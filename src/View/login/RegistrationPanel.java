package View.login;


import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class RegistrationPanel extends JPanel{

    private RegistrationPanel thisPanel;

    private JLabel lblTitle, jLabel;
    private JLabel imageIcon;
    private JTextField jTextField;

    private Controller controller;
    private LoginFrame frame;

    private int width;
    private int height;

    public RegistrationPanel(int width, int height, Controller controller, LoginFrame frame) {
        super(null);
        thisPanel = this;
        this.frame = frame;
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.setMinimumSize(new Dimension(width, height));
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(95,75,139,220));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setUp();

    }

    private void setUp() {
        lblTitle = new JLabel("New user? Register");
        lblTitle.setFont(new Font("serif", Font.BOLD, 24));
        lblTitle.setSize(120, 24);
        lblTitle.setOpaque(false);
        this.add(lblTitle, CENTER_ALIGNMENT);


    }

    private void addInputField(String filepath, String lblText, String fieldText){

        Box box = Box.createHorizontalBox();
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                box.setPreferredSize(new Dimension(width, 20));

                Image image = new ImageIcon(filepath).getImage();
                image = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                imageIcon = new JLabel(new ImageIcon(image));
                imageIcon.setSize(20,20);
                box.add(imageIcon);

                jLabel = new JLabel(lblText);
                jLabel.setFont(new Font("serif", Font.BOLD, 18));
                jLabel.setSize(100, 20);
                box.add(jLabel);

                jTextField = new JTextField(fieldText);
                jTextField.setSize(280, 20);
                box.add(jTextField);

                return null;
            }

            @Override
            protected void done() {
                thisPanel.add(box);
                thisPanel.add(Box.createRigidArea(new Dimension(0, 10)));

                thisPanel.revalidate();
                thisPanel.repaint();
                thisPanel.frame.revalidate();
            }
        };
        worker.execute();
    }

}
