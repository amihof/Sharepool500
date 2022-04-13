package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.main.CircleButton;
import Client.View.main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AnnonsPanel extends JPanel {
    private int width;
    private int height;
    private Controller controller;
    private JTextField search;
    private JLabel typAvAnnonsLabel;
    private JLabel sortAfterText;
    private JButton buttonCircle2;
    private RoundedPanelExample roundedPanelExample;
    private CircleButton circleButton;
    private JButton buttonCircle;
    private JLabel searchLabel;
    private JLabel hyrsUtLabel;

    public AnnonsPanel(int width, int height, Controller controller){
        this.setLayout(null);
        this.controller = controller;
        Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, height);
        this.setLocation(0, 100);

        RoundedPanelExample roundedPanelExample = new RoundedPanelExample();
        CircleButton circleButton = new CircleButton("");
        this.circleButton = circleButton;
        this.roundedPanelExample = roundedPanelExample;

        this.setUp();
    }

    public void setUp(){

        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        Color myNewColor = new Color(245, 221, 204);
        Color greenColor = new Color (167, 203, 156, 255);

        //måste lägga till en actionlistener

        search = new RoundedPanelExample.RoundedTextField(20);
        search.setText("Vad vill du hyra?");
        search.setLocation(30, 20);
        search.setSize(600, 40);
        search.setFont(newFont.deriveFont(20.0F));
        search.setHorizontalAlignment(JLabel.LEFT);
        this.add(search);

        typAvAnnonsLabel = new JLabel("Typ av annons: ");
        typAvAnnonsLabel.setLocation(30, 60);
        typAvAnnonsLabel.setSize(300, 50);
        typAvAnnonsLabel.setFont(newFont.deriveFont(20.0F));
        typAvAnnonsLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(typAvAnnonsLabel);

        sortAfterText = new JLabel("Sortera efter");
        sortAfterText.setLocation(30, 90);
        sortAfterText.setSize(300, 50);
        sortAfterText.setFont(newFont.deriveFont(15.0F));
        sortAfterText.setHorizontalAlignment(JLabel.LEFT);
        this.add(sortAfterText);

        buttonCircle = new CircleButton("");
        buttonCircle.setBorderPainted(false);
        buttonCircle.setLocation(200, 72);
        buttonCircle.setSize(20, 20);
        buttonCircle.setFont(newFont.deriveFont(15.0F));
        buttonCircle.setHorizontalAlignment(JLabel.CENTER);
        buttonCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(buttonCircle);

        buttonCircle2 = new CircleButton("");
        buttonCircle2.setBorderPainted(false);
        buttonCircle2.setLocation(400, 72);
        buttonCircle2.setSize(20, 20);
        buttonCircle2.setFont(newFont.deriveFont(15.0F));
        buttonCircle2.setHorizontalAlignment(JLabel.CENTER);
        buttonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //buttonCircle.setDisabled();
            }
        });
        this.add(buttonCircle2);

        hyrsUtLabel = new JLabel("Hyrs ut");
        hyrsUtLabel.setLocation(240, 60);
        hyrsUtLabel.setSize(300, 50);
        hyrsUtLabel.setFont(newFont.deriveFont(20.0F));
        hyrsUtLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(hyrsUtLabel);

        searchLabel = new JLabel("Sökes");
        searchLabel.setLocation(440, 60);
        searchLabel.setSize(300, 50);
        searchLabel.setFont(newFont.deriveFont(20.0F));
        searchLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(searchLabel);

        JPanel testtest = new JPanel();
        OneAnnons annonser = new OneAnnons();
        testtest.add(annonser);
        testtest.setSize(500, 500);
        testtest.setLocation(255, 95);
        this.add(testtest);

    }

}
