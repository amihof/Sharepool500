package View.HowItWorks;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import Controller.Controller;
import javax.swing.JPanel;

public class SFDPanel extends JPanel
{
    private Controller controller;
    private JLabel titleText;
    private JLabel hyraUtTitle;
    private JLabel hyrautText;

    public SFDPanel(final int width, final int height, final Controller controller) {
        this.setLayout(null);
        this.controller = controller;
        final Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, height);
        this.setLocation(0, 100);
        this.setUp();
    }

    public void setUp() {
        final Font myFont = new Font("Shree Devanagari 714", 0, 18);
        final Font newFont = myFont.deriveFont(25.0f);
        (this.titleText = new JLabel("S\u00e5 fungerar det")).setLocation(50, 60);
        this.titleText.setSize(600, 100);
        this.titleText.setFont(newFont.deriveFont(40.0f));
        this.titleText.setHorizontalAlignment(0);
        this.add(this.titleText);
        (this.hyraUtTitle = new JLabel("Hyra ut")).setLocation(50, 100);
        this.hyraUtTitle.setSize(600, 100);
        this.hyraUtTitle.setFont(newFont.deriveFont(40.0f));
        this.hyraUtTitle.setHorizontalAlignment(0);
        this.add(this.hyraUtTitle);
        (this.hyrautText = new JLabel(".... text .......")).setLocation(50, 140);
        this.hyrautText.setSize(600, 100);
        this.hyrautText.setFont(newFont.deriveFont(40.0f));
        this.hyrautText.setHorizontalAlignment(0);
        this.add(this.hyrautText);
    }
}