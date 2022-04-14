package Server.Model;

public class SQLquery {

    public SQLquery(){

    }

    public boolean RegisterUser(String username,String email, String password){
        boolean sucess = false;

        String query = "call procedure_create_user(?,?,?)";





       return sucess;
    }



}
