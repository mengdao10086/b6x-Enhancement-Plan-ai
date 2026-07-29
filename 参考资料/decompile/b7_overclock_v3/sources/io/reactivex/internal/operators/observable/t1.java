package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class t1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f34719b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f34721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34723d;

        public a(xi.g0<? super T> g0Var, dj.r<? super T> rVar) {
            this.f34720a = g0Var;
            this.f34721b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34722c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34722c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34723d) {
                return;
            }
            this.f34723d = true;
            this.f34720a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34723d) {
                kj.a.Y(th2);
            } else {
                this.f34723d = true;
                this.f34720a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34723d) {
                return;
            }
            try {
                if (this.f34721b.a(t10)) {
                    this.f34720a.onNext(t10);
                    return;
                }
                this.f34723d = true;
                this.f34722c.dispose();
                this.f34720a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34722c.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34722c, bVar)) {
                this.f34722c = bVar;
                this.f34720a.onSubscribe(this);
            }
        }
    }

    public t1(xi.e0<T> e0Var, dj.r<? super T> rVar) {
        super(e0Var);
        this.f34719b = rVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34719b));
    }
}
