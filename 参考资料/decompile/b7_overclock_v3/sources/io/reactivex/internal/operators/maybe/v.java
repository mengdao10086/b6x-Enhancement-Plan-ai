package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class v<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f34009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34010b;

        public a(xi.t<? super T> tVar) {
            this.f34009a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34010b.dispose();
            this.f34010b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34010b.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f34009a.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f34009a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34010b, bVar)) {
                this.f34010b = bVar;
                this.f34009a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f34009a.onSuccess(t10);
        }
    }

    public v(xi.w<T> wVar) {
        super(wVar);
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new a(tVar));
    }
}
