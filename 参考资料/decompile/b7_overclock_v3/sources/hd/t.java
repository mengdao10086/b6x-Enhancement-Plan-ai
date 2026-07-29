package hd;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31143a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31144b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31145c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f31146d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f31147e = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f31148f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f31149g = true;

    @Pure
    public static String a(String str, @g.p0 Throwable th2) {
        String strH = h(th2);
        if (TextUtils.isEmpty(strH)) {
            return str;
        }
        return str + "\n  " + strH.replace("\n", "\n  ") + '\n';
    }

    @Pure
    public static void b(String str, String str2) {
    }

    @Pure
    public static void c(String str, String str2, @g.p0 Throwable th2) {
        b(str, a(str2, th2));
    }

    @Pure
    public static void d(String str, String str2) {
    }

    @Pure
    public static void e(String str, String str2, @g.p0 Throwable th2) {
        d(str, a(str2, th2));
    }

    @Pure
    public static int f() {
        return f31148f;
    }

    @g.p0
    @Pure
    public static String h(@g.p0 Throwable th2) {
        if (th2 == null) {
            return null;
        }
        return k(th2) ? "UnknownHostException (no network)" : !f31149g ? th2.getMessage() : Log.getStackTraceString(th2).trim().replace("\t", wn.a.f54751a);
    }

    @Pure
    public static void i(String str, String str2) {
    }

    @Pure
    public static void j(String str, String str2, @g.p0 Throwable th2) {
        i(str, a(str2, th2));
    }

    @Pure
    public static boolean k(@g.p0 Throwable th2) {
        while (th2 != null) {
            if (th2 instanceof UnknownHostException) {
                return true;
            }
            th2 = th2.getCause();
        }
        return false;
    }

    public static void l(int i10) {
        f31148f = i10;
    }

    public static void m(boolean z10) {
        f31149g = z10;
    }

    @Pure
    public static void n(String str, String str2) {
    }

    @Pure
    public static void o(String str, String str2, @g.p0 Throwable th2) {
        n(str, a(str2, th2));
    }

    @Pure
    public boolean g() {
        return f31149g;
    }
}
