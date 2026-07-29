package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class u<T, U> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<? extends T> f34724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<U> f34725b;

    public final class a implements xi.g0<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SequentialDisposable f34726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.g0<? super T> f34727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f34728c;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.u$a$a, reason: collision with other inner class name */
        public final class C0390a implements xi.g0<T> {
            public C0390a() {
            }

            @Override // xi.g0
            public void onComplete() {
                a.this.f34727b.onComplete();
            }

            @Override // xi.g0
            public void onError(Throwable th2) {
                a.this.f34727b.onError(th2);
            }

            @Override // xi.g0
            public void onNext(T t10) {
                a.this.f34727b.onNext(t10);
            }

            @Override // xi.g0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                a.this.f34726a.b(bVar);
            }
        }

        public a(SequentialDisposable sequentialDisposable, xi.g0<? super T> g0Var) {
            this.f34726a = sequentialDisposable;
            this.f34727b = g0Var;
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34728c) {
                return;
            }
            this.f34728c = true;
            u.this.f34724a.c(new C0390a());
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34728c) {
                kj.a.Y(th2);
            } else {
                this.f34728c = true;
                this.f34727b.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(U u6) {
            onComplete();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34726a.b(bVar);
        }
    }

    public u(xi.e0<? extends T> e0Var, xi.e0<U> e0Var2) {
        this.f34724a = e0Var;
        this.f34725b = e0Var2;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g0Var.onSubscribe(sequentialDisposable);
        this.f34725b.c(new a(sequentialDisposable, g0Var));
    }
}
