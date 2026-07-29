package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class q<T> extends xi.i0<Long> implements fj.d<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34666a;

    public static final class a implements xi.g0<Object>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super Long> f34667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f34669c;

        public a(xi.l0<? super Long> l0Var) {
            this.f34667a = l0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34668b.dispose();
            this.f34668b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34668b.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34668b = DisposableHelper.DISPOSED;
            this.f34667a.onSuccess(Long.valueOf(this.f34669c));
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34668b = DisposableHelper.DISPOSED;
            this.f34667a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(Object obj) {
            this.f34669c++;
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34668b, bVar)) {
                this.f34668b = bVar;
                this.f34667a.onSubscribe(this);
            }
        }
    }

    public q(xi.e0<T> e0Var) {
        this.f34666a = e0Var;
    }

    @Override // fj.d
    public xi.z<Long> b() {
        return kj.a.U(new p(this.f34666a));
    }

    @Override // xi.i0
    public void b1(xi.l0<? super Long> l0Var) {
        this.f34666a.c(new a(l0Var));
    }
}
