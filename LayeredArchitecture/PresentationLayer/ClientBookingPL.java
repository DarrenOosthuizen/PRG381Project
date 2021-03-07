package LayeredArchitecture.PresentationLayer;

import java.sql.Date;
import java.text.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import LayeredArchitecture.BusinessLayer.Customer;
import LayeredArchitecture.BusinessLayer.Event;
import LayeredArchitecture.DataAccessLayer.EventDH;

public class ClientBookingPL 
{

    public static void AddBooking()
    {
        

        //CustDetials.getCustomer_ID();
        //CustDetials.getCustomer_Name();
       // LocalDate.now();        
        //String sBooking_Status="Pending";
        EventDH event = new EventDH();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                           Please Select an Event type                          ");
        
        List<Event> AllEventList = event.ReadAllEvent();

       // for (Event eventItems : AllEventList) {
      //      System.out.println(eventItems);
       // }
        
       

    }   


    public static void main(String[] args) 
    {
        AddBooking();
    }
}