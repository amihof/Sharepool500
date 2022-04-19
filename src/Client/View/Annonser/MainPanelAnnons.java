package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.main.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public MainPanelAnnons(int width, int height, Controller controller, boolean loggedIn){
        super(null);
        this.loggedIn = loggedIn;
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        annonsPanel = new AnnonsPanel(width, height-100, controller);
        this.add(annonsPanel);

        topPanel = new TopPanel(width, height, controller, "0", loggedIn);
        this.add(topPanel);

    }
}
