package io.reactivex.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T> implements o<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<bu.e> f35451a = new AtomicReference<>();

    public final void a() {
        dispose();
    }

    public void b() {
        this.f35451a.get().request(Long.MAX_VALUE);
    }

    public final void c(long j10) {
        this.f35451a.get().request(j10);
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        SubscriptionHelper.cancel(this.f35451a);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.f35451a.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // xi.o, bu.d
    public final void onSubscribe(bu.e eVar) {
        if (f.c(this.f35451a, eVar, getClass())) {
            b();
        }
    }
}
