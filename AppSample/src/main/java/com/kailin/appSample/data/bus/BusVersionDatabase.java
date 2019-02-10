package com.kailin.appSample.data.bus;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BusVersion.class}, version = 1, exportSchema = false)
public abstract class BusVersionDatabase extends RoomDatabase {

    private static volatile BusVersionDatabase busVersionDatabase;

    public static BusVersionDatabase getInstance(Context context) {
        if (busVersionDatabase == null) {
            synchronized (BusVersionDatabase.class) {
                if (busVersionDatabase == null)
                    busVersionDatabase = Room.databaseBuilder(context, BusVersionDatabase.class, "BusVersionDatabase.db").build();
            }
        }
        return busVersionDatabase;
    }

    public abstract BusVersionDao busVersionDao();
}
