package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class k1<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34569a;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f34570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f34572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34573d;

        public a(xi.t<? super T> tVar) {
            this.f34570a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34571b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34571b.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34573d) {
                return;
            }
            this.f34573d = true;
            T t10 = this.f34572c;
            this.f34572c = null;
            if (t10 == null) {
                this.f34570a.onComplete();
            } else {
                this.f34570a.onSuccess(t10);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34573d) {
                kj.a.Y(th2);
            } else {
                this.f34573d = true;
                this.f34570a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34573d) {
                return;
            }
            if (this.f34572c == null) {
                this.f34572c = t10;
                return;
            }
            this.f34573d = true;
            this.f34571b.dispose();
            this.f34570a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34571b, bVar)) {
                this.f34571b = bVar;
                this.f34570a.onSubscribe(this);
            }
        }
    }

    public k1(xi.e0<T> e0Var) {
        this.f34569a = e0Var;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f34569a.c(new a(tVar));
    }
}
