package Client.View.MinaSidorPage;

import Client.Controller.Controller;
import Client.View.main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;

public class RedigeraUppgifter extends JDialog {

    private Controller controller;
    private JLabel andraUppgifterLabel;
    private JLabel userNameLabel;
    private JLabel emailLabel;
    private JTextField userNameField;
    private JTextField eMailField;
    private JButton registerNewUserName;
    private JButton registerNewEmail;

    public RedigeraUppgifter(Controller controller) {
        final Color myNewColor = new Color(245, 221, 204);
        this.controller = controller;
        this.setVisible(true);
        this.setBackground(myNewColor);
        this.setLayout(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setBounds(100, 100, 750, 450);
        this.setUp();
    }

    private void setUp() {
        final Font myFont = new Font("Shree Devanagari 714", 0, 18);
        final Font newFont = myFont.deriveFont(25.0f);

        final Color greenColor = new Color(167, 203, 156, 255);
        (this.andraUppgifterLabel = new JLabel("Redigera profil")).setLocation(30, 10);
        this.andraUppgifterLabel.setSize(375, 50);
        this.andraUppgifterLabel.setFont(newFont.deriveFont(30.0f));
        andraUppgifterLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(this.andraUppgifterLabel);

        (this.userNameLabel = new JLabel("Användarnamn")).setLocation(38, 100);
        this.userNameLabel.setSize(375, 100);
        this.userNameLabel.setFont(newFont.deriveFont(20.0f));
        this.userNameLabel.setHorizontalAlignment(0);
        this.add(this.userNameLabel);

        (this.emailLabel = new JLabel("exempel@epost.com")).setLocation(375, 100);
        this.emailLabel.setSize(375, 100);
        this.emailLabel.setFont(newFont.deriveFont(20.0f));
        this.emailLabel.setHorizontalAlignment(0);
        this.add(this.emailLabel);

        (this.userNameField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("Nytt användarnamn");
        this.userNameField.setLocation(38, 250);
        this.userNameField.setSize(300, 40);
        this.userNameField.setFont(newFont.deriveFont(15.0f));
        this.userNameField.setHorizontalAlignment(0);
        this.add(this.userNameField);

        (this.eMailField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("Ny e-post");
        this.eMailField.setLocation(413, 160);
        this.eMailField.setSize(300, 40);
        this.eMailField.setFont(newFont.deriveFont(15.0f));
        this.eMailField.setHorizontalAlignment(0);
        this.add(this.eMailField);


        (this.registerNewUserName = (JButton)new RoundedPanelExample.CircleBtn("Registrera konto")).setBackground(greenColor);
        this.registerNewUserName.setBorderPainted(false);
        this.registerNewUserName.setLocation(38, 300);
        this.registerNewUserName.setSize(300, 50);
        this.registerNewUserName.setFont(newFont.deriveFont(15.0f));
        this.registerNewUserName.setHorizontalAlignment(0);
        //registerNewUserName.addActionListener(l -> controller.registerNewUser(userNameField.getText(),eMailField.getText()));
        this.add(this.registerNewUserName);

        (this.registerNewEmail = (JButton)new RoundedPanelExample.CircleBtn("Logga in")).setBackground(greenColor);
        this.registerNewEmail.setBorderPainted(false);
        this.registerNewEmail.setLocation(413, 300);
        this.registerNewEmail.setSize(300, 50);
        this.registerNewEmail.setFont(newFont.deriveFont(15.0f));
        this.registerNewEmail.setHorizontalAlignment(0);
        this.add(this.registerNewEmail);
    }
}