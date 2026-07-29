package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements Callable<Void>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final FutureTask<Void> f35168f = new FutureTask<>(Functions.f32980b, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f35169a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f35172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Thread f35173e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Future<?>> f35171c = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Future<?>> f35170b = new AtomicReference<>();

    public d(Runnable runnable, ExecutorService executorService) {
        this.f35169a = runnable;
        this.f35172d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        this.f35173e = Thread.currentThread();
        try {
            this.f35169a.run();
            c(this.f35172d.submit(this));
            this.f35173e = null;
        } catch (Throwable th2) {
            this.f35173e = null;
            kj.a.Y(th2);
        }
        return null;
    }

    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f35171c.get();
            if (future2 == f35168f) {
                future.cancel(this.f35173e != Thread.currentThread());
                return;
            }
        } while (!this.f35171c.compareAndSet(future2, future));
    }

    public void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f35170b.get();
            if (future2 == f35168f) {
                future.cancel(this.f35173e != Thread.currentThread());
                return;
            }
        } while (!this.f35170b.compareAndSet(future2, future));
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f35171c;
        FutureTask<Void> futureTask = f35168f;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.f35173e != Thread.currentThread());
        }
        Future<?> andSet2 = this.f35170b.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.f35173e != Thread.currentThread());
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f35171c.get() == f35168f;
    }
}
