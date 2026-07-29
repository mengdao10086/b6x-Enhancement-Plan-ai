package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class i1 extends f0 {
    public i1() {
    }

    public i1(h hVar) {
        super(hVar);
    }

    public i1(i iVar) {
        super(iVar);
    }

    public i1(h[] hVarArr) {
        super(hVarArr);
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        int iA = z10 ? 4 : 3;
        int length = this.f29678a.length;
        for (int i10 = 0; i10 < length; i10++) {
            iA += this.f29678a[i10].b().A(true);
        }
        return iA;
    }

    @Override // gm.f0
    public d N() {
        return new a1(G());
    }

    @Override // gm.f0
    public l O() {
        return ((f0) F()).O();
    }

    @Override // gm.f0
    public z P() {
        return new e1(H());
    }

    @Override // gm.f0
    public h0 Q() {
        return new l1(false, S());
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.u(z10, 48, this.f29678a);
    }
}
