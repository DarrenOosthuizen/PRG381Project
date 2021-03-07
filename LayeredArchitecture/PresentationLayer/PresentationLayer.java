package LayeredArchitecture.PresentationLayer;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PresentationLayer {
    // !Enum that will be used when client is asked to login as Employee or Client
    enum LoginChoice

    {
        Client(1), Employee(2);

        private int numericValue;
        private static final Map<Integer, LoginChoice> intToEnum = new HashMap<Integer, LoginChoice>();
        static {
            for (LoginChoice type : values()) {
                intToEnum.put(type.getNumericValue(), type);
            }
        }

        private LoginChoice(int numericValue) {
            this.numericValue = numericValue;
        }

        public int getNumericValue() {
            return this.numericValue;
        }

        public static LoginChoice fromInteger(int numericValue) {
            return intToEnum.get(numericValue);
        }

    }

    public static boolean clientLogin = false;
    public static boolean employeeLogin = false;
    public static ClientPL ClientCurrent = new ClientPL();
    public static EmployeePL employeeCurrent = new EmployeePL();

    public static void main(String[] args) {

        while (true) {
            try {
                // !First we will want to clear the console.
                System.out.print("\033[H\033[2J"); // !033[H moves Cursor to top left corner or console. 033[2J Clears
                                                   // console from first part to end of screen
                System.out.flush(); // !Clear System

                // !Menu Layout for Welcoming User
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                        Welcome to Delicious Catering                        ");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                  Please Select Option from the menu below:                  ");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("1 : Login in as Client");
                System.out.println("2 : Login in as Employee");
                System.out.println("-----------------------------------------------------------------------------");

                // !Creating scanner to read user input
                Scanner RdLoginChoice = new Scanner(System.in);
                String strLoginChoice = RdLoginChoice.nextLine();

                // !Checking if user has entered valid option else reset
                if (strLoginChoice.matches("1") || strLoginChoice.matches("2")) {

                    // !Convert string to int to be used in enum
                    int intLoginChoice = Integer.parseInt(strLoginChoice);
                    LoginChoice myLogin = LoginChoice.fromInteger(intLoginChoice);

                    switch (myLogin) {
                        case Client: // !Will now run ClientLogin.java file
                        {

                            System.out.println("You have choosen to login as Client");
                            ClientCurrent.ClientSignIn();
                            break;
                        }
                        case Employee: // !Will now run EmployeeLogin.java file
                        {
                            System.out.println("You have choosen to login as Employee");
                            employeeCurrent.EmployeeSignIn();
                            break;
                        }

                        default: // !Default Option
                        {
                            System.out.println("Invalid Input please try again Defualt");
                            System.out.println("Please press Any Key to reset Console!");
                            break;
                        }
                    }
                } else // !If user entered invalid option will notify them1
                {
                    System.out.println("Invalid Input please try again");
                    System.out.println("Please press Any Key to reset Console!");
                }

                // !Wait for keypress to reset the while and start from the begining
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                br.readLine();
            } catch (Exception e) {

            }
        }

    }

}
