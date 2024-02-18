package View;

import Controller.UserDataFunction;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    private String mail;
    private String password;
    private Scanner sc =new Scanner(System.in);
    public Login()throws SQLException{
        System.out.println("Enter your mail:");
        mail = sc.nextLine();
        System.out.println("Enter your password:");
        password = sc.nextLine();
        start();
    }
    private void start()throws SQLException{

            UserDataFunction cU = new UserDataFunction(mail, password);
            if (cU.findUser()) {
                boolean passWordCheck = true;
                boolean passFlag = false;
                    if(cU.checkPassWord()){
                        passFlag = true;
                    }
                    else{
                        System.out.println("***********-Incorrect Password-***********");
                    }

                if(passFlag){
                    if(cU.checkHospital()){
                        HospitalRole h = new HospitalRole(cU.getUserId());
                    }
                    else{
                        UsersPatientRole up =  new UsersPatientRole(cU.getUserId());
                    }
                }
            }
            else{
                System.out.println("User Not found ");
                System.out.println("Create a account first");
            }
    }
}
