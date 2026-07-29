package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class f1<T, R> extends xi.i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final R f34513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<R, ? super T, R> f34514c;

    public static final class a<T, R> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super R> f34515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.c<R, ? super T, R> f34516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public R f34517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f34518d;

        public a(xi.l0<? super R> l0Var, dj.c<R, ? super T, R> cVar, R r10) {
            this.f34515a = l0Var;
            this.f34517c = r10;
            this.f34516b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34518d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34518d.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            R r10 = this.f34517c;
            if (r10 != null) {
                this.f34517c = null;
                this.f34515a.onSuccess(r10);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34517c == null) {
                kj.a.Y(th2);
            } else {
                this.f34517c = null;
                this.f34515a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            R r10 = this.f34517c;
            if (r10 != null) {
                try {
                    this.f34517c = (R) io.reactivex.internal.functions.a.g(this.f34516b.apply(r10, t10), "The reducer returned a null value");
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f34518d.dispose();
                    onError(th2);
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34518d, bVar)) {
                this.f34518d = bVar;
                this.f34515a.onSubscribe(this);
            }
        }
    }

    public f1(xi.e0<T> e0Var, R r10, dj.c<R, ? super T, R> cVar) {
        this.f34512a = e0Var;
        this.f34513b = r10;
        this.f34514c = cVar;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super R> l0Var) {
        this.f34512a.c(new a(l0Var, this.f34514c, this.f34513b));
    }
}
