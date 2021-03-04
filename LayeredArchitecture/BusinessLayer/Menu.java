package LayeredArchitecture.BusinessLayer;

public class Menu 
{
    private int Menu_ID;
    private String Menu_Name;

    public Menu(int Mmenu_ID, String Mmenu_Name) {
        Menu_ID = Mmenu_ID;
        Menu_Name = Mmenu_Name;
    }
    public Menu()
    {
        
    }

    public int getMenu_ID() {
        return Menu_ID;
    }

    public void setMenu_ID(int menu_ID) {
        Menu_ID = menu_ID;
    }

    public String getMenu_Name() {
        return Menu_Name;
    }

    public void setMenu_Name(String menu_Name) {
        Menu_Name = menu_Name;
    }

    @Override
    public String toString() {
        return "Menu [Menu_ID=" + Menu_ID + ", Menu_Name=" + Menu_Name + "]";
    }

    
    
}
