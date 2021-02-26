//Booking Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Booking;

import java.util.List;
import java.util.ArrayList;

public class BookingDH {
    public void CreateBooking() {
        // Code to write to Bookings tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<Booking> ReadAllBookings() {
        List<Booking> BookingList = new ArrayList<Booking>();
        // Code to read all records from Booking and load into list.
        return BookingList;
        // Return list of records
    }

    public Booking ReadBooking(int Booking_ID) {
        Booking booking = new Booking();
        // Code to read specific record from table and load into object Booking
        return booking;
        // return Booking object
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