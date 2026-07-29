package kr;

import ir.e;
import ir.f;
import ir.i;
import rr.o;

/* JADX INFO: loaded from: classes6.dex */
public class d extends i.c {
    public d(e eVar, f fVar, f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public d(e eVar, f fVar, f fVar2, f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public i A() {
        return v() ? this : new d(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
    }

    @Override // ir.i
    public i K() {
        return (v() || this.f35708c.j()) ? this : M().a(this);
    }

    @Override // ir.i
    public i M() {
        if (v()) {
            return this;
        }
        e eVarI = i();
        c cVar = (c) this.f35708c;
        if (cVar.j()) {
            return eVarI.w();
        }
        c cVar2 = (c) this.f35707b;
        c cVar3 = (c) this.f35709d[0];
        int[] iArrL = rr.i.l();
        int[] iArrL2 = rr.i.l();
        int[] iArrL3 = rr.i.l();
        b.p(cVar.f39111g, iArrL3);
        int[] iArrL4 = rr.i.l();
        b.p(iArrL3, iArrL4);
        boolean zI = cVar3.i();
        int[] iArr = cVar3.f39111g;
        if (!zI) {
            b.p(iArr, iArrL2);
            iArr = iArrL2;
        }
        b.s(cVar2.f39111g, iArr, iArrL);
        b.a(cVar2.f39111g, iArr, iArrL2);
        b.i(iArrL2, iArrL, iArrL2);
        b.o(rr.i.d(iArrL2, iArrL2, iArrL2), iArrL2);
        b.i(iArrL3, cVar2.f39111g, iArrL3);
        b.o(o.E0(8, iArrL3, 2, 0), iArrL3);
        b.o(o.H0(8, iArrL4, 3, 0, iArrL), iArrL);
        c cVar4 = new c(iArrL4);
        b.p(iArrL2, cVar4.f39111g);
        int[] iArr2 = cVar4.f39111g;
        b.s(iArr2, iArrL3, iArr2);
        int[] iArr3 = cVar4.f39111g;
        b.s(iArr3, iArrL3, iArr3);
        c cVar5 = new c(iArrL3);
        b.s(iArrL3, cVar4.f39111g, cVar5.f39111g);
        int[] iArr4 = cVar5.f39111g;
        b.i(iArr4, iArrL2, iArr4);
        int[] iArr5 = cVar5.f39111g;
        b.s(iArr5, iArrL, iArr5);
        c cVar6 = new c(iArrL2);
        b.u(cVar.f39111g, cVar6.f39111g);
        if (!zI) {
            int[] iArr6 = cVar6.f39111g;
            b.i(iArr6, cVar3.f39111g, iArr6);
        }
        return new d(eVarI, cVar4, cVar5, new f[]{cVar6});
    }

    @Override // ir.i
    public i N(i iVar) {
        return this == iVar ? K() : v() ? iVar : iVar.v() ? M() : this.f35708c.j() ? iVar : M().a(iVar);
    }

    @Override // ir.i
    public i a(i iVar) {
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
        e eVarI = i();
        c cVar = (c) this.f35707b;
        c cVar2 = (c) this.f35708c;
        c cVar3 = (c) iVar.q();
        c cVar4 = (c) iVar.r();
        c cVar5 = (c) this.f35709d[0];
        c cVar6 = (c) iVar.s(0);
        int[] iArrN = rr.i.n();
        int[] iArrL = rr.i.l();
        int[] iArrL2 = rr.i.l();
        int[] iArrL3 = rr.i.l();
        boolean zI = cVar5.i();
        if (zI) {
            iArr = cVar3.f39111g;
            iArr2 = cVar4.f39111g;
        } else {
            b.p(cVar5.f39111g, iArrL2);
            b.i(iArrL2, cVar3.f39111g, iArrL);
            b.i(iArrL2, cVar5.f39111g, iArrL2);
            b.i(iArrL2, cVar4.f39111g, iArrL2);
            iArr = iArrL;
            iArr2 = iArrL2;
        }
        boolean zI2 = cVar6.i();
        if (zI2) {
            iArr3 = cVar.f39111g;
            iArr4 = cVar2.f39111g;
        } else {
            b.p(cVar6.f39111g, iArrL3);
            b.i(iArrL3, cVar.f39111g, iArrN);
            b.i(iArrL3, cVar6.f39111g, iArrL3);
            b.i(iArrL3, cVar2.f39111g, iArrL3);
            iArr3 = iArrN;
            iArr4 = iArrL3;
        }
        int[] iArrL4 = rr.i.l();
        b.s(iArr3, iArr, iArrL4);
        b.s(iArr4, iArr2, iArrL);
        if (rr.i.z(iArrL4)) {
            return rr.i.z(iArrL) ? M() : eVarI.w();
        }
        b.p(iArrL4, iArrL2);
        int[] iArrL5 = rr.i.l();
        b.i(iArrL2, iArrL4, iArrL5);
        b.i(iArrL2, iArr3, iArrL2);
        b.k(iArrL5, iArrL5);
        rr.i.C(iArr4, iArrL5, iArrN);
        b.o(rr.i.d(iArrL2, iArrL2, iArrL5), iArrL5);
        c cVar7 = new c(iArrL3);
        b.p(iArrL, cVar7.f39111g);
        int[] iArr5 = cVar7.f39111g;
        b.s(iArr5, iArrL5, iArr5);
        c cVar8 = new c(iArrL5);
        b.s(iArrL2, cVar7.f39111g, cVar8.f39111g);
        b.j(cVar8.f39111g, iArrL, iArrN);
        b.n(iArrN, cVar8.f39111g);
        c cVar9 = new c(iArrL4);
        if (!zI) {
            int[] iArr6 = cVar9.f39111g;
            b.i(iArr6, cVar5.f39111g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = cVar9.f39111g;
            b.i(iArr7, cVar6.f39111g, iArr7);
        }
        return new d(eVarI, cVar7, cVar8, new f[]{cVar9});
    }

    @Override // ir.i
    public i d() {
        return new d(null, f(), g());
    }
}
