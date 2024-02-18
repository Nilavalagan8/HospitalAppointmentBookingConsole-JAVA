package View;

import Controller.BookingDataFunction;
import Controller.HospitalDataFunction;
import Model.DoctorSpeciality;
import Model.DoctorSpecialityJoin;
import Model.Hospital;
import Model.SelectDoctor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListingView {
    private Scanner sc = new Scanner(System.in);
    private HospitalDataFunction HDF = new HospitalDataFunction();
    private BookingDataFunction BDF = new BookingDataFunction();
    private DoctorSpecialityJoin DSJ = new DoctorSpecialityJoin();
    public int chooseHospital()throws SQLException {
        ArrayList<Hospital> hosList = new ArrayList<>();
        hosList = HDF.getAllHospital();
        System.out.println("Choose Hospital");
        System.out.printf("%-15s %-20s %-20s %-20s \n","HOSPITAL-ID","HOSPITAL-NAME","HOSPITAL-CONTACT","HOSPITAL-ADDRESS");
        for(int i=0;i<hosList.size();i++){
            System.out.printf("%-15s %-20s %-20s %-20s \n",hosList.get(i).getHospitalId(),hosList.get(i).getName(),hosList.get(i).getPhN0(),hosList.get(i).getAdd());
        }
        System.out.println("Enter hospital id");
        int hid = sc.nextInt();
        return hid;
    }
    public SelectDoctor selectDoctor(int hosid)throws SQLException{
         ArrayList<SelectDoctor> al = BDF.getDocUser(hosid);
        System.out.printf("%-15s %-20s %-20s %-20s\n","DOCTOR-NAME","DOCTOR-CONTACT","SPECIALITY","KEY");
        for(int i=0;i<al.size();i++){
            System.out.printf("%-15s %-20s %-20s %-20s \n",al.get(i).getDoctorName(),
                    al.get(i).getDoctorPhone(),al.get(i).getSpecialityDepartment(),i+1);
        }
        System.out.println("Enter a key");
        boolean iscorr = true;
        int key1=0;
        while(iscorr) {
            int key = sc.nextInt();
            if (key > al.size() && key < 0) {
                System.out.println("Enter a correct key");
            } else {
                key1 = key-1;
                iscorr = false;
            }
        }
        return al.get(key1);
    }
    public void viewHospitals()throws SQLException{
        ArrayList<Hospital> hosList = HDF.getAllHospital();
        System.out.printf("%-15s %-20s %-20s %-20s \n","HOSPITAL-ID","HOSPITAL-NAME","HOSPITAL-CONTACT","HOSPITAL-ADDRESS");
        for(int i=0;i<hosList.size();i++){
            System.out.printf("%-15s %-20s %-20s %-20s \n",hosList.get(i).getHospitalId(),hosList.get(i).getName(),hosList.get(i).getPhN0(),hosList.get(i).getAdd());
        }
    }
    public void viewBasedSpeciality()throws SQLException{
        SpecialityRole sr = new SpecialityRole();
        int sId = sr.chooseSpecialityViaUser();
        ArrayList<DoctorSpeciality> dlist = DSJ.getDoctorSpeciality(sId);
        System.out.printf("%-15s %-20s %-20s %-20s %-20s\n","HOSPITAL-NAME","HOSPITAL-CONTACT","DOCTOR-NAME","DOCTOR-CONTACT","SPECIALITY");
        for(int i=0;i<dlist.size();i++){
            System.out.printf("%-15s %-20s %-20s %-20s %-20s\n",dlist.get(i).getHospitalName(),dlist.get(i).getHospitalPhone(),
                    dlist.get(i).getDoctorName(),dlist.get(i).getDoctorPhone(),dlist.get(i).getSpeciality());
        }
    }
}
