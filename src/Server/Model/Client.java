package Server.Model;


import Delad.Annons;
import Delad.Buffer;
import Delad.Request;
import Delad.User;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import static java.nio.charset.StandardCharsets.*;

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
        Boolean streamWorking;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            oos.flush();
            streamWorking = true;

        } catch (IOException e) {
            streamWorking = false;
            e.printStackTrace();
        }

        inputHandler = new InputHandler();
        inputListener = new InputListener();
        sql = new SQLquery();


        inputHandlerThread = new Thread(inputHandler);
        inputListenerThread = new Thread(inputListener);

        inputHandlerThread.start();
        inputListenerThread.start();


        if (!streamWorking) {
            inputHandlerThread.interrupt();
            inputListenerThread.interrupt();
        }
    }

    private class InputHandler implements Runnable {
        private Buffer<Request> inputBuffer;

        public InputHandler() {
            inputBuffer = new Buffer<>();
        }

        public void addToBuffer(Request request) {
            inputBuffer.put(request);
        }


        @Override
        public synchronized void run() {
            while (!Thread.interrupted()) {
                Request request = null;
                String str = null;
                try {
                    request = inputBuffer.get();

                    str = request.getRequest();
                    System.out.println(str);

                    if (str.equals("login")) {
                        System.out.println("login request is going to be handled");
                        oos.writeBoolean(
                                sql.login(
                                        request.getUser().getEmail(),
                                        request.getUser().getPassword())
                        );
                        oos.flush();
                        System.out.println("query executed and request handled");
                    } else if (str.equals("register")) {
                        System.out.println("register request is going to be handled");
                        oos.writeBoolean(
                                sql.register(
                                        request.getUser().getUsername(),
                                        request.getUser().getEmail(),
                                        request.getUser().getPassword()));
                        oos.flush();
                        System.out.println("query executed and request handled");

                    } else if (str.equals("createAnnons")) {
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
                    } else if (str.equals("search")) {
                        ArrayList<Annons> result = sql.search(
                                request.getSearch().getText(),
                                request.getSearch().getCategory(),
                                request.getSearch().getFromDate(),
                                request.getSearch().getToDate()
                        );
                    } else {
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

    private class InputListener implements Runnable {

        @Override
        public synchronized void run() {
            Object input = null;
            while (!Thread.interrupted()) {
                try {
                    System.out.println("waiting to read");

                    input = ois.readObject();

                    System.out.println("i read the request");

                    if (input.getClass().isAssignableFrom(Request.class)) {
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
