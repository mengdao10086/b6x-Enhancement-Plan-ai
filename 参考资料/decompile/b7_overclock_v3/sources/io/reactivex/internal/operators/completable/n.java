package io.reactivex.internal.operators.completable;

import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class n<T> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f33107a;

    public static final class a<T> implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33108a;

        public a(xi.d dVar) {
            this.f33108a = dVar;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f33108a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33108a.onSubscribe(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f33108a.onComplete();
        }
    }

    public n(o0<T> o0Var) {
        this.f33107a = o0Var;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33107a.a(new a(dVar));
    }
}
