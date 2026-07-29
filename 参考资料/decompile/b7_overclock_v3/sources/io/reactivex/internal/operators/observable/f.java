package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends xi.i0<Boolean> implements fj.d<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f34506b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super Boolean> f34507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f34508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34510d;

        public a(xi.l0<? super Boolean> l0Var, dj.r<? super T> rVar) {
            this.f34507a = l0Var;
            this.f34508b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34509c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34509c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34510d) {
                return;
            }
            this.f34510d = true;
            this.f34507a.onSuccess(Boolean.TRUE);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34510d) {
                kj.a.Y(th2);
            } else {
                this.f34510d = true;
                this.f34507a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34510d) {
                return;
            }
            try {
                if (this.f34508b.a(t10)) {
                    return;
                }
                this.f34510d = true;
                this.f34509c.dispose();
                this.f34507a.onSuccess(Boolean.FALSE);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34509c.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34509c, bVar)) {
                this.f34509c = bVar;
                this.f34507a.onSubscribe(this);
            }
        }
    }

    public f(xi.e0<T> e0Var, dj.r<? super T> rVar) {
        this.f34505a = e0Var;
        this.f34506b = rVar;
    }

    @Override // fj.d
    public xi.z<Boolean> b() {
        return kj.a.U(new e(this.f34505a, this.f34506b));
    }

    @Override // xi.i0
    public void b1(xi.l0<? super Boolean> l0Var) {
        this.f34505a.c(new a(l0Var, this.f34506b));
    }
}
