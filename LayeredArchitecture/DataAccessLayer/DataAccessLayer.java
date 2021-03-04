package LayeredArchitecture.DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	

public class DataAccessLayer 
{
       private static String dbURL = "jdbc:sqlserver://flystudio.sytes.net; database=Delicious-Catering;" ;
       private static String user = "user=Delicious-Catering;";
       private static String pass = "password=Delicious-Catering";

       public static String DBConnection = dbURL + user + pass ;
    public static void main(String[] args) 
    {
        
            try (Connection connection = DriverManager.getConnection(DBConnection);) 
            {
                // Code here.
                if (connection != null)
                {
                    System.out.println("Connected");
                }
                
            }
            // Handle any errors that may have occurred.
            catch (SQLException e) {
                e.printStackTrace();
            }
        
    }
    
}
