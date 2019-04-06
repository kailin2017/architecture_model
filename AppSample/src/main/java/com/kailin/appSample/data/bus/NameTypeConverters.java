package com.kailin.appSample.data.bus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kailin.appSample.util.GsonUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;

import androidx.room.TypeConverter;

public interface NameTypeConverters {

    @TypeConverter
    static NameType toRouteOperator(String value) {
        Type type = new TypeToken<NameType>() {
        }.getType();
        Gson gson = GsonUtil.getInstance().getGson();
        return gson.fromJson(value, type);
    }

    @TypeConverter
    static String toString(NameType value) {
        return GsonUtil.getInstance().getGson().toJson(value);
    }
}
