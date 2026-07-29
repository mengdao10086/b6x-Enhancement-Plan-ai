package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class b0<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends Throwable> f33537b;

    public b0(Callable<? extends Throwable> callable) {
        this.f33537b = callable;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        try {
            th = (Throwable) io.reactivex.internal.functions.a.g(this.f33537b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            io.reactivex.exceptions.a.b(th);
        }
        EmptySubscription.error(th, dVar);
    }
}
