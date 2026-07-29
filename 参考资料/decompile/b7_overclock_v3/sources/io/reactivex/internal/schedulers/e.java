package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends h0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f35174e = "RxCachedThreadScheduler";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RxThreadFactory f35175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f35176g = "RxCachedWorkerPoolEvictor";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final RxThreadFactory f35177h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f35179j = 60;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f35182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f35183n = "rx2.io-priority";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f35184o = "rx2.io-scheduled-release";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f35185p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f35186q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f35187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<a> f35188d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final TimeUnit f35181l = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f35178i = "rx2.io-keep-alive-time";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f35180k = Long.getLong(f35178i, 60).longValue();

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f35189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f35190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final io.reactivex.disposables.a f35191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ScheduledExecutorService f35192d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Future<?> f35193e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ThreadFactory f35194f;

        public a(long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j10) : 0L;
            this.f35189a = nanos;
            this.f35190b = new ConcurrentLinkedQueue<>();
            this.f35191c = new io.reactivex.disposables.a();
            this.f35194f = threadFactory;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, e.f35177h);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f35192d = scheduledExecutorServiceNewScheduledThreadPool;
            this.f35193e = scheduledFutureScheduleWithFixedDelay;
        }

        public void a() {
            if (this.f35190b.isEmpty()) {
                return;
            }
            long jC = c();
            for (c cVar : this.f35190b) {
                if (cVar.i() > jC) {
                    return;
                }
                if (this.f35190b.remove(cVar)) {
                    this.f35191c.a(cVar);
                }
            }
        }

        public c b() {
            if (this.f35191c.isDisposed()) {
                return e.f35182m;
            }
            while (!this.f35190b.isEmpty()) {
                c cVarPoll = this.f35190b.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(this.f35194f);
            this.f35191c.b(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.j(c() + this.f35189a);
            this.f35190b.offer(cVar);
        }

        public void e() {
            this.f35191c.dispose();
            Future<?> future = this.f35193e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f35192d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    public static final class b extends h0.c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f35196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f35197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f35198d = new AtomicBoolean();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.disposables.a f35195a = new io.reactivex.disposables.a();

        public b(a aVar) {
            this.f35196b = aVar;
            this.f35197c = aVar.b();
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b c(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit) {
            return this.f35195a.isDisposed() ? EmptyDisposable.INSTANCE : this.f35197c.e(runnable, j10, timeUnit, this.f35195a);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f35198d.compareAndSet(false, true)) {
                this.f35195a.dispose();
                if (e.f35185p) {
                    this.f35197c.e(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.f35196b.d(this.f35197c);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35198d.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f35196b.d(this.f35197c);
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f35199c;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f35199c = 0L;
        }

        public long i() {
            return this.f35199c;
        }

        public void j(long j10) {
            this.f35199c = j10;
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f35182m = cVar;
        cVar.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger(f35183n, 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory(f35174e, iMax);
        f35175f = rxThreadFactory;
        f35177h = new RxThreadFactory(f35176g, iMax);
        f35185p = Boolean.getBoolean(f35184o);
        a aVar = new a(0L, null, rxThreadFactory);
        f35186q = aVar;
        aVar.e();
    }

    public e() {
        this(f35175f);
    }

    @Override // xi.h0
    @bj.e
    public h0.c d() {
        return new b(this.f35188d.get());
    }

    @Override // xi.h0
    public void i() {
        a aVar;
        a aVar2;
        do {
            aVar = this.f35188d.get();
            aVar2 = f35186q;
            if (aVar == aVar2) {
                return;
            }
        } while (!this.f35188d.compareAndSet(aVar, aVar2));
        aVar.e();
    }

    @Override // xi.h0
    public void j() {
        a aVar = new a(f35180k, f35181l, this.f35187c);
        if (this.f35188d.compareAndSet(f35186q, aVar)) {
            return;
        }
        aVar.e();
    }

    public int l() {
        return this.f35188d.get().f35191c.g();
    }

    public e(ThreadFactory threadFactory) {
        this.f35187c = threadFactory;
        this.f35188d = new AtomicReference<>(f35186q);
        j();
    }
}
