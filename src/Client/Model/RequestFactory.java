package Client.Model;

import Delad.Annons;
import Delad.Request;
import Delad.User;

import java.util.ArrayList;

/**
 * The request factory is responsible for constructing request to be sent to the server.
 * The class mediated the connection from the controller to client class*/
public class RequestFactory {
    private Client client;

    /**@constructor
     * @param client represents the current client **/
    public RequestFactory(Client client){
        this.client = client;
    }

    /**This function creates new request is created
     * and added to the inputBuffer-buffer in Client-class
     * @param user represents each user**/
    public void login(User user){
        client.addToBuffer(new Request(false, user));
    }

    /**When the user wants to register a new request is created
     * and added to the inputBuffer-buffer in Client-class
     * @param user represents each user**/
    public void register(User user){
        client.addToBuffer(new Request(true, user));
    }

    public  void createAnnons(Annons annons){client.addToBuffer(new Request(annons));}
}

