package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class f extends i.c {
    public f(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public f(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        return v() ? this : new f(this.f35706a, this.f35707b, this.f35708c.n(), this.f35709d);
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
        m mVar = (m) this.f35708c;
        if (mVar.j()) {
            return eVarI.w();
        }
        m mVar2 = (m) this.f35707b;
        m mVar3 = (m) this.f35709d[0];
        int[] iArrH = rr.f.h();
        l.o(mVar.f40281g, iArrH);
        int[] iArrH2 = rr.f.h();
        l.o(iArrH, iArrH2);
        int[] iArrH3 = rr.f.h();
        l.o(mVar2.f40281g, iArrH3);
        l.n(rr.f.b(iArrH3, iArrH3, iArrH3), iArrH3);
        l.h(iArrH, mVar2.f40281g, iArrH);
        l.n(rr.o.E0(5, iArrH, 2, 0), iArrH);
        int[] iArrH4 = rr.f.h();
        l.n(rr.o.H0(5, iArrH2, 3, 0, iArrH4), iArrH4);
        m mVar4 = new m(iArrH2);
        l.o(iArrH3, mVar4.f40281g);
        int[] iArr = mVar4.f40281g;
        l.q(iArr, iArrH, iArr);
        int[] iArr2 = mVar4.f40281g;
        l.q(iArr2, iArrH, iArr2);
        m mVar5 = new m(iArrH);
        l.q(iArrH, mVar4.f40281g, mVar5.f40281g);
        int[] iArr3 = mVar5.f40281g;
        l.h(iArr3, iArrH3, iArr3);
        int[] iArr4 = mVar5.f40281g;
        l.q(iArr4, iArrH4, iArr4);
        m mVar6 = new m(iArrH3);
        l.s(mVar.f40281g, mVar6.f40281g);
        if (!mVar3.i()) {
            int[] iArr5 = mVar6.f40281g;
            l.h(iArr5, mVar3.f40281g, iArr5);
        }
        return new f(eVarI, mVar4, mVar5, new ir.f[]{mVar6});
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
        m mVar = (m) this.f35707b;
        m mVar2 = (m) this.f35708c;
        m mVar3 = (m) iVar.q();
        m mVar4 = (m) iVar.r();
        m mVar5 = (m) this.f35709d[0];
        m mVar6 = (m) iVar.s(0);
        int[] iArrI = rr.f.i();
        int[] iArrH = rr.f.h();
        int[] iArrH2 = rr.f.h();
        int[] iArrH3 = rr.f.h();
        boolean zI = mVar5.i();
        if (zI) {
            iArr = mVar3.f40281g;
            iArr2 = mVar4.f40281g;
        } else {
            l.o(mVar5.f40281g, iArrH2);
            l.h(iArrH2, mVar3.f40281g, iArrH);
            l.h(iArrH2, mVar5.f40281g, iArrH2);
            l.h(iArrH2, mVar4.f40281g, iArrH2);
            iArr = iArrH;
            iArr2 = iArrH2;
        }
        boolean zI2 = mVar6.i();
        if (zI2) {
            iArr3 = mVar.f40281g;
            iArr4 = mVar2.f40281g;
        } else {
            l.o(mVar6.f40281g, iArrH3);
            l.h(iArrH3, mVar.f40281g, iArrI);
            l.h(iArrH3, mVar6.f40281g, iArrH3);
            l.h(iArrH3, mVar2.f40281g, iArrH3);
            iArr3 = iArrI;
            iArr4 = iArrH3;
        }
        int[] iArrH4 = rr.f.h();
        l.q(iArr3, iArr, iArrH4);
        l.q(iArr4, iArr2, iArrH);
        if (rr.f.q(iArrH4)) {
            return rr.f.q(iArrH) ? M() : eVarI.w();
        }
        l.o(iArrH4, iArrH2);
        int[] iArrH5 = rr.f.h();
        l.h(iArrH2, iArrH4, iArrH5);
        l.h(iArrH2, iArr3, iArrH2);
        l.j(iArrH5, iArrH5);
        rr.f.s(iArr4, iArrH5, iArrI);
        l.n(rr.f.b(iArrH2, iArrH2, iArrH5), iArrH5);
        m mVar7 = new m(iArrH3);
        l.o(iArrH, mVar7.f40281g);
        int[] iArr5 = mVar7.f40281g;
        l.q(iArr5, iArrH5, iArr5);
        m mVar8 = new m(iArrH5);
        l.q(iArrH2, mVar7.f40281g, mVar8.f40281g);
        l.i(mVar8.f40281g, iArrH, iArrI);
        l.m(iArrI, mVar8.f40281g);
        m mVar9 = new m(iArrH4);
        if (!zI) {
            int[] iArr6 = mVar9.f40281g;
            l.h(iArr6, mVar5.f40281g, iArr6);
        }
        if (!zI2) {
            int[] iArr7 = mVar9.f40281g;
            l.h(iArr7, mVar6.f40281g, iArr7);
        }
        return new f(eVarI, mVar7, mVar8, new ir.f[]{mVar9});
    }

    @Override // ir.i
    public ir.i d() {
        return new f(null, f(), g());
    }
}
