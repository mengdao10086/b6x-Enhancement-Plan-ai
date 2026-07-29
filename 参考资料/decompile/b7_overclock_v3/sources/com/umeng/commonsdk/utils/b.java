package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, PackageInfo> f24377a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f24378b = new Object();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f24379a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f24379a;
    }

    private b() {
    }

    public PackageInfo a(Context context, String str, int i10) {
        PackageInfo packageInfo;
        synchronized (f24378b) {
            packageInfo = null;
            if (f24377a.containsKey(str)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                packageInfo = f24377a.get(str);
            } else {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str, i10);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                    f24377a.put(str, packageInfo2);
                    packageInfo = packageInfo2;
                } catch (PackageManager.NameNotFoundException unused) {
                    f24377a.put(str, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                }
            }
        }
        return packageInfo;
    }
}
