package Controller;

import javax.swing.ImageIcon;
import View.main.MainFrame;
import View.login.LoginFrame;
import Model.Model;

public class Controller
{
    private Model model;
    private LoginFrame loginFrame;
    private MainFrame view;

    public Controller() {
        final MainFrame view = new MainFrame(this);
        this.view = view;
    }

    public void homePage() {
        view.clearJFrame(this);
        view.updateJFrameHome(this);
    }

    public void setupLogin() {
        this.loginFrame = new LoginFrame(this);
    }

    public void login(final String str, final ImageIcon icon) {
        this.model = new Model();
    }

    public void searchClicked() {
        view.clearJFrame(this);
        view.updateJFrameAnnons(this);
    }

    public void loginClicked() {
        this.view.loginButtonClicked(this);
    }

    public void saFungerarDetClicked() {
        this.view.clearJFrame(this);
        view.updateJFrame(this);
    }
}