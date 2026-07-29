package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* JADX INFO: loaded from: classes5.dex */
public final class t0<T> extends xi.z<T> implements fj.m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f34718a;

    public t0(T t10) {
        this.f34718a = t10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(g0Var, this.f34718a);
        g0Var.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    @Override // fj.m, java.util.concurrent.Callable
    public T call() {
        return this.f34718a;
    }
}
