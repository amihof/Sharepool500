package Shared;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedList;
/**This class represents each message**/

public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 8582693598132329383L;

    private int id;
    private final String text;
    private final ImageIcon icon;

    private Timestamp uploaded;
    private Timestamp downloaded;

    private final User sender;

    /**
     * Message constructor for
     * message objects to be sent to all online users. */
    public Message(String text, ImageIcon icon,User sender){
        this.text = text;
        this.icon = icon;
        this.sender = sender;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Message){
            if( ((Message) obj).getId() == this.id ){
                return true;
            }
        }
        return false;
    }
    public String getText() {
        return text;
    }
    public ImageIcon getIcon() {
        return icon;
    }
    public Timestamp getUploaded() {
        return uploaded;
    }
    public Timestamp getDownloaded() {
        return downloaded;
    }
    public User getSender(){return sender;}
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public void setUploaded(Timestamp uploaded) {
        this.uploaded = uploaded;
    }
    public void setDownloaded(Timestamp downloaded) {
        this.downloaded = downloaded;
    }
}
