package View.MinaSidorPage;

import Controller.Controller;
import View.Annonser.AnnonsPanel;
import View.main.TopPanel;

import javax.swing.*;

public class MainPanelMinaSidor extends JPanel {

    private int width;
    private int height;
    private Controller controller;
    private MinaSidorPanel minaSidorPanel;
    private TopPanel topPanel;

    public MainPanelMinaSidor(int width, int height, Controller controller){
        super(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        minaSidorPanel = new MinaSidorPanel(width, height-100, controller);
        this.add(minaSidorPanel);

        topPanel = new TopPanel(width, height, controller, "0", true);
        this.add(topPanel);

    }
}
