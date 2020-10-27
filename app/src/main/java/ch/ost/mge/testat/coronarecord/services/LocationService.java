package ch.ost.mge.testat.coronarecord.services;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import ch.ost.mge.testat.coronarecord.model.Location;
import ch.ost.mge.testat.coronarecord.model.LocationItem;
import ch.ost.mge.testat.coronarecord.model.LocationList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationService {

    private static HashMap<Integer, Location> locations;
    private static Boolean loaded = false;

    final static String URL = "https://coronarecord.herokuapp.com/";

    public static void load() {

        Log.v("coronaRecord", "LocationService: getLocations() started..");

        // Retrofit init
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Services erstellen
        LocationGET service = retrofit.create(LocationGET.class);

        // Service starten. Es kommt ein Call-Element zurück (eine Art "Promise")
        Call<LocationList> call = service.getItems();


        // Callbacks für den Call: onResponse=Success und onFailure=Error
        call.enqueue(new Callback<LocationList>() {
            @Override
            public void onResponse(Call<LocationList> call, retrofit2.Response<LocationList> response) {
                Log.v("coronaRecord", "LocationService: Received TODO-items: " + response.body().locations.size());
                locations = new HashMap<>();
                for (LocationItem l : response.body().locations){
                    locations.put(l.code, new Location(l.id, l.code, l.name));
                }
                loaded=true;
            }

            @Override
            public void onFailure(Call<LocationList> call, Throwable t) {
                //setOutputText("Could not read data: " + t.getMessage());            }
                Log.v("coronaRecord", "LocationService: ERROR Could not read data: " + t.getMessage());
                fillWithDemo();
                loaded=true;
            }
        });

    }

    public static Location getByCode(int code){
        checkLoaded();
        return locations.get(code);
    }

    public static boolean containsCode(int code){
        checkLoaded();
        return locations.containsKey(code);
    }

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
