package Model;

import Model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingAccess {
    static DB connect = DB.getInstance();
    static Connection con = connect.getConnection();
    public void addbooking(Booking book)throws SQLException{
        String query = "insert into booking(hos_id,pa_id,s_id,D_id,BDate,user_id)values(?,?,?,?,?,?)";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,book.getHospitalId());
        prepare.setInt(2,book.getPatientId());
        prepare.setInt(3,book.getSpecialityId());
        prepare.setInt(4,book.getDoctorId());
        prepare.setString(5,book.getBookingDate());
        prepare.setInt(6,book.getUserId());
        prepare.executeUpdate();
    }
    public ArrayList<Booking> getAllHosBooking(int hId)throws SQLException{
        String query = "select*from booking where hos_id=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,hId);
        ResultSet rs = prepare.executeQuery();
        ArrayList<Booking> book = new ArrayList<>();
        while(rs.next()){
            Booking b = new Booking();
            b.setBookingId(rs.getInt(1));
            b.setHospitalId(rs.getInt(2));
            b.setPatientId(rs.getInt(3));
            b.setSpecialityId(rs.getInt(4));
            b.setDoctorId(rs.getInt(5));
            b.setBookingDate(rs.getString(6));
            b.setUserId(rs.getInt(7));
            book.add(b);
        }
        return book;
    }
    public ArrayList<Booking> getAllUseBooking(int userId)throws SQLException{
        String query = "select*from booking where user_id=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,userId);
        ResultSet rs = prepare.executeQuery();
        ArrayList<Booking> book = new ArrayList<>();
        while(rs.next()){
            Booking b = new Booking();
            b.setBookingId(rs.getInt(1));
            b.setHospitalId(rs.getInt(2));
            b.setPatientId(rs.getInt(3));
            b.setSpecialityId(rs.getInt(4));
            b.setDoctorId(rs.getInt(5));
            b.setBookingDate(rs.getString(6));
            b.setUserId(rs.getInt(7));
            book.add(b);
        }
        return book;
    }
    public void delBookingRecord(int dId)throws SQLException{
        String query = "delete from booking where D_id=?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setInt(1,dId);
        prepare.executeUpdate();
    }
}
