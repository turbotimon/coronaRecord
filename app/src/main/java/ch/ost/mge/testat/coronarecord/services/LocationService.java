package ch.ost.mge.testat.coronarecord.services;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;
import ch.ost.mge.testat.coronarecord.model.Location;

public class LocationService extends Application {

    private static HashMap<Integer, Location> locations;
    private static Boolean loaded = false; //TODO remove?
    private static String filename = "locations";
    private static LocationService locationService = new LocationService();

    public static void loadFromLocalStorage(){
        HashMap<Integer, Location> tmp;
        tmp = (HashMap<Integer, Location>) SaveObjectService.load(locationService, filename);
        if (tmp==null){
            loaded = false;
        } else {
            locations=tmp;
            loaded = true;
        }
    }

    public static void remoteUpdate(){
        // TODO oder weg lassen
    }

    public static void saveToLocalStorage(){
        SaveObjectService.save(locationService, filename, locations);
    }

    public static void clear(){
        locations.clear();
    }

    public static Location getByCode(int code){
        return locations.get(code);
    }

    public static boolean isExisting(int code){
        return locations.containsKey(code);
    }

    //TODO This is just for Demo
    public static void fillWithDemo(){
        Location t0 = new Location(0, 123456, "Local Host");
        Location t1 = new Location(1, 111111, "Whish you where beer");
        Location t2 = new Location(2, 222222, "Stammtisch im Hirsche");
        Location t3 = new Location(3, 333333, "Studio 54");
        locations.put(t0.getCode(), t0);
        locations.put(t1.getCode(), t1);
        locations.put(t2.getCode(), t2);
        locations.put(t3.getCode(), t3);
    }



}
