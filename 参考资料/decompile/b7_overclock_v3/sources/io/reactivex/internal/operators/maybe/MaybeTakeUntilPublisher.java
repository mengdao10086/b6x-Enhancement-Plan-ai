package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeTakeUntilPublisher<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<U> f33895b;

    public static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2187421758664251153L;
        public final xi.t<? super T> downstream;
        public final TakeUntilOtherMaybeObserver<U> other = new TakeUntilOtherMaybeObserver<>(this);

        public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<bu.e> implements xi.o<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            public final TakeUntilMainMaybeObserver<?, U> parent;

            public TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.parent = takeUntilMainMaybeObserver;
            }

            @Override // bu.d
            public void onComplete() {
                this.parent.a();
            }

            @Override // bu.d
            public void onError(Throwable th2) {
                this.parent.b(th2);
            }

            @Override // bu.d
            public void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                this.parent.a();
            }

            @Override // xi.o, bu.d
            public void onSubscribe(bu.e eVar) {
                SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
            }
        }

        public TakeUntilMainMaybeObserver(xi.t<? super T> tVar) {
            this.downstream = tVar;
        }

        public void a() {
            if (DisposableHelper.dispose(this)) {
                this.downstream.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (DisposableHelper.dispose(this)) {
                this.downstream.onError(th2);
            } else {
                kj.a.Y(th2);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.t
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.downstream.onComplete();
            }
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.other);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.downstream.onError(th2);
            } else {
                kj.a.Y(th2);
            }
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            SubscriptionHelper.cancel(this.other);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.downstream.onSuccess(t10);
            }
        }
    }

    public MaybeTakeUntilPublisher(xi.w<T> wVar, bu.c<U> cVar) {
        super(wVar);
        this.f33895b = cVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(tVar);
        tVar.onSubscribe(takeUntilMainMaybeObserver);
        this.f33895b.d(takeUntilMainMaybeObserver.other);
        this.f33914a.a(takeUntilMainMaybeObserver);
    }
}
