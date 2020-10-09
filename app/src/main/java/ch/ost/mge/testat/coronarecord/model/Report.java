package ch.ost.mge.testat.coronarecord.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Report {

    private Integer id;
    private Location location;
    private Date arrived = Calendar.getInstance().getTime();
    private Date departed;
    private ArrayList<Person> personArrayList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getArrived() {
        return arrived;
    }

    public void setArrived(Date arrived) {
        this.arrived = arrived;
    }

    public Date getDeparted() {
        return departed;
    }

    public void setDeparted(Date departed) {
        this.departed = departed;
    }
}
