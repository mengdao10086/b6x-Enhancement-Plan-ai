package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class d0 extends i.c {
    public d0(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public d0(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new d0(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        c0 c0Var = (c0) this.f35708c;
        if (c0Var.j()) {
            return eVarI.w();
        }
        c0 c0Var2 = (c0) this.f35707b;
        c0 c0Var3 = (c0) this.f35709d[0];
        int[] iArrJ = rr.h.j();
        int[] iArrJ2 = rr.h.j();
        int[] iArrJ3 = rr.h.j();
        b0.p(c0Var.f40161g, iArrJ3);
        int[] iArrJ4 = rr.h.j();
        b0.p(iArrJ3, iArrJ4);
        boolean zI = c0Var3.i();
        int[] iArr = c0Var3.f40161g;
        if (!zI) {
            b0.p(iArr, iArrJ2);
            iArr = iArrJ2;
        }
        b0.s(c0Var2.f40161g, iArr, iArrJ);
        b0.a(c0Var2.f40161g, iArr, iArrJ2);
        b0.i(iArrJ2, iArrJ, iArrJ2);
        b0.o(rr.h.d(iArrJ2, iArrJ2, iArrJ2), iArrJ2);
        b0.i(iArrJ3, c0Var2.f40161g, iArrJ3);
        b0.o(rr.o.E0(7, iArrJ3, 2, 0), iArrJ3);
        b0.o(rr.o.H0(7, iArrJ4, 3, 0, iArrJ), iArrJ);
        c0 c0Var4 = new c0(iArrJ4);
        b0.p(iArrJ2, c0Var4.f40161g);
        int[] iArr2 = c0Var4.f40161g;
        b0.s(iArr2, iArrJ3, iArr2);
        int[] iArr3 = c0Var4.f40161g;
        b0.s(iArr3, iArrJ3, iArr3);
        c0 c0Var5 = new c0(iArrJ3);
        b0.s(iArrJ3, c0Var4.f40161g, c0Var5.f40161g);
        int[] iArr4 = c0Var5.f40161g;
        b0.i(iArr4, iArrJ2, iArr4);
        int[] iArr5 = c0Var5.f40161g;
        b0.s(iArr5, iArrJ, iArr5);
        c0 c0Var6 = new c0(iArrJ2);
        b0.u(c0Var.f40161g, c0Var6.f40161g);
        if (!zI) {
            int[] iArr6 = c0Var6.f40161g;
            b0.i(iArr6, c0Var3.f40161g, iArr6);
        }
        return new d0(eVarI, c0Var4, c0Var5, new ir.f[]{c0Var6});
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
        c0 c0Var = (c0) this.f35707b;
        c0 c0Var2 = (c0) this.f35708c;
        c0 c0Var3 = (c0) iVar.q();
        c0 c0Var4 = (c0) iVar.r();
        c0 c0Var5 = (c0) this.f35709d[0];
        c0 c0Var6 = (c0) iVar.s(0);
        int[] iArrK = rr.h.k();
        int[] iArrJ = rr.h.j();
        int[] iArrJ2 = rr.h.j();
        int[] iArrJ3 = rr.h.j();
        boolean zI = c0Var5.i();
        if (zI) {
            iArr = c0Var3.f40161g;
            iArr2 = c0Var4.f40161g;
        } else {
            b0.p(c0Var5.f40161g, iArrJ2);
            b0.i(iArrJ2, c0Var3.f40161g, iArrJ);
            b0.i(iArrJ2, c0Var5.f40161g, iArrJ2);
            b0.i(iArrJ2, c0Var4.f40161g, iArrJ2);
            iArr = iArrJ;
            iArr2 = iArrJ2;
        }
        boolean zI2 = c0Var6.i();
        if (zI2) {
            iArr3 = c0Var.f40161g;
            iArr4 = c0Var2.f40161g;
        } else {
            b0.p(c0Var6.f40161g, iArrJ3);
            b0.i(iArrJ3, c0Var.f40161g, iArrK);
            b0.i(iArrJ3, c0Var6.f40161g, iArrJ3);
            b0.i(iArrJ3, c0Var2.f40161g, iArrJ3);
            iArr3 = iArrK;
            iArr4 = iArrJ3;
        }
        int[] iArrJ4 = rr.h.j();
        b0.s(iArr3, iArr, iArrJ4);
        b0.s(iArr4, iArr2, iArrJ);
        if (rr.h.s(iArrJ4)) {
            return rr.h.s(iArrJ) ? M() : eVarI.w();
        }
        b0.p(iArrJ4, iArrJ2);
        int[] iArrJ5 = rr.h.j();
        b0.i(iArrJ2, iArrJ4, iArrJ5);
        b0.i(iArrJ2, iArr3, iArrJ2);
        b0.k(iArrJ5, iArrJ5);
        rr.h.u(iArr4, iArrJ5, iArrK);
        b0.o(rr.h.d(iArrJ2, iArrJ2, iArrJ5), iArrJ5);
        c0 c0Var7 = new c0(iArrJ3);
        b0.p(iArrJ, c0Var7.f40161g);
        int[] iArr5 = c0Var7.f40161g;
        b0.s(iArr5, iArrJ5, iArr5);
        c0 c0Var8 = new c0(iArrJ5);
        b0.s(iArrJ2, c0Var7.f40161g, c0Var8.f40161g);
        b0.j(c0Var8.f40161g, iArrJ, iArrK);
        b0.n(iArrK, c0Var8.f40161g);
        c0 c0Var9 = new c0(iArrJ4);
        if (!zI) {
            int[] iArr6 = c0Var9.f40161g;
            b0.i(iArr6, c0Var5.f40161g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = c0Var9.f40161g;
            b0.i(iArr7, c0Var6.f40161g, iArr7);
        }
        return new d0(eVarI, c0Var7, c0Var8, new ir.f[]{c0Var9});
    }

    @Override // ir.i
    public ir.i d() {
        return new d0(null, f(), g());
    }
}
