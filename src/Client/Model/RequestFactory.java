package Client.Model;

import Shared.*;

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
        client.addToBuffer(new Request(1, user));
    }

    /**This function creates a register-new-user request
     * @param user contains the username, email and password of the user to be registered**/
    public void register(User user){
        client.addToBuffer(new Request(2, user));
    }

    public void createAnnons(Annons annons){
        client.addToBuffer(new Request(1, annons));
    }

    public void searchAnnons(Search search){
        client.addToBuffer(new Request(search));
    }

    public void startChat(Chat chat){
        client.addToBuffer(new Request(true, chat));
    }

    public void openChat(Chat chat){
        client.addToBuffer(new Request(false, chat));
    }

    public void changePassword(String oldPassword, String newPassword){
        client.addToBuffer(new Request(1, oldPassword, newPassword));
    }

}

