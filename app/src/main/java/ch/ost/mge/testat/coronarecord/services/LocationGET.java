package ch.ost.mge.testat.coronarecord.services;

import java.util.List;
import ch.ost.mge.testat.coronarecord.model.LocationItem;
import ch.ost.mge.testat.coronarecord.model.LocationList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationGET {
    @GET("/locations")
    Call<LocationList> get();
}
