//Booking Finance Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BookingFinanceDH {
    private static DataAccessLayer DAL = new DataAccessLayer();
    public void CreateBookingFinance(Float fTotalprice, Float fDeposit, int iFully, int iDeposti)   
     {
        String InsertCusQuery = ("INSERT INTO tblBookingFinance (Total_Price, Deposit, Is_Fully_Paid, Is_Deposit_Paid) VALUES ('"
                + fTotalprice + "','" + fDeposit + "','" + iFully + "','" + iDeposti + "')");
        

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertCusQuery);) {
            prepsInsertProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BookingFinance> ReadAllBookingFinance() {
        List<BookingFinance> BookingFinanceList = new ArrayList<BookingFinance>();
        
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            String selectSql = "SELECT * from tblBookingFinance";
            resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                BookingFinanceList.add(new BookingFinance(resultSet.getInt(1), resultSet.getFloat(2), resultSet.getFloat(3),
                        resultSet.getInt(4), resultSet.getInt(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        


        return BookingFinanceList;
        
    }

    public BookingFinance ReadBookingFinance(int BookingFinance_ID) {
        BookingFinance Booking_Finance = new BookingFinance();
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblBookingFinance WHERE Booking_ID_ID = '" + BookingFinance_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                Booking_Finance.setBooking_ID(resultSet.getInt(1));
                Booking_Finance.setTotal_Price(resultSet.getFloat(2));
                Booking_Finance.setDeposit(resultSet.getFloat(3));
                Booking_Finance.setIs_Fully_Paid(resultSet.getInt(4));
                Booking_Finance.setIs_Deposit_Paid(resultSet.getInt(5));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

       
        return Booking_Finance;
       
    }

    public void UpdateBookingFinance(BookingFinance oldBookingFinance, BookingFinance newBookingFinance) {
        // Code to update old BookingFinance record to new BookingFinance Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage

        String UPDATECusQuery = ("UPDATE  tblBookingFinance SET Total_Price = '" + newBookingFinance.getTotal_Price() + "', Deposit = '"  + newBookingFinance.getDeposit() + "', Is_Fully_Paid = '"  + newBookingFinance.getIs_Fully_Paid() + "', Is_Deposit_Paid = '"  + newBookingFinance.getIs_Deposit_Paid() + "'"  + " WHERE Booking_ID = '" + oldBookingFinance.getBooking_ID() + "'") ;

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

    public void DeleteBookingFinance(BookingFinance BookingFinanceObj ,int iBookingid) {
        // Code to delete specific BookingFinance from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage

        String DeleteCusQuery = ("DELETE FROM tblBookingFinance WHERE Booking_ID = '" + iBookingid + "'") ;

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
