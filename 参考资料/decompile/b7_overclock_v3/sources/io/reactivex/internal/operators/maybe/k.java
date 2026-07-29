package io.reactivex.internal.operators.maybe;

/* JADX INFO: loaded from: classes5.dex */
public final class k<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f33975a;

    public k(Throwable th2) {
        this.f33975a = th2;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        tVar.onSubscribe(io.reactivex.disposables.c.a());
        tVar.onError(this.f33975a);
    }
}
