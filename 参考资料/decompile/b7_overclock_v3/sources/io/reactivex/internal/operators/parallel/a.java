package io.reactivex.internal.operators.parallel;

import dj.o;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;

/* JADX INFO: loaded from: classes5.dex */
public final class a<T, R> extends jj.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<T> f34848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends bu.c<? extends R>> f34849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ErrorMode f34851d;

    public a(jj.a<T> aVar, o<? super T, ? extends bu.c<? extends R>> oVar, int i10, ErrorMode errorMode) {
        this.f34848a = aVar;
        this.f34849b = (o) io.reactivex.internal.functions.a.g(oVar, "mapper");
        this.f34850c = i10;
        this.f34851d = (ErrorMode) io.reactivex.internal.functions.a.g(errorMode, "errorMode");
    }

    @Override // jj.a
    public int F() {
        return this.f34848a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super R>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super T>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                dVarArr2[i10] = FlowableConcatMap.M8(dVarArr[i10], this.f34849b, this.f34850c, this.f34851d);
            }
            this.f34848a.Q(dVarArr2);
        }
    }
}
