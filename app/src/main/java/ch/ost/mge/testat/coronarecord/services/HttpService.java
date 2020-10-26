package ch.ost.mge.testat.coronarecord.services;

import android.util.Log;

import java.util.List;

import ch.ost.mge.testat.coronarecord.model.LocationItem;
import ch.ost.mge.testat.coronarecord.model.LocationList;
import ch.ost.mge.testat.coronarecord.model.ReportItem;
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

        // Service starten. Es kommt ein Call-Element zurück (eine Art "Promise")
        Call<LocationList> call = service.getItems();


        // Callbacks für den Call: onResponse=Success und onFailure=Error
        call.enqueue(new Callback<LocationList>() {
            @Override
            public void onResponse(Call<LocationList> call, retrofit2.Response<LocationList> response) {
                Log.v("coronaRecord", "httpService: Received TODO-items: " + response.body().locations.size());
            }

            @Override
            public void onFailure(Call<LocationList> call, Throwable t) {
                //setOutputText("Could not read data: " + t.getMessage());            }
                Log.v("coronaRecord", "httpService: ERROR Could not read data: " + t.getMessage());
            }
        });

    }

//    public void sendRecord2(ReportItem report) {
//        ReportPOST.savePost(body).enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//
//                if(response.isSuccessful()) {
//                    //showResponse(response.body().toString());
//                    //Log.i(TAG, "post submitted to API." + response.body().toString());
//                    Log.v("coronaRecord", "httpService: Send Record Successful");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                Log.v("coronaRecord", "httpService: ERROR Could not send data: " + t.getMessage());
//            }
//        });
//    }

    public static void sendRecord(ReportItem report) {

        Log.v("coronaRecord", "httpService: sendRecord() started..");

        // Retrofit init
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Services erstellen
        ReportPOST service = retrofit.create(ReportPOST.class);

        Call<ReportItem> call = service.post(report);

        call.enqueue(new Callback<ReportItem>() {
            @Override
            public void onResponse(Call<ReportItem> call, retrofit2.Response<ReportItem> response) {

                if(response.isSuccessful()) {
                    //showResponse(response.body().toString());
                    //Log.i(TAG, "post submitted to API." + response.body().toString());
                    Log.v("coronaRecord", "httpService: Send Record Successful");
                }
            }

            @Override
            public void onFailure(Call<ReportItem> call, Throwable t) {
                Log.v("coronaRecord", "httpService: ERROR Could not send data: " + t.getMessage());
            }
        });
    }

} // class
