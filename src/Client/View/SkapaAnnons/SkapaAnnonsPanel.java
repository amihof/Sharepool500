package Client.View.SkapaAnnons;


import Client.Controller.Controller;
import Client.View.Main.RoundedPanelExample;
import Shared.Category;

import javax.swing.*;
import java.awt.*;

/**
 * the panel that you create your annons on
 * @Author Amidala Hoffmén
 */
public class SkapaAnnonsPanel extends JPanel {
    private final Controller controller;

    private JComboBox cmbCategories;
    private JTextField rubrikTextField;
    private JTextArea beskrivningTextField;

    public SkapaAnnonsPanel(int width, Controller controller) {
        this.setLayout(null);
        this.controller = controller;
        Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, 750);
        this.setLocation(0, 100);

        this.setUp();
        createAndInitiateComboBox();
        createAndInitiateComboBoxCities();
    }

    private void setUp() {

        Color greenColor = new Color (167, 203, 156, 255);

        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        Font myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        Font newFontBold = myFontBold.deriveFont(25.0F);

        JLabel skapaAnnonsLabel = new JLabel("Skapa annons");
        skapaAnnonsLabel.setLocation(50, 60);
        skapaAnnonsLabel.setSize(600, 100);
        skapaAnnonsLabel.setFont(newFont.deriveFont(40.0F));
        skapaAnnonsLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(skapaAnnonsLabel);

        JLabel kategoriLabel = new JLabel("Kategori");
        kategoriLabel.setLocation(50, 140);
        kategoriLabel.setSize(300, 50);
        kategoriLabel.setFont(newFontBold.deriveFont(22.0F));
        kategoriLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(kategoriLabel);

        JLabel rubrikLabel = new JLabel("Rubrik");
        rubrikLabel.setLocation(50, 270);
        rubrikLabel.setSize(300, 50);
        rubrikLabel.setFont(newFontBold.deriveFont(22.0F));
        rubrikLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(rubrikLabel);


        rubrikTextField = new RoundedPanelExample.RoundedTextField(20);
        rubrikTextField.setLocation(50, 310);
        rubrikTextField.setSize(1000, 40);
        rubrikTextField.setFont(newFont.deriveFont(15.0f));
        rubrikTextField.setHorizontalAlignment(2);
        this.add(rubrikTextField);

        JLabel beskrivningLabel = new JLabel("Beskrivning");
        beskrivningLabel.setLocation(50, 370);
        beskrivningLabel.setSize(300, 50);
        beskrivningLabel.setFont(newFontBold.deriveFont(22.0F));
        beskrivningLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(beskrivningLabel);

        beskrivningTextField = new RoundedPanelExample.RoundedTextArea("");
        beskrivningTextField.setLocation(50, 410);
        beskrivningTextField.setSize(1000, 200);
        beskrivningTextField.setFont(newFont.deriveFont(15.0f));
        beskrivningTextField.setLineWrap(true);
        this.add(beskrivningTextField);

        JButton postAnnons = new RoundedPanelExample.CircleBtn("Skapa annons");
        postAnnons.setBackground(greenColor);
        postAnnons.setBorderPainted(false);
        postAnnons.setLocation(50, 650);
        postAnnons.setSize(230, 50);
        postAnnons.setHorizontalAlignment(JLabel.CENTER);
        postAnnons.addActionListener(e -> {
            controller.registerNewAnnons(rubrikTextField.getText(), beskrivningTextField.getText(), (Category) cmbCategories.getSelectedItem(),true);
            System.out.println("test");
        });
        postAnnons.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
        this.add(postAnnons);

    }

    private void createAndInitiateComboBox()
    {
        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        cmbCategories = new JComboBox(controller.getCategoriesValues());
        cmbCategories.setSelectedIndex(0);
        cmbCategories.setBounds(50,170,200,50);
        cmbCategories.setFont(newFont.deriveFont(15.0F));
        cmbCategories.setPreferredSize(new Dimension(200,50));
                this.add(cmbCategories);
                cmbCategories.addItemListener(e -> {
        });
    }

    private void createAndInitiateComboBoxCities()
    {
        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        JComboBox cmbCities = new JComboBox(controller.getCitiesValues());
        cmbCities.setSelectedIndex(0);
        cmbCities.setBounds(50,210,200,50);
        cmbCities.setFont(newFont.deriveFont(15.0F));
        cmbCities.setPreferredSize(new Dimension(200,30));

        this.add(cmbCities);
        cmbCities.addItemListener(e -> {
        });
    }

}
