package Client.Model;

import Server.Model.Client;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private ServerSocket ss;
    private int port = 2343;

    private Client.Model.Server.ClientConnector connector;

    public Server() {
        try {
            ss = new ServerSocket(port);
            start();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public synchronized void start() {
        if (connector == null) {
            connector = new Client.Model.Server.ClientConnector();
            Thread t = new Thread(connector);
            t.start();
        }
    }

    private class ClientConnector implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    new Client(ss.accept());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Server accepting no new clients");
        }

    }


}
