package Client.View.OneAnnons;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;

/**
 * the main panel when one annons is shown
 * @Author Amidala Hoffmén
 */
public class MainPanelOneAnnons extends JPanel {
    public MainPanelOneAnnons(int width, int height, String productName, String productDescription, String productPublisher, MainFrame view, boolean loggedIn, Controller controller, int searchedAnnonsId, String productPublisherEmail){
        super(null);
        this.setSize(width, height);

        OneAnnons oneAnnons = new OneAnnons(width, height - 100, productName, productDescription, productPublisher, controller, searchedAnnonsId, productPublisherEmail);
        this.add(oneAnnons);

        TopPanel topPanel = new TopPanel(width, height, "0", loggedIn, view);
        this.add(topPanel);
    }
}
