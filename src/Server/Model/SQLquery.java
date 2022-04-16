package Server.Model;

import java.sql.*;

public class SQLquery {

    public SQLquery(){

    }

    public boolean RegisterUser(String username,String email, String password){

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
