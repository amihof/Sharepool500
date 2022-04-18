package Client.Model;

import java.io.Serial;
import java.io.Serializable;

public class Annons implements Serializable {

    @Serial
    private static final long serialVersionUID = 5403016831143700756L;


    private String productName;
    private String productDescription;
    private Enum<Category> productCategory;

    public Annons(String productName, String productDescription, Enum<Category> productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
    }

    public void setAnnons(Annons annons){

    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Enum<Category> getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Enum<Category> productCategory) {
        this.productCategory = productCategory;
    }

}
