package com.sunyjams.domain;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.sunyjams.common.crash.AppCrashHandler;

/**
 * Created by James
 * on 2017/10/20.
 * description
 */

public class BaseApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppCrashHandler.getInstance(this);
    }
}
