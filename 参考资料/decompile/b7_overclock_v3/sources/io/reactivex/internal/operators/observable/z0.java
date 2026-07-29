package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class z0<T> extends io.reactivex.internal.operators.observable.a<T, xi.y<T>> {

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super xi.y<T>> f34813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34814b;

        public a(xi.g0<? super xi.y<T>> g0Var) {
            this.f34813a = g0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34814b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34814b.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34813a.onNext(xi.y.a());
            this.f34813a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34813a.onNext(xi.y.b(th2));
            this.f34813a.onComplete();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34813a.onNext(xi.y.c(t10));
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34814b, bVar)) {
                this.f34814b = bVar;
                this.f34813a.onSubscribe(this);
            }
        }
    }

    public z0(xi.e0<T> e0Var) {
        super(e0Var);
    }

    @Override // xi.z
    public void I5(xi.g0<? super xi.y<T>> g0Var) {
        this.f34421a.c(new a(g0Var));
    }
}
