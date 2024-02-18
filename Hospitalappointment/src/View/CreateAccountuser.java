package View;

import Controller.UserDataFunction;
import Controller.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccountuser {
    Scanner sc= new Scanner(System.in);
    Valid v = new Valid();
    public CreateAccountuser()throws SQLException{
        start();
    }
    private void start()throws SQLException {
            System.out.println("Enter your mail");
            String mail = sc.nextLine();
            UserDataFunction UDF = new UserDataFunction(mail);
            if(!UDF.findUser()){
                String pass1 = v.getPassWord();
                UserDataFunction UDF1 = new UserDataFunction(mail,pass1);
                UDF1.addUser("USER");
            }
            else{
                System.out.println("Mail alreary exist");
            }
    }
}
