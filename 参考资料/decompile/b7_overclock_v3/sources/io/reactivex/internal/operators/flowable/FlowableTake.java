package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTake<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33460c;

    public static final class TakeSubscriber<T> extends AtomicBoolean implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -5636543848937116287L;
        public boolean done;
        public final bu.d<? super T> downstream;
        public final long limit;
        public long remaining;
        public bu.e upstream;

        public TakeSubscriber(bu.d<? super T> dVar, long j10) {
            this.downstream = dVar;
            this.limit = j10;
            this.remaining = j10;
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            long j10 = this.remaining;
            long j11 = j10 - 1;
            this.remaining = j11;
            if (j10 > 0) {
                boolean z10 = j11 == 0;
                this.downstream.onNext(t10);
                if (z10) {
                    this.upstream.cancel();
                    onComplete();
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                if (this.limit != 0) {
                    this.downstream.onSubscribe(this);
                    return;
                }
                eVar.cancel();
                this.done = true;
                EmptySubscription.complete(this.downstream);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                if (get() || !compareAndSet(false, true) || j10 < this.limit) {
                    this.upstream.request(j10);
                } else {
                    this.upstream.request(Long.MAX_VALUE);
                }
            }
        }
    }

    public FlowableTake(xi.j<T> jVar, long j10) {
        super(jVar);
        this.f33460c = j10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new TakeSubscriber(dVar, this.f33460c));
    }
}
