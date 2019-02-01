package com.kailin.architecture_model.util;

import android.text.TextUtils;

public final class CheckProxyUtil {

    private static volatile CheckProxyUtil checkProxyUtil;

    public static CheckProxyUtil getInstance() {
        if (checkProxyUtil == null) {
            synchronized (CheckProxyUtil.class) {
                if (checkProxyUtil == null)
                    checkProxyUtil = new CheckProxyUtil();
            }
        }
        return checkProxyUtil;
    }

    private CheckProxyUtil() {
    }

    public boolean isProxy() {
        int proxyPort;
        try {
            proxyPort = Integer.valueOf(System.getProperty("http.proxyHost"));
        } catch (Exception e) {
            proxyPort = -1;
        }
        return !TextUtils.isEmpty(System.getProperty("http.proxyPort")) && proxyPort > -1;
    }
}
