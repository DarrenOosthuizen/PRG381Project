//User Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.User;
// 
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDH 
{
    private static DataAccessLayer DAL = new DataAccessLayer();

    public void CreateUser(User NewUser)
    {
        String InsertCusQuery = ("INSERT INTO tblUsers (User_ID, User_Name, User_Password, User_Privilege) VALUES ('"
        + NewUser.getUser_ID() + "','" + NewUser.getUser_Name() + "','" + NewUser.getUser_Password() + "','" + NewUser.getUser_Privilege() + "')");


    try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
        PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertCusQuery);) 
        {
        prepsInsertProduct.execute();
        }
    // Handle any errors that may have occurred.
    catch (Exception e) 
    {
    e.printStackTrace();
    }   
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

    public User ReadUser(int User_ID) 
    {
        User user = new User();
        // Code to read specific record from table and load into object User

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tlbUsers WHERE User_ID = '" + User_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                user.setUser_ID(resultSet.getInt(1));
                user.setUser_Name(resultSet.getString(2));
                user.setUser_Password(resultSet.getString(3));
                user.setUser_Privilege(resultSet.getString(4));
               
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
        // return User object
    }

    public void UpdateUser(User oldUser, User newUser) 
    {
        String UPDATECusQuery = ("UPDATE  tblUsers SET User_Name = '" + newUser.getUser_Name() + "', User_Password = '"  + newUser.getUser_Password() + "', User_Privilege = '"  + newUser.getUser_Privilege() + "'"  + " WHERE Customer_ID = '" + oldUser.getUser_ID() + "'") ;

       try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
            PreparedStatement prepsUpdateProduct = connection.prepareStatement(UPDATECusQuery);) 
        {
            prepsUpdateProduct.execute();
            
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteUser(int UserID) 
    {
        String DeleteCusQuery = ("DELETE FROM tblUsers WHERE User_ID = '" + UserID + "'") ;

       try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
            PreparedStatement prepsDeleteProduct = connection.prepareStatement(DeleteCusQuery);) 
        {
            prepsDeleteProduct.execute();
            
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}