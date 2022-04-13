package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.main.TopPanel;

import javax.swing.*;

public class MainPanelAnnons extends JPanel {
    private int width;
    private int height;
    private Controller controller;
    private AnnonsPanel annonsPanel;
    private TopPanel topPanel;

    public MainPanelAnnons(int width, int height, Controller controller){
        super(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        annonsPanel = new AnnonsPanel(width, height-100, controller);
        this.add(annonsPanel);

        topPanel = new TopPanel(width, height, controller, "0", true);
        this.add(topPanel);

    }
}
