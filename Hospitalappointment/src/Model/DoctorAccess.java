package Model;

import Model.DB;
import Model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorAccess {
    static DB connect = DB.getInstance();
    static Connection con = connect.getConnection();
    public void addDoctor(Doctor doc) throws SQLException{
        String query = "Insert into doctor(DoctorName,ph_no,SpecialityId,H_id)values(?,?,?,?)";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,doc.getName());
        prepare.setString(2,doc.getPhone());
        prepare.setInt(3,doc.getSpecialityId());
        prepare.setInt(4,doc.getHospitalId());
        prepare.executeUpdate();
    }
    public ArrayList<Doctor> getAllDoctor(int h_id)throws SQLException{
        String query = "select * from doctor where h_id=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,h_id);
        ResultSet rs = prepare.executeQuery();
        ArrayList<Doctor> doc = new ArrayList<>();
        while(rs.next()){
            Doctor d = new Doctor();
            d.setDoctorId(rs.getInt(1));
            d.setName(rs.getString(2));
            d.setPhone(rs.getString(3));
            d.setSpecialityId(rs.getInt(4));
            d.setHospitalId(rs.getInt(5));
            doc.add(d);
        }
        return doc;
    }
    public ArrayList<Doctor> getDoctor(String name,int hId)throws SQLException{
        String query = "select * from doctor where DoctorName=? and h_id=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,name);
        prepare.setInt(2,hId);
        ResultSet rs = prepare.executeQuery();
        ArrayList<Doctor>doc = new ArrayList<>();
        while(rs.next()){
            Doctor d = new Doctor();
            d.setDoctorId(rs.getInt(1));
            d.setName(rs.getString(2));
            d.setPhone(rs.getString(3));
            d.setSpecialityId(rs.getInt(4));
            d.setHospitalId(rs.getInt(5));
            doc.add(d);
        }
        return doc;
    }
    public void delDoctor(int dId)throws SQLException{
        String query = "delete from doctor where doctor_id=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,dId);
        prepare.executeUpdate();
    }
}
