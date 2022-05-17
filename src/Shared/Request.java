package Shared;

import java.io.Serial;
import java.io.Serializable;
/**This class represents each type of request**/

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = -8969009813588142777L;

    private String request;
    private String email;

    private User user;
    private Chat chat;
    private Message message;
    private Annons annons;
    private Search search;

    /**
     * This constructor is used to create a request for:
     * login: request to login an existing user
     * register: request to register a new user
     * */
    public Request(Boolean register, User user){
        if(register) {
            this.request = "register";
        }else{
            this.request = "login";
        }
        this.user = user;
    }

    /**
     * This constructor is used to create a request for:
     * createAnnons: request to create an instance of an annons in the database
     * */
    public Request(Annons annons){
        request = "createAnnons";
        this.annons = annons;
    }

    /**
     * This constructor is used to create a request for:
     * updateInfo: request to create an update an instance of a user in the database
     * */
    public Request(User user){
        request = "updateInfo";
        this.user = user;
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
     * openChat:
     * */
    public Request(Chat chat) {
        request = "startChat";
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
