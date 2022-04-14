package Server.Model;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -5886308724572898536L;

    private String username;
    private String password;
    private String email;

    public User(String username){
        this.username = username;
    }

    public int hashCode() {
        return username.hashCode();
    }

    public boolean equals(Object obj) {
        if(obj!=null && obj instanceof User)
            return username.equals(((User)obj).getUsername());
        return false;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString(){
        return username;
    }
}
