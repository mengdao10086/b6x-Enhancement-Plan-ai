package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class e0<T> extends xi.j<T> implements Callable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends T> f33581b;

    public e0(Callable<? extends T> callable) {
        this.f33581b = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) io.reactivex.internal.functions.a.g(this.f33581b.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(dVar);
        dVar.onSubscribe(deferredScalarSubscription);
        try {
            deferredScalarSubscription.c(io.reactivex.internal.functions.a.g(this.f33581b.call(), "The callable returned a null value"));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            if (deferredScalarSubscription.h()) {
                kj.a.Y(th2);
            } else {
                dVar.onError(th2);
            }
        }
    }
}
