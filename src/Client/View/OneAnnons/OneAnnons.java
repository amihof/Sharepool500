package Client.View.OneAnnons;

import Client.View.Main.MainFrame;
import Client.View.Main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;

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

    private JLabel beskrivning;
    private JLabel uthyrareLabel;
    private JLabel uthyrareBoxLabel;

    private JButton skickaMeddelandeButton;

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
        this.setBackground(backgroundColor);

        setUp();

    }

    public void setUp(){
        productNameLabel = new JLabel(productName);
        productNameLabel.setLocation(30, 50);
        productNameLabel.setSize(600, 100);
        productNameLabel.setFont(newFont.deriveFont(40.0F));
        productNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(productNameLabel);

        beskrivning = new JLabel("Beskrivning");
        beskrivning.setLocation(30, 110);
        beskrivning.setSize(600, 100);
        beskrivning.setFont(newFontBold.deriveFont(20.0F));
        beskrivning.setHorizontalAlignment(JLabel.LEFT);
        this.add(beskrivning);

        productDescriptionLabel = new JLabel(productDescription);
        productDescriptionLabel.setLocation(30, 135);
        productDescriptionLabel.setSize(1000, 100);
        productDescriptionLabel.setFont(newFont.deriveFont(20.0F));
        productDescriptionLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(productDescriptionLabel);

        uthyrareBoxLabel = new RoundedPanelExample.roundedJLabel("");
        uthyrareBoxLabel.setLocation(800, 50);
        uthyrareBoxLabel.setSize(400, 200);
        uthyrareBoxLabel.setFont(newFont.deriveFont(20.0F));
        uthyrareBoxLabel.setBackground(Color.WHITE);
        uthyrareBoxLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(uthyrareBoxLabel);

        uthyrareLabel = new JLabel("Uthyrare");
        uthyrareLabel.setLocation(15, 15);
        uthyrareLabel.setSize(100, 40);
        uthyrareLabel.setFont(newFont.deriveFont(20.0F));
        uthyrareLabel.setHorizontalAlignment(JLabel.LEFT);
        uthyrareBoxLabel.add(uthyrareLabel);

        productPublisherLabel = new JLabel(productPublisher);
        productPublisherLabel.setLocation(15, 50);
        productPublisherLabel.setSize(400, 50);
        productPublisherLabel.setFont(newFont.deriveFont(30.0F));
        productPublisherLabel.setHorizontalAlignment(JLabel.LEFT);
        uthyrareBoxLabel.add(productPublisherLabel);

        skickaMeddelandeButton = new RoundedPanelExample.CircleBtn("Skicka meddelande");
        skickaMeddelandeButton.setLocation(800, 300);
        skickaMeddelandeButton.setBorderPainted(false);
        skickaMeddelandeButton.setSize(400, 75);
        skickaMeddelandeButton.setFont(newFont.deriveFont(20.0F));
        skickaMeddelandeButton.setBackground(orangeColor);
        skickaMeddelandeButton.setHorizontalAlignment(JLabel.CENTER);
        this.add(skickaMeddelandeButton);



    }
}