package io.reactivex.internal.operators.single;

import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super T> f35050b;

    public final class a implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35051a;

        public a(l0<? super T> l0Var) {
            this.f35051a = l0Var;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f35051a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f35051a.onSubscribe(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                l.this.f35050b.accept(t10);
                this.f35051a.onSuccess(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f35051a.onError(th2);
            }
        }
    }

    public l(o0<T> o0Var, dj.g<? super T> gVar) {
        this.f35049a = o0Var;
        this.f35050b = gVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35049a.a(new a(l0Var));
    }
}
