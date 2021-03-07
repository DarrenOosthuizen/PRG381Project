package LayeredArchitecture.BusinessLayer;

public class EmployeeUser {
    private int User_ID;
    private int Employee_ID;

    public EmployeeUser(int EUuser_ID, int EUemployee_ID) {
        User_ID = EUuser_ID;
        Employee_ID = EUemployee_ID;
    }

    public EmployeeUser()
    {
        
    }

    public int getUser_ID() {
        return User_ID;
    }
   
    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public int getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        Employee_ID = employee_ID;
    }

    @Override
    public String toString() {
        return "EmployeeUser [Employee_ID=" + Employee_ID + ", User_ID=" + User_ID + "]";
    }

}
