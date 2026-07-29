package wc;

import hd.u0;
import java.util.Collections;
import java.util.List;
import qc.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qc.b[] f54635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f54636b;

    public b(qc.b[] bVarArr, long[] jArr) {
        this.f54635a = bVarArr;
        this.f54636b = jArr;
    }

    @Override // qc.f
    public int c(long j10) {
        int iF = u0.f(this.f54636b, j10, false, false);
        if (iF < this.f54636b.length) {
            return iF;
        }
        return -1;
    }

    @Override // qc.f
    public long d(int i10) {
        hd.a.a(i10 >= 0);
        hd.a.a(i10 < this.f54636b.length);
        return this.f54636b[i10];
    }

    @Override // qc.f
    public List<qc.b> e(long j10) {
        int iJ = u0.j(this.f54636b, j10, true, false);
        if (iJ != -1) {
            qc.b[] bVarArr = this.f54635a;
            if (bVarArr[iJ] != qc.b.f47222q) {
                return Collections.singletonList(bVarArr[iJ]);
            }
        }
        return Collections.emptyList();
    }

    @Override // qc.f
    public int f() {
        return this.f54636b.length;
    }
}
