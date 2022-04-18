package Client.Model;

import Client.Controller.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class Client {

    private Controller controller;
    private User user;
    private Annons annons;

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
            controller = new Controller();
            user = new User();
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
                                oos.writeObject(request); /**sends the request**/
                                oos.flush();

                                Boolean loggedIn = ois.readBoolean(); /**sees if its logged in**/
                                //send back result of login to amidala
                                if(loggedIn){
                                    user.setUser(request.getUser()); /**the user information saves**/
                                    controller.loginClicked(); /**usern logs in to the program**/
                                } else{

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        //case for register
                        case "register":
                            String userName = user.getUsername();
                            String email = user.getEmail();
                            String password = user.getPassword();
                            try {
                                oos.writeObject(request);
                                oos.flush();

                                Boolean registered = ois.readBoolean();
                                //send back result of register to amidala
                                if(registered){
                                    user.setUser(request.getUser()); /**the user information saves**/
                                    controller.registerNewUser(userName, email, password);/**registers the user with its information**/
                                } else{

                                }
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
                                if(annonsCreated) {
                                    annons.setAnnons(request.getAnnons());
                                    controller.skapaAnnonsClicked();
                                } else{
                                    
                                }

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
                                controller.searchClicked();
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
