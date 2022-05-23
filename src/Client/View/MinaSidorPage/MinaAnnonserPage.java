package Client.View.MinaSidorPage;

import Client.View.Main.MainFrame;
import Client.View.Main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;

public class MinaAnnonserPage extends JPanel {
    private Color backgroundColor;
    private Color greenColor;
    private Color orangeColor;
    private JPanel cards;

    private Font myFont;
    private Font myFontBold;
    private Font newFont;
    private Font newFontBold;
    private JButton aktivaAnnonser;
    private JButton gamlaAnnonser;
    private MainFrame view;
    private JLabel minaAnnonserLabel;
    private JPanel aktivaAnnonserPanel;

    public MinaAnnonserPage(int width, int height, MainFrame view){
        this.setLayout(null);

        this.backgroundColor = new Color(245, 221, 204);
        this.greenColor = new Color (167, 203, 156, 255);
        this.orangeColor = new Color (225, 143, 107);

        myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);
        myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        newFontBold = myFontBold.deriveFont(25.0F);

        this.view = view;

        CardLayout cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        cards = new JPanel(cardLayout);

        this.setBackground(backgroundColor);
        this.setSize(width, height);
        this.setLocation(250, 100);

        setUp();

        cardLayout.show(cards, "AktivaAnnonser");
    }

    private void setUp() {
        minaAnnonserLabel = new JLabel("Mina annonser");
        minaAnnonserLabel.setLocation(30, 30);
        minaAnnonserLabel.setSize(300, 50);
        minaAnnonserLabel.setFont(newFont.deriveFont(40.0F));
        minaAnnonserLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(minaAnnonserLabel);

        aktivaAnnonser = new RoundedPanelExample.CircleBtn("Aktiva annonser");
        aktivaAnnonser.setBackground(orangeColor);
        aktivaAnnonser.setBorderPainted(false);
        aktivaAnnonser.setLocation(30, 100);
        aktivaAnnonser.setSize(200, 40);
        aktivaAnnonser.setHorizontalAlignment(JLabel.CENTER);
        aktivaAnnonser.setEnabled(false);
        aktivaAnnonser.addActionListener(l -> gamlaAnnonser.setEnabled(true));
        aktivaAnnonser.addActionListener(l -> aktivaAnnonser.setEnabled(false));
        aktivaAnnonser.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
        this.add(aktivaAnnonser);

        gamlaAnnonser = new RoundedPanelExample.CircleBtn("Gamla annonser");
        gamlaAnnonser.setBackground(orangeColor);
        gamlaAnnonser.setBorderPainted(false);
        gamlaAnnonser.setLocation(330, 100);
        gamlaAnnonser.setSize(200, 40);
        gamlaAnnonser.setHorizontalAlignment(JLabel.CENTER);
        gamlaAnnonser.addActionListener(l -> aktivaAnnonser.setEnabled(true));
        gamlaAnnonser.addActionListener(l -> gamlaAnnonser.setEnabled(false));
        gamlaAnnonser.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
        this.add(gamlaAnnonser);

    }

    public void makeAktivaAnnonserPanel(){
        aktivaAnnonserPanel.setLayout(null);
        aktivaAnnonserPanel.setBackground(backgroundColor);
        //aktivaAnnonserPanel.setSize();
        aktivaAnnonserPanel.setLocation(250, 100);
    }

}
