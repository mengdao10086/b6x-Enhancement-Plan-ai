package s0;

import android.annotation.SuppressLint;
import android.location.LocationRequest;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.core.util.g0;
import g.f0;
import g.n0;
import g.p0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f49303h = Long.MAX_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f49304i = 100;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f49305j = 102;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f49306k = 104;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f49307l = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f49309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f49310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f49311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f49312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f49313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f49314g;

    @v0(19)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Class<?> f49315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f49316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Method f49317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static Method f49318d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Method f49319e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static Method f49320f;

        public static Object a(c0 c0Var, String str) {
            try {
                if (f49315a == null) {
                    f49315a = Class.forName("android.location.LocationRequest");
                }
                if (f49316b == null) {
                    Method declaredMethod = f49315a.getDeclaredMethod("createFromDeprecatedProvider", String.class, Long.TYPE, Float.TYPE, Boolean.TYPE);
                    f49316b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object objInvoke = f49316b.invoke(null, str, Long.valueOf(c0Var.b()), Float.valueOf(c0Var.e()), Boolean.FALSE);
                if (objInvoke == null) {
                    return null;
                }
                if (f49317c == null) {
                    Method declaredMethod2 = f49315a.getDeclaredMethod("setQuality", Integer.TYPE);
                    f49317c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                f49317c.invoke(objInvoke, Integer.valueOf(c0Var.g()));
                if (f49318d == null) {
                    Method declaredMethod3 = f49315a.getDeclaredMethod("setFastestInterval", Long.TYPE);
                    f49318d = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                f49318d.invoke(objInvoke, Long.valueOf(c0Var.f()));
                if (c0Var.d() < Integer.MAX_VALUE) {
                    if (f49319e == null) {
                        Method declaredMethod4 = f49315a.getDeclaredMethod("setNumUpdates", Integer.TYPE);
                        f49319e = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    f49319e.invoke(objInvoke, Integer.valueOf(c0Var.d()));
                }
                if (c0Var.a() < Long.MAX_VALUE) {
                    if (f49320f == null) {
                        Method declaredMethod5 = f49315a.getDeclaredMethod("setExpireIn", Long.TYPE);
                        f49320f = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    f49320f.invoke(objInvoke, Long.valueOf(c0Var.a()));
                }
                return objInvoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    @v0(31)
    public static class b {
        @g.u
        public static LocationRequest a(c0 c0Var) {
            return new LocationRequest.Builder(c0Var.b()).setQuality(c0Var.g()).setMinUpdateIntervalMillis(c0Var.f()).setDurationMillis(c0Var.a()).setMaxUpdates(c0Var.d()).setMinUpdateDistanceMeters(c0Var.e()).setMaxUpdateDelayMillis(c0Var.c()).build();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface d {
    }

    public c0(long j10, int i10, long j11, int i11, long j12, float f10, long j13) {
        this.f49309b = j10;
        this.f49308a = i10;
        this.f49310c = j12;
        this.f49311d = j11;
        this.f49312e = i11;
        this.f49313f = f10;
        this.f49314g = j13;
    }

    @f0(from = 1)
    public long a() {
        return this.f49311d;
    }

    @f0(from = 0)
    public long b() {
        return this.f49309b;
    }

    @f0(from = 0)
    public long c() {
        return this.f49314g;
    }

    @f0(from = 1, to = 2147483647L)
    public int d() {
        return this.f49312e;
    }

    @g.x(from = 0.0d, to = 3.4028234663852886E38d)
    public float e() {
        return this.f49313f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f49308a == c0Var.f49308a && this.f49309b == c0Var.f49309b && this.f49310c == c0Var.f49310c && this.f49311d == c0Var.f49311d && this.f49312e == c0Var.f49312e && Float.compare(c0Var.f49313f, this.f49313f) == 0 && this.f49314g == c0Var.f49314g;
    }

    @f0(from = 0)
    public long f() {
        long j10 = this.f49310c;
        return j10 == -1 ? this.f49309b : j10;
    }

    public int g() {
        return this.f49308a;
    }

    @n0
    @v0(31)
    public LocationRequest h() {
        return b.a(this);
    }

    public int hashCode() {
        int i10 = this.f49308a * 31;
        long j10 = this.f49309b;
        int i11 = (i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f49310c;
        return i11 + ((int) (j11 ^ (j11 >>> 32)));
    }

    @p0
    @SuppressLint({"NewApi"})
    @v0(19)
    public LocationRequest i(@n0 String str) {
        return Build.VERSION.SDK_INT >= 31 ? h() : (LocationRequest) a.a(this, str);
    }

    @n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request[");
        if (this.f49309b != Long.MAX_VALUE) {
            sb2.append("@");
            g0.e(this.f49309b, sb2);
            int i10 = this.f49308a;
            if (i10 == 100) {
                sb2.append(" HIGH_ACCURACY");
            } else if (i10 == 102) {
                sb2.append(" BALANCED");
            } else if (i10 == 104) {
                sb2.append(" LOW_POWER");
            }
        } else {
            sb2.append("PASSIVE");
        }
        if (this.f49311d != Long.MAX_VALUE) {
            sb2.append(", duration=");
            g0.e(this.f49311d, sb2);
        }
        if (this.f49312e != Integer.MAX_VALUE) {
            sb2.append(", maxUpdates=");
            sb2.append(this.f49312e);
        }
        long j10 = this.f49310c;
        if (j10 != -1 && j10 < this.f49309b) {
            sb2.append(", minUpdateInterval=");
            g0.e(this.f49310c, sb2);
        }
        if (this.f49313f > 0.0d) {
            sb2.append(", minUpdateDistance=");
            sb2.append(this.f49313f);
        }
        if (this.f49314g / 2 > this.f49309b) {
            sb2.append(", maxUpdateDelay=");
            g0.e(this.f49314g, sb2);
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f49321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f49322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f49323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f49324d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f49325e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f49326f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f49327g;

        public c(long j10) {
            d(j10);
            this.f49322b = 102;
            this.f49323c = Long.MAX_VALUE;
            this.f49324d = Integer.MAX_VALUE;
            this.f49325e = -1L;
            this.f49326f = 0.0f;
            this.f49327g = 0L;
        }

        @n0
        public c0 a() {
            androidx.core.util.o.o((this.f49321a == Long.MAX_VALUE && this.f49325e == -1) ? false : true, "passive location requests must have an explicit minimum update interval");
            long j10 = this.f49321a;
            return new c0(j10, this.f49322b, this.f49323c, this.f49324d, Math.min(this.f49325e, j10), this.f49326f, this.f49327g);
        }

        @n0
        public c b() {
            this.f49325e = -1L;
            return this;
        }

        @n0
        public c c(@f0(from = 1) long j10) {
            this.f49323c = androidx.core.util.o.h(j10, 1L, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        @n0
        public c d(@f0(from = 0) long j10) {
            this.f49321a = androidx.core.util.o.h(j10, 0L, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        @n0
        public c e(@f0(from = 0) long j10) {
            this.f49327g = j10;
            this.f49327g = androidx.core.util.o.h(j10, 0L, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        @n0
        public c f(@f0(from = 1, to = 2147483647L) int i10) {
            this.f49324d = androidx.core.util.o.g(i10, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        @n0
        public c g(@g.x(from = 0.0d, to = 3.4028234663852886E38d) float f10) {
            this.f49326f = f10;
            this.f49326f = androidx.core.util.o.f(f10, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        @n0
        public c h(@f0(from = 0) long j10) {
            this.f49325e = androidx.core.util.o.h(j10, 0L, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        @n0
        public c i(int i10) {
            androidx.core.util.o.c(i10 == 104 || i10 == 102 || i10 == 100, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i10));
            this.f49322b = i10;
            return this;
        }

        public c(@n0 c0 c0Var) {
            this.f49321a = c0Var.f49309b;
            this.f49322b = c0Var.f49308a;
            this.f49323c = c0Var.f49311d;
            this.f49324d = c0Var.f49312e;
            this.f49325e = c0Var.f49310c;
            this.f49326f = c0Var.f49313f;
            this.f49327g = c0Var.f49314g;
        }
    }
}
