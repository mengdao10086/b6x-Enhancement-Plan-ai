package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableCount<T> extends a<T, Long> {

    public static final class CountSubscriber extends DeferredScalarSubscription<Long> implements xi.o<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        public long count;
        public bu.e upstream;

        public CountSubscriber(bu.d<? super Long> dVar) {
            super(dVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            c(Long.valueOf(this.count));
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(Object obj) {
            this.count++;
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCount(xi.j<T> jVar) {
        super(jVar);
    }

    @Override // xi.j
    public void k6(bu.d<? super Long> dVar) {
        this.f33524b.j6(new CountSubscriber(dVar));
    }
}
