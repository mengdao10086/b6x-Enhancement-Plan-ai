package s0;

import android.annotation.SuppressLint;
import android.location.GnssStatus;
import android.location.GpsStatus;
import androidx.annotation.RestrictTo;
import g.f0;
import g.n0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f49272a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f49273b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f49274c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f49275d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f49276e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f49277f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f49278g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f49279h = 7;

    /* JADX INFO: renamed from: s0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0563a {
        public void a(@f0(from = 0) int i10) {
        }

        public void b(@n0 a aVar) {
        }

        public void c() {
        }

        public void d() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface b {
    }

    @n0
    @v0(24)
    public static a n(@n0 GnssStatus gnssStatus) {
        return new s0.b(gnssStatus);
    }

    @SuppressLint({"ReferencesDeprecated"})
    @n0
    public static a o(@n0 GpsStatus gpsStatus) {
        return new c(gpsStatus);
    }

    @g.x(from = 0.0d, to = 360.0d)
    public abstract float a(@f0(from = 0) int i10);

    @g.x(from = 0.0d, to = 63.0d)
    public abstract float b(@f0(from = 0) int i10);

    @g.x(from = 0.0d)
    public abstract float c(@f0(from = 0) int i10);

    @g.x(from = 0.0d, to = 63.0d)
    public abstract float d(@f0(from = 0) int i10);

    public abstract int e(@f0(from = 0) int i10);

    @g.x(from = -90.0d, to = 90.0d)
    public abstract float f(@f0(from = 0) int i10);

    @f0(from = 0)
    public abstract int g();

    @f0(from = 1, to = 200)
    public abstract int h(@f0(from = 0) int i10);

    public abstract boolean i(@f0(from = 0) int i10);

    public abstract boolean j(@f0(from = 0) int i10);

    public abstract boolean k(@f0(from = 0) int i10);

    public abstract boolean l(@f0(from = 0) int i10);

    public abstract boolean m(@f0(from = 0) int i10);
}
