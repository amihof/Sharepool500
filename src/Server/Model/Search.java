package Server.Model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class Search implements Serializable {

    @Serial
    private static final long serialVersionUID = -7627573875816995294L;

    private String text = "";
    private Date toDate = null;
    private Date fromDate = null;
    private Enum<Category> category = null;

    public Search(String text, Date toDate, Date fromDate, Enum<Category> category) {
        this.text = text;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public Date getToDate() {
        return toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Enum<Category> getCategory() {
        return category;
    }
}
