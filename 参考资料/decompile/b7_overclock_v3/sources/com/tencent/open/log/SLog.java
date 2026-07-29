package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.d;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f22733c;
    public static SLog instance;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f22734a = new a(new b(a(), c.f22774m, c.f22768g, c.f22769h, c.f22764c, c.f22770i, 10, c.f22766e, c.f22775n));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Tracer f22735b;

    private SLog() {
    }

    public static final void d(String str, String str2) {
        getInstance().a(2, str, str2, null);
    }

    public static final void e(String str, String str2) {
        getInstance().a(16, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().c();
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                if (instance == null) {
                    instance = new SLog();
                    f22733c = true;
                }
            }
        }
        return instance;
    }

    public static final void i(String str, String str2) {
        getInstance().a(4, str, str2, null);
    }

    public static void release() {
        synchronized (SLog.class) {
            getInstance().b();
            if (instance != null) {
                instance = null;
            }
        }
    }

    public static final void u(String str, String str2) {
        getInstance().a(32, str, str2, null);
    }

    public static final void v(String str, String str2) {
        getInstance().a(1, str, str2, null);
    }

    public static final void w(String str, String str2) {
        getInstance().a(8, str, str2, null);
    }

    public void a(int i10, String str, String str2, Throwable th2) {
        if (f22733c) {
            String strB = com.tencent.open.utils.f.b();
            if (!TextUtils.isEmpty(strB)) {
                String str3 = strB + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f22734a == null) {
                    return;
                }
                e.f22780a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                this.f22734a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                f22733c = false;
            }
        }
        e.f22780a.a(i10, Thread.currentThread(), System.currentTimeMillis(), str, str2, th2);
        if (d.a.a(c.f22763b, i10)) {
            a aVar = this.f22734a;
            if (aVar == null) {
                return;
            } else {
                aVar.a(i10, Thread.currentThread(), System.currentTimeMillis(), str, str2, th2);
            }
        }
        Tracer tracer = this.f22735b;
        if (tracer != null) {
            try {
                tracer.a(i10, Thread.currentThread(), System.currentTimeMillis(), str, a(str2), th2);
            } catch (Exception unused) {
            }
        }
    }

    public void b() {
        a aVar = this.f22734a;
        if (aVar != null) {
            aVar.a();
            this.f22734a.b();
            this.f22734a = null;
        }
    }

    public void c() {
        a aVar = this.f22734a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.f22735b = tracer;
    }

    public static final void d(String str, String str2, Throwable th2) {
        getInstance().a(2, str, str2, th2);
    }

    public static final void e(String str, String str2, Throwable th2) {
        getInstance().a(16, str, str2, th2);
    }

    public static final void i(String str, String str2, Throwable th2) {
        getInstance().a(4, str, str2, th2);
    }

    public static final void u(String str, String str2, Throwable th2) {
        getInstance().a(32, str, str2, th2);
    }

    public static final void v(String str, String str2, Throwable th2) {
        getInstance().a(1, str, str2, th2);
    }

    public static final void w(String str, String str2, Throwable th2) {
        getInstance().a(8, str, str2, th2);
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? "" : d.a(str) ? "xxxxxx" : str;
    }

    public static File a() {
        String str = c.f22765d;
        try {
            d.c cVarB = d.b.b();
            if (cVarB != null && cVarB.c() > c.f22767f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(com.tencent.open.utils.f.c(), str);
        } catch (Throwable th2) {
            e(TAG, "getLogFilePath:", th2);
            return null;
        }
    }
}
