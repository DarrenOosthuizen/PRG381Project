package LayeredArchitecture.BusinessLayer;

public class CustomerUser {
    private int Customer_ID;
    private int Booking_ID;

    public CustomerUser(int Customer_ID, int Booking_ID) {
        this.Customer_ID = Customer_ID;
        this.Booking_ID = Booking_ID;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public int getBooking_ID() {
        return Booking_ID;
    }

    public void setBooking_ID(int booking_ID) {
        Booking_ID = booking_ID;
    }

}
