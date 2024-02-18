package View;

import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {
    Scanner sc = new Scanner(System.in);
    public SignUp()throws SQLException{
        start();
    }
    private void start()throws SQLException{
        boolean isrun = true;
        while(isrun){
            System.out.println("Create User account         ---1");
            System.out.println("Register as hospital        ---2");
            System.out.println("Exit                        ---3");
            int flag = sc.nextInt();
            if(flag==1){
                CreateAccountuser CAu = new CreateAccountuser();
            }
            else if(flag==2){
                HospitalRegister HR = new HospitalRegister();
            }
            else if (flag == 3) {
                isrun=false;
            }
            else{
                System.out.println("Enter correct key");
            }
        }
    }
}
