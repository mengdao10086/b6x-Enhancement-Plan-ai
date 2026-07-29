package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class p extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33110a;

    public static final class a implements xi.d, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f33112b;

        public a(xi.d dVar) {
            this.f33111a = dVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33112b.dispose();
            this.f33112b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33112b.isDisposed();
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            this.f33111a.onComplete();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.f33111a.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33112b, bVar)) {
                this.f33112b = bVar;
                this.f33111a.onSubscribe(this);
            }
        }
    }

    public p(xi.g gVar) {
        this.f33110a = gVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33110a.a(new a(dVar));
    }
}
