package com.kailin.architecture_model.util;

import java.io.File;

public final class CheckRootUtil {

    private static volatile CheckRootUtil checkRootUtil;

    public static CheckRootUtil getInstance() {
        if (checkRootUtil == null) {
            synchronized (CheckRootUtil.class) {
                if (checkRootUtil == null)
                    checkRootUtil = new CheckRootUtil();
            }
        }
        return checkRootUtil;
    }

    private final String[] rootPaths = new String[]{
            "/sbin/",
            "/system/bin/",
            "/system/xbin/",
            "/data/local/xbin/",
            "/data/local/bin/",
            "/system/sd/xbin/",
            "/system/bin/failsafe/",
            "/data/local/"
    };

    public boolean isRooted() {
        return doesFileExists();
    }

    private boolean doesFileExists() {
        for (String path : rootPaths) {
            File file = new File(String.format("%s/su", path));
            if (file.exists()) {
                return true;
            }
        }
        return false;
    }
}
