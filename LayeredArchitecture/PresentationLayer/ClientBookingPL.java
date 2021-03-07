package LayeredArchitecture.PresentationLayer;

import java.beans.Statement;
import java.sql.Time;
import java.text.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import java.util.*;

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

public class ClientBookingPL {

    public void AddBooking() throws ParseException {

        Scanner scScanner = new Scanner(System.in);
        // CustDetials.getCustomer_ID();
        // CustDetials.getCustomer_Name();
        // LocalDate.now();
        // String sBooking_Status="Pending";
        EventDH eventdh = new EventDH();
        VenueDH venuedh = new VenueDH();
        Venue venue = new Venue();
        Event event = new Event();
        Customer customer = new Customer();
        BookingFood booking_food = new BookingFood();
        BookingFoodDH booking_fooddh = new BookingFoodDH();
        Booking bookingEvent = new Booking();
        BookingDH bookingeventDH = new BookingDH();

        boolean beventid = false;
        int iEventID = 0;
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                           Please Select an Event type                          ");
        int icount = 0;
        List<Event> AllEventList = eventdh.ReadAllEvent();

        for (Event eventItems : AllEventList) {
            System.out.println("Event ID= " + eventItems.getEvent_ID() + " Event Type= " + eventItems.getEvent_Name());
            icount++;
        }

        while (beventid = false) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                         Please Input the value of event ID                          ");
            iEventID = (scScanner.nextInt());
            if (iEventID == 0 || iEventID > icount) {
                System.out.println("Please select valied event type");
                break;
            } else {
                beventid = true;
            }

        }

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                           Please Enter Event Year                          ");
        int sEventYear = scScanner.nextInt();

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(
                "                           Please Enter Event Month(Enter digit month)                          ");
        int sEventMonth = scScanner.nextInt();

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                           Please Enter Event Day                        ");
        int sEventDay = scScanner.nextInt();

        Date eventDateReal = new Date(sEventYear, sEventMonth, sEventDay);

        boolean eventime = false;
        long sTime;
        Time eventimeReal;

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                           Please Enter Event Time(24h time)                         ");

        sTime = (scScanner.nextLong());
        eventimeReal = new Time(sTime);

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                           Please Select a Venue                          ");

        List<Venue> AllVenueList = venuedh.ReadAllVenues();
        int vicount = 0;
        for (Venue venueItems : AllVenueList) {
            System.out.println("Venue ID= " + venueItems.getVenue_ID() + " Venue Name= " + venueItems.getVenue_Name());
            vicount++;
        }

        boolean bVenueID = false;

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                         Please Input the value of Venue ID                          ");
        System.out.println("                        If Venue not on list please enter 0                           ");
        int iVenueID = 0;
        boolean venueselected = false;

        while (venueselected == false) {

            iVenueID = (scScanner.nextInt());

            for (Venue venueItems : AllVenueList) {

                if (iVenueID == (venueItems.getVenue_ID())) {
                    iVenueID = (venueItems.getVenue_ID());
                    venueselected = true;
                } else {
                    if (iVenueID == (0)) {
                        System.out.println(
                                "-----------------------------------------------------------------------------");
                        System.out.println(
                                "                         Please Enter Name of Venue                          ");
                        String sVenueName = (scScanner.nextLine());
                        System.out.println(
                                "-----------------------------------------------------------------------------");
                        System.out.println(
                                "                         Please Enter Address of Venue                          ");
                        String sVenueAdress = (scScanner.nextLine());
                        System.out.println(
                                "-----------------------------------------------------------------------------");
                        System.out.println(
                                "                         Please Enter Phone Number of Venue                          ");
                        String sVenueNumber = (scScanner.nextLine());
                        System.out.println(
                                "-----------------------------------------------------------------------------");
                        System.out.println(
                                "                         Please Enter Email of Venue                          ");
                        String sVenueEmail = (scScanner.nextLine());

                        venueselected = true;

                        venue.setVenue_Address(sVenueAdress);
                        venue.setVenue_Email(sVenueEmail);
                        venue.setVenue_Name(sVenueName);
                        venue.setVenue_Phone_Number(sVenueNumber);
                        venuedh.CreateVenue(venue);

                        List<Venue> venueList = venuedh.ReadAllVenues();

                        for (Venue venue2 : venueList) {
                            if (venue2.getVenue_Name().equals(sVenueName)) {
                                iVenueID = venue2.getVenue_ID();
                            }
                        }

                    } else {
                        System.out.println("venue not selected please try again");
                    }

                }

            }

        }

