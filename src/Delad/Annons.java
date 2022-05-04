package Delad;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

public class Annons implements Serializable {
    @Serial
    private static final long serialVersionUID = 5403016831143700756L;

    private final User publisher;
    private final String productName;
    private final String productDescription;
    private final Category productCategory;
    private final boolean renting;
    private final ImageIcon clientPicture;
    private int annonsId;

    public Annons(String productName, String productDescription, Category productCategory, User publisher, Boolean renting, ImageIcon clientPicture) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.publisher = publisher;
        this.renting  = renting;
        this.clientPicture = clientPicture;
    }

    public Annons(String productName, String productDescription, Category productCategory, User publisher, Boolean renting) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.publisher = publisher;
        this.renting  = renting;
        this.clientPicture = null;
    }



    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public User getPublisher() {
        return publisher;
    }

    public Boolean getRenting(){return renting;}
}
