package LayeredArchitecture.PresentationLayer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import LayeredArchitecture.BusinessLayer.Booking;
import LayeredArchitecture.DataAccessLayer.BookingDH;
import LayeredArchitecture.DataAccessLayer.VenueDH;
import LayeredArchitecture.DataAccessLayer.BookingFinanceDH;
import LayeredArchitecture.BusinessLayer.BookingFinance;

public class EmployeeBookingPL {

    private static BookingDH bookingDH = new BookingDH();
    private List<Booking> bookingsList = new ArrayList<Booking>();
    private static BookingFinanceDH bookingFinanceDH = new BookingFinanceDH();

    EmployeeBookingPL() {
        GetAllBookings();
    }

    public List<Booking> GetAllBookings() {
        bookingsList = bookingDH.ReadAllBookings();
        return bookingsList;
    }

    public List<Booking> GetPaidBookings() {
        List<Booking> paidBookingsList = new ArrayList<Booking>();
        List<BookingFinance> bookingFinanceList = bookingFinanceDH.ReadAllBookingFinance();
        List<Booking> nonConfirmedBookings = GetNonConfirmedBookings();
        for (Booking booking : nonConfirmedBookings) {
            for (BookingFinance bookingFinance : bookingFinanceList) {
                if (booking.getBookingID() == bookingFinance.getBooking_ID()) {
                    paidBookingsList.add(booking);
                }
            }
        }
        return paidBookingsList;
    }

    public List<Booking> GetUnPaidBookings() {
        List<Booking> unpaidBookingsList = new ArrayList<Booking>();
        List<Booking> paidBookings = GetPaidBookings();
        for (Booking booking : GetNonConfirmedBookings()) {
            if (!paidBookings.contains(booking)) {
                unpaidBookingsList.add(booking);
            }
        }
        return unpaidBookingsList;
    }

    public List<Booking> GetConfirmedBookings() {
        List<Booking> confirmedBookingsList = new ArrayList<Booking>();
        for (Booking booking : bookingsList) {
            if (booking.getBooking_Status().equalsIgnoreCase("Confirmed")) {
                confirmedBookingsList.add(booking);
            }
        }
        return confirmedBookingsList;
    }

    public List<Booking> GetNonConfirmedBookings() {
        List<Booking> nonConfirmedBookingsList = new ArrayList<Booking>();
        for (Booking booking : bookingsList) {
            if (booking.getBooking_Status().equalsIgnoreCase("Not-Confirmed")) {
                nonConfirmedBookingsList.add(booking);
            }
        }
        return nonConfirmedBookingsList;
    }

