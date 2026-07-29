package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class s<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends xi.e0<? extends T>> f34694a;

    public s(Callable<? extends xi.e0<? extends T>> callable) {
        this.f34694a = callable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        try {
            ((xi.e0) io.reactivex.internal.functions.a.g(this.f34694a.call(), "null ObservableSource supplied")).c(g0Var);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, g0Var);
        }
    }
}
