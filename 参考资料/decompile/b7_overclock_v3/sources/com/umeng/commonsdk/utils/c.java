package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f24381b = "lastReqTime";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f24382c = 48;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f24383d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24384e = 720;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f24385f = "iss";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f24386g = "sinr";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f24387h = "clean";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f24388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f24389j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24380a = z.b().b(z.f23820z);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Object f24390k = new Object();

    static {
        f24388i = false;
        f24389j = f24384e;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f24385f, "");
            if (TextUtils.isEmpty(strImprintProperty) || !"1".equals(strImprintProperty)) {
                return;
            }
            synchronized (f24390k) {
                f24388i = true;
            }
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f24386g, "");
            if (TextUtils.isEmpty(strImprintProperty)) {
                f24389j = 48;
                return;
            }
            try {
                f24389j = a(Integer.parseInt(strImprintProperty2));
            } catch (Throwable unused) {
                f24389j = 48;
            }
        }
    }

    private static int a(int i10) {
        if (i10 > f24384e) {
            return f24384e;
        }
        if (i10 < 1) {
            return 1;
        }
        return i10;
    }

    public static boolean a() {
        boolean z10;
        synchronized (f24390k) {
            z10 = f24388i;
        }
        return z10;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24380a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(f24381b, 0L);
        }
        return 0L;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24380a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f24387h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24380a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f24387h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24380a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f24387h, false);
        }
        return false;
    }

    public static int a(Context context) {
        int i10;
        synchronized (f24390k) {
            i10 = f24389j;
        }
        return i10;
    }

    public static boolean a(long j10, long j11, int i10) {
        Date date = new Date(j11);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j10));
        calendar.add(10, i10);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j10) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24380a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f24381b, j10).commit();
        }
    }
}
