package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class p<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends bu.c<? extends T>> f33714b;

    public p(Callable<? extends bu.c<? extends T>> callable) {
        this.f33714b = callable;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        try {
            ((bu.c) io.reactivex.internal.functions.a.g(this.f33714b.call(), "The publisher supplied is null")).d(dVar);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
