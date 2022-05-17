package Client.Controller;

import Client.Model.*;
import Client.View.Main.MainFrame;

import Shared.*;

import java.util.ArrayList;

/**
 * The controller class is the link between view and model
 * @Author Amidala Hoffmén
 */
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
        requestFactory.getUsername(user.getEmail());
        requestFactory.login(user);
    }

    /**
     * gets the info of the logged in user
     * @param user is the user that is logged in
     */
    public void loggedInInfo(User user) {

        view.loggedInInfo(user);
    }

    /**
     * when the user successfully loggs in, this method disposes the old view and creates
     * a new view that the current user is logged in on
     * if the user fails to login, it tells the view that the user failed to login and displays a
     * jdialog
     * @param username is true if the user is logged in and false if the login failed
     */
    public void loggedInOrNot(String username){
        if (username.equals("")){
            view.couldNotLogin();
        }
        else {
            view.dispose();
            view = new MainFrame(this, true);
            user.setUsername(username);
        }
    }

    /**
     * when the user clicks "Registrera användare" on the login/register panel, this method makes a
     * request at requestfactory to register a new user.
     */
    public void registerNewUser(String userName, String email, String password) {
        requestFactory.register(new User(userName, email, password));
    }

    /**
     * if the user could not register, this method calls a method in view that shows an error message
     */
    public void couldNotRegister() {
        view.couldNotRegister();
    }

    /**
     * getter
     * @return category
     */
    public Category[] getCategoriesValues() {
        return Category.values();
    }

    /**
     * this method is called when someone is making a new Annons. is sends the parameters of the annons
     * from view to requestfactory
     * @param productName the title of the annons
     * @param productDescription the description of the product
     * @param productCategory the category of the product
     * @param renting ?
     */
    public void registerNewAnnons(String productName, String productDescription, Category productCategory, Boolean renting) {
        requestFactory.createAnnons(new Annons(productName, productDescription, productCategory, user, renting));
    }

    /**
     * this method calls a method in view that tells the user that their annons is made
     */
    public void annonsMade() {
        view.annonsMade();
    }

    /**
     * when the user click search, this method is called and takes the parameters from view and sends
     * into requestfactory to create a new search request.
     * @param text the text the user searched for
     * @param productCategory the category the user searched for
     */
    public void searchedClicked(String text, Category productCategory) {
        requestFactory.searchAnnons(new Search(text, productCategory));
    }

    /**
     * this method takes the arraylist of all annonser that matched the search terms the user used and
     * sends them into view to show the user
     * @param searchedAnnonsList the list of all annonser that matched the search terms
     */
    public void seeSearchedAnnons(ArrayList<Annons> searchedAnnonsList){
        view.updateAnnonserSeen(searchedAnnonsList);
    }

    /**
     * this method takes the annons id and email of the publisher of the annons when the user wants
     * to start a chat with someone.
     * @param searchedAnnonsId the id of the annons the user wants to start a chat with
     * @param productPublisherEmail the email of the publisher that the user wants to start a chat with
     */
    public void sendMessageClicked(int searchedAnnonsId, String productPublisherEmail) {
        requestFactory.startChat(new Chat(searchedAnnonsId, productPublisherEmail, user.getEmail()));
    }

    public void seeEveryChat(ArrayList<Chat> chatList) {
        view.updateChatList(chatList);

    }
}