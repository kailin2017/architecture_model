package com.kailin.appSample.data.bus.version;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BusVersionService {

    @GET("/MOTC/v2/Bus/DataVersion/City/{city}?$format=JSON")
    Observable<BusVersion> getBusVersion(@Path("city") String city);
}
