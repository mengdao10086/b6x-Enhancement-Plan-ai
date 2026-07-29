package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class y0<T, R> extends io.reactivex.internal.operators.observable.a<T, xi.e0<? extends R>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.e0<? extends R>> f34787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends xi.e0<? extends R>> f34788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<? extends xi.e0<? extends R>> f34789d;

    public static final class a<T, R> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super xi.e0<? extends R>> f34790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends xi.e0<? extends R>> f34791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.o<? super Throwable, ? extends xi.e0<? extends R>> f34792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Callable<? extends xi.e0<? extends R>> f34793d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public io.reactivex.disposables.b f34794e;

        public a(xi.g0<? super xi.e0<? extends R>> g0Var, dj.o<? super T, ? extends xi.e0<? extends R>> oVar, dj.o<? super Throwable, ? extends xi.e0<? extends R>> oVar2, Callable<? extends xi.e0<? extends R>> callable) {
            this.f34790a = g0Var;
            this.f34791b = oVar;
            this.f34792c = oVar2;
            this.f34793d = callable;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34794e.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34794e.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            try {
                this.f34790a.onNext((xi.e0) io.reactivex.internal.functions.a.g(this.f34793d.call(), "The onComplete ObservableSource returned is null"));
                this.f34790a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34790a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            try {
                this.f34790a.onNext((xi.e0) io.reactivex.internal.functions.a.g(this.f34792c.apply(th2), "The onError ObservableSource returned is null"));
                this.f34790a.onComplete();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f34790a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            try {
                this.f34790a.onNext((xi.e0) io.reactivex.internal.functions.a.g(this.f34791b.apply(t10), "The onNext ObservableSource returned is null"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34790a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34794e, bVar)) {
                this.f34794e = bVar;
                this.f34790a.onSubscribe(this);
            }
        }
    }

    public y0(xi.e0<T> e0Var, dj.o<? super T, ? extends xi.e0<? extends R>> oVar, dj.o<? super Throwable, ? extends xi.e0<? extends R>> oVar2, Callable<? extends xi.e0<? extends R>> callable) {
        super(e0Var);
        this.f34787b = oVar;
        this.f34788c = oVar2;
        this.f34789d = callable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super xi.e0<? extends R>> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34787b, this.f34788c, this.f34789d));
    }
}
