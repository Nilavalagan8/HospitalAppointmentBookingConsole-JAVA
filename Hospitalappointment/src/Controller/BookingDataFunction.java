package Controller;

import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDataFunction {
    BookingDetailJoin BDJ = new BookingDetailJoin();
    BookingAccess BA = new BookingAccess();
    public BookingDataFunction(){
    }
    public ArrayList<BookingDetail> getBookingDetail(int hId,String date)throws SQLException {
        return BDJ.getBookingDetail(hId,date);
    }
    public ArrayList<BookingDetail> getAllBookingHos(int hid)throws SQLException{
        return BDJ.getAllBookingDetailHos(hid);
    }
    public ArrayList<SelectDoctor> getDocUser(int hosid)throws SQLException{
        return BDJ.getDocUser(hosid);
    }
    public void addBooking(Booking book)throws SQLException{
        BA.addbooking(book);
    }
    public ArrayList<BookingDetail> getAllBookingViaUser(int uid)throws SQLException{
        return BDJ.getAllBookingViaUser(uid);
    }
    public ArrayList<BookingDetail> getTodaybookingUser(int uid,String date)throws SQLException{
        return BDJ.getBookingDetailViaUser(uid,date);
    }
}
