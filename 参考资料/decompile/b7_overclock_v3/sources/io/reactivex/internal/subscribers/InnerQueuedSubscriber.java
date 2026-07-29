package io.reactivex.internal.subscribers;

import bu.e;
import fj.l;
import hj.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.n;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<e> implements o<T>, e {
    private static final long serialVersionUID = 22876611072430776L;
    public volatile boolean done;
    public int fusionMode;
    public final int limit;
    public final g<T> parent;
    public final int prefetch;
    public long produced;
    public volatile fj.o<T> queue;

    public InnerQueuedSubscriber(g<T> gVar, int i10) {
        this.parent = gVar;
        this.prefetch = i10;
        this.limit = i10 - (i10 >> 2);
    }

    public boolean a() {
        return this.done;
    }

    public fj.o<T> b() {
        return this.queue;
    }

    public void c() {
        if (this.fusionMode != 1) {
            long j10 = this.produced + 1;
            if (j10 != this.limit) {
                this.produced = j10;
            } else {
                this.produced = 0L;
                get().request(j10);
            }
        }
    }

    @Override // bu.e
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void d() {
        this.done = true;
    }

    @Override // bu.d
    public void onComplete() {
        this.parent.a(this);
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        this.parent.d(this, th2);
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (this.fusionMode == 0) {
            this.parent.c(this, t10);
        } else {
            this.parent.b();
        }
    }

    @Override // xi.o, bu.d
    public void onSubscribe(e eVar) {
        if (SubscriptionHelper.setOnce(this, eVar)) {
            if (eVar instanceof l) {
                l lVar = (l) eVar;
                int iRequestFusion = lVar.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = lVar;
                    this.done = true;
                    this.parent.a(this);
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = lVar;
                    n.j(eVar, this.prefetch);
                    return;
                }
            }
            this.queue = n.c(this.prefetch);
            n.j(eVar, this.prefetch);
        }
    }

    @Override // bu.e
    public void request(long j10) {
        if (this.fusionMode != 1) {
            long j11 = this.produced + j10;
            if (j11 < this.limit) {
                this.produced = j11;
            } else {
                this.produced = 0L;
                get().request(j11);
            }
        }
    }
}
