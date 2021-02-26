public class Venue {
    private int Venue_ID;
    private String Venue_Name;
    private String Venue_Phone_Number;
    private String Venue_Email;
    private String Venue_Address;

    public Venue(int Vvenue_ID, String Vvenue_Name, String Vvenue_Phone_Number, String Vvenue_Email, String Vvenue_Address) {
        Venue_ID = Vvenue_ID;
        Venue_Name = Vvenue_Name;
        Venue_Phone_Number = Vvenue_Phone_Number;
        Venue_Email = Vvenue_Email;
        Venue_Address = Vvenue_Address;
    }

    @Override
    public String toString() {
        return "Venue [Venue_Address=" + Venue_Address + ", Venue_Email=" + Venue_Email + ", Venue_ID=" + Venue_ID
                + ", Venue_Name=" + Venue_Name + ", Venue_Phone_Number=" + Venue_Phone_Number + "]";
    }

    



}
