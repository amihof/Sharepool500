package Server.Model;


import Delad.Annons;
import Delad.Buffer;
import Delad.Request;
import Delad.User;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Client {
    private static HashMap<Client, User> clientUserHashMap = new HashMap<>();


    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private InputHandler ih;

    private SQLquery sql;
    private InputHandler inputHandler;
    private InputListener inputListener;
    private final Thread inputHandlerThread, inputListenerThread;

    public Client(Socket s) {
        this.socket = s;

        inputHandler = new InputHandler();
        inputListener = new InputListener();


        inputHandlerThread = new Thread(inputHandler);
        inputListenerThread = new Thread(inputListener);

        try{
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            oos.flush();

        } catch (IOException e) {
            inputHandlerThread.interrupt();
            inputListenerThread.interrupt();
            e.printStackTrace();
        }

    }

    private class InputHandler implements Runnable{
        private Buffer<Request> inputBuffer;

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

                    switch (str){
                        case "login":
                            try {
                                oos.writeBoolean(
                                        sql.login(
                                                request.getUser().getEmail(),
                                                request.getUser().getPassword())
                                );
                                oos.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "register":
                            System.out.println("enter case register");
                            try {
                                oos.writeBoolean(
                                        sql.register(
                                                request.getUser().getUsername(),
                                                request.getUser().getEmail(),
                                                request.getUser().getPassword()));
                                oos.flush();
                                System.out.println("query executed and request handled");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "createAnnons":
                            try {
                                oos.writeBoolean(
                                        sql.createAnnons(
                                                request.getAnnons().getProductName(),
                                                request.getAnnons().getProductDescription(),
                                                request.getAnnons().getProductCategory(),
                                                request.getUser().getEmail(),
                                                request.getAnnons().getRenting()
                                        )
                                );
                                oos.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "search":
                            ArrayList<Annons> result = sql.search(
                                    request.getSearch().getText(),
                                    request.getSearch().getCategory(),
                                    request.getSearch().getFromDate(),
                                    request.getSearch().getToDate()
                            );
                            break;
                        default:
                            System.out.println("default case and return false");
                            try {
                                oos.writeBoolean(false);
                                oos.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                    }

                } catch (InterruptedException e) {
                    System.out.println("didnt enter the switch statement. Interrupted thread");
                    e.printStackTrace();
                }

            }
        }
    }

    private class InputListener implements Runnable{

        @Override
        public synchronized void run() {
            Object input = null;
            while (!Thread.interrupted()) {
                try {
                    input = ois.readObject();

                    System.out.println("i read the request");

                    if(input.getClass().isAssignableFrom(Request.class)){
                        inputHandler.addToBuffer((Request) input);
                    } else {
                        System.out.println(input.getClass().toString());
                        throw new ClassNotFoundException("Input from " + socket.getInetAddress() + " does not observe communication protocol");
                    }

                } catch (EOFException e) {
                    inputHandlerThread.interrupt();
                    inputListenerThread.interrupt();
                    e.printStackTrace();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
