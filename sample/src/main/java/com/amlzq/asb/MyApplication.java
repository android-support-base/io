package com.amlzq.asb;

import android.app.Application;

import com.amlzq.android.log.Log;

public class MyApplication extends Application {
    public static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        MyConfig.configApplication(this);

        // 打印应用初始化后的状态
        Log.i("Debug state:" + MyConfig.DEBUG);
        Log.i("Channel id:" + MyConfig.CHANNEL_ID);
    }

}