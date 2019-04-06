package com.kailin.appSample.data.bus;

import com.kailin.appSample.connect.RetrofitManager;
import com.kailin.appSample.data.bus.version.BusVersionService;
import com.kailin.architecture_model.util.LoggerUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

@RunWith(RobolectricTestRunner.class)
@Config
public class BusVersionServiceTest {

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;
        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Test
    public void getBusVersion() {
        BusVersionService busVersionService = RetrofitManager.getInstance().create(BusVersionService.class);
        busVersionService.getBusVersion("Taipei")
                .subscribe(busVersion -> LoggerUtil.getInstance().d(busVersion), throwable -> throwable.printStackTrace());
    }
}