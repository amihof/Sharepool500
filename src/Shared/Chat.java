package Shared;

import java.io.Serial;
import java.io.Serializable;
import java.util.Stack;

/**This class is a object class of a class
 * @author Hadi Saghir
 */

public class Chat implements Serializable {
    @Serial
    private static final long serialVersionUID = -3_930_131_856_060_689_940L;

    private int id;
    private Stack<Message> messages;

    private int annonsId;
    private String requester_email;
    private String userEmail;

    /**@param annonsId the id
     * @param requester_email the email of the requester**/
    public Chat(Integer annonsId, String requester_email, String userEmail){
        this.annonsId=annonsId;
        this.requester_email=requester_email;
        this.userEmail = userEmail;
    }

    public int getAnnonsId() {
        return annonsId;
    }

    public String getRequester_email() {
        return requester_email;
    }

    public String getUserEmail(){
        return userEmail;
    }
}
