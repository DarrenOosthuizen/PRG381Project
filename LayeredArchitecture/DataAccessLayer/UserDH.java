//User Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.User;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDH 
{
    private static DataAccessLayer DAL = new DataAccessLayer();
    public void CreateUser() 
    {
        // Code to write to Users tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<User> ReadAllUsers() 
    {
        List<User> UserList = new ArrayList<User>();
        // Code to read all records from User and load into list.

        ResultSet resultSet = null;
        
        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
        Statement statement = connection.createStatement();) 
        {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from tblUsers";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) 
            {
                UserList.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4))) ; 
            }

        
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
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