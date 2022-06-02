package Client.View.MessagePage;

import Client.View.Main.MainFrame;
import Client.View.Main.TopPanel;

import javax.swing.*;

/**
 * the main panel for messages.
 * @Author Amidala Hoffmén
 */
public class MainPanelMessages extends JPanel {
    private final LeftPanelMessages leftPanelMessages;

    public MainPanelMessages(int width, int height, Boolean loggedIn, MainFrame view){
        super(null);

        this.setSize(width, height);


        ChatPanelMessages chatPanelMessages = new ChatPanelMessages(width - 250, height - 100);
        this.add(chatPanelMessages);

        leftPanelMessages = new LeftPanelMessages(250, height-100);
        this.add(leftPanelMessages);

        TopPanel topPanel = new TopPanel(width, height, "Messages", loggedIn, view);
        this.add(topPanel);

    }

    public LeftPanelMessages getLeftPanelMessages(){
        return leftPanelMessages;
    }
}
