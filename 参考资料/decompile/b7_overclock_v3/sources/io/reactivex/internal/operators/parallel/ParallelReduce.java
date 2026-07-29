package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelReduce<T, R> extends jj.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<? extends T> f34835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<R> f34836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<R, ? super T, R> f34837c;

    public static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;
        public R accumulator;
        public boolean done;
        public final dj.c<R, ? super T, R> reducer;

        public ParallelReduceSubscriber(bu.d<? super R> dVar, R r10, dj.c<R, ? super T, R> cVar) {
            super(dVar);
            this.accumulator = r10;
            this.reducer = cVar;
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
            R r10 = this.accumulator;
            this.accumulator = null;
            c(r10);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            this.accumulator = null;
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            try {
                this.accumulator = (R) io.reactivex.internal.functions.a.g(this.reducer.apply(this.accumulator, t10), "The reducer returned a null value");
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

    public ParallelReduce(jj.a<? extends T> aVar, Callable<R> callable, dj.c<R, ? super T, R> cVar) {
        this.f34835a = aVar;
        this.f34836b = callable;
        this.f34837c = cVar;
    }

    @Override // jj.a
    public int F() {
        return this.f34835a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super R>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super Object>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                try {
                    dVarArr2[i10] = new ParallelReduceSubscriber(dVarArr[i10], io.reactivex.internal.functions.a.g(this.f34836b.call(), "The initialSupplier returned a null value"), this.f34837c);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    V(dVarArr, th2);
                    return;
                }
            }
            this.f34835a.Q(dVarArr2);
        }
    }

    public void V(bu.d<?>[] dVarArr, Throwable th2) {
        for (bu.d<?> dVar : dVarArr) {
            EmptySubscription.error(th2, dVar);
        }
    }
}
