package Controller;

import Model.Speciality;
import Model.SpecialityAccess;

import java.sql.SQLException;
import java.util.ArrayList;

public class SpecialityDataFunction {
    private SpecialityAccess sa = new SpecialityAccess();
    private Speciality sp = new Speciality();
    public void addSpeciality(String spe)throws SQLException {
        sp.setDepartment(spe);
        sa.addSpeciality(sp);
    }
    public ArrayList<Speciality> getAllSpeciality()throws SQLException{
        return sa.getAllSpecility();
    }
    public Speciality getSpeciality(String spe)throws SQLException{
        return sa.getSpeciality(spe);
    }
}
