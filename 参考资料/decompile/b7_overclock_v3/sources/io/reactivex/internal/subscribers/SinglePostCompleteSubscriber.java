package io.reactivex.internal.subscribers;

import bu.d;
import bu.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import xi.o;
import ya.g;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements o<T>, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f35236a = Long.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f35237b = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    public final d<? super R> downstream;
    public long produced;
    public e upstream;
    public R value;

    public SinglePostCompleteSubscriber(d<? super R> dVar) {
        this.downstream = dVar;
    }

    public final void a(R r10) {
        long j10 = this.produced;
        if (j10 != 0) {
            b.e(this, j10);
        }
        while (true) {
            long j11 = get();
            if ((j11 & Long.MIN_VALUE) != 0) {
                b(r10);
                return;
            }
            if ((j11 & Long.MAX_VALUE) != 0) {
                lazySet(g.f56663b);
                this.downstream.onNext(r10);
                this.downstream.onComplete();
                return;
            } else {
                this.value = r10;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                } else {
                    this.value = null;
                }
            }
        }
    }

    public void b(R r10) {
    }

    public void cancel() {
        this.upstream.cancel();
    }

    @Override // xi.o, bu.d
    public void onSubscribe(e eVar) {
        if (SubscriptionHelper.validate(this.upstream, eVar)) {
            this.upstream = eVar;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // bu.e
    public final void request(long j10) {
        long j11;
        if (SubscriptionHelper.validate(j10)) {
            do {
                j11 = get();
                if ((j11 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, g.f56663b)) {
                        this.downstream.onNext(this.value);
                        this.downstream.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j11, b.c(j11, j10)));
            this.upstream.request(j10);
        }
    }
}
