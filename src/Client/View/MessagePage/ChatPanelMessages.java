package Client.View.MessagePage;

import Client.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatPanelMessages extends JPanel {
    private final JPanel contactsView = new JPanel();
    private int width;
    private int height;
    private Controller controller;
    private JTextArea chatArea;
    private JScrollPane scroll;
    private JTextField messageTextField;
    private JPanel test;


    public ChatPanelMessages(int width, int height, Controller controller){
        this.setLayout(null);
        this.controller = controller;
        final Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, height-100);
        this.setLocation(250, 100);

        test = new JPanel();
        test.setLayout(null);
        test.setSize(width-60, 430);
        test.setBackground(Color.WHITE);
        test.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        test.setLocation(30, 120);

        this.add(test);

        this.setUp();
    }

    public void setUp(){
        chatArea = new JTextArea(20, 30);
        scroll = new JScrollPane(chatArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        chatArea.setLayout(new BorderLayout());
        chatArea.setSize(500, 555);
        chatArea.setFont(new Font("Serif", Font.PLAIN, 15));
        chatArea.setLocation(30, 60);
        chatArea.setLineWrap(true);
        chatArea.setEditable(false);

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(chatArea);
        scroll.setLocation(0, 0);
        scroll.setSize(width, height - 70);
        scroll.setVisible(true);
        test.add(scroll);

        messageTextField = new JTextField("Aa");
        messageTextField.setSize(width - 40, 35);
        messageTextField.setLocation(35, height - 65);
        messageTextField.setFont(messageTextField.getFont().deriveFont(15.0F));
        messageTextField.setHorizontalAlignment(JLabel.LEFT);
        messageTextField.setBackground(new Color(236, 236, 236));
        messageTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        messageTextField.requestFocusInWindow();
        messageTextField.setVisible(true);
        test.add(messageTextField);
        messageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                if (messageTextField.getText().length() < 1) {
                    // do nothing
                } else {
                    chatArea.append("<" + "username" + ":" + dtf.format(now) + ">:  " + messageTextField.getText()
                            + "\n");
                    messageTextField.setText("");
                }
                messageTextField.requestFocusInWindow();
            }
        });

        test.setVisible(true);


    }
}
