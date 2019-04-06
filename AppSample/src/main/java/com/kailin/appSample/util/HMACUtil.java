package com.kailin.appSample.util;

import java.util.Base64;
import java.util.concurrent.atomic.AtomicReference;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HMACUtil {

    private static final AtomicReference<HMACUtil> reference = new AtomicReference<>();

    public static HMACUtil getInstance() {
        while (true) {
            HMACUtil instance = reference.get();
            if (instance != null)
                return instance;

            instance = new HMACUtil();
            if (reference.compareAndSet(null, instance))
                return instance;
        }
    }

    private final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    private HMACUtil() {
    }

    public String sha1Encrypt(String data, String key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("UTF-8"), HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);
            byte[] result = mac.doFinal(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(result);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
