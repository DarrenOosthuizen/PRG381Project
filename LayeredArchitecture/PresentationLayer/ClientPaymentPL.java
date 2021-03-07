package LayeredArchitecture.PresentationLayer;

import java.util.List;
import java.util.Scanner;

import LayeredArchitecture.BusinessLayer.Booking;
import LayeredArchitecture.BusinessLayer.BookingFinance;
import LayeredArchitecture.BusinessLayer.BookingFood;
import LayeredArchitecture.BusinessLayer.Customer;
import LayeredArchitecture.DataAccessLayer.BookingDH;
import LayeredArchitecture.DataAccessLayer.BookingFinanceDH;
import LayeredArchitecture.DataAccessLayer.BookingFoodDH;

public class ClientPaymentPL 
{
    BookingDH bookingobj = new BookingDH();
    BookingFinanceDH bookingfinanceobj = new BookingFinanceDH();
    List<Booking> lstBooking = bookingobj.ReadAllBookings();
    List<BookingFinance> lstBookingFinance = bookingfinanceobj.ReadAllBookingFinance();
    BookingFinance oldfinance = new BookingFinance();
    BookingFinance newfinance = new BookingFinance();


    public void AddPayment(Customer cusOBJ)
    {
        boolean loggedout = false;
        while(loggedout==false)
        {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("                  Welcome to Booking Payment Menu                   ");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("                      Please Insert Booking ID                      ");
            System.out.println("                           Please 0 to Exit                         ");
            System.out.println("--------------------------------------------------------------------");
            Scanner scannerPay = new Scanner(System.in);
             
            int ClientPay = scannerPay.nextInt();

            if(ClientPay==0)
            {
                System.out.println("Exiting!");
                System.out.println("Press Any Key to Continue");
                loggedout = true ;
            }
            else if(ClientPay > lstBooking.size())
            {
                 System.out.println("Booking ID not found or Booking ID does not belong to you! Please Try Again");
            }
            else
            {
                for (Booking bookingitem : lstBooking) 
                {
                    if(bookingitem.getBookingID()==ClientPay)
                    {
                        if(bookingitem.getCustomerID()==cusOBJ.getCustomer_ID())
                        {
                            for (BookingFinance bookingfiitem : lstBookingFinance) 
                            {
                                if(bookingfiitem.getBooking_ID()==bookingitem.getBookingID())
                                {
                                    oldfinance.setTotal_Price(bookingfiitem.getTotal_Price()); 
                                    oldfinance.setDeposit(bookingfiitem.getDeposit()); 
                                    oldfinance.setIs_Deposit_Paid(bookingfiitem.getIs_Deposit_Paid()); 
                                    oldfinance.setAmount_Paid(bookingfiitem.getAmount_Paid()); 
                                    oldfinance.setIs_Fully_Paid(bookingfiitem.getIs_Fully_Paid()); 
                                     
                                    String DepPaid = "";
                                    if(bookingfiitem.getIs_Deposit_Paid()==0)
                                    {
                                        DepPaid = "No";
                                    }
                                    else
                                    {
                                        DepPaid = "Yes";
                                    }

                                    String FullPaid = "";
                                    if(bookingfiitem.getIs_Fully_Paid()==0)
                                    {
                                        FullPaid = "No";
                                    }
                                    else
                                    {
                                        FullPaid = "Yes";
                                    }
                                    System.out.println("Total Amount is : " + bookingfiitem.getTotal_Price());
                                    System.out.println("Deposit Amount is : " + bookingfiitem.getDeposit());
                                    System.out.println("Deposit Paid : " + DepPaid);
                                    System.out.println("Full Amount Paid : " + FullPaid);
                                    System.out.println("Amount To Pay : " + (bookingfiitem.getTotal_Price() - bookingfiitem.getAmount_Paid()));

                                    System.out.println("            Please Insert Amount you Wish to pay             ");
                                    Float ClientAmount = scannerPay.nextFloat();

                                    System.out.println("You are going to pay : " + ClientAmount);

                                    newfinance.setTotal_Price(oldfinance.getTotal_Price()); 
                                    newfinance.setDeposit(oldfinance.getDeposit()); 
                                    newfinance.setIs_Deposit_Paid(oldfinance.getIs_Deposit_Paid()); 
                                    newfinance.setAmount_Paid(ClientAmount); 
                                    newfinance.setIs_Fully_Paid(oldfinance.getIs_Fully_Paid()); 

                                    bookingfinanceobj.UpdateBookingFinance(oldfinance, newfinance);
                                    System.out.println("Paid");

                                }
                            }
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
