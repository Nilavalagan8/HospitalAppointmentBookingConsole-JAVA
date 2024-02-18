package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static DB instance = null;
    public static Connection con = null;

    private DB(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalappointmentbooking","root","Data");
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    public static DB getInstance(){
        if(instance == null){
            instance = new DB();
        }
        return instance;
    }

    public Connection getConnection(){
        return con;
    }
}