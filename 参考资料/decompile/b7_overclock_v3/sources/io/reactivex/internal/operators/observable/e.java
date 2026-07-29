package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends io.reactivex.internal.operators.observable.a<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f34484b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super Boolean> f34485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f34486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34488d;

        public a(xi.g0<? super Boolean> g0Var, dj.r<? super T> rVar) {
            this.f34485a = g0Var;
            this.f34486b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34487c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34487c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34488d) {
                return;
            }
            this.f34488d = true;
            this.f34485a.onNext(Boolean.TRUE);
            this.f34485a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34488d) {
                kj.a.Y(th2);
            } else {
                this.f34488d = true;
                this.f34485a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34488d) {
                return;
            }
            try {
                if (this.f34486b.a(t10)) {
                    return;
                }
                this.f34488d = true;
                this.f34487c.dispose();
                this.f34485a.onNext(Boolean.FALSE);
                this.f34485a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34487c.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34487c, bVar)) {
                this.f34487c = bVar;
                this.f34485a.onSubscribe(this);
            }
        }
    }

    public e(xi.e0<T> e0Var, dj.r<? super T> rVar) {
        super(e0Var);
        this.f34484b = rVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super Boolean> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34484b));
    }
}
