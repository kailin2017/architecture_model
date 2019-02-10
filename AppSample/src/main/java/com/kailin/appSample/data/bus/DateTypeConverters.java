package com.kailin.appSample.data.bus;

import java.util.Date;

import androidx.room.TypeConverter;

public interface DateTypeConverters {

    @TypeConverter
    static Date revertDate(long value) {
        return new Date(value);
    }

    @TypeConverter
    static long converterDate(Date value) {
        return value.getTime();
    }
}
