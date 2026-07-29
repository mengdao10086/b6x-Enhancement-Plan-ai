package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.ScalarSubscription;

/* JADX INFO: loaded from: classes5.dex */
public final class l0<T> extends xi.j<T> implements fj.m<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f33682b;

    public l0(T t10) {
        this.f33682b = t10;
    }

    @Override // fj.m, java.util.concurrent.Callable
    public T call() {
        return this.f33682b;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        dVar.onSubscribe(new ScalarSubscription(dVar, this.f33682b));
    }
}
