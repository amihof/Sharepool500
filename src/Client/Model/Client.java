package Client.Model;

import Client.Controller.Controller;
import Delad.Annons;
import Delad.Buffer;
import Delad.Request;
import Delad.User;

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
        System.out.println("client starta");
        this.proxy = proxy;
        this.ip = ip;
        try {
            socket  = new Socket(ip, proxy);
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("try catch färdig");
        inputHandler = new InputHandler();
        System.out.println("ny inputhandler");

        inputHandlerThread = new Thread(inputHandler);
        inputHandlerThread.start();
        System.out.println("starta tråd");

    }

    public void addToBuffer(Request request){
        inputHandler.addToBuffer(request);
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

                    if(str.equals("login")){
                        oos.writeObject(request); /**sends the request**/
                        oos.flush();

                        Boolean loggedIn = ois.readBoolean(); /**sees if its logged in**/
                        //send back result of login to amidala
                        System.out.println(loggedIn);
                        if(loggedIn){
                            user = request.getUser(); /**the user information saves**/
                            controller.loggedInOrNot(loggedIn); /**usern logs in to the program**/
                        } else{

                        }
                    } else if(str.equals("register")){
                        oos.writeObject(request);
                        oos.flush();

                        Boolean registered = ois.readBoolean();
                        System.out.println(registered);
                        //send back result of register to amidala
                        if(registered){
                            user = request.getUser();/**the user information saves**/
                            // controller.registerNewUser(userName, email, password);/**registers the user with its information**/
                        } else{

                        }

                    }else if(str.equals("createAnnons")){
                        oos.writeObject(request);
                        oos.flush();

                        Boolean annonsCreated = ois.readBoolean();

                        //send back result of creating the annons to amidala
                        if(annonsCreated) {
                            //annons.setAnnons(request.getAnnons());
                            controller.skapaAnnonsClicked();
                        } else{

                        }
                    }else if(str.equals("search")){

                        oos.writeObject(request);
                        oos.flush();

                        Object tempObject = ois.readObject();
                        ArrayList<Annons> result;

                        if(tempObject != null && Objects.requireNonNull(tempObject).getClass().isAssignableFrom(ArrayList.class)){
                            result = (ArrayList<Annons>) tempObject;

                        }
                        //send back result of search to amidala
                        controller.searchClicked();
                    } else{
                        throw new Exception("Could not read request type");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
