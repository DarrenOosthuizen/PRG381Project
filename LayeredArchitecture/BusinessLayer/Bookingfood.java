package LayeredArchitecture.BusinessLayer;

public class Bookingfood{
    private int Booking_ID;
    private int Adults_Meal;
    private int Kids_Meal;
    private int Drinks;
    private int Dessert;
    private int Decorations;
    private String Additional_Decorations;

    public BookingFood(int BFbooking_ID, int BFadults_Meal, int BFkids_Meal, int BFdrinks, int BFdessert, int BFdecorations,
            String BFadditional_Decorations) {
        Booking_ID = BFbooking_ID;
        Adults_Meal = BFadults_Meal;
        Kids_Meal = BFkids_Meal;
        Drinks = BFdrinks;
        Dessert = BFdessert;
        Decorations = BFdecorations;
        Additional_Decorations = BFadditional_Decorations;
    }
    public BookingFood()
    {
        
    }

    @Override
    public String toString() {
        return "Bookingfood [Additional_Decorations=" + Additional_Decorations + ", Adults_Meal=" + Adults_Meal
                + ", Booking_ID=" + Booking_ID + ", Decorations=" + Decorations + ", Dessert=" + Dessert + ", Drinks="
                + Drinks + ", Kids_Meal=" + Kids_Meal + "]";
    }

    public int getBooking_ID() {
        return Booking_ID;
    }

    public void setBooking_ID(int booking_ID) {
        Booking_ID = booking_ID;
    }

    public int getAdults_Meal() {
        return Adults_Meal;
    }

    public void setAdults_Meal(int adults_Meal) {
        Adults_Meal = adults_Meal;
    }

    public int getKids_Meal() {
        return Kids_Meal;
    }

    public void setKids_Meal(int kids_Meal) {
        Kids_Meal = kids_Meal;
    }

    public int getDrinks() {
        return Drinks;
    }

    public void setDrinks(int drinks) {
        Drinks = drinks;
    }

    public int getDessert() {
        return Dessert;
    }

    public void setDessert(int dessert) {
        Dessert = dessert;
    }

    public int getDecorations() {
        return Decorations;
    }

    public void setDecorations(int decorations) {
        Decorations = decorations;
    }

    public String getAdditional_Decorations() {
        return Additional_Decorations;
    }

    public void setAdditional_Decorations(String additional_Decorations) {
        Additional_Decorations = additional_Decorations;
    }
}
