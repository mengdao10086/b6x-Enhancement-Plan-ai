package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class b0<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.v<? extends R, ? super T> f33922b;

    public b0(xi.w<T> wVar, xi.v<? extends R, ? super T> vVar) {
        super(wVar);
        this.f33922b = vVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        try {
            this.f33914a.a((xi.t) io.reactivex.internal.functions.a.g(this.f33922b.a(tVar), "The operator returned a null MaybeObserver"));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, tVar);
        }
    }
}
