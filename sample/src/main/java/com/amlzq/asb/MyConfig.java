package com.amlzq.asb;

import android.app.Application;

import com.amlzq.android.ApplicationConfig;
import com.amlzq.android.annotation.ReleaseCheck;
import com.amlzq.android.log.Log;
import com.amlzq.android.log.LogWrapper;
import com.amlzq.android.util.UtilConfig;

public class MyConfig extends ApplicationConfig {

    public static String IDENTIFY = "IOSupport";
    public static boolean DEBUG = BuildConfig.DEBUG;
    public static String SHARED_PREFERENCES_NAME = IDENTIFY + "Prefs";

    /**
     * 初始化组件(除开第三方服务之外的SDK API)
     *
     * @param thisApp
     */
    @ReleaseCheck
    public static void configApplication(Application thisApp) {
        ApplicationConfig.IDENTIFY = IDENTIFY;
        ApplicationConfig.DEBUG = DEBUG;
        ApplicationConfig.SHARED_PREFERENCES_NAME = SHARED_PREFERENCES_NAME;

        // 初始化日志库
        Log.TAG = IDENTIFY;
        Log.LEVEL = Log.VERBOSE;
        LogWrapper logWrapper = new LogWrapper();
        Log.setLogNode(logWrapper);

        UtilConfig.DEBUG = DEBUG;
        UtilConfig.init(thisApp, IDENTIFY);

//        PrefsUtil.FILE_NAME = SHARED_PREFERENCES_NAME;

        // 崩溃处理类
//        if (!DEBUG)
//            CrashHandler.getInstance().init(DEBUG, getCrashDir().getAbsolutePath());
    }

    // HTTP Config
    /**
     * 入口协议
     * 生产环境必须https
     */
    public static final String PORTAL_PROTOCOL = "http://";
    /**
     * 主机名
     */
    public static final String PORTAL_HOST = DEBUG ? "" : "";
    /**
     * 入口地址
     */
    public static final String PORTAL_ADDRESS = "";
    /**
     * 入口端口
     */
    public static final String PORTAL_PORT = "";
    /**
     * 入口目录
     */
    public static final String DIRECTORY = "";
    /**
     * 服务器超时
     */
    public static final int TIMEOUT = 9 * 1000;

}