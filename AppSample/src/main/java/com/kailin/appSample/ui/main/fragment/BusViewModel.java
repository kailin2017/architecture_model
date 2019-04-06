package com.kailin.appSample.ui.main.fragment;

import com.kailin.appSample.MyApplication;
import com.kailin.appSample.data.bus.BusDatabase;
import com.kailin.appSample.data.bus.route.BusRoute;
import com.kailin.appSample.data.bus.route.BusRouteDao;
import com.kailin.architecture_model.architecture.ArchitectureViewModel;

import java.util.List;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public final class BusViewModel extends ArchitectureViewModel {

    private final BusRouteDao busRouteDao = BusDatabase.getInstance(MyApplication.getInstance()).busRouteDao();
    private final MutableLiveData<List<BusRoute>> busRoutesLiveData = new MutableLiveData<>();

    public void busRoutesObserver(LifecycleOwner owner, Observer<List<BusRoute>> observer) {
        busRoutesLiveData.observe(owner, observer);
    }

    public void queryBus(String routeName) {
        rxOptimization(busRouteDao.getBusRoutes(routeName), this::queryBusOnNext);
    }

    private void queryBusOnNext(List<BusRoute> busRoutes) {
        busRoutesLiveData.postValue(busRoutes);
    }
}
