package LayeredArchitecture.DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	

public class DataAccessLayer 
{
    public static void main(String[] args) 
    {
        
            String dbURL = "jdbc:sqlserver://flystudio.sytes.net" ;
            String user = "Delicious-Catering";
            String pass = "Delicious-Catering";
    
            try (Connection connection = DriverManager.getConnection(dbURL,user,pass);) 
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
