package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeToObservable<T> extends xi.z<T> implements fj.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33904a;

    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements xi.t<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        public io.reactivex.disposables.b upstream;

        public MaybeToObservableObserver(xi.g0<? super T> g0Var) {
            super(g0Var);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // xi.t
        public void onComplete() {
            a();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            e(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            b(t10);
        }
    }

    public MaybeToObservable(xi.w<T> wVar) {
        this.f33904a = wVar;
    }

    public static <T> xi.t<T> i8(xi.g0<? super T> g0Var) {
        return new MaybeToObservableObserver(g0Var);
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f33904a.a(i8(g0Var));
    }

    @Override // fj.f
    public xi.w<T> source() {
        return this.f33904a;
    }
}
