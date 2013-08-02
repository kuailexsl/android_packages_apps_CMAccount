package com.cyanogenmod.id;

import android.app.Application;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

public class CMID extends Application {

    public static final String TAG = "CMID";
    public static final boolean DEBUG = true;

    public static final String ACCOUNT_TYPE_CMID = "com.cyanogenmod.id";
    public static final String ACCOUNT_TYPE_GOOGLE = "com.google";
    public static final String AUTHTOKEN_TYPE_ACCESS = "com.cyanogenmod.id";
    public static final String AUTHTOKEN_TYPE_REFRESH = "com.cyanogenmod.id.auth.refresh_token";
    public static final String AUTHTOKEN_EXPIRES_IN= "com.cyanogenmod.id.auth.expires_in";

    public static final String ACTION_SETUP_WIFI = "com.android.net.wifi.SETUP_WIFI_NETWORK";

    public static final String EXTRA_FIRST_RUN = "firstRun";
    public static final String EXTRA_ALLOW_SKIP = "allowSkip";
    public static final String EXTRA_SHOW_SKIP = "extra_prefs_show_button_bar";
    public static final String EXTRA_AUTO_FINISH = "wifi_auto_finish_on_connect";
    public static final String EXTRA_SHOW_BUTTON_BAR = "extra_prefs_show_button_bar";
    public static final String EXTRA_PREF_BACK_TEXT = "extra_prefs_set_back_text";
    public static final String EXTRA_ONLY_ACCESS_POINTS = "only_access_points";

    public static final String GCM_PREFERENCES = "com.cyanogenmod.id.gcm";
    public static final String AUTH_PREFERENCES = "com.cyanogenmod.id.auth";
    public static final String SETTINGS_PREFERENCES = "com.cyanogenmod.id_preferences";

    public static final String KEY_FIND_DEVICE_PREF = "find_device";

    public static final String BACKOFF_MS = "backoff_ms";
    public static final int DEFAULT_BACKOFF_MS = 3000;
    public static final int MAX_BACKOFF_MS = 1000 * 60 * 60 * 6; // 6 hours

    public static final int REQUEST_CODE_SETUP_WIFI = 0;
    public static final int REQUEST_CODE_SETUP_CMID = 1;


    @Override
    public void onCreate() {
        super.onCreate();
        final DevicePolicyManager dpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        final ComponentName deviceAdmin = new ComponentName(getApplicationContext(), CMIDAdminReceiver.class);
        dpm.setActiveAdmin(deviceAdmin, true);
    }

    public static class CMIDAdminReceiver extends DeviceAdminReceiver {}

}