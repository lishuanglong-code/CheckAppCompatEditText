package com.lsl;

import android.util.Log;

/**
 * creation time ：2018/12/4
 * author ：lishuanglong
 * <p>
 * 日志类
 */
public class L {
    private static final boolean flag = true;
    public static final String TAG = "L_xxxxxxxxx";

    public static void d(String context) {
        d(TAG, context);
    }

    public static void d(String tag, String context) {
        if (flag) {
            Log.d(tag, context);
        }
    }
}
