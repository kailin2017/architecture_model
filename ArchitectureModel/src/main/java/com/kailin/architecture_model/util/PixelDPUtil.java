package com.kailin.architecture_model.util;

import android.content.Context;
import android.util.DisplayMetrics;

public final class PixelDPUtil {

    private static volatile PixelDPUtil pixelDPUtil;

    public static PixelDPUtil getInstance() {
        if (pixelDPUtil == null) {
            synchronized (PixelDPUtil.class) {
                if (pixelDPUtil == null)
                    pixelDPUtil = new PixelDPUtil();
            }
        }
        return pixelDPUtil;
    }

    private PixelDPUtil(){}

    /**
     * Covert dp to px
     *
     * @param dp
     * @param context
     * @return pixel
     */
    public int convertDpToPixel(float dp, Context context) {
        float px = dp * getDensity(context);
        return (int) px;
    }

    /**
     * Covert px to dp
     *
     * @param px
     * @param context
     * @return dp
     */
    public int convertPixelToDp(float px, Context context) {
        float dp = px / getDensity(context);
        return (int) dp;
    }

    /**
     * 取得螢幕密度
     * 120dpi = 0.75
     * 160dpi = 1 (default)
     * 240dpi = 1.5
     *
     * @param context
     * @return
     */
    private float getDensity(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.density;
    }
}
