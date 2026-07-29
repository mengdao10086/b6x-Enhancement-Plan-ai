package fi;

import android.util.Log;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28514a = "SourceFile";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f28515b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f28516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f28517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f28518e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
        public static final int I1 = 2;
        public static final int J1 = 3;
        public static final int K1 = 4;
        public static final int L1 = 5;
        public static final int M1 = 6;
        public static final int N1 = 10;
    }

    public static String a(String str) {
        if (!f28516c) {
            return str;
        }
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[3];
        return f28517d ? String.format("[%s:%s] %s", stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()), str) : String.format("[%s] %s", stackTraceElement.getMethodName(), str);
    }

    public static void b(String str, Object... objArr) {
        if (i()) {
            f();
            e(str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        if (j()) {
            f();
            e(str, objArr);
        }
    }

    public static void d(Throwable th2, String str, Object... objArr) {
        if (j()) {
            f();
            e(str, objArr);
        }
    }

    public static String e(String str, Object... objArr) {
        if (objArr == null || objArr.length != 0) {
            str = String.format(str, objArr);
        }
        return a(str);
    }

    public static String f() {
        String str = f28518e;
        if (str != null) {
            return str;
        }
        String fileName = new Throwable().getStackTrace()[2].getFileName();
        return fileName == null ? f28514a : fileName.split("[.]")[0];
    }

    public static void g(String str, Object... objArr) {
        if (k()) {
            f();
            e(str, objArr);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (k()) {
            e(str2, objArr);
        }
    }

    public static boolean i() {
        return f28515b <= 3;
    }

    public static boolean j() {
        return f28515b <= 6;
    }

    public static boolean k() {
        return f28515b <= 4;
    }

    public static boolean l() {
        return f28515b <= 2;
    }

    public static boolean m() {
        return f28515b <= 5;
    }

    public static void n(boolean z10, boolean z11) {
        f28516c = z10;
        f28517d = z11;
    }

    public static void o(int i10) {
        f28515b = i10;
    }

    public static void p(@p0 String str) {
        f28518e = str;
    }

    public static void q(String str, Object... objArr) {
        if (l()) {
            f();
            e(str, objArr);
        }
    }

    public static void r(String str, Object... objArr) {
        if (m()) {
            f();
            e(str, objArr);
        }
    }

    public static void s(Throwable th2, String str, Object... objArr) {
        if (m()) {
            f();
            e(str, objArr);
        }
    }

    public static void t(String str, Object... objArr) {
        if (j()) {
            Log.wtf(f(), e(str, objArr));
        }
    }

    public static void u(Throwable th2, String str, Object... objArr) {
        if (j()) {
            Log.wtf(f(), e(str, objArr), th2);
        }
    }
}
