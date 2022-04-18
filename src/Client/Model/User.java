package Client.Model;


import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
    @Serial

    private static final long serialVersionUID = -5886308724572898536L;

    private String username;
    private String password;
    private String email;

    public User(){

    }

    public User(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public static void setUser(User user) {
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

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
