package io.reactivex.internal.operators.completable;

import xi.e0;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class k<T> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0<T> f33101a;

    public static final class a<T> implements g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33102a;

        public a(xi.d dVar) {
            this.f33102a = dVar;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f33102a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f33102a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33102a.onSubscribe(bVar);
        }
    }

    public k(e0<T> e0Var) {
        this.f33101a = e0Var;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33101a.c(new a(dVar));
    }
}
