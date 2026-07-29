package lr;

import ir.i;

/* JADX INFO: loaded from: classes6.dex */
public class v2 extends i.b {
    public v2(ir.e eVar, ir.f fVar, ir.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public v2(ir.e eVar, ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
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
        return new v2(this.f35706a, fVar, fVar2.a(fVar3), new ir.f[]{fVar3});
    }

    @Override // ir.i
    public ir.i M() {
        long[] jArr;
        if (v()) {
            return this;
        }
        ir.e eVarI = i();
        r2 r2Var = (r2) this.f35707b;
        if (r2Var.j()) {
            return eVarI.w();
        }
        r2 r2Var2 = (r2) this.f35708c;
        r2 r2Var3 = (r2) this.f35709d[0];
        long[] jArrC = rr.n.c();
        long[] jArrC2 = rr.n.c();
        long[] jArrS = r2Var3.i() ? null : q2.s(r2Var3.f40350g);
        long[] jArr2 = r2Var2.f40350g;
        if (jArrS == null) {
            jArr = r2Var3.f40350g;
        } else {
            q2.q(jArr2, jArrS, jArrC);
            q2.w(r2Var3.f40350g, jArrC2);
            jArr2 = jArrC;
            jArr = jArrC2;
        }
        long[] jArrC3 = rr.n.c();
        q2.w(r2Var2.f40350g, jArrC3);
        q2.d(jArr2, jArr, jArrC3);
        if (rr.n.h(jArrC3)) {
            return new v2(eVarI, new r2(jArrC3), u2.f40387v);
        }
        long[] jArrD = rr.n.d();
        q2.p(jArrC3, jArr2, jArrD);
        r2 r2Var4 = new r2(jArrC);
        q2.w(jArrC3, r2Var4.f40350g);
        r2 r2Var5 = new r2(jArrC3);
        if (jArrS != null) {
            long[] jArr3 = r2Var5.f40350g;
            q2.o(jArr3, jArr, jArr3);
        }
        long[] jArr4 = r2Var.f40350g;
        if (jArrS != null) {
            q2.q(jArr4, jArrS, jArrC2);
            jArr4 = jArrC2;
        }
        q2.x(jArr4, jArrD);
        q2.t(jArrD, jArrC2);
        q2.d(r2Var4.f40350g, r2Var5.f40350g, jArrC2);
        return new v2(eVarI, r2Var4, new r2(jArrC2), new ir.f[]{r2Var5});
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
        r2 r2Var = (r2) this.f35707b;
        if (r2Var.j()) {
            return iVar;
        }
        r2 r2Var2 = (r2) iVar.n();
        r2 r2Var3 = (r2) iVar.s(0);
        if (r2Var2.j() || !r2Var3.i()) {
            return M().a(iVar);
        }
        r2 r2Var4 = (r2) this.f35708c;
        r2 r2Var5 = (r2) this.f35709d[0];
        r2 r2Var6 = (r2) iVar.o();
        long[] jArrC = rr.n.c();
        long[] jArrC2 = rr.n.c();
        long[] jArrC3 = rr.n.c();
        long[] jArrC4 = rr.n.c();
        q2.w(r2Var.f40350g, jArrC);
        q2.w(r2Var4.f40350g, jArrC2);
        q2.w(r2Var5.f40350g, jArrC3);
        q2.o(r2Var4.f40350g, r2Var5.f40350g, jArrC4);
        q2.d(jArrC3, jArrC2, jArrC4);
        long[] jArrS = q2.s(jArrC3);
        q2.q(r2Var6.f40350g, jArrS, jArrC3);
        q2.b(jArrC3, jArrC2, jArrC3);
        long[] jArrD = rr.n.d();
        q2.p(jArrC3, jArrC4, jArrD);
        q2.r(jArrC, jArrS, jArrD);
        q2.t(jArrD, jArrC3);
        q2.q(r2Var2.f40350g, jArrS, jArrC);
        q2.b(jArrC, jArrC4, jArrC2);
        q2.w(jArrC2, jArrC2);
        if (rr.n.h(jArrC2)) {
            return rr.n.h(jArrC3) ? iVar.M() : eVarI.w();
        }
        if (rr.n.h(jArrC3)) {
            return new v2(eVarI, new r2(jArrC3), u2.f40387v);
        }
        r2 r2Var7 = new r2();
        q2.w(jArrC3, r2Var7.f40350g);
        long[] jArr = r2Var7.f40350g;
        q2.o(jArr, jArrC, jArr);
        r2 r2Var8 = new r2(jArrC);
        q2.o(jArrC3, jArrC2, r2Var8.f40350g);
        long[] jArr2 = r2Var8.f40350g;
        q2.q(jArr2, jArrS, jArr2);
        r2 r2Var9 = new r2(jArrC2);
        q2.b(jArrC3, jArrC2, r2Var9.f40350g);
        long[] jArr3 = r2Var9.f40350g;
        q2.w(jArr3, jArr3);
        rr.o.j1(18, jArrD);
        q2.p(r2Var9.f40350g, jArrC4, jArrD);
        q2.f(r2Var6.f40350g, jArrC4);
        q2.p(jArrC4, r2Var8.f40350g, jArrD);
        q2.t(jArrD, r2Var9.f40350g);
        return new v2(eVarI, r2Var7, r2Var9, new ir.f[]{r2Var8});
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
            r2Var = (r2) fVarD.p().a(fVarD).a(r2Var10).b();
            if (r2Var.j()) {
                return new v2(eVarI, r2Var, u2.f40387v);
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
                return new v2(eVarI, r2Var11, u2.f40387v);
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
        return new v2(eVarI, r2Var, r2Var2, new ir.f[]{r2Var3});
    }

    @Override // ir.i
    public ir.i d() {
        return new v2(null, f(), g());
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
