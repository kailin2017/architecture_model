package com.kailin.appSample.data.bus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kailin.appSample.util.GsonUtil;

import java.lang.reflect.Type;

import androidx.room.TypeConverter;

public interface BusCityConverters {

    @TypeConverter
    static BusCity toRouteOperator(String value) {
        Type type = new TypeToken<BusCity>() {
        }.getType();
        Gson gson = GsonUtil.getInstance().getGson();
        return gson.fromJson(value, type);
    }

    @TypeConverter
    static String toString(BusCity value) {
        return value.name();
    }
}
