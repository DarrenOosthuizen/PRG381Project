//Customer Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Customer;
import jdk.incubator.jpackage.main.Main;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDH 
{
    private static DataAccessLayer DAL = new DataAccessLayer();

    public static void main(String[] args) 
    {
        System.out.println("Testing Input");
        CreateCustomer("Kyle", "Oosthuizen", "0720899534", "Darren.oosth");
    }

    public static void CreateCustomer(String CCCusName, String CCCusSurname, String CCCusCell, String CCCusEmail) 
    {
       String InsertCusQuery = ("INSERT INTO tblCustomer (Customer_Name, Customer_Surname, Customer_Cell, Customer_Email) VALUES ('" + CCCusName + "','" + CCCusSurname + "','" + CCCusCell + "','" + CCCusEmail + "')");
       ResultSet resultSet = null ;

       try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
            PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertCusQuery, Statement.RETURN_GENERATED_KEYS);) 
        {
            prepsInsertProduct.execute();
            
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Customer> ReadAllCustomers() 
    {
        List<Customer> CustomerList = new ArrayList<Customer>();
        ResultSet resultSet = null;
       
        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
        Statement statement = connection.createStatement();) 
        {

            
            String selectSql = "SELECT * from tblCustomer";
            resultSet = statement.executeQuery(selectSql);

            
            while (resultSet.next()) 
            {
                CustomerList.add(new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5))) ; 
            }

        
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 

        return CustomerList;
        
    }



    public Customer ReadCustomer(int Customer_ID) 
    {
        Customer customer = new Customer();
        // Code to read specific record from table and load into object Customer

        ResultSet resultSet = null;
    
        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
        Statement statement = connection.createStatement();) 
        {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblCustomer WHERE Customer_ID = '" + Customer_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) 
            {
               customer.setCustomer_ID(resultSet.getInt(1));
               customer.setCustomer_Name(resultSet.getString(2));
               customer.setCustomer_Surname(resultSet.getString(3));
               customer.setCustomer_Cell(resultSet.getString(4));
               customer.setCustomer_Email(resultSet.getString(5));
            }


        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 

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
