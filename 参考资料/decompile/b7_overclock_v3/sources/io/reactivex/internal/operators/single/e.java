package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
@bj.d
public final class e<T, R> extends xi.q<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0<T> f35018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, xi.y<R>> f35019b;

    public static final class a<T, R> implements l0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super R> f35020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, xi.y<R>> f35021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f35022c;

        public a(xi.t<? super R> tVar, dj.o<? super T, xi.y<R>> oVar) {
            this.f35020a = tVar;
            this.f35021b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f35022c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35022c.isDisposed();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f35020a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f35022c, bVar)) {
                this.f35022c = bVar;
                this.f35020a.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                xi.y yVar = (xi.y) io.reactivex.internal.functions.a.g(this.f35021b.apply(t10), "The selector returned a null Notification");
                if (yVar.h()) {
                    this.f35020a.onSuccess((Object) yVar.e());
                } else if (yVar.f()) {
                    this.f35020a.onComplete();
                } else {
                    this.f35020a.onError(yVar.d());
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f35020a.onError(th2);
            }
        }
    }

    public e(i0<T> i0Var, dj.o<? super T, xi.y<R>> oVar) {
        this.f35018a = i0Var;
        this.f35019b = oVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        this.f35018a.a(new a(tVar, this.f35019b));
    }
}
