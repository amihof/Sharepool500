package Client.Controller;

import Client.Model.*;
import Client.View.Main.MainFrame;
import Delad.Annons;
import Delad.Category;
import Delad.Search;
import Delad.User;

import java.util.ArrayList;

public class Controller
{
    private MainFrame view;
    private RequestFactory requestFactory;
    private Client client;

    private User user;

    private ArrayList<Annons> searchedAnnonsList;
    /**
     * this constructor is called when the program starts. It creates a new MainFrame, Client and
     * RequestFactory
     * @Author Amidala Hoffmén
     */
    public Controller() {
        this.view = new MainFrame(this, false);
        client = new Client(1050,"127.0.0.1", this);
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

    public void loggedInInfo(User user) {
        view.loggedInInfo(user);
    }

    /**
     * when the user successfully loggs in, this method disposes the old view and creates
     * a new view that the current user is logged in on
     * if the user fails to login, it tells the view that the user failed to login and displays a
     * jdialog
     * @param loggedIn is true if the user is logged in and false if the login failed
     */
    public void loggedInOrNot(boolean loggedIn){
        if (!loggedIn){
            view.couldNotLogin();
        }
        else {
            view.dispose();
            view = new MainFrame(this, loggedIn);
        }
    }

    /**
     * when the user clicks "Registrera användare" on the login/register panel, this method makes a
     * request at requestfactory to register a new user.
     */
    public void registerNewUser(String userName, String email, String password) {
        requestFactory.register(new User(userName, email, password));
    }

    public void couldNotRegister() {
        view.couldNotRegister();
    }

    public Category[] getCategoriesValues() {
        return Category.values();
    }

    public void registerNewAnnons(String productName, String productDescription, Category productCategory, Boolean renting) {
        requestFactory.createAnnons(new Annons(productName, productDescription, productCategory, user, renting));
    }


    public void annonsMade() {
        view.annonsMade();
    }

    public void searchedClicked(String text, Category productCategory) {
        requestFactory.searchAnnons(new Search(text, productCategory));
    }

    public void seeSearchedAnnons(ArrayList<Annons> searchedAnnonsList){
        ArrayList<String> nameListAnnonser = new ArrayList<>();
        this.searchedAnnonsList = searchedAnnonsList;

        for (Annons a : searchedAnnonsList)
        {
            nameListAnnonser.add(a.getProductName());
        }

        view.updateAnnonserSeen(searchedAnnonsList);
    }

}