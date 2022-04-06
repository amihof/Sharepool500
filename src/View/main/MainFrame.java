package View.main;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * the main frame
 */
public class MainFrame {
    private MainPanel mainPanel;
    private int width;
    private int height;
    private JFrame frame;
    private Controller controller;

    /**
     * a method that sets up the frame
     * @param controller is needed for the frame to function
     */
    public MainFrame(Controller controller){
        this.controller = controller;
        frame = new JFrame();
        height = 1080;
        width = 1920;
        mainPanel = new MainPanel(width, height, controller);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.add(this.mainPanel);
    }


}
