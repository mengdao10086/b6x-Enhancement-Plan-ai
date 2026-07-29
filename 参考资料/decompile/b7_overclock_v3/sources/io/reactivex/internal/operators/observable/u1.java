package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class u1<T> extends io.reactivex.internal.operators.observable.a<T, lj.d<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f34735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34736c;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super lj.d<T>> f34737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TimeUnit f34738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final xi.h0 f34739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f34740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public io.reactivex.disposables.b f34741e;

        public a(xi.g0<? super lj.d<T>> g0Var, TimeUnit timeUnit, xi.h0 h0Var) {
            this.f34737a = g0Var;
            this.f34739c = h0Var;
            this.f34738b = timeUnit;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34741e.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34741e.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34737a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34737a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            long jE = this.f34739c.e(this.f34738b);
            long j10 = this.f34740d;
            this.f34740d = jE;
            this.f34737a.onNext(new lj.d(t10, jE - j10, this.f34738b));
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34741e, bVar)) {
                this.f34741e = bVar;
                this.f34740d = this.f34739c.e(this.f34738b);
                this.f34737a.onSubscribe(this);
            }
        }
    }

    public u1(xi.e0<T> e0Var, TimeUnit timeUnit, xi.h0 h0Var) {
        super(e0Var);
        this.f34735b = h0Var;
        this.f34736c = timeUnit;
    }

    @Override // xi.z
    public void I5(xi.g0<? super lj.d<T>> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34736c, this.f34735b));
    }
}
