package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSubscribeOn<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f34347b;

    public static final class SubscribeOnObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8094547886072529208L;
        public final xi.g0<? super T> downstream;
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        public SubscribeOnObserver(xi.g0<? super T> g0Var) {
            this.downstream = g0Var;
        }

        public void a(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.g0
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SubscribeOnObserver<T> f34348a;

        public a(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f34348a = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f34421a.c(this.f34348a);
        }
    }

    public ObservableSubscribeOn(xi.e0<T> e0Var, xi.h0 h0Var) {
        super(e0Var);
        this.f34347b = h0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(g0Var);
        g0Var.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.a(this.f34347b.f(new a(subscribeOnObserver)));
    }
}
