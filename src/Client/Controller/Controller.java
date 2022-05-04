package Client.Controller;

import Client.Model.*;
import Client.View.Main.MainFrame;
import Delad.Annons;
import Delad.Category;
import Delad.User;

import javax.swing.*;

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

    /**
     * loggedIn is false because you are not logged in when you start the program.
     * view, client and request factory is initialized
     */
    public Controller() {
        loggedIn = false;
        MainFrame view = new MainFrame(this, loggedIn);
        this.view = view;
        System.out.println("view färdig");
        client = new Client(725,"127.0.0.1", this);
        System.out.println("client färdig");
        requestFactory = new RequestFactory(client);
    }

    /**
     * when the "Hem" button on the top panel is clicked, this method sends to view that the
     * state of the mainPanel has changed to MainPanel.
     */
    public void homePage() {
        view.panelStateChanged("MainPanel");
    }

    /**
     * when the "Sök" button is clicked on the "Hem" panel, this method sends to view that the
     * state of the mainPanel has changed to MainPanelAnnons.
     */
    public void searchClicked() {
        view.panelStateChanged("MainPanelAnnons");
    }

    /**
     * when the user clicks "Logga in" on the login panel, this method creates a new user with the
     * parameters that is sent in, and also creates a request factory with that user.
     * @param email is the email that the user typed in
     * @param password is the password that the user typed in
     */
    public void loginClicked(String email, String password) {
        user = new User(email, password);
        requestFactory.login(user);
    }

    /**
     * when the user clicks "Ändra uppgifter" in the Mina sidor panel, this method tells view that
     * the user has clicked this button and starts a method in view.
     */
    public void andraUppgifterClicked() {
        view.andraUppgifterClicked(this);
    }

    /**
     * when the user clicks "Så fungerar det" on the top panel, this method tells view that the
     * state of main panel has changed to "MainPanelSFD"
     */
    public void saFungerarDetClicked() {
        view.panelStateChanged("MainPanelSFD");
       /* this.view.clearJFrame(this);
        view.updateJFrame(this);*/
    }

    /**
     * when the user clicks "Mina sidor" on the top panel, this method tells view that the
     * state of main panel has changed to "MainPanelMinaSidor"
     */
    public void minaSidorClicked() {
        view.panelStateChanged("MainPanelMinaSidor");
    }

    /**
     * when the user clicks "Skapa annons" on the top panel, this method tells view that the
     * state of main panel has changed to "MainPanelSkapaAnnons"
     */
    public void skapaAnnonsClicked() {
        view.panelStateChanged("MainPanelSkapaAnnons");

    }

    /**
     * when the user clicks "Registrera användare" on the login/register panel, this method makes a
     * request at requestfactory to register a new user.
     */
    public void registerNewUser(String userName, String email, String password) {
        requestFactory.register(new User(userName, email, password));
    }

    /**
     * getter for username
     * @return the current users username
     */
    public String getUserName(){
        return userName;
    }

    /**
     * getter for email
     * @return the current users email
     */
    public String getEmail(){
        return email;
    }

    /**
     * getter for password
     * @return the current users password
     */
    public String getPassword(){
        return password;
    }

    /**
     * getter for categories
     * @return the current chosen category
     */
    public Category[] getCategoriesValues() {
        return Category.values();
    }

    /**
     * when "Skapa annons" is clicked in the SkapaAnnonsPanel, this method tells view that
     * a new annons is trying to get made.
     * @param productName the product name the user typed in
     * @param productDescription the description the user typed in
     * @param productCategory the category the user typed in
     * @param publisherEmail the users email
     * @param renting ??
     */
    public void newAnnons(String productName, String productDescription, Category productCategory, String publisherEmail, Boolean renting) {

        annons = new Annons(productName, productDescription, productCategory, new User(publisherEmail), renting);

    }

    /**
     * when the user successfully loggs in, this method disposes the old view and creates
     * a new view that the current user is logged in on
     * @param loggedIn is true if the user is logged in
     */
    public void loggedInOrNot(boolean loggedIn){
        view.dispose();
        view = new MainFrame(this, loggedIn);

    }

    /**
     * when "Login/register" button is clicked, this method tells that to view.
     */
    public void loginRegisterClicked() {
        view.loginButtonClicked(this);
    }

    /**
     * when a user fails to login, this method tells view that the user failed to log in and displays
     * a jdialog. 
     */
    public void couldNotLogin() {
        view.couldNotLogin();
    }
}