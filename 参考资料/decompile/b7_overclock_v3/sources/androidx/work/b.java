package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.room.j0;
import g.n0;
import g.p0;
import g.v0;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f8339i = new a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @j0(name = "required_network_type")
    public NetworkType f8340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j0(name = "requires_charging")
    public boolean f8341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @j0(name = "requires_device_idle")
    public boolean f8342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @j0(name = "requires_battery_not_low")
    public boolean f8343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @j0(name = "requires_storage_not_low")
    public boolean f8344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @j0(name = "trigger_content_update_delay")
    public long f8345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @j0(name = "trigger_max_content_delay")
    public long f8346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @j0(name = "content_uri_triggers")
    public c f8347h;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public b() {
        this.f8340a = NetworkType.NOT_REQUIRED;
        this.f8345f = -1L;
        this.f8346g = -1L;
        this.f8347h = new c();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    @v0(24)
    public c a() {
        return this.f8347h;
    }

    @n0
    public NetworkType b() {
        return this.f8340a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long c() {
        return this.f8345f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long d() {
        return this.f8346g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(24)
    public boolean e() {
        return this.f8347h.c() > 0;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || b.class != o10.getClass()) {
            return false;
        }
        b bVar = (b) o10;
        if (this.f8341b == bVar.f8341b && this.f8342c == bVar.f8342c && this.f8343d == bVar.f8343d && this.f8344e == bVar.f8344e && this.f8345f == bVar.f8345f && this.f8346g == bVar.f8346g && this.f8340a == bVar.f8340a) {
            return this.f8347h.equals(bVar.f8347h);
        }
        return false;
    }

    public boolean f() {
        return this.f8343d;
    }

    public boolean g() {
        return this.f8341b;
    }

    @v0(23)
    public boolean h() {
        return this.f8342c;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.f8340a.hashCode() * 31) + (this.f8341b ? 1 : 0)) * 31) + (this.f8342c ? 1 : 0)) * 31) + (this.f8343d ? 1 : 0)) * 31) + (this.f8344e ? 1 : 0)) * 31;
        long j10 = this.f8345f;
        int i10 = (iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f8346g;
        return ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f8347h.hashCode();
    }

    public boolean i() {
        return this.f8344e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(24)
    public void j(@p0 c mContentUriTriggers) {
        this.f8347h = mContentUriTriggers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void k(@n0 NetworkType requiredNetworkType) {
        this.f8340a = requiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void l(boolean requiresBatteryNotLow) {
        this.f8343d = requiresBatteryNotLow;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void m(boolean requiresCharging) {
        this.f8341b = requiresCharging;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public void n(boolean requiresDeviceIdle) {
        this.f8342c = requiresDeviceIdle;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void o(boolean requiresStorageNotLow) {
        this.f8344e = requiresStorageNotLow;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void p(long triggerContentUpdateDelay) {
        this.f8345f = triggerContentUpdateDelay;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void q(long triggerMaxContentDelay) {
        this.f8346g = triggerMaxContentDelay;
    }

    public b(a builder) {
        this.f8340a = NetworkType.NOT_REQUIRED;
        this.f8345f = -1L;
        this.f8346g = -1L;
        this.f8347h = new c();
        this.f8341b = builder.f8348a;
        int i10 = Build.VERSION.SDK_INT;
        this.f8342c = i10 >= 23 && builder.f8349b;
        this.f8340a = builder.f8350c;
        this.f8343d = builder.f8351d;
        this.f8344e = builder.f8352e;
        if (i10 >= 24) {
            this.f8347h = builder.f8355h;
            this.f8345f = builder.f8353f;
            this.f8346g = builder.f8354g;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public NetworkType f8350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8352e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8353f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f8354g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c f8355h;

        public a() {
            this.f8348a = false;
            this.f8349b = false;
            this.f8350c = NetworkType.NOT_REQUIRED;
            this.f8351d = false;
            this.f8352e = false;
            this.f8353f = -1L;
            this.f8354g = -1L;
            this.f8355h = new c();
        }

        @n0
        @v0(24)
        public a a(@n0 Uri uri, boolean triggerForDescendants) {
            this.f8355h.a(uri, triggerForDescendants);
            return this;
        }

        @n0
        public b b() {
            return new b(this);
        }

        @n0
        public a c(@n0 NetworkType networkType) {
            this.f8350c = networkType;
            return this;
        }

        @n0
        public a d(boolean requiresBatteryNotLow) {
            this.f8351d = requiresBatteryNotLow;
            return this;
        }

        @n0
        public a e(boolean requiresCharging) {
            this.f8348a = requiresCharging;
            return this;
        }

        @n0
        @v0(23)
        public a f(boolean requiresDeviceIdle) {
            this.f8349b = requiresDeviceIdle;
            return this;
        }

        @n0
        public a g(boolean requiresStorageNotLow) {
            this.f8352e = requiresStorageNotLow;
            return this;
        }

        @n0
        @v0(24)
        public a h(long duration, @n0 TimeUnit timeUnit) {
            this.f8354g = timeUnit.toMillis(duration);
            return this;
        }

        @n0
        @v0(26)
        public a i(Duration duration) {
            this.f8354g = duration.toMillis();
            return this;
        }

        @n0
        @v0(24)
        public a j(long duration, @n0 TimeUnit timeUnit) {
            this.f8353f = timeUnit.toMillis(duration);
            return this;
        }

        @n0
        @v0(26)
        public a k(Duration duration) {
            this.f8353f = duration.toMillis();
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public a(@n0 b constraints) {
            boolean z10 = false;
            this.f8348a = false;
            this.f8349b = false;
            this.f8350c = NetworkType.NOT_REQUIRED;
            this.f8351d = false;
            this.f8352e = false;
            this.f8353f = -1L;
            this.f8354g = -1L;
            this.f8355h = new c();
            this.f8348a = constraints.g();
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23 && constraints.h()) {
                z10 = true;
            }
            this.f8349b = z10;
            this.f8350c = constraints.b();
            this.f8351d = constraints.f();
            this.f8352e = constraints.i();
            if (i10 >= 24) {
                this.f8353f = constraints.c();
                this.f8354g = constraints.d();
                this.f8355h = constraints.a();
            }
        }
    }

    public b(@n0 b other) {
        this.f8340a = NetworkType.NOT_REQUIRED;
        this.f8345f = -1L;
        this.f8346g = -1L;
        this.f8347h = new c();
        this.f8341b = other.f8341b;
        this.f8342c = other.f8342c;
        this.f8340a = other.f8340a;
        this.f8343d = other.f8343d;
        this.f8344e = other.f8344e;
        this.f8347h = other.f8347h;
    }
}
