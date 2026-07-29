package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.v;
import java.util.Arrays;
import java.util.NoSuchElementException;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class z<T, R> extends i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<? extends o0<? extends T>> f35090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Object[], ? extends R> f35091b;

    public final class a implements dj.o<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // dj.o
        public R apply(T t10) throws Exception {
            return (R) io.reactivex.internal.functions.a.g(z.this.f35091b.apply(new Object[]{t10}), "The zipper returned a null value");
        }
    }

    public z(Iterable<? extends o0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        this.f35090a = iterable;
        this.f35091b = oVar;
    }

    @Override // xi.i0
    public void b1(l0<? super R> l0Var) {
        o0[] o0VarArr = new o0[8];
        try {
            int i10 = 0;
            for (o0<? extends T> o0Var : this.f35090a) {
                if (o0Var == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), l0Var);
                    return;
                }
                if (i10 == o0VarArr.length) {
                    o0VarArr = (o0[]) Arrays.copyOf(o0VarArr, (i10 >> 2) + i10);
                }
                int i11 = i10 + 1;
                o0VarArr[i10] = o0Var;
                i10 = i11;
            }
            if (i10 == 0) {
                EmptyDisposable.error(new NoSuchElementException(), l0Var);
                return;
            }
            if (i10 == 1) {
                o0VarArr[0].a(new v.a(l0Var, new a()));
                return;
            }
            SingleZipArray.ZipCoordinator zipCoordinator = new SingleZipArray.ZipCoordinator(l0Var, i10, this.f35091b);
            l0Var.onSubscribe(zipCoordinator);
            for (int i12 = 0; i12 < i10 && !zipCoordinator.isDisposed(); i12++) {
                o0VarArr[i12].a(zipCoordinator.observers[i12]);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, l0Var);
        }
    }
}
