package Client.View.LoginPage;

import Client.View.Main.MainFrame;
import Client.View.Main.RoundedPanelExample;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import Client.Controller.Controller;

/**
 * the JDialog that pops up when you click the Login/register button
 * @Author Amidala Hoffmén
 */
public class MainLogin extends JDialog
{
    private JTextField userNameField;
    private JTextField eMailField;
    private JTextField passwordField;
    private JTextField upprepaPasswordField;
    private JTextField eMailLoginField;
    private JTextField passwordLoginField;

    private final Controller controller;
    private final MainFrame view;

    /**
     * creating the JDialog
     * @param controller so we can call methods in the controller
     */
    public MainLogin(final Controller controller, MainFrame view) {
        final Color backgroundColor = new Color(245, 221, 204);
        this.controller = controller;
        this.view = view;
        this.setVisible(true);
        this.setBackground(backgroundColor);
        this.setLayout(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setBounds(100, 100, 750, 450);
        this.setUp();
    }

    /**
     * setting up the MainLogin/register dialog
     */
    public void setUp() {
        final Font myFont = new Font("Shree Devanagari 714", 0, 18);
        final Font newFont = myFont.deriveFont(25.0f);
        final Color greenColor = new Color(167, 203, 156, 255);

        JLabel registrera;
        (registrera = new JLabel("Skapa konto")).setLocation(0, 10);
        registrera.setSize(375, 100);
        registrera.setFont(newFont.deriveFont(25.0f));
        registrera.setHorizontalAlignment(0);
        this.add(registrera);

        JLabel loggaIn;
        (loggaIn = new JLabel("Logga in")).setLocation(375, 10);
        loggaIn.setSize(375, 100);
        loggaIn.setFont(newFont.deriveFont(25.0f));
        loggaIn.setHorizontalAlignment(0);
        this.add(loggaIn);

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

        /**
         * ÄNDRA LÖSENORDET SÅ DET INTE SYNS NÄR MAN SKRIVER IN DET!!!!!!!!! MEN DET SKA STÅ
         * PASSWORD OM INGET ÄR SKRIVET!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         */
        (this.passwordField = (JTextField) new RoundedPanelExample.RoundedTextField(20)).setText("Lösenord");
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
                if (upprepaPasswordField.getText().equals("") || upprepaPasswordField.getText().equals("Upprepa lösenord")) {
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
        eMailLoginField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (eMailLoginField.getText().equals("") || eMailLoginField.getText().equals("E-post")) {
                    eMailLoginField.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (eMailLoginField.getText().equals("")){
                    eMailLoginField.setText("E-post");
                }
            }
        });
        this.add(this.eMailLoginField);

        (this.passwordLoginField = (JTextField)new RoundedPanelExample.RoundedTextField(20)).setText("Lösenord");
        this.passwordLoginField.setLocation(413, 160);
        this.passwordLoginField.setSize(300, 40);
        this.passwordLoginField.setFont(newFont.deriveFont(15.0f));
        this.passwordLoginField.setHorizontalAlignment(2);
        passwordLoginField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (passwordLoginField.getText().equals("") || passwordLoginField.getText().equals("Lösenord")) {
                    passwordLoginField.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (passwordLoginField.getText().equals("")){
                    passwordLoginField.setText("Lösenord");
                }
            }
        });
        this.add(this.passwordLoginField);

        JButton registerUser;
        (registerUser = (JButton)new RoundedPanelExample.CircleBtn("Registrera konto")).setBackground(greenColor);
        registerUser.setBorderPainted(false);
        registerUser.setLocation(38, 340);
        registerUser.setSize(300, 50);
        registerUser.setFont(newFont.deriveFont(15.0f));
        registerUser.setHorizontalAlignment(0);
        registerUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userNameField.getText().length() > 16 || !passwordField.getText().equals(upprepaPasswordField.getText())){
                    view.wrongPasswordOrUsername();
                }
                else{
                    System.out.println(userNameField.getText() + eMailField.getText() + passwordField.getText());
                    controller.registerNewUser(userNameField.getText(), eMailField.getText(), passwordField.getText());
                    dispose();
                    view.accountMade();
                }
            }

        });

        this.add(registerUser);

        JButton loginButton;
        (loginButton = (JButton)new RoundedPanelExample.CircleBtn("Logga in")).setBackground(greenColor);
        loginButton.setBorderPainted(false);
        loginButton.setLocation(413, 340);
        loginButton.setSize(300, 50);
        loginButton.setFont(newFont.deriveFont(15.0f));
        loginButton.setHorizontalAlignment(0);

        loginButton.addActionListener(l-> controller.loginClicked(eMailLoginField.getText(), passwordLoginField.getText()));
        loginButton.addActionListener(l-> this.dispose());
        this.add(loginButton);

        JPanel streck;
        (streck = new JPanel()).setLayout(null);
        streck.setSize(2, 350);
        streck.setLocation(375, 35);
        streck.setBackground(Color.BLACK);
        this.add(streck);

    }

}