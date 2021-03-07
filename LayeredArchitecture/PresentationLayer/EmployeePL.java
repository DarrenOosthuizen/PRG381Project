package LayeredArchitecture.PresentationLayer;

import java.util.List;
import java.util.Scanner;

import LayeredArchitecture.DataAccessLayer.EmployeeDH;
import LayeredArchitecture.DataAccessLayer.EmployeeUserDH;
import LayeredArchitecture.DataAccessLayer.UserDH;
import LayeredArchitecture.BusinessLayer.User;
import LayeredArchitecture.BusinessLayer.Employee;
import LayeredArchitecture.BusinessLayer.EmployeeUser;

public class EmployeePL {
    private static UserDH userDH = new UserDH();
    private static EmployeeUserDH employeeUserDH = new EmployeeUserDH();
    private static Employee employeeOBJ = new Employee();
    private static EmployeeDH employeeDH = new EmployeeDH();

    private static int UserID;
    boolean EmployeeFound = false;

    public void EmployeeSignIn() {
        EmployeeFound = false;
        while (!EmployeeFound) {
            try {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("Please Enter Employee User Name :");
                Scanner employeeScanner = new Scanner(System.in);
                String employeeUsername = employeeScanner.nextLine();
                System.out.printf("Please Enter Password for User %s:", employeeUsername);
                System.out.println("");
                String employeePassword = employeeScanner.nextLine();
                List<User> usersList = userDH.ReadAllUsers();
                for (User user : usersList) {
                    if (employeeUsername.matches(user.getUser_Name())
                            && employeePassword.matches(user.getUser_Password())) {
                        UserID = user.getUser_ID();
                        EmployeeFound = true;
                    }

                }
                if (EmployeeFound == true) {
                    System.out.println("Logged in Successfuly");

                    EmployeeUser employeeUserOBJ = employeeUserDH.ReadEmployeeUser(UserID);

                    employeeOBJ = employeeDH.ReadEmployee(employeeUserOBJ.getEmployee_ID());
                    EmployeeMenu();

                } else {
                    System.out.println("Failed. Please try again");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void EmployeeMenu() {
        boolean loggedout = false;
        while (!loggedout) {
            System.out.print("\033[H\033[2J"); // !033[H moves Cursor to top left corner or console. 033[2J Clears
            System.out.flush(); // !Clear System

            System.out.println("Employee Menu");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                           Welcome to Employee Portal                           ");
            System.out.println(employeeOBJ.getEmployee_Name() + " " + employeeOBJ.getEmployee_Surname());
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("                  Please Select Option from the menu below:                  ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("1 : View confirmed bookings");
            System.out.println("2 : Confirm bookings");
            System.out.println("3 : Accept bookings and set price");
            System.out.println("0 : Exit Application");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Please select a valid menu option above");

            boolean CorrectMenuOption = false;
            while (!CorrectMenuOption) {
                Scanner employeScanner = new Scanner(System.in);
                int employeeChoice = employeScanner.nextInt();
                if (employeeChoice == 1) {
                    EmployeeBookingPL employeeBookingPL = new EmployeeBookingPL();
                    employeeBookingPL.ViewConfirmedBookings();
                    CorrectMenuOption = true;
                } else if (employeeChoice == 2) {
                    EmployeeBookingPL employeeBookingPL = new EmployeeBookingPL();
                    employeeBookingPL.ViewNonConfirmedBookings();
                    CorrectMenuOption = true;

                } else if (employeeChoice == 3) {
                    EmployeeBookingPL employeeBookingPL = new EmployeeBookingPL();
                    employeeBookingPL.ViewUnpaidBookings();
                    // CorrectMenuOption = true;

                } else if (employeeChoice == 0) {
                    System.out.println("You will be logged out");
                    System.out.println("Press any key to continue");
                    CorrectMenuOption = true;
                    loggedout = true;

                    break;
                } else {
                    System.out.println("Invalid menu option choosen! Please try again");
                    CorrectMenuOption = false;
                }

            }

        }

    }

}
