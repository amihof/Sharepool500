package Client.View.OneAnnons;

import Client.Controller.Controller;
import Client.View.Annonser.AnnonsPanel;
import Client.View.Annonser.DisplayAnnonser;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;

/**
 * the main panel when one annons is shown
 * @Author Amidala Hoffmén
 */
public class MainPanelOneAnnons extends JPanel {
    private MainFrame view;
    private boolean loggedIn;
    private int width;
    private int height;
    private OneAnnons oneAnnons;
    private TopPanel topPanel;
    private Controller controller;

    public MainPanelOneAnnons(int width, int height, String productName, String productCategory, String productDescription, String productPublisher, MainFrame view, boolean loggedIn, Controller controller, int searchedAnnonsId, String productPublisherEmail){
        super(null);
        this.view = view;
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        oneAnnons = new OneAnnons(width, height-100, productName, productCategory, productDescription, productPublisher, loggedIn, controller, searchedAnnonsId, productPublisherEmail);
        this.add(oneAnnons);

        topPanel = new TopPanel(width, height, "0",loggedIn,view);
        this.add(topPanel);
    }
}
