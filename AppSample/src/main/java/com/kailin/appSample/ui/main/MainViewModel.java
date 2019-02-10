package com.kailin.appSample.ui.main;

import com.kailin.appSample.MyApplication;
import com.kailin.appSample.connect.RetrofitManager;
import com.kailin.appSample.data.bus.BusVersion;
import com.kailin.appSample.data.bus.BusVersionDatabase;
import com.kailin.appSample.data.bus.BusVersionService;
import com.kailin.architecture_model.architecture.ArchitectureViewModel;

public final class MainViewModel extends ArchitectureViewModel {

    private RetrofitManager retrofitManager;
    private BusVersionDatabase busVersionDatabase;

    @Override
    public void onCreate() {
        retrofitManager = RetrofitManager.getInstance();
        busVersionDatabase = BusVersionDatabase.getInstance(MyApplication.getInstance());
    }

    @Override
    public void onDestroy() {
        busVersionDatabase.close();
    }

    public void getBusVersion() {
        BusVersionService busVersionService = retrofitManager.create(BusVersionService.class);
        busVersionService.getBusVersion("Taipei")
                .subscribe(this::busVersionConsumer);
    }

    private void busVersionConsumer(BusVersion busVersion) {
        busVersionDatabase.busVersionDao().insert(busVersion);
    }
}
