package Client.View.Annonser;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.OneAnnons.MainPanelOneAnnons;
import Shared.Annons;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * this class is the panel that displays all the annonser that match the users search terms
 * @Author Amidala Hoffmén
 */
public class DisplayAnnonser extends JPanel implements ListSelectionListener {
    private final JPanel annonserView = new JPanel();
    private final int width;
    private final int height;
    private final Color backgroundColor;

    private static Map<String, ImageIcon> imageMap;
    private JList list;
    private String[] nameList;

    private ArrayList<Annons> searchedAnnonsList;

    private final MainFrame view;

    private boolean loggedIn;
    private Controller controller;

    /**
     * sets the bounds of the panel
     * @param width the width of the panel
     * @param height the height of the panel
     * @param view class variable so you can refer to that class
     */
    public DisplayAnnonser(int width, int height, MainFrame view, boolean loggedIn, Controller controller){
        this.setLayout(null);
        backgroundColor = new Color(245, 221, 204);
        this.view = view;
        this.width = width;
        this.height = height;
        this.controller = controller;
        this.loggedIn = loggedIn;
        this.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        this.setSize(width, height);
        setLocation(0, 250);

    }

    /**
     * setting up the panel
     */
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
        String productName = searchedAnnonsList.get(list.getSelectedIndex()).getProductName();
        String productCategory = String.valueOf(searchedAnnonsList.get(list.getSelectedIndex()).getProductCategory());
        String productDescription = searchedAnnonsList.get(list.getSelectedIndex()).getProductDescription();
        String productPublisher = searchedAnnonsList.get(list.getSelectedIndex()).getPublisher().getUsername();
        String productPublisherEmail = searchedAnnonsList.get(list.getSelectedIndex()).getPublisher().getEmail();
        int searchedAnnonsId = searchedAnnonsList.get(list.getSelectedIndex()).getAnnonsID();
        MainPanelOneAnnons mainPanelOneAnnons = new MainPanelOneAnnons(width + 40, height, productName, productCategory, productDescription, productPublisher, view, loggedIn, controller, searchedAnnonsId, productPublisherEmail);
        view.displayOneAnnons(mainPanelOneAnnons);

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
            label.setBorder(BorderFactory.createMatteBorder(0,
                    0, 15, 0, new Color(245, 221, 204)));
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

    public void addNewAnnons(ArrayList<Annons> searchedAnnonsList){
        ArrayList<String> nameListAnnonser = new ArrayList<>();
        this.searchedAnnonsList = searchedAnnonsList;

        for (Annons a : searchedAnnonsList)
        {
            nameListAnnonser.add(a.getProductName());
        }

        this.nameList = nameListAnnonser.toArray(new String[0]);

        setUp();
        annonserView.setSize(width, 500);
        annonserView.setLocation(0,0);
        annonserView.setBackground(backgroundColor);
        this.add(annonserView,BorderLayout.CENTER);
    }

}
