package Controller;

import Model.BookingAccess;
import Model.Doctor;
import Model.DoctorAccess;

import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDataFunction {
    ArrayList<Doctor> doctor_data ;
    ArrayList<Doctor> allDoctorData;
    DoctorAccess da;
    BookingAccess bA;

    public DoctorDataFunction(){
         da = new DoctorAccess();
    }

    public ArrayList<Doctor> getAllDoctorDataHos(int hId)throws SQLException{
        return da.getAllDoctor(hId);
    }

    public ArrayList<Doctor> getDoctorDataHos(String name,int did)throws SQLException{
        return da.getDoctor(name,did);
    }

    public void delDoctor(int dId)throws SQLException{
        bA=new BookingAccess();
        bA.delBookingRecord(dId);
        da.delDoctor(dId);
    }
    public void addDoctor(Doctor doc)throws SQLException{
        DoctorAccess da = new DoctorAccess();
        da.addDoctor(doc);
    }
}
