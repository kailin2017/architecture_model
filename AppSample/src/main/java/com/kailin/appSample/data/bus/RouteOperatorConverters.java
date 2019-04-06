package com.kailin.appSample.data.bus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kailin.appSample.util.GsonUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;

import androidx.room.TypeConverter;

public interface RouteOperatorConverters {

    @TypeConverter
    static ArrayList<RouteOperator> toRouteOperator(String value) {
        Type type = new TypeToken<ArrayList<RouteOperator>>() {
        }.getType();
        Gson gson = GsonUtil.getInstance().getGson();
        return gson.fromJson(value, type);
    }

    @TypeConverter
    static String toString(ArrayList<RouteOperator> value) {
        Gson gson = GsonUtil.getInstance().getGson();
        return gson.toJson(value);
    }
}
