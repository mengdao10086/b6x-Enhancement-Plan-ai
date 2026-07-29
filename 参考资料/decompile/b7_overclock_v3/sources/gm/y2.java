package gm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class y2 extends b0 {
    public y2(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // gm.b0
    public void A(c0[] c0VarArr) throws IOException {
        for (c0 c0Var : c0VarArr) {
            c0Var.F().y(this, true);
        }
    }

    @Override // gm.b0
    public y2 g() {
        return this;
    }

    @Override // gm.b0
    public void n(h[] hVarArr) throws IOException {
        for (h hVar : hVarArr) {
            hVar.b().F().y(this, true);
        }
    }

    @Override // gm.b0
    public void z(c0 c0Var, boolean z10) throws IOException {
        c0Var.F().y(this, z10);
    }
}
