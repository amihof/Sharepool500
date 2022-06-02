package Client.View.MessagePage;

import Client.Controller.Controller;
import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;
import Client.View.SkapaAnnons.SkapaAnnonsPanel;

import javax.swing.*;
import java.awt.*;

/**
 * the main panel for messages.
 * @Author Amidala Hoffmén
 */
public class MainPanelMessages extends JPanel {
    private int width;
    private int height;
    private Controller controller;
    private Boolean loggedIn;
    private MainFrame view;
    private LeftPanelMessages leftPanelMessages;
    private ChatPanelMessages chatPanelMessages;
    private TopPanel topPanel;
    private Color backgroundColor;
    private Color greenColor;
    private Color orangeColor;

    public MainPanelMessages(int width, int height, Controller controller, Boolean loggedIn, MainFrame view){
        super(null);

        this.view = view;
        this.loggedIn = loggedIn;
        this.width = width;
        this.height = height;
        this.setSize(width, height);


        chatPanelMessages = new ChatPanelMessages(width-250, height-100, controller);
        this.add(chatPanelMessages);

        leftPanelMessages = new LeftPanelMessages(250, height-100, controller);
        this.add(leftPanelMessages);

        topPanel = new TopPanel(width, height, "Messages", loggedIn, view);
        this.add(topPanel);

    }

    public LeftPanelMessages getLeftPanelMessages(){
        return leftPanelMessages;
    }
}
