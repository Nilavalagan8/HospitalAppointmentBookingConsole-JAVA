package View;

import Controller.SpecialityDataFunction;
import Model.Speciality;
import Model.SpecialityAccess;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpecialityRole {
Scanner sc = new Scanner(System.in);
    Speciality spec;
    SpecialityAccess specAcc = new SpecialityAccess();
    SpecialityDataFunction SDF = new SpecialityDataFunction();
    ArrayList<Speciality> speclist;
    public int getSpecialityIdHos()throws SQLException{
        System.out.println("Choose Speciality    --1");
        int speId = chooseSpeciality();
        int id=0;
        if(speId==-1){
            sc.nextLine();
            System.out.println("Enter Speciality");
            String s = sc.nextLine();
            addSpeciality(s);
            int spid = SDF.getSpeciality(s).getSpecialityId();
            id = spid;
        }
        else{
            id = speId;
        }
        return id;
    }
    public int chooseSpeciality()throws SQLException {
        speclist = SDF.getAllSpeciality();
        System.out.printf("%-15s %-20s\n",
                "SPECIALITY_ID","SPECIALITY");
        for(int i=0;i<speclist.size();i++){
            System.out.printf("%-15s %-20s\n",
                    speclist.get(i).getSpecialityId(),speclist.get(i).getDepartment());
        }
        System.out.println("Other Speciality '-1' ");
        System.out.println("Enter Speciality Id");
        int specId = sc.nextInt();
        return specId;
    }
    public int chooseSpecialityViaUser()throws SQLException {
        speclist = SDF.getAllSpeciality();
        System.out.printf("%-15s %-20s\n",
                "SPECIALITY_ID","SPECIALITY");
        for(int i=0;i<speclist.size();i++){
            System.out.printf("%-15s %-20s\n",
                    speclist.get(i).getSpecialityId(),speclist.get(i).getDepartment());
        }
        boolean isBreak = true;
        System.out.println("Enter Speciality Id");
        int specId = sc.nextInt();
        return specId;
    }
    public void addSpeciality(String spec)throws SQLException{
        SDF.addSpeciality(spec);
    }
}
