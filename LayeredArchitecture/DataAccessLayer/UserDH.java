//User Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.User;

import java.util.List;
import java.util.ArrayList;

public class UserDH {
    public void CreateUser() {
        // Code to write to Users tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<User> ReadAllCustomers() {
        List<User> UserList = new ArrayList<User>();
        // Code to read all records from User and load into list.
        return UserList;
        // Return list of records
    }

    public User ReadUser(int User_ID) {
        User user = new User();
        // Code to read specific record from table and load into object Customer
        return user;
        // return Customer object
    }

    public void UpdateUser(User oldUser, User newUser) {
        // Code to update old User record to new User Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteUser(User UserObj) {
        // Code to delete specific User from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
}