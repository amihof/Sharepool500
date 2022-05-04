package Client.Model;

import Delad.Annons;
import Delad.Request;
import Delad.User;

import java.util.ArrayList;

public class RequestFactory {
    private Client client;

    /**@constructor
     * @param client represents each client **/
    public RequestFactory(Client client){
        this.client = client;
    }

    /**When the user wants to log in a new request is created
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

