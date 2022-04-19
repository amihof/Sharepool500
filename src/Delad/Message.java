package Delad;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedList;

public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 8582693598132329383L;

    private static int nextID = 0;
    private int currID;

    private final String text;
    private final ImageIcon icon;

    private Timestamp uploaded;
    private Timestamp downloaded;

    private final User sender;

    public Message(){
        currID = nextID;
        nextID++;
        this.text = null;
        this.icon = null;
        sender = null;
    }

    /**
     * Message constructor for
     * message objects to be sent to all online users. */
    public Message(String text, User sender){
        currID = nextID;
        nextID++;
        this.text = text;
        this.icon = null;
        this.sender = sender;

    }

    /**
     * Message constructor for
     * message objects to be sent to specific recipients */
    public Message(String text, ImageIcon icon, LinkedList<User> recipients, User sender) {
        currID = nextID;
        nextID++;
        this.text = text;
        this.icon = icon;
        this.sender = sender;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Message){
            if( ((Message) obj).getCurrID() == this.currID ){
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
    public int getCurrID(){return currID;}
    public void setCurrID(){currID = nextID; nextID++;}
    public void setUploaded(Timestamp uploaded) {
        this.uploaded = uploaded;
    }
    public void setDownloaded(Timestamp downloaded) {
        this.downloaded = downloaded;
    }
}
