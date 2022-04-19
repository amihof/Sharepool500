package Delad;

import java.io.Serial;
import java.io.Serializable;
import java.util.Stack;

public class Chat implements Serializable {
    @Serial
    private static final long serialVersionUID = -3_930_131_856_060_689_940L;

    private int id;
    private Stack<Message> messages;

    private String annonsId;
    private String requester_email;

    public Chat(String annonsId, String requester_email){

    }
}
