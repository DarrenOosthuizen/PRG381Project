package LayeredArchitecture.BusinessLayer;


import java.sql.Time;
import java.util.Date;

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

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }

    public String getBooking_Status() {
        return Booking_Status;
    }

    public void setBooking_Status(String booking_Status) {
        Booking_Status = booking_Status;
    }

    public int getEvent_ID() {
        return Event_ID;
    }

    public void setEvent_ID(int EventID) {
        Event_ID = EventID;
    }

    public Date getEvent_Date() {
        return Event_Date;
    }

    public void setEvent_Date(Date event_Date) {
        Event_Date = event_Date;
    }

    public Time getEvent_Time() {
        return Event_Time;
    }

    public void setEvent_Time(Time event_Time) {
        Event_Time = event_Time;
    }

    public int getVenue_ID() {
        return Venue_ID;
    }

    public void setVenue_ID(int venue_ID) {
        Venue_ID = venue_ID;
    }

    public int getTotal_Adults() {
        return Total_Adults;
    }

    public void setTotal_Adults(int total_Adults) {
        Total_Adults = total_Adults;
    }

    public int getTotal_Kids() {
        return Total_Kids;
    }

    public void setTotal_Kids(int total_Kids) {
        Total_Kids = total_Kids;
    }

}
