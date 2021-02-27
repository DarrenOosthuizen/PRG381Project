package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.EmployeeUser;
import java.util.List;
import java.util.ArrayList;

public class EmployeeUserDH 
{
    public void CreateEmployeeUser() {
        // Code to write to EmployeeUser tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<EmployeeUser> ReadAllEmployeeUser() {
        List<EmployeeUser> EmployeeUserList = new ArrayList<EmployeeUser>();
        // Code to read all records from EmployeeUser and load into list.
        return EmployeeUserList;
        // Return list of records
    }

    public EmployeeUser ReadEmployeeUser(int EmployeeUser_ID) {
        EmployeeUser Employee_User = new EmployeeUser();
        // Code to read specific record from table and load into object Employee_User
        return Employee_User;
        // return EmployeeUser object
    }

    public void UpdateEmployeeUser(EmployeeUser oldEmployeeUser, EmployeeUser newEmployeeUser) {
        // Code to update old EmployeeUser record to new EmployeeUser Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteEmployeeUser(EmployeeUser EmployeeUserObj) {
        // Code to delete specific EmployeeUser from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
}
