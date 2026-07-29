package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class n<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f33984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f33985b;

    public static final class a<T> implements l0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f33987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33988c;

        public a(xi.t<? super T> tVar, dj.r<? super T> rVar) {
            this.f33986a = tVar;
            this.f33987b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.f33988c;
            this.f33988c = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33988c.isDisposed();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f33986a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33988c, bVar)) {
                this.f33988c = bVar;
                this.f33986a.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                if (this.f33987b.a(t10)) {
                    this.f33986a.onSuccess(t10);
                } else {
                    this.f33986a.onComplete();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33986a.onError(th2);
            }
        }
    }

    public n(o0<T> o0Var, dj.r<? super T> rVar) {
        this.f33984a = o0Var;
        this.f33985b = rVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33984a.a(new a(tVar, this.f33985b));
    }
}
