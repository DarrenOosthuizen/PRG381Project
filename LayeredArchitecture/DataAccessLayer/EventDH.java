package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Event;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EventDH {
    private static DataAccessLayer DAL = new DataAccessLayer();

    public void CreateEvent(Event event) {
        String InsertCusQuery = ("INSERT INTO tblEvent (Event_ID, Event_Name) VALUES ('" + event.getEvent_ID() + "','"
                + event.getEvent_Name() + "')");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertCusQuery);) {
            prepsInsertProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Event> ReadAllEvent() {
        List<Event> EventList = new ArrayList<Event>();
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            String selectSql = "SELECT * from tblEvent";
            resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                EventList.add(new Event(resultSet.getInt(0), resultSet.getString(1)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return EventList;
    }

    public Event ReadEvent(int Event_ID) {
        Event event = new Event();
        // Code to read specific record from table and load into object Customer

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblEvent WHERE Event_ID = '" + Event_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                event.setEvent_ID(resultSet.getInt(0));
                event.setEvent_Name(resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
        // return Customer object
    }

    public void UpdateEvent(Event oldEvent, Event newEvent) {
        String UPDATECusQuery = ("UPDATE  tblEvent SET Event_Name = '" + newEvent.getEvent_Name()
                + "' WHERE Customer_ID = '" + oldEvent.getEvent_ID() + "'");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsUpdateProduct = connection.prepareStatement(UPDATECusQuery);) {
            prepsUpdateProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteEvent(int Event_ID) {
        String DeleteCusQuery = ("DELETE FROM tblEvent WHERE Event_ID = '" + Event_ID + "'");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsDeleteProduct = connection.prepareStatement(DeleteCusQuery);) {
            prepsDeleteProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
