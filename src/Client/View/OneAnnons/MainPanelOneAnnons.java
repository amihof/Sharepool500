package Client.View.OneAnnons;

import Client.Controller.Controller;
import Client.View.Annonser.AnnonsPanel;
import Client.View.Annonser.DisplayAnnonser;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;

public class MainPanelOneAnnons extends JPanel {
    private MainFrame view;
    private boolean loggedIn;
    private int width;
    private int height;
    private OneAnnons oneAnnons;
    private TopPanel topPanel;
    private Controller controller;

    public MainPanelOneAnnons(int width, int height, String productName, String productCategory, String productDescription, String productPublisher, MainFrame view){
        super(null);
        this.view = view;
        this.loggedIn = loggedIn;
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        oneAnnons = new OneAnnons(width, height-100, productName, productCategory, productDescription, productPublisher);
        this.add(oneAnnons);

        topPanel = new TopPanel(width, height, controller, "0",loggedIn,view);
        this.add(topPanel);
    }
}
