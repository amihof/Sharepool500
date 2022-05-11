package Client.View.OneAnnons;

import Client.View.Main.MainFrame;
import Delad.Annons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OneAnnons extends JPanel {
    private Color backgroundColor;
    private Color greenColor;
    private Color orangeColor;

    private Font myFont;
    private Font myFontBold;
    private Font newFont;
    private Font newFontBold;

    private String whichPage;
    private MainFrame view;

    private int width;
    private int height;

    private String productName;
    private String productCategory;
    private String productDescription;
    private String productPublisher;

    private JLabel productNameLabel;
    private JLabel productCategoryLabel;
    private JLabel productDescriptionLabel;
    private JLabel productPublisherLabel;

    public OneAnnons(int width, int height, String productName, String productCategory, String productDescription, String productPublisher){
        setLayout(null);
        this.backgroundColor = new Color(245, 221, 204);
        this.greenColor = new Color (167, 203, 156, 255);
        this.orangeColor = new Color (225, 143, 107);

        myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);
        myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        newFontBold = myFontBold.deriveFont(25.0F);

        this.width = width;
        this.height = height;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productPublisher = productPublisher;

        this.whichPage = whichPage;

        this.view = view;

        this.setSize(width, height);
        this.setLocation(0,100);
        this.setBackground(greenColor);

        setUp();

    }

    public void setUp(){
        productNameLabel = new JLabel(productName);
        productNameLabel.setLocation(200, 200);
        productNameLabel.setSize(600, 100);
        productNameLabel.setFont(newFont.deriveFont(40.0F));
        productNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(productNameLabel);

    }
}