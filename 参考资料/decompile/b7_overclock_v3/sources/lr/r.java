package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class r extends i.c {
    public r(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public r(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new r(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        q qVar = (q) this.f35708c;
        if (qVar.j()) {
            return eVarI.w();
        }
        q qVar2 = (q) this.f35707b;
        q qVar3 = (q) this.f35709d[0];
        int[] iArrJ = rr.g.j();
        p.o(qVar.f40332g, iArrJ);
        int[] iArrJ2 = rr.g.j();
        p.o(iArrJ, iArrJ2);
        int[] iArrJ3 = rr.g.j();
        p.o(qVar2.f40332g, iArrJ3);
        p.n(rr.g.b(iArrJ3, iArrJ3, iArrJ3), iArrJ3);
        p.h(iArrJ, qVar2.f40332g, iArrJ);
        p.n(rr.o.E0(6, iArrJ, 2, 0), iArrJ);
        int[] iArrJ4 = rr.g.j();
        p.n(rr.o.H0(6, iArrJ2, 3, 0, iArrJ4), iArrJ4);
        q qVar4 = new q(iArrJ2);
        p.o(iArrJ3, qVar4.f40332g);
        int[] iArr = qVar4.f40332g;
        p.q(iArr, iArrJ, iArr);
        int[] iArr2 = qVar4.f40332g;
        p.q(iArr2, iArrJ, iArr2);
        q qVar5 = new q(iArrJ);
        p.q(iArrJ, qVar4.f40332g, qVar5.f40332g);
        int[] iArr3 = qVar5.f40332g;
        p.h(iArr3, iArrJ3, iArr3);
        int[] iArr4 = qVar5.f40332g;
        p.q(iArr4, iArrJ4, iArr4);
        q qVar6 = new q(iArrJ3);
        p.s(qVar.f40332g, qVar6.f40332g);
        if (!qVar3.i()) {
            int[] iArr5 = qVar6.f40332g;
            p.h(iArr5, qVar3.f40332g, iArr5);
        }
        return new r(eVarI, qVar4, qVar5, new ir.f[]{qVar6});
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
        q qVar = (q) this.f35707b;
        q qVar2 = (q) this.f35708c;
        q qVar3 = (q) iVar.q();
        q qVar4 = (q) iVar.r();
        q qVar5 = (q) this.f35709d[0];
        q qVar6 = (q) iVar.s(0);
        int[] iArrL = rr.g.l();
        int[] iArrJ = rr.g.j();
        int[] iArrJ2 = rr.g.j();
        int[] iArrJ3 = rr.g.j();
        boolean zI = qVar5.i();
        if (zI) {
            iArr = qVar3.f40332g;
            iArr2 = qVar4.f40332g;
        } else {
            p.o(qVar5.f40332g, iArrJ2);
            p.h(iArrJ2, qVar3.f40332g, iArrJ);
            p.h(iArrJ2, qVar5.f40332g, iArrJ2);
            p.h(iArrJ2, qVar4.f40332g, iArrJ2);
            iArr = iArrJ;
            iArr2 = iArrJ2;
        }
        boolean zI2 = qVar6.i();
        if (zI2) {
            iArr3 = qVar.f40332g;
            iArr4 = qVar2.f40332g;
        } else {
            p.o(qVar6.f40332g, iArrJ3);
            p.h(iArrJ3, qVar.f40332g, iArrL);
            p.h(iArrJ3, qVar6.f40332g, iArrJ3);
            p.h(iArrJ3, qVar2.f40332g, iArrJ3);
            iArr3 = iArrL;
            iArr4 = iArrJ3;
        }
        int[] iArrJ4 = rr.g.j();
        p.q(iArr3, iArr, iArrJ4);
        p.q(iArr4, iArr2, iArrJ);
        if (rr.g.x(iArrJ4)) {
            return rr.g.x(iArrJ) ? M() : eVarI.w();
        }
        p.o(iArrJ4, iArrJ2);
        int[] iArrJ5 = rr.g.j();
        p.h(iArrJ2, iArrJ4, iArrJ5);
        p.h(iArrJ2, iArr3, iArrJ2);
        p.j(iArrJ5, iArrJ5);
        rr.g.A(iArr4, iArrJ5, iArrL);
        p.n(rr.g.b(iArrJ2, iArrJ2, iArrJ5), iArrJ5);
        q qVar7 = new q(iArrJ3);
        p.o(iArrJ, qVar7.f40332g);
        int[] iArr5 = qVar7.f40332g;
        p.q(iArr5, iArrJ5, iArr5);
        q qVar8 = new q(iArrJ5);
        p.q(iArrJ2, qVar7.f40332g, qVar8.f40332g);
        p.i(qVar8.f40332g, iArrJ, iArrL);
        p.m(iArrL, qVar8.f40332g);
        q qVar9 = new q(iArrJ4);
        if (!zI) {
            int[] iArr6 = qVar9.f40332g;
            p.h(iArr6, qVar5.f40332g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = qVar9.f40332g;
            p.h(iArr7, qVar6.f40332g, iArr7);
        }
        return new r(eVarI, qVar7, qVar8, new ir.f[]{qVar9});
    }

    @Override // ir.i
    public ir.i d() {
        return new r(null, f(), g());
    }
}
