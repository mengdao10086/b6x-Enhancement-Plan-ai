package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T> extends io.reactivex.internal.operators.observable.a<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f34519b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super Boolean> f34520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f34521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34523d;

        public a(xi.g0<? super Boolean> g0Var, dj.r<? super T> rVar) {
            this.f34520a = g0Var;
            this.f34521b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34522c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34522c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34523d) {
                return;
            }
            this.f34523d = true;
            this.f34520a.onNext(Boolean.FALSE);
            this.f34520a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34523d) {
                kj.a.Y(th2);
            } else {
                this.f34523d = true;
                this.f34520a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34523d) {
                return;
            }
            try {
                if (this.f34521b.a(t10)) {
                    this.f34523d = true;
                    this.f34522c.dispose();
                    this.f34520a.onNext(Boolean.TRUE);
                    this.f34520a.onComplete();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34522c.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34522c, bVar)) {
                this.f34522c = bVar;
                this.f34520a.onSubscribe(this);
            }
        }
    }

    public g(xi.e0<T> e0Var, dj.r<? super T> rVar) {
        super(e0Var);
        this.f34519b = rVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super Boolean> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34519b));
    }
}
