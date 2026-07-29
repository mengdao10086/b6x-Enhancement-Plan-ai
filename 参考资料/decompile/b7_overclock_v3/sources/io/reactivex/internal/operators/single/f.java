package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35023a;

    public static final class a<T> implements l0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l0<? super T> f35024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f35025b;

        public a(l0<? super T> l0Var) {
            this.f35024a = l0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f35024a = null;
            this.f35025b.dispose();
            this.f35025b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35025b.isDisposed();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f35025b = DisposableHelper.DISPOSED;
            l0<? super T> l0Var = this.f35024a;
            if (l0Var != null) {
                this.f35024a = null;
                l0Var.onError(th2);
            }
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f35025b, bVar)) {
                this.f35025b = bVar;
                this.f35024a.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f35025b = DisposableHelper.DISPOSED;
            l0<? super T> l0Var = this.f35024a;
            if (l0Var != null) {
                this.f35024a = null;
                l0Var.onSuccess(t10);
            }
        }
    }

    public f(o0<T> o0Var) {
        this.f35023a = o0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35023a.a(new a(l0Var));
    }
}
