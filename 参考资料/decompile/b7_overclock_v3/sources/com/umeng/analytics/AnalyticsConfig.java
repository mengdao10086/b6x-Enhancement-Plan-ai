package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_START_TIME = "startTime";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static double[] f23100a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f23101b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f23102c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f23103d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f23104e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = z.b().b(z.A);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Object f23105f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f23106g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f23107h = "";

    public static void a(String str) {
        f23102c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f23100a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f23105f) {
            str = f23107h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f23103d)) {
            f23103d = com.umeng.common.b.a(context).c();
        }
        return f23103d;
    }

    public static int getVerticalType(Context context) {
        if (f23104e == 0) {
            f23104e = com.umeng.common.b.a(context).d();
        }
        return f23104e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z10;
        synchronized (f23105f) {
            z10 = f23106g;
        }
        return z10;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f23105f) {
            f23106g = false;
            f23107h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f23105f) {
            f23106g = true;
            if (map != null && map.containsKey("debugkey")) {
                f23107h = map.get("debugkey");
            }
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.A, 0, "\\|");
        } else {
            f23103d = str;
            com.umeng.common.b.a(context).a(f23103d);
        }
    }

    public static void a(Context context, int i10) {
        f23104e = i10;
        com.umeng.common.b.a(context).a(f23104e);
    }
}
