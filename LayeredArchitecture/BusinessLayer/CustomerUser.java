package LayeredArchitecture.BusinessLayer;

public class CustomerUser {
    private int Customer_ID;
    private int Booking_ID;

    public CustomerUser(int CUCustomer_ID, int CUBooking_ID) {
        this.Customer_ID = CUCustomer_ID;
        this.Booking_ID = CUBooking_ID;
    }

    public CustomerUser() {
        
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

    @Override
    public String toString() {
        return "CustomerUser [Booking_ID=" + Booking_ID + ", Customer_ID=" + Customer_ID + "]";
    }

}
