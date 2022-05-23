package Client.View.MinaSidorPage;

import Client.View.Main.MainFrame;
import Client.View.Main.RoundedPanelExample;
import Shared.Chat;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class MinaAnnonserPage extends JPanel implements ListSelectionListener {
    private Color backgroundColor;
    private Color greenColor;
    private Color orangeColor;
    private JPanel cards;

    private Font myFont;
    private Font myFontBold;
    private Font newFont;
    private Font newFontBold;
    private JButton aktivaAnnonser;
    private JButton gamlaAnnonser;
    private MainFrame view;
    private JLabel minaAnnonserLabel;

    private JPanel aktivaAnnonserPanel = new JPanel();
    private String[] nameList;
    private ArrayList<Chat> chatList;
    private JList list;

    private int width;

    private JPanel annonserPanels = new JPanel();

    public MinaAnnonserPage(int width, int height, MainFrame view){
        this.setLayout(null);

        this.backgroundColor = new Color(245, 221, 204);
        this.greenColor = new Color (167, 203, 156, 255);
        this.orangeColor = new Color (225, 143, 107);

        myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);
        myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        newFontBold = myFontBold.deriveFont(25.0F);

        this.view = view;
        this.width = width;

        CardLayout cardLayout = new CardLayout();
        annonserPanels.setLayout(cardLayout);
        annonserPanels.setBounds(30,160,width-310,600);
        annonserPanels.setBackground(Color.RED);
        this.add(annonserPanels);
        cards = new JPanel(cardLayout);

        annonserPanels.add(cards);

        this.setBackground(backgroundColor);
        this.setSize(width, height);
        this.setLocation(250, 100);

        setUp();

        cardLayout.show(cards, "AktivaAnnonser");
    }

    private void setUp() {
        minaAnnonserLabel = new JLabel("Mina annonser");
        minaAnnonserLabel.setLocation(30, 30);
        minaAnnonserLabel.setSize(300, 50);
        minaAnnonserLabel.setFont(newFont.deriveFont(40.0F));
        minaAnnonserLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(minaAnnonserLabel);

        aktivaAnnonser = new RoundedPanelExample.CircleBtn("Aktiva annonser");
        aktivaAnnonser.setBackground(orangeColor);
        aktivaAnnonser.setBorderPainted(false);
        aktivaAnnonser.setLocation(30, 100);
        aktivaAnnonser.setSize(200, 40);
        aktivaAnnonser.setHorizontalAlignment(JLabel.CENTER);
        aktivaAnnonser.setEnabled(false);
        aktivaAnnonser.addActionListener(l -> gamlaAnnonser.setEnabled(true));
        aktivaAnnonser.addActionListener(l -> aktivaAnnonser.setEnabled(false));
        aktivaAnnonser.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
        this.add(aktivaAnnonser);

        gamlaAnnonser = new RoundedPanelExample.CircleBtn("Gamla annonser");
        gamlaAnnonser.setBackground(orangeColor);
        gamlaAnnonser.setBorderPainted(false);
        gamlaAnnonser.setLocation(330, 100);
        gamlaAnnonser.setSize(200, 40);
        gamlaAnnonser.setHorizontalAlignment(JLabel.CENTER);
        gamlaAnnonser.addActionListener(l -> aktivaAnnonser.setEnabled(true));
        gamlaAnnonser.addActionListener(l -> gamlaAnnonser.setEnabled(false));
        gamlaAnnonser.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20).deriveFont(17.0F));
        this.add(gamlaAnnonser);

        ArrayList<String> nameListChat = new ArrayList<>();

        nameListChat.add("email");
        nameListChat.add("testtest");

        this.nameList = nameListChat.toArray(new String[0]);

        setUpAnnonser();
        aktivaAnnonserPanel.setSize(250, 500);
        aktivaAnnonserPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        aktivaAnnonserPanel.setLocation(0,90);
        aktivaAnnonserPanel.setBackground(Color.WHITE);

        cards.add(aktivaAnnonserPanel, "AktivaAnnonser");

    }

    public void setUpAnnonser(){
        list = new JList(nameList);
        list.setCellRenderer(new IconListRenderer());

        list.addListSelectionListener(this);

        list.setFixedCellHeight(100);
        list.setFixedCellWidth(width-312);

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(width-310, 600));
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

    public void addNewChat(ArrayList<Chat> chatList) {
        ArrayList<String> nameListChat = new ArrayList<>();
        this.chatList = chatList;

        for (Chat a : chatList)
        {
            nameListChat.add(a.getRequester_email());
        }

        nameListChat.add("email");
        nameListChat.add("testtest");
        nameListChat.add("email3");

        this.nameList = nameListChat.toArray(new String[0]);

        setUpAnnonser();
        aktivaAnnonserPanel.setSize(width-310, 600);
        aktivaAnnonserPanel.setLocation(0,70);
        aktivaAnnonserPanel.setBackground(Color.WHITE);
        cards.add(aktivaAnnonserPanel, "AktivaAnnonser");
    }

}
