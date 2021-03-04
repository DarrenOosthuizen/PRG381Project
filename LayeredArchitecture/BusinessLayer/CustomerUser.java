package LayeredArchitecture.BusinessLayer;

public class CustomerUser {
    private int Customer_ID;
    private int User_ID;

    public CustomerUser(int CUCustomer_ID, int CUUser_ID) {
        this.Customer_ID = CUCustomer_ID;
        this.User_ID = CUUser_ID;
    }

    public CustomerUser() {
        
    }

    

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    @Override
    public String toString() {
        return "CustomerUser [User_ID=" + User_ID + ", Customer_ID=" + Customer_ID + "]";
    }

}
