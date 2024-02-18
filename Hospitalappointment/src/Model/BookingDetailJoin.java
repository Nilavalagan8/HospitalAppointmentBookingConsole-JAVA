package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDetailJoin {
    static DB connect = DB.getInstance();
    static Connection con = connect.getConnection();
    public ArrayList<BookingDetail> getBookingDetail(int h_id,String date)throws SQLException {
        String query ="select patient.Pa_name,DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),patient.dob)), '%Y') +0 AS age,patient.ph_no,hospital.name,hospital.phone_no,hospital.address,speciality.department,doctor.doctorname,doctor.ph_no,booking.bdate,users.mail from booking join patient on booking.pa_id = patient.Pa_id  join hospital on booking.hos_id = hospital.h_id join speciality on booking.s_id = speciality.sp_id join doctor on booking.d_id = doctor.doctor_id join users on booking.user_id = users.u_id where booking.BDate =? and booking.hos_id =? order by booking.BDate";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,date);
        prepare.setInt(2,h_id);
        ResultSet rs = prepare.executeQuery();
        ArrayList<BookingDetail>bookD = new ArrayList<>();
        while(rs.next()){
            BookingDetail book = new BookingDetail();
            book.setPatientName(rs.getString(1));
            book.setAge(rs.getInt(2));
            book.setPatientPhoneNo(rs.getString(3));
            book.setHospitalName(rs.getString(4));
            book.setHospitalPhoneNo(rs.getString(5));
            book.setHospitalAddress(rs.getString(6));
            book.setSpecialityDept(rs.getString(7));
            book.setDoctorName(rs.getString(8));
            book.setDoctorPhone(rs.getString(9));
            book.setBookingDate(rs.getString(10));
            book.setMail(rs.getString(11));
            bookD.add(book);
        }
        return bookD;
    }
    public ArrayList<BookingDetail> getAllBookingDetailHos(int h_id)throws SQLException {
        String query ="select patient.Pa_name,DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),patient.dob)), '%Y') +0 AS age,patient.ph_no,hospital.name,hospital.phone_no,hospital.address,speciality.department,doctor.doctorname,doctor.ph_no,booking.bdate,users.mail from booking join patient on booking.pa_id = patient.Pa_id  join hospital on booking.hos_id = hospital.h_id join speciality on booking.s_id = speciality.sp_id join doctor on booking.d_id = doctor.doctor_id join users on booking.user_id = users.u_id where booking.hos_id =? order by booking.BDate";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,h_id);
        ResultSet rs = prepare.executeQuery();
        ArrayList<BookingDetail>bookD = new ArrayList<>();
        while(rs.next()){
            BookingDetail book = new BookingDetail();
            book.setPatientName(rs.getString(1));
            book.setAge(rs.getInt(2));
            book.setPatientPhoneNo(rs.getString(3));
            book.setHospitalName(rs.getString(4));
            book.setHospitalPhoneNo(rs.getString(5));
            book.setHospitalAddress(rs.getString(6));
            book.setSpecialityDept(rs.getString(7));
            book.setDoctorName(rs.getString(8));
            book.setDoctorPhone(rs.getString(9));
            book.setBookingDate(rs.getString(10));
            book.setMail(rs.getString(11));
            bookD.add(book);
        }
        return bookD;
    }
    public ArrayList<BookingDetail> getAllBookingViaUser(int uid)throws SQLException{
        String query = "select patient.Pa_name,DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),patient.dob)), '%Y') +0 AS age,patient.ph_no,hospital.name,hospital.phone_no,hospital.address,speciality.department,doctor.doctorname,doctor.ph_no,booking.bdate,users.mail from booking join patient on booking.pa_id = patient.Pa_id  join hospital on booking.hos_id = hospital.h_id join speciality on booking.s_id = speciality.sp_id join doctor on booking.d_id = doctor.doctor_id join users on booking.user_id = users.u_id where booking.user_id =?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,uid);
        ResultSet rs = prepare.executeQuery();
        ArrayList<BookingDetail> bd = new ArrayList<>();
        while(rs.next()){
            BookingDetail book = new BookingDetail();
            book.setPatientName(rs.getString(1));
            book.setAge(rs.getInt(2));
            book.setPatientPhoneNo(rs.getString(3));
            book.setHospitalName(rs.getString(4));
            book.setHospitalPhoneNo(rs.getString(5));
            book.setHospitalAddress(rs.getString(6));
            book.setSpecialityDept(rs.getString(7));
            book.setDoctorName(rs.getString(8));
            book.setDoctorPhone(rs.getString(9));
            book.setBookingDate(rs.getString(10));
            book.setMail(rs.getString(11));
            bd.add(book);
        }
        return  bd;
    }
    public ArrayList<BookingDetail> getBookingDetailViaUser(int uid,String date)throws SQLException {
        String query ="select patient.Pa_name,DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),patient.dob)), '%Y') +0 AS age,patient.ph_no,hospital.name,hospital.phone_no,hospital.address,speciality.department,doctor.doctorname,doctor.ph_no,booking.bdate,users.mail from booking join patient on booking.pa_id = patient.Pa_id  join hospital on booking.hos_id = hospital.h_id join speciality on booking.s_id = speciality.sp_id join doctor on booking.d_id = doctor.doctor_id join users on booking.user_id = users.u_id where booking.BDate =? and booking.user_id =? order by booking.BDate";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,date);
        prepare.setInt(2,uid);
        ResultSet rs = prepare.executeQuery();
        ArrayList<BookingDetail>bookD = new ArrayList<>();
        while(rs.next()){
            BookingDetail book = new BookingDetail();
            book.setPatientName(rs.getString(1));
            book.setAge(rs.getInt(2));
            book.setPatientPhoneNo(rs.getString(3));
            book.setHospitalName(rs.getString(4));
            book.setHospitalPhoneNo(rs.getString(5));
            book.setHospitalAddress(rs.getString(6));
            book.setSpecialityDept(rs.getString(7));
            book.setDoctorName(rs.getString(8));
            book.setDoctorPhone(rs.getString(9));
            book.setBookingDate(rs.getString(10));
            book.setMail(rs.getString(11));
            bookD.add(book);
        }
        return bookD;
    }
    public ArrayList<SelectDoctor> getDocUser(int hosId)throws SQLException{
        String query = "Select doctor.doctor_id,doctor.doctorname,doctor.ph_no,speciality.sp_id,speciality.department from doctor join speciality on doctor.specialityid = speciality.sp_id where h_id =?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,hosId);
        ResultSet rs = prepare.executeQuery();
        ArrayList<SelectDoctor> alist = new ArrayList<>();
        while(rs.next()){
            SelectDoctor sd = new SelectDoctor();
            sd.setDoctorId(rs.getInt(1));
            sd.setDoctorName(rs.getString(2));
            sd.setDoctorPhone(rs.getString(3));
            sd.setSpecialityId(rs.getInt(4));
            sd.setSpecialityDepartment(rs.getString(5));
            alist.add(sd);
        }
        return alist;
    }

}
