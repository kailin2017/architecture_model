package com.kailin.architecture_model.util;

import android.os.Build;

public final class CheckEmulatorUtil {

    private static volatile CheckEmulatorUtil checkEmulatorUtil;

    public static CheckEmulatorUtil getInstance() {
        if (checkEmulatorUtil == null) {
            synchronized (CheckEmulatorUtil.class) {
                if (checkEmulatorUtil == null)
                    checkEmulatorUtil = new CheckEmulatorUtil();
            }
        }
        return checkEmulatorUtil;
    }

    private CheckEmulatorUtil() {
    }

    public boolean isEmulator() {
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT);
    }
}
