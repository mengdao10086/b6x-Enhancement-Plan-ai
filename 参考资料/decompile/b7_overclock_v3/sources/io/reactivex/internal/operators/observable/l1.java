package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class l1<T> extends xi.i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<? extends T> f34581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f34582b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super T> f34583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f34584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f34586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34587e;

        public a(xi.l0<? super T> l0Var, T t10) {
            this.f34583a = l0Var;
            this.f34584b = t10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34585c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34585c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34587e) {
                return;
            }
            this.f34587e = true;
            T t10 = this.f34586d;
            this.f34586d = null;
            if (t10 == null) {
                t10 = this.f34584b;
            }
            if (t10 != null) {
                this.f34583a.onSuccess(t10);
            } else {
                this.f34583a.onError(new NoSuchElementException());
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34587e) {
                kj.a.Y(th2);
            } else {
                this.f34587e = true;
                this.f34583a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34587e) {
                return;
            }
            if (this.f34586d == null) {
                this.f34586d = t10;
                return;
            }
            this.f34587e = true;
            this.f34585c.dispose();
            this.f34583a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34585c, bVar)) {
                this.f34585c = bVar;
                this.f34583a.onSubscribe(this);
            }
        }
    }

    public l1(xi.e0<? extends T> e0Var, T t10) {
        this.f34581a = e0Var;
        this.f34582b = t10;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super T> l0Var) {
        this.f34581a.c(new a(l0Var, this.f34582b));
    }
}
