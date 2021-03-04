package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.BookingFood;
import java.util.List;
import java.util.ArrayList;

public class BookingFoodDH 
{
    public void CreateBookingFood() {
        // Code to write to BookingFood tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<BookingFood> ReadAllBookingFood() {
        List<BookingFood> BookingFoodList = new ArrayList<BookingFood>();
        // Code to read all records from BookingsFood and load into list.
        return BookingFoodList;
        // Return list of records
    }

    public BookingFood ReadBookingFood(int BookingFood_ID) {
        BookingFood Booking_Food = new BookingFood();
        // Code to read specific record from table and load into object Booking_Food
        return Booking_Food;
        // return BookingFood object
    }

    public void UpdateBookingFood(BookingFood oldBookingFood, BookingFood newBookingFood) {
        // Code to update old BookingFood record to new BookingFood Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteBookingFood(BookingFood BookingFoodObj) {
        // Code to delete specific BookingFood from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
    
}
