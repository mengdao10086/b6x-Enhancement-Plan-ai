package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class c<T> extends xi.i0<Boolean> implements fj.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f33924b;

    public static final class a implements xi.t<Object>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super Boolean> f33925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f33926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33927c;

        public a(l0<? super Boolean> l0Var, Object obj) {
            this.f33925a = l0Var;
            this.f33926b = obj;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33927c.dispose();
            this.f33927c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33927c.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33927c = DisposableHelper.DISPOSED;
            this.f33925a.onSuccess(Boolean.FALSE);
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33927c = DisposableHelper.DISPOSED;
            this.f33925a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33927c, bVar)) {
                this.f33927c = bVar;
                this.f33925a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(Object obj) {
            this.f33927c = DisposableHelper.DISPOSED;
            this.f33925a.onSuccess(Boolean.valueOf(io.reactivex.internal.functions.a.c(obj, this.f33926b)));
        }
    }

    public c(xi.w<T> wVar, Object obj) {
        this.f33923a = wVar;
        this.f33924b = obj;
    }

    @Override // xi.i0
    public void b1(l0<? super Boolean> l0Var) {
        this.f33923a.a(new a(l0Var, this.f33924b));
    }

    @Override // fj.f
    public xi.w<T> source() {
        return this.f33923a;
    }
}
