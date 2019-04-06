package com.kailin.appSample.connect;

import com.kailin.appSample.util.HMACUtil;
import com.kailin.appSample.util.UTCTimeUtil;

import java.io.IOException;
import java.util.WeakHashMap;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

public final class MyInterceptor implements Interceptor {

    private static volatile WeakHashMap<String, MyInterceptor> weakHashMap = new WeakHashMap<>();

    public static MyInterceptor getInstance(String appId, String appKey) {
        MyInterceptor myInterceptor = weakHashMap.get(appId);
        if (myInterceptor == null) {
            synchronized (MyInterceptor.class) {
                myInterceptor = weakHashMap.get(appId);
                if (myInterceptor == null) {
                    myInterceptor = new MyInterceptor(appId, appKey);
                    weakHashMap.put(appId, myInterceptor);
                }
            }
        }
        return myInterceptor;
    }

    private final String appId, appKey;

    private MyInterceptor(String appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        String dateString = UTCTimeUtil.getInstance().getUtcTime();

        Request oldRequest = chain.request();
        Request.Builder builder = oldRequest.newBuilder();

        HMACUtil hmacUtil = HMACUtil.getInstance();
        String signature = hmacUtil.sha1Encrypt(String.format("x-date: %s", dateString), appKey);
        String authorization = String.format("hmac username=\"%s\", algorithm=\"hmac-sha1\", headers=\"x-date\", signature=\"%s\"", appId, signature);

        builder.addHeader("Authorization", authorization);
        builder.addHeader("x-date", dateString);

        Request request = builder.build();

        Response response = chain.proceed(request);
        return response;
    }
}
