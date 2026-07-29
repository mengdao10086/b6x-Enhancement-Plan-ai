package io.reactivex.internal.operators.maybe;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class p<T> extends xi.q<T> implements Callable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dj.a f33997a;

    public p(dj.a aVar) {
        this.f33997a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        this.f33997a.run();
        return null;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        io.reactivex.disposables.b bVarB = io.reactivex.disposables.c.b();
        tVar.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            this.f33997a.run();
            if (bVarB.isDisposed()) {
                return;
            }
            tVar.onComplete();
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
