//Customer Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Customer;

import java.util.List;
import java.util.ArrayList;

public class CustomerDH {
    public void CreateCustomer() {
        // Code to write to Customers tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<Customer> ReadAllCustomers() {
        List<Customer> CustomerList = new ArrayList<Customer>();
        // Code to read all records from Customer and load into list.
        return CustomerList;
        // Return list of records
    }

    public Customer ReadCustomer(int Customer_ID) {
        Customer customer = new Customer();
        // Code to read specific record from table and load into object Customer
        return customer;
        // return Customer object
    }

    public void UpdateCustomer(Customer oldCustomer, Customer newCustomer) {
        // Code to update old Customer record to new Customer Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteCustomer(Customer CustomerObj) {
        // Code to delete specific Customer from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
}
