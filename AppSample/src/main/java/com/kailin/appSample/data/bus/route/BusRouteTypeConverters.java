package com.kailin.appSample.data.bus.route;

import androidx.room.TypeConverter;

public interface BusRouteTypeConverters {

    @TypeConverter
    static BusRouteType toBusRouteType(String value) {
        return BusRouteType.valueOf(value);
    }

    @TypeConverter
    static String toString(BusRouteType value) {
        return value.name();
    }
}
