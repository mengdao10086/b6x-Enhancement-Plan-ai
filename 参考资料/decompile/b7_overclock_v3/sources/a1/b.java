package a1;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.RestrictTo;
import g.n0;
import g.u;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final int A = 128;
    public static final int B = 256;
    public static final int C = 512;
    public static final int D = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f36a = 128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f37b = 256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f38c = 512;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f39d = 1024;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f40e = 2048;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final int f41f = 4096;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final int f42g = 8192;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f43h = 16384;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f44i = 32768;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f45j = 65536;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f46k = 131072;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f47l = 262144;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f48m = 524288;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f49n = 1048576;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f50o = 2097152;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f51p = 4194304;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f52q = 8388608;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f53r = 16777216;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f54s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f55t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f56u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f57v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f58w = 8;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f59x = 16;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f60y = 32;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f61z = 64;

    @v0(16)
    public static class a {
        @u
        public static int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getAction();
        }

        @u
        public static int b(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getMovementGranularity();
        }

        @u
        public static void c(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setAction(i10);
        }

        @u
        public static void d(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setMovementGranularity(i10);
        }
    }

    /* JADX INFO: renamed from: a1.b$b, reason: collision with other inner class name */
    @v0(19)
    public static class C0004b {
        @u
        public static int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        @u
        public static void b(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setContentChangeTypes(i10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    @Deprecated
    public static void a(AccessibilityEvent accessibilityEvent, f fVar) {
        accessibilityEvent.appendRecord((AccessibilityRecord) fVar.g());
    }

    @Deprecated
    public static f b(AccessibilityEvent accessibilityEvent) {
        return new f(accessibilityEvent);
    }

    public static int c(@n0 AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }

    public static int d(@n0 AccessibilityEvent accessibilityEvent) {
        return C0004b.a(accessibilityEvent);
    }

    public static int e(@n0 AccessibilityEvent accessibilityEvent) {
        return a.b(accessibilityEvent);
    }

    @Deprecated
    public static f f(AccessibilityEvent accessibilityEvent, int i10) {
        return new f(accessibilityEvent.getRecord(i10));
    }

    @Deprecated
    public static int g(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getRecordCount();
    }

    public static void h(@n0 AccessibilityEvent accessibilityEvent, int i10) {
        a.c(accessibilityEvent, i10);
    }

    public static void i(@n0 AccessibilityEvent accessibilityEvent, int i10) {
        C0004b.b(accessibilityEvent, i10);
    }

    public static void j(@n0 AccessibilityEvent accessibilityEvent, int i10) {
        a.d(accessibilityEvent, i10);
    }
}
