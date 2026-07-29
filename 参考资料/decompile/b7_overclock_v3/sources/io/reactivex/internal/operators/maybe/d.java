package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> extends xi.i0<Long> implements fj.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33932a;

    public static final class a implements xi.t<Object>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super Long> f33933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f33934b;

        public a(l0<? super Long> l0Var) {
            this.f33933a = l0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33934b.dispose();
            this.f33934b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33934b.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33934b = DisposableHelper.DISPOSED;
            this.f33933a.onSuccess(0L);
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33934b = DisposableHelper.DISPOSED;
            this.f33933a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33934b, bVar)) {
                this.f33934b = bVar;
                this.f33933a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(Object obj) {
            this.f33934b = DisposableHelper.DISPOSED;
            this.f33933a.onSuccess(1L);
        }
    }

    public d(xi.w<T> wVar) {
        this.f33932a = wVar;
    }

    @Override // xi.i0
    public void b1(l0<? super Long> l0Var) {
        this.f33932a.a(new a(l0Var));
    }

    @Override // fj.f
    public xi.w<T> source() {
        return this.f33932a;
    }
}
