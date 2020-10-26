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
