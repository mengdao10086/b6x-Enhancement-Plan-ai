package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeDelayOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<U> f33839b;

    public static final class OtherSubscriber<T> extends AtomicReference<bu.e> implements xi.o<Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        public final xi.t<? super T> downstream;
        public Throwable error;
        public T value;

        public OtherSubscriber(xi.t<? super T> tVar) {
            this.downstream = tVar;
        }

        @Override // bu.d
        public void onComplete() {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.downstream.onError(th2);
                return;
            }
            T t10 = this.value;
            if (t10 != null) {
                this.downstream.onSuccess(t10);
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            Throwable th3 = this.error;
            if (th3 == null) {
                this.downstream.onError(th2);
            } else {
                this.downstream.onError(new CompositeException(th3, th2));
            }
        }

        @Override // bu.d
        public void onNext(Object obj) {
            bu.e eVar = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar != subscriptionHelper) {
                lazySet(subscriptionHelper);
                eVar.cancel();
                onComplete();
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public static final class a<T, U> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OtherSubscriber<T> f33840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bu.c<U> f33841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33842c;

        public a(xi.t<? super T> tVar, bu.c<U> cVar) {
            this.f33840a = new OtherSubscriber<>(tVar);
            this.f33841b = cVar;
        }

        public void a() {
            this.f33841b.d(this.f33840a);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33842c.dispose();
            this.f33842c = DisposableHelper.DISPOSED;
            SubscriptionHelper.cancel(this.f33840a);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33840a.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // xi.t
        public void onComplete() {
            this.f33842c = DisposableHelper.DISPOSED;
            a();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33842c = DisposableHelper.DISPOSED;
            this.f33840a.error = th2;
            a();
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33842c, bVar)) {
                this.f33842c = bVar;
                this.f33840a.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f33842c = DisposableHelper.DISPOSED;
            this.f33840a.value = t10;
            a();
        }
    }

    public MaybeDelayOtherPublisher(xi.w<T> wVar, bu.c<U> cVar) {
        super(wVar);
        this.f33839b = cVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new a(tVar, this.f33839b));
    }
}
