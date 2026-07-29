package io.reactivex.internal.operators.maybe;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends Throwable> f33979a;

    public l(Callable<? extends Throwable> callable) {
        this.f33979a = callable;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        tVar.onSubscribe(io.reactivex.disposables.c.a());
        try {
            th = (Throwable) io.reactivex.internal.functions.a.g(this.f33979a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            io.reactivex.exceptions.a.b(th);
        }
        tVar.onError(th);
    }
}
