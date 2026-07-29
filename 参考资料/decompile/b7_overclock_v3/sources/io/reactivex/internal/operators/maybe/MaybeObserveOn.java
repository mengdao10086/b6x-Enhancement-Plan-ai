package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeObserveOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f33879b;

    public static final class ObserveOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        public final xi.t<? super T> downstream;
        public Throwable error;
        public final xi.h0 scheduler;
        public T value;

        public ObserveOnMaybeObserver(xi.t<? super T> tVar, xi.h0 h0Var) {
            this.downstream = tVar;
            this.scheduler = h0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.t
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.f(this));
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.error = th2;
            DisposableHelper.replace(this, this.scheduler.f(this));
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.value = t10;
            DisposableHelper.replace(this, this.scheduler.f(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.error = null;
                this.downstream.onError(th2);
                return;
            }
            T t10 = this.value;
            if (t10 == null) {
                this.downstream.onComplete();
            } else {
                this.value = null;
                this.downstream.onSuccess(t10);
            }
        }
    }

    public MaybeObserveOn(xi.w<T> wVar, xi.h0 h0Var) {
        super(wVar);
        this.f33879b = h0Var;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new ObserveOnMaybeObserver(tVar, this.f33879b));
    }
}
