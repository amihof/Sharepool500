package Client.Model;


import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
    @Serial

    private static final long serialVersionUID = -5886308724572898536L;

    private String username;
    private String password;
    private String email;


    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static void setUser(User user) {
    }

    public int hashCode() {
        return username.hashCode();
    }

    public boolean equals(Object obj) {
        if(obj!=null && obj instanceof Server.Model.User)
            return username.equals(((Server.Model.User)obj).getUsername());
        return false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        return username;
    }

}
