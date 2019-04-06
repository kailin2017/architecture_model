package com.kailin.appSample.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.atomic.AtomicReference;

public final class GsonUtil {

    private static final AtomicReference<GsonUtil> reference = new AtomicReference<>();

    public static GsonUtil getInstance() {
        while (true) {
            GsonUtil instance = reference.get();
            if (instance != null)
                return instance;

            instance = new GsonUtil();
            if (reference.compareAndSet(null, instance))
                return instance;
        }
    }

    private final Gson gson;

    private GsonUtil() {
        gson = new GsonBuilder()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
                .create();
    }

    public Gson getGson() {
        return gson;
    }

}
