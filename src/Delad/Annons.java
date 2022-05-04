package Delad;

import java.io.Serial;
import java.io.Serializable;
/**This class represents each add which is created**/
public class Annons implements Serializable {
    @Serial
    private static final long serialVersionUID = 5403016831143700756L;

    private User publisher;
    private String productName;
    private String productDescription;
    private Category productCategory;
    private boolean renting;

    /**@constructor to create a new add to upload
     * @param productName is the products name
     * @param productDescription exist to write
     * something about the add if the user wishes to
     * @param productCategory is the category
     * @param publisher is the user who has uploaded the add
     * @param renting is a boolean which returns the true
     * or false depending on  if it is renting or not
     * **/
    public Annons(String productName, String productDescription, Category productCategory, User publisher, Boolean renting) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.publisher = publisher;
        this.renting  = renting;
    }

    /**@return productName**/
    public String getProductName() {
        return productName;
    }

    /**@return productDescription**/
    public String getProductDescription() {
        return productDescription;
    }

    /**@return productCategory**/
    public Category getProductCategory() {
        return productCategory;
    }

    /**@return publisher**/
    public User getPublisher() {
        return publisher;
    }

    /**@return renting**/
    public Boolean getRenting(){return renting;}
}
