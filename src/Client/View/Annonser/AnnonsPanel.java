package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.Main.CircleButton;
import Client.View.Main.RoundedPanelExample;

import javax.swing.*;
import java.awt.*;
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

    public synchronized void receive(String username, int msgId, String txt, final ImageIcon attachedPicture) {
        Box box = Box.createHorizontalBox();
        msgTracker.put(msgId, box);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                box.setMinimumSize(new Dimension(800, 150));
                box.setPreferredSize(new Dimension(900, 150));

                TextArea lblText = new TextArea("< " + username + " > : " + txt);
                lblText.setEditable(false);
                lblText.setFont(new Font("Serif", Font.PLAIN, 12));
                lblText.setMinimumSize(new Dimension(600, 20));
                lblText.setMaximumSize(new Dimension(600, 150));
                box.add(lblText, LEFT_ALIGNMENT);

                JLabel lblPic = new JLabel();
                lblPic.setMinimumSize(new Dimension(100, 150));
                lblPic.setMaximumSize(new Dimension(100, 150));
                if (attachedPicture != null) {
                    Image image = attachedPicture.getImage();
                    image = image.getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon attachedPictureEdited = new ImageIcon(image);
                    lblPic.setIcon(attachedPictureEdited);
                }
                box.add(lblPic, RIGHT_ALIGNMENT);
                return null;
            }

            @Override
            protected void done() {
                thisPanel.add(box);
                thisPanel.add(Box.createRigidArea(new Dimension(0, 5)));

                thisPanel.revalidate();
                thisPanel.repaint();
                frame.revalidate();
            }
        };
        worker.execute();
    }


}
