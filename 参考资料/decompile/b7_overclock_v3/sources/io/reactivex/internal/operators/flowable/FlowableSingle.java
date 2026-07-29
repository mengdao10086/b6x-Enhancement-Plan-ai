package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSingle<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f33443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33444d;

    public static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements xi.o<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        public final T defaultValue;
        public boolean done;
        public final boolean failOnEmpty;
        public bu.e upstream;

        public SingleElementSubscriber(bu.d<? super T> dVar, T t10, boolean z10) {
            super(dVar);
            this.defaultValue = t10;
            this.failOnEmpty = z10;
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
            T t10 = this.value;
            this.value = null;
            if (t10 == null) {
                t10 = this.defaultValue;
            }
            if (t10 != null) {
                c(t10);
            } else if (this.failOnEmpty) {
                this.downstream.onError(new NoSuchElementException());
            } else {
                this.downstream.onComplete();
            }
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
            if (this.value == null) {
                this.value = t10;
                return;
            }
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
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

    public FlowableSingle(xi.j<T> jVar, T t10, boolean z10) {
        super(jVar);
        this.f33443c = t10;
        this.f33444d = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new SingleElementSubscriber(dVar, this.f33443c, this.f33444d));
    }
}
