package Client.Controller;

import Client.Model.*;
import Client.View.Main.MainFrame;
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
        view.panelStateChanged("MainPanel");
    }

    public void searchClicked() {
        view.panelStateChanged("MainPanelAnnons");
    }

    public void loginClicked() {
        requestFactory.login(user);
    }

    public void andraUppgifterClicked() {
        view.andraUppgifterClicked(this);
    }

    public void saFungerarDetClicked() {
        view.panelStateChanged("MainPanelSFD");
       /* this.view.clearJFrame(this);
        view.updateJFrame(this);*/
    }

    public void minaSidorClicked() {
        view.panelStateChanged("MainPanelMinaSidor");
    }

    public void skapaAnnonsClicked() {
        view.panelStateChanged("MainPanelSkapaAnnons");

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
        view.updateLogin(loggedIn);

    }

    public void login() {
        this.loggedIn = true;
        view.dispose();
        view = new MainFrame(this, loggedIn);
    }

    public void loginRegisterClicked() {
        view.loginButtonClicked(this);
    }
}