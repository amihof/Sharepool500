package Shared;


import java.io.Serial;
import java.io.Serializable;


/**This class is an object class of a search
 * @author Hadi Saghir
 */
public class Search implements Serializable {

    @Serial
    private static final long serialVersionUID = -7627573875816995294L;

    private String text = "";
    private Category category = null;
    private City city = null;


    /**@param text
     * @param category
     * @param city
     **/
    public Search(String text, Category category, City city) {
        this.text = text;
        this.category = category;
        this.city = city;
    }

    public String getText() {
        return text;
    }

    public Category getCategory() {
        return category;
    }

    public City getCity(){
        return city;
    }
}
