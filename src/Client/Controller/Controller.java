package Client.Controller;

import Client.Model.Category;
import Client.View.main.MainFrame;

public class Controller
{
    private MainFrame view;
    private String password;
    private String email;
    private String userName;

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

    public void andraUppgifterClicked() {
        view.andraUppgifterClicked(this);
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
        view.clearJFrame(this);
        view.updateJFrameSkapaAnnons(this);

    }

    public void registerNewUser(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }

    public Category[] getCategoriesValues() {
        return Category.values();
    }

    public void uploadAnnons() {
        view.addAnnons();
    }
}