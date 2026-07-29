package io.reactivex.internal.operators.completable;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class j extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<?> f33100a;

    public j(Callable<?> callable) {
        this.f33100a = callable;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        io.reactivex.disposables.b bVarB = io.reactivex.disposables.c.b();
        dVar.onSubscribe(bVarB);
        try {
            this.f33100a.call();
            if (bVarB.isDisposed()) {
                return;
            }
            dVar.onComplete();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            if (bVarB.isDisposed()) {
                kj.a.Y(th2);
            } else {
                dVar.onError(th2);
            }
        }
    }
}
