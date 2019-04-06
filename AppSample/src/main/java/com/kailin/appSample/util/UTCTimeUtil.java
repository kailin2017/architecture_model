package com.kailin.appSample.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public final class UTCTimeUtil {

    private static final AtomicReference<UTCTimeUtil> reference = new AtomicReference<>();

    public static UTCTimeUtil getInstance() {
        while (true) {
            UTCTimeUtil instance = reference.get();
            if (instance != null)
                return instance;

            instance = new UTCTimeUtil();
            if (reference.compareAndSet(null, instance))
                return instance;
        }
    }

    private UTCTimeUtil(){
    }

    public String getUtcTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }
}
