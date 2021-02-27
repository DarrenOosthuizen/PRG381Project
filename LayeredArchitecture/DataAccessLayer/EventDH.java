package LayeredArchitecture.DataAccessLayer;

import LayeredArchitecture.BusinessLayer.Event;
import java.util.List;
import java.util.ArrayList;

public class EventDH {
    public void CreateEvent() {
        // Code to write to Event tabel
        // Would be better to change the method to return true on succesfull create at a
        // later stage
    }

    public List<Event> ReadAllEvent() {
        List<Event> EventList = new ArrayList<Event>();
        // Code to read all records from Event and load into list.
        return EventList;
        // Return list of records
    }

    public Event ReadEvent(int Event_ID) {
        Event Event_read = new Event();
        // Code to read specific record from table and load into object Event_read
        return Event_read;
        // return Event object
    }

    public void UpdateEvent(Event oldEvent, Event newEvent) {
        // Code to update old Event record to new Event Record
        // Would be better to change the method to return true on succesfull update at a
        // later stage
    }

    public void DeleteEvent(Event EventObj) {
        // Code to delete specific Event from table
        // Would be better to change the method to return true on succesfull delete at a
        // later stage
    }
    
}
