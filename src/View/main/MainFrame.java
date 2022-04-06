package View.main;

import java.awt.Container;
import java.awt.Component;
import java.awt.Dimension;

import View.Annonser.AnnonsPanel;
import View.Annonser.MainPanelAnnons;
import View.HowItWorks.MainPanelSFD;
import View.LoginPage.MainLogin;
import Controller.Controller;
import javax.swing.JFrame;

public class MainFrame
{
    private MainPanel mainPanel;
    private int width;
    private int height;
    private JFrame frame;
    private Controller controller;
    private MainLogin mainLogin;
    private MainPanelSFD mainPanelSFD;
    private MainPanelAnnons mainPanelAnnons;

    public MainFrame(final Controller controller) {
        this.controller = controller;
        this.height = 1080;
        this.width = 1920;
        this.mainPanelSFD = new MainPanelSFD(this.width, this.height, controller);
        this.frame = new JFrame();
        this.mainPanel = new MainPanel(this.width, this.height, controller);
        this.frame.setPreferredSize(new Dimension(this.width, this.height));
        this.frame.setResizable(true);
        this.frame.setDefaultCloseOperation(3);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.add((Component)this.mainPanel);
    }

    public void loginButtonClicked(final Controller controller) {
        this.mainLogin = new MainLogin(controller);
    }

    public void clearJFrame(final Controller controller) {
        final Component[] components = this.mainPanel.getComponents();
        final Component[] components2 = this.mainPanelSFD.getComponents();
        for (final Component component : components) {
            this.mainPanel.remove(component);
        }
        for (final Component component : components2) {
            this.mainPanelSFD.remove(component);
        }
    }

    public void updateJFrame(Controller controller) {
        this.mainPanelSFD = new MainPanelSFD(width, height, controller);
        this.frame.add(this.mainPanelSFD);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setPreferredSize(new Dimension(this.width, this.height));
        this.frame.setResizable(true);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setContentPane(this.mainPanelSFD);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void updateJFrameHome(Controller controller) {
        this.mainPanel = new MainPanel(width, height, controller);
        this.frame.add(this.mainPanel);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setPreferredSize(new Dimension(this.width, this.height));
        this.frame.setResizable(true);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setContentPane(this.mainPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void updateJFrameAnnons(Controller controller) {
        this.mainPanelAnnons = new MainPanelAnnons(width, height, controller);
        this.frame.add(this.mainPanelAnnons);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setPreferredSize(new Dimension(this.width, this.height));
        this.frame.setResizable(true);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setContentPane(this.mainPanelAnnons);
        this.frame.revalidate();
        this.frame.repaint();
    }
}