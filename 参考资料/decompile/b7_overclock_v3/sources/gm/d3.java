package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class d3 extends n0 {
    public d3(int i10, int i11, int i12, h hVar) {
        super(i10, i11, i12, hVar);
    }

    public d3(int i10, int i11, h hVar) {
        super(true, i10, i11, hVar);
    }

    public d3(int i10, h hVar) {
        super(true, i10, hVar);
    }

    public d3(boolean z10, int i10, int i11, h hVar) {
        super(z10, i10, i11, hVar);
    }

    public d3(boolean z10, int i10, h hVar) {
        super(z10, i10, hVar);
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        c0 c0VarF = this.f29754d.b().F();
        boolean zW = W();
        int iA = c0VarF.A(zW);
        if (zW) {
            iA += b0.h(iA);
        }
        return iA + (z10 ? b0.j(this.f29753c) : 0);
    }

    @Override // gm.n0, gm.c0
    public c0 F() {
        return this;
    }

    @Override // gm.n0
    public String K() {
        return j.f29714b;
    }

    @Override // gm.n0
    public f0 Y(c0 c0Var) {
        return new z2(c0Var);
    }

    @Override // gm.n0
    public n0 Z(int i10, int i11) {
        return new d3(this.f29751a, i10, i11, this.f29754d);
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        c0 c0VarF = this.f29754d.b().F();
        boolean zW = W();
        if (z10) {
            int i10 = this.f29752b;
            if (zW || c0VarF.z()) {
                i10 |= 32;
            }
            b0Var.w(true, i10, this.f29753c);
        }
        if (zW) {
            b0Var.m(c0VarF.A(true));
        }
        c0VarF.y(b0Var.g(), zW);
    }

    @Override // gm.c0
    public boolean z() {
        return W() || this.f29754d.b().F().z();
    }
}
