package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {
    public q0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @g.y0("android.permission.KILL_BACKGROUND_PROCESSES")
    public static Set<String> a() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) j1.a().getSystemService(androidx.appcompat.widget.c.f2369r)).getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
            while (it2.hasNext()) {
                Collections.addAll(hashSet, it2.next().pkgList);
            }
        }
        return hashSet;
    }

    public static String b() {
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        String strC = c();
        return !TextUtils.isEmpty(strC) ? strC : e();
    }

    public static String c() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) j1.a().getSystemService(androidx.appcompat.widget.c.f2369r);
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
                int iMyPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid && (str = runningAppProcessInfo.processName) != null) {
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String strTrim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return strTrim;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String e() {
        try {
            Application applicationA = j1.a();
            Field field = applicationA.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(applicationA);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(obj2, new Object[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String f() {
        List<UsageStats> listQueryUsageStats;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) j1.a().getSystemService(androidx.appcompat.widget.c.f2369r)).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        if (Build.VERSION.SDK_INT > 21) {
            PackageManager packageManager = j1.a().getPackageManager();
            Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            listQueryIntentActivities.toString();
            if (listQueryIntentActivities.size() <= 0) {
                return "";
            }
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(j1.a().getPackageName(), 0);
                AppOpsManager appOpsManager = (AppOpsManager) j1.a().getSystemService("appops");
                if (appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) != 0) {
                    intent.addFlags(268435456);
                    j1.a().startActivity(intent);
                }
                if (appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) != 0) {
                    return "";
                }
                UsageStatsManager usageStatsManager = (UsageStatsManager) j1.a().getSystemService("usagestats");
                if (usageStatsManager != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    listQueryUsageStats = usageStatsManager.queryUsageStats(4, jCurrentTimeMillis - 604800000, jCurrentTimeMillis);
                } else {
                    listQueryUsageStats = null;
                }
                if (listQueryUsageStats != null && !listQueryUsageStats.isEmpty()) {
                    UsageStats usageStats = null;
                    for (UsageStats usageStats2 : listQueryUsageStats) {
                        if (usageStats == null || usageStats2.getLastTimeUsed() > usageStats.getLastTimeUsed()) {
                            usageStats = usageStats2;
                        }
                    }
                    if (usageStats == null) {
                        return null;
                    }
                    return usageStats.getPackageName();
                }
                return "";
            } catch (PackageManager.NameNotFoundException e10) {
                e10.printStackTrace();
            }
        }
        return "";
    }

    public static boolean g() {
        return j1.a().getPackageName().equals(b());
    }

    @g.y0("android.permission.KILL_BACKGROUND_PROCESSES")
    public static Set<String> h() {
        ActivityManager activityManager = (ActivityManager) j1.a().getSystemService(androidx.appcompat.widget.c.f2369r);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        if (runningAppProcesses == null) {
            return hashSet;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            for (String str : it2.next().pkgList) {
                activityManager.killBackgroundProcesses(str);
                hashSet.add(str);
            }
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it3 = activityManager.getRunningAppProcesses().iterator();
        while (it3.hasNext()) {
            for (String str2 : it3.next().pkgList) {
                hashSet.remove(str2);
            }
        }
        return hashSet;
    }

    @g.y0("android.permission.KILL_BACKGROUND_PROCESSES")
    public static boolean i(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'packageName' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        ActivityManager activityManager = (ActivityManager) j1.a().getSystemService(androidx.appcompat.widget.c.f2369r);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
            Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
            while (it2.hasNext()) {
                if (Arrays.asList(it2.next().pkgList).contains(str)) {
                    activityManager.killBackgroundProcesses(str);
                }
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses2 = activityManager.getRunningAppProcesses();
            if (runningAppProcesses2 != null && runningAppProcesses2.size() != 0) {
                Iterator<ActivityManager.RunningAppProcessInfo> it3 = runningAppProcesses2.iterator();
                while (it3.hasNext()) {
                    if (Arrays.asList(it3.next().pkgList).contains(str)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
