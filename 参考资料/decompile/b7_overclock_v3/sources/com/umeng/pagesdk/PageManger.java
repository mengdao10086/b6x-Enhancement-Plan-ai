package com.umeng.pagesdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;

/* JADX INFO: loaded from: classes5.dex */
public class PageManger {
    public static final String TAG = "PageManger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f24458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f24459b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static EfsReporter f24460c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static PageConfigManger f24461d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f24462e = true;
    public static boolean isDebug = true;

    public static Context getApplicationContext() {
        return f24458a;
    }

    public static PageConfigManger getPageConfigManger() {
        return f24461d;
    }

    public static EfsReporter getReporter() {
        return f24460c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    return;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        if (isInit()) {
            return;
        }
        f24458a = context.getApplicationContext();
        f24460c = efsReporter;
        f24461d = new PageConfigManger(context, efsReporter);
        f24459b = true;
    }

    public static boolean isControlMainThread() {
        return f24462e;
    }

    public static boolean isInit() {
        return f24459b;
    }

    public static void onTracePageBegin(Activity activity, String str) {
        try {
            onTracePageBegin(activity, str, false);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void onTracePageBegin(Activity activity, String str, boolean z10) {
        if (activity != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z10 || !(str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                    if (str.length() <= 10) {
                        if (f24462e && !c.a(activity.getApplicationContext())) {
                            boolean z11 = isDebug;
                        }
                        b.a(activity.getClass().getName(), str, z10);
                        return;
                    }
                    if (isDebug) {
                        StringBuilder sb2 = new StringBuilder("tracePageBegin. method name is ");
                        sb2.append(str);
                        sb2.append("method name over length !");
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void onTracePageEnd(Activity activity, String str) {
        try {
            onTracePageEnd(activity, str, false);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void onTracePageEnd(Activity activity, String str, boolean z10) {
        if (activity != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z10 || !(str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                    if (str.length() <= 10) {
                        if (f24462e && !c.a(activity.getApplicationContext())) {
                            boolean z11 = isDebug;
                        }
                        b.b(activity.getClass().getName(), str, z10);
                        return;
                    }
                    if (isDebug) {
                        StringBuilder sb2 = new StringBuilder("tracePageEnd. method name is ");
                        sb2.append(str);
                        sb2.append("method name over length !");
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void setControlMainThread(boolean z10) {
        f24462e = z10;
    }
}
