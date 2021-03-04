//Booking Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Booking;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class booking {
    private static DataAccessLayer DAL = new DataAccessLayer();
    public void CreateBooking(int iiBookingid, int iiCustomer_ID,String ssCustomer_Name,Date dDate_Created, String sBooking_status, int dEvent_ID,Date dEvent_date, Time tEvent_time,String sVenue_ID,int iTotal_Adults,int iTotal_Kids) {
        // Code to write to Bookings tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
        String InsertCusQuery = ("INSERT INTO tblBookings (Customer_ID, Customer_Name, Date_Created, Booking_Status,Event_ID,Event_Date,Event_Time,Venue_ID,Total_Adults,Total_Kids) VALUES ('"
        + iiCustomer_ID + "','" + ssCustomer_Name + "','" + dDate_Created + "','" + sBooking_status +"','" + dEvent_ID+"','" + dEvent_date+"','" + tEvent_time+"','" + sVenue_ID+ "','" + iTotal_Adults+"','" + iTotal_Kids+"')");


try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
        PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertCusQuery);) {
    prepsInsertProduct.execute();

}
// Handle any errors that may have occurred.
catch (Exception e) {
    e.printStackTrace();
    }
}



    public List<Booking> ReadAllBookings() {
        List<Booking> BookingList = new ArrayList<Booking>();
        
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            String selectSql = "SELECT * from tblBookings";
            resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                BookingList.add(new Booking(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                        resultSet.getDate(4), resultSet.getString(5),resultSet.getInt(6),resultSet.getDate(7),resultSet.getTime(8),resultSet.getInt(9),resultSet.getInt(10),resultSet.getInt(11)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        

        return BookingList;
        // Return list of records
    }

    public Booking ReadBooking(int Booking_ID) {
        Booking booking = new Booking();
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblBookings WHERE Booking_ID = '" + Booking_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                //booking.set;
                //booking.setTotal_Price(resultSet.getFloat(2));
                //booking.setDeposit(resultSet.getFloat(3));
                //booking.setIs_Fully_Paid(resultSet.getInt(4));
                //booking.setIs_Deposit_Paid(resultSet.getInt(5));
               // booking.setbooking_ID(resultSet.getInt(6));
                //booking.setTotal_Price(resultSet.getFloat(7));
                //booking.setDeposit(resultSet.getFloat(8));
                //booking.setIs_Fully_Paid(resultSet.getInt(9));
                //booking.setIs_Deposit_Paid(resultSet.getInt(10));
                //booking.setIs_Deposit_Paid(resultSet.getInt(11));

                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booking;
        
    }

    public void UpdateBooking(Booking oldBooking, Booking newBooking) {
        // Code to update old Booking record to new Booking Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteBooking(Booking BookingObj) {
        // Code to delete specific Booking from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
}