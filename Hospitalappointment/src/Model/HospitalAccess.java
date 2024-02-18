package Model;

import Model.DB;
import Model.Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HospitalAccess {
    static DB connect = DB.getInstance();
    static Connection con = connect.getConnection();
    public void addHospital(Hospital hos)throws SQLException {
        String query = "Insert into hospital(name,phone_no,Address,User_id) values(?,?,?,?)";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1, hos.getName());
        prepare.setString(2, hos.getPhN0());
        prepare.setString(3, hos.getAdd());
        prepare.setInt(4,hos.getuId());
        prepare.executeUpdate();
    }
    public Hospital getHospital(int uid)throws SQLException{
        String query = "select * from hospital where user_id=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,uid);
        ResultSet rs =prepare.executeQuery();
        Hospital hos = new Hospital();
        if(rs.next()){
            hos.setHospitalId(rs.getInt(1));
            hos.setName(rs.getString(2));
            hos.setPhN0(rs.getString(3));
            hos.setAdd(rs.getString(4));
            hos.setuId(rs.getInt(5));
        }
        return hos;
    }
    public ArrayList<Hospital> getAllHospital()throws SQLException{
        String query = "select * from hospital";
        PreparedStatement prepare = con.prepareStatement(query);
        ResultSet rs =prepare.executeQuery(query);
        ArrayList<Hospital> hosp = new ArrayList<>();
        while(rs.next()){
            Hospital hos = new Hospital();
            hos.setHospitalId(rs.getInt(1));
            hos.setName(rs.getString(2));
            hos.setPhN0(rs.getString(3));
            hos.setAdd(rs.getString(4));
            hos.setuId(rs.getInt(5));
            hosp.add(hos);
        }
        return hosp;
    }
}

