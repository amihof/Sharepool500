package Client.View.Main;

import Client.Controller.Controller;
import Client.View.Hem.StartPanel;

import javax.swing.*;

/**
 * the main panel that changes depending on the situation
 */
public class MainPanel extends JPanel {

    /**
     * setting up the main panel. Sets up different panels depending on where the user is
     * @param width the width of the panel
     * @param height the height of the panel
     * @param controller is needed for it to function
     */
    public MainPanel(int width, int height, Controller controller, boolean loggedIn, MainFrame view) {
        super(null);
        setSize(width, height);

        StartPanel startPanel = new StartPanel(width, height - 100, controller, view);
        this.add(startPanel);

        TopPanel topPanel = new TopPanel(width, height, "Hem", loggedIn, view);
        this.add(topPanel);

    }
}
