package View.main;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * the top of the GUI. The panel that is at the top and almost never changes, only a few small changes.
 */
public class TopPanel extends JPanel {
    private JLabel sharePoolLogo;
    private JButton hem;
    private JButton saFungerarDet;
    private JButton meddelanden;
    private JButton loggaInRegistrera;
    private RoundedPanelExample roundedPanelExample;
    private Controller controller;

    public TopPanel(int width, int height, Controller controller){
        this.setLayout(null);
        this.controller = controller;
        roundedPanelExample = new RoundedPanelExample();

        this.setBackground(Color.WHITE);
        this.setSize(width, height-500);
        this.setLocation(0,0);
        setUp();
    }

    public void setUp(){

        Color myNewColor = new Color (225, 143, 107);

        Color greenColor = new Color (167, 203, 156, 255);

        Font myFont = new Font("Shree Devanagari 714", Font.BOLD, 18);
        Font newFont = myFont.deriveFont(25.0F);

        sharePoolLogo = new JLabel("Sharepool");
        sharePoolLogo.setLocation(30, 10);
        sharePoolLogo.setSize(600, 100);
        sharePoolLogo.setForeground(myNewColor);
        sharePoolLogo.setFont(newFont.deriveFont(40.0F));
        sharePoolLogo.setHorizontalAlignment(JLabel.LEFT);
        this.add(sharePoolLogo);

        hem = new JButton("Hem");
        hem.setBackground(Color.WHITE);
        hem.setBorderPainted(false);
        hem.setLocation(250, 48);
        hem.setSize(100, 30);
        hem.setHorizontalAlignment(JLabel.CENTER);
        hem.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(17.0F));
        hem.setEnabled(true);
        hem.addActionListener(l -> controller.homePage());
        this.add(hem);

        saFungerarDet = new JButton("Så fungerar det");
        saFungerarDet.setBackground(Color.WHITE);
        saFungerarDet.setBorderPainted(false);
        saFungerarDet.setLocation(350, 48);
        saFungerarDet.setSize(180, 30);
        saFungerarDet.setHorizontalAlignment(JLabel.LEFT);
        saFungerarDet.addActionListener(l -> controller.saFungerarDetClicked());
        saFungerarDet.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(17.0F));
        this.add(saFungerarDet);

        meddelanden = new JButton("Meddelanden");
        meddelanden.setBackground(Color.WHITE);
        meddelanden.setBorderPainted(false);
        meddelanden.setLocation(525, 48);
        meddelanden.setSize(150, 30);
        meddelanden.setHorizontalAlignment(JLabel.LEFT);
        meddelanden.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(17.0F));
        this.add(meddelanden);

        loggaInRegistrera = new RoundedPanelExample.CircleBtn("Logga in/Registrera");
        loggaInRegistrera.setBackground(greenColor);
        loggaInRegistrera.setBorderPainted(false);
        loggaInRegistrera.setLocation(1025, 37);
        loggaInRegistrera.setSize(200, 40);
        loggaInRegistrera.setHorizontalAlignment(JLabel.CENTER);
        loggaInRegistrera.addActionListener(l -> controller.loginClicked());
        loggaInRegistrera.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
        this.add(loggaInRegistrera);

    }
}
