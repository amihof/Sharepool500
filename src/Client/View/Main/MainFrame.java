package Client.View.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Client.View.Annonser.MainPanelAnnons;
import Client.View.HowItWorks.MainPanelSFD;
import Client.View.LoginPage.MainLogin;
import Client.Controller.Controller;
import Client.View.MessagePage.MainPanelMessages;
import Client.View.MinaSidorPage.MainPanelMinaSidor;
import Client.View.MinaSidorPage.RedigeraUppgifter;
import Client.View.OneAnnons.MainPanelOneAnnons;
import Client.View.SkapaAnnons.MainPanelSkapaAnnons;

import Shared.Annons;
import Shared.Chat;
import Shared.User;


import javax.swing.*;

/**
 * the main frame of the program
 * @Author Amidala Hoffmén
 */
public class MainFrame
{
    private final int width = 1280;
    private final int height = 1920;
    private final boolean loggedIn;

    private final JFrame frame;
    private final Controller controller;
    private MainLogin mainLogin;
    private MainPanelAnnons mainPanelAnnons;
    private MainPanelMinaSidor mainPanelMinaSidor;
    private MainPanelMessages mainPanelMessages;
    private MainPanel mainPanel;

    private JDialog d;
    private final JPanel cards;

    private MainFrame view;

    /**
     * the constructor that is called when the GUI starts up.
     * @param controller the controller variable so you can call methods in controller
     * @param loggedIn if the user is logged in or not
     */
    public MainFrame(final Controller controller, boolean loggedIn) {
        this.loggedIn = loggedIn;
        this.controller = controller;
        frame = new JFrame();

        mainPanelMinaSidor = new MainPanelMinaSidor(width, height, controller, loggedIn, this);
        mainPanel = new MainPanel(width, height, controller, loggedIn, this);

        CardLayout cardLayout = new CardLayout(); //cardlayout that has all the panels in it so when you click on a button it switches the visible panel
        frame.setLayout(cardLayout);
        frame.setPreferredSize(new Dimension(this.width, this.height));
        cards = new JPanel(new CardLayout());

        cards.add(mainPanel, "MainPanel");
        cards.add(new MainPanelSFD(width, height, controller, loggedIn, this), "MainPanelSFD");
        cards.add(mainPanelMinaSidor, "MainPanelMinaSidor");
        cards.add(new MainPanelMessages(width, height, controller, loggedIn, this), "MainPanelMessages");
        addScroll(this);

        cardLayout.show(frame.getContentPane(), "MainPanel");

        frame.add(cards);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        this.view = this;
    }

    /**
     * when you click login/register on the GUI, this method makes a new MainLogin which allows
     * the user to login or register a new user
     */
    public void loginOrRegisterButtonClicked() {
        this.mainLogin = new MainLogin(controller, this);
    }

    /**
     * when you click on "Ändra uppgifter" on the Mina Sidor panel, this creates a new RedigeraUppgifter
     * which is a jdialog that allows you to change your information
     */
    public void andraUppgifterClicked(String userUsername, String userEmail) {
        new RedigeraUppgifter(controller, userUsername, userEmail);
    }

    /**
     * makes a new MainPanelSkapaAnnons panel with a scrollpanel
     * @param view so you can call methods in view
     */
    public void addScroll(MainFrame view) {
        MainPanelSkapaAnnons mainPanelSkapaAnnons = new MainPanelSkapaAnnons(width, height, controller, loggedIn, view);

        JScrollPane scrollPanel = new JScrollPane(mainPanelSkapaAnnons,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanelSkapaAnnons.setPreferredSize(new Dimension((int) mainPanelSkapaAnnons.getPreferredSize().getWidth(),
                (int)(mainPanelSkapaAnnons.getPreferredSize().getHeight()-1100)));
        scrollPanel.setBounds(0, 100, width, 700);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.setViewportView(mainPanelSkapaAnnons);

        cards.add(scrollPanel, "MainPanelSkapaAnnons");

    }

    /**
     * this method disposes the current JFrame
     */
    public void dispose() {
        frame.dispose();
        mainLogin.dispose();
    }

    /**
     * this method changes which panel is visible on the JFrame
     * @param newPanel is the new panel that should currently be visible
     */
    public void panelStateChanged(String newPanel) {
        if (newPanel.equals("MainPanel")){
            this.mainPanel = new MainPanel(width, height, controller, loggedIn, this);
            cards.add(mainPanel, "MainPanel");
        }

        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, newPanel);
    }

    /**
     * changes the panel state on mina sidor
     * @param text is the new panel that should currently be visible on Mina sidor
     */
    public void minaSidorPanelStateChanged(String text) {
        mainPanelMinaSidor.getMinaSidorPanel().panelStateChanged(text);
    }

