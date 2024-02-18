package Controller;

import java.util.regex.Pattern;

public class Validation {
    public boolean checkPassWord(String pass1,String pass2){
        if(pass1.equals(pass2)){
            if(pass1.length()>=6){
                String special = pass1.replaceAll("[^\\W]","");
                String Upper = pass1.replaceAll("[^A-Z]","");
                String num = pass1.replaceAll("[^0-9]","");
                if(special.length()>0 && Upper.length()>0 && num.length()>0){
                    return true;
                }
            }
        }
        return false;
    }
}
