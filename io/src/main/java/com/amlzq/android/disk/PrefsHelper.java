package com.amlzq.android.disk;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by amlzq on 2019/4/9.
 * SharedPreferences helper
 *
 * @reference https://blog.csdn.net/lmj623565791/article/details/38965311
 */
public class PrefsHelper {

    private String mFileName;

    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String mFileName) {
        this.mFileName = mFileName;
    }

    public void put(Context context, String key, Object object) {
        put(context, mFileName, Context.MODE_PRIVATE, key, object);
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     */
    public void put(Context context, String name, int mode, String key, Object object) {
        SharedPreferences preferences = context.getSharedPreferences(name, mode);
        SharedPreferences.Editor editor = preferences.edit();
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
        SharedPreferencesCompat.apply(editor);
    }

    public Object get(Context context, String key, Object defValue) {
        return get(context, mFileName, Context.MODE_PRIVATE, key, defValue);
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     */
    public Object get(Context context, String name, int mode, String key, Object defValue) {
        SharedPreferences preferences = context.getSharedPreferences(name, mode);
        if (defValue instanceof String) {
            return preferences.getString(key, (String) defValue);
        } else if (defValue instanceof Integer) {
            return preferences.getInt(key, (Integer) defValue);
        } else if (defValue instanceof Boolean) {
            return preferences.getBoolean(key, (Boolean) defValue);
        } else if (defValue instanceof Float) {
            return preferences.getFloat(key, (Float) defValue);
        } else if (defValue instanceof Long) {
            return preferences.getLong(key, (Long) defValue);
        }
        return null;
    }

    /**
     * 移除某个key值已经对应的值
     */
    public void remove(Context context, String key) {
        remove(context, mFileName, key);
    }

    public void remove(Context context, String name, String key) {
        SharedPreferences preferences = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     */
    public void clear(Context context) {
        clear(context, mFileName);
    }

    public void clear(Context context, String name) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    public boolean contains(Context context, String key) {
        return contains(context, mFileName, key);
    }

    /**
     * 查询某个key是否已经存在
     */
    public boolean contains(Context context, String name, String key) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.contains(key);
    }

    public Map<String, ?> getAll(Context context) {
        return getAll(context, mFileName);
    }

    /**
     * 返回所有的键值对
     */
    public Map<String, ?> getAll(Context context, String name) {
        SharedPreferences preferences = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        return preferences.getAll();
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }
            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }
    }

}
