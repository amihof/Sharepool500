package Client.View.MinaSidorPage;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.Main.RoundedPanelExample;
import Shared.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MinaSidorPanel extends JPanel {

    private Controller controller;
    private JLabel kontoLabel;
    private JLabel userNameLabel;
    private JLabel uppgifterLabel;
    private JLabel userNameLabel2;
    private JLabel emailLabel;
    private JLabel phoneNumberLabel;
    private JButton changeUppgifterButton;
    private MainFrame view;
    private String whichPage;
    private JPanel cards;
    private JPanel kontoUppgifter;
    private MinaAnnonserPage minaAnnonser;
    private JPanel bytLosenord;
    private JPanel raderaKonto;
    private Color greenColor;
    private Color orangeColor;
    private Color backgroundColor;
    private Font myFont;
    private Font newFont;
    private Font myFontBold;
    private Font newFontBold;

    private String userEmail;
    private String userUserName;
    private String userPassword;

    private int width;
    private int height;

    public MinaSidorPanel(int width, int height, Controller controller, MainFrame view, String whichPage) {
        this.setLayout(null);

        this.backgroundColor = new Color(245, 221, 204);
        this.greenColor = new Color (167, 203, 156, 255);
        this.orangeColor = new Color (225, 143, 107);

        myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);
        myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        newFontBold = myFontBold.deriveFont(25.0F);

        this.width = width;
        this.height = height;
        this.whichPage = whichPage;
        this.view = view;
        this.controller = controller;
        this.setBackground(backgroundColor);
        this.setSize(width, height);
        this.setLocation(250, 100);

        CardLayout cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        cards = new JPanel(cardLayout);

        kontoUppgifter = new JPanel();
        kontoUppgifter.setLayout(null);
        kontoUppgifter.setBackground(backgroundColor);
        kontoUppgifter.setSize(width, height);
        kontoUppgifter.setLocation(250, 100);
        kontoUppgifter.setBounds(250,100,width, height);

        bytLosenord = new JPanel();
        bytLosenord.setLayout(null);
        bytLosenord.setBackground(backgroundColor);
        bytLosenord.setSize(width, height);
        bytLosenord.setLocation(250, 100);

        raderaKonto = new JPanel();
        raderaKonto.setLayout(null);
        raderaKonto.setBackground(backgroundColor);
        raderaKonto.setSize(width, height);
        raderaKonto.setLocation(250, 100);

        this.setUp();

        cardLayout.show(cards, "Kontouppgifter");

        this.add(cards);
    }

    private void setUp() {
        makeKontoUppgifter();
        makeMinaAnnonser();
        makeBytLosenord();
        makeRaderaKonto();

    }

    private void makeRaderaKonto() {
        JLabel raderaKontoLabel = new JLabel("Radera konto");
        raderaKontoLabel.setLocation(30, 30);
        raderaKontoLabel.setSize(300, 50);
        raderaKontoLabel.setFont(newFont.deriveFont(40.0F));
        raderaKontoLabel.setHorizontalAlignment(JLabel.LEFT);
        raderaKonto.add(raderaKontoLabel);

        JLabel raderaKontoText = new JLabel("För att radera ditt konto, skriv in ditt lösenord");
        raderaKontoText.setLocation(30, 90);
        raderaKontoText.setSize(500, 50);
        raderaKontoText.setFont(newFont.deriveFont(20.0F));
        raderaKontoText.setHorizontalAlignment(JLabel.LEFT);
        raderaKonto.add(raderaKontoText);

        JTextField enterPasswordDeleteAccount = new RoundedPanelExample.RoundedTextField(20);
        enterPasswordDeleteAccount.setText("");
        enterPasswordDeleteAccount.setLocation(490, 90);
        enterPasswordDeleteAccount.setSize(400, 40);
        enterPasswordDeleteAccount.setFont(newFont.deriveFont(15.0f));
        enterPasswordDeleteAccount.setHorizontalAlignment(JTextField.LEFT);
        raderaKonto.add(enterPasswordDeleteAccount);

        JButton deleteAccountButton = new RoundedPanelExample.CircleBtn("Radera mitt konto");
        deleteAccountButton.setBackground(orangeColor);
        deleteAccountButton.setBorderPainted(false);
        deleteAccountButton.setLocation(30, 150);
        deleteAccountButton.setSize(200, 40);
        deleteAccountButton.setFont(newFont.deriveFont(15.0f));
        deleteAccountButton.setHorizontalAlignment(0);
        // deleteAccountButton.addActionListener(l -> controller.updateEmail(newPasswordField.getText()));
        raderaKonto.add(deleteAccountButton);

        cards.add(raderaKonto, "RaderaKonto");
    }

    private void makeBytLosenord() {
        JLabel passwordLabel = new JLabel("Byt lösenord");
        passwordLabel.setLocation(30, 30);
        passwordLabel.setSize(300, 50);
        passwordLabel.setFont(newFont.deriveFont(40.0F));
        passwordLabel.setHorizontalAlignment(JLabel.LEFT);
        bytLosenord.add(passwordLabel);

        JLabel currentPassword = new JLabel("Aktuellt lösenord");
        currentPassword.setLocation(30, 90);
        currentPassword.setSize(220, 50);
        currentPassword.setFont(newFont.deriveFont(20.0F));
        currentPassword.setHorizontalAlignment(JLabel.RIGHT);
        bytLosenord.add(currentPassword);

        JLabel newPassword = new JLabel("Nytt lösenord");
        newPassword.setLocation(30, 150);
        newPassword.setSize(220, 50);
        newPassword.setFont(newFont.deriveFont(20.0F));
        newPassword.setHorizontalAlignment(JLabel.RIGHT);
        bytLosenord.add(newPassword);

        JLabel newPasswordAgain = new JLabel("Upprepa nytt lösenord");
        newPasswordAgain.setLocation(30, 210);
        newPasswordAgain.setSize(220, 50);
        newPasswordAgain.setFont(newFont.deriveFont(20.0F));
        newPasswordAgain.setHorizontalAlignment(JLabel.RIGHT);
        bytLosenord.add(newPasswordAgain);

        JTextField currentPasswordField = new RoundedPanelExample.RoundedTextField(20);
        currentPasswordField.setText("");
        currentPasswordField.setLocation(260, 90);
        currentPasswordField.setSize(300, 40);
        currentPasswordField.setFont(newFont.deriveFont(15.0f));
        currentPasswordField.setHorizontalAlignment(JTextField.LEFT);
        bytLosenord.add(currentPasswordField);

        JTextField newPasswordField = new RoundedPanelExample.RoundedTextField(20);
        newPasswordField.setText("");
        newPasswordField.setLocation(260, 150);
        newPasswordField.setSize(300, 40);
        newPasswordField.setFont(newFont.deriveFont(15.0f));
        newPasswordField.setHorizontalAlignment(JTextField.LEFT);
        bytLosenord.add(newPasswordField);

        JTextField repeatPasswordField = new RoundedPanelExample.RoundedTextField(20);
        repeatPasswordField.setText("");
        repeatPasswordField.setLocation(260, 210);
        repeatPasswordField.setSize(300, 40);
        repeatPasswordField.setFont(newFont.deriveFont(15.0f));
        repeatPasswordField.setHorizontalAlignment(JTextField.LEFT);
        bytLosenord.add(repeatPasswordField);

        JButton saveChanges = new RoundedPanelExample.CircleBtn("Spara ändringar");
        saveChanges.setBackground(orangeColor);
        saveChanges.setBorderPainted(false);
        saveChanges.setLocation(30, 270);
        saveChanges.setSize(200, 40);
        saveChanges.setFont(newFont.deriveFont(15.0f));
        saveChanges.setHorizontalAlignment(0);
       // saveChanges.addActionListener(l -> controller.updateEmail(newPasswordField.getText()));
        bytLosenord.add(saveChanges);

        cards.add(bytLosenord, "BytLösenord");
    }

    private void makeMinaAnnonser() {
        minaAnnonser = new MinaAnnonserPage(width, height, view);

        cards.add(minaAnnonser, "MinaAnnonser");
    }

    private void makeKontoUppgifter() {
        kontoLabel = new JLabel("Konto");
        kontoLabel.setLocation(30, 30);
        kontoLabel.setSize(150, 50);
        kontoLabel.setFont(newFont.deriveFont(40.0F));
        kontoLabel.setHorizontalAlignment(JLabel.LEFT);
        kontoUppgifter.add(kontoLabel);

        userNameLabel = new JLabel(userUserName);
        userNameLabel.setLocation(30, 80);
        userNameLabel.setSize(200, 30);
        userNameLabel.setFont(newFont.deriveFont(22.0F));
        userNameLabel.setHorizontalAlignment(JLabel.LEFT);
        kontoUppgifter.add(userNameLabel);

        uppgifterLabel = new JLabel("Uppgifter");
        uppgifterLabel.setLocation(30, 220);
        uppgifterLabel.setSize(150, 30);
        uppgifterLabel.setFont(newFontBold.deriveFont(22.0F));
        uppgifterLabel.setHorizontalAlignment(JLabel.LEFT);
        kontoUppgifter.add(uppgifterLabel);

        userNameLabel2 = new JLabel(userUserName);
        userNameLabel2.setLocation(30, 260);
        userNameLabel2.setSize(200, 30);
        userNameLabel2.setFont(newFont.deriveFont(22.0F));
        userNameLabel2.setHorizontalAlignment(JLabel.LEFT);
        kontoUppgifter.add(userNameLabel2);

        emailLabel = new JLabel(userEmail);
        emailLabel.setLocation(30, 300);
        emailLabel.setSize(400, 30);
        emailLabel.setFont(newFont.deriveFont(22.0F));
        emailLabel.setHorizontalAlignment(JLabel.LEFT);
        kontoUppgifter.add(emailLabel);

        changeUppgifterButton = new RoundedPanelExample.CircleBtn("Ändra uppgifter");
        changeUppgifterButton.setBackground(orangeColor);
        changeUppgifterButton.setBorderPainted(false);
        changeUppgifterButton.setLocation(30, 390);
        changeUppgifterButton.setSize(225, 50);
        changeUppgifterButton.setHorizontalAlignment(JLabel.CENTER);
        changeUppgifterButton.addActionListener(l -> view.andraUppgifterClicked(userUserName, userEmail));
        changeUppgifterButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(22.0F));
        kontoUppgifter.add(changeUppgifterButton);

        cards.add(kontoUppgifter, "Kontouppgifter");
    }

    public void panelStateChanged(String panel) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, panel);
    }

    public void updateUserInfo(User user) {
        this.userEmail = user.getEmail();
        this.userUserName = user.getUsername();
        this.userPassword = user.getPassword();
        makeKontoUppgifter();
    }
}
