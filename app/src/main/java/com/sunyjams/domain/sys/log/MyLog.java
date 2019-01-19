package com.sunyjams.domain.sys.log;


import android.util.Log;

import com.sunyjams.domain.config.SysConfig;

/**
 * Created by James
 * Date 2017/12/5.
 * description
 */
public class MyLog {

    private static final String TAG = "com.xiaou.mobile.log";

    private static final boolean IS_FORCE_OUT_PUT_LOG = false;

    public static void i(String tag, String msg){
        if(SysConfig.IS_DEBUG || IS_FORCE_OUT_PUT_LOG){
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg){
        if(SysConfig.IS_DEBUG || IS_FORCE_OUT_PUT_LOG){
            Log.d(tag, msg);
        }
    }

    public static void v(String tag, String msg){
        if(SysConfig.IS_DEBUG || IS_FORCE_OUT_PUT_LOG){
            Log.v(tag, msg);
        }
    }

    public static void e(String tag, String msg){
        if(SysConfig.IS_DEBUG || IS_FORCE_OUT_PUT_LOG){
            Log.e(tag, msg);
        }
    }

    /**
     * 也可以使用这种方式输出log，默认TAG为xiaou
     * @param msg msm
     */
    public static void i(String msg){
        i(TAG, msg);
    }

    public static void d(String msg){
        d(TAG, msg);
    }

    public static void v(String msg){
        v(TAG, msg);
    }

    public static void e(String msg){
        e(TAG, msg);
    }

}
