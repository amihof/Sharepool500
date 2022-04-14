package Server.Model;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = -8969009813588142777L;

    private String request;
    private String response;

    private User user;
    private Chat chat;
    private Message msg;
    private Annons annons;
    private Loan loan;

    public Request(){

    }

    public void setResponse(){

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
