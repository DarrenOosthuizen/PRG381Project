package LayeredArchitecture.PresentationLayer;

import java.util.List;
import java.util.Scanner;

import LayeredArchitecture.BusinessLayer.Booking;
import LayeredArchitecture.BusinessLayer.BookingFood;
import LayeredArchitecture.BusinessLayer.Customer;
import LayeredArchitecture.DataAccessLayer.BookingDH;
import LayeredArchitecture.DataAccessLayer.BookingFoodDH;
import LayeredArchitecture.DataAccessLayer.Notification;

public class ClientUpdatePL 
{ 
    BookingDH bookingobj = new BookingDH();
    BookingFoodDH foodobj = new BookingFoodDH();
    BookingFood newFoodobj = new BookingFood();
    BookingFood oldFoodobj = new BookingFood();
    private static Notification notificationService = new Notification();

    public void UpdateMenu(Customer CusOBJ)
    {
        List<Booking> BookingList = bookingobj.ReadAllBookings();
        
        Scanner updateScanner = new Scanner(System.in);
        boolean loggedout = false;
        while(loggedout==false)
        {
        System.out.println("--------------------------------------------------------");
        System.out.println("             Welcome to Update Booking Menu             ");
        System.out.println("                    Enter 0 to exit                     ");
        System.out.println("--------------------------------------------------------");
        System.out.println("                 Please enter BookingID                 ");
        System.out.println("--------------------------------------------------------");
            int iupdate = 0 ;
            int ClientUpdate = updateScanner.nextInt();
            if(ClientUpdate==0)
            {
                System.out.println("Exiting!");
                System.out.println("Press Any Key to Continue");
                loggedout = true ;
                break;
            }
            else if(ClientUpdate > BookingList.size())
            {
                 System.out.println("Booking ID not found or Booking ID does not belong to you! Please Try Again");
            }
            else
            {
                
                for (Booking bookingitem : BookingList) 
                {
                    if(bookingitem.getBookingID()==ClientUpdate)
                    {
                        
                        
                        
                        if(bookingitem.getCustomerID()==CusOBJ.getCustomer_ID())
                        {
                            
                            List<BookingFood> FoodList = foodobj.ReadAllBookingFood();
                            for (BookingFood bookingitemfood : FoodList) 
                            {
                                if(bookingitemfood.getBooking_ID()==bookingitem.getBookingID())
                                {
                                    oldFoodobj.setBooking_ID(bookingitemfood.getBooking_ID());
                                    oldFoodobj.setAdults_Meal(bookingitemfood.getAdults_Meal());
                                    oldFoodobj.setKids_Meal(bookingitemfood.getDrinks());
                                    oldFoodobj.setDrinks(bookingitemfood.getDessert());
                                    oldFoodobj.setDessert(bookingitemfood.getDessert());
                                    oldFoodobj.setDecorations(bookingitemfood.getDecorations());
                                    oldFoodobj.setAdditional_Decorations(bookingitemfood.getAdditional_Decorations());
                                    if(bookingitemfood.getAdults_Meal()==1)
                                    {
                                        System.out.println("1.You currently have Adult Menu Selected");
                                    }
                                    else
                                    {
                                        System.out.println("1.You currently dont have Adults Menu Selected");
                                    }
                                    if(bookingitemfood.getKids_Meal()==1)
                                    {
                                        System.out.println("2.You currently have Kids Menu Selected");
                                    }
                                    else
                                    {
                                        System.out.println("2.You currently dont have Kids Menu Selected");
                                    }
                                    if(bookingitemfood.getDrinks()==1)
                                    {
                                        System.out.println("3.You currently have Drinks Menu Selected");
                                    }
                                    else
                                    {
                                        System.out.println("3.You currently dont have Drinks Menu Selected");
                                    }
                                    if(bookingitemfood.getDessert()==1)
                                    {
                                        System.out.println("4.You currently have Dessert Menu Selected");
                                    }
                                    else
                                    {
                                        System.out.println("4.You currently dont have Dessert Menu Selected");
                                    }
                                    if(bookingitemfood.getDecorations()==1)
                                    {
                                        iupdate = 6;
                                        System.out.println("5.You currently have Additional Decorations Selected");
                                        System.out.println("5.Your current Decorations Notes : " + bookingitemfood.getAdditional_Decorations());

                                    }
                                    else
                                    {
                                        System.out.println("5.You currently dont have Additional Decorations Selected");
                                        iupdate = 5 ;
                                    }
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
            boolean updatedone = false;
            while(updatedone==false)
            {
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("                  Please Enter ID you would like to alter                  ");
                System.out.println("                          Please Enter 0 to Exit                           ");
                System.out.println("---------------------------------------------------------------------------");
                Scanner scUpdate = new Scanner(System.in);
                int UpdateChoice = scUpdate.nextInt();

                if(UpdateChoice > iupdate)
                {
                    System.out.println("Please Enter Valid Option");
                }
                else if (UpdateChoice==1)
                {
                    boolean done = false;
                    while(done == false)
                    {
                        System.out.println("Please enter Yes to have Adults Menu or No to not have Adults Menu");
                        String strUpdate = scUpdate.nextLine();
                        if(strUpdate.equalsIgnoreCase("YES"))
                        { 
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setAdults_Meal(1); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Menu Updated","Adults Menu Updated on order :" + newFoodobj.getBooking_ID);
                            
                            done = true;       
                        }
                        else if (strUpdate.equalsIgnoreCase("NO"))
                        {
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setAdults_Meal(0); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Menu Updated","Adults Menu Updated on order :" + newFoodobj.getBooking_ID);
                            
                            done = true ;
                        }
                        else
                        {
                            System.out.println("Please insert Valid Answer");
                        }
                    }
                }
                else if (UpdateChoice==2)
                {
                    boolean done = false;
                    while(done == false)
                    {
                        System.out.println("Please enter Yes to have Kids Menu or No to not have Kids Menu");
                        String strUpdate = scUpdate.nextLine();
                        if(strUpdate.equalsIgnoreCase("YES"))
                        {                          
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setKids_Meal(1); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Menu Updated","Kids Menu Updated on order :" + newFoodobj.getBooking_ID);
                            done = true;                   
                        }
                        else if (strUpdate.equalsIgnoreCase("NO"))
                        {
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setKids_Meal(0); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Menu Updated","Kids Menu Updated on order :" + newFoodobj.getBooking_ID);
                            done = true ;
                        }
                        else
                        {
                            System.out.println("Please insert Valid Answer");
                        }
                    }
                }
                else if (UpdateChoice==3)
                {
                    boolean done = false;
                    while(done == false)
                    {
                        System.out.println("Please enter Yes to have Drinks Menu or No to not have Drinks Menu");
                        String strUpdate = scUpdate.nextLine();
                        if(strUpdate.equalsIgnoreCase("YES"))
                        {                      
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setDrinks(1); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Menu Updated","Drinks Menu Updated on order :" + newFoodobj.getBooking_ID);
                            done = true;                   
                        }
                        else if (strUpdate.equalsIgnoreCase("NO"))
                        {
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setDrinks(0); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Menu Updated","Drinks Menu Updated on order :" + newFoodobj.getBooking_ID);
                            done = true ;
                        }
                        else
                        {
                            System.out.println("Please insert Valid Answer");
                        }
                    }
                }
                else if (UpdateChoice==4)
                {
                    boolean done = false;
                    while(done == false)
                    {
                        System.out.println("Please enter Yes to have Dessert Menu or No to not have Dessert Menu");
                        String strUpdate = scUpdate.nextLine();
                        if(strUpdate.equalsIgnoreCase("YES"))
                        {
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setDessert(1); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Menu Updated","Dessert Menu Updated on order :" + newFoodobj.getBooking_ID);
                            done = true;                 
                        }
                        else if (strUpdate.equalsIgnoreCase("NO"))
                        {
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setDessert(0); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Menu Updated","Dessert Menu Updated on order :" + newFoodobj.getBooking_ID);
                            done = true ;
                        }
                        else
                        {
                            System.out.println("Please insert Valid Answer");
                        }
                    }
                }
                else if (UpdateChoice==5)
                {
                    boolean done = false;
                    while(done == false)
                    {
                        System.out.println("Please enter Yes to have Decorations or No to not have Decorations");
                        String strUpdate = scUpdate.nextLine();
                        if(strUpdate.equalsIgnoreCase("YES"))
                        {                     
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setDecorations(1); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Decorations Updated","Decorations Updated on order :" + newFoodobj.getBooking_ID);
                            done = true;                      
                        }
                        else if (strUpdate.equalsIgnoreCase("NO"))
                        {
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdditional_Decorations(oldFoodobj.getAdditional_Decorations()); 
                            newFoodobj.setDecorations(0); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            done = true ;
                        }
                        else
                        {
                            System.out.println("Please insert Valid Answer");
                        }
                    }
                }
                else if (UpdateChoice==6)
                {
                    boolean done = false;
                    while(done == false)
                    {
                        System.out.println("Please enter Yes to have additional Decorations or No to not have additional Decorations");
                        String strUpdate = scUpdate.nextLine();
                        if(strUpdate.equalsIgnoreCase("YES"))
                        {   
                            System.out.println("Please Insert what Decorations you would like to have:");
                            String UserDeco = scUpdate.nextLine();
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setAdditional_Decorations(strUpdate); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Additional Decorations Updated","Additional Decorations Updated on order :" + newFoodobj.getBooking_ID);
                            done = true;          
                        }
                        else if (strUpdate.equalsIgnoreCase("NO"))
                        {
                            newFoodobj.setBooking_ID(oldFoodobj.getBooking_ID()); 
                            newFoodobj.setKids_Meal(oldFoodobj.getKids_Meal()); 
                            newFoodobj.setDecorations(oldFoodobj.getDecorations()); 
                            newFoodobj.setDessert(oldFoodobj.getDessert()); 
                            newFoodobj.setDrinks(oldFoodobj.getDrinks()); 
                            newFoodobj.setAdults_Meal(oldFoodobj.getAdults_Meal()); 
                            newFoodobj.setAdditional_Decorations("None"); 
                            foodobj.UpdateBookingFood(oldFoodobj, newFoodobj);
                            System.out.println("Menu Updated");
                            notificationService.SendMail("Raheal@gmail.com","Additional Decorations Updated","Additional Decorations Updated on order :" + newFoodobj.getBooking_ID);
                           
                            done = true ;
                        }
                        else
                        {
                            System.out.println("Please insert Valid Answer");
                        }
                    }   
                }
                else if(UpdateChoice == 0)
                {
                    System.out.println("Exiting Now");
                    updatedone = true;

                }
            }
        }
    }
}
