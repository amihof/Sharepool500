package main.java.View.SkapaAnnons;

import main.java.Controller.Controller;
import main.java.View.MinaSidorPage.MinaSidorPanel;
import main.java.View.main.TopPanel;

import javax.swing.*;

public class MainPanelSkapaAnnons extends JPanel {

    private int width;
    private int height;
    private Controller controller;
    private SkapaAnnonsPanel skapaAnnonsPanel;
    private TopPanel topPanel;

    public MainPanelSkapaAnnons(int width, int height, Controller controller){
        super(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        skapaAnnonsPanel = new SkapaAnnonsPanel(width, height-100, controller);
        this.add(skapaAnnonsPanel);

        topPanel = new TopPanel(width, height, controller, "0", true);
        this.add(topPanel);

    }
}
