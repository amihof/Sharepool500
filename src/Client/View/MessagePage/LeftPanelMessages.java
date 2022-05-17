package Client.View.MessagePage;

import Client.Controller.Controller;
import Delad.Chat;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class LeftPanelMessages extends JPanel implements ListSelectionListener {
    private int width;
    private int height;
    private Controller controller;
    private Color backgroundColor;
    private Color greenColor;
    private Color orangeColor;
    private Font myFont;
    private Font newFont;
    private Font myFontBold;
    private Font newFontBold;
    private JLabel meddelandenLabel;
    private JPanel contactsPanel = new JPanel();
    private String[] nameList;
    private ArrayList<Chat> chatList;

    private JList list;

    private ArrayList<Chat> contactsList;

    public LeftPanelMessages(int width, int height, Controller controller){
        this.setLayout(null);
        this.controller = controller;

        this.backgroundColor = new Color(245, 221, 204);
        this.greenColor = new Color (167, 203, 156, 255);
        this.orangeColor = new Color (225, 143, 107);

        myFont = new Font("Shree Devanagari 714", Font.PLAIN, 18);
        newFont = myFont.deriveFont(25.0F);
        myFontBold = new Font("Shree Devanagari 714", Font.BOLD, 18);
        newFontBold = myFontBold.deriveFont(25.0F);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setSize(width, height);
        this.setLocation(0, 100);
        setUp();
    }

    public void setUp(){
        meddelandenLabel = new JLabel("Meddelanden");
        meddelandenLabel.setLocation(0, 0);
        meddelandenLabel.setSize(250, 100);
        meddelandenLabel.setFont(newFontBold.deriveFont(25.0f));
        meddelandenLabel.setForeground(greenColor);
        meddelandenLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(meddelandenLabel);

        ArrayList<String> nameListChat = new ArrayList<>();

        nameListChat.add("email");
        nameListChat.add("testtest");
        nameListChat.add("email3");
        nameListChat.add("email");
        nameListChat.add("testtestttt");
        nameListChat.add("email32323");
        nameListChat.add("email21321");
        nameListChat.add("testt41423est");
        nameListChat.add("emai4324235453l3");
        nameListChat.add("emai143565l");
        nameListChat.add("test465432test");
        nameListChat.add("emai324567l3");
        this.nameList = nameListChat.toArray(new String[0]);

        setUpContacts();
        contactsPanel.setSize(250, 900);
        contactsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contactsPanel.setLocation(0,100);
        contactsPanel.setBackground(Color.WHITE);
        this.add(contactsPanel,BorderLayout.CENTER);

    }


    public void setUpContacts(){
        list = new JList(nameList);
        list.setCellRenderer(new IconListRenderer());

        list.addListSelectionListener(this);

        list.setFixedCellHeight(100);
        list.setFixedCellWidth(250);

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(250, 1000));
        scroll.setBackground(Color.WHITE);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        this.contactsPanel.add(scroll);
        this.contactsPanel.setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        list.getSelectedValue();
        System.out.println(list.getSelectedValue());

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
            label.setBorder(BorderFactory.createMatteBorder(5,
                    0, 5, 0, new Color (167, 203, 156, 255)));
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

        setUpContacts();
        contactsPanel.setSize(250, 1000);
        contactsPanel.setLocation(0,70);
        contactsPanel.setBackground(Color.WHITE);
        this.add(contactsPanel);
    }
}