        boolean badults = false;
        int iAdults_meal = 0;
        int iTotalAdults = 0;
        while (badults = false) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                         Please Input the Amount of Adults                          ");

            iTotalAdults = (scScanner.nextInt());
            if (iTotalAdults == 0) {
                iAdults_meal = 0;
                badults = true;
            } else {
                iAdults_meal = 1;
                badults = true;
            }

        }
        int iKids_meal = 0;
        int iTotalKids = 0;
        boolean bkids = false;

        while (bkids = false) {

            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                         Please Input the Amount of Kids                         ");
            iKids_meal = 0;
            iTotalKids = (scScanner.nextInt());

            if (iTotalKids == 0) {
                iKids_meal = 0;
            } else {
                iKids_meal = 1;
            }
        }

        int menudrinks = 0;
        boolean bdriks = false;

        while (bdriks = false) {

            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                         Would you like Drinks menu?(yes/no)                        ");

            String drinks = scScanner.nextLine();

            if (drinks.equalsIgnoreCase("yes")) {
                menudrinks = 1;
                bdriks = true;
            } else if (drinks.equalsIgnoreCase("no")) {
                menudrinks = 0;
                bdriks = true;
            } else {
                System.out.println("Please only type yes or no");
                bdriks = false;
            }

        }

        boolean bDessert = false;
        int menudessert = 0;

        while (bDessert = false) {

            System.out.println("-----------------------------------------------------------------------------");
            System.out
                    .println("                         Would you like Dessert menu?(yes/no)                         ");

            String dessert = scScanner.nextLine();
            if (dessert.equalsIgnoreCase("yes")) {
                menudessert = 1;
            } else if (dessert.equalsIgnoreCase("no")) {
                menudessert = 0;
            } else {
                System.out.println("Please only type yes or no");
                bDessert = false;
            }

        }

        int iDecorations = 0;
        String Decorations = "";
        String additionalDecor = "";
        boolean bDecor = false;
        while (bDecor = false) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                         Would you like Decorations?(yes/no)                         ");

            Decorations = scScanner.nextLine();
            if (Decorations.equalsIgnoreCase("yes")) {
                iDecorations = 1;
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(
                        "                         Please specify Additional Decorations.                     ");
                additionalDecor = scScanner.nextLine();

                bDecor = true;
            } else if (Decorations.equalsIgnoreCase("no")) {
                iDecorations = 0;
                bDecor = true;
            } else {
                System.out.println("only enter yes or no");
            }
        }

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Date todayWithZeroTime = formatter.parse(formatter.format(today));

        bookingEvent.setCustomerID(customer.getCustomer_ID());
        bookingEvent.setCustomer_Name(customer.getCustomer_Name());
        bookingEvent.setDateCreated(todayWithZeroTime);
        bookingEvent.setBooking_Status("Non-Confirmed");
        bookingEvent.setEvent_ID(iEventID);
        bookingEvent.setEvent_Date(eventDateReal);
        bookingEvent.setEvent_Time(eventimeReal);
        bookingEvent.setVenue_ID(iVenueID);
        bookingEvent.setTotal_Adults(iTotalAdults);
        bookingEvent.setTotal_Kids(iTotalKids);

        // bookingeventDH.CreateBooking(iiBookingid, iiCustomer_ID, ssCustomer_Name,
        // dDate_Created, sBooking_status, dEvent_ID, dEvent_date, tEvent_time,
        // sVenue_ID, iTotal_Adults, iTotal_Kids);

        booking_food.setAdults_Meal(iAdults_meal);
        booking_food.setKids_Meal(iKids_meal);
        booking_food.setDrinks(menudrinks);
        booking_food.setDessert(menudessert);
        booking_food.setDecorations(iDecorations);
        booking_food.setAdditional_Decorations(additionalDecor);
        // booking_fooddh.CreateBookingFood(AdultsMeal, Kids_meal, Drinks, Dessert,
        // Decorations, Additional_Decorations);

    }

}