package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class x<T> extends xi.a implements fj.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f34013a;

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f34014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34015b;

        public a(xi.d dVar) {
            this.f34014a = dVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34015b.dispose();
            this.f34015b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34015b.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f34015b = DisposableHelper.DISPOSED;
            this.f34014a.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f34015b = DisposableHelper.DISPOSED;
            this.f34014a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34015b, bVar)) {
                this.f34015b = bVar;
                this.f34014a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f34015b = DisposableHelper.DISPOSED;
            this.f34014a.onComplete();
        }
    }

    public x(xi.w<T> wVar) {
        this.f34013a = wVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f34013a.a(new a(dVar));
    }

    @Override // fj.c
    public xi.q<T> c() {
        return kj.a.T(new w(this.f34013a));
    }
}
