package LayeredArchitecture.PresentationLayer;


import java.beans.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.text.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import java.util.*;
import java.util.Calendar;

import LayeredArchitecture.BusinessLayer.Booking;
import LayeredArchitecture.BusinessLayer.BookingFood;
import LayeredArchitecture.BusinessLayer.Customer;
import LayeredArchitecture.BusinessLayer.Event;
import LayeredArchitecture.BusinessLayer.Venue;
import LayeredArchitecture.DataAccessLayer.BookingDH;
import LayeredArchitecture.DataAccessLayer.BookingFoodDH;
import LayeredArchitecture.DataAccessLayer.DataAccessLayer;
import LayeredArchitecture.DataAccessLayer.EventDH;
import LayeredArchitecture.DataAccessLayer.VenueDH;

public class ClientBookingPL 
{
    

    public  void AddBooking(Customer CusOBJ) throws ParseException, IOException
    {
        
        Scanner scScanner = new Scanner(System.in);
        CusOBJ.getCustomer_ID();
        CusOBJ.getCustomer_Name();
        EventDH eventdh = new EventDH();
        VenueDH venuedh= new VenueDH();
        Venue venue= new Venue();
        Event event= new Event();
        Customer customer= new Customer();
        BookingFood booking_food=new BookingFood();
        BookingFoodDH booking_fooddh=new BookingFoodDH();
        Booking bookingEvent= new Booking();
        BookingDH bookingeventDH= new BookingDH();

        
        int iEventID=0;
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                           Please Select an Event type                          ");
        int icount=0;
        List<Event> AllEventList = eventdh.ReadAllEvent();

       for (Event eventItems : AllEventList) {
            System.out.println(eventItems.getEvent_ID()+ ". "+eventItems.getEvent_Name());
            icount++;
        }
       
        boolean beventid=false;
        while (beventid==false) 
        {            
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                         Please Input the value of event ID                          ");
            iEventID=(scScanner.nextInt());
            if (iEventID==0 || iEventID>icount) 
            {
                System.out.println("Please select valied event type");
                break;
            }
            else
            {
                beventid=true;
            }
        }

        
        long millis=System.currentTimeMillis();
        java.sql.Date DateCreated=new java.sql.Date(millis);
        System.out.println(DateCreated);

        
        
         
        
        boolean evenyear = false;
            
        int iEventYear = 0 ;
        System.out.println("-----------------------------------------------------------------------------");    
        System.out.println("                           Please Enter Event Year                          ");
            while(evenyear==false)
            {
                iEventYear= scScanner.nextInt();
                int iYear = String.valueOf(iEventYear).length();
                if(iYear!=4)
                {   
                    System.out.println("Please Insert Valid Year");
                }
                else
                {
                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    if(iEventYear < year)
                    {
                        System.out.println("Please Insert a Current Year or Year in future");
                    }
                    else
                    {
                        evenyear = true ;
                    }
                }
            }

            boolean evenmonth = false;
            int iEventMonth = 0;
            System.out.println("-----------------------------------------------------------------------------");    
            System.out.println("                Please Enter Event Month(Enter digit month)                  ");
            while(evenmonth==false)
            {
                 iEventMonth= scScanner.nextInt();
                int iMonth = String.valueOf(iEventMonth).length();
                if(iMonth > 2)
                {
                    System.out.println("Please Insert Valid Month");
                }
                else
                {
                    if(iEventMonth == 0 || iEventMonth >12)
                    {
                        System.out.println("Please Insert Valid Month");   
                    }
                    else
                    {
                        int month = Calendar.getInstance().get(Calendar.MONTH);
                        int year = Calendar.getInstance().get(Calendar.YEAR);
                        
                        if(iEventMonth < (month+1) && iEventYear == year)
                        {
                            System.out.println("Please Insert a Current Month or Month in future");
                        }
                        else
                        {
                            evenmonth = true ;
                        }
                    }
                }
            }

            boolean evenday = false;
            int iEventDay = 0;
            System.out.println("-----------------------------------------------------------------------------");    
            System.out.println("                           Please Enter Event Day                         ");
            while(evenday==false)
            {
                iEventDay= scScanner.nextInt();
                int iDay = String.valueOf(iEventDay).length();
                if(iDay > 2)
                {
                    System.out.println("Please Insert Valid Date");
                }
                else
                {
                    if(iEventDay == 0 || iEventDay >31)
                    {
                        System.out.println("Please Insert Valid Date");   
                    }
                    else
                    {
                        int month = Calendar.getInstance().get(Calendar.MONTH);
                        int year = Calendar.getInstance().get(Calendar.YEAR);
                        int day = Calendar.getInstance().get(Calendar.DATE);
                        if(iEventDay < (day + 1) && iEventMonth == (month+1) && iEventYear == year)
                        {
                            System.out.println("Please Insert a Date 1 Day Ahead or Date in future");
                        }
                        else
                        {
                            evenday = true ;
                        }
                    }
                }

            }
            boolean datecorrect = false;
            java.sql.Date sqlDate = null;;
            while(datecorrect==false)
            {
            Date eventDateReal=new Date(iEventYear, iEventMonth, iEventDay);
            sqlDate = new java.sql.Date(eventDateReal.getTime());
            }
            
           
            
            
            
           boolean eventime=false;
           String sTime;
           Time eventimeReal;
                       
            

            System.out.println("-----------------------------------------------------------------------------");    
            System.out.println("                           Please Enter Event Time(HH:MM:SS)                         ");
            Scanner timScanner = new Scanner(System.in) ;
            sTime= timScanner.nextLine();         
            
            

           
            
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                           Please Select a Venue                          ");
            
            List<Venue> AllVenueList = venuedh.ReadAllVenues();
            int vicount=0;
           for (Venue venueItems : AllVenueList) {
                System.out.println("Venue ID= "+venueItems.getVenue_ID()+" Venue Name= "+venueItems.getVenue_Name());
                vicount++;
            }
            
         

         
             
           
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                         Please Input the value of Venue ID                          ");
        System.out.println("                        If Venue not on list please enter 0                           ");
        int iVenueID=0;
        boolean venueselected= false;

        while (venueselected==false) 
        {  
            icount = 0;
           iVenueID=(scScanner.nextInt());

            for (Venue venueItems : AllVenueList) 
                {
                    icount ++;
                }

            if(iVenueID > icount)
            {
                System.out.println("Please enter valid ID");
            }               
            else if (iVenueID==(0)) 
            {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                         Please Enter Name of Venue                          ");
                String sVenueName =(scScanner.nextLine());
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                         Please Enter Address of Venue                          ");
                String sVenueAdress =(scScanner.nextLine());
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                         Please Enter Phone Number of Venue                          ");
                String sVenueNumber =(scScanner.nextLine()); 
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                         Please Enter Email of Venue                          ");
                String sVenueEmail =(scScanner.nextLine()); 
                venueselected=true;
                venue.setVenue_Address(sVenueAdress);
                venue.setVenue_Email(sVenueEmail);
                venue.setVenue_Name(sVenueName);
                venue.setVenue_Phone_Number(sVenueNumber);
                venuedh.CreateVenue(venue);
                List<Venue> venueList=  venuedh.ReadAllVenues();
                    for (Venue venue2 : venueList) 
                    {
                        if (venue2.getVenue_Name().equals(sVenueName)) 
                        {
                            iVenueID=venue2.getVenue_ID();
                        }
                    }
            }
            else 
            {
                venueselected= true ;
            }                  
        }

                boolean badults=false;
                int iAdults_meal=0;
                int iTotalAdults=0;
                while (badults==false) 
                {                            
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                         Please Input the Amount of Adults                          ");
                
                iTotalAdults =(scScanner.nextInt());                                        
                if (iTotalAdults==0) {
                 iAdults_meal=0;
                 badults=true;
                }
                else
                {
                    iAdults_meal=1;
                    badults=true;
                }
            

            }
            int iKids_meal=0;
            int iTotalKids=0;
            boolean bkids=false;

            while (bkids==false) {
                
            
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                         Please Input the Amount of Kids                         ");
                iKids_meal=0;
               iTotalKids =(scScanner.nextInt());
                
               if (iTotalKids==0) {
                  iKids_meal=0;
               }
               else{
                iKids_meal=1;
                bkids = true;
               }
            }

            int menudrinks=0;
            boolean bdriks=false;

            
                
            
               System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                         Would you like Drinks menu?(yes/no)                        ");
            while (bdriks==false) 
            {
                String drinks=scScanner.nextLine();

                if (drinks.equalsIgnoreCase("YES")) {
                    menudrinks=1;
                    bdriks=true;
                }
                else if (drinks.equalsIgnoreCase("NO"))                              
                {
                    menudrinks=0;
                    bdriks=true;
                } 
                else 
                {
                    System.out.println("Please only type yes or no");
                    bdriks=false;
                }
            
            }
                
                boolean bDessert =false;
                int menudessert=0;


               
                    
                
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                         Would you like Dessert menu?(yes/no)                         ");

                while (bDessert==false) 
                {
                String dessert=scScanner.nextLine();
                if (dessert.equalsIgnoreCase("yes")) {
                    menudessert=1;
                    bDessert = true ;
                }
                else if(dessert.equalsIgnoreCase("no"))
                {
                    menudessert=0;
                    bDessert = true ;
                } 
                else if(!dessert.equalsIgnoreCase("NO") && !dessert.equalsIgnoreCase("YES"))
                {
                    System.out.println("Please only type yes or no");
                    bDessert=false;
                }

            }

            int iDecorations=0;
            String Decorations="";  
            String additionalDecor="None";
            boolean bDecor=false;
            while(bDecor==false)
            {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                         Would you like Decorations?(yes/no)                         ");
                
                
                Decorations=scScanner.nextLine();
                if (Decorations.equalsIgnoreCase("yes")) 
                {
                    iDecorations=1;
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("                         Please specify Additional Decorations.                     ");
                    additionalDecor=scScanner.nextLine();

                    bDecor=true;
                }
                else if(Decorations.equalsIgnoreCase("no"))
                {
                    iDecorations=0;
                    bDecor=true;
                }
                else{
                    System.out.println("only enter yes or no");
                }
            }
 
               
            bookingEvent.setCustomerID(CusOBJ.getCustomer_ID());
            bookingEvent.setCustomer_Name(CusOBJ.getCustomer_Name());
            bookingEvent.setDateCreated(DateCreated);
            bookingEvent.setBooking_Status("Non-Confirmed");
            bookingEvent.setEvent_ID(iEventID);
            bookingEvent.setEvent_Date(sqlDate);
            bookingEvent.setEvent_Time(sTime);
            bookingEvent.setVenue_ID(iVenueID);
            bookingEvent.setTotal_Adults(iTotalAdults);
            bookingEvent.setTotal_Kids(iTotalKids);

            bookingeventDH.CreateBooking(bookingEvent);

            booking_food.setAdults_Meal(iAdults_meal);
            booking_food.setKids_Meal(iKids_meal);
            booking_food.setDrinks(menudrinks);
            booking_food.setDessert(menudessert);
            booking_food.setDecorations(iDecorations);
            booking_food.setAdditional_Decorations(additionalDecor);
            booking_fooddh.CreateBookingFood(booking_food);

            //!Wait for keypress to reset the while and start from the begining
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
        }

      

}