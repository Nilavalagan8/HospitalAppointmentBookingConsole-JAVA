package View;

import Controller.HospitalDataFunction;
import Model.Hospital;
import Model.HospitalAccess;

import java.sql.SQLException;
import java.util.Scanner;

public class HospitalRole {
    Scanner sc = new Scanner(System.in);
    private int userId;
    private Hospital hos = new Hospital();
    public HospitalDataFunction hosp;
    public HospitalRole(int userId)throws SQLException {
        this.userId = userId;
        hosp = new HospitalDataFunction();
        hos = hosp.getHospital(userId);
        start();
    }
    private void start()throws SQLException{
        boolean flag = true;
        while(flag){
            System.out.println("View the today appointment  -1");
            System.out.println("Remove doctor               -2");
            System.out.println("View all appointment        -3");
            System.out.println("Add Doctor                  -4");
            System.out.println("Exit                        -5");
            int hosrole = sc.nextInt();
            if(hosrole==1){
               BookingRole ba = new BookingRole();
               ba.todayAppointmentHos(hos.getHospitalId());
            }
            else if(hosrole==2){
                DoctorRole da = new DoctorRole(hos.getHospitalId());
                da.deleteDoctor();
            }
            else if(hosrole==3){
                BookingRole ba = new BookingRole();
                ba.viewAllAppointmentHos(hos.getHospitalId());
            }
            else if(hosrole==4){
                DoctorRole da = new DoctorRole(hos.getHospitalId());
                da.addDoctor();
            }
            else if(hosrole==5){
                flag = false;
            }
            else{
                System.out.println("Enter a correct Key");
            }
        }
    }
}
