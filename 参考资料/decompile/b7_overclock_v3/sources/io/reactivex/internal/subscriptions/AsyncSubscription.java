package io.reactivex.internal.subscriptions;

import bu.e;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class AsyncSubscription extends AtomicLong implements e, b {
    private static final long serialVersionUID = 7028635084060361255L;
    public final AtomicReference<e> actual;
    public final AtomicReference<b> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    public boolean a(b bVar) {
        return DisposableHelper.replace(this.resource, bVar);
    }

    public boolean b(b bVar) {
        return DisposableHelper.set(this.resource, bVar);
    }

    public void c(e eVar) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, eVar);
    }

    @Override // bu.e
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.actual.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // bu.e
    public void request(long j10) {
        SubscriptionHelper.deferredRequest(this.actual, this, j10);
    }

    public AsyncSubscription(b bVar) {
        this();
        this.resource.lazySet(bVar);
    }
}
