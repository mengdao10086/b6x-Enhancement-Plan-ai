package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class h<T> extends xi.i0<Boolean> implements fj.d<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f34529b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super Boolean> f34530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f34531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34532c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34533d;

        public a(xi.l0<? super Boolean> l0Var, dj.r<? super T> rVar) {
            this.f34530a = l0Var;
            this.f34531b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34532c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34532c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34533d) {
                return;
            }
            this.f34533d = true;
            this.f34530a.onSuccess(Boolean.FALSE);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34533d) {
                kj.a.Y(th2);
            } else {
                this.f34533d = true;
                this.f34530a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34533d) {
                return;
            }
            try {
                if (this.f34531b.a(t10)) {
                    this.f34533d = true;
                    this.f34532c.dispose();
                    this.f34530a.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34532c.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34532c, bVar)) {
                this.f34532c = bVar;
                this.f34530a.onSubscribe(this);
            }
        }
    }

    public h(xi.e0<T> e0Var, dj.r<? super T> rVar) {
        this.f34528a = e0Var;
        this.f34529b = rVar;
    }

    @Override // fj.d
    public xi.z<Boolean> b() {
        return kj.a.U(new g(this.f34528a, this.f34529b));
    }

    @Override // xi.i0
    public void b1(xi.l0<? super Boolean> l0Var) {
        this.f34528a.c(new a(l0Var, this.f34529b));
    }
}
