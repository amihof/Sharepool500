package Client.View.MinaSidorPage;

import Client.Controller.Controller;
import Client.View.main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;

public class MinaSidorPanel extends JPanel {

    private Controller controller;
    private JPanel leftPanel;
    private JLabel kontoLabel;
    private JLabel userNameLabel;
    private JLabel uppgifterLabel;
    private JLabel userNameLabel2;
    private JLabel emailLabel;
    private JLabel phoneNumberLabel;
    private JButton changeUppgifterButton;
    private JButton kontoUppgifterButton;
    private JButton minaAnnonserButton;
    private JButton laneHistorikButton;
    private JButton changePasswordButton;
    private JButton raderaKontoButton;

    public MinaSidorPanel(int width, int height, Controller controller) {
        this.setLayout(null);
        this.controller = controller;
        Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, height);
        this.setLocation(0, 100);

        this.setUp();
    }

    private void setUp() {
        Color greenColor = new Color (167, 203, 156, 255);
        Color myNewColor = new Color (225, 143, 107);

        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        Font myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        Font newFontBold = myFontBold.deriveFont(25.0F);

        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setSize(250, 980);
        leftPanel.setLocation(0,0);
        leftPanel.setBackground(greenColor);

        kontoLabel = new JLabel("Konto");
        kontoLabel.setLocation(300, 30);
        kontoLabel.setSize(150, 50);
        kontoLabel.setFont(newFont.deriveFont(40.0F));
        kontoLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(kontoLabel);

        userNameLabel = new JLabel("Användarnamn");
        userNameLabel.setLocation(300, 80);
        userNameLabel.setSize(200, 30);
        userNameLabel.setFont(newFont.deriveFont(22.0F));
        userNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(userNameLabel);

        uppgifterLabel = new JLabel("Uppgifter");
        uppgifterLabel.setLocation(300, 220);
        uppgifterLabel.setSize(150, 30);
        uppgifterLabel.setFont(newFontBold.deriveFont(22.0F));
        uppgifterLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(uppgifterLabel);

        userNameLabel2 = new JLabel("Användarnamn");
        userNameLabel2.setLocation(300, 260);
        userNameLabel2.setSize(200, 30);
        userNameLabel2.setFont(newFont.deriveFont(22.0F));
        userNameLabel2.setHorizontalAlignment(JLabel.LEFT);
        this.add(userNameLabel2);

        emailLabel = new JLabel("exempel@email.com");
        emailLabel.setLocation(300, 300);
        emailLabel.setSize(400, 30);
        emailLabel.setFont(newFont.deriveFont(22.0F));
        emailLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(emailLabel);

        phoneNumberLabel = new JLabel("072 123 45 67");
        phoneNumberLabel.setLocation(300, 340);
        phoneNumberLabel.setSize(250, 30);
        phoneNumberLabel.setFont(newFont.deriveFont(22.0F));
        phoneNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(phoneNumberLabel);

        changeUppgifterButton = new RoundedPanelExample.CircleBtn("Ändra uppgifter");
        changeUppgifterButton.setBackground(myNewColor);
        changeUppgifterButton.setBorderPainted(false);
        changeUppgifterButton.setLocation(300, 390);
        changeUppgifterButton.setSize(225, 50);
        changeUppgifterButton.setHorizontalAlignment(JLabel.CENTER);
        //changeUppgifterButton.addActionListener(l -> controller.minaSidorClicked());
        changeUppgifterButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(22.0F));
        this.add(changeUppgifterButton);

        kontoUppgifterButton = new JButton("Kontouppgifter");
        kontoUppgifterButton.setBackground(greenColor);
        kontoUppgifterButton.setBorderPainted(false);
        kontoUppgifterButton.setLocation(10, 30);
        kontoUppgifterButton.setSize(250, 30);
        kontoUppgifterButton.setHorizontalAlignment(JLabel.LEFT);
        kontoUppgifterButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        kontoUppgifterButton.setEnabled(true);
        //kontoUppgifterButton.addActionListener(l -> controller.homePage());
        leftPanel.add(kontoUppgifterButton);

        minaAnnonserButton = new JButton("Mina annonser");
        minaAnnonserButton.setBackground(greenColor);
        minaAnnonserButton.setBorderPainted(false);
        minaAnnonserButton.setLocation(10, 70);
        minaAnnonserButton.setSize(250, 30);
        minaAnnonserButton.setHorizontalAlignment(JLabel.LEFT);
        minaAnnonserButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        minaAnnonserButton.setEnabled(true);
        //minaAnnonserButton.addActionListener(l -> controller.homePage());
        leftPanel.add(minaAnnonserButton);

        laneHistorikButton = new JButton("Lånehistorik");
        laneHistorikButton.setBackground(greenColor);
        laneHistorikButton.setBorderPainted(false);
        laneHistorikButton.setLocation(10, 110);
        laneHistorikButton.setSize(250, 30);
        laneHistorikButton.setHorizontalAlignment(JLabel.LEFT);
        laneHistorikButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        laneHistorikButton.setEnabled(true);
        //laneHistorikButton.addActionListener(l -> controller.homePage());
        leftPanel.add(laneHistorikButton);

        changePasswordButton = new JButton("Byt lösenord");
        changePasswordButton.setBackground(greenColor);
        changePasswordButton.setBorderPainted(false);
        changePasswordButton.setLocation(10, 150);
        changePasswordButton.setSize(250, 30);
        changePasswordButton.setHorizontalAlignment(JLabel.LEFT);
        changePasswordButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        changePasswordButton.setEnabled(true);
        //changePasswordButton.addActionListener(l -> controller.homePage());
        leftPanel.add(changePasswordButton);

        raderaKontoButton = new JButton("Radera konto");
        raderaKontoButton.setBackground(greenColor);
        raderaKontoButton.setBorderPainted(false);
        raderaKontoButton.setLocation(10, 190);
        raderaKontoButton.setSize(250, 30);
        raderaKontoButton.setHorizontalAlignment(JLabel.LEFT);
        raderaKontoButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(22.0F));
        raderaKontoButton.setEnabled(true);
        //raderaKontoButton.addActionListener(l -> controller.homePage());
        leftPanel.add(raderaKontoButton);

        this.add(leftPanel);

    }
}
