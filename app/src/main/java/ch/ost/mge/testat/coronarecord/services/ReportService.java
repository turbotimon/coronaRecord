// https://www.journaldev.com/13639/retrofit-android-example-tutorial

package ch.ost.mge.testat.coronarecord.services;

import android.util.Log;

import ch.ost.mge.testat.coronarecord.model.Report;
import ch.ost.mge.testat.coronarecord.model.ReportItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReportService {
    final static String URL = "https://coronarecord.herokuapp.com/";

    public static void send(Report report) {

        Log.v("coronaRecord", "httpService: sendRecord() started..");

        // Report erstellen
        ReportItem reportItem = new ReportItem(report.getId(), report.getLocation(), report.getArrived(), report.getDeparted());

        // Retrofit init
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Services erstellen
        ReportPOST service = retrofit.create(ReportPOST.class);

        Call<ReportItem> call = service.post(reportItem);

        call.enqueue(new Callback<ReportItem>() {
            @Override
            public void onResponse(Call<ReportItem> call, retrofit2.Response<ReportItem> response) {

                if(response.isSuccessful()) {
                    //showResponse(response.body().toString());
                    //Log.i(TAG, "post submitted to API." + response.body().toString());
                    Log.v("coronaRecord", "httpService: Send Record Successful");
                }
            }

            // Es kommt immer ein Fehlerm, da die Response vom Server nicht ganz korrekt ist.
            // https://stackoverflow.com/questions/39918814/use-jsonreader-setlenienttrue-to-accept-malformed-json-at-line-1-column-1-path

            @Override
            public void onFailure(Call<ReportItem> call, Throwable t) {
                Log.v("coronaRecord", "httpService: ERROR Could not send data: " + t.getMessage());
            }
        });
    }
}
