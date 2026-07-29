package io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicInteger;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class n<T> extends i0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f35057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0<? extends T> f35058b;

    public static class a<T> implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.disposables.a f35060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[] f35061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l0<? super Boolean> f35062d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicInteger f35063e;

        public a(int i10, io.reactivex.disposables.a aVar, Object[] objArr, l0<? super Boolean> l0Var, AtomicInteger atomicInteger) {
            this.f35059a = i10;
            this.f35060b = aVar;
            this.f35061c = objArr;
            this.f35062d = l0Var;
            this.f35063e = atomicInteger;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            int i10;
            do {
                i10 = this.f35063e.get();
                if (i10 >= 2) {
                    kj.a.Y(th2);
                    return;
                }
            } while (!this.f35063e.compareAndSet(i10, 2));
            this.f35060b.dispose();
            this.f35062d.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f35060b.b(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f35061c[this.f35059a] = t10;
            if (this.f35063e.incrementAndGet() == 2) {
                l0<? super Boolean> l0Var = this.f35062d;
                Object[] objArr = this.f35061c;
                l0Var.onSuccess(Boolean.valueOf(io.reactivex.internal.functions.a.c(objArr[0], objArr[1])));
            }
        }
    }

    public n(o0<? extends T> o0Var, o0<? extends T> o0Var2) {
        this.f35057a = o0Var;
        this.f35058b = o0Var2;
    }

    @Override // xi.i0
    public void b1(l0<? super Boolean> l0Var) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        l0Var.onSubscribe(aVar);
        this.f35057a.a(new a(0, aVar, objArr, l0Var, atomicInteger));
        this.f35058b.a(new a(1, aVar, objArr, l0Var, atomicInteger));
    }
}
