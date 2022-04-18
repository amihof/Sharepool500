package Server.Model;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class SQLquery {

    public SQLquery(){

    }

    public boolean login(String username,String email, String password){

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

    public ArrayList<Annons> search(String text, Enum<Category> category, Date date){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            String QUERY = String.format("INSERT INTO \"user\" (username, email, password) " +
                    "VALUES('%s', '%s', '%s');",username, email, password );

            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            ResultSet resultSet = pstmt.executeQuery();

            ArrayList<Annons> result;
            Annons tempAnnons;
            while (resultSet.next()){
                result.add(new Annons(resultSet.getString(1)));
            }



            return pstmt.execute();

        } catch (Exception p) {
            return null;
        }


    }

    public boolean createAnnons(String text){

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



}
