package Controller;

import Model.Users;
import Model.UsersAccess;

import java.sql.SQLException;

public class UserDataFunction {
    private String mail;
    private String password;
    private Users data = null ;
    private UsersAccess usersAccess = new UsersAccess();
    public UserDataFunction(String mail, String password){
        this.mail = mail;
        this.password = password;
    }
    public UserDataFunction(String mail){
        this.mail = mail;
    }
    public UserDataFunction(){};
    public boolean findUser()throws SQLException {
        data = usersAccess.getUser(mail);
        if(data.getMail()!=null){
            return true;
        }
        return false;
    }
    public boolean checkPassWord(){
        String pwd = data.getPassWord();
        if(pwd.equals(password)){
            return true;
        }
        return false;
    }
    public boolean checkHospital(){
        String cH = data.getUserType();
        if(cH.equals("HOSPITAL")){
            return true;
        }
        return false;
    }
    public boolean checkUser(){
        String cU = data.getUserType();
        if(cU.equals("USER")){
            return true;
        }
        return false;
    }
    public void addUser(String type)throws SQLException{
        Users udata = new Users();
        udata.setMail(mail);
        udata.setPassWord(password);
        udata.setType(type);
        usersAccess.addUser(udata);
    }
    public int getUserId(){
        return data.getUerId();
    }
    public int getUserId(String mail)throws SQLException{
        UsersAccess UA2 = new UsersAccess();
        Users us1 = UA2.getUser(mail);
        return us1.getUerId();
    }
}
