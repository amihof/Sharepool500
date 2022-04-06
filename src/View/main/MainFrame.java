package View.main;

import java.awt.Container;
import java.awt.Component;
import java.awt.Dimension;
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

    public MainFrame(final Controller controller) {
        this.controller = controller;
        this.mainPanelSFD = new MainPanelSFD(this.width, this.height, controller);
        this.frame = new JFrame();
        this.height = 1080;
        this.width = 1920;
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
        this.updateJFrame(1080, 720, controller);
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }

    private void updateJFrame(final int width, final int height, final Controller controller) {
        this.mainPanelSFD = new MainPanelSFD(width, height, controller);
        this.frame.add(this.mainPanelSFD);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setResizable(false);
        final Dimension screenSize = new Dimension(1080, 680);
        this.mainPanelSFD.setPreferredSize(screenSize);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setContentPane(this.mainPanelSFD);
        this.frame.revalidate();
        this.frame.repaint();
    }
}