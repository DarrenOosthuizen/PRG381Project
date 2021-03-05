package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.BookingFood;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingFoodDH 
{
    private static DataAccessLayer DAL = new DataAccessLayer();

    public void CreateBookingFood(int AdultsMeal,int Kids_meal,int Drinks,int Dessert,int Decorations,String Additional_Decorations) {

        String InsertCusQuery = ("INSERT INTO tblBookingFood (Adults_Meal, Kids_Meal, Drinks, Dessert, Decorations, Additional_Decorations) VALUES ('"
                + AdultsMeal + "','" + Kids_meal + "','" + Drinks + "','" + Dessert +"','" +Decorations+"','" +Additional_Decorations+ "')");
        

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertCusQuery);) {
            prepsInsertProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BookingFood> ReadAllBookingFood() {
        List<BookingFood> BookingFoodList = new ArrayList<BookingFood>();

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            String selectSql = "SELECT * from tblBookingFood";
            resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                BookingFoodList.add(new BookingFood(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getString(7)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
      
        return BookingFoodList;
        
    }

    public BookingFood ReadBookingFood(int BookingFood_ID) {
        BookingFood Booking_Food = new BookingFood();

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblBookingFood WHERE Booking_ID = '" + BookingFood_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                Booking_Food.setBooking_ID(resultSet.getInt(1));
                Booking_Food.setAdults_Meal(resultSet.getInt(2));
                Booking_Food.setKids_Meal(resultSet.getInt(3));
                Booking_Food.setDrinks(resultSet.getInt(4));
                Booking_Food.setDessert(resultSet.getInt(5));
                Booking_Food.setDecorations(resultSet.getInt(6));
                Booking_Food.setAdditional_Decorations(resultSet.getString(7));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return Booking_Food;
        
    }

    public void UpdateBookingFood(BookingFood oldBookingFood, BookingFood newBookingFood) {
        // Code to update old BookingFood record to new BookingFood Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage

        String UPDATECusQuery = ("UPDATE  tblBookingFood SET Adults_Meal = '" + newBookingFood.getAdults_Meal() + "', Kids_Meal = '"  + newBookingFood.getKids_Meal() + "', Drinks = '"  + newBookingFood.getDrinks() + "', Dessert = '"  + newBookingFood.getDessert() + "', Decorations = '"  + newBookingFood.getDecorations() +"', Additional_Decorations = '"  + newBookingFood.getAdditional_Decorations() +  "'"  + " WHERE Booking_ID = '" + oldBookingFood.getBooking_ID() + "'") ;

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

    public void DeleteBookingFood(BookingFood BookingFoodObj,int iBookingFoodid) {
        // Code to delete specific BookingFood from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage

        String DeleteCusQuery = ("DELETE FROM tblBookingFood WHERE Booking_ID = '" + iBookingFoodid + "'") ;

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
