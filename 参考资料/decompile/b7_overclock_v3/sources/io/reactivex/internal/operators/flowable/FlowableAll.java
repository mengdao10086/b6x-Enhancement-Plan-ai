package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableAll<T> extends a<T, Boolean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.r<? super T> f33156c;

    public static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements xi.o<T> {
        private static final long serialVersionUID = -3521127104134758517L;
        public boolean done;
        public final dj.r<? super T> predicate;
        public bu.e upstream;

        public AllSubscriber(bu.d<? super Boolean> dVar, dj.r<? super T> rVar) {
            super(dVar);
            this.predicate = rVar;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            c(Boolean.TRUE);
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
            try {
                if (this.predicate.a(t10)) {
                    return;
                }
                this.done = true;
                this.upstream.cancel();
                c(Boolean.FALSE);
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

    public FlowableAll(xi.j<T> jVar, dj.r<? super T> rVar) {
        super(jVar);
        this.f33156c = rVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super Boolean> dVar) {
        this.f33524b.j6(new AllSubscriber(dVar, this.f33156c));
    }
}
