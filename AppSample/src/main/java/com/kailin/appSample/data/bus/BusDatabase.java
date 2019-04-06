package com.kailin.appSample.data.bus;

import android.content.Context;

import com.kailin.appSample.data.bus.route.BusRoute;
import com.kailin.appSample.data.bus.route.BusRouteDao;
import com.kailin.appSample.data.bus.version.BusVersion;
import com.kailin.appSample.data.bus.version.BusVersionDao;

import java.util.concurrent.atomic.AtomicReference;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BusVersion.class, BusRoute.class}, version = 1, exportSchema = false)
public abstract class BusDatabase extends RoomDatabase {

    private static final AtomicReference<BusDatabase> reference = new AtomicReference<>();

    public static BusDatabase createInstance(Context context) {
        return Room.databaseBuilder(context, BusDatabase.class, "BusDatabase.db").build();
    }

    public static BusDatabase getInstance(Context context) {
        while (true) {
            BusDatabase instance = reference.get();
            if (instance != null)
                return instance;

            instance = createInstance(context);
            if (reference.compareAndSet(null, instance))
                return instance;
        }
    }

    public abstract BusRouteDao busRouteDao();

    public abstract BusVersionDao busVersionDao();

    // close後已無法使用,必須將reference同步清除
    @Override
    public void close() {
        super.close();
        reference.compareAndSet(this, null);
    }
}
