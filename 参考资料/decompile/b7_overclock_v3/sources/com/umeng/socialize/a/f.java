package com.umeng.socialize.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes5.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f24544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f24545f;

    public f(Object obj, Object obj2) {
        String strValueOf;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f24540a = packageInfo.packageName;
        this.f24542c = packageInfo.versionName;
        this.f24543d = packageInfo.firstInstallTime;
        this.f24544e = packageInfo.lastUpdateTime;
        this.f24545f = a(packageInfo);
        try {
            strValueOf = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            strValueOf = "";
        }
        this.f24541b = strValueOf;
    }

    private int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i10 = applicationInfo.flags;
        return ((i10 & 1) == 0 && (i10 & 128) == 0) ? 1 : 0;
    }
}
