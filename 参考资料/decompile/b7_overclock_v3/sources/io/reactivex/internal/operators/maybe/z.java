package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class z<T> extends xi.i0<Boolean> implements fj.f<T>, fj.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f34018a;

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super Boolean> f34019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34020b;

        public a(l0<? super Boolean> l0Var) {
            this.f34019a = l0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34020b.dispose();
            this.f34020b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34020b.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f34020b = DisposableHelper.DISPOSED;
            this.f34019a.onSuccess(Boolean.TRUE);
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f34020b = DisposableHelper.DISPOSED;
            this.f34019a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34020b, bVar)) {
                this.f34020b = bVar;
                this.f34019a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f34020b = DisposableHelper.DISPOSED;
            this.f34019a.onSuccess(Boolean.FALSE);
        }
    }

    public z(xi.w<T> wVar) {
        this.f34018a = wVar;
    }

    @Override // xi.i0
    public void b1(l0<? super Boolean> l0Var) {
        this.f34018a.a(new a(l0Var));
    }

    @Override // fj.c
    public xi.q<Boolean> c() {
        return kj.a.T(new y(this.f34018a));
    }

    @Override // fj.f
    public xi.w<T> source() {
        return this.f34018a;
    }
}
