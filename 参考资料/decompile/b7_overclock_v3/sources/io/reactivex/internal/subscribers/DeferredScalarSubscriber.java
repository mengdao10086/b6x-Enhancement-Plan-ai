package io.reactivex.internal.subscribers;

import bu.d;
import bu.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements o<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    public boolean hasValue;
    public e upstream;

    public DeferredScalarSubscriber(d<? super R> dVar) {
        super(dVar);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.hasValue) {
            c(this.value);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.value = null;
        this.downstream.onError(th2);
    }

    public void onSubscribe(e eVar) {
        if (SubscriptionHelper.validate(this.upstream, eVar)) {
            this.upstream = eVar;
            this.downstream.onSubscribe(this);
            eVar.request(Long.MAX_VALUE);
        }
    }
}
