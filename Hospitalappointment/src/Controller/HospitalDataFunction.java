package Controller;

import Model.Hospital;
import Model.HospitalAccess;

import java.sql.SQLException;
import java.util.ArrayList;

public class HospitalDataFunction {
    private int uid;
    private HospitalAccess hosAcc = new HospitalAccess();
    private Hospital hos = new Hospital();
    public HospitalDataFunction(int uid){
        this.uid = uid;
    }
    public HospitalDataFunction(){

    }
    public Hospital getHospital(int uid)throws SQLException {
         return hosAcc.getHospital(uid);
    }
    public void addHospital(Hospital hos1)throws SQLException{
        hosAcc.addHospital(hos1);
    }
    public ArrayList<Hospital> getAllHospital()throws SQLException{
        return hosAcc.getAllHospital();
    }
}
