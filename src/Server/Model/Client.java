package Server.Model;


import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class Client {
    private static HashMap<User, Client> chm = new HashMap<>();


    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private InputHandler ih;

    private Thread t1;
    private Thread t2;

    private class InputHandler implements Runnable{
        private Server.Model.Buffer<Message> inputBuffer;

        public InputHandler(){
            inputBuffer = new Server.Model.Buffer<>();
        }

        public void addToBuffer(Message msg){
            inputBuffer.put(msg);
        }


        @Override
        public synchronized void run() {
            Object o = null;
            while (!Thread.interrupted()) {
                Message temp = null;
                try {
                    inputBuffer.get();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public Client(Socket s) {
        this.socket = s;

    }
}
