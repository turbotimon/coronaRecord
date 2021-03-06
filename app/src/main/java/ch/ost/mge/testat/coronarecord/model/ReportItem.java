package ch.ost.mge.testat.coronarecord.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ReportItem {

    @SerializedName("id")
    public Integer id;
    @SerializedName("    public Location location;\n")
    public Location location;
    @SerializedName("arrived")
    public Date arrived;
    @SerializedName("departed")
    public Date departed;
    @SerializedName("personlist")
    public String personList;

    public ReportItem(Integer id, Location location, Date arrived, Date departed, String personList) {
        this.id = id;
        this.location = location;
        this.arrived = arrived;
        this.departed = departed;
        this.personList = personList;
    }

}
