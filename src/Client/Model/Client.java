package Client.Model;

import Client.Controller.Controller;

import Shared.Annons;
import Shared.Buffer;
import Shared.Request;
import Shared.User;
import Shared.Chat;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

/**@Author Evan Ebdo**/

public class Client {

    private Controller controller;
    private User user;
    private Annons annons;

    private Socket socket;
    private int port;
    private String ip;

    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private InputHandler inputHandler;
    private final Thread inputHandlerThread;

    /**Connection between client and server**/
    /**@param port is the port for the connection
     * @param ip is the IP address
     * @param controller a Controller reference **/

    public Client(int port, String ip, Controller controller) {
        System.out.println("client starta");
        this.controller = controller;
        this.port = port;
        this.ip = ip;
        try { //a try catch to handle the connection
            socket  = new Socket(ip, port);
            ois = new ObjectInputStream(socket.getInputStream()); //connected
            oos = new ObjectOutputStream(socket.getOutputStream());//connected
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

    /**in this class we implement Runnable**/
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

        public void removeFromBuffer(Request request){
            //inputBuffer.
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

                    oos.writeObject(request); //sends the request
                    oos.flush(); //makes sure the request is written
                    if(str.equals("login")){ //the request type is login

                        String username = ois.readUTF(); //checks if its logged in**/

                        if(!username.equals("")){
                            user = request.getUser(); //the user information saves
                            controller.loggedInOrNot(username);
                            controller.loggedInInfo(user);

                            //the information is sent to the controller
                            // and the user logs in to the program

                        } else{
                            controller.loggedInOrNot(username);
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

                    }else if(str.equals("updateEmail")){ ////the request type is register
                        oos.writeObject(request); //sends the request
                        oos.flush(); //makes sure the request is written


                        Boolean updated = ois.readBoolean();
                        System.out.println(updated);
                        //checks if the user is registered

                        if(updated){

                        } else{
                            controller.couldNotRegister();
                            throw new Exception("Could not register ");

                        }

                    } else if(str.equals("showAnnons")) {
                        oos.writeObject(request);//sends the request
                        oos.flush(); //makes sure the request is written

                        Object tempObject = ois.readObject();
                        ArrayList<Annons> result;

                        if(tempObject != null && Objects.requireNonNull(tempObject).getClass().isAssignableFrom(ArrayList.class)) {
                            result = (ArrayList<Annons>) tempObject;

                            System.out.println("Client - result arrayen user annonser");
                            // System.out.println(result.get(0).getProductName()+"?!");
                            System.out.println(result);

                            controller.seeUserAnnonser(result);
                        }


                    }
                    else if(str.equals("updateUsername")){ ////the request type is register
                        oos.writeObject(request); //sends the request
                        oos.flush(); //makes sure the request is written


                        Boolean updated = ois.readBoolean();
                        System.out.println(updated);
                        //checks if the user is registered

                        if(updated){

                        } else{
                            controller.couldNotRegister();
                            throw new Exception("Could not register ");

                        }

                    }else if(str.equals("updatePassword")){ ////the request type is register
                        oos.writeObject(request); //sends the request
                        oos.flush(); //makes sure the request is written


                        Boolean updated = ois.readBoolean();
                        System.out.println(updated);
                        //checks if the user is registered

                        if(updated){


                        } else{
                            controller.couldNotRegister();
                            throw new Exception("Could not register ");

                        }

                    }else if(str.equals("createAnnons")){//the request type is creating an annons
                        oos.writeObject(request); //sends the request
                        oos.flush(); //makes sure the request is written

                        Boolean annonsCreated = ois.readBoolean(); //checks if the add iss created
                        if(annonsCreated) {
                            controller.annonsMade();
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

                            System.out.println("Client - result arrayen");
                           // System.out.println(result.get(0).getProductName()+"?!");
                            System.out.println(result);

                            controller.seeSearchedAnnons(result);
                        } else{

                            throw new Exception("Could not search ");

                        }
                        //the information is sent to the controller
                        //and the user can search for an add

                        oos.writeObject(request); //sends the request
                        oos.flush(); //makes sure the request is written
                    } else if(str.equals("getUsername")){
                        oos.writeObject(request); //sends the request
                        oos.flush(); //makes sure the request is written

                        Boolean requestSent = ois.readBoolean(); //checks if the add is created
                        if(requestSent) {
                            controller.annonsMade();


                        } else{
                            throw new Exception("Could not get username ");


                        }
                        oos.writeObject(request);//sends the request
                        oos.flush(); //makes sure the request is written
                    } else if(str.equals("startChat")){


                        Object tempObject = ois.readObject();
                        ArrayList<Chat> result;

                        if(tempObject != null && Objects.requireNonNull(tempObject).getClass().isAssignableFrom(ArrayList.class)) {
                            result = (ArrayList<Chat>) tempObject;

                            System.out.println("Client - result arrayen chatter");
                            System.out.println(result);

                            controller.seeEveryChat(result);

                        } else{
                        throw new Exception("Could not start chat ");

                    }

                    }else{
                        throw new Exception("Could not read request type");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
