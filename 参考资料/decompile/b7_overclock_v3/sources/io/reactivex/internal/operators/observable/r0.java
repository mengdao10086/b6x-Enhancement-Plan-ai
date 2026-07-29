package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public final class r0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34690b;

        public a(xi.g0<? super T> g0Var) {
            this.f34689a = g0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34690b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34690b.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34689a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34689a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34690b = bVar;
            this.f34689a.onSubscribe(this);
        }
    }

    public r0(xi.e0<T> e0Var) {
        super(e0Var);
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var));
    }
}
