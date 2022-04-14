package Client.View.main;

import java.awt.*;

import Client.View.Annonser.MainPanelAnnons;
import Client.View.HowItWorks.MainPanelSFD;
import Client.View.LoginPage.MainLogin;
import Client.Controller.Controller;
import Client.View.MinaSidorPage.MainPanelMinaSidor;
import Client.View.SkapaAnnons.MainPanelSkapaAnnons;
import Client.View.SkapaAnnons.SkapaAnnonsPanel;

import javax.swing.*;

public class MainFrame
{
    private MainPanel mainPanel;
    private int width = 1280;
    private int height = 1920;
    private JFrame frame;
    private Controller controller;
    private MainLogin mainLogin;
    private MainPanelSFD mainPanelSFD;
    private MainPanelAnnons mainPanelAnnons;
    private MainPanelMinaSidor mainPanelMinaSidor;
    private MainPanelSkapaAnnons mainPanelSkapaAnnons;
    private SkapaAnnonsPanel skapaAnnonsPanel;
    private TopPanel topPanel;

    public MainFrame(final Controller controller) {
        this.controller = controller;
        this.mainPanelSFD = new MainPanelSFD(this.width, this.height, controller);
        this.mainPanelMinaSidor = new MainPanelMinaSidor(width, height, controller);
        this.mainPanelAnnons = new MainPanelAnnons(width, height, controller);
        this.mainPanelSkapaAnnons = new MainPanelSkapaAnnons(width, height, controller);
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
        final Component[] components3 = this.mainPanelMinaSidor.getComponents();
        final Component[] components4 = this.mainPanelAnnons.getComponents();

        for (final Component component : components) {
            this.mainPanel.remove(component);
        }
        for (final Component component : components2) {
            this.mainPanelSFD.remove(component);
        }
        for (final Component component : components3) {
            this.mainPanelMinaSidor.remove(component);
        }
        for (final Component component : components4) {
            this.mainPanelAnnons.remove(component);
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

    public void updateJFrameMinaSidor(Controller controller) {
        this.mainPanelMinaSidor = new MainPanelMinaSidor(width, height, controller);
        this.frame.add(this.mainPanelMinaSidor);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setPreferredSize(new Dimension(this.width, this.height));
        this.frame.setResizable(true);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setContentPane(this.mainPanelMinaSidor);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void updateJFrameSkapaAnnons(Controller controller) {
        skapaAnnonsPanel = new SkapaAnnonsPanel(width, height-100, controller);
        addScroll(skapaAnnonsPanel,width, 50);
        topPanel = new TopPanel(width, height, controller, "0", true);
       // this.frame.add(this.mainPanelSkapaAnnons);
        frame.add(topPanel);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setPreferredSize(new Dimension(this.width, this.height));
        this.frame.setResizable(true);
        this.frame.pack();
        this.frame.setVisible(true);
        //this.frame.setContentPane(topPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void addScroll(JPanel jPanel, int w, int h) {
        JScrollPane jScrollPane = new JScrollPane(){

        };
        JViewport viewport = new JViewport() {

        };
        jScrollPane.setViewport(viewport);
        jScrollPane.setViewportView(jPanel);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setSize(new Dimension(w, h));
        jScrollPane.setMinimumSize(new Dimension(w, h));
        jScrollPane.setPreferredSize(new Dimension(w, h));
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        jScrollPane.setLocation(0,100);
        frame.setContentPane(jScrollPane);
    }
}