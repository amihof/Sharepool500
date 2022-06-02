package Client.View.MinaSidorPage;

import Client.Controller.Controller;
import Client.View.Main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * the jdialog that pops up when you want to edit your information
 * @Author Amidala Hoffmén
 */
public class RedigeraUppgifter extends JDialog {

    private final Controller controller;
    private JTextField userNameField;
    private JTextField emailField;

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
        final Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        final Font newFont = myFont.deriveFont(25.0f);

        Color orangeColor = new Color (225, 143, 107);

        JLabel andraUppgifterLabel;
        (andraUppgifterLabel = new JLabel("Redigera profil")).setLocation(30, 20);
        andraUppgifterLabel.setSize(375, 50);
        andraUppgifterLabel.setFont(newFont.deriveFont(30.0f));
        andraUppgifterLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(andraUppgifterLabel);

        JLabel userNameLabel;
        (userNameLabel = new JLabel("Ange nytt användarnamn")).setLocation(38, 100);
        userNameLabel.setSize(375, 100);
        userNameLabel.setFont(newFont.deriveFont(20.0f));
        userNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(userNameLabel);

        JLabel emailLabel;
        (emailLabel = new JLabel("Ange ny e-post")).setLocation(413, 100);
        emailLabel.setSize(375, 100);
        emailLabel.setFont(newFont.deriveFont(20.0f));
        emailLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(emailLabel);

        (this.userNameField = new RoundedPanelExample.RoundedTextField(20)).setText("Nytt användarnamn");
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

        (this.emailField = new RoundedPanelExample.RoundedTextField(20)).setText("Ny e-post");
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


        JButton registerNewUserName;
        (registerNewUserName = new RoundedPanelExample.CircleBtn("Bekräfta nytt användarnamn")).setBackground(orangeColor);
        registerNewUserName.setBorderPainted(false);
        registerNewUserName.setLocation(38, 300);
        registerNewUserName.setSize(300, 50);
        registerNewUserName.setFont(newFont.deriveFont(15.0f));
        registerNewUserName.setHorizontalAlignment(0);
        registerNewUserName.addActionListener(l -> controller.updateUsername(userNameField.getText()));
        this.add(registerNewUserName);

        JButton registerNewEmail;
        (registerNewEmail = new RoundedPanelExample.CircleBtn("Bekräfta ny e-post")).setBackground(orangeColor);
        registerNewEmail.setBorderPainted(false);
        registerNewEmail.setLocation(413, 300);
        registerNewEmail.setSize(300, 50);
        registerNewEmail.setFont(newFont.deriveFont(15.0f));
        registerNewEmail.setHorizontalAlignment(0);
        registerNewEmail.addActionListener(l -> controller.updateEmail(emailField.getText()));
        this.add(registerNewEmail);
    }
}
