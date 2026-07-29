package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class k0<T> extends xi.z<T> implements Callable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends T> f34568a;

    public k0(Callable<? extends T> callable) {
        this.f34568a = callable;
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
            deferredScalarDisposable.b(io.reactivex.internal.functions.a.g(this.f34568a.call(), "Callable returned null"));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            if (deferredScalarDisposable.isDisposed()) {
                kj.a.Y(th2);
            } else {
                g0Var.onError(th2);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) io.reactivex.internal.functions.a.g(this.f34568a.call(), "The callable returned a null value");
    }
}
