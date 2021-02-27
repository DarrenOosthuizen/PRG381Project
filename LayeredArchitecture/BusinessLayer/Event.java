package LayeredArchitecture.BusinessLayer;

public class Event 
{
    private int Event_ID;
    private String Event_Name;

    @Override
    public String toString() {
        return "Event [Event_ID=" + Event_ID + ", Event_Name=" + Event_Name + "]";
    }

    public Event(int Eevent_ID, String Eevent_Name) {
        Event_ID = Eevent_ID;
        Event_Name = Eevent_Name;
    }

    public int getEvent_ID() {
        return Event_ID;
    }

    public void setEvent_ID(int event_ID) {
        Event_ID = event_ID;
    }

    public String getEvent_Name() {
        return Event_Name;
    }

    public void setEvent_Name(String event_Name) {
        Event_Name = event_Name;
    }
    
}
