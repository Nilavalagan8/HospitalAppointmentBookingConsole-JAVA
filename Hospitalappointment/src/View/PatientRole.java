package View;

import Controller.PatientDataFunction;
import Model.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientRole {
    private int uid;
    Scanner sc = new Scanner(System.in);
    PatientDataFunction PDF = new PatientDataFunction();
    public int choosePatient(int uid)throws SQLException {
        ArrayList<Patient> alist= PDF.getPatientViaUser(uid);
        int id =0;
        if(alist.size()==0){
            System.out.println("You don't have a old patient");
            System.out.println("Add a new patient");
            id =-1;
        }
        else if(alist.size()==1){
            id = alist.get(0).getPatientId();
        }
        else{
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s ","PATIENT-ID","PATIENT-NAME","PADIENT-DOB","PHONE-NO","ADDRESS");
            for(int i=0;i<alist.size();i++){
                System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s ",alist.get(i).getPatientId(),alist.get(i).getPatientName(),
                        alist.get(i).getdOB(),alist.get(i).getPhoneNo(),alist.get(i).getAddress());
            }
            System.out.println("Enter patient id Or -1 if patient not found");
            int pid = sc.nextInt();
            id = pid;
        }
        return  id;
    }
    public int addPatient(int uid)throws SQLException{
        System.out.println("Enter patient name:");
        String pName = sc.nextLine();
        System.out.println("Enter Date of Birth:(YYYY-MM-DD)");
        String pDOB = sc.nextLine();
        System.out.println("Enter Phone Number:");
        String phNo = sc.nextLine();
        System.out.println("Enter address");
        String add = sc.nextLine();
        Patient p = new Patient();
        p.setPatientName(pName);
        p.setdOB(pDOB);
        p.setPhoneNo(phNo);
        p.setAddress(add);
        p.setUserId(uid);
        PDF.addNewPatient(p);
        return PDF.getPatient(pName,phNo).getPatientId();
    }

}
