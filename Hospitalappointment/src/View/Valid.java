package View;

import Controller.Validation;

import java.util.Scanner;

public class Valid {
    Scanner sc = new Scanner(System.in);
    private Validation valid = new Validation();
    public String getPassWord(){
        boolean passrun = true;
        String pass1="";
        while(passrun){
            System.out.println("Enter password(password min 6 characters, min one special character, 1 UpperCase,1 number)");
            String pass = sc.nextLine();
            System.out.println("Enter confirm password");
            String passcon = sc.nextLine();
            if(valid.checkPassWord(pass,passcon)){
                pass1 = pass;
                passrun = false;
            }
            else{
                System.out.println("Enter valid password");
            }
        }
        return pass1;
    }
}
