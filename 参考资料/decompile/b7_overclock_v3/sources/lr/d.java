package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class d extends i.c {
    public d(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public d(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new d(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        c cVar = (c) this.f35708c;
        if (cVar.j()) {
            return eVarI.w();
        }
        c cVar2 = (c) this.f35707b;
        c cVar3 = (c) this.f35709d[0];
        int[] iArrJ = rr.e.j();
        int[] iArrJ2 = rr.e.j();
        int[] iArrJ3 = rr.e.j();
        b.p(cVar.f40159g, iArrJ3);
        int[] iArrJ4 = rr.e.j();
        b.p(iArrJ3, iArrJ4);
        boolean zI = cVar3.i();
        int[] iArr = cVar3.f40159g;
        if (!zI) {
            b.p(iArr, iArrJ2);
            iArr = iArrJ2;
        }
        b.s(cVar2.f40159g, iArr, iArrJ);
        b.a(cVar2.f40159g, iArr, iArrJ2);
        b.i(iArrJ2, iArrJ, iArrJ2);
        b.o(rr.e.b(iArrJ2, iArrJ2, iArrJ2), iArrJ2);
        b.i(iArrJ3, cVar2.f40159g, iArrJ3);
        b.o(rr.o.E0(4, iArrJ3, 2, 0), iArrJ3);
        b.o(rr.o.H0(4, iArrJ4, 3, 0, iArrJ), iArrJ);
        c cVar4 = new c(iArrJ4);
        b.p(iArrJ2, cVar4.f40159g);
        int[] iArr2 = cVar4.f40159g;
        b.s(iArr2, iArrJ3, iArr2);
        int[] iArr3 = cVar4.f40159g;
        b.s(iArr3, iArrJ3, iArr3);
        c cVar5 = new c(iArrJ3);
        b.s(iArrJ3, cVar4.f40159g, cVar5.f40159g);
        int[] iArr4 = cVar5.f40159g;
        b.i(iArr4, iArrJ2, iArr4);
        int[] iArr5 = cVar5.f40159g;
        b.s(iArr5, iArrJ, iArr5);
        c cVar6 = new c(iArrJ2);
        b.u(cVar.f40159g, cVar6.f40159g);
        if (!zI) {
            int[] iArr6 = cVar6.f40159g;
            b.i(iArr6, cVar3.f40159g, iArr6);
        }
        return new d(eVarI, cVar4, cVar5, new ir.f[]{cVar6});
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
        c cVar = (c) this.f35707b;
        c cVar2 = (c) this.f35708c;
        c cVar3 = (c) iVar.q();
        c cVar4 = (c) iVar.r();
        c cVar5 = (c) this.f35709d[0];
        c cVar6 = (c) iVar.s(0);
        int[] iArrL = rr.e.l();
        int[] iArrJ = rr.e.j();
        int[] iArrJ2 = rr.e.j();
        int[] iArrJ3 = rr.e.j();
        boolean zI = cVar5.i();
        if (zI) {
            iArr = cVar3.f40159g;
            iArr2 = cVar4.f40159g;
        } else {
            b.p(cVar5.f40159g, iArrJ2);
            b.i(iArrJ2, cVar3.f40159g, iArrJ);
            b.i(iArrJ2, cVar5.f40159g, iArrJ2);
            b.i(iArrJ2, cVar4.f40159g, iArrJ2);
            iArr = iArrJ;
            iArr2 = iArrJ2;
        }
        boolean zI2 = cVar6.i();
        if (zI2) {
            iArr3 = cVar.f40159g;
            iArr4 = cVar2.f40159g;
        } else {
            b.p(cVar6.f40159g, iArrJ3);
            b.i(iArrJ3, cVar.f40159g, iArrL);
            b.i(iArrJ3, cVar6.f40159g, iArrJ3);
            b.i(iArrJ3, cVar2.f40159g, iArrJ3);
            iArr3 = iArrL;
            iArr4 = iArrJ3;
        }
        int[] iArrJ4 = rr.e.j();
        b.s(iArr3, iArr, iArrJ4);
        b.s(iArr4, iArr2, iArrJ);
        if (rr.e.x(iArrJ4)) {
            return rr.e.x(iArrJ) ? M() : eVarI.w();
        }
        b.p(iArrJ4, iArrJ2);
        int[] iArrJ5 = rr.e.j();
        b.i(iArrJ2, iArrJ4, iArrJ5);
        b.i(iArrJ2, iArr3, iArrJ2);
        b.k(iArrJ5, iArrJ5);
        rr.e.A(iArr4, iArrJ5, iArrL);
        b.o(rr.e.b(iArrJ2, iArrJ2, iArrJ5), iArrJ5);
        c cVar7 = new c(iArrJ3);
        b.p(iArrJ, cVar7.f40159g);
        int[] iArr5 = cVar7.f40159g;
        b.s(iArr5, iArrJ5, iArr5);
        c cVar8 = new c(iArrJ5);
        b.s(iArrJ2, cVar7.f40159g, cVar8.f40159g);
        b.j(cVar8.f40159g, iArrJ, iArrL);
        b.n(iArrL, cVar8.f40159g);
        c cVar9 = new c(iArrJ4);
        if (!zI) {
            int[] iArr6 = cVar9.f40159g;
            b.i(iArr6, cVar5.f40159g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = cVar9.f40159g;
            b.i(iArr7, cVar6.f40159g, iArr7);
        }
        return new d(eVarI, cVar7, cVar8, new ir.f[]{cVar9});
    }

    @Override // ir.i
    public ir.i d() {
        return new d(null, f(), g());
    }
}
