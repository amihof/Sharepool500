package Client.View.HowItWorks;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import Client.Controller.Controller;
import javax.swing.JPanel;

/**
 * The panel that shows when you click "Hur fungerar det"
 * @Author Amidala Hoffmén
 */
public class SFDPanel extends JPanel
{
    private Controller controller;

    private JLabel titleText;
    private JLabel hyraUtTitle;
    private JLabel hyrautText;
    private JLabel beskrivningText;

    /**
     * creating the panel that shows the information about how Sharepool works.
     * @param width the width of the panel
     * @param height the height of the panel
     * @param controller the controller variable so we can call methods in the controller
     */
    public SFDPanel(int width, int height, Controller controller) {
        this.setLayout(null);
        this.controller = controller;
        final Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, height);
        this.setLocation(0, 100);
        this.setUp();
    }

    /**
     * setting up the panel
     */
    public void setUp() {
        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        Font newFont = myFont.deriveFont(25.0F);

        Font myBoldFont = new Font("Shree Devanagari 714", Font.BOLD, 18);
        Font newBoldFont = myBoldFont.deriveFont(25.0F);

        titleText = new JLabel("Så fungerar det");
        titleText.setLocation(50, 60);
        titleText.setSize(600, 100);
        titleText.setFont(newFont.deriveFont(40.0f));
        titleText.setHorizontalAlignment(JLabel.LEFT);
        this.add(this.titleText);

        beskrivningText = new JLabel("text........");
        beskrivningText.setLocation(50, 140);
        beskrivningText.setSize(600, 50);
        beskrivningText.setFont(newFont.deriveFont(20.0f));
        beskrivningText.setHorizontalAlignment(JLabel.LEFT);
        this.add(beskrivningText);

        hyraUtTitle = new JLabel("Hyra ut:");
        hyraUtTitle.setLocation(50, 190);
        hyraUtTitle.setSize(600, 50);
        hyraUtTitle.setFont(newBoldFont.deriveFont(20.0f));
        hyraUtTitle.setHorizontalAlignment(JLabel.LEFT);
        this.add(hyraUtTitle);

        hyrautText = new JLabel(".... text .......");
        hyrautText.setLocation(50, 240);
        hyrautText.setSize(600, 50);
        hyrautText.setFont(newFont.deriveFont(20.0f));
        hyrautText.setHorizontalAlignment(JLabel.LEFT);
        this.add(hyrautText);

    }
}