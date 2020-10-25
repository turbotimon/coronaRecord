package ch.ost.mge.testat.coronarecord.services;

import android.util.Log;

import java.util.List;

import ch.ost.mge.testat.coronarecord.model.LocationItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpService {

    final static String URL = "https://coronarecord.herokuapp.com/";

    public static void getLocations() {

        Log.v("coronaRecord", "httpService: getLocations() started..");

        // Retrofit init
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Services erstellen
        LocationGET service = retrofit.create(LocationGET.class); //TODO locitem -> location
        // TODO POST-Service

        // Service starten. Es kommt ein Call-Element zurück (eine Art "Promise")
        Call<List<LocationItem>> call = service.getItems();


        // Callbacks für den Call: onResponse=Success und onFailure=Error
        call.enqueue(new Callback<List<LocationItem>>() {
            @Override
            public void onResponse(Call<List<LocationItem>> call, retrofit2.Response<List<LocationItem>> response) {
                Log.v("coronaRecord", "httpService: Received TODO-items: " + response.body().size());
            }

            @Override
            public void onFailure(Call<List<LocationItem>> call, Throwable t) {
                //setOutputText("Could not read data: " + t.getMessage());            }
                Log.v("coronaRecord", "httpService: ERROR Could not read data: " + t.getMessage());
            }
        });

    } //

} // class
