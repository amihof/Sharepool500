package Client.Model;

import java.io.Serial;
import java.io.Serializable;

public class Annons implements Serializable {

    @Serial
    private static final long serialVersionUID = 5403016831143700756L;

    private User publisher;
    private String productName;
    private String productDescription;
    private Category productCategory;

    public Annons(String productName, String productDescription, Category productCategory, User publisher) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.publisher = publisher;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Enum<Category> getProductCategory() {
        return productCategory;
    }

    public User getPublisher() {
        return publisher;
    }
}
