package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class j extends i.c {
    public j(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public j(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new j(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        i iVar = (i) this.f35708c;
        if (iVar.j()) {
            return eVarI.w();
        }
        i iVar2 = (i) this.f35707b;
        i iVar3 = (i) this.f35709d[0];
        int[] iArrH = rr.f.h();
        int[] iArrH2 = rr.f.h();
        int[] iArrH3 = rr.f.h();
        h.o(iVar.f40231g, iArrH3);
        int[] iArrH4 = rr.f.h();
        h.o(iArrH3, iArrH4);
        boolean zI = iVar3.i();
        int[] iArr = iVar3.f40231g;
        if (!zI) {
            h.o(iArr, iArrH2);
            iArr = iArrH2;
        }
        h.q(iVar2.f40231g, iArr, iArrH);
        h.a(iVar2.f40231g, iArr, iArrH2);
        h.h(iArrH2, iArrH, iArrH2);
        h.n(rr.f.b(iArrH2, iArrH2, iArrH2), iArrH2);
        h.h(iArrH3, iVar2.f40231g, iArrH3);
        h.n(rr.o.E0(5, iArrH3, 2, 0), iArrH3);
        h.n(rr.o.H0(5, iArrH4, 3, 0, iArrH), iArrH);
        i iVar4 = new i(iArrH4);
        h.o(iArrH2, iVar4.f40231g);
        int[] iArr2 = iVar4.f40231g;
        h.q(iArr2, iArrH3, iArr2);
        int[] iArr3 = iVar4.f40231g;
        h.q(iArr3, iArrH3, iArr3);
        i iVar5 = new i(iArrH3);
        h.q(iArrH3, iVar4.f40231g, iVar5.f40231g);
        int[] iArr4 = iVar5.f40231g;
        h.h(iArr4, iArrH2, iArr4);
        int[] iArr5 = iVar5.f40231g;
        h.q(iArr5, iArrH, iArr5);
        i iVar6 = new i(iArrH2);
        h.s(iVar.f40231g, iVar6.f40231g);
        if (!zI) {
            int[] iArr6 = iVar6.f40231g;
            h.h(iArr6, iVar3.f40231g, iArr6);
        }
        return new j(eVarI, iVar4, iVar5, new ir.f[]{iVar6});
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
        i iVar2 = (i) this.f35707b;
        i iVar3 = (i) this.f35708c;
        i iVar4 = (i) iVar.q();
        i iVar5 = (i) iVar.r();
        i iVar6 = (i) this.f35709d[0];
        i iVar7 = (i) iVar.s(0);
        int[] iArrI = rr.f.i();
        int[] iArrH = rr.f.h();
        int[] iArrH2 = rr.f.h();
        int[] iArrH3 = rr.f.h();
        boolean zI = iVar6.i();
        if (zI) {
            iArr = iVar4.f40231g;
            iArr2 = iVar5.f40231g;
        } else {
            h.o(iVar6.f40231g, iArrH2);
            h.h(iArrH2, iVar4.f40231g, iArrH);
            h.h(iArrH2, iVar6.f40231g, iArrH2);
            h.h(iArrH2, iVar5.f40231g, iArrH2);
            iArr = iArrH;
            iArr2 = iArrH2;
        }
        boolean zI2 = iVar7.i();
        if (zI2) {
            iArr3 = iVar2.f40231g;
            iArr4 = iVar3.f40231g;
        } else {
            h.o(iVar7.f40231g, iArrH3);
            h.h(iArrH3, iVar2.f40231g, iArrI);
            h.h(iArrH3, iVar7.f40231g, iArrH3);
            h.h(iArrH3, iVar3.f40231g, iArrH3);
            iArr3 = iArrI;
            iArr4 = iArrH3;
        }
        int[] iArrH4 = rr.f.h();
        h.q(iArr3, iArr, iArrH4);
        h.q(iArr4, iArr2, iArrH);
        if (rr.f.q(iArrH4)) {
            return rr.f.q(iArrH) ? M() : eVarI.w();
        }
        h.o(iArrH4, iArrH2);
        int[] iArrH5 = rr.f.h();
        h.h(iArrH2, iArrH4, iArrH5);
        h.h(iArrH2, iArr3, iArrH2);
        h.j(iArrH5, iArrH5);
        rr.f.s(iArr4, iArrH5, iArrI);
        h.n(rr.f.b(iArrH2, iArrH2, iArrH5), iArrH5);
        i iVar8 = new i(iArrH3);
        h.o(iArrH, iVar8.f40231g);
        int[] iArr5 = iVar8.f40231g;
        h.q(iArr5, iArrH5, iArr5);
        i iVar9 = new i(iArrH5);
        h.q(iArrH2, iVar8.f40231g, iVar9.f40231g);
        h.i(iVar9.f40231g, iArrH, iArrI);
        h.m(iArrI, iVar9.f40231g);
        i iVar10 = new i(iArrH4);
        if (!zI) {
            int[] iArr6 = iVar10.f40231g;
            h.h(iArr6, iVar6.f40231g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = iVar10.f40231g;
            h.h(iArr7, iVar7.f40231g, iArr7);
        }
        return new j(eVarI, iVar8, iVar9, new ir.f[]{iVar10});
    }

    @Override // ir.i
    public ir.i d() {
        return new j(null, f(), g());
    }
}
