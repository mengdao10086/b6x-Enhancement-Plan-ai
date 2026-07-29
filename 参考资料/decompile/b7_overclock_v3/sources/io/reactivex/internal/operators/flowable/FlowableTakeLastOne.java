package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTakeLastOne<T> extends a<T, T> {

    public static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements xi.o<T> {
        private static final long serialVersionUID = -5467847744262967226L;
        public bu.e upstream;

        public TakeLastOneSubscriber(bu.d<? super T> dVar) {
            super(dVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            T t10 = this.value;
            if (t10 != null) {
                c(t10);
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.value = null;
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.value = t10;
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

    public FlowableTakeLastOne(xi.j<T> jVar) {
        super(jVar);
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new TakeLastOneSubscriber(dVar));
    }
}
