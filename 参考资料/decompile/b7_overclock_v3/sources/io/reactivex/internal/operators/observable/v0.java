package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class v0<T> extends xi.i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f34748b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super T> f34749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f34750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f34752d;

        public a(xi.l0<? super T> l0Var, T t10) {
            this.f34749a = l0Var;
            this.f34750b = t10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34751c.dispose();
            this.f34751c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34751c == DisposableHelper.DISPOSED;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34751c = DisposableHelper.DISPOSED;
            T t10 = this.f34752d;
            if (t10 != null) {
                this.f34752d = null;
                this.f34749a.onSuccess(t10);
                return;
            }
            T t11 = this.f34750b;
            if (t11 != null) {
                this.f34749a.onSuccess(t11);
            } else {
                this.f34749a.onError(new NoSuchElementException());
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34751c = DisposableHelper.DISPOSED;
            this.f34752d = null;
            this.f34749a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34752d = t10;
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34751c, bVar)) {
                this.f34751c = bVar;
                this.f34749a.onSubscribe(this);
            }
        }
    }

    public v0(xi.e0<T> e0Var, T t10) {
        this.f34747a = e0Var;
        this.f34748b = t10;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super T> l0Var) {
        this.f34747a.c(new a(l0Var, this.f34748b));
    }
}
