package Client.Model;

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

    /**
     * This constructor is used to create a request for:
     * login
     * register
     * */
    public Request(String requestType, User user){
        if(requestType == "login") {
            request = "ibsfefibse";
            this.user = user;

        }else if (requestType == "register"){
            request = "isfhbefs";
            this.user = user;
        }
    }

    /**
     * This constructor is used to create a skapa annons request*/
    public Request(Annons annons){
        request = "habonaufneadai";
        this.annons = annons;
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
}
