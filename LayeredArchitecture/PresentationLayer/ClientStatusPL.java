package LayeredArchitecture.PresentationLayer;

import java.util.List;
import java.util.Scanner;

import LayeredArchitecture.BusinessLayer.Booking;
import LayeredArchitecture.BusinessLayer.Customer;
import LayeredArchitecture.DataAccessLayer.BookingDH;

public class ClientStatusPL 
{
    BookingDH bookingobj = new BookingDH();
    public void CheckStatus(Customer customerOBJ)
    {
        boolean loggedout = false;
        while(loggedout == false)
        {
            List<Booking> BookingList = bookingobj.ReadAllBookings();
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                      Welcome to Status Check                      ");
            System.out.println("                      Please enter 0 to exit                      ");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("            Please Enter the Booking ID to view status             ");
            System.out.println("-------------------------------------------------------------------");
            Scanner RDClientStatus = new Scanner(System.in);
            int ClientBooking = RDClientStatus.nextInt();
            if(ClientBooking==0)
            {
                System.out.println("Exiting!");
                System.out.println("Press Any Key to Continue");
                loggedout = true ;
            }
            else if(ClientBooking > BookingList.size())
            {
                System.out.println("Booking ID not found or Booking ID does not belong to you! Please Try Again");
            }
            else
            {
                for (Booking bookingitem : BookingList) 
                {
                    if(bookingitem.getBookingID()==ClientBooking)
                    {
                        if(bookingitem.getCustomerID()==customerOBJ.getCustomer_ID())
                        {
                            System.out.println("Your Booking with ID: " + bookingitem.getBookingID() + " status is : " + bookingitem.getBooking_Status());
                        }
                        else
                        {
                            System.out.println("Booking ID not found or Booking ID does not belong to you! Please Try Again");
                        }
                        
                
                    }
                }
            }
        }


        
    }
    
}
