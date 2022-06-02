package Client.View.HowItWorks;

import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;
import javax.swing.JPanel;

/**
 * the main panel for the "How it works/hur fungerar det" button
 * @Author Amidala Hoffmén
 */
public class MainPanelSFD extends JPanel
{

    /**
     * creating the panel
     * @param width the width of the panel
     * @param height the height of the panel
     * @param loggedIn if the user is logged in or not
     * @param view the view variable so we can call methods in the controller
     */
    public MainPanelSFD(int width, int height, boolean loggedIn, MainFrame view) {
        super(null);
        this.setSize(width, height);
        this.add((new SFDPanel(width, height - 100)));
        this.add((new TopPanel(width, height, "SFD", loggedIn, view)));
    }
}