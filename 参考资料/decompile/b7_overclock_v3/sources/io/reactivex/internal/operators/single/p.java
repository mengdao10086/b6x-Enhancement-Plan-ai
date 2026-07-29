package io.reactivex.internal.operators.single;

import java.util.concurrent.Callable;
import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class p<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends T> f35065a;

    public p(Callable<? extends T> callable) {
        this.f35065a = callable;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        io.reactivex.disposables.b bVarB = io.reactivex.disposables.c.b();
        l0Var.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            a0.c cVar = (Object) io.reactivex.internal.functions.a.g(this.f35065a.call(), "The callable returned a null value");
            if (bVarB.isDisposed()) {
                return;
            }
            l0Var.onSuccess(cVar);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            if (bVarB.isDisposed()) {
                kj.a.Y(th2);
            } else {
                l0Var.onError(th2);
            }
        }
    }
}
