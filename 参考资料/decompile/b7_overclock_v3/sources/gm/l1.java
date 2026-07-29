package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class l1 extends h0 {
    public l1() {
    }

    public l1(h hVar) {
        super(hVar);
    }

    public l1(i iVar) {
        super(iVar, false);
    }

    public l1(boolean z10, h[] hVarArr) {
        super(z10, hVarArr);
    }

    public l1(h[] hVarArr) {
        super(hVarArr, false);
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        int iA = z10 ? 4 : 3;
        int length = this.f29697a.length;
        for (int i10 = 0; i10 < length; i10++) {
            iA += this.f29697a[i10].b().A(true);
        }
        return iA;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.u(z10, 49, this.f29697a);
    }
}
