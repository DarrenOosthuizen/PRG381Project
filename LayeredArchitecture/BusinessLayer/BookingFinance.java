package LayeredArchitecture.BusinessLayer;

public class BookingFinance {
    private int Booking_ID;
    private Float Total_Price;
    private Float Deposit;
    private int Is_Fully_Paid;
    private int Is_Deposit_Paid;

    

    public BookingFinance(int BFbooking_ID, Float BFtotal_Price, Float BFdeposit, int BFis_Fully_Paid, int BFis_Deposit_Paid) {
        Booking_ID = BFbooking_ID;
        Total_Price = BFtotal_Price;
        Deposit = BFdeposit;
        Is_Fully_Paid = BFis_Fully_Paid;
        Is_Deposit_Paid = BFis_Deposit_Paid;
    }

    public BookingFinance() 
    {

    }

    public int getBooking_ID() {
        return Booking_ID;
    }

     

    public void setBooking_ID(int booking_ID) {
        Booking_ID = booking_ID;
    }

    public Float getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(Float total_Price) {
        Total_Price = total_Price;
    }

    public Float getDeposit() {
        return Deposit;
    }

    public void setDeposit(Float deposit) {
        Deposit = deposit;
    }

    public int getIs_Fully_Paid() {
        return Is_Fully_Paid;
    }

    public void setIs_Fully_Paid(int is_Fully_Paid) {
        Is_Fully_Paid = is_Fully_Paid;
    }

    public int getIs_Deposit_Paid() {
        return Is_Deposit_Paid;
    }

    public void setIs_Deposit_Paid(int is_Deposit_Paid) {
        Is_Deposit_Paid = is_Deposit_Paid;
    }

    @Override
    public String toString() {
        return "BookingFinance [Booking_ID=" + Booking_ID + ", Deposit=" + Deposit + ", Is_Deposit_Paid="
                + Is_Deposit_Paid + ", Is_Fully_Paid=" + Is_Fully_Paid + ", Total_Price=" + Total_Price + "]";
    }

}
