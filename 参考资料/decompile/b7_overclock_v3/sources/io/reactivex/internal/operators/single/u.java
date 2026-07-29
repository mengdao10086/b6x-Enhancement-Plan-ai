package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.EmptyDisposable;
import xi.i0;
import xi.l0;
import xi.n0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class u<T, R> extends i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0<? extends R, ? super T> f35078b;

    public u(o0<T> o0Var, n0<? extends R, ? super T> n0Var) {
        this.f35077a = o0Var;
        this.f35078b = n0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super R> l0Var) {
        try {
            this.f35077a.a((l0) io.reactivex.internal.functions.a.g(this.f35078b.a(l0Var), "The onLift returned a null SingleObserver"));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, l0Var);
        }
    }
}
