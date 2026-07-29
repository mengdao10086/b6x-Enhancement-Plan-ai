package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnErrorNext<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends bu.c<? extends T>> f33342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33343d;

    public static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements xi.o<T> {
        private static final long serialVersionUID = 4063763155303814625L;
        public final boolean allowFatal;
        public boolean done;
        public final bu.d<? super T> downstream;
        public final dj.o<? super Throwable, ? extends bu.c<? extends T>> nextSupplier;
        public boolean once;
        public long produced;

        public OnErrorNextSubscriber(bu.d<? super T> dVar, dj.o<? super Throwable, ? extends bu.c<? extends T>> oVar, boolean z10) {
            super(false);
            this.downstream = dVar;
            this.nextSupplier = oVar;
            this.allowFatal = z10;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.once) {
                if (this.done) {
                    kj.a.Y(th2);
                    return;
                } else {
                    this.downstream.onError(th2);
                    return;
                }
            }
            this.once = true;
            if (this.allowFatal && !(th2 instanceof Exception)) {
                this.downstream.onError(th2);
                return;
            }
            try {
                bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.nextSupplier.apply(th2), "The nextSupplier returned a null Publisher");
                long j10 = this.produced;
                if (j10 != 0) {
                    i(j10);
                }
                cVar.d(this);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (!this.once) {
                this.produced++;
            }
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            k(eVar);
        }
    }

    public FlowableOnErrorNext(xi.j<T> jVar, dj.o<? super Throwable, ? extends bu.c<? extends T>> oVar, boolean z10) {
        super(jVar);
        this.f33342c = oVar;
        this.f33343d = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(dVar, this.f33342c, this.f33343d);
        dVar.onSubscribe(onErrorNextSubscriber);
        this.f33524b.j6(onErrorNextSubscriber);
    }
}
