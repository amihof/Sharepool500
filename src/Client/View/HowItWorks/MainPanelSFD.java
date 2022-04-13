package Client.View.HowItWorks;

import java.awt.Component;

import Client.View.main.TopPanel;
import Client.Controller.Controller;
import javax.swing.JPanel;

public class MainPanelSFD extends JPanel
{
    private int width;
    private int height;
    private Controller controller;
    private SFDPanel sfdPanel;
    private TopPanel topPanel;

    public MainPanelSFD(int width, int height, Controller controller) {
        super(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.add((Component)(this.sfdPanel = new SFDPanel(width, height - 100, controller)));
        this.add((Component)(this.topPanel = new TopPanel(width, height, controller, "SFD", false)));
    }
}