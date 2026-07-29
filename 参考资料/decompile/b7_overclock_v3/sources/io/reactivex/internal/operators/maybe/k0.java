package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.maybe.c0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class k0<T, R> extends xi.q<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<? extends xi.w<? extends T>> f33976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Object[], ? extends R> f33977b;

    public final class a implements dj.o<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // dj.o
        public R apply(T t10) throws Exception {
            return (R) io.reactivex.internal.functions.a.g(k0.this.f33977b.apply(new Object[]{t10}), "The zipper returned a null value");
        }
    }

    public k0(Iterable<? extends xi.w<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        this.f33976a = iterable;
        this.f33977b = oVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        xi.w[] wVarArr = new xi.w[8];
        try {
            int i10 = 0;
            for (xi.w<? extends T> wVar : this.f33976a) {
                if (wVar == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), tVar);
                    return;
                }
                if (i10 == wVarArr.length) {
                    wVarArr = (xi.w[]) Arrays.copyOf(wVarArr, (i10 >> 2) + i10);
                }
                int i11 = i10 + 1;
                wVarArr[i10] = wVar;
                i10 = i11;
            }
            if (i10 == 0) {
                EmptyDisposable.complete(tVar);
                return;
            }
            if (i10 == 1) {
                wVarArr[0].a(new c0.a(tVar, new a()));
                return;
            }
            MaybeZipArray.ZipCoordinator zipCoordinator = new MaybeZipArray.ZipCoordinator(tVar, i10, this.f33977b);
            tVar.onSubscribe(zipCoordinator);
            for (int i12 = 0; i12 < i10 && !zipCoordinator.isDisposed(); i12++) {
                wVarArr[i12].a(zipCoordinator.observers[i12]);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, tVar);
        }
    }
}
