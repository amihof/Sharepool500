package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.Main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * The panel that lets the user search for an annons
 * @Author Amidala Hoffmén
 */
public class AnnonsPanel extends JPanel {
    private JTextField search;
    private final JPanel thisPanel;
    private final Color backgroundColor;
    private final Font newFont;

    /**
     * the constructor that sets the size and location of the panel
     * @param width the width of the panel
     */
    public AnnonsPanel(int width){
        this.setLayout(null);

        backgroundColor = new Color(245, 221, 204);
        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);

        this.thisPanel = new JPanel();
        this.setBackground(backgroundColor);
        this.setSize(width, 150);
        this.setLocation(0, 100);

        setUp();
    }

    /**
     * setting up the panel
     */
    public void setUp(){
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

        JLabel typAvAnnonsLabel = new JLabel("Typ av annons: ");
        typAvAnnonsLabel.setLocation(30, 60);
        typAvAnnonsLabel.setSize(300, 50);
        typAvAnnonsLabel.setFont(newFont.deriveFont(20.0F));
        typAvAnnonsLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(typAvAnnonsLabel);

        JLabel sortAfterText = new JLabel("Sortera efter");
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
        buttonCircle.setBackground(backgroundColor);

        buttonCircle2.setText("Sökes");
        buttonCircle2.setFont(newFont.deriveFont(20.0F));
        buttonCircle2.setBackground(backgroundColor);

        this.add(buttonCircle);
        this.add(buttonCircle2);

        thisPanel.setOpaque(false);
        thisPanel.setBackground(Color.DARK_GRAY);
        thisPanel.setLayout(new BoxLayout(thisPanel, BoxLayout.Y_AXIS));
        thisPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    }

    public void updateSearchTextField(String newSearch){
        search.setText(newSearch);
    }

}
