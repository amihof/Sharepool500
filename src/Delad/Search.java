package Delad;


import Delad.Category;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
/**This class represents each search**/

public class Search implements Serializable {

    @Serial
    private static final long serialVersionUID = -7627573875816995294L;

    private String text = "";
    private Category category = null;


    /**@param text
     * @param category
     **/
    public Search(String text, Category category) {
        this.text = text;
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public Category getCategory() {
        return category;
    }
}