    /**
     * changes which text should be bold based on which button is clicked on the left panel in "Mina sidor"
     * @param text is the JButton that should have bold text
     */
    public void minaSidorTextSizeChanged(String text) {
        mainPanelMinaSidor.getLeftPanel().textSizeChanged(text);
    }

    /**
     * a popup that tells the user that login failed
     */
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
        JLabel label = new JLabel ("Användarnamn och lösenord matchar inte ");
        label.setForeground(Color.RED);
        d.add(label);
        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);
    }

    /**
     * a popup that tells the user that register failed
     */
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
        JLabel label = new JLabel ("E-postadressen du angav används redan.");
        label.setForeground(Color.RED);
        d.add(label);
        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);
    }

    /**
     * a popup that tells the user that an annons is made
     */
    public void annonsMade() {
        d = new JDialog(frame , "Annons skapad", true);
        d.setLayout( new FlowLayout() );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
                addScroll(view);
            }
        });
        JLabel label = new JLabel ("Annonsen har skapats.");
        label.setForeground(Color.RED);
        d.add(label);
        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);
    }

    /**
     * updates the text field in annonsPanel based on what u searched for on the homepage
     * @param newText is the text the user searched for
     */
    public void updateTextFieldAnnonsPanel(String newText) {
        mainPanelAnnons.getAnnonsPanel().updateSearchTextField(newText);
    }

    public void updateAnnonserSeen(ArrayList<Annons> nameListAnnonser) {
        mainPanelAnnons = new MainPanelAnnons(width,height,controller,loggedIn,this);

        mainPanelAnnons.getDisplayAnnonser().addNewAnnons(nameListAnnonser);
        cards.add(mainPanelAnnons, "MainPanelAnnons");
        panelStateChanged("MainPanelAnnons");
    }

    public void wrongPasswordOrUsername() {
        d = new JDialog(frame , "Fel uppgifter", true);
        d.setLayout( new FlowLayout() );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        JLabel label = new JLabel ("Användarnamn eller lösenord fel.");
        label.setForeground(Color.RED);
        d.add(label);
        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);
    }

    public void accountMade() {
        d = new JDialog(frame , "Konto skapats", true);
        d.setLayout( new FlowLayout() );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        JLabel label = new JLabel ("Konto registrerat");
        label.setForeground(Color.RED);
        d.add(label);
        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);
    }

    public void displayOneAnnons(MainPanelOneAnnons mainPanelOneAnnons) {
        cards.add(mainPanelOneAnnons, "MainPanelOneAnnons");
        panelStateChanged("MainPanelOneAnnons");
    }

    public void loggedInInfo(User user) {
        mainPanelMinaSidor.getMinaSidorPanel().updateUserInfo(user);
    }

    public void updateChatList(ArrayList<Chat> chatList) {
        mainPanelMessages = new MainPanelMessages(width,height,controller,loggedIn,this);

        mainPanelMessages.getLeftPanelMessages().addNewChat(chatList);
        cards.add(mainPanelAnnons, "MainPanelAnnons");
        panelStateChanged("MainPanelAnnons");
    }

    public void needToLogin() {
        d = new JDialog(frame , "Felmeddelande", true);
        d.setLayout( new FlowLayout() );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        JLabel label = new JLabel ("Du måste logga in för att skicka meddelande");
        label.setForeground(Color.RED);
        d.add(label);
        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);
    }

    public void updateUserAnnonser(ArrayList<Annons> userAnnonser) {
        //mainPanelMinaSidor = new MainPanelMinaSidor(width,height,controller,loggedIn,this);

        mainPanelMinaSidor.getMinaAnnonserPage().addNewAnnons(userAnnonser);
        cards.add(mainPanelMinaSidor, "MainPanelMinaSidor");
        panelStateChanged("MainPanelMinaSidor");
    }

    public void usernameUpdated() {
        d = new JDialog(frame , "Meddelande", true);
        d.setLayout( new FlowLayout() );
        d.setForeground(Color.RED);
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        JLabel label = new JLabel ("Användarnamn har ändrats. Logga ut och in för att se ändringar");
        label.setForeground(Color.RED);
        d.add(label);
        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);

    }

    public void emailUpdated(){
        d = new JDialog(frame , "Meddelande", true);
        d.setLayout( new FlowLayout() );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        JLabel label = new JLabel ("E-post har uppdaterats. Logga ut och in för att se ändringar");
        label.setForeground(Color.RED);
        d.add(label);
        d.add(b);
        d.setSize(300,150);
        d.setVisible(true);
    }
}