package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import xi.g0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleToObservable<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f34983a;

    public static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements l0<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        public io.reactivex.disposables.b upstream;

        public SingleToObservableObserver(g0<? super T> g0Var) {
            super(g0Var);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            e(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            b(t10);
        }
    }

    public SingleToObservable(o0<? extends T> o0Var) {
        this.f34983a = o0Var;
    }

    public static <T> l0<T> i8(g0<? super T> g0Var) {
        return new SingleToObservableObserver(g0Var);
    }

    @Override // xi.z
    public void I5(g0<? super T> g0Var) {
        this.f34983a.a(i8(g0Var));
    }
}
