package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends xi.w<? extends T>> f33936a;

    public e(Callable<? extends xi.w<? extends T>> callable) {
        this.f33936a = callable;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        try {
            ((xi.w) io.reactivex.internal.functions.a.g(this.f33936a.call(), "The maybeSupplier returned a null MaybeSource")).a(tVar);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, tVar);
        }
    }
}
