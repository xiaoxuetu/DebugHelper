package io.github.xiaoxuetu.debughelper.util;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 通过反射的方式访问SystemProperties
 *
 * 代码参见 https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/os/SystemProperties.java;l=251?q=SystemProperties
 */
@SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
public class SystemPropertiesHelper {

    private static final String TAG = SystemPropertiesHelper.class.getName();

    private static final String SYSTEM_PROPERTIES_CLASS_NAME = "android.os.SystemProperties";

    public static boolean getBooleanProp(String key, boolean defaultVal) {
        try {
            Class<?> cls = Class.forName(SYSTEM_PROPERTIES_CLASS_NAME);
            java.lang.reflect.Method method = cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);

            method.setAccessible(true);
            return (boolean) method.invoke(null, key, defaultVal);
        } catch (Throwable t) {
            Log.e(TAG, "get prop error", t);
        }
        return defaultVal;
    }

    public static String getStringProp(String key, String defaultVal) {
        try {
            Class<?> cls = Class.forName(SYSTEM_PROPERTIES_CLASS_NAME);
            java.lang.reflect.Method method = cls.getDeclaredMethod("get", String.class, String.class);

            method.setAccessible(true);
            return (String) method.invoke(null, key, defaultVal);
        } catch (Throwable t) {
            Log.e(TAG, "get prop error", t);
        }
        return defaultVal;
    }

    public static void setStringProp(@NonNull String key, @Nullable String val) {
        try {
             Class<?> cls = Class.forName(SYSTEM_PROPERTIES_CLASS_NAME);
             java.lang.reflect.Method method = cls.getDeclaredMethod("set", String.class, String.class);

            method.setAccessible(true);
            method.invoke(null, key, val);
        } catch (Throwable t) {
            Log.e(TAG, "set prop error", t);
        }
    }
}