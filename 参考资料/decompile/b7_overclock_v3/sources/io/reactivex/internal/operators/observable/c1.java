package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class c1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends T> f34463b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super Throwable, ? extends T> f34465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34466c;

        public a(xi.g0<? super T> g0Var, dj.o<? super Throwable, ? extends T> oVar) {
            this.f34464a = g0Var;
            this.f34465b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34466c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34466c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34464a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            try {
                T tApply = this.f34465b.apply(th2);
                if (tApply != null) {
                    this.f34464a.onNext(tApply);
                    this.f34464a.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th2);
                    this.f34464a.onError(nullPointerException);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f34464a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34464a.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34466c, bVar)) {
                this.f34466c = bVar;
                this.f34464a.onSubscribe(this);
            }
        }
    }

    public c1(xi.e0<T> e0Var, dj.o<? super Throwable, ? extends T> oVar) {
        super(e0Var);
        this.f34463b = oVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34463b));
    }
}
