package Client.View.SkapaAnnons;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;

/**
 * the main panel when you want to create an ad
 * @Author Amidala Hoffmén
 */
public class MainPanelSkapaAnnons extends JPanel {
    public MainPanelSkapaAnnons(int width, int height, Controller controller, boolean loggedIn, MainFrame view){
        super(null);
        this.setSize(width, height);

        SkapaAnnonsPanel skapaAnnonsPanel = new SkapaAnnonsPanel(width, controller);
        this.add(skapaAnnonsPanel);

        TopPanel topPanel = new TopPanel(width, height, "0", loggedIn, view);
        this.add(topPanel);

    }

}
