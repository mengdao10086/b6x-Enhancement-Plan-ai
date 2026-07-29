package vt;

import tt.n;

/* JADX INFO: loaded from: classes6.dex */
public class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e[] f53371d;

    public b(Class cls, boolean z10, e[] eVarArr) {
        super(cls, null, z10);
        this.f53371d = eVarArr;
    }

    @Override // vt.c
    public synchronized n[] a() {
        n[] nVarArr;
        int length = this.f53371d.length;
        nVarArr = new n[length];
        for (int i10 = 0; i10 < length; i10++) {
            e eVar = this.f53371d[i10];
            nVarArr[i10] = g(eVar.f53372a, eVar.f53374c, eVar.f53373b, eVar.f53375d, eVar.f53376e);
        }
        return nVarArr;
    }
}
