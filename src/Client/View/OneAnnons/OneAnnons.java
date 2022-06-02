package Client.View.OneAnnons;

import Client.Controller.Controller;
import Client.View.Main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;

/**
 * the panel that shows one annons
 * @Author Amidala Hoffmén
 */
public class OneAnnons extends JPanel {
    private final Color orangeColor;

    private final Font newFont;
    private final Font newFontBold;


    private final String productName;
    private final String productDescription;
    private final String productPublisher;
    private final Controller controller;
    private final int searchedAnnonsId;
    private final String productPublisherEmail;

    public OneAnnons(int width, int height, String productName, String productDescription, String productPublisher, Controller controller, int searchedAnnonsId, String productPublisherEmail){
        setLayout(null);
        Color backgroundColor = new Color(245, 221, 204);
        this.orangeColor = new Color (225, 143, 107);

        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);
        Font myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        newFontBold = myFontBold.deriveFont(25.0F);

        this.productName = productName;
        this.productDescription = productDescription;
        this.productPublisher = productPublisher;
        this.controller = controller;
        this.searchedAnnonsId = searchedAnnonsId;
        this.productPublisherEmail = productPublisherEmail;

        this.setSize(width, height);
        this.setLocation(0,100);
        this.setBackground(backgroundColor);

        setUp();

    }

    public void setUp(){
        JLabel productNameLabel = new JLabel(productName);
        productNameLabel.setLocation(30, 50);
        productNameLabel.setSize(600, 100);
        productNameLabel.setFont(newFont.deriveFont(40.0F));
        productNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(productNameLabel);

        JLabel beskrivning = new JLabel("Beskrivning");
        beskrivning.setLocation(30, 110);
        beskrivning.setSize(600, 100);
        beskrivning.setFont(newFontBold.deriveFont(20.0F));
        beskrivning.setHorizontalAlignment(JLabel.LEFT);
        this.add(beskrivning);

        JLabel productDescriptionLabel = new JLabel(productDescription);
        productDescriptionLabel.setLocation(30, 135);
        productDescriptionLabel.setSize(1000, 100);
        productDescriptionLabel.setFont(newFont.deriveFont(20.0F));
        productDescriptionLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(productDescriptionLabel);

        JLabel uthyrareBoxLabel = new RoundedPanelExample.roundedJLabel("");
        uthyrareBoxLabel.setLocation(800, 50);
        uthyrareBoxLabel.setSize(400, 200);
        uthyrareBoxLabel.setFont(newFont.deriveFont(20.0F));
        uthyrareBoxLabel.setBackground(Color.WHITE);
        uthyrareBoxLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(uthyrareBoxLabel);

        JLabel uthyrareLabel = new JLabel("Uthyrare");
        uthyrareLabel.setLocation(15, 15);
        uthyrareLabel.setSize(100, 40);
        uthyrareLabel.setFont(newFont.deriveFont(20.0F));
        uthyrareLabel.setHorizontalAlignment(JLabel.LEFT);
        uthyrareBoxLabel.add(uthyrareLabel);

        JLabel productPublisherLabel = new JLabel(productPublisher);
        productPublisherLabel.setLocation(15, 50);
        productPublisherLabel.setSize(400, 50);
        productPublisherLabel.setFont(newFont.deriveFont(30.0F));
        productPublisherLabel.setHorizontalAlignment(JLabel.LEFT);
        uthyrareBoxLabel.add(productPublisherLabel);

        JButton skickaMeddelandeButton = new RoundedPanelExample.CircleBtn("Skicka meddelande");
        skickaMeddelandeButton.setLocation(800, 300);
        skickaMeddelandeButton.setBorderPainted(false);
        skickaMeddelandeButton.setSize(400, 75);
        skickaMeddelandeButton.setFont(newFont.deriveFont(20.0F));
        skickaMeddelandeButton.setBackground(orangeColor);
        skickaMeddelandeButton.setHorizontalAlignment(JLabel.CENTER);
        skickaMeddelandeButton.addActionListener(e -> controller.sendMessageClicked(searchedAnnonsId, productPublisherEmail));
        this.add(skickaMeddelandeButton);



    }
}