package Client.Model;

import Server.Model.Server;

import java.sql.*;
import java.time.LocalDate;

public class RegisterUser {
    public void addNewPatient(String userName, String email, String password) throws SQLException {
        Connection con = Server.getCon();
        PreparedStatement pstmt = null;
        try {
            String QUERY = "call addmember(?, ?, ?, ?, ?, ?);"; //procedure
            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, userName);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();

            String QUERY2 = "SELECT email FROM patient where userName = '" + email + "';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY2);
            while (rs.next()) {
                System.out.println("You are registered successfully. Your username is: " + rs.getString("username"));
            }
        } catch (Exception p) {
            System.out.println("The email you entered already exists. Please try again with a different email");
        }

        pstmt.closeOnCompletion();
        con.close();
    }

}
