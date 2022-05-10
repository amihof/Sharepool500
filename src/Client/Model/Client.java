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

    public Client(int proxy, String ip, Controller controller) {
        System.out.println("client starta");
        this.controller = controller;
        this.proxy = proxy;
        this.ip = ip;
        try { //a try catch to handle the connection
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
        inputHandlerThread.start(); //starts the  thread
        System.out.println("starta tråd");

    }

    /**This method adds the request from RequestFactory to the buffer in the
     * InputHandler class (the thread class)
     *@param request is the request receive from the request class**/

    public void addToBuffer(Request request){
        inputHandler.addToBuffer(request);
    }

    private class InputHandler implements Runnable{
        private Buffer<Request> inputBuffer;

        //client.getInputHandler.addToBuffer(den request du skapade i requestFactory)

        /**New Buffer to add requests**/
        public InputHandler(){
            inputBuffer = new Buffer<>();
        }

        /**In this method the requests adds to the buffer
         *@param request is the request receive from the Request class
        **/
        public void addToBuffer(Request request){
            inputBuffer.put(request);
        }

        /**In this method exist several switch statements
         to hanndle is kind of request. The requests are
         Strings taken from the request class**/
        @Override
        public synchronized void run() {
            Object o = null;
            while (!Thread.interrupted()) {
                Request request = null;
                String str = null;
                try {
                    request = inputBuffer.get(); //receives the request from the buffer
                    str = request.getRequest();

                    if(str.equals("login")){ //the request type is login
                        oos.writeObject(request); //sends the request
                        oos.flush(); //makes sure the request is written


                        Boolean loggedIn = ois.readBoolean(); //checks if its logged in**/
                        System.out.println(loggedIn);

                        if(loggedIn){
                            user = request.getUser(); //the user information saves
                            controller.loggedInOrNot(loggedIn);
                            //the information is sent to the controller
                            // and the user logs in to the program

                        } else{
                            controller.couldNotLogin();
                            throw new Exception("Could not log in ");

                        }
                    } else if(str.equals("register")){ ////the request type is register
                        oos.writeObject(request); //sends the request
                        oos.flush(); //makes sure the request is written


                        Boolean registered = ois.readBoolean();
                        System.out.println(registered);

                        //checks if the user is registered

                        if(registered){
                            user = request.getUser();//the user information saves
                            // controller.registerNewUser(userName, email, password);/**registers the user with its information**/
                        } else{
                            controller.couldNotRegister();
                            throw new Exception("Could not register ");

                        }

                    }else if(str.equals("createAnnons")){//the request type is creating an annons
                        oos.writeObject(request); //sends the request
                        oos.flush(); //makes sure the request is written

                        Boolean annonsCreated = ois.readBoolean(); //checks if the add iss created
                        if(annonsCreated) {
                            //annons.setAnnons(request.getAnnons());
                            //the information is sent to the controller
                            //and an add is created

                        } else{
                            throw new Exception("Could not create an add ");


                        }
                    }else if(str.equals("search")){

                        oos.writeObject(request);//sends the request
                        oos.flush(); //makes sure the request is written

                        Object tempObject = ois.readObject();
                        ArrayList<Annons> result;

                        if(tempObject != null && Objects.requireNonNull(tempObject).getClass().isAssignableFrom(ArrayList.class)){
                            result = (ArrayList<Annons>) tempObject;
                        }
                        //the information is sent to the controller
                        //and the user can search for an add


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
