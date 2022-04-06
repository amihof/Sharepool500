package Controller;

import Model.Model;
import View.login.LoginFrame;
import View.main.MainFrame;

import javax.swing.*;

public class Controller {

    private Model model;
    private LoginFrame loginFrame;


    public Controller(){
        MainFrame view = new MainFrame(this);

    }

    public void homePage(){

    }

    public void setupLogin() {
        this.loginFrame = new LoginFrame(this);
    }

    public void login(String str, ImageIcon icon) {
        this.model = new Model();
    }

    public void searchClicked() {


    }
}
