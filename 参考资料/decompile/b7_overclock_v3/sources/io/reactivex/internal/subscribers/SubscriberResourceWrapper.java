package io.reactivex.internal.subscribers;

import bu.d;
import bu.e;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<b> implements o<T>, b, e {
    private static final long serialVersionUID = -8612022020200669122L;
    public final d<? super T> downstream;
    public final AtomicReference<e> upstream = new AtomicReference<>();

    public SubscriberResourceWrapper(d<? super T> dVar) {
        this.downstream = dVar;
    }

    public void a(b bVar) {
        DisposableHelper.set(this, bVar);
    }

    @Override // bu.e
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // bu.d
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        DisposableHelper.dispose(this);
        this.downstream.onError(th2);
    }

    @Override // bu.d
    public void onNext(T t10) {
        this.downstream.onNext(t10);
    }

    @Override // xi.o, bu.d
    public void onSubscribe(e eVar) {
        if (SubscriptionHelper.setOnce(this.upstream, eVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // bu.e
    public void request(long j10) {
        if (SubscriptionHelper.validate(j10)) {
            this.upstream.get().request(j10);
        }
    }
}
