package Client.View.SkapaAnnons;


import Client.Controller.Controller;
import Client.View.Main.RoundedPanelExample;
import Delad.Category;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import static java.awt.Color.black;

public class SkapaAnnonsPanel extends JPanel implements ActionListener {
    private Controller controller;
    private JLabel skapaAnnonsLabel;
    private JLabel kategoriLabel;
    private JLabel rubrikLabel;
    private JLabel sokesLabel;
    private JLabel beskrivningLabel;
    private JComboBox cmbCategories;
    private JTextField rubrikTextField;
    private JTextArea beskrivningTextField;
    private JButton postAnnons;
    private JButton uploadPic;
    private JLabel picLabel = new JLabel();
    private ImageIcon clientPicture;
    private JRadioButton j1;
    private JRadioButton j2;
    private ButtonGroup G;
    private String radioButtonText = null;

    public SkapaAnnonsPanel(int width, int height, Controller controller) {
        this.setLayout(null);
        this.controller = controller;
        Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, height);
        this.setLocation(0, 100);

        this.setUp();
        createAndInitiateComboBox();
        addActionEvent();
    }

    private void setUp() {

        Color myNewColor = new Color (225, 143, 107);

        Color backgroundColor = new Color(245, 221, 204);

        Color greenColor = new Color (167, 203, 156, 255);

        G = new ButtonGroup();
        j1 = new JRadioButton();
        j2 = new JRadioButton();
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
        j1.setBackground(backgroundColor);
        j2.setBackground(backgroundColor);

        j1.setText("Hyrs ut");
        j2.setActionCommand("Hyrs ut");
        j1.setFont(newFont.deriveFont(20.0F));

        j2.setText("Sökes");
        j2.setActionCommand("Sökes");
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

        beskrivningTextField = new RoundedPanelExample.RoundedTextArea("");
        beskrivningTextField.setLocation(50, 410);
        beskrivningTextField.setSize(1000, 200);
        beskrivningTextField.setFont(newFont.deriveFont(15.0f));
        beskrivningTextField.setLineWrap(true);
        this.add(beskrivningTextField);

        uploadPic = new RoundedPanelExample.CircleBtn("Ladda upp bild");
        uploadPic.setBackground(myNewColor);
        uploadPic.setBorderPainted(false);
        uploadPic.setBounds(50, 840, 200, 40);
        uploadPic.setHorizontalAlignment(JLabel.CENTER);
        uploadPic.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
        this.add(uploadPic);

        postAnnons = new RoundedPanelExample.CircleBtn("Skapa annons");
        postAnnons.setBackground(greenColor);
        postAnnons.setBorderPainted(false);
        postAnnons.setLocation(50, 930);
        postAnnons.setSize(230, 50);
        postAnnons.setHorizontalAlignment(JLabel.CENTER);
        postAnnons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Enumeration<AbstractButton> allRadioButton=G.getElements();
                while(allRadioButton.hasMoreElements())
                {
                    JRadioButton temp=(JRadioButton)allRadioButton.nextElement();
                    if(temp.isSelected())
                    {
                        radioButtonText = temp.getText();
                    }
                }
                controller.registerNewAnnons(rubrikTextField.getText(), beskrivningTextField.getText(), (Category) cmbCategories.getSelectedItem(), radioButtonText == "Hyrs ut" ? true : false);
            }
        });
        postAnnons.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
        this.add(postAnnons);

        this.add(uploadPic);

        picLabel.setBounds(50, 650, 150, 150);
        picLabel.setBorder(BorderFactory.createLineBorder(black));
        this.add(picLabel);

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

    public void addActionEvent() {
        uploadPic.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uploadPic) {
            JFileChooser fileChooser = new JFileChooser();
            File selectedFile = null;
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(getParent());
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();
                    BufferedImage picture = ImageIO.read(file);

                    //picLabel.setIcon(new ImageIcon(picture));
                    //add(picLabel);
                    selectedFile = fileChooser.getSelectedFile();
                    setPicture(selectedFile.getAbsolutePath());

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            }
            uploadPic.setEnabled(false);
        }

    }

    public ImageIcon setPicture(String fileName){
        clientPicture = new ImageIcon(fileName);
        Image clientImage = clientPicture.getImage();
        Image newClientImage = clientImage.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        clientPicture = new ImageIcon(newClientImage);
        picLabel.setIcon(clientPicture);
        add(picLabel);

        setClientPicture(clientPicture);

        return clientPicture;
    }

    public void setClientPicture(ImageIcon clientPicture){
        this.clientPicture = clientPicture;
    }

    public ImageIcon getClientPicture(){
        return clientPicture;
    }

}
