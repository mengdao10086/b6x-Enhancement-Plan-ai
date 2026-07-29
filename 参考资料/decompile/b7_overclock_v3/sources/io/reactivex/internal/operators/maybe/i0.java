package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class i0<T> extends xi.i0<T> implements fj.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f33970b;

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f33971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f33972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33973c;

        public a(l0<? super T> l0Var, T t10) {
            this.f33971a = l0Var;
            this.f33972b = t10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33973c.dispose();
            this.f33973c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33973c.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33973c = DisposableHelper.DISPOSED;
            T t10 = this.f33972b;
            if (t10 != null) {
                this.f33971a.onSuccess(t10);
            } else {
                this.f33971a.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33973c = DisposableHelper.DISPOSED;
            this.f33971a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33973c, bVar)) {
                this.f33973c = bVar;
                this.f33971a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f33973c = DisposableHelper.DISPOSED;
            this.f33971a.onSuccess(t10);
        }
    }

    public i0(xi.w<T> wVar, T t10) {
        this.f33969a = wVar;
        this.f33970b = t10;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f33969a.a(new a(l0Var, this.f33970b));
    }

    @Override // fj.f
    public xi.w<T> source() {
        return this.f33969a;
    }
}
