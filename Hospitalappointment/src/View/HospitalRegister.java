package View;

import Controller.HospitalDataFunction;
import Controller.UserDataFunction;
import Model.Hospital;

import java.sql.SQLException;
import java.util.Scanner;

public class HospitalRegister {
    Valid v = new Valid();
    Scanner sc = new Scanner(System.in);
    public HospitalRegister()throws SQLException{
        addUser();
    }
    private void addUser()throws SQLException {
        System.out.println("Enter your mail");
        String mail = sc.nextLine();
        UserDataFunction UDF = new UserDataFunction(mail);
        if(!UDF.findUser()){
            String pass1 = v.getPassWord();
            UserDataFunction UDF1 = new UserDataFunction(mail,pass1);
            UDF1.addUser("HOSPITAL");
            addHospital(mail);
        }
        else{
            System.out.println("Mail alreary exist");
        }
    }
    public void addHospital(String mail)throws SQLException{
        UserDataFunction UDF2 = new UserDataFunction();
        int uId = UDF2.getUserId(mail);
        System.out.println("Enter Hospital Name:");
        String hosName = sc.nextLine();
        System.out.println("Enter Hospital Contact Number ");
        String hosContact = sc.nextLine();
        System.out.println("Enter Hospital Address");
        String hosAddress = sc.nextLine();
        Hospital hos = new Hospital();
        hos.setName(hosName);
        hos.setPhN0(hosContact);
        hos.setAdd(hosAddress);
        hos.setuId(uId);
        HospitalDataFunction HDF = new HospitalDataFunction();
        HDF.addHospital(hos);
        int hosId = HDF.getHospital(uId).getHospitalId();
        DoctorRole DR = new DoctorRole(hosId);
        DR.addDoctor();
    }
}
