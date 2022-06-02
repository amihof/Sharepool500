package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;

/**
 * the main panel of annonser. this panel holds the smaller jpanels
 * @Author Amidala Hoffmén
 */
public class MainPanelAnnons extends JPanel {
    private final DisplayAnnonser displayAnnonser;

    public MainPanelAnnons(int width, int height, Controller controller, boolean loggedIn, MainFrame view){
        super(null);
        this.setSize(width, height);

        AnnonsPanel annonsPanel = new AnnonsPanel(width);
        this.add(annonsPanel);

        displayAnnonser = new DisplayAnnonser(width, height, view, loggedIn, controller);
        this.add(displayAnnonser);

        TopPanel topPanel = new TopPanel(width, height, "0", loggedIn, view);
        this.add(topPanel);

    }

    public DisplayAnnonser getDisplayAnnonser(){
        return displayAnnonser;
    }
}
