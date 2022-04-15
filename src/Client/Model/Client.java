package Client.Model;

import Server.Model.Request;
import Server.Model.User;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class Client {
    private static HashMap<Client, User> clientUserHashMap = new HashMap<>();

    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Client.InputHandler ih;

    private Client.InputHandler inputHandler;
    private Client.InputListener inputListener;
    private final Thread inputHandlerThread, inputListenerThread;

    public Client(Socket s) {
        this.socket = s;
        inputHandler = new Client.InputHandler();
        inputListener = new Client.InputListener();

        inputHandlerThread = new Thread(inputHandler);
        inputListenerThread = new Thread(inputListener);

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

                    /*switch (str){
                        case "":
                            break;
                        case "":
                            break;
                        case "":
                            break;
                        case "":
                            break;
                        case "":
                            break;
                        case "":
                            break;
                        case "":
                            break;
                    }*/

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private class InputListener implements Runnable{

        @Override
        public synchronized void run() {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                inputHandlerThread.interrupt();
                inputListenerThread.interrupt();
                e.printStackTrace();
            }

            Object input = null;
            while (!Thread.interrupted()) {
                try {
                    input = ois.readObject();

                    if(input.getClass().isAssignableFrom(Request.class)){
                        inputHandler.addToBuffer((Request) input);
                    } else {
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
