package Server.Model;
//kommentarer saknas
import Delad.Annons;
import Delad.Category;
import Delad.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class SQLquery {

    //tom konstruktor
    public SQLquery(){

    }

    /**
     *
     * @param email is the username types in as input to login
     * @param password is the password
     * @return returns true if the login is successful
     */

    public boolean login(String email, String password){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            String QUERY = "call procedure_login(?,?)"; // Första parameter ? är email och andra ? är password av registrerad användare

            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            System.out.println("Quert prepared and will execute");
            pstmt.execute();
            return true;

        } catch (Exception p) {
            System.out.println("login attempt failed");
            return false;
        }


    }

    /**
     *
     * @param username is the username the user chooses as input when the user signs up on the website
     * @param email is the email
     * @param password is the password
     * @return returns true if the registration is complete
     */

    public boolean register(String username,String email, String password){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            String QUERY = "call procedure_create_user(?,?,?,?)";

            pstmt = con.prepareStatement(QUERY);
            pstmt.setBoolean(1, false);
            pstmt.setString(2, username);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            return pstmt.execute();

        } catch (Exception p) {
            System.out.println("registeration attempt failed");
            return false;
        }


    }

    /**
     *
     * @param productname is the parameter where the user searches for a type of object
     * @param category is the category the user chooses in the drop down list when searching for something
     * @return
     */

    public ArrayList<Annons> search(String productname, Category category) {

        

    //oanvända parametrar
        Connection con = Server.getCon();


        PreparedStatement pstmt = null;
        try {
            String QUERY = "SELECT  product.name, product.description, annons.owner_email,renting FROM product_type " +
                    "INNER JOIN product ON  product_type.id = product.product_type_id " +
                    "INNER JOIN annons ON product.id = annons.p_id " +
                    "WHERE product_type.name LIKE '%?%' AND product.name LIKE '%?%';";

            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1,category.toString());
            pstmt.setString(2,productname);
            ResultSet resultSet = pstmt.executeQuery();

            ArrayList<Annons> result = null;
            Annons tempAnnons;
            while (resultSet.next()) {
                //result.add(new Annons(resultSet.getString(1),category.valueOf(resultSet.getString(2)),));
                //bortkommenterad kod

                result.add(new Annons(resultSet.getString(1),resultSet.getString(2), category,
                        new User(resultSet.getString(3)),resultSet.getBoolean(4)));
            }
            return result;

        } catch (Exception p) {
            System.out.println("no result found");
            return null;
        }

    }

    /**
     *
     * @param productName is the users input for the name of the product he wishes to create an annons for
     * @param productDescription is the description
     * @param productCategory the category from the drop down list
     * @param publisherEmail the users email
     * @param renting this is a boolean which determines what type of annons it is, true for lending out, false if borrow
     * @return returns true if sucess
     */
    public boolean createAnnons(String productName, String productDescription, Category productCategory, String publisherEmail, Boolean renting){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {

            String QUERY = "call procedure_create_annons(?,?,?,?,?)"; // 5 parameters from the user

           // String QUERY1 = String.format("INSERT INTO \"annons\" (+default+, "+publisherEmail+", password) " +
           //         "VALUES('%s', '%s', '%s');"); //vilka values ska insertas? vad ska default vara?


            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, productName);
            pstmt.setString(2, productDescription);
            pstmt.setString(3, productCategory.toString());
            pstmt.setString(4, publisherEmail);
            pstmt.setBoolean(5, renting);
            pstmt = con.prepareStatement(QUERY);

            return pstmt.execute();

        } catch (Exception e) {
            System.out.println("couldn't create an annons");
            e.printStackTrace();
            return false;
        }


    }
}
