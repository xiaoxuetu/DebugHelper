package io.github.xiaoxuetu.debughelper.util;

import android.text.TextUtils;
import android.util.Log;

public class DeveloperModeHelper {

    private static final String TAG = "DeveloperModeHelper";

    private static final String DEVELOPER_PROPERTY_KEY = "service.adb.tcp.port";

    public enum DeveloperMode {
        USB,
        REMOTE
    }

    public static DeveloperMode getDeveloperMode() {
        String portStr = SystemPropertiesHelper.getStringProp(DEVELOPER_PROPERTY_KEY, "");
        int port = -1;

        if (!TextUtils.isEmpty(portStr) && TextUtils.isDigitsOnly(portStr)) {
            try {
                port = Integer.parseInt(portStr);
            } catch (Exception ignored){
            }
        }
        Log.d(TAG, "port str is " + portStr + ", port is " + port);
        return port <= 0 ? DeveloperMode.USB : DeveloperMode.REMOTE;
    }
}
