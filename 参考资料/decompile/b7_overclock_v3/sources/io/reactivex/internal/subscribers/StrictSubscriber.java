package io.reactivex.internal.subscribers;

import bu.d;
import bu.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public class StrictSubscriber<T> extends AtomicInteger implements o<T>, e {
    private static final long serialVersionUID = -4945028590049415624L;
    public volatile boolean done;
    public final d<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<e> upstream = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(d<? super T> dVar) {
        this.downstream = dVar;
    }

    @Override // bu.e
    public void cancel() {
        if (this.done) {
            return;
        }
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // bu.d
    public void onComplete() {
        this.done = true;
        g.a(this.downstream, this, this.error);
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        this.done = true;
        g.c(this.downstream, th2, this, this.error);
    }

    @Override // bu.d
    public void onNext(T t10) {
        g.e(this.downstream, t10, this, this.error);
    }

    @Override // xi.o, bu.d
    public void onSubscribe(e eVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, eVar);
        } else {
            eVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // bu.e
    public void request(long j10) {
        if (j10 > 0) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j10);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j10));
    }
}
