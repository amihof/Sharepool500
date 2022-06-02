package Client.View.MinaSidorPage;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;

/**
 * the main panel of "Mina sidor"
 * @Author Amidala Hoffmén
 */
public class MainPanelMinaSidor extends JPanel {

    private final MinaSidorPanel minaSidorPanel;
    private final LeftPanel leftPanel;

    public MainPanelMinaSidor(int width, int height, Controller controller, boolean loggedIn, MainFrame view){
        super(null);
        this.setSize(width, height);

        leftPanel = new LeftPanel(controller, view);
        this.add(leftPanel);

        minaSidorPanel = new MinaSidorPanel(width, height-100, controller, view);
        this.add(minaSidorPanel);

        TopPanel topPanel = new TopPanel(width, height, "0", loggedIn, view);
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
