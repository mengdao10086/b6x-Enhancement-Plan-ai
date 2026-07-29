package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.f1;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class g1<T, R> extends xi.i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<R> f34526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<R, ? super T, R> f34527c;

    public g1(xi.e0<T> e0Var, Callable<R> callable, dj.c<R, ? super T, R> cVar) {
        this.f34525a = e0Var;
        this.f34526b = callable;
        this.f34527c = cVar;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super R> l0Var) {
        try {
            this.f34525a.c(new f1.a(l0Var, this.f34527c, io.reactivex.internal.functions.a.g(this.f34526b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, l0Var);
        }
    }
}
