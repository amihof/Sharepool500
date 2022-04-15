package Server.Model;


import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {

    private static Connection con; {
        String url = "jdbc:postgresql://pgserver.mau.se:5432/am3087";
        String conID = "am3087";
        String  conPWD = "dtw2s5jg";

        try{
            con = DriverManager.getConnection(url, conID, conPWD);
            System.out.println("Connection Established");
        } catch (SQLException e) {
            try {
                throw new SQLException(e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static Connection getCon(){
        return con;
    }

    private ServerSocket ss;
    private int port = 2343;

    private ClientConnector connector;

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
            connector = new ClientConnector();
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
