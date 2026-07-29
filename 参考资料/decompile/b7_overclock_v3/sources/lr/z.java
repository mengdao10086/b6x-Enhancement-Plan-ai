package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class z extends i.c {
    public z(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public z(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new z(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        y yVar = (y) this.f35708c;
        if (yVar.j()) {
            return eVarI.w();
        }
        y yVar2 = (y) this.f35707b;
        y yVar3 = (y) this.f35709d[0];
        int[] iArrJ = rr.h.j();
        x.o(yVar.f40421g, iArrJ);
        int[] iArrJ2 = rr.h.j();
        x.o(iArrJ, iArrJ2);
        int[] iArrJ3 = rr.h.j();
        x.o(yVar2.f40421g, iArrJ3);
        x.n(rr.h.d(iArrJ3, iArrJ3, iArrJ3), iArrJ3);
        x.h(iArrJ, yVar2.f40421g, iArrJ);
        x.n(rr.o.E0(7, iArrJ, 2, 0), iArrJ);
        int[] iArrJ4 = rr.h.j();
        x.n(rr.o.H0(7, iArrJ2, 3, 0, iArrJ4), iArrJ4);
        y yVar4 = new y(iArrJ2);
        x.o(iArrJ3, yVar4.f40421g);
        int[] iArr = yVar4.f40421g;
        x.q(iArr, iArrJ, iArr);
        int[] iArr2 = yVar4.f40421g;
        x.q(iArr2, iArrJ, iArr2);
        y yVar5 = new y(iArrJ);
        x.q(iArrJ, yVar4.f40421g, yVar5.f40421g);
        int[] iArr3 = yVar5.f40421g;
        x.h(iArr3, iArrJ3, iArr3);
        int[] iArr4 = yVar5.f40421g;
        x.q(iArr4, iArrJ4, iArr4);
        y yVar6 = new y(iArrJ3);
        x.s(yVar.f40421g, yVar6.f40421g);
        if (!yVar3.i()) {
            int[] iArr5 = yVar6.f40421g;
            x.h(iArr5, yVar3.f40421g, iArr5);
        }
        return new z(eVarI, yVar4, yVar5, new ir.f[]{yVar6});
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
        y yVar = (y) this.f35707b;
        y yVar2 = (y) this.f35708c;
        y yVar3 = (y) iVar.q();
        y yVar4 = (y) iVar.r();
        y yVar5 = (y) this.f35709d[0];
        y yVar6 = (y) iVar.s(0);
        int[] iArrK = rr.h.k();
        int[] iArrJ = rr.h.j();
        int[] iArrJ2 = rr.h.j();
        int[] iArrJ3 = rr.h.j();
        boolean zI = yVar5.i();
        if (zI) {
            iArr = yVar3.f40421g;
            iArr2 = yVar4.f40421g;
        } else {
            x.o(yVar5.f40421g, iArrJ2);
            x.h(iArrJ2, yVar3.f40421g, iArrJ);
            x.h(iArrJ2, yVar5.f40421g, iArrJ2);
            x.h(iArrJ2, yVar4.f40421g, iArrJ2);
            iArr = iArrJ;
            iArr2 = iArrJ2;
        }
        boolean zI2 = yVar6.i();
        if (zI2) {
            iArr3 = yVar.f40421g;
            iArr4 = yVar2.f40421g;
        } else {
            x.o(yVar6.f40421g, iArrJ3);
            x.h(iArrJ3, yVar.f40421g, iArrK);
            x.h(iArrJ3, yVar6.f40421g, iArrJ3);
            x.h(iArrJ3, yVar2.f40421g, iArrJ3);
            iArr3 = iArrK;
            iArr4 = iArrJ3;
        }
        int[] iArrJ4 = rr.h.j();
        x.q(iArr3, iArr, iArrJ4);
        x.q(iArr4, iArr2, iArrJ);
        if (rr.h.s(iArrJ4)) {
            return rr.h.s(iArrJ) ? M() : eVarI.w();
        }
        x.o(iArrJ4, iArrJ2);
        int[] iArrJ5 = rr.h.j();
        x.h(iArrJ2, iArrJ4, iArrJ5);
        x.h(iArrJ2, iArr3, iArrJ2);
        x.j(iArrJ5, iArrJ5);
        rr.h.u(iArr4, iArrJ5, iArrK);
        x.n(rr.h.d(iArrJ2, iArrJ2, iArrJ5), iArrJ5);
        y yVar7 = new y(iArrJ3);
        x.o(iArrJ, yVar7.f40421g);
        int[] iArr5 = yVar7.f40421g;
        x.q(iArr5, iArrJ5, iArr5);
        y yVar8 = new y(iArrJ5);
        x.q(iArrJ2, yVar7.f40421g, yVar8.f40421g);
        x.i(yVar8.f40421g, iArrJ, iArrK);
        x.m(iArrK, yVar8.f40421g);
        y yVar9 = new y(iArrJ4);
        if (!zI) {
            int[] iArr6 = yVar9.f40421g;
            x.h(iArr6, yVar5.f40421g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = yVar9.f40421g;
            x.h(iArr7, yVar6.f40421g, iArr7);
        }
        return new z(eVarI, yVar7, yVar8, new ir.f[]{yVar9});
    }

    @Override // ir.i
    public ir.i d() {
        return new z(null, f(), g());
    }
}
