package Client.Controller;

import Client.Model.*;
import Client.View.Main.MainFrame;
import Delad.Annons;
import Delad.Category;
import Delad.Search;
import Delad.User;

import javax.swing.*;
import java.util.ArrayList;

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
        client = new Client(1050,"127.0.0.1", this);
        System.out.println("client färdig");
        requestFactory = new RequestFactory(client);
    }

    /**
     * when the user clicks "Logga in" on the login panel, this method creates a new user with the
     * parameters that is sent in, and also creates a request factory with that user.
     * @param email is the email that the user typed in
     * @param password is the password that the user typed in
     */
    public void loginClicked(String email, String password) {
        this.user = new User(email, password);
        requestFactory.login(user);
    }

    /**
     * when the user clicks "Registrera användare" on the login/register panel, this method makes a
     * request at requestfactory to register a new user.
     */
    public void registerNewUser(String userName, String email, String password) {
        requestFactory.register(new User(userName, email, password));
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
     * when a user fails to login, this method tells view that the user failed to log in and displays
     * a jdialog. 
     */
    public void couldNotLogin() {
        view.couldNotLogin();
    }

    //--GETTERS and SETTERS--//
    public String getEmail(){
        return email;
    }

    public Category[] getCategoriesValues() {
        return Category.values();
    }

    public void registerNewAnnons(String productName, String productDescription, Category productCategory, Boolean renting) {
        requestFactory.createAnnons(new Annons(productName, productDescription, productCategory, user, renting));
    }

    public void couldNotRegister() {
        view.couldNotRegister();
    }

    public void annonsMade() {
        view.annonsMade();
    }

    public void searchedClicked(String text, Category productCategory) {
        requestFactory.searchAnnons(new Search(text, productCategory));
    }

    public void seeSearchedAnnons(ArrayList<Annons> searchedAnnonsList){
        ArrayList<String> nameListAnnonser = new ArrayList<>();
        //String[] nameListAnnonser = new String[0];

        for (Annons a : searchedAnnonsList)
        {
            nameListAnnonser.add(a.getProductName());
        }
        //String[] newArrayTest = nameListAnnonser.toArray(new String[searchedAnnonsList.size()]);

        view.updateAnnonserSeen(nameListAnnonser);
    }
}