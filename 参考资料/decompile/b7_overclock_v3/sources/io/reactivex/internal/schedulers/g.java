package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public class g extends h0.c implements io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f35204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f35205b;

    public g(ThreadFactory threadFactory) {
        this.f35204a = j.a(threadFactory);
    }

    @Override // xi.h0.c
    @bj.e
    public io.reactivex.disposables.b b(@bj.e Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // xi.h0.c
    @bj.e
    public io.reactivex.disposables.b c(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit) {
        return this.f35205b ? EmptyDisposable.INSTANCE : e(runnable, j10, timeUnit, null);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f35205b) {
            return;
        }
        this.f35205b = true;
        this.f35204a.shutdownNow();
    }

    @bj.e
    public ScheduledRunnable e(Runnable runnable, long j10, @bj.e TimeUnit timeUnit, @bj.f ej.a aVar) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(kj.a.b0(runnable), aVar);
        if (aVar != null && !aVar.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            scheduledRunnable.a(j10 <= 0 ? this.f35204a.submit((Callable) scheduledRunnable) : this.f35204a.schedule((Callable) scheduledRunnable, j10, timeUnit));
        } catch (RejectedExecutionException e10) {
            if (aVar != null) {
                aVar.a(scheduledRunnable);
            }
            kj.a.Y(e10);
        }
        return scheduledRunnable;
    }

    public io.reactivex.disposables.b f(Runnable runnable, long j10, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(kj.a.b0(runnable));
        try {
            scheduledDirectTask.b(j10 <= 0 ? this.f35204a.submit(scheduledDirectTask) : this.f35204a.schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            kj.a.Y(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    public io.reactivex.disposables.b g(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Runnable runnableB0 = kj.a.b0(runnable);
        if (j11 <= 0) {
            d dVar = new d(runnableB0, this.f35204a);
            try {
                dVar.b(j10 <= 0 ? this.f35204a.submit(dVar) : this.f35204a.schedule(dVar, j10, timeUnit));
                return dVar;
            } catch (RejectedExecutionException e10) {
                kj.a.Y(e10);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableB0);
        try {
            scheduledDirectPeriodicTask.b(this.f35204a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e11) {
            kj.a.Y(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void h() {
        if (this.f35205b) {
            return;
        }
        this.f35205b = true;
        this.f35204a.shutdown();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f35205b;
    }
}
