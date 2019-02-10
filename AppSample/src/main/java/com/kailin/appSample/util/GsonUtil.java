package com.kailin.appSample.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonUtil {

    private static volatile GsonUtil gsonUtil;

    public static GsonUtil getInstance(){
        if (gsonUtil==null){
            synchronized (GsonUtil.class){
                if (gsonUtil==null)
                    gsonUtil = new GsonUtil();
            }
        }
        return gsonUtil;
    }

    private final Gson gson;

    private GsonUtil() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
    }

    public Gson getGson() {
        return gson;
    }
}
