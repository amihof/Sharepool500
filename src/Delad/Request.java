package Delad;

import java.io.Serial;
import java.io.Serializable;
/**This class represents each type of request**/

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = -8969009813588142777L;

    private String request;

    private User user;
    private Chat chat;
    private Message msg;
    private Annons annons;
    private Loan loan;
    private Search search;

    /**
     * This constructor is used to create a request for:
     * login
     * register
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
