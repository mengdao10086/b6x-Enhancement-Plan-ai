package io.reactivex.internal.operators.parallel;

import dj.o;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T, R> extends jj.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<T> f34883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends bu.c<? extends R>> f34884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34887e;

    public e(jj.a<T> aVar, o<? super T, ? extends bu.c<? extends R>> oVar, boolean z10, int i10, int i11) {
        this.f34883a = aVar;
        this.f34884b = oVar;
        this.f34885c = z10;
        this.f34886d = i10;
        this.f34887e = i11;
    }

    @Override // jj.a
    public int F() {
        return this.f34883a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super R>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super T>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                dVarArr2[i10] = FlowableFlatMap.M8(dVarArr[i10], this.f34884b, this.f34885c, this.f34886d, this.f34887e);
            }
            this.f34883a.Q(dVarArr2);
        }
    }
}
