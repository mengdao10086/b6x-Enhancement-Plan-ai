package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public final class s0<T> extends xi.a implements fj.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34695a;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f34696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34697b;

        public a(xi.d dVar) {
            this.f34696a = dVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34697b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34697b.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34696a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34696a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34697b = bVar;
            this.f34696a.onSubscribe(this);
        }
    }

    public s0(xi.e0<T> e0Var) {
        this.f34695a = e0Var;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f34695a.c(new a(dVar));
    }

    @Override // fj.d
    public xi.z<T> b() {
        return kj.a.U(new r0(this.f34695a));
    }
}
