package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class v extends i.c {
    public v(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public v(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new v(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        u uVar = (u) this.f35708c;
        if (uVar.j()) {
            return eVarI.w();
        }
        u uVar2 = (u) this.f35707b;
        u uVar3 = (u) this.f35709d[0];
        int[] iArrJ = rr.g.j();
        int[] iArrJ2 = rr.g.j();
        int[] iArrJ3 = rr.g.j();
        t.p(uVar.f40379g, iArrJ3);
        int[] iArrJ4 = rr.g.j();
        t.p(iArrJ3, iArrJ4);
        boolean zI = uVar3.i();
        int[] iArr = uVar3.f40379g;
        if (!zI) {
            t.p(iArr, iArrJ2);
            iArr = iArrJ2;
        }
        t.s(uVar2.f40379g, iArr, iArrJ);
        t.a(uVar2.f40379g, iArr, iArrJ2);
        t.i(iArrJ2, iArrJ, iArrJ2);
        t.o(rr.g.b(iArrJ2, iArrJ2, iArrJ2), iArrJ2);
        t.i(iArrJ3, uVar2.f40379g, iArrJ3);
        t.o(rr.o.E0(6, iArrJ3, 2, 0), iArrJ3);
        t.o(rr.o.H0(6, iArrJ4, 3, 0, iArrJ), iArrJ);
        u uVar4 = new u(iArrJ4);
        t.p(iArrJ2, uVar4.f40379g);
        int[] iArr2 = uVar4.f40379g;
        t.s(iArr2, iArrJ3, iArr2);
        int[] iArr3 = uVar4.f40379g;
        t.s(iArr3, iArrJ3, iArr3);
        u uVar5 = new u(iArrJ3);
        t.s(iArrJ3, uVar4.f40379g, uVar5.f40379g);
        int[] iArr4 = uVar5.f40379g;
        t.i(iArr4, iArrJ2, iArr4);
        int[] iArr5 = uVar5.f40379g;
        t.s(iArr5, iArrJ, iArr5);
        u uVar6 = new u(iArrJ2);
        t.u(uVar.f40379g, uVar6.f40379g);
        if (!zI) {
            int[] iArr6 = uVar6.f40379g;
            t.i(iArr6, uVar3.f40379g, iArr6);
        }
        return new v(eVarI, uVar4, uVar5, new ir.f[]{uVar6});
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
        u uVar = (u) this.f35707b;
        u uVar2 = (u) this.f35708c;
        u uVar3 = (u) iVar.q();
        u uVar4 = (u) iVar.r();
        u uVar5 = (u) this.f35709d[0];
        u uVar6 = (u) iVar.s(0);
        int[] iArrL = rr.g.l();
        int[] iArrJ = rr.g.j();
        int[] iArrJ2 = rr.g.j();
        int[] iArrJ3 = rr.g.j();
        boolean zI = uVar5.i();
        if (zI) {
            iArr = uVar3.f40379g;
            iArr2 = uVar4.f40379g;
        } else {
            t.p(uVar5.f40379g, iArrJ2);
            t.i(iArrJ2, uVar3.f40379g, iArrJ);
            t.i(iArrJ2, uVar5.f40379g, iArrJ2);
            t.i(iArrJ2, uVar4.f40379g, iArrJ2);
            iArr = iArrJ;
            iArr2 = iArrJ2;
        }
        boolean zI2 = uVar6.i();
        if (zI2) {
            iArr3 = uVar.f40379g;
            iArr4 = uVar2.f40379g;
        } else {
            t.p(uVar6.f40379g, iArrJ3);
            t.i(iArrJ3, uVar.f40379g, iArrL);
            t.i(iArrJ3, uVar6.f40379g, iArrJ3);
            t.i(iArrJ3, uVar2.f40379g, iArrJ3);
            iArr3 = iArrL;
            iArr4 = iArrJ3;
        }
        int[] iArrJ4 = rr.g.j();
        t.s(iArr3, iArr, iArrJ4);
        t.s(iArr4, iArr2, iArrJ);
        if (rr.g.x(iArrJ4)) {
            return rr.g.x(iArrJ) ? M() : eVarI.w();
        }
        t.p(iArrJ4, iArrJ2);
        int[] iArrJ5 = rr.g.j();
        t.i(iArrJ2, iArrJ4, iArrJ5);
        t.i(iArrJ2, iArr3, iArrJ2);
        t.k(iArrJ5, iArrJ5);
        rr.g.A(iArr4, iArrJ5, iArrL);
        t.o(rr.g.b(iArrJ2, iArrJ2, iArrJ5), iArrJ5);
        u uVar7 = new u(iArrJ3);
        t.p(iArrJ, uVar7.f40379g);
        int[] iArr5 = uVar7.f40379g;
        t.s(iArr5, iArrJ5, iArr5);
        u uVar8 = new u(iArrJ5);
        t.s(iArrJ2, uVar7.f40379g, uVar8.f40379g);
        t.j(uVar8.f40379g, iArrJ, iArrL);
        t.n(iArrL, uVar8.f40379g);
        u uVar9 = new u(iArrJ4);
        if (!zI) {
            int[] iArr6 = uVar9.f40379g;
            t.i(iArr6, uVar5.f40379g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = uVar9.f40379g;
            t.i(iArr7, uVar6.f40379g, iArr7);
        }
        return new v(eVarI, uVar7, uVar8, new ir.f[]{uVar9});
    }

    @Override // ir.i
    public ir.i d() {
        return new v(null, f(), g());
    }
}
