package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class h extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends Throwable> f33098a;

    public h(Callable<? extends Throwable> callable) {
        this.f33098a = callable;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        try {
            th = (Throwable) io.reactivex.internal.functions.a.g(this.f33098a.call(), "The error returned is null");
        } catch (Throwable th2) {
            th = th2;
            io.reactivex.exceptions.a.b(th);
        }
        EmptyDisposable.error(th, dVar);
    }
}
