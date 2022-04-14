
package Client.View.SkapaAnnons;


import Client.Controller.Controller;
import Client.View.main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SkapaAnnonsPanel extends JPanel {
    private Controller controller;
    private JLabel skapaAnnonsLabel;
    private JLabel kategoriLabel;
    private JLabel rubrikLabel;
    private JLabel sokesLabel;
    private JLabel beskrivningLabel;
    private JComboBox cmbCategories;
    private JTextField rubrikTextField;
    private JTextField beskrivningTextField;

    public SkapaAnnonsPanel(int width, int height, Controller controller) {
        this.setLayout(null);
        this.controller = controller;
        Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, height);
        this.setLocation(0, 100);

        this.setUp();
        createAndInitiateComboBox();
    }

    private void setUp() {

        ButtonGroup G = new ButtonGroup();
        JRadioButton j1 = new JRadioButton();
        JRadioButton j2 = new JRadioButton();
        G.add(j1);
        G.add(j2);

        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        Font myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        Font newFontBold = myFontBold.deriveFont(25.0F);

        skapaAnnonsLabel = new JLabel("Skapa annons");
        skapaAnnonsLabel.setLocation(50, 60);
        skapaAnnonsLabel.setSize(600, 100);
        skapaAnnonsLabel.setFont(newFont.deriveFont(40.0F));
        skapaAnnonsLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(skapaAnnonsLabel);

        kategoriLabel = new JLabel("Kategori");
        kategoriLabel.setLocation(50, 140);
        kategoriLabel.setSize(300, 50);
        kategoriLabel.setFont(newFontBold.deriveFont(22.0F));
        kategoriLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(kategoriLabel);

        rubrikLabel = new JLabel("Rubrik");
        rubrikLabel.setLocation(50, 270);
        rubrikLabel.setSize(300, 50);
        rubrikLabel.setFont(newFontBold.deriveFont(22.0F));
        rubrikLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(rubrikLabel);

        j1.setBounds(50,220,100,50);
        j2.setBounds(200,220,100,50);

        j1.setText("Hyrs ut");
        j1.setFont(newFont.deriveFont(20.0F));

        j2.setText("Sökes");
        j2.setFont(newFont.deriveFont(20.0F));

        this.add(j1);
        this.add(j2);

        rubrikTextField = new RoundedPanelExample.RoundedTextField(20);
        rubrikTextField.setLocation(50, 310);
        rubrikTextField.setSize(1000, 40);
        rubrikTextField.setFont(newFont.deriveFont(15.0f));
        rubrikTextField.setHorizontalAlignment(2);
        this.add(rubrikTextField);

        beskrivningLabel = new JLabel("Beskrivning");
        beskrivningLabel.setLocation(50, 370);
        beskrivningLabel.setSize(300, 50);
        beskrivningLabel.setFont(newFontBold.deriveFont(22.0F));
        beskrivningLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(beskrivningLabel);

        beskrivningTextField = new RoundedPanelExample.RoundedTextField(20);
        beskrivningTextField.setLocation(50, 410);
        beskrivningTextField.setSize(1000, 200);
        beskrivningTextField.setFont(newFont.deriveFont(15.0f));
        beskrivningTextField.setHorizontalAlignment(2);
        this.add(beskrivningTextField);

    }

    private void createAndInitiateComboBox()
    {
        cmbCategories = new JComboBox(controller.getCategoriesValues());
        cmbCategories.setSelectedIndex(0);
        cmbCategories.setBounds(50,170,200,70);
        cmbCategories.setSize(200,50);
        cmbCategories.setPreferredSize(new Dimension(500,50));
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
