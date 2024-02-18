package Controller;

import Model.DoctorSpeciality;
import Model.DoctorSpecialityJoin;

import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorSpecialityDataFunction {
    DoctorSpecialityJoin DSJ = new DoctorSpecialityJoin();
    public ArrayList<DoctorSpeciality> getDoctorSpec(int spid)throws SQLException{
        return DSJ.getDoctorSpeciality(spid);
    }
}
