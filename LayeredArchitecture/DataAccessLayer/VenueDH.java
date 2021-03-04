//Venue Data Handler
package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Venue;

import java.util.List;
import java.util.ArrayList;

public class VenueDH {
    public void CreateVenue() {
        // Code to write to Venue tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<Venue> ReadAllVenues() {
        List<Venue> VenueList = new ArrayList<Venue>();
        // Code to read all records from Venue and load into list.
        return VenueList;
        // Return list of records
    }

    public Venue ReadVenue(int Venue_ID) {
        Venue venue = new Venue();
        // Code to read specific record from table and load into object venue
        return venue;
        // return venue object
    }

    public void UpdateVenue(Venue oldVenue, Venue newVenue) {
        // Code to update old Venue record to new Venue Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteVenue(Venue VenueObj) {
        // Code to delete specific Venue from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
}