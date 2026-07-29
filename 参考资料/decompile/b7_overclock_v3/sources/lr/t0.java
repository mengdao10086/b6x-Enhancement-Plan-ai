package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class t0 extends i.c {
    public t0(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public t0(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new t0(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        s0 s0Var = (s0) this.f35708c;
        if (s0Var.j()) {
            return eVarI.w();
        }
        s0 s0Var2 = (s0) this.f35707b;
        s0 s0Var3 = (s0) this.f35709d[0];
        int[] iArrD = rr.o.D(17);
        int[] iArrD2 = rr.o.D(17);
        int[] iArrD3 = rr.o.D(17);
        r0.o(s0Var.f40359g, iArrD3);
        int[] iArrD4 = rr.o.D(17);
        r0.o(iArrD3, iArrD4);
        boolean zI = s0Var3.i();
        int[] iArr = s0Var3.f40359g;
        if (!zI) {
            r0.o(iArr, iArrD2);
            iArr = iArrD2;
        }
        r0.q(s0Var2.f40359g, iArr, iArrD);
        r0.a(s0Var2.f40359g, iArr, iArrD2);
        r0.i(iArrD2, iArrD, iArrD2);
        rr.o.g(17, iArrD2, iArrD2, iArrD2);
        r0.n(iArrD2);
        r0.i(iArrD3, s0Var2.f40359g, iArrD3);
        rr.o.E0(17, iArrD3, 2, 0);
        r0.n(iArrD3);
        rr.o.H0(17, iArrD4, 3, 0, iArrD);
        r0.n(iArrD);
        s0 s0Var4 = new s0(iArrD4);
        r0.o(iArrD2, s0Var4.f40359g);
        int[] iArr2 = s0Var4.f40359g;
        r0.q(iArr2, iArrD3, iArr2);
        int[] iArr3 = s0Var4.f40359g;
        r0.q(iArr3, iArrD3, iArr3);
        s0 s0Var5 = new s0(iArrD3);
        r0.q(iArrD3, s0Var4.f40359g, s0Var5.f40359g);
        int[] iArr4 = s0Var5.f40359g;
        r0.i(iArr4, iArrD2, iArr4);
        int[] iArr5 = s0Var5.f40359g;
        r0.q(iArr5, iArrD, iArr5);
        s0 s0Var6 = new s0(iArrD2);
        r0.r(s0Var.f40359g, s0Var6.f40359g);
        if (!zI) {
            int[] iArr6 = s0Var6.f40359g;
            r0.i(iArr6, s0Var3.f40359g, iArr6);
        }
        return new t0(eVarI, s0Var4, s0Var5, new ir.f[]{s0Var6});
    }

    @Override // ir.i
    public ir.i N(ir.i iVar) {
        return this == iVar ? K() : v() ? iVar : iVar.v() ? M() : this.f35708c.j() ? iVar : M().a(iVar);
    }

    public ir.f O(ir.f fVar, ir.f fVar2, ir.f fVar3, ir.f fVar4) {
        return fVar.a(fVar2).p().t(fVar3).t(fVar4);
    }

    public ir.f P(ir.f fVar) {
        return Q(S(fVar));
    }

    public ir.f Q(ir.f fVar) {
        return S(S(fVar));
    }

    public ir.f R(ir.f fVar) {
        return S(fVar).a(fVar);
    }

    public ir.f S(ir.f fVar) {
        return fVar.a(fVar);
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
        s0 s0Var = (s0) this.f35707b;
        s0 s0Var2 = (s0) this.f35708c;
        s0 s0Var3 = (s0) iVar.q();
        s0 s0Var4 = (s0) iVar.r();
        s0 s0Var5 = (s0) this.f35709d[0];
        s0 s0Var6 = (s0) iVar.s(0);
        int[] iArrD = rr.o.D(17);
        int[] iArrD2 = rr.o.D(17);
        int[] iArrD3 = rr.o.D(17);
        int[] iArrD4 = rr.o.D(17);
        boolean zI = s0Var5.i();
        if (zI) {
            iArr = s0Var3.f40359g;
            iArr2 = s0Var4.f40359g;
        } else {
            r0.o(s0Var5.f40359g, iArrD3);
            r0.i(iArrD3, s0Var3.f40359g, iArrD2);
            r0.i(iArrD3, s0Var5.f40359g, iArrD3);
            r0.i(iArrD3, s0Var4.f40359g, iArrD3);
            iArr = iArrD2;
            iArr2 = iArrD3;
        }
        boolean zI2 = s0Var6.i();
        if (zI2) {
            iArr3 = s0Var.f40359g;
            iArr4 = s0Var2.f40359g;
        } else {
            r0.o(s0Var6.f40359g, iArrD4);
            r0.i(iArrD4, s0Var.f40359g, iArrD);
            r0.i(iArrD4, s0Var6.f40359g, iArrD4);
            r0.i(iArrD4, s0Var2.f40359g, iArrD4);
            iArr3 = iArrD;
            iArr4 = iArrD4;
        }
        int[] iArrD5 = rr.o.D(17);
        r0.q(iArr3, iArr, iArrD5);
        r0.q(iArr4, iArr2, iArrD2);
        if (rr.o.d0(17, iArrD5)) {
            return rr.o.d0(17, iArrD2) ? M() : eVarI.w();
        }
        r0.o(iArrD5, iArrD3);
        int[] iArrD6 = rr.o.D(17);
        r0.i(iArrD3, iArrD5, iArrD6);
        r0.i(iArrD3, iArr3, iArrD3);
        r0.i(iArr4, iArrD6, iArrD);
        s0 s0Var7 = new s0(iArrD4);
        r0.o(iArrD2, s0Var7.f40359g);
        int[] iArr5 = s0Var7.f40359g;
        r0.a(iArr5, iArrD6, iArr5);
        int[] iArr6 = s0Var7.f40359g;
        r0.q(iArr6, iArrD3, iArr6);
        int[] iArr7 = s0Var7.f40359g;
        r0.q(iArr7, iArrD3, iArr7);
        s0 s0Var8 = new s0(iArrD6);
        r0.q(iArrD3, s0Var7.f40359g, s0Var8.f40359g);
        r0.i(s0Var8.f40359g, iArrD2, iArrD2);
        r0.q(iArrD2, iArrD, s0Var8.f40359g);
        s0 s0Var9 = new s0(iArrD5);
        if (!zI) {
            int[] iArr8 = s0Var9.f40359g;
            r0.i(iArr8, s0Var5.f40359g, iArr8);
        }
        if (!zI2) {
            int[] iArr9 = s0Var9.f40359g;
            r0.i(iArr9, s0Var6.f40359g, iArr9);
        }
        return new t0(eVarI, s0Var7, s0Var8, new ir.f[]{s0Var9});
    }

    @Override // ir.i
    public ir.i d() {
        return new t0(null, f(), g());
    }
}
