package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.flowable.u0;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class v0<T, R> extends xi.i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<T> f33774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<R> f33775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<R, ? super T, R> f33776c;

    public v0(bu.c<T> cVar, Callable<R> callable, dj.c<R, ? super T, R> cVar2) {
        this.f33774a = cVar;
        this.f33775b = callable;
        this.f33776c = cVar2;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super R> l0Var) {
        try {
            this.f33774a.d(new u0.a(l0Var, this.f33776c, io.reactivex.internal.functions.a.g(this.f33775b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, l0Var);
        }
    }
}
