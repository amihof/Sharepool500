package Server.Model;

import Delad.Annons;
import Delad.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class SQLquery {

    //tom konstruktor
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
            System.out.println("Quert prepared and will execute");
            return pstmt.execute();

        } catch (Exception p) {
            System.out.println("login attempt failed");
            return false;
        }


    }

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

    // To do date //tar bort

    //oanvända parametrar
    public ArrayList<Annons> search(String productname, Category category, Date fromDate, Date toDate) {
        Connection con = Server.getCon();


        PreparedStatement pstmt = null;
        try {
            String QUERY = "SELECT  product.name, product.description, annons.owner_email FROM product_type " +
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
            }
            return result;

        } catch (Exception p) {
            System.out.println("no result found");
            return null;
        }

    }

    //för lång rad
    //kommentera vad gör creatAnnons
    public boolean createAnnons(String productName, String productDescription, Category productCategory, String publisherEmail, Boolean renting){

        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            //förklara mer vilka paramtrar förväntas
            String QUERY = "call procedure_create_annons(?,?,?,?,?)";

            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, productName);
            pstmt.setString(2, productDescription);
            pstmt.setString(3, productCategory.toString());
            pstmt.setString(4, publisherEmail);
            pstmt.setBoolean(5, renting);
            pstmt = con.prepareStatement(QUERY);

            return pstmt.execute();

        } catch (Exception p) {
            System.out.println("couldn't create an annons");
            return false;
        }


    }



}
