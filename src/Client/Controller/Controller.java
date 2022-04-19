package Client.Controller;

import Client.Model.*;
import Client.View.main.MainFrame;
import Delad.Annons;
import Delad.Category;
import Delad.User;

public class Controller
{
    private MainFrame view;
    private String password;
    private String email;
    private String userName;
    private RequestFactory requestFactory;
    private Client client;

    private boolean loggedIn;

    private User user;

    private Annons annons;

    public Controller() {
        loggedIn = false;
        MainFrame view = new MainFrame(this, loggedIn);
        this.view = view;
        System.out.println("view färdig");
        client = new Client(725,"127.0.0.1");
        System.out.println("client färdig");
        requestFactory = new RequestFactory(client);
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
        requestFactory.register(new User(userName, email, password));
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

    public void newAnnons(String productName, String productDescription, Category productCategory, String publisherEmail, Boolean renting) {

        annons = new Annons(productName, productDescription, productCategory, new User(publisherEmail), renting);

    }

    public void loggedInOrNot(boolean loggedIn){

    }

    public void login() {
        this.loggedIn = true;
        view.dispose();
        view = new MainFrame(this, loggedIn);
    }
}