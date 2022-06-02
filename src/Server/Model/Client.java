package Server.Model;


import Shared.Buffer;
import Shared.Message;
import Shared.Request;
import Shared.User;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;


/**
 * Server.Model.Client is an object representing a client connected to the server
 * The class is responsible for listing to and handling request sent by the client
 * It has two private inner classes: inputHandler and inputLister
 * When the client disconnects the class will terminate automatically
 * @author Hadi Saghir */
public class Client {
    //clientUserHashMap identifies the different clients as users when logged in
    private static HashMap<Client, User> clientUserHashMap = new HashMap<>();
    private static HashMap<User, Integer> notifications = new HashMap<>(); //not implemented fully


    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private SQLquery sql;
    private InputHandler inputHandler;
    private InputListener inputListener;
    private final Thread inputHandlerThread, inputListenerThread;

    /**
     * When a client connects to the server a socket is used to communicate via TCP
     * The constructor is responsible for: setting up the communication streams between the client and the server
     * @param socket is the communication path, passed by the server upon acceptance of connection*/
    public Client(Socket socket) {
        this.socket = socket;
        Boolean streamWorking; //signaling tool to terminate threads in case of failed attempt to establish streams
        try {
            //open streams
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            oos.flush();
            streamWorking = true;

        } catch (IOException e) {
            streamWorking = false;
            e.printStackTrace();
        }

        //instantiate the runnable objects
        inputHandler = new InputHandler();
        inputListener = new InputListener();
        sql = new SQLquery();

        //instantiate threads run the runnable objects
        inputHandlerThread = new Thread(inputHandler);
        inputListenerThread = new Thread(inputListener);

        //start threads
        inputHandlerThread.start();
        inputListenerThread.start();

        //interrupt thread if client disconnects and the streams stop working
        if (!streamWorking) {
            inputHandlerThread.interrupt();
            inputListenerThread.interrupt();
        }
    }

    /**
     * InputHandler is responsible for managing the incoming request and sending back a response
     * */
    private class InputHandler implements Runnable {
        private Buffer<Request> inputBuffer;

        /**
         * InputHandler Constructor instantiate a request buffer where requests will be stored
         * The buffer will synchronize the inputHandler and inputListener
         * */
        public InputHandler() {
            inputBuffer = new Buffer<>();
        }

        /**
         * addToBuffer method is a caller method that store request sent by the inputListener
         * @param request the request send by the client to be handled by the server
         * */
        public void addToBuffer(Request request) {
            inputBuffer.put(request);
        }


        /**
         * run method is run by inputHandlerThread (multi-threading)
         * The method gets a Request object from the buffer and using the identifier requestType : String
         * The respective method is called from the sql : SQLQuery
         * The response is sent back to the client using the TCP communication (ois and oos streams)
         * */
        @Override
        public synchronized void run() {
            while (!Thread.interrupted()) {
                Request request = null;
                String requestType = null;
                try {
                    // get request : Request from the buffer
                    request = inputBuffer.get();

                    //get the type of request
                    requestType = request.getRequest();

                    //The respective method is called from sql : SQLQuery using the identifier requestType : String
                    if (requestType.equals("login")) {
                        oos.writeUTF(
                                sql.login(
                                        request.getUser().getEmail(),
                                        request.getUser().getPassword())
                        );
                        oos.flush();
                        clientUserHashMap.put(Client.this, new User(request.getUser().getEmail(),
                                request.getUser().getPassword()));
                    } else if (requestType.equals("register")) {
                        oos.writeBoolean(sql.register(
                                request.getUser().getUsername(),
                                request.getUser().getEmail(),
                                request.getUser().getPassword()
                                ));
                        oos.flush();
                        notifications.put(new User(request.getUser().getUsername(),
                                request.getUser().getEmail(),
                                request.getUser().getPassword()),
                                0);
                    } else if (requestType.equals("createAnnons")) {
                        oos.writeBoolean(
                                sql.createAnnons(
                                        request.getAnnons().getProductName(),
                                        request.getAnnons().getProductDescription(),
                                        request.getAnnons().getProductCategory(),
                                        request.getAnnons().getPublisher().getEmail(),
                                        request.getAnnons().getRenting()
                                )
                        );
                        oos.flush();
                    } else if (requestType.equals("updateEmail")) {
                        oos.writeBoolean(sql.updateEmail(
                                clientUserHashMap.get(Client.this).getEmail(),
                                request.getUser().getEmail()
                        ));
                    }else if (requestType.equals("updateUsername")) {
                        oos.writeBoolean(sql.updateUsername(
                                clientUserHashMap.get(Client.this).getEmail(),
                                request.getUser().getUsername()
                        ));
                    }else if (requestType.equals("updatePassword")) {
                        oos.writeBoolean(sql.updatePassword(
                                clientUserHashMap.get(Client.this).getEmail(),
                                request.getUser().getPassword(), //the new password
                                request.getUser().getEmail() //the old password for confirmation
                        ));
                    }else if (requestType.equals("deleteUser")) {
                        oos.writeBoolean(sql.deleteUser(
                                clientUserHashMap.get(Client.this).getEmail(),
                                clientUserHashMap.get(Client.this).getPassword()
                        ));
                    } else if (requestType.equals("search")) {
                        oos.writeObject(sql.search(
                                request.getSearch().getText(),
                                request.getSearch().getCategory()
                        ));
                        System.out.println("search worked");

                    }else if (requestType.equals("showAnnons")) {
                        oos.writeObject(sql.showAnnons(
                                request.getUser()
                        ));
                    }
                    else if (requestType.equals("createChat")) {
                        oos.writeObject(sql.createChat(
                                request.getChat()
                        ));


                    }else if (requestType.equals("sendMessage")) {
                        //oos.writeObject(sql.createMessage());


                    } else if (requestType.equals("Rate")) {
                        //oos.writeObject(sql.createMessage());


                    }else {
                        System.out.println("default case and return false");
                        oos.writeBoolean(false);
                        oos.flush();
                    }

                } catch (IOException | InterruptedException e) {
                    System.out.println("Didn't enter the switch statement. Interrupted thread");
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * InputHandler is responsible for listening for incoming request from a specific client
     * adding them to the a buffer to be read by the inputHandler of said client*/
    private class InputListener implements Runnable {

        /**
         * run method is run by inputListenerThread (multi-threading)
         * The method reads a Request object from the connected client
         * The request is then added to the buffer
         * The inputListener is responsible for manging the TCP-communication and
         * in the case of disconnection, the inputListener is responsible for
         * signaling the termination of the inputListener and inputHandler
         * */
        @Override
        public synchronized void run() {
            Object input = null;
            while (!Thread.interrupted()) {
                try {

                    //The thread is blocked until an object is available to be read
                    input = ois.readObject();

                    //check correct format
                    if (input.getClass().isAssignableFrom(Request.class)) {
                        inputHandler.addToBuffer((Request) input);
                    } else {
                        inputHandlerThread.interrupt();
                        inputListenerThread.interrupt();
                        throw new ClassNotFoundException("Input from " + socket.getInetAddress() + " does not" +
                                " observe communication protocol and thus disconnected");
                    }

                } catch (EOFException e) {
                    inputHandlerThread.interrupt();
                    inputListenerThread.interrupt();
                    System.out.println("Client "  + socket.getInetAddress() + " has disconnected");
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
