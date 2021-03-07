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

public class BookingDH {
    private static DataAccessLayer DAL = new DataAccessLayer();
    public void CreateBooking(Booking newBooking) {
        // Code to write to Bookings tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
        String InsertCusQuery = ("INSERT INTO tblBookings (Customer_ID, Customer_Name, Date_Created, Booking_Status,Event_ID,Event_Date,Event_Time,Venue_ID,Total_Adults,Total_Kids) VALUES ('"
        + newBooking.getCustomerID() + "','" + newBooking.getCustomer_Name() + "','" + newBooking.getDateCreated() + "','" + newBooking.getBooking_Status() +"','" + newBooking.getEvent_ID()+"','" + newBooking.getEvent_Date()+"','" + newBooking.getEvent_Time()+"','" + newBooking.getVenue_ID()+ "','" + newBooking.getTotal_Adults()+"','" + newBooking.getTotal_Kids()+"')");


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
                        resultSet.getDate(4), resultSet.getString(5),resultSet.getInt(6),resultSet.getDate(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getInt(10),resultSet.getInt(11)));
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
                booking.setBookingID(resultSet.getInt(1));
                booking.setCustomerID(resultSet.getInt(2));
                booking.setCustomer_Name(resultSet.getString(3));
                booking.setDateCreated(resultSet.getDate(4));
                booking.setBooking_Status(resultSet.getString(5));       
                booking.setEvent_ID(resultSet.getInt(6));
                booking.setEvent_Date(resultSet.getDate(7));
                booking.setEvent_Time(resultSet.getString(8));
                booking.setVenue_ID(resultSet.getInt(9));
                booking.setTotal_Adults(resultSet.getInt(10));
                booking.setTotal_Kids(resultSet.getInt(11));
                


             

                
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

        String UPDATECusQuery = ("UPDATE  tblBookings SET Customer_ID = '" + newBooking.getCustomerID() + "', Customer_Name = '"  + newBooking.getCustomer_Name() + "', Date_Created = '"  + newBooking.getDateCreated() + "', Booking_Status = '"  + newBooking.getBooking_Status() + "', Event_ID = '"  + newBooking.getEvent_ID() + "', Event_Date = '"  + newBooking.getEvent_Date() + "', Event_Time = '"  + newBooking.getEvent_Time() + "', Venue_ID = '"  + newBooking.getVenue_ID() + "', Total_Adults = '"  + newBooking.getTotal_Adults() + "', Total_Kids = '"  + newBooking.getTotal_Kids() + "'"  + " WHERE Booking_ID = '" + oldBooking.getBookingID() + "'") ;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
             PreparedStatement prepsUpdateProduct = connection.prepareStatement(UPDATECusQuery);) 
         {
             prepsUpdateProduct.execute();
             
         }
         // Handle any errors that may have occurred.
         catch (Exception e) {
             e.printStackTrace();
         }
    }

    public void DeleteBooking(Booking BookingObj,int iBookingid) {
        // Code to delete specific Booking from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage

        String DeleteCusQuery = ("DELETE FROM tblBookings WHERE Booking_ID = '" + iBookingid + "'") ;

       try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
            PreparedStatement prepsDeleteProduct = connection.prepareStatement(DeleteCusQuery);) 
        {
            prepsDeleteProduct.execute();
            
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}