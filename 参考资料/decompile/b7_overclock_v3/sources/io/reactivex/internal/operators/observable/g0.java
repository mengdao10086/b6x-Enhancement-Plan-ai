package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class g0<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends Throwable> f34524a;

    public g0(Callable<? extends Throwable> callable) {
        this.f34524a = callable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        try {
            th = (Throwable) io.reactivex.internal.functions.a.g(this.f34524a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            io.reactivex.exceptions.a.b(th);
        }
        EmptyDisposable.error(th, g0Var);
    }
}
