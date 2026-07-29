package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class o1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f34643b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f34645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34647d;

        public a(xi.g0<? super T> g0Var, dj.r<? super T> rVar) {
            this.f34644a = g0Var;
            this.f34645b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34646c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34646c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34644a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34644a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34647d) {
                this.f34644a.onNext(t10);
                return;
            }
            try {
                if (this.f34645b.a(t10)) {
                    return;
                }
                this.f34647d = true;
                this.f34644a.onNext(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34646c.dispose();
                this.f34644a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34646c, bVar)) {
                this.f34646c = bVar;
                this.f34644a.onSubscribe(this);
            }
        }
    }

    public o1(xi.e0<T> e0Var, dj.r<? super T> rVar) {
        super(e0Var);
        this.f34643b = rVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34643b));
    }
}
