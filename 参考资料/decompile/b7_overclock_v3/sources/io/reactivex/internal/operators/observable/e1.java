package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class e1<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.c<T, T, T> f34499b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f34500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.c<T, T, T> f34501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f34502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f34503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public io.reactivex.disposables.b f34504e;

        public a(xi.t<? super T> tVar, dj.c<T, T, T> cVar) {
            this.f34500a = tVar;
            this.f34501b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34504e.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34504e.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34502c) {
                return;
            }
            this.f34502c = true;
            T t10 = this.f34503d;
            this.f34503d = null;
            if (t10 != null) {
                this.f34500a.onSuccess(t10);
            } else {
                this.f34500a.onComplete();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34502c) {
                kj.a.Y(th2);
                return;
            }
            this.f34502c = true;
            this.f34503d = null;
            this.f34500a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34502c) {
                return;
            }
            T t11 = this.f34503d;
            if (t11 == null) {
                this.f34503d = t10;
                return;
            }
            try {
                this.f34503d = (T) io.reactivex.internal.functions.a.g(this.f34501b.apply(t11, t10), "The reducer returned a null value");
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34504e.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34504e, bVar)) {
                this.f34504e = bVar;
                this.f34500a.onSubscribe(this);
            }
        }
    }

    public e1(xi.e0<T> e0Var, dj.c<T, T, T> cVar) {
        this.f34498a = e0Var;
        this.f34499b = cVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f34498a.c(new a(tVar, this.f34499b));
    }
}
