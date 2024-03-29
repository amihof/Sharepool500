package Client.View.MinaSidorPage;

import Client.Controller.Controller;
import Client.View.Main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RedigeraUppgifter extends JDialog {

    private Controller controller;
    private JLabel andraUppgifterLabel;
    private JLabel userNameLabel;
    private JLabel emailLabel;
    private JTextField userNameField;
    private JTextField emailField;
    private JButton registerNewUserName;
    private JButton registerNewEmail;
    private String whichPage;
    private String userUsername;
    private String userEmail;

    public RedigeraUppgifter(Controller controller, String userUsername, String userEmail) {
        final Color myNewColor = new Color(245, 221, 204);
        this.controller = controller;
        this.setVisible(true);
        this.setBackground(myNewColor);
        this.setLayout(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setBounds(100, 100, 750, 450);
        this.userUsername = userUsername;
        this.userEmail = userEmail;
        this.setUp();
    }

    private void setUp() {
        final Font myFont = new Font("Shree Devanagari 714", 0, 18);
        final Font newFont = myFont.deriveFont(25.0f);

        Color orangeColor = new Color (225, 143, 107);

        final Color greenColor = new Color(167, 203, 156, 255);
        (this.andraUppgifterLabel = new JLabel("Redigera profil")).setLocation(30, 20);
        this.andraUppgifterLabel.setSize(375, 50);
        this.andraUppgifterLabel.setFont(newFont.deriveFont(30.0f));
        andraUppgifterLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(this.andraUppgifterLabel);

        (this.userNameLabel = new JLabel("Ange nytt användarnamn")).setLocation(38, 100);
        this.userNameLabel.setSize(375, 100);
        this.userNameLabel.setFont(newFont.deriveFont(20.0f));
        this.userNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(this.userNameLabel);

        (this.emailLabel = new JLabel("Ange ny e-post")).setLocation(413, 100);
        this.emailLabel.setSize(375, 100);
        this.emailLabel.setFont(newFont.deriveFont(20.0f));
        this.emailLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(this.emailLabel);

        (this.userNameField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("Nytt användarnamn");
        this.userNameField.setLocation(38, 175);
        this.userNameField.setSize(300, 40);
        this.userNameField.setFont(newFont.deriveFont(15.0f));
        this.userNameField.setHorizontalAlignment(JTextField.LEFT);
        userNameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (userNameField.getText().equals("") || userNameField.getText().equals("Nytt användarnamn")) {
                    userNameField.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (userNameField.getText().equals("")){
                    userNameField.setText("Nytt användarnamn");

                }
            }
        });
        this.add(this.userNameField);

        (this.emailField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("Ny e-post");
        this.emailField.setLocation(413, 175);
        this.emailField.setSize(300, 40);
        this.emailField.setFont(newFont.deriveFont(15.0f));
        this.emailField.setHorizontalAlignment(JTextField.LEFT);
        emailField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (emailField.getText().equals("") || emailField.getText().equals("Ny e-post")) {
                    emailField.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (emailField.getText().equals("")){
                    emailField.setText("Ny e-post");

                }
            }
        });
        this.add(this.emailField);


        (this.registerNewUserName = (JButton)new RoundedPanelExample.CircleBtn("Bekräfta nytt användarnamn")).setBackground(orangeColor);
        this.registerNewUserName.setBorderPainted(false);
        this.registerNewUserName.setLocation(38, 300);
        this.registerNewUserName.setSize(300, 50);
        this.registerNewUserName.setFont(newFont.deriveFont(15.0f));
        this.registerNewUserName.setHorizontalAlignment(0);
        registerNewUserName.addActionListener(l -> controller.updateUsername(userNameField.getText()));
        this.add(this.registerNewUserName);

        (this.registerNewEmail = (JButton)new RoundedPanelExample.CircleBtn("Bekräfta ny e-post")).setBackground(orangeColor);
        this.registerNewEmail.setBorderPainted(false);
        this.registerNewEmail.setLocation(413, 300);
        this.registerNewEmail.setSize(300, 50);
        this.registerNewEmail.setFont(newFont.deriveFont(15.0f));
        this.registerNewEmail.setHorizontalAlignment(0);
        registerNewEmail.addActionListener(l -> controller.updateEmail(emailField.getText()));
        this.add(this.registerNewEmail);
    }
}
