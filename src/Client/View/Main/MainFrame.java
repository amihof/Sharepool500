package Client.View.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.View.Annonser.AnnonsPanel;
import Client.View.Annonser.MainPanelAnnons;
import Client.View.HowItWorks.MainPanelSFD;
import Client.View.LoginPage.MainLogin;
import Client.Controller.Controller;
import Client.View.MessagePage.MainPanelMessages;
import Client.View.MinaSidorPage.MainPanelMinaSidor;
import Client.View.MinaSidorPage.MinaSidorPanel;
import Client.View.MinaSidorPage.RedigeraUppgifter;
import Client.View.SkapaAnnons.MainPanelSkapaAnnons;
import Client.View.SkapaAnnons.SkapaAnnonsPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
    private JDialog d;
    private MinaSidorPanel minaSidorPanel;

    private boolean loggedIn;

    private JPanel listContainer;

    private JPanel cards;

    public MainFrame(final Controller controller, boolean loggedIn) {
        this.loggedIn = loggedIn;
        frame = new JFrame();
        mainPanelMinaSidor = new MainPanelMinaSidor(width, height, controller, true, this);
        mainPanelAnnons = new MainPanelAnnons(width,height,controller,true,this, frame);
        topPanel = new TopPanel(width, height, controller, "Hem", loggedIn, this);
        this.controller = controller;

        CardLayout cardLayout = new CardLayout();
        frame.setLayout(cardLayout);
        frame.setPreferredSize(new Dimension(this.width, this.height));
        cards = new JPanel(new CardLayout());
        cards.add(new MainPanel(width, height, controller, loggedIn, this), "MainPanel");
        cards.add(new MainPanelSFD(width, height, controller, loggedIn, this), "MainPanelSFD");
        cards.add(new MainPanelMinaSidor(width, height, controller, loggedIn, this), "MainPanelMinaSidor");
        cards.add(mainPanelAnnons, "MainPanelAnnons");
        cards.add(new MainPanelMessages(width, height, controller, loggedIn, this), "MainPanelMessages");
        addScroll(this);

        cardLayout.show(frame.getContentPane(), "MainPanel");

        frame.add(cards);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();

        frame.setVisible(true);

        this.controller = controller;
    }

    public void loginButtonClicked() {
        this.mainLogin = new MainLogin(controller);
    }

    public void andraUppgifterClicked() {
        this.redigeraUppgifter = new RedigeraUppgifter(controller);
    }

    public void addScroll(MainFrame view) {
        mainPanelSkapaAnnons = new MainPanelSkapaAnnons(width,height,controller,loggedIn,view);

        JScrollPane scrollPanel = new JScrollPane(mainPanelSkapaAnnons,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanelSkapaAnnons.setPreferredSize(new Dimension((int) mainPanelSkapaAnnons.getPreferredSize().getWidth(),
                (int)(mainPanelSkapaAnnons.getPreferredSize().getHeight()-700)));
        scrollPanel.setBounds(0, 100, width, height-500);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.setViewportView(mainPanelSkapaAnnons);

        cards.add(scrollPanel, "MainPanelSkapaAnnons");


    }

    public void dispose() {
        frame.dispose();
        mainLogin.dispose();

    }

    public void panelStateChanged(String newPanel) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, newPanel);
    }

    public void minaSidorPanelStateChanged(String text) {
        mainPanelMinaSidor.getMinaSidorPanel().panelStateChanged(text);
    }

    public void minaSidorTextSizeChanged(String text) {
        mainPanelMinaSidor.getLeftPanel().textSizeChanged(text);
    }

    public void couldNotLogin() {
        d = new JDialog(frame , "Dialog Example", true);
        d.setLayout( new FlowLayout() );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        d.add( new JLabel ("Användarnamn och lösenord matchar inte "));

        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);
    }

    public void couldNotRegister() {
        d = new JDialog(frame , "Fel", true);
        d.setLayout( new FlowLayout() );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        d.add( new JLabel ("E-postadressen du angav används redan."));
        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);
    }

    public void updateTextFieldAnnonsPanel(String newText) {
        mainPanelAnnons.getAnnonsPanel().updateSearchTextField(newText);
    }
}