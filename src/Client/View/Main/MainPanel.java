package Client.View.Main;

import Client.Controller.Controller;
import Client.View.Hem.StartPanel;

import javax.swing.*;

/**
 * the main panel that changes depending on the situation
 */
public class MainPanel extends JPanel {
    private JPanel colorPanel;
    private TopPanel topPanel;
    private StartPanel startPanel;
    private int width;
    private int height;
    private boolean loggedIn;

    /**
     * setting up the main panel. Sets up different panels depending on where the user is
     * @param width the width of the panel
     * @param height the height of the panel
     * @param controller is needed for it to function
     */
    public MainPanel(int width, int height, Controller controller, boolean loggedIn) {
        super(null);
        this.loggedIn = loggedIn;
        this.width = width;
        this.height = height;
        setSize(width, height);

        startPanel = new StartPanel(width, height-100, controller);
        this.add(startPanel);

        topPanel = new TopPanel(width, height, controller, "Hem", loggedIn);
        this.add(topPanel);

    }
}
