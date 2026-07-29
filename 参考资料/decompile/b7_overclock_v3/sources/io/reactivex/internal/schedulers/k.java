package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class k extends h0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f35212e = "rx2.single-priority";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f35213f = "RxSingleScheduler";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final RxThreadFactory f35214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ScheduledExecutorService f35215h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f35216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService> f35217d;

    public static final class a extends h0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f35218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.disposables.a f35219b = new io.reactivex.disposables.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f35220c;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.f35218a = scheduledExecutorService;
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b c(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit) {
            if (this.f35220c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(kj.a.b0(runnable), this.f35219b);
            this.f35219b.b(scheduledRunnable);
            try {
                scheduledRunnable.a(j10 <= 0 ? this.f35218a.submit((Callable) scheduledRunnable) : this.f35218a.schedule((Callable) scheduledRunnable, j10, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e10) {
                dispose();
                kj.a.Y(e10);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f35220c) {
                return;
            }
            this.f35220c = true;
            this.f35219b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35220c;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f35215h = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f35214g = new RxThreadFactory(f35213f, Math.max(1, Math.min(10, Integer.getInteger(f35212e, 5).intValue())), true);
    }

    public k() {
        this(f35214g);
    }

    public static ScheduledExecutorService l(ThreadFactory threadFactory) {
        return j.a(threadFactory);
    }

    @Override // xi.h0
    @bj.e
    public h0.c d() {
        return new a(this.f35217d.get());
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b g(@bj.e Runnable runnable, long j10, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(kj.a.b0(runnable));
        try {
            scheduledDirectTask.b(j10 <= 0 ? this.f35217d.get().submit(scheduledDirectTask) : this.f35217d.get().schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            kj.a.Y(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b h(@bj.e Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Runnable runnableB0 = kj.a.b0(runnable);
        if (j11 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableB0);
            try {
                scheduledDirectPeriodicTask.b(this.f35217d.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e10) {
                kj.a.Y(e10);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = this.f35217d.get();
        d dVar = new d(runnableB0, scheduledExecutorService);
        try {
            dVar.b(j10 <= 0 ? scheduledExecutorService.submit(dVar) : scheduledExecutorService.schedule(dVar, j10, timeUnit));
            return dVar;
        } catch (RejectedExecutionException e11) {
            kj.a.Y(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // xi.h0
    public void i() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.f35217d.get();
        ScheduledExecutorService scheduledExecutorService2 = f35215h;
        if (scheduledExecutorService == scheduledExecutorService2 || (andSet = this.f35217d.getAndSet(scheduledExecutorService2)) == scheduledExecutorService2) {
            return;
        }
        andSet.shutdownNow();
    }

    @Override // xi.h0
    public void j() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorServiceL = null;
        do {
            scheduledExecutorService = this.f35217d.get();
            if (scheduledExecutorService != f35215h) {
                if (scheduledExecutorServiceL != null) {
                    scheduledExecutorServiceL.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorServiceL == null) {
                scheduledExecutorServiceL = l(this.f35216c);
            }
        } while (!this.f35217d.compareAndSet(scheduledExecutorService, scheduledExecutorServiceL));
    }

    public k(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f35217d = atomicReference;
        this.f35216c = threadFactory;
        atomicReference.lazySet(l(threadFactory));
    }
}
