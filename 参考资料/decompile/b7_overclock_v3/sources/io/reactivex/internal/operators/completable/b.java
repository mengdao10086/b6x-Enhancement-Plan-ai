package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends xi.g> f33082a;

    public b(Callable<? extends xi.g> callable) {
        this.f33082a = callable;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        try {
            ((xi.g) io.reactivex.internal.functions.a.g(this.f33082a.call(), "The completableSupplier returned a null CompletableSource")).a(dVar);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, dVar);
        }
    }
}
