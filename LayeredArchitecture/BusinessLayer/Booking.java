package LayeredArchitecture.BusinessLayer;

import java.sql.Date;
import java.sql.Time;

public class Booking {
    private int BookingID;
    private int CustomerID;
    private String Customer_Name;
    private Date DateCreated;
    private String Booking_Status;
    private int Event_ID;
    private Date Event_Date;
    private Time Event_Time;
    private int Venue_ID;
    private int Total_Adults;
    private int Total_Kids;

    public Booking() {

    }

    public Booking(int BbookingID, int BcustomerID, String Bcustomer_Name, Date BdateCreated, String Bbooking_Status,
            int Bevent_ID, Date Bevent_Date, Time Bevent_Time, int Bvenue_ID, int Btotal_Adults, int Btotal_Kids) {
        BookingID = BbookingID;
        CustomerID = BcustomerID;
        Customer_Name = Bcustomer_Name;
        DateCreated = BdateCreated;
        Booking_Status = Bbooking_Status;
        Event_ID = Bevent_ID;
        Event_Date = Bevent_Date;
        Event_Time = Bevent_Time;
        Venue_ID = Bvenue_ID;
        Total_Adults = Btotal_Adults;
        Total_Kids = Btotal_Kids;
    }

    @Override
    public String toString() {
        return "Booking [BookingID=" + BookingID + ", Booking_Status=" + Booking_Status + ", CustomerID=" + CustomerID
                + ", Customer_Name=" + Customer_Name + ", DateCreated=" + DateCreated + ", Event_Date=" + Event_Date
                + ", Event_ID=" + Event_ID + ", Event_Time=" + Event_Time + ", Total_Adults=" + Total_Adults
                + ", Total_Kids=" + Total_Kids + ", Venue_ID=" + Venue_ID + "]";
    }

}
