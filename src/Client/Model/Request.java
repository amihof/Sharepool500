package Client.Model;

import Server.Model.Annons;
import Server.Model.Chat;
import Server.Model.Loan;
import Server.Model.Message;
import Server.Model.User;

public class Request {
    private static final long serialVersionUID = -8969009813588142777L;

    private String request;
    private String response;

    private Server.Model.User user;
    private Chat chat;
    private Server.Model.Message msg;
    private Server.Model.Annons annons;
    private Server.Model.Loan loan;

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
