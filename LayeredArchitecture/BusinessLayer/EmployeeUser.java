package LayeredArchitecture.BusinessLayer;

public class EmployeeUser {
    private int User_ID;
    private int Employee_ID;

    public EmployeeUser(int user_ID, int employee_ID) {
        User_ID = user_ID;
        Employee_ID = employee_ID;
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

}
