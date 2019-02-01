package com.kailin.architecture_model.util;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

import java.util.UUID;

public final class UUIDUtil {

    private static volatile UUIDUtil uuidUtil;

    private static final String PERFERENCES_KEY_UUID = "UUID";

    public static UUIDUtil getInstance(Context context) {
        if (uuidUtil == null) {
            synchronized (UUIDUtil.class) {
                if (uuidUtil == null)
                    uuidUtil = new UUIDUtil(context);
            }
        }
        return uuidUtil;
    }

    private final Context context;
    private final SharedPreferencesUtil sharedPreferencesUtil;

    private UUIDUtil(Context context) {
        this.context = context.getApplicationContext();
        this.sharedPreferencesUtil = SharedPreferencesUtil.getInstance(context);
    }

    public String getUUID() {
        String uuid = sharedPreferencesUtil.getString(PERFERENCES_KEY_UUID);
        if (TextUtils.isEmpty(uuid)) {
            String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            uuid = UUID.nameUUIDFromBytes(androidId.getBytes()).toString();
            if (TextUtils.isEmpty(uuid)) {
                uuid = UUID.randomUUID().toString();
            }
            sharedPreferencesUtil.putString(PERFERENCES_KEY_UUID, uuid);
        }
        return uuid;
    }
}
