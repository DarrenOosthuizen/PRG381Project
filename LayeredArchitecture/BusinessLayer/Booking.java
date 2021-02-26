package LayeredArchitecture.BusinessLayer;

import java.sql.Date;
import java.sql.Time;

public class Booking 
{
    private int BookingID ;
    private int CustomerID;
    private String Customer_Name;
    private Date DateCreated ;
    private String Booking_Status;
    private int Event_ID;
    private Date Event_Date;
    private Time Event_Time;
    private int Venue_ID;
    private int Total_Adults;
    private int Total_Kids;

    public Booking(int bookingID, int customerID, String customer_Name, Date dateCreated, String booking_Status,
            int event_ID, Date event_Date, Time event_Time, int venue_ID, int total_Adults, int total_Kids) {
        BookingID = bookingID;
        CustomerID = customerID;
        Customer_Name = customer_Name;
        DateCreated = dateCreated;
        Booking_Status = booking_Status;
        Event_ID = event_ID;
        Event_Date = event_Date;
        Event_Time = event_Time;
        Venue_ID = venue_ID;
        Total_Adults = total_Adults;
        Total_Kids = total_Kids;
    }

    @Override
    public String toString() {
        return "Booking [BookingID=" + BookingID + ", Booking_Status=" + Booking_Status + ", CustomerID=" + CustomerID
                + ", Customer_Name=" + Customer_Name + ", DateCreated=" + DateCreated + ", Event_Date=" + Event_Date
                + ", Event_ID=" + Event_ID + ", Event_Time=" + Event_Time + ", Total_Adults=" + Total_Adults
                + ", Total_Kids=" + Total_Kids + ", Venue_ID=" + Venue_ID + "]";
    }

    
    
}
