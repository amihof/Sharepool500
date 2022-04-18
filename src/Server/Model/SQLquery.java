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
            String QUERY = String.format("INSERT INTO \"user\" (username, email, password) " +
                    "VALUES('%s', '%s', '%s');", email, password );

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
            String QUERY = String.format("INSERT INTO \"user\" (username, email, password) " +
                    "VALUES('%s', '%s', '%s');",username, email, password );

            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            return pstmt.execute();

        } catch (Exception p) {
            return false;
        }


    }

    public ArrayList<Annons> search(String text, Enum<Category> category, Date fromDate, Date toDate) {

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            String QUERY = String.format("INSERT INTO \"user\" (username, email, password) " +
                    "VALUES('%s', '%s', '%s');");

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

    public boolean createAnnons(String productName, String productDescription, Enum<Category> productCategory, String publisherEmail, Boolean renting){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            String QUERY = String.format("INSERT INTO \"user\" (username, email, password) " +
                    "VALUES('%s', '%s', '%s');");

            pstmt = con.prepareStatement(QUERY);

            return pstmt.execute();

        } catch (Exception p) {
            return false;
        }


    }



}
