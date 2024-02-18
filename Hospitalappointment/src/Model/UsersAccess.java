package Model;

import Model.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersAccess {
    static DB connect = DB.getInstance();
    static Connection con = connect.getConnection();
     public void addUser(Users user)throws SQLException{
            String query = "Insert into users(mail,password,type)values(?,?,?)";
            PreparedStatement prepare = con.prepareStatement(query);
            prepare.setString(1, user.getMail());
            prepare.setString(2, user.getPassWord());
            prepare.setString(3, user.getUserType());
            prepare.executeUpdate();
    }
    public ArrayList<Users> getAllUser()throws SQLException{
        String query = "select * from Users";
        PreparedStatement prepare = con.prepareStatement(query);
        ResultSet rs =prepare.executeQuery(query);
        ArrayList<Users> user = new ArrayList<>();
        while(rs.next()){
            Users u= new Users();
            u.setUserId(rs.getInt(1));
            u.setMail(rs.getString(2));
            u.setPassWord(rs.getString(3));
            u.setType(rs.getString(4));
            user.add(u);
        }
        return user;
    }
    public Users getUser(String mail)throws SQLException{
         String query = "select*from users where mail=?";
         PreparedStatement prepare = con.prepareStatement(query);
         prepare.setString(1,mail);
         ResultSet rs = prepare.executeQuery();
         Users u = new Users();
         if(rs.next()){
             u.setUserId(rs.getInt(1));
             u.setMail(rs.getString(2));
             u.setPassWord(rs.getString(3));
             u.setType(rs.getString(4));
         }
         return u;
    }
}
