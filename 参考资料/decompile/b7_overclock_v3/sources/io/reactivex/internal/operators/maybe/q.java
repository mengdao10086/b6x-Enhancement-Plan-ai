package io.reactivex.internal.operators.maybe;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class q<T> extends xi.q<T> implements Callable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends T> f33998a;

    public q(Callable<? extends T> callable) {
        this.f33998a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.f33998a.call();
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        io.reactivex.disposables.b bVarB = io.reactivex.disposables.c.b();
        tVar.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            T tCall = this.f33998a.call();
            if (bVarB.isDisposed()) {
                return;
            }
            if (tCall == null) {
                tVar.onComplete();
            } else {
                tVar.onSuccess(tCall);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            if (bVarB.isDisposed()) {
                kj.a.Y(th2);
            } else {
                tVar.onError(th2);
            }
        }
    }
}
