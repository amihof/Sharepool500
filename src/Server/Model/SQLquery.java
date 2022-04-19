package Server.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class SQLquery {

    public SQLquery(){

    }

   public boolean login(String email, String password){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            String QUERY = "call procedure_login(?,?)";

            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            return pstmt.execute();

        } catch (Exception p) {
            return false;
        }


    }

    public boolean register(String username,String email, String password){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            String QUERY = "call procedure_create_user(?,?,?)";

            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            System.out.println("Quert prepared and will execute");
            return pstmt.execute();

        } catch (Exception p) {
            System.out.println("query executed and result was false");
            return false;
        }


    }

    public ArrayList<Annons> search(String searchText, Category category, Date fromDate, Date toDate) {
        Connection con = Server.getCon();

        PreparedStatement pstmt = null;
        try {
            String QUERY = "call procedure_search_annons(?,?,?,?)";

            pstmt = con.prepareStatement(QUERY);
            ResultSet resultSet = pstmt.executeQuery();

            ArrayList<Annons> result = null;
            Annons tempAnnons;
            while (resultSet.next()) {
                //result.add(new Annons(resultSet.getString(1)));
            }
            return result;

        } catch (Exception p) {
            return null;
        }

    }

    public boolean createAnnons(String productName, String productDescription, Category productCategory, String publisherEmail, Boolean renting){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            String QUERY = String.format("INSERT INTO \"annons\" (+default+, "+publisherEmail+", password) " +
                    "VALUES('%s', '%s', '%s');");

            pstmt = con.prepareStatement(QUERY);

            return pstmt.execute();

        } catch (Exception p) {
            return false;
        }


    }



}
