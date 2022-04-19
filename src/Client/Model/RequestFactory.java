package Client.Model;

import java.util.ArrayList;

public class RequestFactory {
    private Client client;


    public RequestFactory(Client client){
        this.client = client;
    }

    public void login(User user){
        client.addToBuffer(new Request("login", user));
    }

    public void register(User user){
        client.addToBuffer(new Request("register", user));
    }
}

