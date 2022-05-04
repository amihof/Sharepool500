package Client.View.SkapaAnnons;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanelSkapaAnnons extends JPanel {

    private int width;
    private int height;
    private Controller controller;
    private SkapaAnnonsPanel skapaAnnonsPanel;
    private TopPanel topPanel;
    private boolean loggedIn;
    private MainFrame view;

    public MainPanelSkapaAnnons(int width, int height, Controller controller, boolean loggedIn, MainFrame view){
        super(null);
        this.view = view;
        this.loggedIn = loggedIn;
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        skapaAnnonsPanel = new SkapaAnnonsPanel(width, height-100, controller);
        this.add(skapaAnnonsPanel);

        topPanel = new TopPanel(width, height, controller, "0", loggedIn, view);
        this.add(topPanel);

    }

    public SkapaAnnonsPanel getSkapaAnnonsPanel(){
        return skapaAnnonsPanel;
    }
}
