package LayeredArchitecture.BusinessLayer;

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
//methods

public int getVenue_ID() {
    return Venue_ID;
}

public void setVenue_ID(int venue_ID) {
    Venue_ID = venue_ID;
}

public String getVenue_Name() {
    return Venue_Name;
}

public void setVenue_Name(String venue_Name) {
    Venue_Name = venue_Name;
}

public String getVenue_Phone_Number() {
    return Venue_Phone_Number;
}

public void setVenue_Phone_Number(String venue_Phone_Number) {
    Venue_Phone_Number = venue_Phone_Number;
}

public String getVenue_Email() {
    return Venue_Email;
}

public void setVenue_Email(String venue_Email) {
    Venue_Email = venue_Email;
}

public String getVenue_Address() {
    return Venue_Address;
}

public void setVenue_Address(String venue_Address) {
    Venue_Address = venue_Address;
}

    


}
