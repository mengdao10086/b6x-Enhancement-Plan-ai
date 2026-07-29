package io.reactivex.internal.operators.single;

import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class v<T, R> extends i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f35079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends R> f35080b;

    public static final class a<T, R> implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super R> f35081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends R> f35082b;

        public a(l0<? super R> l0Var, dj.o<? super T, ? extends R> oVar) {
            this.f35081a = l0Var;
            this.f35082b = oVar;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f35081a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f35081a.onSubscribe(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                this.f35081a.onSuccess(io.reactivex.internal.functions.a.g(this.f35082b.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(th2);
            }
        }
    }

    public v(o0<? extends T> o0Var, dj.o<? super T, ? extends R> oVar) {
        this.f35079a = o0Var;
        this.f35080b = oVar;
    }

    @Override // xi.i0
    public void b1(l0<? super R> l0Var) {
        this.f35079a.a(new a(l0Var, this.f35080b));
    }
}
