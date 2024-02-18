package Model;

import Model.DB;
import Model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientAccess {
    static DB connect = DB.getInstance();
    static Connection con = connect.getConnection();
    public void addPatient(Patient pat)throws SQLException{
        String query = "insert into patient(pa_name,DOB,Ph_no,address,user_id)values(?,?,?,?,?)";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,pat.getPatientName());
        prepare.setString(2,pat.getdOB());
        prepare.setString(3,pat.getPhoneNo());
        prepare.setString(4, pat.getAddress());
        prepare.setInt(5,pat.getUserId());
        prepare.executeUpdate();
    }
    public ArrayList<Patient> getAllPatient(int hId)throws SQLException{
        String query = "select*from patient where hId=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,hId);
        ResultSet rs = prepare.executeQuery();
        ArrayList<Patient> pat = new ArrayList<>();
        while (rs.next()){
            Patient p = new Patient();
            p.setPatientId(rs.getInt(1));
            p.setPatientName(rs.getString(2));
            p.setdOB(rs.getString(3));
            p.setPhoneNo(rs.getString(4));
            p.setAddress(rs.getString(5));
            p.setUserId(rs.getInt(6));
            pat.add(p);
        }
        return pat;
    }
    public Patient getPatient(String name,String phone)throws SQLException{
        String query = "select*from patient where pa_name=? and ph_no=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,name);
        prepare.setString(2,phone);
        ResultSet rs = prepare.executeQuery();
        Patient p = new Patient();
        if(rs.next()){
            p.setPatientId(rs.getInt(1));
            p.setPatientName(rs.getString(2));
            p.setdOB(rs.getString(3));
            p.setPhoneNo(rs.getString(4));
            p.setAddress(rs.getString(5));
            p.setUserId(rs.getInt(6));
        }
        return  p;
    }
    public ArrayList<Patient> getPatientViaUser(int uid)throws SQLException{
        String query = "select*from patient where user_id=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,uid);
        ResultSet rs = prepare.executeQuery();
        ArrayList<Patient> pat = new ArrayList<>();
        if(rs.next()){
            Patient p = new Patient();
            p.setPatientId(rs.getInt(1));
            p.setPatientName(rs.getString(2));
            p.setdOB(rs.getString(3));
            p.setPhoneNo(rs.getString(4));
            p.setAddress(rs.getString(5));
            p.setUserId(rs.getInt(6));
            pat.add(p);
        }
        return  pat;
    }
}
