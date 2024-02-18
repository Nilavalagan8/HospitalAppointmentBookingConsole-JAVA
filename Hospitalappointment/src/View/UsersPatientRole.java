package View;

import java.sql.SQLException;
import java.util.Scanner;

public class UsersPatientRole {
    Scanner sc = new Scanner(System.in);
    private int uid;
    public UsersPatientRole(int uid)throws SQLException{
        this.uid = uid;
        start();
    }
    private void start() throws SQLException {
        boolean isStart = true;
        while(isStart){
            System.out.println("Book a Appointment           -1");
            System.out.println("View today Appointment       -2");
            System.out.println("view All Appointment         -3");
            System.out.println("List the hospital            -4");
            System.out.println("Search based on speciality   -5");
            System.out.println("Exit                         -6");
            int flag = sc.nextInt();
            BookingRole b = new BookingRole();
            ListingView BDV = new ListingView();
            if(flag==1){
                b.bookAppoint(uid);
            }
            else if(flag==2){
                b.viewTodayAppointmentViaUser(uid);
            }
            else if(flag==3){
                b.viewAllAppointmentViaUser(uid);
            }
            else if(flag==4){
                BDV.viewHospitals();
            }
            else if(flag==5){
                ListingView LV = new ListingView();
                LV.viewBasedSpeciality();
            }
            else if(flag==6){
                isStart = false;
            }
            else{
                System.out.println("Enter a correct key");
            }
        }
    }
}
