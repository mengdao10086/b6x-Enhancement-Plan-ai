package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import g.f0;
import g.k0;
import g.n0;
import g.p0;
import g.v0;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ListenableWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public Context f8279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public WorkerParameters f8280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f8281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8283e;

    public static abstract class a {

        /* JADX INFO: renamed from: androidx.work.ListenableWorker$a$a, reason: collision with other inner class name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class C0079a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final d f8284a;

            public C0079a() {
                this(d.f8360c);
            }

            @Override // androidx.work.ListenableWorker.a
            @n0
            public d c() {
                return this.f8284a;
            }

            public boolean equals(Object o10) {
                if (this == o10) {
                    return true;
                }
                if (o10 == null || C0079a.class != o10.getClass()) {
                    return false;
                }
                return this.f8284a.equals(((C0079a) o10).f8284a);
            }

            public int hashCode() {
                return (C0079a.class.getName().hashCode() * 31) + this.f8284a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f8284a + '}';
            }

            public C0079a(@n0 d outputData) {
                this.f8284a = outputData;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class b extends a {
            @Override // androidx.work.ListenableWorker.a
            @n0
            public d c() {
                return d.f8360c;
            }

            public boolean equals(Object o10) {
                if (this == o10) {
                    return true;
                }
                return o10 != null && b.class == o10.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final d f8285a;

            public c() {
                this(d.f8360c);
            }

            @Override // androidx.work.ListenableWorker.a
            @n0
            public d c() {
                return this.f8285a;
            }

            public boolean equals(Object o10) {
                if (this == o10) {
                    return true;
                }
                if (o10 == null || c.class != o10.getClass()) {
                    return false;
                }
                return this.f8285a.equals(((c) o10).f8285a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f8285a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f8285a + '}';
            }

            public c(@n0 d outputData) {
                this.f8285a = outputData;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public a() {
        }

        @n0
        public static a a() {
            return new C0079a();
        }

        @n0
        public static a b(@n0 d outputData) {
            return new C0079a(outputData);
        }

        @n0
        public static a d() {
            return new b();
        }

        @n0
        public static a e() {
            return new c();
        }

        @n0
        public static a f(@n0 d outputData) {
            return new c(outputData);
        }

        @n0
        public abstract d c();
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(@n0 Context appContext, @n0 WorkerParameters workerParams) {
        if (appContext == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParams == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.f8279a = appContext;
        this.f8280b = workerParams;
    }

    @n0
    public final Context a() {
        return this.f8279a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public Executor c() {
        return this.f8280b.a();
    }

    @n0
    public ListenableFuture<g> d() {
        androidx.work.impl.utils.futures.a aVarU = androidx.work.impl.utils.futures.a.u();
        aVarU.q(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return aVarU;
    }

    @n0
    public final UUID e() {
        return this.f8280b.c();
    }

    @n0
    public final d g() {
        return this.f8280b.d();
    }

    @p0
    @v0(28)
    public final Network h() {
        return this.f8280b.e();
    }

    @f0(from = 0)
    public final int i() {
        return this.f8280b.g();
    }

    @n0
    public final Set<String> j() {
        return this.f8280b.i();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public w2.a k() {
        return this.f8280b.j();
    }

    @n0
    @v0(24)
    public final List<String> l() {
        return this.f8280b.k();
    }

    @n0
    @v0(24)
    public final List<Uri> m() {
        return this.f8280b.l();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public y n() {
        return this.f8280b.m();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean o() {
        return this.f8283e;
    }

    public final boolean p() {
        return this.f8281c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean q() {
        return this.f8282d;
    }

    public void r() {
    }

    @n0
    public final ListenableFuture<Void> s(@n0 g foregroundInfo) {
        this.f8283e = true;
        return this.f8280b.b().a(a(), e(), foregroundInfo);
    }

    @n0
    public ListenableFuture<Void> t(@n0 d data) {
        return this.f8280b.f().a(a(), e(), data);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void u(boolean runInForeground) {
        this.f8283e = runInForeground;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void v() {
        this.f8282d = true;
    }

    @k0
    @n0
    public abstract ListenableFuture<a> w();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void x() {
        this.f8281c = true;
        r();
    }
}
