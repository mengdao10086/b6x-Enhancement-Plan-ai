package io.reactivex.internal.operators.maybe;

/* JADX INFO: loaded from: classes5.dex */
public final class a0<T> extends xi.q<T> implements fj.m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f33915a;

    public a0(T t10) {
        this.f33915a = t10;
    }

    @Override // fj.m, java.util.concurrent.Callable
    public T call() {
        return this.f33915a;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        tVar.onSubscribe(io.reactivex.disposables.c.a());
        tVar.onSuccess(this.f33915a);
    }
}
