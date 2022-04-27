package Client.View.Main;

import java.awt.*;

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
    private JScrollPane scrollPanel;

    private boolean loggedIn;

    private JPanel listContainer;

    private JPanel cards;


    public MainFrame(final Controller controller, boolean loggedIn) {
        this.loggedIn = loggedIn;
        frame = new JFrame();
        mainPanelAnnons = new MainPanelAnnons(width, height, controller, loggedIn);
        topPanel = new TopPanel(width, height, controller, "Hem", loggedIn);
        this.controller = controller;
        CardLayout cardLayout = new CardLayout();
        frame.setLayout(cardLayout);
        frame.setPreferredSize(new Dimension(this.width, this.height));
        cards = new JPanel(new CardLayout());
        cards.add(new MainPanel(width, height, controller, loggedIn), "MainPanel");
        cards.add(new MainPanelSFD(width, height, controller, loggedIn), "MainPanelSFD");
        cards.add(new MainPanelMinaSidor(width, height, controller, loggedIn), "MainPanelMinaSidor");
       // cards.add(new MainPanelSkapaAnnons(width, height, controller, loggedIn), "MainPanelSkapaAnnons");
        cards.add(new MainPanelAnnons(width, height, controller, loggedIn), "MainPanelAnnons");
       // cards.add(new MainPanelAnnons(width, height, controller, loggedIn), "MainPanelAnnons");
        addScroll();
        cards.add(scrollPanel, "MainPanelSkapaAnnons");

        cardLayout.show(frame.getContentPane(), "MainPanel");

        frame.add(cards);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();

        frame.setVisible(true);

        this.controller = controller;
    }

    public void loginButtonClicked(final Controller controller) {
        this.mainLogin = new MainLogin(controller);
    }

    public void andraUppgifterClicked(final Controller controller) {
        this.redigeraUppgifter = new RedigeraUppgifter(controller);
    }

    public void addScroll() {
        skapaAnnonsPanel = new SkapaAnnonsPanel(width, height-100, controller);

        scrollPanel = new JScrollPane(
                skapaAnnonsPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        skapaAnnonsPanel.setPreferredSize(new Dimension((int) skapaAnnonsPanel.getPreferredSize().getWidth(),
                (int)(skapaAnnonsPanel.getPreferredSize().getHeight()+100)));
        scrollPanel.setBounds(0, 0, width, height);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.add(topPanel);
    }

    public void addAnnons(){
        OneAnnons newAnnons = new OneAnnons();
        //listContainer.add(newAnnons);
        //listContainer.revalidate();

    }

    public void dispose() {
        frame.dispose();
        mainLogin.dispose();

    }

    public void updateLogin(boolean loggedIn) {
        this.loggedIn = loggedIn;
        /*clearJFrame(controller);
        updateJFrameHome(controller);*/


    }

    public void panelStateChanged(String newPanel) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, newPanel);
    }

}