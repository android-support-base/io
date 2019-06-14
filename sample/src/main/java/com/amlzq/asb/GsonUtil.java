package com.amlzq.asb;

import com.google.gson.Gson;

/**
 * Gson工具
 */

public class GsonUtil {

    /**
     * Object 到 String 的序列化
     */
    public static String obj2str(final Object obj) {
        try {
            return new Gson().toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * String 到 Object 的反序列化
     */
    public static <T> T str2obj(final String string, final Class<T> clazz) {
        try {
            return new Gson().fromJson(string, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
