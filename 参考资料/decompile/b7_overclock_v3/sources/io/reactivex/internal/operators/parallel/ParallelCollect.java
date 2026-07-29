package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelCollect<T, C> extends jj.a<C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<? extends T> f34823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends C> f34824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.b<? super C, ? super T> f34825c;

    public static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        public C collection;
        public final dj.b<? super C, ? super T> collector;
        public boolean done;

        public ParallelCollectSubscriber(bu.d<? super C> dVar, C c10, dj.b<? super C, ? super T> bVar) {
            super(dVar);
            this.collection = c10;
            this.collector = bVar;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c10 = this.collection;
            this.collection = null;
            c(c10);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            this.collection = null;
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            try {
                this.collector.a(this.collection, t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                onError(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public ParallelCollect(jj.a<? extends T> aVar, Callable<? extends C> callable, dj.b<? super C, ? super T> bVar) {
        this.f34823a = aVar;
        this.f34824b = callable;
        this.f34825c = bVar;
    }

    @Override // jj.a
    public int F() {
        return this.f34823a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super C>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super Object>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                try {
                    dVarArr2[i10] = new ParallelCollectSubscriber(dVarArr[i10], io.reactivex.internal.functions.a.g(this.f34824b.call(), "The initialSupplier returned a null value"), this.f34825c);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    V(dVarArr, th2);
                    return;
                }
            }
            this.f34823a.Q(dVarArr2);
        }
    }

    public void V(bu.d<?>[] dVarArr, Throwable th2) {
        for (bu.d<?> dVar : dVarArr) {
            EmptySubscription.error(th2, dVar);
        }
    }
}
