package Client.View.Main;

import Client.Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * the top of the GUI. The panel that is at the top and almost never changes, only a few small changes.
 */
public class TopPanel extends JPanel {
    private JLabel sharePoolLogo;
    private JPanel whichPageColor;
    private String whichPage;
    private Boolean loggedIn;

    private JButton hem;
    private JButton saFungerarDet;
    private JButton meddelanden;
    private JButton loggaInRegistrera;
    private JButton skapaAnnonsButton;
    private JButton minaSidorButton;

    private RoundedPanelExample roundedPanelExample;
    private Controller controller;
    private MainFrame view;

    /**
     * creates the TopPanel
     * @param width is the width of the panel
     * @param height is the height of the panel
     * @param controller the controller variable so we can call methods in the controller
     * @param whichPage which page is clicked, home, how it works or messages
     * @param loggedIn if the user is logged in or not
     * @param view the view variable so we can call methods in the MainFrame
     */
    public TopPanel(int width, int height, Controller controller, String whichPage, boolean loggedIn, MainFrame view){
        this.setLayout(null);
        this.view = view;
        this.loggedIn = loggedIn;
        this.controller = controller;
        this.whichPage = whichPage;
        roundedPanelExample = new RoundedPanelExample();

        this.setBackground(Color.WHITE);
        this.setSize(width, height-500);
        this.setLocation(0,0);
        setUp();
    }

    /**
     * setting up the TopPanel
     */
    public void setUp(){

        Color myNewColor = new Color (225, 143, 107);

        Color greenColor = new Color (167, 203, 156, 255);

        Font myFont = new Font("Shree Devanagari 714", Font.BOLD, 18);
        Font newFont = myFont.deriveFont(25.0F);

        sharePoolLogo = new JLabel("Sharepool");
        sharePoolLogo.setLocation(30, 10);
        sharePoolLogo.setSize(600, 100);
        sharePoolLogo.setForeground(myNewColor);
        sharePoolLogo.setFont(newFont.deriveFont(40.0F));
        sharePoolLogo.setHorizontalAlignment(JLabel.LEFT);
        this.add(sharePoolLogo);

        hem = new JButton("Hem");
        hem.setBackground(Color.WHITE);
        hem.setBorderPainted(false);
        hem.setLocation(250, 48);
        hem.setSize(100, 30);
        hem.setHorizontalAlignment(JLabel.CENTER);
        hem.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(17.0F));
        hem.setEnabled(true);
        hem.addActionListener(l -> view.panelStateChanged("MainPanel"));
        this.add(hem);

        saFungerarDet = new JButton("Så fungerar det");
        saFungerarDet.setBackground(Color.WHITE);
        saFungerarDet.setBorderPainted(false);
        saFungerarDet.setLocation(350, 48);
        saFungerarDet.setSize(180, 30);
        saFungerarDet.setHorizontalAlignment(JLabel.LEFT);
        saFungerarDet.addActionListener(l -> view.panelStateChanged("MainPanelSFD"));
        saFungerarDet.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(17.0F));
        this.add(saFungerarDet);

        meddelanden = new JButton("Meddelanden");
        meddelanden.setBackground(Color.WHITE);
        meddelanden.setBorderPainted(false);
        meddelanden.setLocation(525, 48);
        meddelanden.setSize(150, 30);
        meddelanden.setHorizontalAlignment(JLabel.LEFT);
        meddelanden.addActionListener(l -> view.panelStateChanged("MainPanelMessages"));
        meddelanden.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 18).deriveFont(17.0F));
        this.add(meddelanden);

        if(loggedIn){
            minaSidorButton = new RoundedPanelExample.CircleBtn("Mina sidor");
            minaSidorButton.setBackground(greenColor);
            minaSidorButton.setBorderPainted(false);
            minaSidorButton.setLocation(1050, 37);
            minaSidorButton.setSize(175, 40);
            minaSidorButton.setHorizontalAlignment(JLabel.CENTER);
            minaSidorButton.addActionListener(l -> view.panelStateChanged("MainPanelMinaSidor"));
            minaSidorButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
            this.add(minaSidorButton);

            skapaAnnonsButton = new RoundedPanelExample.CircleBtn("Skapa annons");
            skapaAnnonsButton.setBackground(greenColor);
            skapaAnnonsButton.setBorderPainted(false);
            skapaAnnonsButton.setLocation(850, 37);
            skapaAnnonsButton.setSize(175, 40);
            skapaAnnonsButton.setHorizontalAlignment(JLabel.CENTER);
            skapaAnnonsButton.addActionListener(l -> view.panelStateChanged("MainPanelSkapaAnnons"));
            skapaAnnonsButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
            this.add(skapaAnnonsButton);

        }
        else if(!loggedIn) {
            loggaInRegistrera = new RoundedPanelExample.CircleBtn("Logga in/Registrera");
            loggaInRegistrera.setBackground(greenColor);
            loggaInRegistrera.setBorderPainted(false);
            loggaInRegistrera.setLocation(1025, 37);
            loggaInRegistrera.setSize(200, 40);
            loggaInRegistrera.setHorizontalAlignment(JLabel.CENTER);
            loggaInRegistrera.addActionListener(l -> view.loginOrRegisterButtonClicked());
            loggaInRegistrera.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
            this.add(loggaInRegistrera);
        }

        if ("Hem".equals(whichPage)) {
            whichPageColor = new JPanel();
            whichPageColor.setSize(95, 5);
            whichPageColor.setLocation(255, 95);
            whichPageColor.setBackground(myNewColor);
            this.add(whichPageColor);
        } else if ("SFD".equals(whichPage)) {
            whichPageColor = new JPanel();
            whichPageColor.setSize(160, 5);
            whichPageColor.setLocation(350, 95);
            whichPageColor.setBackground(myNewColor);
            this.add(whichPageColor);
        } else if ("Messages".equals(whichPage)) {
            whichPageColor = new JPanel();
            whichPageColor.setSize(140, 5);
            whichPageColor.setLocation(525, 95);
            whichPageColor.setBackground(myNewColor);
            this.add(whichPageColor);
        }

    }
}
