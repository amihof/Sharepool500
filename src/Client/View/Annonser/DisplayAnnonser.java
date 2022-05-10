package Client.View.Annonser;

import Client.Controller.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DisplayAnnonser extends JPanel implements ListSelectionListener {
    private JPanel annonserView = new JPanel();
    private Controller controller;
    private int width;
    private int height;
    private Color backgroundColor;

    private static Map<String, ImageIcon> imageMap;
    private JList list;
    private String[] nameList = new String[2];


    public DisplayAnnonser(int width, int height, Controller controller){
        this.setLayout(null);
        backgroundColor = new Color(245, 221, 204);
        this.controller = controller;
        this.width = width-40;
        this.height = height;
        this.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        this.setSize(width, height);
        setLocation(0, 250);
        setUp();
        annonserView.setSize(width, 1000);
        annonserView.setLocation(0,0);
        annonserView.setBackground(backgroundColor);
        this.add(annonserView,BorderLayout.CENTER);

    }

    public void setUp(){
        //String[] nameList = {"Annons", "Annons2", "Annons3", "Annons4", "Annons5"};
        String[] nameList = getAnnonserList();
        imageMap = createImageMap(nameList);
        list = new JList(nameList);
        list.setCellRenderer(new IconListRenderer());

        list.addListSelectionListener(this);

        list.setFixedCellHeight(220);
        list.setFixedCellWidth(width-60);

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(width+40, 430));
        scroll.setBackground(backgroundColor);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        this.annonserView.add(scroll);
        this.annonserView.setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        list.getSelectedValue();
        System.out.println(list.getSelectedIndex());
        System.out.println(list.getSelectedValue());
        /*controller.setFriendName(String.valueOf(list.getSelectedValue()));
        controller.clearChat();*/

    }

    public static class IconListRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvetica", Font.BOLD, 20);

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setIcon(imageMap.get((String) value));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            label.setBorder(BorderFactory.createMatteBorder(15,
                    30, 15, 30, new Color(245, 221, 204)));
            return label;
        }
    }

    private Map<String, ImageIcon> createImageMap(String[] list) {
        Map<String, ImageIcon> map = new HashMap<>();
        try {

            ImageIcon imageIcon = new ImageIcon(new URL("http://i.stack.imgur.com/UvHN4.png")); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(250, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            map.put("Annons", new ImageIcon(newimg));

            imageIcon = new ImageIcon(new URL("http://i.stack.imgur.com/s89ON.png")); // load the image to a imageIcon
            image = imageIcon.getImage(); // transform it
            newimg = image.getScaledInstance(250, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            map.put("Annons2", new ImageIcon(newimg));

            imageIcon = new ImageIcon(new URL("http://i.stack.imgur.com/QEK2o.png")); // load the image to a imageIcon
            image = imageIcon.getImage(); // transform it
            newimg = image.getScaledInstance(250, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            map.put("Annons3", new ImageIcon(newimg));

            imageIcon = new ImageIcon(new URL("http://i.stack.imgur.com/f4T4l.png")); // load the image to a imageIcon
            image = imageIcon.getImage(); // transform it
            newimg = image.getScaledInstance(250, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            map.put("Annons4", new ImageIcon(newimg));


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return map;
    }

    /*public void addNewAnnonsImage(){
        Map<String, ImageIcon> map = new HashMap<>();
        try {

            ImageIcon imageIcon = new ImageIcon(new URL("http://i.stack.imgur.com/UvHN4.png")); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(250, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            map.put("Annons", new ImageIcon(newimg));


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

   /* public void addNewAnnons(String newAnnonsName){
        this.n += 1;
        newList.add(newAnnonsName);

        nameList =  newList.toArray(new String[0]);

    }*/

    public void addNewAnnonsTest(ArrayList<String> annonserSearchedFor){
        this.nameList = annonserSearchedFor.toArray(new String[annonserSearchedFor.size()]);
        System.out.println(nameList+"f");
    }

    private String[] getAnnonserList() {
        return nameList;
    }
}
