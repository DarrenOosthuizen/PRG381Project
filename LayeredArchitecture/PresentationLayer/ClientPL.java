package LayeredArchitecture.PresentationLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import LayeredArchitecture.BusinessLayer.Customer;
import LayeredArchitecture.BusinessLayer.CustomerUser;
import LayeredArchitecture.BusinessLayer.User;
import LayeredArchitecture.DataAccessLayer.CustomerDH;
import LayeredArchitecture.DataAccessLayer.CustomerUserDH;
import LayeredArchitecture.DataAccessLayer.DataAccessLayer;
import LayeredArchitecture.DataAccessLayer.UserDH;

public class ClientPL 
{
    
    private static UserDH UserDH = new UserDH();
    private static CustomerUserDH CusUsDh = new CustomerUserDH();
    private static CustomerDH CusDH = new CustomerDH();
    public  static Customer CustomerOBJ = new Customer();
    private static int UserID;
    boolean ClientFound = false ;

    enum ClientPLMenu
    {
        Exit,
        Add,
        View,
        Modify
    }

    
    public void ClientSignIn() 
    {
        ClientFound= false ;
        while(ClientFound==false)
        {
        try
        {
            
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Please Enter Client User Name :");

            Scanner RdClientUser = new Scanner(System.in);
            String strClientUser= RdClientUser.nextLine();
            System.out.printf("Please Enter Password for User %s:", strClientUser);
            System.out.println("");

            String strClientPass= RdClientUser.nextLine();
            
            List<User> UserList = UserDH.ReadAllUsers() ;

            for (User userItem : UserList) 
            {
                if(strClientUser.matches(userItem.getUser_Name()) && strClientPass.matches(userItem.getUser_Password()))
                {
                    UserID = userItem.getUser_ID();
                    ClientFound = true ;
                }
                
            }

            if(ClientFound==true)
            {
                System.out.println("Logged in Successfuly");
            
                CustomerUser CusUSOBJ = CusUsDh.ReadCustomerUser(UserID);
                CustomerOBJ = CusDH.ReadCustomer(CusUSOBJ.getCustomer_ID());
                ClientMenu();
                
                
                

            }
            else
            {
                System.out.println("Failed. Please try again");
            }
           
              
        

        }
        catch(Exception e)
        {

        }
        }
    }

    public void ClientMenu() throws ParseException, IOException
    {
        boolean loggedout = false;
        while(loggedout==false)
        {
        System.out.print("\033[H\033[2J"); // !033[H moves Cursor to top left corner or console. 033[2J Clears
        System.out.flush(); // !Clear System

        System.out.println("Client Menu");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                           Welcome to Client Portal                           ");
        System.out.println(CustomerOBJ.getCustomer_Name() + " " + CustomerOBJ.getCustomer_Surname() + CustomerOBJ.getCustomer_ID());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                  Please Select Option from the menu below:                  ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("1 : Add New Booking");
        System.out.println("2 : Check Status of Booking");
        System.out.println("3 : Update Menu of Booking");
        System.out.println("0 : Exit Application");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Please select a valid menu option above");


        boolean CorrectMenuOption = false;
        while(CorrectMenuOption==false)
        {
            Scanner RDClientMenu = new Scanner(System.in);
            int intClientChoice = RDClientMenu.nextInt();
            if(intClientChoice==1)
            {
                ClientBookingPL newClientBooking = new ClientBookingPL();
                newClientBooking.AddBooking(CustomerOBJ);
                CorrectMenuOption = true ;
                        
            }
            else if(intClientChoice==2)
            {
                ClientStatusPL newClientStatus = new ClientStatusPL();
                newClientStatus.CheckStatus(CustomerOBJ);
                CorrectMenuOption = true ;

            }
            else if(intClientChoice==3)
            {
                ClientUpdatePL newClientUpdate = new ClientUpdatePL();
                newClientUpdate.UpdateMenu(CustomerOBJ);
                CorrectMenuOption = true ;
            }
            else if(intClientChoice==0)
            {
                System.out.println("You will be logged out");
                System.out.println("Press any key to continue");
                CorrectMenuOption = true;
                loggedout = true ;
                
                break;
            }
            else
            {
                System.out.println("Invalid menu option choosen! Please try again");
                CorrectMenuOption = false ;
            }
           

        }
        }
    }
    public void ResetClient()
    {
        ClientFound = false ;
    }

    public boolean ClientLogin() 
    {

        return true;
    }
    
}
