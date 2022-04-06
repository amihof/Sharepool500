package View.Annonser;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class AnnonsPanel extends JPanel {
    private int width;
    private int height;
    private Controller controller;

    public AnnonsPanel(int width, int height, Controller controller){
        this.setLayout(null);
        this.controller = controller;
        Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, height);
        this.setLocation(0, 100);
        this.setUp();
    }

    public void setUp(){

    }

}
