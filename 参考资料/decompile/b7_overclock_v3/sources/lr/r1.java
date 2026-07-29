package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class r1 extends i.b {
    public r1(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public r1(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // ir.i
    public ir.i A() {
        if (v()) {
            return this;
        }
        ir.f fVar = this.f35707b;
        if (fVar.j()) {
            return this;
        }
        ir.f fVar2 = this.f35708c;
        ir.f fVar3 = this.f35709d[0];
        return new r1(this.f35706a, fVar, fVar2.a(fVar3), new ir.f[]{fVar3});
    }

    @Override // ir.i
    public ir.i M() {
        if (v()) {
            return this;
        }
        ir.e eVarI = i();
        ir.f fVarK = this.f35707b;
        if (fVarK.j()) {
            return eVarI.w();
        }
        ir.f fVar = this.f35708c;
        ir.f fVar2 = this.f35709d[0];
        boolean zI = fVar2.i();
        ir.f fVarK2 = zI ? fVar : fVar.k(fVar2);
        ir.f fVarP = zI ? fVar2 : fVar2.p();
        ir.f fVarO = eVarI.o();
        if (!zI) {
            fVarO = fVarO.k(fVarP);
        }
        ir.f fVarA = fVar.p().a(fVarK2).a(fVarO);
        if (fVarA.j()) {
            return new r1(eVarI, fVarA, eVarI.q().o());
        }
        ir.f fVarP2 = fVarA.p();
        ir.f fVarK3 = zI ? fVarA : fVarA.k(fVarP);
        if (!zI) {
            fVarK = fVarK.k(fVar2);
        }
        return new r1(eVarI, fVarP2, fVarK.r(fVarA, fVarK2).a(fVarP2).a(fVarK3), new ir.f[]{fVarK3});
    }

    @Override // ir.i
    public ir.i N(ir.i iVar) {
        if (v()) {
            return iVar;
        }
        if (iVar.v()) {
            return M();
        }
        ir.e eVarI = i();
        ir.f fVar = this.f35707b;
        if (fVar.j()) {
            return iVar;
        }
        ir.f fVarN = iVar.n();
        ir.f fVarS = iVar.s(0);
        if (fVarN.j() || !fVarS.i()) {
            return M().a(iVar);
        }
        ir.f fVar2 = this.f35708c;
        ir.f fVar3 = this.f35709d[0];
        ir.f fVarO = iVar.o();
        ir.f fVarP = fVar.p();
        ir.f fVarP2 = fVar2.p();
        ir.f fVarP3 = fVar3.p();
        ir.f fVarA = eVarI.o().k(fVarP3).a(fVarP2).a(fVar2.k(fVar3));
        ir.f fVarB = fVarO.b();
        ir.f fVarM = eVarI.o().a(fVarB).k(fVarP3).a(fVarP2).m(fVarA, fVarP, fVarP3);
        ir.f fVarK = fVarN.k(fVarP3);
        ir.f fVarP4 = fVarK.a(fVarA).p();
        if (fVarP4.j()) {
            return fVarM.j() ? iVar.M() : eVarI.w();
        }
        if (fVarM.j()) {
            return new r1(eVarI, fVarM, eVarI.q().o());
        }
        ir.f fVarK2 = fVarM.p().k(fVarK);
        ir.f fVarK3 = fVarM.k(fVarP4).k(fVarP3);
        return new r1(eVarI, fVarK2, fVarM.a(fVarP4).p().m(fVarA, fVarB, fVarK3), new ir.f[]{fVarK3});
    }

    @Override // ir.i
    public ir.i a(ir.i iVar) {
        ir.f fVarK;
        ir.f fVarK2;
        ir.f fVarK3;
        ir.f fVarA;
        ir.f fVarN;
        ir.f fVarA2;
        if (v()) {
            return iVar;
        }
        if (iVar.v()) {
            return this;
        }
        ir.e eVarI = i();
        ir.f fVarK4 = this.f35707b;
        ir.f fVarN2 = iVar.n();
        if (fVarK4.j()) {
            return fVarN2.j() ? eVarI.w() : iVar.a(this);
        }
        ir.f fVar = this.f35708c;
        ir.f fVar2 = this.f35709d[0];
        ir.f fVarO = iVar.o();
        ir.f fVarS = iVar.s(0);
        boolean zI = fVar2.i();
        if (zI) {
            fVarK = fVarN2;
            fVarK2 = fVarO;
        } else {
            fVarK = fVarN2.k(fVar2);
            fVarK2 = fVarO.k(fVar2);
        }
        boolean zI2 = fVarS.i();
        if (zI2) {
            fVarK3 = fVar;
        } else {
            fVarK4 = fVarK4.k(fVarS);
            fVarK3 = fVar.k(fVarS);
        }
        ir.f fVarA3 = fVarK3.a(fVarK2);
        ir.f fVarA4 = fVarK4.a(fVarK);
        if (fVarA4.j()) {
            return fVarA3.j() ? M() : eVarI.w();
        }
        if (fVarN2.j()) {
            ir.i iVarB = B();
            ir.f fVarQ = iVarB.q();
            ir.f fVarR = iVarB.r();
            ir.f fVarD = fVarR.a(fVarO).d(fVarQ);
            fVarA = fVarD.p().a(fVarD).a(fVarQ).a(eVarI.o());
            if (fVarA.j()) {
                return new r1(eVarI, fVarA, eVarI.q().o());
            }
            fVarA2 = fVarD.k(fVarQ.a(fVarA)).a(fVarA).a(fVarR).d(fVarA).a(fVarA);
            fVarN = eVarI.n(ir.d.f35647b);
        } else {
            ir.f fVarP = fVarA4.p();
            ir.f fVarK5 = fVarA3.k(fVarK4);
            ir.f fVarK6 = fVarA3.k(fVarK);
            ir.f fVarK7 = fVarK5.k(fVarK6);
            if (fVarK7.j()) {
                return new r1(eVarI, fVarK7, eVarI.q().o());
            }
            ir.f fVarK8 = fVarA3.k(fVarP);
            ir.f fVarK9 = !zI2 ? fVarK8.k(fVarS) : fVarK8;
            ir.f fVarR2 = fVarK6.a(fVarP).r(fVarK9, fVar.a(fVar2));
            if (!zI) {
                fVarK9 = fVarK9.k(fVar2);
            }
            fVarA = fVarK7;
            fVarN = fVarK9;
            fVarA2 = fVarR2;
        }
        return new r1(eVarI, fVarA, fVarA2, new ir.f[]{fVarN});
    }

    @Override // ir.i
    public ir.i d() {
        return new r1(null, f(), g());
    }

    @Override // ir.i
    public boolean h() {
        ir.f fVarN = n();
        return (fVarN.j() || o().u() == fVarN.u()) ? false : true;
    }

    @Override // ir.i
    public ir.f r() {
        ir.f fVar = this.f35707b;
        ir.f fVar2 = this.f35708c;
        if (v() || fVar.j()) {
            return fVar2;
        }
        ir.f fVarK = fVar2.a(fVar).k(fVar);
        ir.f fVar3 = this.f35709d[0];
        return !fVar3.i() ? fVarK.d(fVar3) : fVarK;
    }
}
