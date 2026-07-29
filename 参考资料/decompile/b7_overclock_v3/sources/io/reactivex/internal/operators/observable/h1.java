package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class h1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.c<T, T, T> f34536b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.c<T, T, T> f34538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f34540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34541e;

        public a(xi.g0<? super T> g0Var, dj.c<T, T, T> cVar) {
            this.f34537a = g0Var;
            this.f34538b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34539c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34539c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34541e) {
                return;
            }
            this.f34541e = true;
            this.f34537a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34541e) {
                kj.a.Y(th2);
            } else {
                this.f34541e = true;
                this.f34537a.onError(th2);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34541e) {
                return;
            }
            xi.g0<? super T> g0Var = this.f34537a;
            T t11 = this.f34540d;
            if (t11 == null) {
                this.f34540d = t10;
                g0Var.onNext(t10);
                return;
            }
            try {
                ?? r42 = (T) io.reactivex.internal.functions.a.g(this.f34538b.apply(t11, t10), "The value returned by the accumulator is null");
                this.f34540d = r42;
                g0Var.onNext(r42);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34539c.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34539c, bVar)) {
                this.f34539c = bVar;
                this.f34537a.onSubscribe(this);
            }
        }
    }

    public h1(xi.e0<T> e0Var, dj.c<T, T, T> cVar) {
        super(e0Var);
        this.f34536b = cVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34536b));
    }
}
