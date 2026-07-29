package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class v<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.y<R>> f34742b;

    public static final class a<T, R> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super R> f34743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends xi.y<R>> f34744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f34745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f34746d;

        public a(xi.g0<? super R> g0Var, dj.o<? super T, ? extends xi.y<R>> oVar) {
            this.f34743a = g0Var;
            this.f34744b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34746d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34746d.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34745c) {
                return;
            }
            this.f34745c = true;
            this.f34743a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34745c) {
                kj.a.Y(th2);
            } else {
                this.f34745c = true;
                this.f34743a.onError(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34745c) {
                if (t10 instanceof xi.y) {
                    xi.y yVar = (xi.y) t10;
                    if (yVar.g()) {
                        kj.a.Y(yVar.d());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                xi.y yVar2 = (xi.y) io.reactivex.internal.functions.a.g(this.f34744b.apply(t10), "The selector returned a null Notification");
                if (yVar2.g()) {
                    this.f34746d.dispose();
                    onError(yVar2.d());
                } else if (!yVar2.f()) {
                    this.f34743a.onNext((Object) yVar2.e());
                } else {
                    this.f34746d.dispose();
                    onComplete();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34746d.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34746d, bVar)) {
                this.f34746d = bVar;
                this.f34743a.onSubscribe(this);
            }
        }
    }

    public v(xi.e0<T> e0Var, dj.o<? super T, ? extends xi.y<R>> oVar) {
        super(e0Var);
        this.f34742b = oVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34742b));
    }
}
