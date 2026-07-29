package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class l0 extends i.c {
    public l0(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public l0(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new l0(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        k0 k0Var = (k0) this.f35708c;
        if (k0Var.j()) {
            return eVarI.w();
        }
        k0 k0Var2 = (k0) this.f35707b;
        k0 k0Var3 = (k0) this.f35709d[0];
        int[] iArrL = rr.i.l();
        int[] iArrL2 = rr.i.l();
        int[] iArrL3 = rr.i.l();
        j0.p(k0Var.f40264g, iArrL3);
        int[] iArrL4 = rr.i.l();
        j0.p(iArrL3, iArrL4);
        boolean zI = k0Var3.i();
        int[] iArr = k0Var3.f40264g;
        if (!zI) {
            j0.p(iArr, iArrL2);
            iArr = iArrL2;
        }
        j0.s(k0Var2.f40264g, iArr, iArrL);
        j0.a(k0Var2.f40264g, iArr, iArrL2);
        j0.i(iArrL2, iArrL, iArrL2);
        j0.o(rr.i.d(iArrL2, iArrL2, iArrL2), iArrL2);
        j0.i(iArrL3, k0Var2.f40264g, iArrL3);
        j0.o(rr.o.E0(8, iArrL3, 2, 0), iArrL3);
        j0.o(rr.o.H0(8, iArrL4, 3, 0, iArrL), iArrL);
        k0 k0Var4 = new k0(iArrL4);
        j0.p(iArrL2, k0Var4.f40264g);
        int[] iArr2 = k0Var4.f40264g;
        j0.s(iArr2, iArrL3, iArr2);
        int[] iArr3 = k0Var4.f40264g;
        j0.s(iArr3, iArrL3, iArr3);
        k0 k0Var5 = new k0(iArrL3);
        j0.s(iArrL3, k0Var4.f40264g, k0Var5.f40264g);
        int[] iArr4 = k0Var5.f40264g;
        j0.i(iArr4, iArrL2, iArr4);
        int[] iArr5 = k0Var5.f40264g;
        j0.s(iArr5, iArrL, iArr5);
        k0 k0Var6 = new k0(iArrL2);
        j0.u(k0Var.f40264g, k0Var6.f40264g);
        if (!zI) {
            int[] iArr6 = k0Var6.f40264g;
            j0.i(iArr6, k0Var3.f40264g, iArr6);
        }
        return new l0(eVarI, k0Var4, k0Var5, new ir.f[]{k0Var6});
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
        k0 k0Var = (k0) this.f35707b;
        k0 k0Var2 = (k0) this.f35708c;
        k0 k0Var3 = (k0) iVar.q();
        k0 k0Var4 = (k0) iVar.r();
        k0 k0Var5 = (k0) this.f35709d[0];
        k0 k0Var6 = (k0) iVar.s(0);
        int[] iArrN = rr.i.n();
        int[] iArrL = rr.i.l();
        int[] iArrL2 = rr.i.l();
        int[] iArrL3 = rr.i.l();
        boolean zI = k0Var5.i();
        if (zI) {
            iArr = k0Var3.f40264g;
            iArr2 = k0Var4.f40264g;
        } else {
            j0.p(k0Var5.f40264g, iArrL2);
            j0.i(iArrL2, k0Var3.f40264g, iArrL);
            j0.i(iArrL2, k0Var5.f40264g, iArrL2);
            j0.i(iArrL2, k0Var4.f40264g, iArrL2);
            iArr = iArrL;
            iArr2 = iArrL2;
        }
        boolean zI2 = k0Var6.i();
        if (zI2) {
            iArr3 = k0Var.f40264g;
            iArr4 = k0Var2.f40264g;
        } else {
            j0.p(k0Var6.f40264g, iArrL3);
            j0.i(iArrL3, k0Var.f40264g, iArrN);
            j0.i(iArrL3, k0Var6.f40264g, iArrL3);
            j0.i(iArrL3, k0Var2.f40264g, iArrL3);
            iArr3 = iArrN;
            iArr4 = iArrL3;
        }
        int[] iArrL4 = rr.i.l();
        j0.s(iArr3, iArr, iArrL4);
        j0.s(iArr4, iArr2, iArrL);
        if (rr.i.z(iArrL4)) {
            return rr.i.z(iArrL) ? M() : eVarI.w();
        }
        j0.p(iArrL4, iArrL2);
        int[] iArrL5 = rr.i.l();
        j0.i(iArrL2, iArrL4, iArrL5);
        j0.i(iArrL2, iArr3, iArrL2);
        j0.k(iArrL5, iArrL5);
        rr.i.C(iArr4, iArrL5, iArrN);
        j0.o(rr.i.d(iArrL2, iArrL2, iArrL5), iArrL5);
        k0 k0Var7 = new k0(iArrL3);
        j0.p(iArrL, k0Var7.f40264g);
        int[] iArr5 = k0Var7.f40264g;
        j0.s(iArr5, iArrL5, iArr5);
        k0 k0Var8 = new k0(iArrL5);
        j0.s(iArrL2, k0Var7.f40264g, k0Var8.f40264g);
        j0.j(k0Var8.f40264g, iArrL, iArrN);
        j0.n(iArrN, k0Var8.f40264g);
        k0 k0Var9 = new k0(iArrL4);
        if (!zI) {
            int[] iArr6 = k0Var9.f40264g;
            j0.i(iArr6, k0Var5.f40264g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = k0Var9.f40264g;
            j0.i(iArr7, k0Var6.f40264g, iArr7);
        }
        return new l0(eVarI, k0Var7, k0Var8, new ir.f[]{k0Var9});
    }

    @Override // ir.i
    public ir.i d() {
        return new l0(null, f(), g());
    }
}
