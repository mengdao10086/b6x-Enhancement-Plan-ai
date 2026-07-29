package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import g.n0;
import g.v0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4682a = "TraceCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f4683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f4684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f4685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f4686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f4687f;

    @v0(18)
    public static class a {
        @g.u
        public static void a(String str) {
            Trace.beginSection(str);
        }

        @g.u
        public static void b() {
            Trace.endSection();
        }
    }

    @v0(29)
    public static class b {
        @g.u
        public static void a(String str, int i10) {
            Trace.beginAsyncSection(str, i10);
        }

        @g.u
        public static void b(String str, int i10) {
            Trace.endAsyncSection(str, i10);
        }

        @g.u
        public static boolean c() {
            return Trace.isEnabled();
        }

        @g.u
        public static void d(String str, long j10) {
            Trace.setCounter(str, j10);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f4683b = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f4684c = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f4685d = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f4686e = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f4687f = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(@n0 String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.a(str, i10);
        } else {
            try {
                f4685d.invoke(null, Long.valueOf(f4683b), str, Integer.valueOf(i10));
            } catch (Exception unused) {
            }
        }
    }

    public static void b(@n0 String str) {
        a.a(str);
    }

    public static void c(@n0 String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.b(str, i10);
        } else {
            try {
                f4686e.invoke(null, Long.valueOf(f4683b), str, Integer.valueOf(i10));
            } catch (Exception unused) {
            }
        }
    }

    public static void d() {
        a.b();
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT >= 29) {
            return b.c();
        }
        try {
            return ((Boolean) f4684c.invoke(null, Long.valueOf(f4683b))).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void f(@n0 String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.d(str, i10);
        } else {
            try {
                f4687f.invoke(null, Long.valueOf(f4683b), str, Integer.valueOf(i10));
            } catch (Exception unused) {
            }
        }
    }
}
