package xi;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f55337a = Boolean.getBoolean("rx2.scheduler.use-nanotime");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f55338b = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public static final class a implements io.reactivex.disposables.b, Runnable, lj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @bj.e
        public final Runnable f55339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @bj.e
        public final c f55340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @bj.f
        public Thread f55341c;

        public a(@bj.e Runnable runnable, @bj.e c cVar) {
            this.f55339a = runnable;
            this.f55340b = cVar;
        }

        @Override // lj.a
        public Runnable a() {
            return this.f55339a;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f55341c == Thread.currentThread()) {
                c cVar = this.f55340b;
                if (cVar instanceof io.reactivex.internal.schedulers.g) {
                    ((io.reactivex.internal.schedulers.g) cVar).h();
                    return;
                }
            }
            this.f55340b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f55340b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f55341c = Thread.currentThread();
            try {
                this.f55339a.run();
            } finally {
                dispose();
                this.f55341c = null;
            }
        }
    }

    public static final class b implements io.reactivex.disposables.b, Runnable, lj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @bj.e
        public final Runnable f55342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @bj.e
        public final c f55343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f55344c;

        public b(@bj.e Runnable runnable, @bj.e c cVar) {
            this.f55342a = runnable;
            this.f55343b = cVar;
        }

        @Override // lj.a
        public Runnable a() {
            return this.f55342a;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f55344c = true;
            this.f55343b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f55344c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f55344c) {
                return;
            }
            try {
                this.f55342a.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f55343b.dispose();
                throw ExceptionHelper.f(th2);
            }
        }
    }

    public static abstract class c implements io.reactivex.disposables.b {

        public final class a implements Runnable, lj.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @bj.e
            public final Runnable f55345a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @bj.e
            public final SequentialDisposable f55346b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f55347c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f55348d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public long f55349e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public long f55350f;

            public a(long j10, @bj.e Runnable runnable, long j11, @bj.e SequentialDisposable sequentialDisposable, long j12) {
                this.f55345a = runnable;
                this.f55346b = sequentialDisposable;
                this.f55347c = j12;
                this.f55349e = j11;
                this.f55350f = j10;
            }

            @Override // lj.a
            public Runnable a() {
                return this.f55345a;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r12 = this;
                    java.lang.Runnable r0 = r12.f55345a
                    r0.run()
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r12.f55346b
                    boolean r0 = r0.isDisposed()
                    if (r0 != 0) goto L53
                    xi.h0$c r0 = xi.h0.c.this
                    java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
                    long r2 = r0.a(r1)
                    long r4 = xi.h0.f55338b
                    long r6 = r2 + r4
                    long r8 = r12.f55349e
                    r10 = 1
                    int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r0 < 0) goto L35
                    long r6 = r12.f55347c
                    long r8 = r8 + r6
                    long r8 = r8 + r4
                    int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                    if (r0 < 0) goto L2a
                    goto L35
                L2a:
                    long r4 = r12.f55350f
                    long r8 = r12.f55348d
                    long r8 = r8 + r10
                    r12.f55348d = r8
                    long r8 = r8 * r6
                    long r4 = r4 + r8
                    goto L45
                L35:
                    long r4 = r12.f55347c
                    long r6 = r2 + r4
                    long r8 = r12.f55348d
                    long r8 = r8 + r10
                    r12.f55348d = r8
                    long r4 = r4 * r8
                    long r4 = r6 - r4
                    r12.f55350f = r4
                    r4 = r6
                L45:
                    r12.f55349e = r2
                    long r4 = r4 - r2
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r12.f55346b
                    xi.h0$c r2 = xi.h0.c.this
                    io.reactivex.disposables.b r1 = r2.c(r12, r4, r1)
                    r0.a(r1)
                L53:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: xi.h0.c.a.run():void");
            }
        }

        public long a(@bj.e TimeUnit timeUnit) {
            return h0.c(timeUnit);
        }

        @bj.e
        public io.reactivex.disposables.b b(@bj.e Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        @bj.e
        public abstract io.reactivex.disposables.b c(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit);

        @bj.e
        public io.reactivex.disposables.b d(@bj.e Runnable runnable, long j10, long j11, @bj.e TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable runnableB0 = kj.a.b0(runnable);
            long nanos = timeUnit.toNanos(j11);
            long jA = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b bVarC = c(new a(jA + timeUnit.toNanos(j10), runnableB0, jA, sequentialDisposable2, nanos), j10, timeUnit);
            if (bVarC == EmptyDisposable.INSTANCE) {
                return bVarC;
            }
            sequentialDisposable.a(bVarC);
            return sequentialDisposable2;
        }
    }

    public static long b() {
        return f55338b;
    }

    public static long c(TimeUnit timeUnit) {
        return !f55337a ? timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @bj.e
    public abstract c d();

    public long e(@bj.e TimeUnit timeUnit) {
        return c(timeUnit);
    }

    @bj.e
    public io.reactivex.disposables.b f(@bj.e Runnable runnable) {
        return g(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @bj.e
    public io.reactivex.disposables.b g(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit) {
        c cVarD = d();
        a aVar = new a(kj.a.b0(runnable), cVarD);
        cVarD.c(aVar, j10, timeUnit);
        return aVar;
    }

    @bj.e
    public io.reactivex.disposables.b h(@bj.e Runnable runnable, long j10, long j11, @bj.e TimeUnit timeUnit) {
        c cVarD = d();
        b bVar = new b(kj.a.b0(runnable), cVarD);
        io.reactivex.disposables.b bVarD = cVarD.d(bVar, j10, j11, timeUnit);
        return bVarD == EmptyDisposable.INSTANCE ? bVarD : bVar;
    }

    public void i() {
    }

    public void j() {
    }

    @bj.e
    public <S extends h0 & io.reactivex.disposables.b> S k(@bj.e dj.o<j<j<xi.a>>, xi.a> oVar) {
        return new SchedulerWhen(oVar, this);
    }
}
