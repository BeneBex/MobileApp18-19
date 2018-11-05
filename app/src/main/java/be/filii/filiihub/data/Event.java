package be.filii.filiihub.data;

import android.media.Image;

import java.util.Date;

public class Event {
    private Date date;
    private String name;
    private String description;
    private String place;
    private Image image;

    public Event(){

    }

    public Event(Date date, String name, String description, String place){
        this.date = date;
        this.name= name;
        this.description = description;
        this.place = place;
        //this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPlace() {
        return place;
    }

    public Image getImage() {
        return image;
    }
}
