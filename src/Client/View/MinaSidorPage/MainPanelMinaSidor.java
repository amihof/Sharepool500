package Client.View.MinaSidorPage;

import Client.Controller.Controller;
import Client.View.Annonser.DisplayAnnonser;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;

/**
 * the main panel of "Mina sidor"
 * @Author Amidala Hoffmén
 */
public class MainPanelMinaSidor extends JPanel {

    private int width;
    private int height;
    private Controller controller;
    private MinaSidorPanel minaSidorPanel;
    private TopPanel topPanel;
    private boolean loggedIn;
    private MainFrame view;
    private LeftPanel leftPanel;

    public MainPanelMinaSidor(int width, int height, Controller controller, boolean loggedIn, MainFrame view){
        super(null);
        this.view = view;
        this.loggedIn = loggedIn;
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        leftPanel = new LeftPanel(width, height, controller, "0", loggedIn, view);
        this.add(leftPanel);

        minaSidorPanel = new MinaSidorPanel(width, height-100, controller, view, "Kontouppgifter");
        this.add(minaSidorPanel);

        topPanel = new TopPanel(width, height, "0", loggedIn, view);
        this.add(topPanel);

    }

    public MinaSidorPanel getMinaSidorPanel() {
        return minaSidorPanel;
    }

    public LeftPanel getLeftPanel(){
        return leftPanel;
    }

    public MinaAnnonserPage getMinaAnnonserPage() {
        return minaSidorPanel.getMinaAnnonserPage();
    }

}
