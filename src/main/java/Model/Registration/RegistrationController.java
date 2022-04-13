package main.java.Model.Registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
@RequestMapping(path = "api/v1/registration") //till databasen
@AllArgsConstructor
public class RegistrationController {

    /*public Connection getDatabaseConnection() throws SQLException {
        String url = "jdbc:postgresql://pgserver.mau.se:5432/burek";
        String user = "am3087";
        String password = "dtw2s5jg\n";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            return con;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}