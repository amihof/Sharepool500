package Client.View.MinaSidorPage;

import Client.View.Main.RoundedPanelExample;
import Shared.Annons;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * the panel that shows your published ads
 * @Author Amidala Hoffmén
 */
public class MinaAnnonserPage extends JPanel implements ListSelectionListener {
    private final Color redColor;
    private final Color greenColor;

    private final Font newFont;

    private final JPanel aktivaAnnonserPanel = new JPanel();
    private String[] nameList;

    private final int width;
    private JList list;

    public MinaAnnonserPage(int width, int height){
        this.setLayout(null);

        Color backgroundColor = new Color(245, 221, 204);
        this.redColor = new Color(236, 66, 66);
        this.greenColor = new Color (167, 203, 156, 255);

        Font myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);

        this.width = width;

        this.setBackground(backgroundColor);
        this.setSize(width, height);
        this.setLocation(250, 100);

        setUp();
    }

    private void setUp() {
        JLabel minaAnnonserLabel = new JLabel("Mina annonser");
        minaAnnonserLabel.setLocation(30, 30);
        minaAnnonserLabel.setSize(300, 50);
        minaAnnonserLabel.setFont(newFont.deriveFont(40.0F));
        minaAnnonserLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(minaAnnonserLabel);

        aktivaAnnonserPanel.setSize(width-310, 400);
        aktivaAnnonserPanel.setBounds(30,100,width-310,400);
        aktivaAnnonserPanel.setBackground(Color.WHITE);
        this.add(aktivaAnnonserPanel);

        JButton seeAnnonsButton = new RoundedPanelExample.CircleBtn("Redigera annons");
        seeAnnonsButton.setBackground(greenColor);
        seeAnnonsButton.setBorderPainted(false);
        seeAnnonsButton.setLocation(30, 520);
        seeAnnonsButton.setSize(200, 50);
        seeAnnonsButton.setFont(newFont.deriveFont(15.0f));
        seeAnnonsButton.setHorizontalAlignment(0);
        this.add(seeAnnonsButton);

        JButton deleteAnnonsButton = new RoundedPanelExample.CircleBtn("Radera annons");
        deleteAnnonsButton.setBackground(redColor);
        deleteAnnonsButton.setBorderPainted(false);
        deleteAnnonsButton.setLocation(250, 520);
        deleteAnnonsButton.setSize(200, 50);
        deleteAnnonsButton.setFont(newFont.deriveFont(15.0f));
        deleteAnnonsButton.setHorizontalAlignment(0);
        this.add(deleteAnnonsButton);

    }

    public void setUpAnnonser(){
        list = new JList(nameList);
        list.setCellRenderer(new IconListRenderer());

        list.addListSelectionListener(this);

        list.setFixedCellHeight(100);
        list.setFixedCellWidth(width-328);

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(width-310, 400));
        scroll.setBackground(Color.WHITE);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        this.aktivaAnnonserPanel.add(scroll);
        this.aktivaAnnonserPanel.setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        list.getSelectedValue();

    }

    public static class IconListRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvetica", Font.BOLD, 20);

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            label.setBorder(BorderFactory.createMatteBorder(0,
                    0, 2, 0, new Color (167, 203, 156, 255)));

            if (isSelected) {
                setBackground(Color.LIGHT_GRAY);
                setForeground(Color.BLACK);
            }

            return label;
        }
    }

    public void addNewAnnons(ArrayList<Annons> annonsList) {
        ArrayList<String> nameListAnnonser = new ArrayList<>();

        for (Annons a : annonsList)
        {
            nameListAnnonser.add(a.getProductName());
        }

        this.nameList = nameListAnnonser.toArray(new String[0]);

        setUpAnnonser();
        aktivaAnnonserPanel.setSize(width-310, 400);
        aktivaAnnonserPanel.setLocation(0,100);
        aktivaAnnonserPanel.setBackground(Color.WHITE);
        this.add(aktivaAnnonserPanel);
    }


}
