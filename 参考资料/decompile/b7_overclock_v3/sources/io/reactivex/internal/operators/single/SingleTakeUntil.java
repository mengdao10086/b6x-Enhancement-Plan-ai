package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleTakeUntil<T, U> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<U> f34973b;

    public static final class TakeUntilMainObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements l0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -622603812305745221L;
        public final l0<? super T> downstream;
        public final TakeUntilOtherSubscriber other = new TakeUntilOtherSubscriber(this);

        public TakeUntilMainObserver(l0<? super T> l0Var) {
            this.downstream = l0Var;
        }

        public void a(Throwable th2) {
            io.reactivex.disposables.b andSet;
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                kj.a.Y(th2);
                return;
            }
            if (andSet != null) {
                andSet.dispose();
            }
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.other.a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.other.a();
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || getAndSet(disposableHelper) == disposableHelper) {
                kj.a.Y(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.other.a();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.downstream.onSuccess(t10);
            }
        }
    }

    public static final class TakeUntilOtherSubscriber extends AtomicReference<bu.e> implements xi.o<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        public final TakeUntilMainObserver<?> parent;

        public TakeUntilOtherSubscriber(TakeUntilMainObserver<?> takeUntilMainObserver) {
            this.parent = takeUntilMainObserver;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        @Override // bu.d
        public void onComplete() {
            bu.e eVar = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.a(new CancellationException());
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.parent.a(th2);
        }

        @Override // bu.d
        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.parent.a(new CancellationException());
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public SingleTakeUntil(o0<T> o0Var, bu.c<U> cVar) {
        this.f34972a = o0Var;
        this.f34973b = cVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(l0Var);
        l0Var.onSubscribe(takeUntilMainObserver);
        this.f34973b.d(takeUntilMainObserver.other);
        this.f34972a.a(takeUntilMainObserver);
    }
}
