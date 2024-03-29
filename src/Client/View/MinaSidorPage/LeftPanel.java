package Client.View.MinaSidorPage;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel{
    private Color backgroundColor;
    private Color greenColor;
    private Color orangeColor;
    private Font myFont;
    private Font newFont;
    private Font myFontBold;
    private Font newFontBold;

    private JButton kontoUppgifterButton;
    private JButton minaAnnonserButton;
    private JButton loggaUtButton;
    private JButton changePasswordButton;
    private JButton raderaKontoButton;
    private MainFrame view;
    private String whichPage;
    private Controller controller;

    public LeftPanel(int width, int height, Controller controller, String whichPage, boolean loggedIn, MainFrame view){
        this.backgroundColor = new Color(245, 221, 204);
        this.greenColor = new Color (167, 203, 156, 255);
        this.orangeColor = new Color (225, 143, 107);

        myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);
        myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        newFontBold = myFontBold.deriveFont(25.0F);

        this.whichPage = whichPage;

        this.view = view;
        this.controller = controller;

        this.setLayout(null);
        this.setSize(250, 980);
        this.setLocation(0,100);
        this.setBackground(greenColor);

        setUp();
    }

    public void setUp(){

        kontoUppgifterButton = new JButton("Kontouppgifter");
        kontoUppgifterButton.setBackground(greenColor);
        kontoUppgifterButton.setBorderPainted(false);
        kontoUppgifterButton.setLocation(10, 30);
        kontoUppgifterButton.setSize(250, 30);
        kontoUppgifterButton.setHorizontalAlignment(JLabel.LEFT);
        kontoUppgifterButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        kontoUppgifterButton.setEnabled(true);
        kontoUppgifterButton.addActionListener(l -> view.minaSidorPanelStateChanged("Kontouppgifter"));
        kontoUppgifterButton.addActionListener(l -> view.minaSidorTextSizeChanged("Kontouppgifter"));
        this.add(kontoUppgifterButton);

        minaAnnonserButton = new JButton("Mina annonser");
        minaAnnonserButton.setBackground(greenColor);
        minaAnnonserButton.setBorderPainted(false);
        minaAnnonserButton.setLocation(10, 70);
        minaAnnonserButton.setSize(250, 30);
        minaAnnonserButton.setHorizontalAlignment(JLabel.LEFT);
        minaAnnonserButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        minaAnnonserButton.setEnabled(true);
        minaAnnonserButton.addActionListener(l -> view.minaSidorPanelStateChanged("MinaAnnonser"));
        minaAnnonserButton.addActionListener(l -> view.minaSidorTextSizeChanged("MinaAnnonser"));
        minaAnnonserButton.addActionListener(l -> controller.minaAnnonserClicked());
        this.add(minaAnnonserButton);

        changePasswordButton = new JButton("Byt lösenord");
        changePasswordButton.setBackground(greenColor);
        changePasswordButton.setBorderPainted(false);
        changePasswordButton.setLocation(10, 110);
        changePasswordButton.setSize(250, 30);
        changePasswordButton.setHorizontalAlignment(JLabel.LEFT);
        changePasswordButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        changePasswordButton.setEnabled(true);
        changePasswordButton.addActionListener(l -> view.minaSidorPanelStateChanged("BytLösenord"));
        changePasswordButton.addActionListener(l -> view.minaSidorTextSizeChanged("BytLösenord"));
        this.add(changePasswordButton);

        raderaKontoButton = new JButton("Radera konto");
        raderaKontoButton.setBackground(greenColor);
        raderaKontoButton.setBorderPainted(false);
        raderaKontoButton.setLocation(10, 150);
        raderaKontoButton.setSize(250, 30);
        raderaKontoButton.setHorizontalAlignment(JLabel.LEFT);
        raderaKontoButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        raderaKontoButton.setEnabled(true);
        raderaKontoButton.addActionListener(l -> view.minaSidorPanelStateChanged("RaderaKonto"));
        raderaKontoButton.addActionListener(l -> view.minaSidorTextSizeChanged("RaderaKonto"));
        this.add(raderaKontoButton);

        loggaUtButton = new JButton("Logga ut");
        loggaUtButton.setBackground(greenColor);
        loggaUtButton.setBorderPainted(false);
        loggaUtButton.setLocation(10, 190);
        loggaUtButton.setSize(250, 30);
        loggaUtButton.setHorizontalAlignment(JLabel.LEFT);
        loggaUtButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        loggaUtButton.setEnabled(true);
        loggaUtButton.addActionListener(l -> controller.loggaUt());
        this.add(loggaUtButton);
    }

    public void textSizeChanged(String whichPage){
        if ("Kontouppgifter".equals(whichPage)){
            kontoUppgifterButton.setFont(new Font("Shree Devanagari 714", Font.BOLD, 18).deriveFont(22.0F));
            minaAnnonserButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            loggaUtButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            changePasswordButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            raderaKontoButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));

        }
        else if ("MinaAnnonser".equals(whichPage)){
            minaAnnonserButton.setFont(new Font("Shree Devanagari 714", Font.BOLD, 18).deriveFont(22.0F));
            kontoUppgifterButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            loggaUtButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            changePasswordButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            raderaKontoButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        }
        else if ("LoggaUt".equals(whichPage)){
            loggaUtButton.setFont(new Font("Shree Devanagari 714", Font.BOLD, 18).deriveFont(22.0F));
            kontoUppgifterButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            minaAnnonserButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            changePasswordButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            raderaKontoButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        }
        else if ("BytLösenord".equals(whichPage)){
            changePasswordButton.setFont(new Font("Shree Devanagari 714", Font.BOLD, 18).deriveFont(22.0F));
            kontoUppgifterButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            minaAnnonserButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            loggaUtButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            raderaKontoButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        }
        else if ("RaderaKonto".equals(whichPage)){
            raderaKontoButton.setFont(new Font("Shree Devanagari 714", Font.BOLD, 18).deriveFont(22.0F));
            kontoUppgifterButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            minaAnnonserButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            loggaUtButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
            changePasswordButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        }
    }
}
