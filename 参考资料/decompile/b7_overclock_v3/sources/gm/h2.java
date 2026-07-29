package gm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class h2 extends y2 {
    public h2(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // gm.y2, gm.b0
    public void A(c0[] c0VarArr) throws IOException {
        for (c0 c0Var : c0VarArr) {
            c0Var.E().y(this, true);
        }
    }

    @Override // gm.b0
    public h2 f() {
        return this;
    }

    @Override // gm.y2, gm.b0
    public void n(h[] hVarArr) throws IOException {
        for (h hVar : hVarArr) {
            hVar.b().E().y(this, true);
        }
    }

    @Override // gm.y2, gm.b0
    public void z(c0 c0Var, boolean z10) throws IOException {
        c0Var.E().y(this, z10);
    }
}
