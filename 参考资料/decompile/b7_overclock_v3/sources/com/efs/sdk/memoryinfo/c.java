package com.efs.sdk.memoryinfo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
final class c {
    public final String activity;

    /* JADX INFO: renamed from: bg, reason: collision with root package name */
    public final String f13012bg;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f13013n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f13014o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f13015p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f13016q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f13017r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f13018s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f13019t;

    public c(Context context) {
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo = null;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(androidx.appcompat.widget.c.f2369r);
            if (activityManager != null && (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) != null && processMemoryInfo.length > 0) {
                memoryInfo = processMemoryInfo[0];
            }
        } catch (Throwable unused) {
        }
        if (memoryInfo == null) {
            memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
        }
        this.f13012bg = UMMemoryMonitor.get().isForeground() ? "fg" : "bg";
        this.f13013n = ((long) memoryInfo.getTotalPss()) * 1024;
        this.f13014o = ((long) memoryInfo.dalvikPss) * 1024;
        this.f13015p = ((long) memoryInfo.nativePss) * 1024;
        this.f13018s = f.a(memoryInfo) * 1024;
        long jFreeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.f13016q = jFreeMemory;
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        if (jMaxMemory != 0) {
            this.f13017r = (jFreeMemory * 1.0f) / jMaxMemory;
        } else {
            this.f13017r = 1.0f;
        }
        this.f13019t = f.a() * 1024;
        this.activity = UMMemoryMonitor.get().getCurrentActivity();
    }
}
