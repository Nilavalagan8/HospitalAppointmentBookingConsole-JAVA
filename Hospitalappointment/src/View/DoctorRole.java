package View;

import Controller.DoctorDataFunction;
import Model.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorRole {
    Scanner sc = new Scanner(System.in);
    int hid;
    Doctor doc;
    public DoctorRole(int hid){
        this.hid=hid;
    }
    public void deleteDoctor()throws SQLException {
        System.out.println("choose Doctor below the list --1");
        System.out.println("Enter Doctor Name            --2");
        DoctorDataFunction dDF = new DoctorDataFunction();
        ArrayList<Doctor> delData;
        int delDoc = sc.nextInt();
        if(delDoc==1){
            delData = dDF.getAllDoctorDataHos(hid);
            System.out.printf("%-15s %-20s %-20s %-20s\n",
                    "DOCTOR_ID","DOCTOR_NAME","SPECIALITY","HOSPITAL_ID");
            for(int i=0;i<delData.size();i++){
                System.out.printf("%-15s %-20s %-20s %-20s\n",
                        delData.get(i).getDoctorId(),delData.get(i).getName(),delData.get(i).getSpecialityId(),delData.get(i).getHospitalId());
            }
            System.out.println("Enter Doctor id to delete");
            int docId = sc.nextInt();
            dDF.delDoctor(docId);
        }
        else if(delDoc==2){
            String name = sc.nextLine();
            delData = dDF.getDoctorDataHos(name,hid);
            if(delData.size()>1){
                for(int i=0;i<delData.size();i++){
                    System.out.printf("%-15s %-20s %-20s %-20s %-20s\n",
                            delData.get(i).getDoctorId(),delData.get(i).getName(),delData.get(i).getSpecialityId(),delData.get(i).getHospitalId());
                }
                System.out.println("Enter doctor id:");
                int ddId = sc.nextInt();
                dDF.delDoctor(ddId);
            }
            else{
                dDF.delDoctor(delData.get(0).getDoctorId());
            }
        }
    }
    public void addDoctor()throws SQLException{
        doc = new Doctor();
        System.out.println("Enter Doctor Name:");
        String dName = sc.nextLine();
        System.out.println("Enter Doctor Phone:");
        String dPhone = sc.nextLine();
        SpecialityRole sA = new SpecialityRole();
         int s_id = sA.getSpecialityIdHos();
        Doctor d = new Doctor();
        d.setName(dName);
        d.setPhone(dPhone);
        d.setSpecialityId(s_id);
        d.setHospitalId(hid);
        DoctorDataFunction DDF = new DoctorDataFunction();
        DDF.addDoctor(d);
    }
}
