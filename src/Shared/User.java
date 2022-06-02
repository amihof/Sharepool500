package Shared;

import java.io.Serial;
import java.io.Serializable;
/**This class represents each user**/

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -5886308724572898536L;

    private String username;
    private String password;
    private String email;

    
    public User(){

    }


    /**@param email
     * @param password
     **/
    public User(String email,String password){
        this.email=email;
        this.password=password;
    }


    /**@param username
     * @param email
     * @param password
     **/
    public User(String username, String email, String password){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int hashCode() {
        return username.hashCode();
    }

    /**@param obj
     * @return username
     **/
    public boolean equals(Object obj) {
        if(obj!=null && obj instanceof User)
            return username.equals(((User)obj).getUsername());
        return false;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
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
