package Client.Controller;

import Client.View.main.MainFrame;
import Client.Model.Model;

public class Controller
{
    private Model model;
    private MainFrame view;

    public Controller() {
        final MainFrame view = new MainFrame(this);
        this.view = view;
    }

    public void homePage() {
        view.clearJFrame(this);
        view.updateJFrameHome(this);
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

    public void minaSidorClicked() {
        view.clearJFrame(this);
        view.updateJFrameMinaSidor(this);
    }

    public void skapaAnnonsClicked() {

    }
}