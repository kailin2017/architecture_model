package com.kailin.appSample.data.bus.route;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kailin.appSample.util.GsonUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;

import androidx.room.TypeConverter;

public interface BusSubRouteConverters {

    @TypeConverter
    static ArrayList<BusSubRoute> toBusSubRoutes(String value) {
        Type type = new TypeToken<ArrayList<BusSubRoute>>() {
        }.getType();
        Gson gson = GsonUtil.getInstance().getGson();
        return gson.fromJson(value, type);
    }

    @TypeConverter
    static String toString(ArrayList<BusSubRoute> value) {
        Gson gson = GsonUtil.getInstance().getGson();
        return gson.toJson(value);
    }
}
