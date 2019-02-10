package com.kailin.appSample.data.bus;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BusVersionService {

    @GET("/MOTC/v2/Bus/DataVersion/City/{city}?$format=JSON")
    Flowable<BusVersion> getBusVersion(@Query("city") String city);
}
