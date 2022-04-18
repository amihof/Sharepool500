package Client.Model;

import java.util.ArrayList;

public class RequestFactory {
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
    public RequestFactory(String requestType, User user, boolean loggedIn, boolean registered){
        if(requestType == "login") {
            request = "login";
            this.user = user;
            loggedIn = false;

        }else if (requestType == "register"){
            request = "register";
            this.user = user;
            registered = false;
        }
    }
    //en arraylista för att söka behövs i reqeustfacoty, beronde på vad hadi ska skicka till mig
    //boolena om det är login eller registratiin om att det lyckades, eller annons

    /**
     * This constructor is used to create a skapa annons request*/
    public RequestFactory(Annons annons, User user){
        request = "annons";
        this.annons = annons;
        this.user = user;
    }
    /**This constructor is used to search for objects request**/
    public RequestFactory(Search search){
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
}

