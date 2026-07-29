package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnBackpressureError<T> extends a<T, T> {

    public static final class BackpressureErrorSubscriber<T> extends AtomicLong implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -3176480756392482682L;
        public boolean done;
        public final bu.d<? super T> downstream;
        public bu.e upstream;

        public BackpressureErrorSubscriber(bu.d<? super T> dVar) {
            this.downstream = dVar;
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
            } else {
                this.done = true;
                this.downstream.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (get() != 0) {
                this.downstream.onNext(t10);
                io.reactivex.internal.util.b.e(this, 1L);
            } else {
                this.upstream.cancel();
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
            }
        }
    }

    public FlowableOnBackpressureError(xi.j<T> jVar) {
        super(jVar);
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new BackpressureErrorSubscriber(dVar));
    }
}
