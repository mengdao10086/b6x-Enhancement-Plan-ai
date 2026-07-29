package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTakeUntil<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<? extends U> f34361b;

    public static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1418547743690811973L;
        public final xi.g0<? super T> downstream;
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        public final TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new OtherObserver();
        public final AtomicThrowable error = new AtomicThrowable();

        public final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            public OtherObserver() {
            }

            @Override // xi.g0
            public void onComplete() {
                TakeUntilMainObserver.this.a();
            }

            @Override // xi.g0
            public void onError(Throwable th2) {
                TakeUntilMainObserver.this.b(th2);
            }

            @Override // xi.g0
            public void onNext(U u6) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver.this.a();
            }

            @Override // xi.g0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public TakeUntilMainObserver(xi.g0<? super T> g0Var) {
            this.downstream = g0Var;
        }

        public void a() {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.b(this.downstream, this, this.error);
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.d(this.downstream, th2, this, this.error);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // xi.g0
        public void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.g.b(this.downstream, this, this.error);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.g.d(this.downstream, th2, this, this.error);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            io.reactivex.internal.util.g.f(this.downstream, t10, this, this.error);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public ObservableTakeUntil(xi.e0<T> e0Var, xi.e0<? extends U> e0Var2) {
        super(e0Var);
        this.f34361b = e0Var2;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(g0Var);
        g0Var.onSubscribe(takeUntilMainObserver);
        this.f34361b.c(takeUntilMainObserver.otherObserver);
        this.f34421a.c(takeUntilMainObserver);
    }
}
