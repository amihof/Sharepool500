package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.OneAnnons.MainPanelOneAnnons;
import Delad.Annons;

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
    private String[] nameList;

    private ArrayList<Annons> searchedAnnonsList;

    private MainPanelOneAnnons mainPanelOneAnnons;

    private String productName;
    private String productDescription;
    private String productCategory;
    private String productPublisher;

    private MainFrame view;


    public DisplayAnnonser(int width, int height, Controller controller, MainFrame view){
        this.setLayout(null);
        backgroundColor = new Color(245, 221, 204);
        this.view = view;
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        this.setSize(width, height);
        setLocation(0, 250);

    }

    public void setUp(){
        imageMap = createImageMap(nameList);
        list = new JList(nameList);
        list.setCellRenderer(new IconListRenderer());

        list.addListSelectionListener(this);

        list.setFixedCellHeight(220);
        list.setFixedCellWidth(width-60);

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(width, 430));
        scroll.setBackground(backgroundColor);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        this.annonserView.add(scroll);
        this.annonserView.setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        list.getSelectedValue();
        System.out.println(list.getSelectedValue());
        productName = searchedAnnonsList.get(list.getSelectedIndex()).getProductName();
        productCategory = String.valueOf(searchedAnnonsList.get(list.getSelectedIndex()).getProductCategory());
        productDescription = searchedAnnonsList.get(list.getSelectedIndex()).getProductDescription();
        productPublisher = searchedAnnonsList.get(list.getSelectedIndex()).getPublisher().getUsername();
        mainPanelOneAnnons = new MainPanelOneAnnons(width+40, height, productName, productCategory, productDescription, productPublisher, view);
        view.displayOneAnnons(mainPanelOneAnnons);

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

    public void addNewAnnonsTest(ArrayList<Annons> searchedAnnonsList){
        ArrayList<String> nameListAnnonser = new ArrayList<>();
        this.searchedAnnonsList = searchedAnnonsList;

        for (Annons a : searchedAnnonsList)
        {
            nameListAnnonser.add(a.getProductName());
        }

        this.nameList = nameListAnnonser.toArray(new String[0]);
        System.out.println(nameListAnnonser);

        for (int i = 0; i < nameList.length; i++){
            System.out.println(nameList[i]);
        }

        setUp();
        annonserView.setSize(width, 1000);
        annonserView.setLocation(0,0);
        annonserView.setBackground(backgroundColor);
        this.add(annonserView,BorderLayout.CENTER);
    }

}
