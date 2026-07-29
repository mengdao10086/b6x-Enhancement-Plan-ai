package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class l0<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<? extends T> f34578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34580c;

    public l0(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        this.f34578a = future;
        this.f34579b = j10;
        this.f34580c = timeUnit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(g0Var);
        g0Var.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            TimeUnit timeUnit = this.f34580c;
            deferredScalarDisposable.b(io.reactivex.internal.functions.a.g(timeUnit != null ? this.f34578a.get(this.f34579b, timeUnit) : this.f34578a.get(), "Future returned null"));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            if (deferredScalarDisposable.isDisposed()) {
                return;
            }
            g0Var.onError(th2);
        }
    }
}
