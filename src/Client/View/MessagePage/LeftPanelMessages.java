package Client.View.MessagePage;

import Client.Controller.Controller;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;

public class LeftPanelMessages extends JPanel {
    private int width;
    private int height;
    private Controller controller;
    private Color backgroundColor;
    private Color greenColor;
    private Color orangeColor;
    private Font myFont;
    private Font newFont;
    private Font myFontBold;
    private Font newFontBold;
    private JLabel meddelandenLabel;

    public LeftPanelMessages(int width, int height, Controller controller){
        this.setLayout(null);
        this.controller = controller;

        this.backgroundColor = new Color(245, 221, 204);
        this.greenColor = new Color (167, 203, 156, 255);
        this.orangeColor = new Color (225, 143, 107);

        myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);
        myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        newFontBold = myFontBold.deriveFont(25.0F);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setSize(width, height);
        this.setLocation(0, 100);
        this.setUp();
    }

    public void setUp(){
        meddelandenLabel = new JLabel("Meddelanden");
        meddelandenLabel.setLocation(0, 0);
        meddelandenLabel.setSize(250, 100);
        meddelandenLabel.setFont(newFontBold.deriveFont(25.0f));
        meddelandenLabel.setForeground(greenColor);
        meddelandenLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(meddelandenLabel);

    }
}
