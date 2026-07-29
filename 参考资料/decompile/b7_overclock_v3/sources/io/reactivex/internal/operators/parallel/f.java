package io.reactivex.internal.operators.parallel;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends jj.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<T>[] f34888a;

    public f(bu.c<T>[] cVarArr) {
        this.f34888a = cVarArr;
    }

    @Override // jj.a
    public int F() {
        return this.f34888a.length;
    }

    @Override // jj.a
    public void Q(bu.d<? super T>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                this.f34888a[i10].d(dVarArr[i10]);
            }
        }
    }
}
