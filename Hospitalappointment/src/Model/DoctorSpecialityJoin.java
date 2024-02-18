package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorSpecialityJoin {
    static DB connect = DB.getInstance();
    static Connection con = connect.getConnection();
    public ArrayList<DoctorSpeciality> getDoctorSpeciality(int spid)throws SQLException{
        String query = "SELECT hospital.name,hospital.phone_no,doctor.doctorname,doctor.ph_no,speciality.department from doctor join speciality on doctor.specialityId = speciality.sp_id join hospital on doctor.h_id = hospital.h_id where doctor.SpecialityId =?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,spid);
        ResultSet rs = prepare.executeQuery();
        ArrayList<DoctorSpeciality> doclist = new ArrayList<>();
        while(rs.next()){
            DoctorSpeciality ds = new DoctorSpeciality();
            ds.setHospitalName(rs.getString(1));
            ds.setHospitalPhone(rs.getString(2));
            ds.setDoctorName(rs.getString(3));
            ds.setDoctorPhone(rs.getString(4));
            ds.setSpeciality(rs.getString(5));
            doclist.add(ds);
        }
        return doclist;
    }
}
