package Client.View.LoginPage;

import Client.View.Main.RoundedPanelExample;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JPanel;
import Client.Controller.Controller;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JDialog;

public class MainLogin extends JDialog
{
    private JLabel registrera;
    private JLabel loggaIn;
    private JTextField userNameField;
    private JTextField eMailField;
    private JTextField passwordField;
    private JTextField upprepaPasswordField;
    private JTextField eMailLoginField;
    private JTextField passwordLoginField;
    private JButton registerUser;
    private Controller controller;
    private JButton loginButton;
    private JButton forgotPassword;
    private JPanel streck;

    public MainLogin(final Controller controller) {
        final Color myNewColor = new Color(245, 221, 204);
        this.controller = controller;
        this.setVisible(true);
        this.setBackground(myNewColor);
        this.setLayout(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setBounds(100, 100, 750, 450);
        this.setUp();
    }

    public void setUp() {
        final Font myFont = new Font("Shree Devanagari 714", 0, 18);
        final Font newFont = myFont.deriveFont(25.0f);

        final Color greenColor = new Color(167, 203, 156, 255);
        (this.registrera = new JLabel("Skapa konto")).setLocation(0, 10);
        this.registrera.setSize(375, 100);
        this.registrera.setFont(newFont.deriveFont(25.0f));
        this.registrera.setHorizontalAlignment(0);
        this.add(this.registrera);

        (this.loggaIn = new JLabel("Logga in")).setLocation(375, 10);
        this.loggaIn.setSize(375, 100);
        this.loggaIn.setFont(newFont.deriveFont(25.0f));
        this.loggaIn.setHorizontalAlignment(0);
        this.add(this.loggaIn);

        (this.userNameField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("Användarnamn");
        this.userNameField.setLocation(38, 100);
        this.userNameField.setSize(300, 40);
        this.userNameField.setFont(newFont.deriveFont(15.0f));
        this.userNameField.setHorizontalAlignment(2);
        userNameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (userNameField.getText().equals("") || userNameField.getText().equals("Användarnamn")) {
                    userNameField.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (userNameField.getText().equals("")){
                    userNameField.setText("Användarnamn");

                }
            }
        });

        this.add(this.userNameField);

        (this.eMailField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("E-post");
        this.eMailField.setLocation(38, 160);
        this.eMailField.setSize(300, 40);
        this.eMailField.setFont(newFont.deriveFont(15.0f));
        this.eMailField.setHorizontalAlignment(2);
        eMailField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (eMailField.getText().equals("") || eMailField.getText().equals("E-post")) {
                    eMailField.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (eMailField.getText().equals("")){
                    eMailField.setText("E-post");

                }
            }
        });
        this.add(this.eMailField);

        (this.passwordField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("Lösenord");
        this.passwordField.setLocation(38, 220);
        this.passwordField.setSize(300, 40);
        this.passwordField.setFont(newFont.deriveFont(15.0f));
        this.passwordField.setHorizontalAlignment(2);
        passwordField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("") || passwordField.getText().equals("Lösenord")) {
                    passwordField.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (passwordField.getText().equals("")){
                    passwordField.setText("Lösenord");

                }
            }
        });
        this.add(this.passwordField);

        (this.upprepaPasswordField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("Upprepa lösenord");
        this.upprepaPasswordField.setLocation(38, 280);
        this.upprepaPasswordField.setSize(300, 40);
        this.upprepaPasswordField.setFont(newFont.deriveFont(15.0f));
        this.upprepaPasswordField.setHorizontalAlignment(2);
        upprepaPasswordField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (upprepaPasswordField.getText().equals("") || eMailField.getText().equals("Upprepa lösenord")) {
                    upprepaPasswordField.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (upprepaPasswordField.getText().equals("")){
                    upprepaPasswordField.setText("Upprepa lösenord");

                }
            }
        });
        this.add(this.upprepaPasswordField);

        (this.eMailLoginField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("E-post");
        this.eMailLoginField.setLocation(413, 100);
        this.eMailLoginField.setSize(300, 40);
        this.eMailLoginField.setFont(newFont.deriveFont(15.0f));
        this.eMailLoginField.setHorizontalAlignment(2);
        eMailField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (eMailField.getText().equals("") || eMailField.getText().equals("E-post")) {
                    eMailField.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (eMailField.getText().equals("")){
                    eMailField.setText("E-post");

                }
            }
        });
        this.add(this.eMailLoginField);

        (this.passwordLoginField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("Lösenord");
        this.passwordLoginField.setLocation(413, 160);
        this.passwordLoginField.setSize(300, 40);
        this.passwordLoginField.setFont(newFont.deriveFont(15.0f));
        this.passwordLoginField.setHorizontalAlignment(2);
        this.add(this.passwordLoginField);

        (this.registerUser = (JButton)new RoundedPanelExample.CircleBtn("Registrera konto")).setBackground(greenColor);
        this.registerUser.setBorderPainted(false);
        this.registerUser.setLocation(38, 340);
        this.registerUser.setSize(300, 50);
        this.registerUser.setFont(newFont.deriveFont(15.0f));
        this.registerUser.setHorizontalAlignment(0);
        registerUser.addActionListener(l -> controller.registerNewUser(eMailField.getText(), userNameField.getText(), passwordField.getText()));
        registerUser.addActionListener(l-> this.dispose());
        this.add(this.registerUser);

        (this.loginButton = (JButton)new RoundedPanelExample.CircleBtn("Logga in")).setBackground(greenColor);
        this.loginButton.setBorderPainted(false);
        this.loginButton.setLocation(413, 340);
        this.loginButton.setSize(300, 50);
        this.loginButton.setFont(newFont.deriveFont(15.0f));
        this.loginButton.setHorizontalAlignment(0);
        loginButton.addActionListener(l-> controller.loginClicked(eMailLoginField.getText(), passwordLoginField.getText()));
       // loginButton.addActionListener(l-> controller.login());
        loginButton.addActionListener(l-> this.dispose());
        this.add(this.loginButton);

        this.forgotPassword = new JButton("Jag har glömt mitt lösenord");
        this.forgotPassword.setBorderPainted(false);
        this.forgotPassword.setLocation(375, 200);
        this.forgotPassword.setSize(375, 30);
        this.forgotPassword.setHorizontalAlignment(0);
        forgotPassword.setBackground(Color.LIGHT_GRAY);
        this.forgotPassword.setFont(newFont.deriveFont(10.0f));
        this.forgotPassword.setForeground(Color.GRAY);
        this.forgotPassword.setEnabled(true);
        this.add(this.forgotPassword);

        (this.streck = new JPanel()).setLayout(null);
        this.streck.setSize(2, 350);
        this.streck.setLocation(375, 35);
        this.streck.setBackground(Color.BLACK);
        this.add(this.streck);

    }

}