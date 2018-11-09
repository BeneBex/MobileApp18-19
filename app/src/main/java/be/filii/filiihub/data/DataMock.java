package be.filii.filiihub.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class DataMock {

    static public List<Event> mockEvents(){
         List<Event> events = new ArrayList<Event>();

        Event event = new Event(new Date(2018,12,20), "Blue Thrill Td", "een toffe TD", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2018,11,27), "Boardgame Night", "spelletjes avond met Cegeka", "Cegeka Hasselt");
        events.add(event);
        event = new Event(new Date(2018,12,31), "New Year", "Samen het nieuwe jaar instappen!", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2019,2,14), "Valentijn", "We gaan samen chocolade desserts maken!", "Bakkery Hasselt");
        events.add(event);
        event = new Event(new Date(2019,1,20), "LAN Party", "In een grote zaal samen game", "PXL");
        events.add(event);

        return events;

    }

}
