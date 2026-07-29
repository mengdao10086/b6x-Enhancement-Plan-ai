package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33083a;

    public static final class a implements xi.d, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xi.d f33084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f33085b;

        public a(xi.d dVar) {
            this.f33084a = dVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33084a = null;
            this.f33085b.dispose();
            this.f33085b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33085b.isDisposed();
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            this.f33085b = DisposableHelper.DISPOSED;
            xi.d dVar = this.f33084a;
            if (dVar != null) {
                this.f33084a = null;
                dVar.onComplete();
            }
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.f33085b = DisposableHelper.DISPOSED;
            xi.d dVar = this.f33084a;
            if (dVar != null) {
                this.f33084a = null;
                dVar.onError(th2);
            }
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33085b, bVar)) {
                this.f33085b = bVar;
                this.f33084a.onSubscribe(this);
            }
        }
    }

    public c(xi.g gVar) {
        this.f33083a = gVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33083a.a(new a(dVar));
    }
}
