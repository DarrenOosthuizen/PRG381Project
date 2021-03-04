package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Menu;
import java.util.List;
import java.util.ArrayList;

public class MenuDH 
{
    
    public void CreateMenu() {
        // Code to write to BookingsFinance tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<Menu> ReadAllMenu() {
        List<Menu> MenuList = new ArrayList<Menu>();
        // Code to read all records from BookingsFinance and load into list.
        return MenuList;
        // Return list of records
    }

    public Menu ReadMenu(int Menu_ID) {
        Menu Menu_Read = new Menu();
        // Code to read specific record from table and load into object Menu_Read
        return Menu_Read;
        // return Menu object
    }

    public void UpdateMenu(Menu oldMenu, Menu newMenu) {
        // Code to update old Menu record to new Menu Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteMenu(Menu MenuObj) {
        // Code to delete specific Menu from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
    
}
