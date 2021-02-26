package LayeredArchitecture.BusinessLayer;

public class Customer {
    private int Customer_ID;
    private int Customer_Name;
    private int Customer_Surname;
    private int Customer_Cell;
    private int Customer_Email;

    public Customer(int customer_ID, int customer_Name, int customer_Surname, int customer_Cell, int customer_Email) {
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

    public int getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(int customer_Name) {
        Customer_Name = customer_Name;
    }

    public int getCustomer_Surname() {
        return Customer_Surname;
    }

    public void setCustomer_Surname(int customer_Surname) {
        Customer_Surname = customer_Surname;
    }

    public int getCustomer_Cell() {
        return Customer_Cell;
    }

    public void setCustomer_Cell(int customer_Cell) {
        Customer_Cell = customer_Cell;
    }

    public int getCustomer_Email() {
        return Customer_Email;
    }

    public void setCustomer_Email(int customer_Email) {
        Customer_Email = customer_Email;
    }
}
