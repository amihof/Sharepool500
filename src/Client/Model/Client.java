package Client.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class Client {


    private Socket socket;
    private int proxy;
    private String ip;

    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private InputHandler inputHandler;
    private final Thread inputHandlerThread;

    public Client(int proxy, String ip) {
        this.proxy = proxy;
        this.ip = ip;
        try {
            socket  = new Socket(ip, proxy);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputHandler = new InputHandler();

        inputHandlerThread = new Thread(inputHandler);

    }


    private class InputHandler implements Runnable{
        private Buffer<Request> inputBuffer;

        //client.getInputHandler.addToBuffer(den request du skapade i requestFactory)
        public InputHandler(){
            inputBuffer = new Buffer<>();
        }

        public void addToBuffer(Request request){
            inputBuffer.put(request);
        }


        @Override
        public synchronized void run() {
            Object o = null;
            while (!Thread.interrupted()) {
                Request request = null;
                String str = null;
                try {
                    request = inputBuffer.get();

                    str = request.getRequest();
                    /**
                     * In this switch statement which takes the request (string from the request class),
                     * The string for the different function is found in the java file
                     * you send a Request object
                     * Then, you wait until i respond to you, according to the agreed protocol
                     * final, send the information back ami so she can present them to the user
                     * rinse, repeat
                     * */
                    switch (str){
                        //case for login
                        case "login" :
                            try {
                                oos.writeObject(request);
                                oos.flush();

                                Boolean loggedIn = ois.readBoolean();
                                //send back result of login to amidala
                                //if(loggedIn){
                                // client.setUser(request.getUser());
                                // controller.loggedIn()
                                // } else{
                                // 
                                // }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        //case for register
                        case "register":
                            try {
                                oos.writeObject(request);
                                oos.flush();

                                Boolean registered = ois.readBoolean();
                                //send back result of register to amidala
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "createAnnons":
                            try {
                                oos.writeObject(request);
                                oos.flush();

                                Boolean annonsCreated = ois.readBoolean();
                                //send back result of creating the annons to amidala
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "search":
                            try {
                                oos.writeObject(request);
                                oos.flush();

                                Object tempObject = ois.readObject();
                                ArrayList<Annons> result;

                                if(tempObject != null && Objects.requireNonNull(tempObject).getClass().isAssignableFrom(ArrayList.class)){
                                    result = (ArrayList<Annons>) tempObject;

                                }
                                //send back result of search to amidala
                            } catch (IOException | ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            break;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
