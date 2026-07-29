package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class p<T> extends io.reactivex.internal.operators.observable.a<T, Long> {

    public static final class a implements xi.g0<Object>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super Long> f34648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f34650c;

        public a(xi.g0<? super Long> g0Var) {
            this.f34648a = g0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34649b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34649b.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34648a.onNext(Long.valueOf(this.f34650c));
            this.f34648a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34648a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(Object obj) {
            this.f34650c++;
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34649b, bVar)) {
                this.f34649b = bVar;
                this.f34648a.onSubscribe(this);
            }
        }
    }

    public p(xi.e0<T> e0Var) {
        super(e0Var);
    }

    @Override // xi.z
    public void I5(xi.g0<? super Long> g0Var) {
        this.f34421a.c(new a(g0Var));
    }
}
