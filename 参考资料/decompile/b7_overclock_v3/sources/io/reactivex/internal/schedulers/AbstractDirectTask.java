package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements io.reactivex.disposables.b, lj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FutureTask<Void> f35106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FutureTask<Void> f35107b;
    private static final long serialVersionUID = 1811839108042568751L;
    public final Runnable runnable;
    public Thread runner;

    static {
        Runnable runnable = Functions.f32980b;
        f35106a = new FutureTask<>(runnable, null);
        f35107b = new FutureTask<>(runnable, null);
    }

    public AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // lj.a
    public Runnable a() {
        return this.runnable;
    }

    public final void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == f35106a) {
                return;
            }
            if (future2 == f35107b) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == f35106a || future == (futureTask = f35107b) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.runner != Thread.currentThread());
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == f35106a || future == f35107b;
    }
}
