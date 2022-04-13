package main.java.Controller;

import main.java.View.main.MainFrame;

public class Controller
{
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