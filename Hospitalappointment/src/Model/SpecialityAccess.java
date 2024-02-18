package Model;

import Model.DB;
import Model.Speciality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpecialityAccess {
    static DB connect = DB.getInstance();
    static Connection con = connect.getConnection();
    public void addSpeciality(Speciality spec)throws SQLException{
        String query = "insert into speciality(department)values(?)";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,spec.getDepartment());
        prepare.executeUpdate();
    }
    public ArrayList<Speciality> getAllSpecility()throws SQLException{
        String query = "select*from speciality";
        PreparedStatement prepare = con.prepareStatement(query);
        ResultSet rs = prepare.executeQuery();
        ArrayList<Speciality> spec = new ArrayList<>();
        while(rs.next()){
            Speciality s = new Speciality();
            s.setSpecialityId(rs.getInt(1));
            s.setDepartment(rs.getString(2));
            spec.add(s);
        }
        return spec;
    }
    public Speciality getSpeciality(String dept)throws SQLException{
        String query = "select * from speciality where department=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,dept);
        ResultSet rs = prepare.executeQuery();
        Speciality sp = new Speciality();
        if(rs.next()){
            sp.setSpecialityId(rs.getInt(1));
            sp.setDepartment(rs.getString(2));
        }
        return sp;
    }
}
