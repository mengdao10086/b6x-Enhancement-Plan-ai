package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class r<T> extends xi.q<T> implements fj.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33999a;

    public static final class a<T> implements xi.d, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f34000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34001b;

        public a(xi.t<? super T> tVar) {
            this.f34000a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34001b.dispose();
            this.f34001b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34001b.isDisposed();
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            this.f34001b = DisposableHelper.DISPOSED;
            this.f34000a.onComplete();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.f34001b = DisposableHelper.DISPOSED;
            this.f34000a.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34001b, bVar)) {
                this.f34001b = bVar;
                this.f34000a.onSubscribe(this);
            }
        }
    }

    public r(xi.g gVar) {
        this.f33999a = gVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33999a.a(new a(tVar));
    }

    @Override // fj.e
    public xi.g source() {
        return this.f33999a;
    }
}
