package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Employee;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDH {

    private static DataAccessLayer DAL = new DataAccessLayer();

    public void CreateEmployee(Employee employee) {
        String InsertCusQuery = ("INSERT INTO tblEmployee (Employee_Name, Employee_Surname, Employee_Cell, Employee_Email, Employee_Role) VALUES ('"
                + employee.getEmployee_Name() + "','" + employee.getEmployee_Surname() + "','"
                + employee.getEmployee_Cell() + "','" + employee.getEmployee_Email() + "','"
                + employee.getEmployee_Role() + "')");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertCusQuery);) {
            prepsInsertProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> ReadAllEmployee() {
        List<Employee> EmployeeList = new ArrayList<Employee>();
        ResultSet resultSet = null;
        // Code to read all records from Customer and load into list.
        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from tblEmployee";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                EmployeeList.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return EmployeeList;
    }

    public Employee ReadEmployee(int Employee_ID) {
        Employee employee = new Employee();
        // Code to read specific record from table and load into object Customer

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblEmployee WHERE Employee_ID = '" + Employee_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                employee.setEmployee_ID(resultSet.getInt(1));
                employee.setEmployee_Name(resultSet.getString(2));
                employee.setEmployee_Surname(resultSet.getString(3));
                employee.setEmployee_Cell(resultSet.getString(4));
                employee.setEmployee_Email(resultSet.getString(5));
                employee.setEmployee_Role(resultSet.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
        // return Customer object
    }

    public void UpdateEmployee(Employee oldEmployee, Employee newEmployee) {
        String UPDATECusQuery = ("UPDATE  tblEmployee SET Employee_Name = '" + newEmployee.getEmployee_Name()
                + "', Employee_Surname = '" + newEmployee.getEmployee_Surname() + "', Employee_Cell = '"
                + newEmployee.getEmployee_Cell() + "', Employee_Email = '" + newEmployee.getEmployee_Email()
                + "', Employee_Role = '" + newEmployee.getEmployee_Role() + "'" + " WHERE Employee_ID = '"
                + oldEmployee.getEmployee_ID() + "'");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsUpdateProduct = connection.prepareStatement(UPDATECusQuery);) {
            prepsUpdateProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteEmployee(int Employee_ID) {
        String DeleteCusQuery = ("DELETE FROM tblEmployee WHERE Employee_ID = '" + Employee_ID + "'");

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
