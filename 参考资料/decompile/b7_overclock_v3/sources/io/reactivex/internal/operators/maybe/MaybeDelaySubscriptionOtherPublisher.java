package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<U> f33843b;

    public static final class DelayMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T> {
        private static final long serialVersionUID = 706635022205076709L;
        public final xi.t<? super T> downstream;

        public DelayMaybeObserver(xi.t<? super T> tVar) {
            this.downstream = tVar;
        }

        @Override // xi.t
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    public static final class a<T> implements xi.o<Object>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DelayMaybeObserver<T> f33844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public xi.w<T> f33845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33846c;

        public a(xi.t<? super T> tVar, xi.w<T> wVar) {
            this.f33844a = new DelayMaybeObserver<>(tVar);
            this.f33845b = wVar;
        }

        public void a() {
            xi.w<T> wVar = this.f33845b;
            this.f33845b = null;
            wVar.a(this.f33844a);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33846c.cancel();
            this.f33846c = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.f33844a);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f33844a.get());
        }

        @Override // bu.d
        public void onComplete() {
            bu.e eVar = this.f33846c;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar != subscriptionHelper) {
                this.f33846c = subscriptionHelper;
                a();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            bu.e eVar = this.f33846c;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar == subscriptionHelper) {
                kj.a.Y(th2);
            } else {
                this.f33846c = subscriptionHelper;
                this.f33844a.downstream.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(Object obj) {
            bu.e eVar = this.f33846c;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar != subscriptionHelper) {
                eVar.cancel();
                this.f33846c = subscriptionHelper;
                a();
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33846c, eVar)) {
                this.f33846c = eVar;
                this.f33844a.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public MaybeDelaySubscriptionOtherPublisher(xi.w<T> wVar, bu.c<U> cVar) {
        super(wVar);
        this.f33843b = cVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33843b.d(new a(tVar, this.f33914a));
    }
}
