package Server.Model;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -5886308724572898536L;

    private String username;
    private ImageIcon image;

    public User(String username, ImageIcon image){
        this.username = username;
        this.image = image;
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

    public ImageIcon getImage() {
        return image;
    }
}
