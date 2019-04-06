package com.kailin.appSample.ui.main;

import com.kailin.appSample.MyApplication;
import com.kailin.appSample.base.BaseViewModel;
import com.kailin.appSample.connect.RetrofitManager;
import com.kailin.appSample.connect.RetrofitService;
import com.kailin.appSample.data.bus.BusCity;
import com.kailin.appSample.data.bus.BusDatabase;
import com.kailin.appSample.data.bus.route.BusRoute;
import com.kailin.appSample.data.bus.route.BusRouteService;
import com.kailin.appSample.data.bus.version.BusVersion;
import com.kailin.appSample.data.bus.version.BusVersionService;
import com.kailin.architecture_model.util.LoggerUtil;

import java.util.ArrayList;

import io.reactivex.Observable;

public final class MainViewModel extends BaseViewModel {

    private final LoggerUtil loggerUtil = LoggerUtil.getInstance();
    private final RetrofitManager retrofitManager = RetrofitManager.getInstance(RetrofitService.PTX_L1);
    private final BusVersionService busVersionService = retrofitManager.create(BusVersionService.class);
    private final BusRouteService busRouteService = retrofitManager.create(BusRouteService.class);
    private BusDatabase busDatabase;

    @Override
    public void onCreate() {
        busDatabase = BusDatabase.getInstance(MyApplication.getInstance());
    }

    @Override
    public void onDestroy() {
        busDatabase.close();
    }

    public void getBusVersion() {
        Observable<ArrayList<BusRoute>> flowable = Observable.fromArray(BusCity.values())
                .flatMap(this::CityFlatMap)
                .filter(this::busVersionFilter)
                .flatMap(this::busRouteFlatMap);

        rxOptimization(flowable, this::busRouteOnNext);
    }

    private Observable<String> CityFlatMap(BusCity busCity) {
        String busCityName = busCity.name();
        return Observable.zip(
                busVersionService.getBusVersion(busCityName),
                Observable.just(busCityName),
                this::busVersionBiFunction);
    }

    private String busVersionBiFunction(BusVersion busVersion, String city) {
        boolean isUpdateBusRoute = false;
        busVersion.setBusCity(city);

        BusVersion busVersionLocal = busDatabase.busVersionDao().getBusVersion(city);
        if (busVersionLocal == null) {
            // 無local版本紀錄
            isUpdateBusRoute = true;
        } else if (busVersionLocal.compareTo(busVersion) == -1) {
            // local資料較舊
            isUpdateBusRoute = true;
        } else if (busDatabase.busRouteDao().getBusRouteCount() < 1) {
            // local無路線資料
            isUpdateBusRoute = true;
        } else if (busDatabase.busRouteDao().getOldBusRoute(busVersion.getVersionID()) > 0) {
            // local有舊版本資料
            isUpdateBusRoute = true;
        }

        return isUpdateBusRoute ? city : "";
    }

    private boolean busVersionFilter(String city) {
        return !city.isEmpty();
    }

    private Observable<ArrayList<BusRoute>> busRouteFlatMap(String city) {
        return busRouteService.getBusRoute(city);
    }

    private void busRouteOnNext(ArrayList<BusRoute> busRoutes) {
        busDatabase.busRouteDao().insert(busRoutes);
        busDatabase.busRouteDao().getBusRoutes();
    }
}
