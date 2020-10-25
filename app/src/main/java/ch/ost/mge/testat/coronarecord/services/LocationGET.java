package ch.ost.mge.testat.coronarecord.services;

import java.util.List;
import ch.ost.mge.testat.coronarecord.model.LocationItem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationGET {
    @GET("/locations")
    Call<List<LocationItem>> getItems();
}
