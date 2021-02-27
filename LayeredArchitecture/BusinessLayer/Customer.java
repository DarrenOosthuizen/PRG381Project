package LayeredArchitecture.BusinessLayer;

public class Customer {
    private int Customer_ID;
    private String Customer_Name;
    private String Customer_Surname;
    private String Customer_Cell;
    private String Customer_Email;

    public Customer(){
        
    }
    public Customer(int Ccustomer_ID, String Ccustomer_Name, String Ccustomer_Surname, String Ccustomer_Cell,
            String Ccustomer_Email) {
        Customer_ID = Ccustomer_ID;
        Customer_Name = Ccustomer_Name;
        Customer_Surname = Ccustomer_Surname;
        Customer_Cell = Ccustomer_Cell;
        Customer_Email = Ccustomer_Email;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getCustomer_Surname() {
        return Customer_Surname;
    }

    public void setCustomer_Surname(String customer_Surname) {
        Customer_Surname = customer_Surname;
    }

    public String getCustomer_Cell() {
        return Customer_Cell;
    }

    public void setCustomer_Cell(String customer_Cell) {
        Customer_Cell = customer_Cell;
    }

    public String getCustomer_Email() {
        return Customer_Email;
    }

    public void setCustomer_Email(String customer_Email) {
        Customer_Email = customer_Email;
    }

    @Override
    public String toString() {
        return "Customer [Customer_Cell=" + Customer_Cell + ", Customer_Email=" + Customer_Email + ", Customer_ID="
                + Customer_ID + ", Customer_Name=" + Customer_Name + ", Customer_Surname=" + Customer_Surname + "]";
    }

}
