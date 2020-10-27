package ch.ost.mge.testat.coronarecord.services;
import ch.ost.mge.testat.coronarecord.model.ReportItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
//import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ReportPOST {
    @POST("/record")
    public Call<ReportItem> post(@Body ReportItem post);
}
