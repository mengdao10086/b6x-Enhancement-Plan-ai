package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class h0 extends i.c {
    public h0(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public h0(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new h0(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
    }

    @Override // ir.i
    public ir.i K() {
        return (v() || this.f35708c.j()) ? this : M().a(this);
    }

    @Override // ir.i
    public ir.i M() {
        if (v()) {
            return this;
        }
        ir.e eVarI = i();
        g0 g0Var = (g0) this.f35708c;
        if (g0Var.j()) {
            return eVarI.w();
        }
        g0 g0Var2 = (g0) this.f35707b;
        g0 g0Var3 = (g0) this.f35709d[0];
        int[] iArrL = rr.i.l();
        f0.o(g0Var.f40212g, iArrL);
        int[] iArrL2 = rr.i.l();
        f0.o(iArrL, iArrL2);
        int[] iArrL3 = rr.i.l();
        f0.o(g0Var2.f40212g, iArrL3);
        f0.n(rr.i.d(iArrL3, iArrL3, iArrL3), iArrL3);
        f0.h(iArrL, g0Var2.f40212g, iArrL);
        f0.n(rr.o.E0(8, iArrL, 2, 0), iArrL);
        int[] iArrL4 = rr.i.l();
        f0.n(rr.o.H0(8, iArrL2, 3, 0, iArrL4), iArrL4);
        g0 g0Var4 = new g0(iArrL2);
        f0.o(iArrL3, g0Var4.f40212g);
        int[] iArr = g0Var4.f40212g;
        f0.q(iArr, iArrL, iArr);
        int[] iArr2 = g0Var4.f40212g;
        f0.q(iArr2, iArrL, iArr2);
        g0 g0Var5 = new g0(iArrL);
        f0.q(iArrL, g0Var4.f40212g, g0Var5.f40212g);
        int[] iArr3 = g0Var5.f40212g;
        f0.h(iArr3, iArrL3, iArr3);
        int[] iArr4 = g0Var5.f40212g;
        f0.q(iArr4, iArrL4, iArr4);
        g0 g0Var6 = new g0(iArrL3);
        f0.s(g0Var.f40212g, g0Var6.f40212g);
        if (!g0Var3.i()) {
            int[] iArr5 = g0Var6.f40212g;
            f0.h(iArr5, g0Var3.f40212g, iArr5);
        }
        return new h0(eVarI, g0Var4, g0Var5, new ir.f[]{g0Var6});
    }

    @Override // ir.i
    public ir.i N(ir.i iVar) {
        return this == iVar ? K() : v() ? iVar : iVar.v() ? M() : this.f35708c.j() ? iVar : M().a(iVar);
    }

    @Override // ir.i
    public ir.i a(ir.i iVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (v()) {
            return iVar;
        }
        if (iVar.v()) {
            return this;
        }
        if (this == iVar) {
            return M();
        }
        ir.e eVarI = i();
        g0 g0Var = (g0) this.f35707b;
        g0 g0Var2 = (g0) this.f35708c;
        g0 g0Var3 = (g0) iVar.q();
        g0 g0Var4 = (g0) iVar.r();
        g0 g0Var5 = (g0) this.f35709d[0];
        g0 g0Var6 = (g0) iVar.s(0);
        int[] iArrN = rr.i.n();
        int[] iArrL = rr.i.l();
        int[] iArrL2 = rr.i.l();
        int[] iArrL3 = rr.i.l();
        boolean zI = g0Var5.i();
        if (zI) {
            iArr = g0Var3.f40212g;
            iArr2 = g0Var4.f40212g;
        } else {
            f0.o(g0Var5.f40212g, iArrL2);
            f0.h(iArrL2, g0Var3.f40212g, iArrL);
            f0.h(iArrL2, g0Var5.f40212g, iArrL2);
            f0.h(iArrL2, g0Var4.f40212g, iArrL2);
            iArr = iArrL;
            iArr2 = iArrL2;
        }
        boolean zI2 = g0Var6.i();
        if (zI2) {
            iArr3 = g0Var.f40212g;
            iArr4 = g0Var2.f40212g;
        } else {
            f0.o(g0Var6.f40212g, iArrL3);
            f0.h(iArrL3, g0Var.f40212g, iArrN);
            f0.h(iArrL3, g0Var6.f40212g, iArrL3);
            f0.h(iArrL3, g0Var2.f40212g, iArrL3);
            iArr3 = iArrN;
            iArr4 = iArrL3;
        }
        int[] iArrL4 = rr.i.l();
        f0.q(iArr3, iArr, iArrL4);
        f0.q(iArr4, iArr2, iArrL);
        if (rr.i.z(iArrL4)) {
            return rr.i.z(iArrL) ? M() : eVarI.w();
        }
        f0.o(iArrL4, iArrL2);
        int[] iArrL5 = rr.i.l();
        f0.h(iArrL2, iArrL4, iArrL5);
        f0.h(iArrL2, iArr3, iArrL2);
        f0.j(iArrL5, iArrL5);
        rr.i.C(iArr4, iArrL5, iArrN);
        f0.n(rr.i.d(iArrL2, iArrL2, iArrL5), iArrL5);
        g0 g0Var7 = new g0(iArrL3);
        f0.o(iArrL, g0Var7.f40212g);
        int[] iArr5 = g0Var7.f40212g;
        f0.q(iArr5, iArrL5, iArr5);
        g0 g0Var8 = new g0(iArrL5);
        f0.q(iArrL2, g0Var7.f40212g, g0Var8.f40212g);
        f0.i(g0Var8.f40212g, iArrL, iArrN);
        f0.m(iArrN, g0Var8.f40212g);
        g0 g0Var9 = new g0(iArrL4);
        if (!zI) {
            int[] iArr6 = g0Var9.f40212g;
            f0.h(iArr6, g0Var5.f40212g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = g0Var9.f40212g;
            f0.h(iArr7, g0Var6.f40212g, iArr7);
        }
        return new h0(eVarI, g0Var7, g0Var8, new ir.f[]{g0Var9});
    }

    @Override // ir.i
    public ir.i d() {
        return new h0(null, f(), g());
    }
}
