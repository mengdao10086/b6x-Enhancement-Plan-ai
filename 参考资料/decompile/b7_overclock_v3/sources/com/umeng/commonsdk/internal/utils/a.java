package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.commonsdk.internal.utils.a$a, reason: collision with other inner class name */
    public static class C0260a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24077b;
    }

    public static long a(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (packageInfoA != null) {
                return packageInfoA.firstInstallTime;
            }
            return 0L;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            ULog.e("getAppFirstInstallTime" + th2.getMessage());
            return 0L;
        }
    }

    public static long b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (packageInfoA != null) {
                return packageInfoA.lastUpdateTime;
            }
            return 0L;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            ULog.e("getAppLastUpdateTime:" + th2.getMessage());
            return 0L;
        }
    }

    public static void b(Context context) {
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
            ULog.e("getAppInstaller:" + e10.getMessage());
            return null;
        }
    }

    public static int d(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (packageInfoA == null || (applicationInfo = packageInfoA.applicationInfo) == null) {
                return 0;
            }
            return applicationInfo.uid;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            ULog.e("getAppUid:" + th2.getMessage());
            return 0;
        }
    }

    public static DisplayMetrics e(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static List<InputMethodInfo> f(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return null;
        }
        return inputMethodManager.getInputMethodList();
    }

    public static List<C0260a> g(Context context) {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (String str : list) {
                    if (str != null && !str.startsWith(j3.b.f36044h)) {
                        C0260a c0260a = new C0260a();
                        c0260a.f24076a = str;
                        c0260a.f24077b = e(context, str);
                        arrayList.add(c0260a);
                    }
                }
            }
        } catch (Exception e10) {
            ULog.e("getAppList:" + e10.getMessage());
        }
        return arrayList;
    }

    public static ActivityManager.MemoryInfo h(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(androidx.appcompat.widget.c.f2369r)) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String i(Context context) {
        return null;
    }

    public static String j(Context context) {
        return null;
    }

    private static String e(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return (String) applicationInfo.loadLabel(context.getPackageManager());
            }
            return null;
        } catch (Exception e10) {
            ULog.e("getLabel:" + e10.getMessage());
            return null;
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", l4.f.f39447b));
    }

    public static boolean a() {
        return h.a();
    }

    public static String b() {
        return new SimpleDateFormat().format(new Date());
    }

    public static float a(Context context) {
        if (context == null) {
            return 0.0f;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (Exception e10) {
            ULog.e("getFontSize:" + e10.getMessage());
            return 0.0f;
        }
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", l4.f.f39447b));
    }

    public static long c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String d() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String string = declaredMethod.invoke(null, "net.hostname").toString();
            return (string == null || string.equalsIgnoreCase("")) ? string : HelperUtils.getUmengMD5(string);
        } catch (Exception e10) {
            ULog.e("getHostName:" + e10.getMessage());
            return null;
        }
    }
}
