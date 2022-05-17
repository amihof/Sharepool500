package Client.View.Hem;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.Main.RoundedPanelExample;
import Shared.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * StartPanel is the view that the user sees when they first enter the website. Its under the "Hem" button.
 * here u search for a product
 * @Author Amidala Hoffmén
 */
public class StartPanel extends JPanel {
    private final Controller controller;
    private JTextField search;
    private JComboBox cmbCategories;
    private final MainFrame view;

    /**
     * setting up the panel and setting the colors.
     * @param width the width of the panel
     * @param height the height of the panel
     * @param controller the controller class that this panel needs to function
     */
    public StartPanel(int width, int height, Controller controller, MainFrame view){
        this.setLayout(null);
        this.view = view;
        this.controller = controller;

        Color backgroundColor = new Color (245, 221, 204);
        this.setBackground(backgroundColor);

        this.setSize(width, height);
        setLocation(0,100);
        createAndInitiateComboBox();
        setUp();

    }

    /**
     * setting up all the JLabels and JPanels needed.
     */
    public void setUp(){
        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);
        Color greenColor = new Color (167, 203, 156, 255);

        JLabel welcomeText = new JLabel("Välkommen till Sharepool");
        welcomeText.setLocation(50, 60);
        welcomeText.setSize(600, 100);
        welcomeText.setFont(newFont.deriveFont(40.0F));
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        this.add(welcomeText);

        JButton searchRuta = new RoundedPanelExample.CircleBtn("Sök");
        searchRuta.setBackground(greenColor);
        searchRuta.setBorderPainted(false);
        searchRuta.setLocation(140, 380);
        searchRuta.setSize(300, 50);
        searchRuta.setFont(newFont.deriveFont(15.0F));
        searchRuta.setHorizontalAlignment(JLabel.CENTER);
        searchRuta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (search.getText().equals("Vad vill du hyra?")){
                    controller.searchedClicked("", (Category) cmbCategories.getSelectedItem());
                    view.panelStateChanged("MainPanelAnnons");
                }
                else{
                    controller.searchedClicked(search.getText(), (Category) cmbCategories.getSelectedItem());
                    view.panelStateChanged("MainPanelAnnons");
                }

            }

        });
        this.add(searchRuta);

        JLabel searchText = new JLabel("Sök efter annons");
        searchText.setLocation(140, 160);
        searchText.setSize(600, 100);
        searchText.setFont(newFont.deriveFont(30.0F));
        searchText.setHorizontalAlignment(JLabel.LEFT);
        this.add(searchText);

        search = new RoundedPanelExample.RoundedTextField(20);
        search.setText("Vad vill du hyra?");
        search.setLocation(140, 240);
        search.setSize(300, 50);
        search.setFont(newFont.deriveFont(15.0F));
        search.setHorizontalAlignment(JLabel.LEFT);
        search.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("") || search.getText().equals("Vad vill du hyra?")) {
                    search.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (search.getText().equals("")){
                    search.setText("Vad vill du hyra?");

                }
            }
        });
        this.add(search);
        this.add(RoundedPanelExample.roundedPanelExample());
    }

    /**
     * creates and initiates the combo box
     */
    private void createAndInitiateComboBox()
    {
        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        cmbCategories = new JComboBox(controller.getCategoriesValues());
        cmbCategories.setSelectedIndex(0);
        cmbCategories.setBounds(140,310,300,30);
        cmbCategories.setFont(newFont.deriveFont(15.0F));
        cmbCategories.setPreferredSize(new Dimension(300,30));
        this.add(cmbCategories);
        cmbCategories.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                Object obj = cmbCategories.getSelectedItem();
                int index = cmbCategories.getSelectedIndex();
            }
        });
    }
}
