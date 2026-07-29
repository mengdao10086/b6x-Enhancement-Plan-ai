package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeTakeUntilMaybe<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.w<U> f33894b;

    public static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2187421758664251153L;
        public final xi.t<? super T> downstream;
        public final TakeUntilOtherMaybeObserver<U> other = new TakeUntilOtherMaybeObserver<>(this);

        public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            public final TakeUntilMainMaybeObserver<?, U> parent;

            public TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.parent = takeUntilMainMaybeObserver;
            }

            @Override // xi.t
            public void onComplete() {
                this.parent.a();
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                this.parent.b(th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.t
            public void onSuccess(Object obj) {
                this.parent.a();
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
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.t
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.downstream.onComplete();
            }
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.other);
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
            DisposableHelper.dispose(this.other);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.downstream.onSuccess(t10);
            }
        }
    }

    public MaybeTakeUntilMaybe(xi.w<T> wVar, xi.w<U> wVar2) {
        super(wVar);
        this.f33894b = wVar2;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(tVar);
        tVar.onSubscribe(takeUntilMainMaybeObserver);
        this.f33894b.a(takeUntilMainMaybeObserver.other);
        this.f33914a.a(takeUntilMainMaybeObserver);
    }
}
