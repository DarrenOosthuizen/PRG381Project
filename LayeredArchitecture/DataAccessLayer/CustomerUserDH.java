package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.CustomerUser;
import java.util.List;
import java.util.ArrayList;

public class CustomerUserDH {
    public void CreateCustomerUser() {
        // Code to write to CustomerUser tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<CustomerUser> ReadAllCustomerUser() {
        List<CustomerUser> CustomerUserList = new ArrayList<CustomerUser>();
        // Code to read all records from CustomerUser and load into list.
        return CustomerUserList;
        // Return list of records
    }

    public CustomerUser ReadCustomerUser(int CustomerUser_ID) {
        CustomerUser Customer_User = new CustomerUser();
        // Code to read specific record from table and load into object Customer_User
        return Customer_User;
        // return CustomerUser object
    }

    public void UpdateCustomerUser(CustomerUser oldCustomerUser, CustomerUser newCustomerUser) {
        // Code to update old CustomerUser record to new CustomerUser Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteCustomerUser(CustomerUser CustomerUserObj) {
        // Code to delete specific CustomerUser from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
    
}
