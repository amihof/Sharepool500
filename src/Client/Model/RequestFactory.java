package Client.Model;

import Shared.*;
/**@Author Evan Ebdo**/

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

    /**this method is for a request of type changePassword,
     * a new request of changePassword is added to the buffer**/
    public void changePassword(String oldPassword, String newPassword){
        client.addToBuffer(new Request(1, oldPassword, newPassword));
    }
    /**this method is for a request of type changeUsername,
     * a new request of changeUsername is added to the buffer**/
    public void changeUsername(String oldUsername, String newUsername){
        client.addToBuffer(new Request(4, oldUsername, newUsername));
    }
    /**this method is for a request of type changeEmail,
     * a new request of changeEmail is added to the buffer**/
    public void changeEmail(String oldEmail, String newEmail){
        client.addToBuffer(new Request(3, oldEmail, newEmail));
    }
    /*public void deleteAnnons(){
        client
    }*/

   /* public void changeEmail(String oldEmail, String newEmail){
        client.addToBuffer(new Request(2, oldEmail, newEmail));
    }

    public void changeUsername(String email, String newUsername){
        client.addToBuffer(new Request(3, email, newUsername));
    }*/

}

