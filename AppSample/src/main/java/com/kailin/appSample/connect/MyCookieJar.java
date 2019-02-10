package com.kailin.appSample.connect;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public final class MyCookieJar implements CookieJar {

    private final WeakHashMap<HttpUrl, List<Cookie>> weakHashMap = new WeakHashMap<>();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        weakHashMap.put(url, cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = weakHashMap.get(url);
        return cookies == null ? new ArrayList<>() : cookies;
    }
}
