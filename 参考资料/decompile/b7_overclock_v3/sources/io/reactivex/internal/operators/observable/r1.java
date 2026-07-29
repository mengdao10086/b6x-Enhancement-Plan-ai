package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class r1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f34693c;

        public a(xi.g0<? super T> g0Var) {
            this.f34691a = g0Var;
        }

        public void a() {
            T t10 = this.f34693c;
            if (t10 != null) {
                this.f34693c = null;
                this.f34691a.onNext(t10);
            }
            this.f34691a.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34693c = null;
            this.f34692b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34692b.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34693c = null;
            this.f34691a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34693c = t10;
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34692b, bVar)) {
                this.f34692b = bVar;
                this.f34691a.onSubscribe(this);
            }
        }
    }

    public r1(xi.e0<T> e0Var) {
        super(e0Var);
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var));
    }
}
