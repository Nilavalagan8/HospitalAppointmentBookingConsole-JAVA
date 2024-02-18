package View;

import java.sql.SQLException;
import java.util.Scanner;

public class Start {
    public static Scanner sc = new Scanner(System.in);
    public void main()throws SQLException {
        boolean log=true;
        while(log) {
            System.out.println("Hospital Appointment Booking System");
            System.out.println();
            System.out.println();
            System.out.println("Login   -1");
            System.out.println("SingUp  -2");
            System.out.println("Exit    -3");
            int flag=sc.nextInt();
            sc.nextLine();
            if(flag==1){
                Login l = new Login();
            }
            else if(flag==2){
                SignUp Su = new SignUp();
            }
            else if(flag==3){
                log = false;
            }
            else{
                System.out.println("Enter a correct Key.......");
            }
        }
    }

}
