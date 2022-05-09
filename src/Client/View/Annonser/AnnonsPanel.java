package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.Main.CircleButton;
import Client.View.Main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;

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
    private JPanel thisPanel;
    private JFrame frame;

    private static HashMap<Integer, Box> msgTracker = new HashMap<>();


    public AnnonsPanel(int width, int height, Controller controller, JFrame frame){
        this.setLayout(null);
        this.thisPanel = new JPanel();
        this.controller = controller;
        Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, 150);
        this.setLocation(0, 100);

        RoundedPanelExample roundedPanelExample = new RoundedPanelExample();
        CircleButton circleButton = new CircleButton("");
        this.circleButton = circleButton;
        this.roundedPanelExample = roundedPanelExample;

        setUp();
    }

    public void setUp(){

        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        Color myNewColor = new Color(245, 221, 204);
        Color greenColor = new Color (167, 203, 156, 255);

        search = new RoundedPanelExample.RoundedTextField(20);
        search.setText("Vad vill du hyra?");
        search.setLocation(30, 20);
        search.setSize(600, 40);
        search.setFont(newFont.deriveFont(20.0F));
        search.setHorizontalAlignment(JLabel.LEFT);
        search.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("Vad vill du hyra?")){
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

        ButtonGroup G = new ButtonGroup();
        JRadioButton buttonCircle = new JRadioButton();
        JRadioButton buttonCircle2 = new JRadioButton();
        G.add(buttonCircle);
        G.add(buttonCircle2);

        buttonCircle.setBounds(400,62,100,50);
        buttonCircle2.setBounds(200,62,100,50);

        buttonCircle.setText("Hyrs ut");
        buttonCircle.setFont(newFont.deriveFont(20.0F));
        buttonCircle.setBackground(myNewColor);

        buttonCircle2.setText("Sökes");
        buttonCircle2.setFont(newFont.deriveFont(20.0F));
        buttonCircle2.setBackground(myNewColor);

        this.add(buttonCircle);
        this.add(buttonCircle2);

        thisPanel.setOpaque(false);
        thisPanel.setMinimumSize(new Dimension(width, height));
        thisPanel.setBackground(Color.DARK_GRAY);
        thisPanel.setLayout(new BoxLayout(thisPanel, BoxLayout.Y_AXIS));
        thisPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    }

    public void updateSearchTextField(String newSearch){
        search.setText(newSearch);
    }

}
