package Server.Model;

import Client.Model.Annons;
import Client.Model.Chat;
import Client.Model.Loan;
import Client.Model.Message;
import Client.Model.Search;
import Client.Model.User;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = -8969009813588142777L;

    private static String request = "";

    private User user = null;
    private Chat chat = null;
    private Message msg = null;
    private Annons annons = null;
    private Loan loan = null;
    private Search search = null;

    /**
     * This constructor is used to create a request for:
     * login
     * register
     * */
    public Request(String requestType, User user){
        if(requestType == "login") {
            request = "login";
            this.user = user;

        }else if (requestType == "register"){
            request = "register";
            this.user = user;
        }
    }

    /**
     * This constructor is used to create a request for:
     * createAnnons
     *
     * */
    public Request(Annons annons){
        request = "createAnnons";
        this.annons = annons;
    }

    /**
     * This constructor is used to create a request for:
     * search
     *
     * */
    public Request(Search search){
        request = "search";
        this.search = search;
    }

    public String getRequest() {
        return request;
    }

    public User getUser() {
        return user;
    }

    public Message getMsg() {
        return msg;
    }

    public Annons getAnnons() {
        return annons;
    }

    public Loan getLoan() {
        return loan;
    }

    public Chat getChat() {
        return chat;
    }

    public Search getSearch() {
        return search;
    }
}
