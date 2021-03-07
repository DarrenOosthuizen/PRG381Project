package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.EmployeeUser;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeUserDH {
    private static DataAccessLayer DAL = new DataAccessLayer();

    public void CreateEmployeeUser(EmployeeUser newEmployeeUser) {
        String InsertEmployeeUserQuery = ("INSERT INTO tblEmployeeUser (Employee_ID, User_ID) VALUES ('"
                + newEmployeeUser.getEmployee_ID() + "','" + newEmployeeUser.getUser_ID() + "')");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertEmployeeUserQuery);) {
            prepsInsertProduct.execute();
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<EmployeeUser> ReadAllEmployeeUser() {
        List<EmployeeUser> EmployeeUserList = new ArrayList<EmployeeUser>();
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            String selectSql = "SELECT * from tblEmployeeUser";
            resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                EmployeeUserList.add(new EmployeeUser(resultSet.getInt(1), resultSet.getInt(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return EmployeeUserList;
    }

    public EmployeeUser ReadEmployeeUser(int EmployeeUser_ID) {
        EmployeeUser employeeuser = new EmployeeUser();

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblEmployeeUser WHERE User_ID = '" + EmployeeUser_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                employeeuser.setEmployee_ID(resultSet.getInt(1));
                employeeuser.setUser_ID(resultSet.getInt(2));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeuser;

    }

    public void UpdateEmployeeUser(EmployeeUser oldEmployeeUser, EmployeeUser newEmployeeUser) {
        String UPDATECusQuery = ("UPDATE  tblCustomer SET Employee_ID = '" + newEmployeeUser.getEmployee_ID()
                + "', User_ID = '" + newEmployeeUser.getUser_ID() + " WHERE Employee_ID = '"
                + oldEmployeeUser.getEmployee_ID() + "'");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsUpdateProduct = connection.prepareStatement(UPDATECusQuery);) {
            prepsUpdateProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void DeleteEmployeeUser(int EmployeeID) {
        String DeleteCusQuery = ("DELETE FROM tblEmployeeUser WHERE Employee_ID = '" + EmployeeID + "'");

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
