package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class t2 extends i.b {
    public t2(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public t2(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
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
        return new t2(this.f35706a, fVar, fVar2.a(fVar3), new ir.f[]{fVar3});
    }

    @Override // ir.i
    public ir.i M() {
        if (v()) {
            return this;
        }
        ir.e eVarI = i();
        ir.f fVar = this.f35707b;
        if (fVar.j()) {
            return eVarI.w();
        }
        ir.f fVar2 = this.f35708c;
        ir.f fVarP = this.f35709d[0];
        boolean zI = fVarP.i();
        ir.f fVarP2 = zI ? fVarP : fVarP.p();
        ir.f fVarA = zI ? fVar2.p().a(fVar2) : fVar2.a(fVarP).k(fVar2);
        if (fVarA.j()) {
            return new t2(eVarI, fVarA, eVarI.q());
        }
        ir.f fVarP3 = fVarA.p();
        ir.f fVarK = zI ? fVarA : fVarA.k(fVarP2);
        ir.f fVarP4 = fVar2.a(fVar).p();
        if (!zI) {
            fVarP = fVarP2.p();
        }
        return new t2(eVarI, fVarP3, fVarP4.a(fVarA).a(fVarP2).k(fVarP4).a(fVarP).a(fVarP3).a(fVarK), new ir.f[]{fVarK});
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
        ir.f fVarA = fVarP2.a(fVar2.k(fVar3));
        ir.f fVarB = fVarO.b();
        ir.f fVarM = fVarB.k(fVarP3).a(fVarP2).m(fVarA, fVarP, fVarP3);
        ir.f fVarK = fVarN.k(fVarP3);
        ir.f fVarP4 = fVarK.a(fVarA).p();
        if (fVarP4.j()) {
            return fVarM.j() ? iVar.M() : eVarI.w();
        }
        if (fVarM.j()) {
            return new t2(eVarI, fVarM, eVarI.q());
        }
        ir.f fVarK2 = fVarM.p().k(fVarK);
        ir.f fVarK3 = fVarM.k(fVarP4).k(fVarP3);
        return new t2(eVarI, fVarK2, fVarM.a(fVarP4).p().m(fVarA, fVarB, fVarK3), new ir.f[]{fVarK3});
    }

    @Override // ir.i
    public ir.i a(ir.i iVar) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        r2 r2Var;
        r2 r2Var2;
        r2 r2Var3;
        if (v()) {
            return iVar;
        }
        if (iVar.v()) {
            return this;
        }
        ir.e eVarI = i();
        r2 r2Var4 = (r2) this.f35707b;
        r2 r2Var5 = (r2) iVar.n();
        if (r2Var4.j()) {
            return r2Var5.j() ? eVarI.w() : iVar.a(this);
        }
        r2 r2Var6 = (r2) this.f35708c;
        r2 r2Var7 = (r2) this.f35709d[0];
        r2 r2Var8 = (r2) iVar.o();
        r2 r2Var9 = (r2) iVar.s(0);
        long[] jArrC = rr.n.c();
        long[] jArrC2 = rr.n.c();
        long[] jArrC3 = rr.n.c();
        long[] jArrC4 = rr.n.c();
        long[] jArrS = r2Var7.i() ? null : q2.s(r2Var7.f40350g);
        if (jArrS == null) {
            jArr = r2Var5.f40350g;
            jArr2 = r2Var8.f40350g;
        } else {
            q2.q(r2Var5.f40350g, jArrS, jArrC2);
            q2.q(r2Var8.f40350g, jArrS, jArrC4);
            jArr = jArrC2;
            jArr2 = jArrC4;
        }
        long[] jArrS2 = r2Var9.i() ? null : q2.s(r2Var9.f40350g);
        long[] jArr4 = r2Var4.f40350g;
        if (jArrS2 == null) {
            jArr3 = r2Var6.f40350g;
        } else {
            q2.q(jArr4, jArrS2, jArrC);
            q2.q(r2Var6.f40350g, jArrS2, jArrC3);
            jArr4 = jArrC;
            jArr3 = jArrC3;
        }
        q2.b(jArr3, jArr2, jArrC3);
        q2.b(jArr4, jArr, jArrC4);
        if (rr.n.h(jArrC4)) {
            return rr.n.h(jArrC3) ? M() : eVarI.w();
        }
        if (r2Var5.j()) {
            ir.i iVarB = B();
            r2 r2Var10 = (r2) iVarB.q();
            ir.f fVarR = iVarB.r();
            ir.f fVarD = fVarR.a(r2Var8).d(r2Var10);
            r2Var = (r2) fVarD.p().a(fVarD).a(r2Var10);
            if (r2Var.j()) {
                return new t2(eVarI, r2Var, eVarI.q());
            }
            r2Var2 = (r2) fVarD.k(r2Var10.a(r2Var)).a(r2Var).a(fVarR).d(r2Var).a(r2Var);
            r2Var3 = (r2) eVarI.n(ir.d.f35647b);
        } else {
            q2.w(jArrC4, jArrC4);
            long[] jArrS3 = q2.s(jArrC3);
            q2.q(jArr4, jArrS3, jArrC);
            q2.q(jArr, jArrS3, jArrC2);
            r2 r2Var11 = new r2(jArrC);
            q2.o(jArrC, jArrC2, r2Var11.f40350g);
            if (r2Var11.j()) {
                return new t2(eVarI, r2Var11, eVarI.q());
            }
            r2 r2Var12 = new r2(jArrC3);
            q2.q(jArrC4, jArrS3, r2Var12.f40350g);
            if (jArrS2 != null) {
                long[] jArr5 = r2Var12.f40350g;
                q2.q(jArr5, jArrS2, jArr5);
            }
            long[] jArrD = rr.n.d();
            q2.b(jArrC2, jArrC4, jArrC4);
            q2.x(jArrC4, jArrD);
            q2.b(r2Var6.f40350g, r2Var7.f40350g, jArrC4);
            q2.p(jArrC4, r2Var12.f40350g, jArrD);
            r2 r2Var13 = new r2(jArrC4);
            q2.t(jArrD, r2Var13.f40350g);
            if (jArrS != null) {
                long[] jArr6 = r2Var12.f40350g;
                q2.q(jArr6, jArrS, jArr6);
            }
            r2Var = r2Var11;
            r2Var2 = r2Var13;
            r2Var3 = r2Var12;
        }
        return new t2(eVarI, r2Var, r2Var2, new ir.f[]{r2Var3});
    }

    @Override // ir.i
    public ir.i d() {
        return new t2(null, f(), g());
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
