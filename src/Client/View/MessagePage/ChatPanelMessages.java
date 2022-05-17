package Client.View.MessagePage;

import Client.Controller.Controller;
import Shared.Annons;
import Shared.Chat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChatPanelMessages extends JPanel {
    private final JPanel contactsView = new JPanel();
    private int width;
    private int height;
    private Controller controller;

    public ChatPanelMessages(int width, int height, Controller controller){
        this.setLayout(null);
        this.controller = controller;
        final Color myNewColor = new Color(245, 221, 204);
        this.setBackground(myNewColor);
        this.setSize(width, height-100);
        this.setLocation(250, 100);
        this.setUp();
    }

    public void setUp(){


    }
}
