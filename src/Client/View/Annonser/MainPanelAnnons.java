package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;

public class MainPanelAnnons extends JPanel {
    private int width;
    private int height;
    private Controller controller;
    private AnnonsPanel annonsPanel;
    private TopPanel topPanel;

    private JScrollPane scrollPane;

    private int i;
    private JPanel listContainer;

    private boolean loggedIn;
    private MainFrame view;

    public MainPanelAnnons(int width, int height, Controller controller, boolean loggedIn, MainFrame view){
        super(null);
        this.view = view;
        this.loggedIn = loggedIn;
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        annonsPanel = new AnnonsPanel(width, height-100, controller);
        this.add(annonsPanel);

        topPanel = new TopPanel(width, height, controller, "0", loggedIn, view);
        this.add(topPanel);

    }
}
