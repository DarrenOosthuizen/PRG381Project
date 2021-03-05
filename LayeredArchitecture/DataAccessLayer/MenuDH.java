package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Menu;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuDH {
    private static DataAccessLayer DAL = new DataAccessLayer();

    public void CreateMenu(Menu menu) {
        String InsertCusQuery = ("INSERT INTO tblMenu (Menu_ID, Menu_Name) VALUES ('" + menu.getMenu_ID() + "','"
                + menu.getMenu_Name() + "')");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(InsertCusQuery);) {
            prepsInsertProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Menu> ReadAllMenu() {
        List<Menu> MenuList = new ArrayList<Menu>();
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            String selectSql = "SELECT * from tblMenu";
            resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                MenuList.add(new Menu(resultSet.getInt(0), resultSet.getString(1)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return MenuList;
    }

    public Menu ReadMenu(int Menu_ID) {
        Menu menu = new Menu();
        // Code to read specific record from table and load into object Customer

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = ("SELECT * from tblMenu WHERE Menu_ID = '" + Menu_ID + "'");
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                menu.setMenu_ID(resultSet.getInt(0));
                menu.setMenu_Name(resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menu;
        // return Customer object
    }

    public void UpdateMenu(Menu oldMenu, Menu newMenu) {
        String UPDATECusQuery = ("UPDATE  tblMenu SET Menu_Name = '" + newMenu.getMenu_Name() + "' WHERE Menu_ID = '"
                + oldMenu.getMenu_ID() + "'");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsUpdateProduct = connection.prepareStatement(UPDATECusQuery);) {
            prepsUpdateProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteMenu(int Menu_ID) {
        String DeleteCusQuery = ("DELETE FROM tblMenu WHERE Menu_ID = '" + Menu_ID + "'");

        try (Connection connection = DriverManager.getConnection(DAL.DBConnection);
                PreparedStatement prepsDeleteProduct = connection.prepareStatement(DeleteCusQuery);) {
            prepsDeleteProduct.execute();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
