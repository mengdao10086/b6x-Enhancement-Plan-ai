package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class o<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends Throwable> f35064a;

    public o(Callable<? extends Throwable> callable) {
        this.f35064a = callable;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        try {
            th = (Throwable) io.reactivex.internal.functions.a.g(this.f35064a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            io.reactivex.exceptions.a.b(th);
        }
        EmptyDisposable.error(th, l0Var);
    }
}
