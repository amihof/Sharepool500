package Client.Model;

import Delad.Annons;
import Delad.Request;
import Delad.Search;
import Delad.User;

/**@Author Evan Ebdo**/

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

    /**This function creates a log-in request
     * @param user contains the email and password of the user attempting to log in**/
    public void login(User user){
        client.addToBuffer(new Request(false, user));
    }

    /**This function creates a register-new-user request
     * @param user contains the username, email and password of the user to be registered**/
    public void register(User user){
        client.addToBuffer(new Request(true, user));
    }

    /**@param annons is an object of Annons class
     * A anons is created here and added to the buffer in client
     * then a new anons - request is created **/
    public void createAnnons(Annons annons){client.addToBuffer(new Request(annons));}

    /**@param search is an objekt of Searh class
     * A search is created here and added to the buffer in client
     *  then a new search - request is created **/
    public void searchAnnons(Search search){
        client.addToBuffer(new Request(search));
    }
}

