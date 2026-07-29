package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class u<T> extends xi.q<T> implements fj.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34006a;

    public static final class a<T> implements l0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f34007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34008b;

        public a(xi.t<? super T> tVar) {
            this.f34007a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34008b.dispose();
            this.f34008b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34008b.isDisposed();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f34008b = DisposableHelper.DISPOSED;
            this.f34007a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34008b, bVar)) {
                this.f34008b = bVar;
                this.f34007a.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f34008b = DisposableHelper.DISPOSED;
            this.f34007a.onSuccess(t10);
        }
    }

    public u(o0<T> o0Var) {
        this.f34006a = o0Var;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f34006a.a(new a(tVar));
    }

    @Override // fj.i
    public o0<T> source() {
        return this.f34006a;
    }
}
