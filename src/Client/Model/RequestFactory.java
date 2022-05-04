package Client.Model;

import Delad.Annons;
import Delad.Request;
import Delad.User;

import java.util.ArrayList;

public class RequestFactory {
    private Client client;


    public RequestFactory(Client client){
        this.client = client;
    }

    public void login(User user){
        client.addToBuffer(new Request(false, user));
    }

    public void register(User user){
        client.addToBuffer(new Request(true, user));
    }

    public  void createAnnons(Annons annons){client.addToBuffer(new Request(annons));}
}

