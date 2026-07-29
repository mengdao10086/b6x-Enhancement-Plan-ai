package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class w1<T, U extends Collection<? super T>> extends xi.i0<U> implements fj.d<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<U> f34761b;

    public static final class a<T, U extends Collection<? super T>> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super U> f34762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public U f34763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34764c;

        public a(xi.l0<? super U> l0Var, U u6) {
            this.f34762a = l0Var;
            this.f34763b = u6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34764c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34764c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            U u6 = this.f34763b;
            this.f34763b = null;
            this.f34762a.onSuccess(u6);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34763b = null;
            this.f34762a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34763b.add(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34764c, bVar)) {
                this.f34764c = bVar;
                this.f34762a.onSubscribe(this);
            }
        }
    }

    public w1(xi.e0<T> e0Var, int i10) {
        this.f34760a = e0Var;
        this.f34761b = Functions.f(i10);
    }

    @Override // fj.d
    public xi.z<U> b() {
        return kj.a.U(new v1(this.f34760a, this.f34761b));
    }

    @Override // xi.i0
    public void b1(xi.l0<? super U> l0Var) {
        try {
            this.f34760a.c(new a(l0Var, (Collection) io.reactivex.internal.functions.a.g(this.f34761b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, l0Var);
        }
    }

    public w1(xi.e0<T> e0Var, Callable<U> callable) {
        this.f34760a = e0Var;
        this.f34761b = callable;
    }
}
