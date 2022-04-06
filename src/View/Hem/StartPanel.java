package View.Hem;

import Controller.Controller;
import View.main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;

/**
 * StartPanel is the view that the user sees when they first enter the website. Its under the "Hem" button.
 * here u search for a product
 */
public class StartPanel extends JPanel {
    private JLabel welcomeText;
    private JLabel searchText;
    private RoundedPanelExample roundedPanelExample;
    private JButton searchRuta;
    private Controller controller;
    private JTextField search;
    private JTextField kategori;
    private JTextField datum;

    /**
     * setting up the panel and setting the colors.
     * @param width the width of the panel
     * @param height the height of the panel
     * @param controller the controller class that this panel needs to function
     */
    public StartPanel(int width, int height, Controller controller){
        this.setLayout(null);
        this.controller = controller;

        roundedPanelExample = new RoundedPanelExample();

        Color myNewColor = new Color (245, 221, 204);
        this.setBackground(myNewColor);

        this.setSize(width, height);
        setLocation(0,100);
        setUp();

    }

    /**
     * setting up all the JLabels and JPanels needed.
     */
    public void setUp(){

        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        Color greenColor = new Color (167, 203, 156, 255);

        welcomeText = new JLabel("Välkommen till Sharepool");
        welcomeText.setLocation(50, 60);
        welcomeText.setSize(600, 100);
        welcomeText.setFont(newFont.deriveFont(40.0F));
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        this.add(welcomeText);

        searchRuta = new RoundedPanelExample.CircleBtn("Sök");
        searchRuta.setBackground(greenColor);
        searchRuta.setBorderPainted(false);
        searchRuta.setLocation(140, 380);
        searchRuta.setSize(300, 50);
        searchRuta.setFont(newFont.deriveFont(15.0F));
        searchRuta.setHorizontalAlignment(JLabel.CENTER);
        searchRuta.addActionListener(l -> controller.searchClicked());
        this.add(searchRuta);

        //måste lägga till en actionlistener
        searchText = new JLabel("Sök efter annons");
        searchText.setLocation(140, 160);
        searchText.setSize(600, 100);
        searchText.setFont(newFont.deriveFont(30.0F));
        searchText.setHorizontalAlignment(JLabel.LEFT);
        this.add(searchText);

        //måste lägga till en actionlistener
        search = new RoundedPanelExample.RoundedTextField(20);
        search.setText("Vad vill du hyra?");
        search.setLocation(140, 240);
        search.setSize(300, 50);
        search.setFont(newFont.deriveFont(15.0F));
        search.setHorizontalAlignment(JLabel.LEFT);
        this.add(search);
        /*search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((JTextField) e.getSource()).setEnabled(false);
                setPlayerName(playerNameTextField.getText());
                controller.updateHighScoreName(playerNameTextField.getText());
            }
        });*/

        //borde ändras till en lista
        //måste lägga till en actionlistener
        kategori = new RoundedPanelExample.RoundedTextField(20);
        kategori.setText("Kategori");
        kategori.setLocation(140, 310);
        kategori.setSize(140, 50);
        kategori.setFont(newFont.deriveFont(15.0F));
        kategori.setHorizontalAlignment(JLabel.LEFT);
        this.add(kategori);

        //datumen borde ändras till en lista/kalender istället.
        //Måste lägga till en actionlistener
        datum = new RoundedPanelExample.RoundedTextField(20);
        datum.setText("Datum");
        datum.setLocation(300, 310);
        datum.setSize(140, 50);
        datum.setFont(newFont.deriveFont(15.0F));
        datum.setHorizontalAlignment(JLabel.LEFT);
        this.add(datum);

        this.add(RoundedPanelExample.roundedPanelExample());


    }
}
