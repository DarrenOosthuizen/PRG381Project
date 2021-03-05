//Venue Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Venue;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VenueDH {
    private static DataAccessLayer DAL = new DataAccessLayer();

    public void CreateVenue(Venue newVenue) {
        // Code to write to Venue tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
        String InsertVenueQuery = ("INSERT INTO tblVenue (Venue_Name, Venue_Phone, Venue_Email, Venue_Address) VALUES ('"
        + newVenue.getVenue_Name() + "','" + newVenue.getVenue_Phone_Number() + "','" + newVenue.getVenue_Email() + "','" + newVenue.getVenue_Address()+"')");


        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
        PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertVenueQuery);) {
        prepsInsertProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) 
        {
        e.printStackTrace();
        }
    }

    public List<Venue> ReadAllVenues() {
        List<Venue> VenueList = new ArrayList<Venue>();
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            String selectSql = "SELECT * from tblVenue";
            resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                VenueList.add(new Venue(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return VenueList;

    }

    public Venue ReadVenue(int Venue_ID) {
        Venue venue = new Venue();
   

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblVenue WHERE Venue_ID = '" + Venue_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                venue.setVenue_ID(resultSet.getInt(1));
                venue.setVenue_Name(resultSet.getString(2));
                venue.setVenue_Phone_Number(resultSet.getString(3));
                venue.setVenue_Email(resultSet.getString(4));
                venue.setVenue_Address(resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return venue;
    }

    public void UpdateVenue(Venue oldVenue, Venue newVenue) {
        String UPDATEVenQuery = ("UPDATE  tblVenue SET Venue_Name = '" + newVenue.getVenue_Name() + "', Venue_Phone = '"  + newVenue.getVenue_Phone_Number() + "', Venue_Email = '"  + newVenue.getVenue_Email() + "', Venue_Address = '"  + newVenue.getVenue_Address() + "'"  + " WHERE Venue_ID = '" + oldVenue.getVenue_ID() + "'") ;

       try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
            PreparedStatement prepsUpdateProduct = connection.prepareStatement(UPDATEVenQuery);) 
        {
            prepsUpdateProduct.execute();
            
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteVenue(int VenueID) {
        String DeleteCusQuery = ("DELETE FROM tblVenue WHERE Venue_ID = '" + VenueID + "'") ;

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