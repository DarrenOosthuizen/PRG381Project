package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Employee;
import java.util.List;
import java.util.ArrayList;

public class EmployeeDH {
    public void CreateEmployee() {
        // Code to write to Employee tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<Employee> ReadAllEmployee() {
        List<Employee> EmployeeList = new ArrayList<Employee>();
        // Code to read all records from Employees and load into list.
        return EmployeeList;
        // Return list of records
    }

    public Employee ReadEmployee(int Employee_ID) {
        Employee Employee_Read = new Employee();
        // Code to read specific record from table and load into object Employee_Read
        return Employee_Read;
        // return Employee object
    }

    public void UpdateEmployee(Employee oldEmployee, Employee newEmployee) {
        // Code to update old Employee record to new Employee Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteEmployee(Employee EmployeeObj) {
        // Code to delete specific Employee from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
    
}
