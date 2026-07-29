package io.reactivex.internal.operators.single;

import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> extends i0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f35001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.d<Object, Object> f35002c;

    public final class a implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super Boolean> f35003a;

        public a(l0<? super Boolean> l0Var) {
            this.f35003a = l0Var;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f35003a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f35003a.onSubscribe(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                b bVar = b.this;
                this.f35003a.onSuccess(Boolean.valueOf(bVar.f35002c.a(t10, bVar.f35001b)));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f35003a.onError(th2);
            }
        }
    }

    public b(o0<T> o0Var, Object obj, dj.d<Object, Object> dVar) {
        this.f35000a = o0Var;
        this.f35001b = obj;
        this.f35002c = dVar;
    }

    @Override // xi.i0
    public void b1(l0<? super Boolean> l0Var) {
        this.f35000a.a(new a(l0Var));
    }
}
