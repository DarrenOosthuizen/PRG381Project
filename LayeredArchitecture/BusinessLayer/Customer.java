package LayeredArchitecture.BusinessLayer;

public class Customer {
    private int Customer_ID;
    private String Customer_Name;
    private String Customer_Surname;
    private String Customer_Cell;
    private String Customer_Email;

    public Customer(int customer_ID, String customer_Name, String customer_Surname, String customer_Cell,
            String customer_Email) {
        Customer_ID = customer_ID;
        Customer_Name = customer_Name;
        Customer_Surname = customer_Surname;
        Customer_Cell = customer_Cell;
        Customer_Email = customer_Email;
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

}
