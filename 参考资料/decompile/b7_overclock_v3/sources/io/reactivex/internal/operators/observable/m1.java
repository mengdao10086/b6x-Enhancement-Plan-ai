package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class m1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34609b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f34611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34612c;

        public a(xi.g0<? super T> g0Var, long j10) {
            this.f34610a = g0Var;
            this.f34611b = j10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34612c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34612c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34610a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34610a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            long j10 = this.f34611b;
            if (j10 != 0) {
                this.f34611b = j10 - 1;
            } else {
                this.f34610a.onNext(t10);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34612c, bVar)) {
                this.f34612c = bVar;
                this.f34610a.onSubscribe(this);
            }
        }
    }

    public m1(xi.e0<T> e0Var, long j10) {
        super(e0Var);
        this.f34609b = j10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34609b));
    }
}
