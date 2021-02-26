//Booking Finance Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.BookingFinance;
import java.util.List;
import java.util.ArrayList;

public class BookingFinanceDH {
    public void CreateBookingFinance() {
        // Code to write to BookingsFinance tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<BookingFinance> ReadAllBookingFinance() {
        List<BookingFinance> BookingFinanceList = new ArrayList<BookingFinance>();
        // Code to read all records from BookingsFinance and load into list.
        return BookingFinanceList;
        // Return list of records
    }

    public BookingFinance ReadBookingFinance(int BookingFinance_ID) {
        BookingFinance Booking_Finance = new BookingFinance();
        // Code to read specific record from table and load into object Booking_Finance
        return Booking_Finance;
        // return BookingFinance object
    }

    public void UpdateBookingFinance(BookingFinance oldBookingFinance, BookingFinance newBookingFinance) {
        // Code to update old BookingFinance record to new BookingFinance Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteBookingFinance(BookingFinance BookingFinanceObj) {
        // Code to delete specific BookingFinance from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
}
