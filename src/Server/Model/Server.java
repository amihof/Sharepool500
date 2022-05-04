package Server.Model;


import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**Server class is the class responsible for:
 * 1. connecting to the database
 * 2. listening for new client
 * 3. creating an client instance to handle the new client*/
public class Server {

    //Connection to the database am3087 in pgserver.mau.se
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
                con = null;
                ex.printStackTrace();
            }
        }

    }

    private ServerSocket ss;
    private int port = 725;

    private ClientConnector connector;
    private Thread clientConnectorThread;


    /***/
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
        if(getCon() == null){

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


    /**static method to get the connection to the database from all aprts of the server
     * @return con is the connection established to the database */
    public static Connection getCon(){
        return con;
    }

}
