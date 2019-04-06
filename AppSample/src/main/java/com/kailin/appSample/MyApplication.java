package com.kailin.appSample;

import android.app.Application;

import com.kailin.appSample.data.bus.BusDatabase;

public final class MyApplication extends Application {

    private static volatile MyApplication application;

    public static MyApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        BusDatabase.createInstance(this);
    }
}
