package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.i0;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;
import hb.u;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f24247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24249c;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    public static class C0262a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f24250a = new a();

        private C0262a() {
        }
    }

    public static a a(Context context) {
        if (f24247a == null && context != null) {
            f24247a = context.getApplicationContext();
        }
        return C0262a.f24250a;
    }

    private void f(String str) {
        try {
            this.f24248b = str.replaceAll("&=", i0.f11861z).replaceAll("&&", i0.f11861z).replaceAll("==", fh.a.f28350w) + fh.a.f28350w + "Android" + fh.a.f28350w + Build.DISPLAY + fh.a.f28350w + Build.MODEL + fh.a.f28350w + Build.VERSION.RELEASE + i0.f11861z + HelperUtils.getUmengMD5(UMUtils.getAppkey(f24247a));
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f24247a, th2);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] strArrSplit = str2.split("&=");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(an.aQ);
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    String strSubstring = str3.substring(0, 2);
                    if (strSubstring.endsWith(u.f30904o)) {
                        strSubstring = strSubstring.replace(u.f30904o, "");
                    }
                    sb2.append(strSubstring);
                }
            }
            this.f24249c = sb2.toString();
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f24247a, th2);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("t");
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(an.aD);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("h");
    }

    public void e(String str) {
        String strSubstring = str.substring(0, str.indexOf(95));
        g(strSubstring);
        f(strSubstring);
    }

    private a() {
        this.f24248b = null;
        this.f24249c = null;
    }

    public String b() {
        return this.f24248b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    public String a() {
        return this.f24249c;
    }
}
