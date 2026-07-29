package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class p1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<? extends T> f34661b;

    public static final class a<T> implements xi.g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.e0<? extends T> f34663b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34665d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SequentialDisposable f34664c = new SequentialDisposable();

        public a(xi.g0<? super T> g0Var, xi.e0<? extends T> e0Var) {
            this.f34662a = g0Var;
            this.f34663b = e0Var;
        }

        @Override // xi.g0
        public void onComplete() {
            if (!this.f34665d) {
                this.f34662a.onComplete();
            } else {
                this.f34665d = false;
                this.f34663b.c(this);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34662a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34665d) {
                this.f34665d = false;
            }
            this.f34662a.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34664c.b(bVar);
        }
    }

    public p1(xi.e0<T> e0Var, xi.e0<? extends T> e0Var2) {
        super(e0Var);
        this.f34661b = e0Var2;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        a aVar = new a(g0Var, this.f34661b);
        g0Var.onSubscribe(aVar.f34664c);
        this.f34421a.c(aVar);
    }
}
