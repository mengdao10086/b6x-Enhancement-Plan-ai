package ir;

/* JADX INFO: loaded from: classes6.dex */
public class w extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i[] f35737a;

    public w(i[] iVarArr, int i10, int i11) {
        this.f35737a = d(iVarArr, i10, i11);
    }

    public static i[] d(i[] iVarArr, int i10, int i11) {
        i[] iVarArr2 = new i[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iVarArr2[i12] = iVarArr[i10 + i12];
        }
        return iVarArr2;
    }

    @Override // ir.g
    public i a(int i10) {
        throw new UnsupportedOperationException("Constant-time lookup not supported");
    }

    @Override // ir.a, ir.g
    public i b(int i10) {
        return this.f35737a[i10];
    }

    @Override // ir.g
    public int c() {
        return this.f35737a.length;
    }
}
