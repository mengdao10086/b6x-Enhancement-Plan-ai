package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class f0<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Future<? extends T> f33590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33592d;

    public f0(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        this.f33590b = future;
        this.f33591c = j10;
        this.f33592d = timeUnit;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(dVar);
        dVar.onSubscribe(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.f33592d;
            T t10 = timeUnit != null ? this.f33590b.get(this.f33591c, timeUnit) : this.f33590b.get();
            if (t10 == null) {
                dVar.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.c(t10);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            if (deferredScalarSubscription.h()) {
                return;
            }
            dVar.onError(th2);
        }
    }
}
