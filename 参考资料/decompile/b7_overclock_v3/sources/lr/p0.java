package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class p0 extends i.c {
    public p0(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public p0(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new p0(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        o0 o0Var = (o0) this.f35708c;
        if (o0Var.j()) {
            return eVarI.w();
        }
        o0 o0Var2 = (o0) this.f35707b;
        o0 o0Var3 = (o0) this.f35709d[0];
        int[] iArrD = rr.o.D(12);
        int[] iArrD2 = rr.o.D(12);
        int[] iArrD3 = rr.o.D(12);
        n0.o(o0Var.f40315g, iArrD3);
        int[] iArrD4 = rr.o.D(12);
        n0.o(iArrD3, iArrD4);
        boolean zI = o0Var3.i();
        int[] iArr = o0Var3.f40315g;
        if (!zI) {
            n0.o(iArr, iArrD2);
            iArr = iArrD2;
        }
        n0.r(o0Var2.f40315g, iArr, iArrD);
        n0.a(o0Var2.f40315g, iArr, iArrD2);
        n0.i(iArrD2, iArrD, iArrD2);
        n0.n(rr.o.g(12, iArrD2, iArrD2, iArrD2), iArrD2);
        n0.i(iArrD3, o0Var2.f40315g, iArrD3);
        n0.n(rr.o.E0(12, iArrD3, 2, 0), iArrD3);
        n0.n(rr.o.H0(12, iArrD4, 3, 0, iArrD), iArrD);
        o0 o0Var4 = new o0(iArrD4);
        n0.o(iArrD2, o0Var4.f40315g);
        int[] iArr2 = o0Var4.f40315g;
        n0.r(iArr2, iArrD3, iArr2);
        int[] iArr3 = o0Var4.f40315g;
        n0.r(iArr3, iArrD3, iArr3);
        o0 o0Var5 = new o0(iArrD3);
        n0.r(iArrD3, o0Var4.f40315g, o0Var5.f40315g);
        int[] iArr4 = o0Var5.f40315g;
        n0.i(iArr4, iArrD2, iArr4);
        int[] iArr5 = o0Var5.f40315g;
        n0.r(iArr5, iArrD, iArr5);
        o0 o0Var6 = new o0(iArrD2);
        n0.t(o0Var.f40315g, o0Var6.f40315g);
        if (!zI) {
            int[] iArr6 = o0Var6.f40315g;
            n0.i(iArr6, o0Var3.f40315g, iArr6);
        }
        return new p0(eVarI, o0Var4, o0Var5, new ir.f[]{o0Var6});
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
        o0 o0Var = (o0) this.f35707b;
        o0 o0Var2 = (o0) this.f35708c;
        o0 o0Var3 = (o0) iVar.q();
        o0 o0Var4 = (o0) iVar.r();
        o0 o0Var5 = (o0) this.f35709d[0];
        o0 o0Var6 = (o0) iVar.s(0);
        int[] iArrD = rr.o.D(24);
        int[] iArrD2 = rr.o.D(24);
        int[] iArrD3 = rr.o.D(12);
        int[] iArrD4 = rr.o.D(12);
        boolean zI = o0Var5.i();
        if (zI) {
            iArr = o0Var3.f40315g;
            iArr2 = o0Var4.f40315g;
        } else {
            n0.o(o0Var5.f40315g, iArrD3);
            n0.i(iArrD3, o0Var3.f40315g, iArrD2);
            n0.i(iArrD3, o0Var5.f40315g, iArrD3);
            n0.i(iArrD3, o0Var4.f40315g, iArrD3);
            iArr = iArrD2;
            iArr2 = iArrD3;
        }
        boolean zI2 = o0Var6.i();
        if (zI2) {
            iArr3 = o0Var.f40315g;
            iArr4 = o0Var2.f40315g;
        } else {
            n0.o(o0Var6.f40315g, iArrD4);
            n0.i(iArrD4, o0Var.f40315g, iArrD);
            n0.i(iArrD4, o0Var6.f40315g, iArrD4);
            n0.i(iArrD4, o0Var2.f40315g, iArrD4);
            iArr3 = iArrD;
            iArr4 = iArrD4;
        }
        int[] iArrD5 = rr.o.D(12);
        n0.r(iArr3, iArr, iArrD5);
        int[] iArrD6 = rr.o.D(12);
        n0.r(iArr4, iArr2, iArrD6);
        if (rr.o.d0(12, iArrD5)) {
            return rr.o.d0(12, iArrD6) ? M() : eVarI.w();
        }
        n0.o(iArrD5, iArrD3);
        int[] iArrD7 = rr.o.D(12);
        n0.i(iArrD3, iArrD5, iArrD7);
        n0.i(iArrD3, iArr3, iArrD3);
        n0.j(iArrD7, iArrD7);
        rr.k.a(iArr4, iArrD7, iArrD);
        n0.n(rr.o.g(12, iArrD3, iArrD3, iArrD7), iArrD7);
        o0 o0Var7 = new o0(iArrD4);
        n0.o(iArrD6, o0Var7.f40315g);
        int[] iArr5 = o0Var7.f40315g;
        n0.r(iArr5, iArrD7, iArr5);
        o0 o0Var8 = new o0(iArrD7);
        n0.r(iArrD3, o0Var7.f40315g, o0Var8.f40315g);
        rr.k.a(o0Var8.f40315g, iArrD6, iArrD2);
        n0.b(iArrD, iArrD2, iArrD);
        n0.m(iArrD, o0Var8.f40315g);
        o0 o0Var9 = new o0(iArrD5);
        if (!zI) {
            int[] iArr6 = o0Var9.f40315g;
            n0.i(iArr6, o0Var5.f40315g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = o0Var9.f40315g;
            n0.i(iArr7, o0Var6.f40315g, iArr7);
        }
        return new p0(eVarI, o0Var7, o0Var8, new ir.f[]{o0Var9});
    }

    @Override // ir.i
    public ir.i d() {
        return new p0(null, f(), g());
    }
}
