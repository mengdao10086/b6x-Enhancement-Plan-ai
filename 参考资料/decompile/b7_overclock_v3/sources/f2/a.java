package f2;

import android.annotation.SuppressLint;
import android.os.Trace;
import g.n0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27924a = "Trace";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f27925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f27926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f27927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f27928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f27929f;

    @SuppressLint({"NewApi"})
    public static void a(@n0 String str, int i10) {
        try {
            if (f27927d == null) {
                c.a(str, i10);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        b(str, i10);
    }

    public static void b(@n0 String str, int i10) {
        try {
            if (f27927d == null) {
                f27927d = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f27927d.invoke(null, Long.valueOf(f27925b), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            g("asyncTraceBegin", e10);
        }
    }

    public static void c(@n0 String str) {
        b.a(str);
    }

    @SuppressLint({"NewApi"})
    public static void d(@n0 String str, int i10) {
        try {
            if (f27928e == null) {
                c.b(str, i10);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        e(str, i10);
    }

    public static void e(@n0 String str, int i10) {
        try {
            if (f27928e == null) {
                f27928e = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f27928e.invoke(null, Long.valueOf(f27925b), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            g("asyncTraceEnd", e10);
        }
    }

    public static void f() {
        b.b();
    }

    public static void g(@n0 String str, @n0 Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to call ");
        sb2.append(str);
        sb2.append(" via reflection");
    }

    @SuppressLint({"NewApi"})
    public static boolean h() {
        try {
            if (f27926c == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return i();
    }

    public static boolean i() {
        try {
            if (f27926c == null) {
                f27925b = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f27926c = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f27926c.invoke(null, Long.valueOf(f27925b))).booleanValue();
        } catch (Exception e10) {
            g("isTagEnabled", e10);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void j(@n0 String str, int i10) {
        try {
            if (f27929f == null) {
                c.c(str, i10);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        k(str, i10);
    }

    public static void k(@n0 String str, int i10) {
        try {
            if (f27929f == null) {
                f27929f = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            f27929f.invoke(null, Long.valueOf(f27925b), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            g("traceCounter", e10);
        }
    }
}
