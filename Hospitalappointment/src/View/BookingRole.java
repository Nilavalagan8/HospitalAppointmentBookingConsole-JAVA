package View;

import Controller.BookingDataFunction;
import Model.Booking;
import Model.BookingDetail;
import Model.SelectDoctor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingRole {
    Scanner sc= new Scanner(System.in);
    int userId;
    int hosId;
    BookingDataFunction BDF = new BookingDataFunction();

    public void todayAppointmentHos(int h_id)throws SQLException {
        System.out.println("Enter today date(YYYY-MM-DD)");
        String date = sc.nextLine();
        BookingDataFunction GBD = new BookingDataFunction();
        ArrayList<BookingDetail> alist = GBD.getBookingDetail(h_id,date);
        if(alist.size()>0) {
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                    "PATIENTNAME", "AGE", "PATIENT-MOBILE", "HOSPITAL", "HOSPITAL-CONTACT", "HOSPITAL-ADDRESS", "SPECIALITY", "DOCTOR", "DOCTOR-CONTACT", "DATE", "PATIENTMAIL");
            for (int i = 0; i < alist.size(); i++) {
                System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                        alist.get(i).getPatientName(), alist.get(i).getAge(), alist.get(i).getPatientPhoneNo(),
                        alist.get(i).getHospitalName(), alist.get(i).getHospitalPhoneNo(),
                        alist.get(i).getHospitalAddress(), alist.get(i).getSpecialityDept(), alist.get(i).getDoctorName(),
                        alist.get(i).getDoctorPhone(), alist.get(i).getBookingDate(), alist.get(i).getMail());
            }
        }
        else{
            System.out.println("No appointment booked");
        }
    }
    public void viewAllAppointmentHos(int h_id)throws SQLException{
        BookingDataFunction GBD = new BookingDataFunction();
        ArrayList<BookingDetail> alist = GBD.getAllBookingHos(h_id);
        if(alist.size()>0) {
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                    "PATIENTNAME", "AGE", "PATIENT-MOBILE", "HOSPITAL", "HOSPITAL-CONTACT", "HOSPITAL-ADDRESS", "SPECIALITY", "DOCTOR", "DOCTOR-CONTACT", "DATE", "PATIENTMAIL");
            for (int i = 0; i < alist.size(); i++) {
                System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                        alist.get(i).getPatientName(), alist.get(i).getAge(), alist.get(i).getPatientPhoneNo(),
                        alist.get(i).getHospitalName(), alist.get(i).getHospitalPhoneNo(),
                        alist.get(i).getHospitalAddress(), alist.get(i).getSpecialityDept(), alist.get(i).getDoctorName(),
                        alist.get(i).getDoctorPhone(), alist.get(i).getBookingDate(), alist.get(i).getMail());
            }
        }
        else{
            System.out.println("No Bookings");
        }
    }
    public void viewAllAppointmentViaUser(int uid)throws SQLException{
        ArrayList<BookingDetail> alist = BDF.getAllBookingViaUser(uid);
        System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                "PATIENTNAME","AGE","PATIENT-MOBILE","HOSPITAL","HOSPITAL-CONTACT","HOSPITAL-ADDRESS","SPECIALITY","DOCTOR","DOCTOR-CONTACT","DATE","PATIENTMAIL");
        for(int i=0;i<alist.size();i++) {
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                    alist.get(i).getPatientName(), alist.get(i).getAge(), alist.get(i).getPatientPhoneNo(),
                    alist.get(i).getHospitalName(), alist.get(i).getHospitalPhoneNo(),
                    alist.get(i).getHospitalAddress(), alist.get(i).getSpecialityDept(), alist.get(i).getDoctorName(),
                    alist.get(i).getDoctorPhone(), alist.get(i).getBookingDate(), alist.get(i).getMail());
        }
    }
    public void viewTodayAppointmentViaUser(int uid)throws SQLException{
        System.out.println("Enter today Date (YYYY-MM-DD)");
        String s = sc.nextLine();
        ArrayList<BookingDetail> alist = BDF.getTodaybookingUser(uid,s);
        System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                "PATIENTNAME","AGE","PATIENT-MOBILE","HOSPITAL","HOSPITAL-CONTACT","HOSPITAL-ADDRESS","SPECIALITY","DOCTOR","DOCTOR-CONTACT","DATE","PATIENTMAIL");
        for(int i=0;i<alist.size();i++) {
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                    alist.get(i).getPatientName(), alist.get(i).getAge(), alist.get(i).getPatientPhoneNo(),
                    alist.get(i).getHospitalName(), alist.get(i).getHospitalPhoneNo(),
                    alist.get(i).getHospitalAddress(), alist.get(i).getSpecialityDept(), alist.get(i).getDoctorName(),
                    alist.get(i).getDoctorPhone(), alist.get(i).getBookingDate(), alist.get(i).getMail());
        }
    }
        public void bookAppoint(int uid)throws SQLException{
            boolean isBook = true;
            int patId=-1;
            while(isBook) {
                System.out.println("patient already added  -1");
                System.out.println("Add a new patient      -2");
                int flag =sc.nextInt();
                PatientRole pr = new PatientRole();
                if(flag==1){
                    int pid = pr.choosePatient(uid);
                    patId = pid;
                    if(pid ==-1 ){
                        int uId = pr.addPatient(uid);
                        patId = uId;
                    }
                    else{
                        isBook = false;
                    }
                }
                else if(flag==2){
                    patId = pr.addPatient(uid);
                    isBook = false;
                }
                else{
                    System.out.println("Enter a correct key");
                }
            }
            int hosId =-1;
            ListingView sh = new ListingView();
            hosId = sh.chooseHospital();
            SelectDoctor sd = sh.selectDoctor(hosId);
            System.out.println("Enter the appointment Date(YYYY-MM-DD)");
            sc.nextLine();
            String date = sc.nextLine();
            Booking b = new Booking();
            b.setDoctorId(sd.getDoctorId());
            b.setBookingDate(date);
            b.setHospitalId(hosId);
            b.setUserId(uid);
            b.setPatientId(patId);
            b.setSpecialityId(sd.getSpecialityId());
            BDF.addBooking(b);
        }
}
