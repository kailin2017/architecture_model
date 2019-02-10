package com.kailin.appSample.connect;

import java.io.IOException;
import java.util.Date;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class MyInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
//        builder.addHeader("Authorization", "hmac username=\"FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF\", algorithm=\"hmac-sha1\", headers=\"x-date\", signature=\"6TDNdOg8nHuw1N5ZkC1JsuLBhUU=\"");
//        builder.addHeader("x-date", new Date().toString());
        Request request = builder.build();
        Response response = chain.proceed(request);
        return response;
    }
}
