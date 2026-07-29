package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.socialize.handler.UMTencentSSOHandler;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24084a = "BatteryUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f24085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f24086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f24087d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f24089a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (f24086c == null && context != null) {
            f24086c = context.getApplicationContext();
        }
        return a.f24089a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f24086c.registerReceiver(this.f24087d, intentFilter);
            f24085b = true;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f24086c, th2);
        }
    }

    public synchronized void c() {
        try {
            f24086c.unregisterReceiver(this.f24087d);
            f24085b = false;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f24086c, th2);
        }
    }

    private c() {
        this.f24087d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i10 = 0;
                        int intExtra = intent.getIntExtra(UMTencentSSOHandler.LEVEL, 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra("status", 0);
                        int i11 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i11 = 1;
                            } else if (intExtra4 == 4) {
                                i11 = 0;
                            } else if (intExtra4 == 5) {
                                i11 = 2;
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i10 = 1;
                        } else if (intExtra5 == 2) {
                            i10 = 2;
                        }
                        b bVar = new b();
                        bVar.f24078a = intExtra;
                        bVar.f24079b = intExtra2;
                        bVar.f24081d = i11;
                        bVar.f24080c = intExtra3;
                        bVar.f24082e = i10;
                        bVar.f24083f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f24036h, com.umeng.commonsdk.internal.b.a(c.f24086c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(c.f24086c, th2);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f24085b;
    }
}
