package com.kailin.appSample.data.bus.route;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BusRouteService {

    @GET("/MOTC/v2/Bus/Route/City/{city}?$format=JSON")
    Observable<ArrayList<BusRoute>> getBusRoute(@Path("city") String city);
}
