package Controller;

import Model.Patient;
import Model.PatientAccess;

import java.sql.SQLException;
import java.util.ArrayList;

public class PatientDataFunction {
    PatientAccess pa =new PatientAccess();
    public ArrayList<Patient> getPatientViaUser(int uid)throws SQLException{
        return pa.getPatientViaUser(uid);
    }
    public void addNewPatient(Patient p)throws SQLException{
        pa.addPatient(p);
    }
    public Patient getPatient(String name,String num)throws SQLException{
        return pa.getPatient(name,num);
    }
}
