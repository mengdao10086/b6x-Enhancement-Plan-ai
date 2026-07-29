package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import g.i1;
import g.n0;
import g.v0;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f8759d = 30000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"MinMaxConstant"})
    public static final long f8760e = 18000000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"MinMaxConstant"})
    public static final long f8761f = 10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public UUID f8762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public r f8763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public Set<String> f8764c;

    public static abstract class a<B extends a<?, ?>, W extends x> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public r f8767c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Class<? extends ListenableWorker> f8769e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8765a = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Set<String> f8768d = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public UUID f8766b = UUID.randomUUID();

        public a(@n0 Class<? extends ListenableWorker> workerClass) {
            this.f8769e = workerClass;
            this.f8767c = new r(this.f8766b.toString(), workerClass.getName());
            a(workerClass.getName());
        }

        @n0
        public final B a(@n0 String str) {
            this.f8768d.add(str);
            return (B) d();
        }

        @n0
        public final W b() {
            W w10 = (W) c();
            b bVar = this.f8767c.f51850j;
            int i10 = Build.VERSION.SDK_INT;
            boolean z10 = (i10 >= 24 && bVar.e()) || bVar.f() || bVar.g() || (i10 >= 23 && bVar.h());
            r rVar = this.f8767c;
            if (rVar.f51857q) {
                if (z10) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (rVar.f51847g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.f8766b = UUID.randomUUID();
            r rVar2 = new r(this.f8767c);
            this.f8767c = rVar2;
            rVar2.f51841a = this.f8766b.toString();
            return w10;
        }

        @n0
        public abstract W c();

        @n0
        public abstract B d();

        @n0
        public final B e(long j10, @n0 TimeUnit timeUnit) {
            this.f8767c.f51855o = timeUnit.toMillis(j10);
            return (B) d();
        }

        @n0
        @v0(26)
        public final B f(@n0 Duration duration) {
            this.f8767c.f51855o = duration.toMillis();
            return (B) d();
        }

        @n0
        public final B g(@n0 BackoffPolicy backoffPolicy, long j10, @n0 TimeUnit timeUnit) {
            this.f8765a = true;
            r rVar = this.f8767c;
            rVar.f51852l = backoffPolicy;
            rVar.e(timeUnit.toMillis(j10));
            return (B) d();
        }

        @n0
        @v0(26)
        public final B h(@n0 BackoffPolicy backoffPolicy, @n0 Duration duration) {
            this.f8765a = true;
            r rVar = this.f8767c;
            rVar.f51852l = backoffPolicy;
            rVar.e(duration.toMillis());
            return (B) d();
        }

        @n0
        public final B i(@n0 b bVar) {
            this.f8767c.f51850j = bVar;
            return (B) d();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @n0
        public B j(@n0 OutOfQuotaPolicy outOfQuotaPolicy) {
            r rVar = this.f8767c;
            rVar.f51857q = true;
            rVar.f51858r = outOfQuotaPolicy;
            return (B) d();
        }

        @n0
        public B k(long j10, @n0 TimeUnit timeUnit) {
            this.f8767c.f51847g = timeUnit.toMillis(j10);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f8767c.f51847g) {
                return (B) d();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @n0
        @v0(26)
        public B l(@n0 Duration duration) {
            this.f8767c.f51847g = duration.toMillis();
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f8767c.f51847g) {
                return (B) d();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @i1
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public final B m(int i10) {
            this.f8767c.f51851k = i10;
            return (B) d();
        }

        @i1
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public final B n(@n0 WorkInfo.State state) {
            this.f8767c.f51842b = state;
            return (B) d();
        }

        @n0
        public final B o(@n0 d dVar) {
            this.f8767c.f51845e = dVar;
            return (B) d();
        }

        @i1
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public final B p(long j10, @n0 TimeUnit timeUnit) {
            this.f8767c.f51854n = timeUnit.toMillis(j10);
            return (B) d();
        }

        @i1
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public final B q(long j10, @n0 TimeUnit timeUnit) {
            this.f8767c.f51856p = timeUnit.toMillis(j10);
            return (B) d();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public x(@n0 UUID id2, @n0 r workSpec, @n0 Set<String> tags) {
        this.f8762a = id2;
        this.f8763b = workSpec;
        this.f8764c = tags;
    }

    @n0
    public UUID a() {
        return this.f8762a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public String b() {
        return this.f8762a.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public Set<String> c() {
        return this.f8764c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public r d() {
        return this.f8763b;
    }
}
