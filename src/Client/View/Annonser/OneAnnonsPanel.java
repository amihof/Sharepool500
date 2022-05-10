package Client.View.Annonser;

import Client.View.Main.MainFrame;

import javax.swing.*;
import java.awt.*;

public class OneAnnonsPanel extends JPanel {
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

    public OneAnnonsPanel(int width, int height){
        this.backgroundColor = new Color(245, 221, 204);
        this.greenColor = new Color (167, 203, 156, 255);
        this.orangeColor = new Color (225, 143, 107);

        myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);
        myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        newFontBold = myFontBold.deriveFont(25.0F);

        this.whichPage = whichPage;

        this.view = view;

        this.setLayout(null);
        this.setSize(250, 980);
        this.setLocation(0,100);
        this.setBackground(greenColor);

        setUp();


    }

    public void setUp(){

    }
}
