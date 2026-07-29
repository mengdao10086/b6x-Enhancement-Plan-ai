package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableUnsubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f34383b;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1015244841293359600L;
        public final xi.g0<? super T> downstream;
        public final xi.h0 scheduler;
        public io.reactivex.disposables.b upstream;

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeObserver.this.upstream.dispose();
            }
        }

        public UnsubscribeObserver(xi.g0<? super T> g0Var, xi.h0 h0Var) {
            this.downstream = g0Var;
            this.scheduler = h0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.f(new a());
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        @Override // xi.g0
        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (get()) {
                kj.a.Y(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(xi.e0<T> e0Var, xi.h0 h0Var) {
        super(e0Var);
        this.f34383b = h0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new UnsubscribeObserver(g0Var, this.f34383b));
    }
}
