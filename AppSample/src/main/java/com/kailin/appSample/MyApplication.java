package com.kailin.appSample;

import android.app.Application;

public final class MyApplication extends Application {

    private static volatile MyApplication application;

    public static MyApplication getInstance(){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
