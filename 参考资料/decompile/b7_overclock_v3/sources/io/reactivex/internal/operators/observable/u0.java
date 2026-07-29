package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class u0<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34731a;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f34732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f34734c;

        public a(xi.t<? super T> tVar) {
            this.f34732a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34733b.dispose();
            this.f34733b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34733b == DisposableHelper.DISPOSED;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34733b = DisposableHelper.DISPOSED;
            T t10 = this.f34734c;
            if (t10 == null) {
                this.f34732a.onComplete();
            } else {
                this.f34734c = null;
                this.f34732a.onSuccess(t10);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34733b = DisposableHelper.DISPOSED;
            this.f34734c = null;
            this.f34732a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34734c = t10;
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34733b, bVar)) {
                this.f34733b = bVar;
                this.f34732a.onSubscribe(this);
            }
        }
    }

    public u0(xi.e0<T> e0Var) {
        this.f34731a = e0Var;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f34731a.c(new a(tVar));
    }
}
