package Client.View.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.View.Annonser.AnnonsPanel;
import Client.View.Annonser.MainPanelAnnons;
import Client.View.Annonser.OneAnnons;
import Client.View.HowItWorks.MainPanelSFD;
import Client.View.LoginPage.MainLogin;
import Client.Controller.Controller;
import Client.View.MinaSidorPage.MainPanelMinaSidor;
import Client.View.MinaSidorPage.RedigeraUppgifter;
import Client.View.SkapaAnnons.MainPanelSkapaAnnons;
import Client.View.SkapaAnnons.SkapaAnnonsPanel;

import javax.swing.*;
import javax.swing.border.Border;

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
    private RedigeraUppgifter redigeraUppgifter;
    private AnnonsPanel annonsPanel;
    private JPanel newAnnonsPanel;

    private int i;
    private JPanel listContainer;

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
        //initUI();
    }

    public void loginButtonClicked(final Controller controller) {
        this.mainLogin = new MainLogin(controller);
    }

    public void andraUppgifterClicked(final Controller controller) {
        this.redigeraUppgifter = new RedigeraUppgifter(controller);
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
        topPanel = new TopPanel(width, height, controller, "0", true);
       // this.frame.add(this.mainPanelSkapaAnnons);
        frame.add(topPanel);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setPreferredSize(new Dimension(this.width, this.height));
        this.frame.setResizable(true);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setContentPane(topPanel);
        addScroll(skapaAnnonsPanel,width, height-100);
        this.frame.revalidate();
        this.frame.repaint();

    }

    public void updateJFrameAnnons(Controller controller) {
        topPanel = new TopPanel(width, height, controller, "0", true);
        annonsPanel = new AnnonsPanel(width, height-100, controller);
        //this.mainPanelAnnons = new MainPanelAnnons(width, height, controller);
        //this.frame.add(this.mainPanelAnnons);
        frame.add(topPanel);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setPreferredSize(new Dimension(this.width, this.height));
        this.frame.setResizable(true);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setContentPane(topPanel);
        frame.add(annonsPanel);
        addAnnonserPanel();
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void addScroll(JPanel jPanel, int w, int h) {
        skapaAnnonsPanel = new SkapaAnnonsPanel(width, height-100, controller);

        final JScrollPane scrollPanel = new JScrollPane(
                skapaAnnonsPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        skapaAnnonsPanel.setPreferredSize(new Dimension((int) skapaAnnonsPanel.getPreferredSize().getWidth(),
                (int)(skapaAnnonsPanel.getPreferredSize().getHeight()+500)));
        scrollPanel.setBounds(0, 100, width, height-100);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPanel);
    }

    public void addAnnonserPanel(){
        this.listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));

        final JScrollPane scrollPanel = new JScrollPane(
                listContainer,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        listContainer.setPreferredSize(new Dimension((int) listContainer.getPreferredSize().getWidth(),
                (int)(listContainer.getPreferredSize().getHeight()+500)));
        scrollPanel.setBounds(0, 250, width, height-100);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPanel);
        frame.setVisible(true);
    }

    public void addAnnons(){
        OneAnnons newAnnons = new OneAnnons();
        listContainer.add(newAnnons);
        listContainer.revalidate();

    }
}