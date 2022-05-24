package Shared;

import java.io.Serial;
import java.io.Serializable;
/**This class represents each type of request**/

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = -8969009813588142777L;

    private String request;

    private User user;
    private Chat chat;
    private Message message;
    private Annons annons;
    private Search search;

    /**
     * This constructor is used to create a request for:
     * 1.login: request to login an existing user
     * 2. register: request to register a new user
     * 3. updateEmail: request to update an instance of a user in the database
     * 4. updateUsername: request to update an instance of a user in the database
     * 6  deleteUser: request to delete an instance of a user in the database
     * 7. getChats : request to get all instances of chats linked to specific user
     * */
    public Request(int type, User user){
        if(type == 1) {
            this.request = "login";
        }else if(type == 2){
            this.request = "register";
        }else if (type == 3){
            request = "updateEmail";
        }else if (type == 4){
            request = "updateUsername";
        }else if(type == 5) {
            request = "deleteUser";
        }else if (type == 6){
            request = "getChats";
        }
        this.user = user;
    }

    /**
     * This constructor is used to create a request for:
     * 1. updatePassword: request to update an instance of a user in the database
     * */
    public Request(int type, String oldStr, String newStr){
        if (type == 1){
            request = "updatePassowrd";
            user = new User(oldStr, newStr);
        }
    }

    /**
     * This constructor is used to create a request for:
     * 1. createAnnons: request to create an instance of an annons in the database
     * 2. deleteAnnons: request to remove an instance of annons (changing onging from true to false in databas)
     * */
    public Request(int type, Annons annons){
        if(type == 1) {
            request = "createAnnons";
        }else if(type == 2) {
            request = "deleteAnnons";
        }
        this.annons = annons;
    }

    /**
     * This constructor is used to create a request for:
     * search: request to get a list of result from a specified search criteria
     * */
    public Request(Search search){
        request = "search";
        this.search = search;
    }

    /**
     * This constructor is used to create a request for:
     * starChat: request to instantiate an instance of chat between the publisher and requester
     * openChat: request to get all the messages and other information of a certain chat
     * */
    public Request(Boolean startChat, Chat chat) {
        if(startChat){
            request = "startChat";
        } else{
            request = "openChat";
        }
        this.chat = chat;
    }

    /**
     * This constructor is used to create a request for:
     * sendMessage: send a message (sent from the sender to the server)
     * receiveMessage: receive a message (sent from the server to the recipient client)
     * */
    public Request(Boolean sending, Message message) {
        if(sending) {
            request = "sendMessage";
        } else{
            request = "receiveMessage";
        }
        this.message = message;
    }



    public String getRequest() {
        return request;
    }

    public User getUser() {
        return user;
    }

    public Message getMsg() {
        return message;
    }

    public Annons getAnnons() {
        return annons;
    }

    public Chat getChat() {
        return chat;
    }

    public Search getSearch() {
        return search;
    }
}
