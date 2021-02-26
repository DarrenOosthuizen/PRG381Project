package LayeredArchitecture.BusinessLayer;

public class BookingFinance {
    private int Booking_ID;
    private int Total_Price;
    private int Deposit;
    private int Is_Fully_Paid;
    private int Is_Deposit_Paid;

    public BookingFinance(int booking_ID, int total_Price, int deposit, int is_Fully_Paid, int is_Deposit_Paid) {
        Booking_ID = booking_ID;
        Total_Price = total_Price;
        Deposit = deposit;
        Is_Fully_Paid = is_Fully_Paid;
        Is_Deposit_Paid = is_Deposit_Paid;
    }

    public int getBooking_ID() {
        return Booking_ID;
    }

    public void setBooking_ID(int booking_ID) {
        Booking_ID = booking_ID;
    }

    public int getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(int total_Price) {
        Total_Price = total_Price;
    }

    public int getDeposit() {
        return Deposit;
    }

    public void setDeposit(int deposit) {
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
}
