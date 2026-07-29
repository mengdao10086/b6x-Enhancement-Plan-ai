package jr;

import ir.e;
import ir.f;
import ir.i;

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
        return v() ? this : new d(i(), this.f35707b, this.f35708c.n(), this.f35709d);
    }

    @Override // ir.i
    public i K() {
        return (v() || this.f35708c.j()) ? this : Q(false).a(this);
    }

    @Override // ir.i
    public i M() {
        if (v()) {
            return this;
        }
        return this.f35708c.j() ? i().w() : Q(true);
    }

    @Override // ir.i
    public i N(i iVar) {
        return this == iVar ? K() : v() ? iVar : iVar.v() ? M() : this.f35708c.j() ? iVar : Q(false).a(iVar);
    }

    public c O(c cVar, int[] iArr) {
        c cVar2 = (c) i().o();
        if (cVar.i()) {
            return cVar2;
        }
        c cVar3 = new c();
        if (iArr == null) {
            iArr = cVar3.f36906g;
            b.q(cVar.f36906g, iArr);
        }
        b.q(iArr, cVar3.f36906g);
        int[] iArr2 = cVar3.f36906g;
        b.j(iArr2, cVar2.f36906g, iArr2);
        return cVar3;
    }

    public c P() {
        f[] fVarArr = this.f35709d;
        c cVar = (c) fVarArr[1];
        if (cVar != null) {
            return cVar;
        }
        c cVarO = O((c) fVarArr[0], null);
        fVarArr[1] = cVarO;
        return cVarO;
    }

    public d Q(boolean z10) {
        c cVar = (c) this.f35707b;
        c cVar2 = (c) this.f35708c;
        c cVar3 = (c) this.f35709d[0];
        c cVarP = P();
        int[] iArrL = rr.i.l();
        b.q(cVar.f36906g, iArrL);
        b.p(rr.i.d(iArrL, iArrL, iArrL) + rr.i.f(cVarP.f36906g, iArrL), iArrL);
        int[] iArrL2 = rr.i.l();
        b.w(cVar2.f36906g, iArrL2);
        int[] iArrL3 = rr.i.l();
        b.j(iArrL2, cVar2.f36906g, iArrL3);
        int[] iArrL4 = rr.i.l();
        b.j(iArrL3, cVar.f36906g, iArrL4);
        b.w(iArrL4, iArrL4);
        int[] iArrL5 = rr.i.l();
        b.q(iArrL3, iArrL5);
        b.w(iArrL5, iArrL5);
        c cVar4 = new c(iArrL3);
        b.q(iArrL, cVar4.f36906g);
        int[] iArr = cVar4.f36906g;
        b.u(iArr, iArrL4, iArr);
        int[] iArr2 = cVar4.f36906g;
        b.u(iArr2, iArrL4, iArr2);
        c cVar5 = new c(iArrL4);
        b.u(iArrL4, cVar4.f36906g, cVar5.f36906g);
        int[] iArr3 = cVar5.f36906g;
        b.j(iArr3, iArrL, iArr3);
        int[] iArr4 = cVar5.f36906g;
        b.u(iArr4, iArrL5, iArr4);
        c cVar6 = new c(iArrL2);
        if (!rr.i.x(cVar3.f36906g)) {
            int[] iArr5 = cVar6.f36906g;
            b.j(iArr5, cVar3.f36906g, iArr5);
        }
        c cVar7 = null;
        if (z10) {
            cVar7 = new c(iArrL5);
            int[] iArr6 = cVar7.f36906g;
            b.j(iArr6, cVarP.f36906g, iArr6);
            int[] iArr7 = cVar7.f36906g;
            b.w(iArr7, iArr7);
        }
        return new d(i(), cVar4, cVar5, new f[]{cVar6, cVar7});
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
        c cVar3 = (c) this.f35709d[0];
        c cVar4 = (c) iVar.q();
        c cVar5 = (c) iVar.r();
        c cVar6 = (c) iVar.s(0);
        int[] iArrN = rr.i.n();
        int[] iArrL = rr.i.l();
        int[] iArrL2 = rr.i.l();
        int[] iArrL3 = rr.i.l();
        boolean zI = cVar3.i();
        if (zI) {
            iArr = cVar4.f36906g;
            iArr2 = cVar5.f36906g;
        } else {
            b.q(cVar3.f36906g, iArrL2);
            b.j(iArrL2, cVar4.f36906g, iArrL);
            b.j(iArrL2, cVar3.f36906g, iArrL2);
            b.j(iArrL2, cVar5.f36906g, iArrL2);
            iArr = iArrL;
            iArr2 = iArrL2;
        }
        boolean zI2 = cVar6.i();
        if (zI2) {
            iArr3 = cVar.f36906g;
            iArr4 = cVar2.f36906g;
        } else {
            b.q(cVar6.f36906g, iArrL3);
            b.j(iArrL3, cVar.f36906g, iArrN);
            b.j(iArrL3, cVar6.f36906g, iArrL3);
            b.j(iArrL3, cVar2.f36906g, iArrL3);
            iArr3 = iArrN;
            iArr4 = iArrL3;
        }
        int[] iArrL4 = rr.i.l();
        b.u(iArr3, iArr, iArrL4);
        b.u(iArr4, iArr2, iArrL);
        if (rr.i.z(iArrL4)) {
            return rr.i.z(iArrL) ? M() : eVarI.w();
        }
        int[] iArrL5 = rr.i.l();
        b.q(iArrL4, iArrL5);
        int[] iArrL6 = rr.i.l();
        b.j(iArrL5, iArrL4, iArrL6);
        b.j(iArrL5, iArr3, iArrL2);
        b.l(iArrL6, iArrL6);
        rr.i.C(iArr4, iArrL6, iArrN);
        b.p(rr.i.d(iArrL2, iArrL2, iArrL6), iArrL6);
        c cVar7 = new c(iArrL3);
        b.q(iArrL, cVar7.f36906g);
        int[] iArr5 = cVar7.f36906g;
        b.u(iArr5, iArrL6, iArr5);
        c cVar8 = new c(iArrL6);
        b.u(iArrL2, cVar7.f36906g, cVar8.f36906g);
        b.k(cVar8.f36906g, iArrL, iArrN);
        b.o(iArrN, cVar8.f36906g);
        c cVar9 = new c(iArrL4);
        if (!zI) {
            int[] iArr6 = cVar9.f36906g;
            b.j(iArr6, cVar3.f36906g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = cVar9.f36906g;
            b.j(iArr7, cVar6.f36906g, iArr7);
        }
        if (!zI || !zI2) {
            iArrL5 = null;
        }
        return new d(eVarI, cVar7, cVar8, new f[]{cVar9, O(cVar9, iArrL5)});
    }

    @Override // ir.i
    public i d() {
        return new d(null, f(), g());
    }

    @Override // ir.i
    public f s(int i10) {
        return i10 == 1 ? P() : super.s(i10);
    }
}
