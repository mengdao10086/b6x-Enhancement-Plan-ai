package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class y<T> extends io.reactivex.internal.operators.maybe.a<T, Boolean> {

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super Boolean> f34016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34017b;

        public a(xi.t<? super Boolean> tVar) {
            this.f34016a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34017b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34017b.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f34016a.onSuccess(Boolean.TRUE);
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f34016a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34017b, bVar)) {
                this.f34017b = bVar;
                this.f34016a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f34016a.onSuccess(Boolean.FALSE);
        }
    }

    public y(xi.w<T> wVar) {
        super(wVar);
    }

    @Override // xi.q
    public void q1(xi.t<? super Boolean> tVar) {
        this.f33914a.a(new a(tVar));
    }
}
