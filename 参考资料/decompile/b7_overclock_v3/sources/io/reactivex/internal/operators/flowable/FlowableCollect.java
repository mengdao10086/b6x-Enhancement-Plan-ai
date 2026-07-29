package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableCollect<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<? extends U> f33189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.b<? super U, ? super T> f33190d;

    public static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements xi.o<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        public final dj.b<? super U, ? super T> collector;
        public boolean done;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final U f33191u;
        public bu.e upstream;

        public CollectSubscriber(bu.d<? super U> dVar, U u6, dj.b<? super U, ? super T> bVar) {
            super(dVar);
            this.collector = bVar;
            this.f33191u = u6;
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
            c(this.f33191u);
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
                this.collector.a(this.f33191u, t10);
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

    public FlowableCollect(xi.j<T> jVar, Callable<? extends U> callable, dj.b<? super U, ? super T> bVar) {
        super(jVar);
        this.f33189c = callable;
        this.f33190d = bVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        try {
            this.f33524b.j6(new CollectSubscriber(dVar, io.reactivex.internal.functions.a.g(this.f33189c.call(), "The initial value supplied is null"), this.f33190d));
        } catch (Throwable th2) {
            EmptySubscription.error(th2, dVar);
        }
    }
}
