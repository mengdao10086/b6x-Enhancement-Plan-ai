package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableElementAt<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f33229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f33230e;

    public static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements xi.o<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        public long count;
        public final T defaultValue;
        public boolean done;
        public final boolean errorOnFewer;
        public final long index;
        public bu.e upstream;

        public ElementAtSubscriber(bu.d<? super T> dVar, long j10, T t10, boolean z10) {
            super(dVar);
            this.index = j10;
            this.defaultValue = t10;
            this.errorOnFewer = z10;
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
            T t10 = this.defaultValue;
            if (t10 != null) {
                c(t10);
            } else if (this.errorOnFewer) {
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
            long j10 = this.count;
            if (j10 != this.index) {
                this.count = j10 + 1;
                return;
            }
            this.done = true;
            this.upstream.cancel();
            c(t10);
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

    public FlowableElementAt(xi.j<T> jVar, long j10, T t10, boolean z10) {
        super(jVar);
        this.f33228c = j10;
        this.f33229d = t10;
        this.f33230e = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new ElementAtSubscriber(dVar, this.f33228c, this.f33229d, this.f33230e));
    }
}
