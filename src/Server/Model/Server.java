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


    /**The constructor creates a server port that can accept sockets from new clients */
    public Server() {
        try {
            ss = new ServerSocket(port);
            setUp();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    /**sets ut the client connector and interrupts it if the connection to the database fails. terminating the server*/
    public void setUp() {

        if(getCon() == null){
            clientConnectorThread.interrupt();
        }

        if (connector == null) {
            connector = new ClientConnector();
            clientConnectorThread= new Thread(connector);
            clientConnectorThread.start();
        }
    }

    /**Client connector class is a runnable class intended to be run by a thread, listening for new clients*/
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
