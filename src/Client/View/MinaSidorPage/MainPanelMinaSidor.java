package Client.View.MinaSidorPage;

import Client.Controller.Controller;
import Client.View.Main.TopPanel;

import javax.swing.*;

public class MainPanelMinaSidor extends JPanel {

    private int width;
    private int height;
    private Controller controller;
    private MinaSidorPanel minaSidorPanel;
    private TopPanel topPanel;
    private boolean loggedIn;

    public MainPanelMinaSidor(int width, int height, Controller controller, boolean loggedIn){
        super(null);
        this.loggedIn = loggedIn;
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        minaSidorPanel = new MinaSidorPanel(width, height-100, controller);
        this.add(minaSidorPanel);

        topPanel = new TopPanel(width, height, controller, "0", loggedIn);
        this.add(topPanel);

    }
}
