package LayeredArchitecture.BusinessLayer;

public class User {
    private int User_ID;
    private String User_Name;
    private String User_Password;
    private String User_Privilege;

    public User() {

    }

    public User(int Uuser_ID, String Uuser_Name, String Uuser_Password, String Uuser_Privilege) {
        User_ID = Uuser_ID;
        User_Name = Uuser_Name;
        User_Password = Uuser_Password;
        User_Privilege = Uuser_Privilege;
    }

    @Override
    public String toString() {
        return "User [User_ID=" + User_ID + ", User_Name=" + User_Name + ", User_Password=" + User_Password
                + ", User_Privilege=" + User_Privilege + "]";
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String user_Password) {
        User_Password = user_Password;
    }

    public String getUser_Privilege() {
        return User_Privilege;
    }

    public void setUser_Privilege(String user_Privilege) {
        User_Privilege = user_Privilege;
    }

}
