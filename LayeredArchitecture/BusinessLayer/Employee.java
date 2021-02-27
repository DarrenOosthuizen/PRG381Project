package LayeredArchitecture.BusinessLayer;

public class Employee 
{
    private int Employee_ID;
    private String Employee_Name;
    private String Employee_Surname;
    private String Employee_Cell;
    private String Employee_Email;
    private String Employee_Role;

    public Employee(int Eemployee_ID, String Eemployee_Name, String Eemployee_Surname, String Eemployee_Cell,
            String Eemployee_Email, String Eemployee_Role) {
        Employee_ID = Eemployee_ID;
        Employee_Name = Eemployee_Name;
        Employee_Surname = Eemployee_Surname;
        Employee_Cell = Eemployee_Cell;
        Employee_Email = Eemployee_Email;
        Employee_Role = Eemployee_Role;
    }

    public Employee()
    {
        
    }


    @Override
    public String toString() {
        return "Employee [Employee_Cell=" + Employee_Cell + ", Employee_Email=" + Employee_Email + ", Employee_ID="
                + Employee_ID + ", Employee_Name=" + Employee_Name + ", Employee_Role=" + Employee_Role
                + ", Employee_Surname=" + Employee_Surname + "]";
    }

    public int getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        Employee_ID = employee_ID;
    }

    public String getEmployee_Name() {
        return Employee_Name;
    }

    public void setEmployee_Name(String employee_Name) {
        Employee_Name = employee_Name;
    }

    public String getEmployee_Surname() {
        return Employee_Surname;
    }

    public void setEmployee_Surname(String employee_Surname) {
        Employee_Surname = employee_Surname;
    }

    public String getEmployee_Cell() {
        return Employee_Cell;
    }

    public void setEmployee_Cell(String employee_Cell) {
        Employee_Cell = employee_Cell;
    }

    public String getEmployee_Email() {
        return Employee_Email;
    }

    public void setEmployee_Email(String employee_Email) {
        Employee_Email = employee_Email;
    }

    public String getEmployee_Role() {
        return Employee_Role;
    }

    public void setEmployee_Role(String employee_Role) {
        Employee_Role = employee_Role;
    }
    
}
