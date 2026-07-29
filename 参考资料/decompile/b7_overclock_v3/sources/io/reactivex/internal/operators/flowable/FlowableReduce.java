package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableReduce<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<T, T, T> f33382c;

    public static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements xi.o<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        public final dj.c<T, T, T> reducer;
        public bu.e upstream;

        public ReduceSubscriber(bu.d<? super T> dVar, dj.c<T, T, T> cVar) {
            super(dVar);
            this.reducer = cVar;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            bu.e eVar = this.upstream;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar == subscriptionHelper) {
                return;
            }
            this.upstream = subscriptionHelper;
            T t10 = this.value;
            if (t10 != null) {
                c(t10);
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            bu.e eVar = this.upstream;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar == subscriptionHelper) {
                kj.a.Y(th2);
            } else {
                this.upstream = subscriptionHelper;
                this.downstream.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.upstream == SubscriptionHelper.CANCELLED) {
                return;
            }
            T t11 = this.value;
            if (t11 == null) {
                this.value = t10;
                return;
            }
            try {
                this.value = (T) io.reactivex.internal.functions.a.g(this.reducer.apply(t11, t10), "The reducer returned a null value");
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.cancel();
                onError(th2);
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
    }

    public FlowableReduce(xi.j<T> jVar, dj.c<T, T, T> cVar) {
        super(jVar);
        this.f33382c = cVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new ReduceSubscriber(dVar, this.f33382c));
    }
}
