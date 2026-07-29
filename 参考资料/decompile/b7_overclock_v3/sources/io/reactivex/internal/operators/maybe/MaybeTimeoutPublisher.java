package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeTimeoutPublisher<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<U> f33898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.w<? extends T> f33899c;

    public static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T> {
        private static final long serialVersionUID = 8663801314800248617L;
        public final xi.t<? super T> downstream;

        public TimeoutFallbackMaybeObserver(xi.t<? super T> tVar) {
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

    public static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -5955289211445418871L;
        public final xi.t<? super T> downstream;
        public final xi.w<? extends T> fallback;
        public final TimeoutOtherMaybeObserver<T, U> other = new TimeoutOtherMaybeObserver<>(this);
        public final TimeoutFallbackMaybeObserver<T> otherObserver;

        public TimeoutMainMaybeObserver(xi.t<? super T> tVar, xi.w<? extends T> wVar) {
            this.downstream = tVar;
            this.fallback = wVar;
            this.otherObserver = wVar != null ? new TimeoutFallbackMaybeObserver<>(tVar) : null;
        }

        public void a() {
            if (DisposableHelper.dispose(this)) {
                xi.w<? extends T> wVar = this.fallback;
                if (wVar == null) {
                    this.downstream.onError(new TimeoutException());
                } else {
                    wVar.a(this.otherObserver);
                }
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
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver = this.otherObserver;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.dispose(timeoutFallbackMaybeObserver);
            }
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

    public static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<bu.e> implements xi.o<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        public final TimeoutMainMaybeObserver<T, U> parent;

        public TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.parent = timeoutMainMaybeObserver;
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
            get().cancel();
            this.parent.a();
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public MaybeTimeoutPublisher(xi.w<T> wVar, bu.c<U> cVar, xi.w<? extends T> wVar2) {
        super(wVar);
        this.f33898b = cVar;
        this.f33899c = wVar2;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(tVar, this.f33899c);
        tVar.onSubscribe(timeoutMainMaybeObserver);
        this.f33898b.d(timeoutMainMaybeObserver.other);
        this.f33914a.a(timeoutMainMaybeObserver);
    }
}
