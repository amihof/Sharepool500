package Server.Model;
//kommentarer saknas
import Shared.*;

import java.sql.*;
import java.util.ArrayList;

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

    public String login(String email, String password){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        String usernametemp ="";
        try {
            String QUERY = "call procedure_login(?,?)"; // Första parameter ? är email och andra ? är password av registrerad användare
            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            System.out.println("Quert prepared and will execute");
            pstmt.execute();

            QUERY = "SELECT username from users\n" +
            "WHERE '"+email+"'=email";

            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(QUERY);

            while(resultSet.next()){
                usernametemp=resultSet.getString(1);
            }

            return usernametemp;

        } catch (Exception p) {
            System.out.println("login attempt failed");
            return usernametemp;
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
        Connection con = Server.getCon();
        String QUERY;
        int i=0;


        try {
            if(category.toString()=="Kategori"){
                QUERY = "SELECT  annons_title, annons_description,owner_email,U.username,renting,A.id from annons A\n" +
                        "JOIN users U\n" +
                        "ON U.email = A.owner_email\n" +
                        "WHERE annons_title LIKE '%"+productname+"%'  or annons_description LIKE '%"+productname+"%'";
            }
            else{
                QUERY = "SELECT  annons_title, annons_description,owner_email,U.username,renting,A.id from annons A\n" +
                        "JOIN product_type P\n" +
                        "ON A.product_type = P.id\n" +
                        "JOIN users U\n" +
                        "ON U.email = A.owner_email\n" +
                        "WHERE P.name like '%"+category+"%'\n" +
                        "and (annons_title LIKE '%"+productname+"%'  or annons_description LIKE '%"+productname+"%')";
            }
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(QUERY);

            ArrayList<Annons> result = new ArrayList<>();
            Annons tempAnnons;
            User tempuser;
            while (resultSet.next()) {

                tempuser= new User(resultSet.getString(4),resultSet.getString(3),resultSet.getString(6));

                tempAnnons = new Annons(resultSet.getString(1),
                        resultSet.getString(2),category,tempuser,
                        resultSet.getBoolean(5),resultSet.getInt(6));
                result.add(tempAnnons);
               System.out.println(result.get(i).getAnnonsID());
               i++;
            }
            return result;

        } catch (Exception e) {
            System.out.println("no result found");
            e.printStackTrace();
            return null;
        }

    }

    /**
     *
     * @param annons_title is the users input for the name of the product he wishes to create an annons for
     * @param annons_description is the description
     * @param productCategory the category from the drop down list
     * @param publisherEmail the users email
     * @param renting this is a boolean which determines what type of annons it is, true for lending out, false if borrow
     * @return returns true if sucess
     */
    public boolean createAnnons(String annons_title, String annons_description, Category productCategory, String publisherEmail, Boolean renting){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {

            String QUERY = "call procedure_create_annons(?,?,?,?,?,?)"; // 6 parameters from the user

           // String QUERY1 = String.format("INSERT INTO \"annons\" (+default+, "+publisherEmail+", password) " +
           //         "VALUES('%s', '%s', '%s');"); //vilka values ska insertas? vad ska default vara?

            pstmt = con.prepareStatement(QUERY);
            pstmt.setBoolean(1, false);
            pstmt.setString(2, annons_description);
            pstmt.setString(3, annons_title);
            pstmt.setString(4, productCategory.toString());
            pstmt.setString(5, publisherEmail);
            pstmt.setBoolean(6, true);


            return pstmt.execute();

        } catch (Exception e) {
            System.out.println("couldn't create an annons");
            e.printStackTrace();
            return false;
        }


    }

    public boolean createChat(Chat chat){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {

            String QUERY = "call procedure_create_chat(?,?)";
            pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1, chat.getAnnonsId());
            pstmt.setString(2, chat.getRequester_email());
            pstmt.execute();
            return true;

        } catch (Exception e) {
            System.out.println("couldn't create an chat");
            e.printStackTrace();
            return false;
        }
    }


    public boolean createMessage(Message message){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {

            String QUERY = "call procedure_create_chat(?,?)";
            pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1, message.getId()); // id ska genereras av databsen inte motsatsen
            pstmt.setString(2, message.getText());

            return pstmt.execute();

        } catch (Exception e) {
            System.out.println("couldn't create a message");
            e.printStackTrace();
            e.printStackTrace(System.err);
            return false;
        }
    }

    public boolean updateEmail(String oldEmail, String newEmail) {
        Connection con = Server.getCon();
        String QUERY = "call procedure_update_user_email(?,?,?)";
        PreparedStatement pstmt = null;

        try{
            pstmt = con.prepareStatement(QUERY);
            pstmt.setBoolean(1, false);
            pstmt.setString(2, oldEmail);
            pstmt.setString(3, newEmail);

            return pstmt.execute();
        }
        catch(Exception e){
            System.out.println("update username didnt work");
            e.printStackTrace();
            e.printStackTrace(System.err);
            return false;
        }
    }


    public ArrayList<Chat> getChat(){
        Connection con = Server.getCon();
        String QUERY;
        try{
            QUERY = "select C.annonsid,C.email_requester,A.owner_email from chat C\n" +
                    "join annons A\n" +
                    "ON C.annonsid = A.id" +
                    "WHERE A.owner_email=";
            Statement stmt = con.createStatement();
        }
            catch(Exception e){
                System.out.println("didnt get chat");
                e.printStackTrace();
                e.printStackTrace(System.err);
            }
        return null;
    }

    public boolean updateUsername(String email, String username) {
        Connection con = Server.getCon();
        String QUERY = "call procedure_update_user_name(?,?,?)";
        PreparedStatement pstmt = null;

        try{
            pstmt = con.prepareStatement(QUERY);
            pstmt.setBoolean(1, false);
            pstmt.setString(2, email);
            pstmt.setString(3, username);

            return pstmt.execute();
        }
        catch(Exception e){
            System.out.println("update username didnt work");
            e.printStackTrace();
            e.printStackTrace(System.err);
            return false;
        }
    }

    public boolean updatePassword(String email, String password_new, String password_old) {
        Connection con = Server.getCon();
        String QUERY = "call procedure_update_user_password(?,?,?,?)";
        PreparedStatement pstmt = null;

        try{
            pstmt = con.prepareStatement(QUERY);
            pstmt.setBoolean(1, false);
            pstmt.setString(2, email);
            pstmt.setString(3, password_new);
            pstmt.setString(4, password_old);

            return pstmt.execute();
        }
        catch(Exception e){
            System.out.println("update password didnt work");
            e.printStackTrace();
            e.printStackTrace(System.err);
            return false;
        }
    }

    public boolean deleteUser(String email, String password) {
        Connection con = Server.getCon();
        String QUERY = "call procedure_delete_user(?,?,?)";
        PreparedStatement pstmt = null;

        try{
            pstmt = con.prepareStatement(QUERY);
            pstmt.setBoolean(1, false);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            return pstmt.execute();
        }
        catch(Exception e){
            System.out.println("update password didnt work");
            e.printStackTrace();
            e.printStackTrace(System.err);
            return false;
        }
    }



}
