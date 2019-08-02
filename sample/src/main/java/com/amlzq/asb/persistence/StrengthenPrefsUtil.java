package com.amlzq.asb.persistence;

import android.content.Context;
import android.text.TextUtils;

import com.amlzq.android.encode.Base64Util;
import com.amlzq.android.util.PrefsUtil;
import com.amlzq.asb.GsonUtil;

public class StrengthenPrefsUtil {

    ///////////////////////////////////////////////////////////////////////////
    // Object 以 JSON 的形式存入SP
    ///////////////////////////////////////////////////////////////////////////

    /**
     * @param obj 对象
     * @return 是否保存成功
     */
    public static void saveEntity(Context context, final Object obj) {
        if (null != obj) {
            final String innerKey = getKey(obj.getClass());
            if (null != innerKey) {
                String value = GsonUtil.obj2str(obj);
                if (TextUtils.isEmpty(value)) {
                    return;
                }
                value = Base64Util.encode(value.getBytes());
                PrefsUtil.save(context, innerKey, value);
            }
        }
    }

    /**
     * @param clazz        类型
     * @param defaultValue 默认值
     * @return T对象
     */
    public static <T> T getEntity(Context context, final Class<T> clazz, final T defaultValue) {
        final String innerKey = getKey(clazz);
        if (!TextUtils.isEmpty(innerKey)) {
            String value = (String) PrefsUtil.get(context, innerKey, "");
            if (TextUtils.isEmpty(value)) {
                return null;
            }
            value = new String(Base64Util.decode(value));
            T ret = GsonUtil.str2obj(value, clazz);
            if (null != ret) {
                return ret;
            }
        }
        return defaultValue;
    }

    /**
     * 类对应的key
     */
    private static String getKey(final Class<?> clazz) {
        if (null != clazz) {
            return clazz.getName();
        }
        return null;
    }

}
