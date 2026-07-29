package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xi.t<? super T> f33938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f33939b;

        public a(xi.t<? super T> tVar) {
            this.f33938a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33938a = null;
            this.f33939b.dispose();
            this.f33939b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33939b.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33939b = DisposableHelper.DISPOSED;
            xi.t<? super T> tVar = this.f33938a;
            if (tVar != null) {
                this.f33938a = null;
                tVar.onComplete();
            }
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33939b = DisposableHelper.DISPOSED;
            xi.t<? super T> tVar = this.f33938a;
            if (tVar != null) {
                this.f33938a = null;
                tVar.onError(th2);
            }
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33939b, bVar)) {
                this.f33939b = bVar;
                this.f33938a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f33939b = DisposableHelper.DISPOSED;
            xi.t<? super T> tVar = this.f33938a;
            if (tVar != null) {
                this.f33938a = null;
                tVar.onSuccess(t10);
            }
        }
    }

    public f(xi.w<T> wVar) {
        super(wVar);
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new a(tVar));
    }
}
