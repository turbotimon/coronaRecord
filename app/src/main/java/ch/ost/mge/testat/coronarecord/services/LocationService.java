package ch.ost.mge.testat.coronarecord.services;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;
import ch.ost.mge.testat.coronarecord.model.Location;

public class LocationService {

    private static HashMap<Integer, Location> locations;
    private static Boolean loaded = false;

    public static void load(){
        //TODO
        fillWithDemo();
        loaded=true;
    }

    public static Location getByCode(int code){
        checkLoaded();
        return locations.get(code);
    }

    public static boolean containsCode(int code){
        checkLoaded();
        return locations.containsKey(code);
    }

    //TODO This is just for Demo
    private static void fillWithDemo(){
        locations = new HashMap<>();
        Location t0 = new Location(0, 123456, "Local Host");
        Location t1 = new Location(1, 111111, "Whish you where beer");
        Location t2 = new Location(2, 222222, "Stammtisch im Hirsche");
        Location t3 = new Location(3, 333333, "Studio 54");
        locations.put(t0.getCode(), t0);
        locations.put(t1.getCode(), t1);
        locations.put(t2.getCode(), t2);
        locations.put(t3.getCode(), t3);
    }

    private static void checkLoaded(){
        if (!loaded) throw new RuntimeException("LocationService was not loaded");
    }



}
