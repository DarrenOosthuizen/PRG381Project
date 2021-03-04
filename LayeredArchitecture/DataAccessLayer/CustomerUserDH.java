package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.CustomerUser;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerUserDH 
{
    private static DataAccessLayer DAL = new DataAccessLayer();
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

    public CustomerUser ReadCustomerUser(int CustomerUser_ID) 
    {
        CustomerUser Customer_User = new CustomerUser();
        // Code to read specific record from table and load into object Customer_User

        ResultSet resultSet = null;
    
        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
        Statement statement = connection.createStatement();) 
        {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblCustomerUser WHERE User_ID = '" + CustomerUser_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) 
            {
               Customer_User.setCustomer_ID(resultSet.getInt(1));
               Customer_User.setUser_ID(resultSet.getInt(2));
            }

        
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 

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
