package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class n1 extends n0 {
    public n1(int i10) {
        super(false, i10, new i1());
    }

    public n1(int i10, int i11, int i12, h hVar) {
        super(i10, i11, i12, hVar);
    }

    public n1(int i10, int i11, h hVar) {
        super(true, i10, i11, hVar);
    }

    public n1(int i10, h hVar) {
        super(true, i10, hVar);
    }

    public n1(boolean z10, int i10, int i11, h hVar) {
        super(z10, i10, i11, hVar);
    }

    public n1(boolean z10, int i10, h hVar) {
        super(z10, i10, hVar);
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        c0 c0VarB = this.f29754d.b();
        boolean zW = W();
        int iA = c0VarB.A(zW);
        if (zW) {
            iA += 3;
        }
        return iA + (z10 ? b0.j(this.f29753c) : 0);
    }

    @Override // gm.n0
    public String K() {
        return j.f29715c;
    }

    @Override // gm.n0
    public f0 Y(c0 c0Var) {
        return new i1(c0Var);
    }

    @Override // gm.n0
    public n0 Z(int i10, int i11) {
        return new n1(this.f29751a, i10, i11, this.f29754d);
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        c0 c0VarB = this.f29754d.b();
        boolean zW = W();
        if (z10) {
            int i10 = this.f29752b;
            if (zW || c0VarB.z()) {
                i10 |= 32;
            }
            b0Var.w(true, i10, this.f29753c);
        }
        if (!zW) {
            c0VarB.y(b0Var, false);
            return;
        }
        b0Var.k(128);
        c0VarB.y(b0Var, true);
        b0Var.k(0);
        b0Var.k(0);
    }

    @Override // gm.c0
    public boolean z() {
        return W() || this.f29754d.b().z();
    }
}
