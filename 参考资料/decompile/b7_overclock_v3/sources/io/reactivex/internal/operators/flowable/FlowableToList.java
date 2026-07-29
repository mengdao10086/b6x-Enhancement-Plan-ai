package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableToList<T, U extends Collection<? super T>> extends a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<U> f33490c;

    public static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -8134157938864266736L;
        public bu.e upstream;

        /* JADX WARN: Multi-variable type inference failed */
        public ToListSubscriber(bu.d<? super U> dVar, U u6) {
            super(dVar);
            this.value = u6;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            c(this.value);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.value = null;
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            Collection collection = (Collection) this.value;
            if (collection != null) {
                collection.add(t10);
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

    public FlowableToList(xi.j<T> jVar, Callable<U> callable) {
        super(jVar);
        this.f33490c = callable;
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        try {
            this.f33524b.j6(new ToListSubscriber(dVar, (Collection) io.reactivex.internal.functions.a.g(this.f33490c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
