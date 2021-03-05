package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.CustomerUser;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerUserDH 
{
    private static DataAccessLayer DAL = new DataAccessLayer();
    public void CreateCustomerUser(CustomerUser newCusUser) 
    {
        String InsertCusQuery = ("INSERT INTO tblCustomerUser (Customer_ID, User_ID) VALUES ('"
                + newCusUser.getCustomer_ID() + "','" + newCusUser.getUser_ID() + "')");
        

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertCusQuery);) {
            prepsInsertProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CustomerUser> ReadAllCustomerUser() {
        List<CustomerUser> CustomerUserList = new ArrayList<CustomerUser>();
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            String selectSql = "SELECT * from tblCustomerUser";
            resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                CustomerUserList.add(new CustomerUser(resultSet.getInt(1), resultSet.getInt(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return CustomerUserList;
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
        String UPDATECusQuery = ("UPDATE  tblCustomerUser SET Customer_ID = '" + newCustomerUser.getCustomer_ID() + "', User_ID = '"  + newCustomerUser.getUser_ID()  + " WHERE Customer_ID = '" + oldCustomerUser.getCustomer_ID() + "'") ;

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

    public void DeleteCustomerUser(int CustomerUserID) {
        String DeleteCusQuery = ("DELETE FROM tblCustomerUser WHERE Customer_ID = '" + CustomerUserID + "'") ;

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
