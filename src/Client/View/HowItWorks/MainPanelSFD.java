package Client.View.HowItWorks;

import java.awt.Component;

import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;
import Client.Controller.Controller;
import javax.swing.JPanel;

/**
 * the main panel for the "How it works/hur fungerar det" button
 */
public class MainPanelSFD extends JPanel
{
    private int width;
    private int height;
    private boolean loggedIn;

    private Controller controller;
    private SFDPanel sfdPanel;
    private TopPanel topPanel;
    private MainFrame view;

    /**
     * creating the panel
     * @param width the width of the panel
     * @param height the height of the panel
     * @param controller the controller variable so we can call methods in the controller
     * @param loggedIn if the user is logged in or not
     * @param view the view variable so we can call methods in the controller
     */
    public MainPanelSFD(int width, int height, Controller controller, boolean loggedIn, MainFrame view) {
        super(null);
        this.loggedIn = loggedIn;
        this.view = view;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.add((Component)(this.sfdPanel = new SFDPanel(width, height - 100, controller)));
        this.add((Component)(this.topPanel = new TopPanel(width, height, controller, "SFD", loggedIn, view)));
    }
}