    public void ViewUnpaidBookings() {

        boolean loggedout = false;
        while (!loggedout) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println(" Current unpaid Bookings: ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%6s\t%20s\t%10s\t%10s\t%20s\t%20s\n", "Select", "Customer Name", "Date", "Time", "Venue",
                    "# of attendees");

            int indexCounter = 1;
            VenueDH venueDH = new VenueDH();
            List<Booking> menuBookings = new ArrayList<Booking>();
            for (Booking booking : GetUnPaidBookings()) {
                booking.setMenuIndexer(indexCounter);
                System.out.printf("%6s\t%20s\t%10s\t%10s\t%20s\t%20s\n", Integer.toString(indexCounter),
                        booking.getCustomer_Name(), booking.getEvent_Date(), booking.getEvent_Time(),
                        venueDH.ReadVenue(booking.getVenue_ID()).getVenue_Name(),
                        Integer.toString(booking.getTotal_Adults() + booking.getTotal_Kids()));
                menuBookings.add(booking);
                indexCounter++;
            }
            System.out.println("Select a booking to set a price:");
            Scanner employeScanner = new Scanner(System.in);
            int bookingChoice = employeScanner.nextInt();
            if (bookingChoice != 0) {
                for (Booking booking : menuBookings) {
                    if (booking.getMenuIndexer() == bookingChoice) {
                        ViewUnPaidBooking(booking);
                    }
                }
            } else {
                loggedout = true;
            }
        }
    }

    public void ViewUnPaidBooking(Booking booking) {
        boolean loggedout = false;
        while (!loggedout) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                   Booking ID:" + booking.getBookingID() + "                  ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("Booking ID: " + booking.getBookingID());
            System.out.println("Customer ID: " + booking.getCustomerID());
            System.out.println("Customer Name: " + booking.getCustomer_Name());
            System.out.println("Date Created: " + booking.getDateCreated());
            System.out.println("Booking Status: " + booking.getBooking_Status());
            System.out.println("Event ID: " + booking.getEvent_ID());
            System.out.println("Event Date: " + booking.getEvent_Date());
            System.out.println("Event Time: " + booking.getEvent_Time());
            System.out.println("Venue ID: " + booking.getVenue_ID());
            System.out.println("Total Aduldts: " + booking.getTotal_Adults());
            System.out.println("Total Kids: " + booking.getTotal_Kids());
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("0. Back");
            System.out.println("1. Set Booking total price");
            Scanner employeScanner = new Scanner(System.in);
            int bookingChoice = employeScanner.nextInt();
            if (bookingChoice == 0) {
                loggedout = true;

            } else if (bookingChoice == 1) {
                Float totalPrice = 0.0f;
                System.out.println("Please enter total price:");
                try {
                    totalPrice = employeScanner.nextFloat();
                } catch (Exception e) {
                    System.out.println("Please enter valid total price: (Format 0.0)");
                }

                SetBookingPrice(booking, totalPrice);
                System.out.println("Booking price set.");
                loggedout = true;
            }
        }
    }

    public void SetBookingPrice(Booking booking, Float price) {
        BookingFinance bookingFinance = new BookingFinance(booking.getBookingID(), price, price / 2, 0, 0, 0.0f);
        bookingFinanceDH.CreateBookingFinance(bookingFinance);
    }

    public void ViewConfirmedBookings() {
        boolean loggedout = false;
        while (!loggedout) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                  Current Confirmed Bookings:                  ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%6s\t%20s\t%10s\t%10s\t%20s\t%20s\n", "Select", "Customer Name", "Date", "Time", "Venue",
                    "# of attendees");

            int indexCounter = 1;
            VenueDH venueDH = new VenueDH();
            List<Booking> menuBookings = new ArrayList<Booking>();
            for (Booking booking : GetConfirmedBookings()) {
                booking.setMenuIndexer(indexCounter);
                System.out.printf("%6s\t%20s\t%10s\t%10s\t%20s\t%20s\n", Integer.toString(indexCounter),
                        booking.getCustomer_Name(), booking.getEvent_Date(), booking.getEvent_Time(),
                        venueDH.ReadVenue(booking.getVenue_ID()).getVenue_Name(),
                        Integer.toString(booking.getTotal_Adults() + booking.getTotal_Kids()));
                menuBookings.add(booking);
                indexCounter++;
            }
            System.out.println("Select a booking:");
            Scanner employeScanner = new Scanner(System.in);
            int bookingChoice = employeScanner.nextInt();
            if (bookingChoice != 0) {
                for (Booking booking : menuBookings) {
                    if (booking.getMenuIndexer() == bookingChoice) {
                        ViewConfirmedBooking(booking);
                    }
                }
            } else {
                loggedout = true;
            }

        }

    }

    public void ViewConfirmedBooking(Booking booking) {
        boolean loggedout = false;
        while (!loggedout) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                   Booking ID:" + booking.getBookingID() + "                  ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("Booking ID: " + booking.getBookingID());
            System.out.println("Customer ID: " + booking.getCustomerID());
            System.out.println("Customer Name: " + booking.getCustomer_Name());
            System.out.println("Date Created: " + booking.getDateCreated());
            System.out.println("Booking Status: " + booking.getBooking_Status());
            System.out.println("Event ID: " + booking.getEvent_ID());
            System.out.println("Event Date: " + booking.getEvent_Date());
            System.out.println("Event Time: " + booking.getEvent_Time());
            System.out.println("Venue ID: " + booking.getVenue_ID());
            System.out.println("Total Aduldts: " + booking.getTotal_Adults());
            System.out.println("Total Kids: " + booking.getTotal_Kids());
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("0. Back");
            Scanner employeScanner = new Scanner(System.in);
            int bookingChoice = employeScanner.nextInt();
            if (bookingChoice != 0) {
                System.out.println("Please select a valid menu option.");
            } else {
                loggedout = true;
            }
        }

    }

    public void ViewNonConfirmedBooking(Booking booking) {
        boolean loggedout = false;
        while (!loggedout) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                   Booking ID:" + booking.getBookingID() + "                  ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("Booking ID: " + booking.getBookingID());
            System.out.println("Customer ID: " + booking.getCustomerID());
            System.out.println("Customer Name: " + booking.getCustomer_Name());
            System.out.println("Date Created: " + booking.getDateCreated());
            System.out.println("Booking Status: " + booking.getBooking_Status());
            System.out.println("Event ID: " + booking.getEvent_ID());
            System.out.println("Event Date: " + booking.getEvent_Date());
            System.out.println("Event Time: " + booking.getEvent_Time());
            System.out.println("Venue ID: " + booking.getVenue_ID());
            System.out.println("Total Aduldts: " + booking.getTotal_Adults());
            System.out.println("Total Kids: " + booking.getTotal_Kids());
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("0. Back");
            System.out.println("1. Confirm this booking");
            Scanner employeScanner = new Scanner(System.in);
            int bookingChoice = employeScanner.nextInt();
            if (bookingChoice == 1) {
                ConfirmBooking(booking);
                loggedout = true;

            } else if (bookingChoice == 0) {
                loggedout = true;
            } else {
                System.out.println("Please select valid menu option.");
            }
        }

    }

    public void ConfirmBooking(Booking booking) {
        Booking confirmedBooking = booking;
        confirmedBooking.setBooking_Status("Confirmed");
        try {
            bookingDH.UpdateBooking(booking, confirmedBooking);
            System.out.println("Booking confirmed.");
        } catch (Exception e) {
            System.out.println("Booking could not be confirmed");
        }

    }

    public void ViewNonConfirmedBookings() {
        boolean loggedout = false;
        while (!loggedout) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                  Current Non-Confirmed Bookings:                  ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%6s\t%20s\t%10s\t%10s\t%20s\t%20s\n", "Select", "Customer Name", "Date", "Time", "Venue",
                    "# of attendees");

            int indexCounter = 1;
            VenueDH venueDH = new VenueDH();
            List<Booking> menuBookings = new ArrayList<Booking>();
            for (Booking booking : GetNonConfirmedBookings()) {
                if (GetPaidBookings().contains(booking)) {
                    booking.setMenuIndexer(indexCounter);
                    System.out.printf("%6s\t%20s\t%10s\t%10s\t%20s\t%20s\n", Integer.toString(indexCounter),
                            booking.getCustomer_Name(), booking.getEvent_Date(), booking.getEvent_Time(),
                            venueDH.ReadVenue(booking.getVenue_ID()).getVenue_Name(),
                            Integer.toString(booking.getTotal_Adults() + booking.getTotal_Kids()));
                    menuBookings.add(booking);
                    indexCounter++;
                }

            }
            System.out.println("Select a booking:");
            Scanner employeScanner = new Scanner(System.in);
            int bookingChoice = employeScanner.nextInt();
            if (bookingChoice != 0) {
                for (Booking booking : menuBookings) {
                    if (booking.getMenuIndexer() == bookingChoice) {
                        ViewNonConfirmedBooking(booking);
                    }
                }
            } else {
                loggedout = true;
            }

        }

    }

}
