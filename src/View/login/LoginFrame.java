package View.login;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * LoginFrame is single components frame:
 * JPanel for the user to insert their  log-in details*/
public class LoginFrame extends JFrame{
    private Controller controller;
    private LoginFrame frame;
    private LoginPanel lPnl;
    private RegistrationPanel rPnl;

    private int width = 800;
    private int height = 600;


    public LoginFrame(Controller controller){
        super("Sharepool 2");
        this.frame = this;
        this.controller = controller;
        SwingUtilities.invokeLater(this::setUp);
    }

    public void setUp(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(width, height);
        this.setLocation(300, 150);
        this.setResizable(false);

        this.lPnl = new LoginPanel(width / 2, height, controller, this);
        this.rPnl = new RegistrationPanel(width / 2, height, controller, this);
        this.add(lPnl);
        this.add(rPnl);

        this.setVisible(true);
    }

    public LoginPanel geLPnl() {
        return lPnl;
    }
    public RegistrationPanel getRPnl() {
        return rPnl;
    }
}
