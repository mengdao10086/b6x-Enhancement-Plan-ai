package ir;

import ir.e;
import ir.f;
import java.math.BigInteger;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f[] f35705f = new f[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ir.e f35706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f35707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f35708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f[] f35709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Hashtable f35710e;

    public class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f35711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f35712b;

        public a(boolean z10, boolean z11) {
            this.f35711a = z10;
            this.f35712b = z11;
        }

        @Override // ir.p
        public q a(q qVar) {
            y yVar = qVar instanceof y ? (y) qVar : null;
            if (yVar == null) {
                yVar = new y();
            }
            if (yVar.b()) {
                return yVar;
            }
            if (!yVar.a()) {
                if (!this.f35711a && !i.this.D()) {
                    yVar.e();
                    return yVar;
                }
                yVar.d();
            }
            if (this.f35712b && !yVar.c()) {
                if (!i.this.E()) {
                    yVar.e();
                    return yVar;
                }
                yVar.f();
            }
            return yVar;
        }
    }

    public static abstract class b extends i {
        public b(ir.e eVar, f fVar, f fVar2) {
            super(eVar, fVar, fVar2);
        }

        public b(ir.e eVar, f fVar, f fVar2, f[] fVarArr) {
            super(eVar, fVar, fVar2, fVarArr);
        }

        @Override // ir.i
        public boolean D() {
            f fVarM;
            f fVarR;
            ir.e eVarI = i();
            f fVar = this.f35707b;
            f fVarO = eVarI.o();
            f fVarQ = eVarI.q();
            int iS = eVarI.s();
            if (iS != 6) {
                f fVar2 = this.f35708c;
                f fVarK = fVar2.a(fVar).k(fVar2);
                if (iS != 0) {
                    if (iS != 1) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    f fVar3 = this.f35709d[0];
                    if (!fVar3.i()) {
                        f fVarK2 = fVar3.k(fVar3.p());
                        fVarK = fVarK.k(fVar3);
                        fVarO = fVarO.k(fVar3);
                        fVarQ = fVarQ.k(fVarK2);
                    }
                }
                return fVarK.equals(fVar.a(fVarO).k(fVar.p()).a(fVarQ));
            }
            f fVar4 = this.f35709d[0];
            boolean zI = fVar4.i();
            if (fVar.j()) {
                f fVarP = this.f35708c.p();
                if (!zI) {
                    fVarQ = fVarQ.k(fVar4.p());
                }
                return fVarP.equals(fVarQ);
            }
            f fVar5 = this.f35708c;
            f fVarP2 = fVar.p();
            if (zI) {
                fVarM = fVar5.p().a(fVar5).a(fVarO);
                fVarR = fVarP2.p().a(fVarQ);
            } else {
                f fVarP3 = fVar4.p();
                f fVarP4 = fVarP3.p();
                fVarM = fVar5.a(fVar4).m(fVar5, fVarO, fVarP3);
                fVarR = fVarP2.r(fVarQ, fVarP4);
            }
            return fVarM.k(fVarP2).equals(fVarR);
        }

        @Override // ir.i
        public boolean E() {
            BigInteger bigIntegerR = this.f35706a.r();
            if (ir.d.f35648c.equals(bigIntegerR)) {
                return ((f.a) B().f()).y() != 0;
            }
            if (!ir.d.f35650e.equals(bigIntegerR)) {
                return super.E();
            }
            i iVarB = B();
            f fVarF = iVarB.f();
            ir.e eVar = this.f35706a;
            f fVarO = ((e.b) eVar).O(fVarF.a(eVar.o()));
            if (fVarO == null) {
                return false;
            }
            return ((f.a) fVarF.k(fVarO).a(iVarB.g())).y() == 0;
        }

        @Override // ir.i
        public i F(f fVar) {
            if (v()) {
                return this;
            }
            int iJ = j();
            if (iJ == 5) {
                f fVarN = n();
                return i().j(fVarN, o().a(fVarN).d(fVar).a(fVarN.k(fVar)), p());
            }
            if (iJ != 6) {
                return super.F(fVar);
            }
            f fVarN2 = n();
            f fVarO = o();
            f fVar2 = p()[0];
            f fVarK = fVarN2.k(fVar.p());
            return i().j(fVarK, fVarO.a(fVarN2).a(fVarK), new f[]{fVar2.k(fVar)});
        }

        @Override // ir.i
        public i G(f fVar) {
            return F(fVar);
        }

        @Override // ir.i
        public i H(f fVar) {
            if (v()) {
                return this;
            }
            int iJ = j();
            if (iJ != 5 && iJ != 6) {
                return super.H(fVar);
            }
            f fVarN = n();
            return i().j(fVarN, o().a(fVarN).k(fVar).a(fVarN), p());
        }

        @Override // ir.i
        public i I(f fVar) {
            return H(fVar);
        }

        @Override // ir.i
        public i J(i iVar) {
            return iVar.v() ? this : a(iVar.A());
        }

        public b O() {
            i iVarI;
            if (v()) {
                return this;
            }
            ir.e eVarI = i();
            int iS = eVarI.s();
            f fVar = this.f35707b;
            if (iS == 0) {
                iVarI = eVarI.i(fVar.p(), this.f35708c.p());
            } else {
                if (iS != 1) {
                    if (iS != 5) {
                        if (iS != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                    iVarI = eVarI.i(fVar.p(), this.f35708c.p());
                }
                iVarI = eVarI.j(fVar.p(), this.f35708c.p(), new f[]{this.f35709d[0].p()});
            }
            return (b) iVarI;
        }

        public b P(int i10) {
            i iVarI;
            if (v()) {
                return this;
            }
            ir.e eVarI = i();
            int iS = eVarI.s();
            f fVar = this.f35707b;
            if (iS == 0) {
                iVarI = eVarI.i(fVar.s(i10), this.f35708c.s(i10));
            } else {
                if (iS != 1) {
                    if (iS != 5) {
                        if (iS != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                    iVarI = eVarI.i(fVar.s(i10), this.f35708c.s(i10));
                }
                iVarI = eVarI.j(fVar.s(i10), this.f35708c.s(i10), new f[]{this.f35709d[0].s(i10)});
            }
            return (b) iVarI;
        }
    }

    public static abstract class c extends i {
        public c(ir.e eVar, f fVar, f fVar2) {
            super(eVar, fVar, fVar2);
        }

        public c(ir.e eVar, f fVar, f fVar2, f[] fVarArr) {
            super(eVar, fVar, fVar2, fVarArr);
        }

        @Override // ir.i
        public boolean D() {
            f fVar = this.f35707b;
            f fVar2 = this.f35708c;
            f fVarO = this.f35706a.o();
            f fVarQ = this.f35706a.q();
            f fVarP = fVar2.p();
            int iJ = j();
            if (iJ != 0) {
                if (iJ == 1) {
                    f fVar3 = this.f35709d[0];
                    if (!fVar3.i()) {
                        f fVarP2 = fVar3.p();
                        f fVarK = fVar3.k(fVarP2);
                        fVarP = fVarP.k(fVar3);
                        fVarO = fVarO.k(fVarP2);
                        fVarQ = fVarQ.k(fVarK);
                    }
                } else {
                    if (iJ != 2 && iJ != 3 && iJ != 4) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    f fVar4 = this.f35709d[0];
                    if (!fVar4.i()) {
                        f fVarP3 = fVar4.p();
                        f fVarP4 = fVarP3.p();
                        f fVarK2 = fVarP3.k(fVarP4);
                        fVarO = fVarO.k(fVarP4);
                        fVarQ = fVarQ.k(fVarK2);
                    }
                }
            }
            return fVarP.equals(fVar.p().a(fVarO).k(fVar).a(fVarQ));
        }

        @Override // ir.i
        public i J(i iVar) {
            return iVar.v() ? this : a(iVar.A());
        }

        @Override // ir.i
        public boolean h() {
            return g().u();
        }
    }

    public static class d extends b {
        public d(ir.e eVar, f fVar, f fVar2) {
            super(eVar, fVar, fVar2);
        }

        public d(ir.e eVar, f fVar, f fVar2, f[] fVarArr) {
            super(eVar, fVar, fVar2, fVarArr);
        }

        @Override // ir.i
        public i A() {
            if (v()) {
                return this;
            }
            f fVar = this.f35707b;
            if (fVar.j()) {
                return this;
            }
            int iJ = j();
            if (iJ == 0) {
                return new d(this.f35706a, fVar, this.f35708c.a(fVar));
            }
            if (iJ == 1) {
                return new d(this.f35706a, fVar, this.f35708c.a(fVar), new f[]{this.f35709d[0]});
            }
            if (iJ == 5) {
                return new d(this.f35706a, fVar, this.f35708c.b());
            }
            if (iJ != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            f fVar2 = this.f35708c;
            f fVar3 = this.f35709d[0];
            return new d(this.f35706a, fVar, fVar2.a(fVar3), new f[]{fVar3});
        }

        @Override // ir.i
        public i M() {
            f fVarA;
            if (v()) {
                return this;
            }
            ir.e eVarI = i();
            f fVarK = this.f35707b;
            if (fVarK.j()) {
                return eVarI.w();
            }
            int iS = eVarI.s();
            if (iS == 0) {
                f fVarA2 = this.f35708c.d(fVarK).a(fVarK);
                f fVarA3 = fVarA2.p().a(fVarA2).a(eVarI.o());
                return new d(eVarI, fVarA3, fVarK.r(fVarA3, fVarA2.b()));
            }
            if (iS == 1) {
                f fVarK2 = this.f35708c;
                f fVar = this.f35709d[0];
                boolean zI = fVar.i();
                f fVarK3 = zI ? fVarK : fVarK.k(fVar);
                if (!zI) {
                    fVarK2 = fVarK2.k(fVar);
                }
                f fVarP = fVarK.p();
                f fVarA4 = fVarP.a(fVarK2);
                f fVarP2 = fVarK3.p();
                f fVarA5 = fVarA4.a(fVarK3);
                f fVarM = fVarA5.m(fVarA4, fVarP2, eVarI.o());
                return new d(eVarI, fVarK3.k(fVarM), fVarP.p().m(fVarK3, fVarM, fVarA5), new f[]{fVarK3.k(fVarP2)});
            }
            if (iS != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            f fVar2 = this.f35708c;
            f fVar3 = this.f35709d[0];
            boolean zI2 = fVar3.i();
            f fVarK4 = zI2 ? fVar2 : fVar2.k(fVar3);
            f fVarP3 = zI2 ? fVar3 : fVar3.p();
            f fVarO = eVarI.o();
            f fVarK5 = zI2 ? fVarO : fVarO.k(fVarP3);
            f fVarA6 = fVar2.p().a(fVarK4).a(fVarK5);
            if (fVarA6.j()) {
                return new d(eVarI, fVarA6, eVarI.q().o());
            }
            f fVarP4 = fVarA6.p();
            f fVarK6 = zI2 ? fVarA6 : fVarA6.k(fVarP3);
            f fVarQ = eVarI.q();
            if (fVarQ.c() < (eVarI.v() >> 1)) {
                f fVarP5 = fVar2.a(fVarK).p();
                fVarA = fVarP5.a(fVarA6).a(fVarP3).k(fVarP5).a(fVarQ.i() ? fVarK5.a(fVarP3).p() : fVarK5.r(fVarQ, fVarP3.p())).a(fVarP4);
                if (!fVarO.j()) {
                    if (!fVarO.i()) {
                        fVarA = fVarA.a(fVarO.b().k(fVarK6));
                    }
                }
                return new d(eVarI, fVarP4, fVarA, new f[]{fVarK6});
            }
            if (!zI2) {
                fVarK = fVarK.k(fVar3);
            }
            fVarA = fVarK.r(fVarA6, fVarK4).a(fVarP4);
            fVarA = fVarA.a(fVarK6);
            return new d(eVarI, fVarP4, fVarA, new f[]{fVarK6});
        }

        @Override // ir.i
        public i N(i iVar) {
            if (v()) {
                return iVar;
            }
            if (iVar.v()) {
                return M();
            }
            ir.e eVarI = i();
            f fVar = this.f35707b;
            if (fVar.j()) {
                return iVar;
            }
            if (eVarI.s() != 6) {
                return M().a(iVar);
            }
            f fVar2 = iVar.f35707b;
            f fVar3 = iVar.f35709d[0];
            if (fVar2.j() || !fVar3.i()) {
                return M().a(iVar);
            }
            f fVar4 = this.f35708c;
            f fVar5 = this.f35709d[0];
            f fVar6 = iVar.f35708c;
            f fVarP = fVar.p();
            f fVarP2 = fVar4.p();
            f fVarP3 = fVar5.p();
            f fVarA = eVarI.o().k(fVarP3).a(fVarP2).a(fVar4.k(fVar5));
            f fVarB = fVar6.b();
            f fVarM = eVarI.o().a(fVarB).k(fVarP3).a(fVarP2).m(fVarA, fVarP, fVarP3);
            f fVarK = fVar2.k(fVarP3);
            f fVarP4 = fVarK.a(fVarA).p();
            if (fVarP4.j()) {
                return fVarM.j() ? iVar.M() : eVarI.w();
            }
            if (fVarM.j()) {
                return new d(eVarI, fVarM, eVarI.q().o());
            }
            f fVarK2 = fVarM.p().k(fVarK);
            f fVarK3 = fVarM.k(fVarP4).k(fVarP3);
            return new d(eVarI, fVarK2, fVarM.a(fVarP4).p().m(fVarA, fVarB, fVarK3), new f[]{fVarK3});
        }

        @Override // ir.i
        public i a(i iVar) {
            f fVarK;
            f fVarK2;
            f fVarK3;
            f fVarA;
            f fVarN;
            f fVarA2;
            if (v()) {
                return iVar;
            }
            if (iVar.v()) {
                return this;
            }
            ir.e eVarI = i();
            int iS = eVarI.s();
            f fVarK4 = this.f35707b;
            f fVar = iVar.f35707b;
            if (iS == 0) {
                f fVar2 = this.f35708c;
                f fVar3 = iVar.f35708c;
                f fVarA3 = fVarK4.a(fVar);
                f fVarA4 = fVar2.a(fVar3);
                if (fVarA3.j()) {
                    return fVarA4.j() ? M() : eVarI.w();
                }
                f fVarD = fVarA4.d(fVarA3);
                f fVarA5 = fVarD.p().a(fVarD).a(fVarA3).a(eVarI.o());
                return new d(eVarI, fVarA5, fVarD.k(fVarK4.a(fVarA5)).a(fVarA5).a(fVar2));
            }
            if (iS == 1) {
                f fVar4 = this.f35708c;
                f fVarK5 = this.f35709d[0];
                f fVar5 = iVar.f35708c;
                f fVar6 = iVar.f35709d[0];
                boolean zI = fVar6.i();
                f fVarA6 = fVarK5.k(fVar5).a(zI ? fVar4 : fVar4.k(fVar6));
                f fVarA7 = fVarK5.k(fVar).a(zI ? fVarK4 : fVarK4.k(fVar6));
                if (fVarA7.j()) {
                    return fVarA6.j() ? M() : eVarI.w();
                }
                f fVarP = fVarA7.p();
                f fVarK6 = fVarP.k(fVarA7);
                if (!zI) {
                    fVarK5 = fVarK5.k(fVar6);
                }
                f fVarA8 = fVarA6.a(fVarA7);
                f fVarA9 = fVarA8.m(fVarA6, fVarP, eVarI.o()).k(fVarK5).a(fVarK6);
                f fVarK7 = fVarA7.k(fVarA9);
                if (!zI) {
                    fVarP = fVarP.k(fVar6);
                }
                return new d(eVarI, fVarK7, fVarA6.m(fVarK4, fVarA7, fVar4).m(fVarP, fVarA8, fVarA9), new f[]{fVarK6.k(fVarK5)});
            }
            if (iS != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            if (fVarK4.j()) {
                return fVar.j() ? eVarI.w() : iVar.a(this);
            }
            f fVar7 = this.f35708c;
            f fVar8 = this.f35709d[0];
            f fVar9 = iVar.f35708c;
            f fVar10 = iVar.f35709d[0];
            boolean zI2 = fVar8.i();
            if (zI2) {
                fVarK = fVar;
                fVarK2 = fVar9;
            } else {
                fVarK = fVar.k(fVar8);
                fVarK2 = fVar9.k(fVar8);
            }
            boolean zI3 = fVar10.i();
            if (zI3) {
                fVarK3 = fVar7;
            } else {
                fVarK4 = fVarK4.k(fVar10);
                fVarK3 = fVar7.k(fVar10);
            }
            f fVarA10 = fVarK3.a(fVarK2);
            f fVarA11 = fVarK4.a(fVarK);
            if (fVarA11.j()) {
                return fVarA10.j() ? M() : eVarI.w();
            }
            if (fVar.j()) {
                i iVarB = B();
                f fVarQ = iVarB.q();
                f fVarR = iVarB.r();
                f fVarD2 = fVarR.a(fVar9).d(fVarQ);
                fVarA = fVarD2.p().a(fVarD2).a(fVarQ).a(eVarI.o());
                if (fVarA.j()) {
                    return new d(eVarI, fVarA, eVarI.q().o());
                }
                fVarA2 = fVarD2.k(fVarQ.a(fVarA)).a(fVarA).a(fVarR).d(fVarA).a(fVarA);
                fVarN = eVarI.n(ir.d.f35647b);
            } else {
                f fVarP2 = fVarA11.p();
                f fVarK8 = fVarA10.k(fVarK4);
                f fVarK9 = fVarA10.k(fVarK);
                f fVarK10 = fVarK8.k(fVarK9);
                if (fVarK10.j()) {
                    return new d(eVarI, fVarK10, eVarI.q().o());
                }
                f fVarK11 = fVarA10.k(fVarP2);
                f fVarK12 = !zI3 ? fVarK11.k(fVar10) : fVarK11;
                f fVarR2 = fVarK9.a(fVarP2).r(fVarK12, fVar7.a(fVar8));
                if (!zI2) {
                    fVarK12 = fVarK12.k(fVar8);
                }
                fVarA = fVarK10;
                fVarN = fVarK12;
                fVarA2 = fVarR2;
            }
            return new d(eVarI, fVarA, fVarA2, new f[]{fVarN});
        }

        @Override // ir.i
        public i d() {
            return new d(null, f(), g());
        }

        @Override // ir.i
        public boolean h() {
            f fVarN = n();
            if (fVarN.j()) {
                return false;
            }
            f fVarO = o();
            int iJ = j();
            return (iJ == 5 || iJ == 6) ? fVarO.u() != fVarN.u() : fVarO.d(fVarN).u();
        }

        @Override // ir.i
        public f r() {
            int iJ = j();
            if (iJ != 5 && iJ != 6) {
                return this.f35708c;
            }
            f fVar = this.f35707b;
            f fVar2 = this.f35708c;
            if (v() || fVar.j()) {
                return fVar2;
            }
            f fVarK = fVar2.a(fVar).k(fVar);
            if (6 != iJ) {
                return fVarK;
            }
            f fVar3 = this.f35709d[0];
            return !fVar3.i() ? fVarK.d(fVar3) : fVarK;
        }
    }

    public static class e extends c {
        public e(ir.e eVar, f fVar, f fVar2) {
            super(eVar, fVar, fVar2);
        }

        public e(ir.e eVar, f fVar, f fVar2, f[] fVarArr) {
            super(eVar, fVar, fVar2, fVarArr);
        }

        @Override // ir.i
        public i A() {
            if (v()) {
                return this;
            }
            ir.e eVarI = i();
            return eVarI.s() != 0 ? new e(eVarI, this.f35707b, this.f35708c.n(), this.f35709d) : new e(eVarI, this.f35707b, this.f35708c.n());
        }

        @Override // ir.i
        public i K() {
            if (v()) {
                return this;
            }
            f fVar = this.f35708c;
            if (fVar.j()) {
                return this;
            }
            ir.e eVarI = i();
            int iS = eVarI.s();
            if (iS != 0) {
                return iS != 4 ? M().a(this) : U(false).a(this);
            }
            f fVar2 = this.f35707b;
            f fVarV = V(fVar);
            f fVarP = fVarV.p();
            f fVarA = T(fVar2.p()).a(i().o());
            f fVarT = T(fVar2).k(fVarP).t(fVarA.p());
            if (fVarT.j()) {
                return i().w();
            }
            f fVarH = fVarT.k(fVarV).h();
            f fVarK = fVarT.k(fVarH).k(fVarA);
            f fVarT2 = fVarP.p().k(fVarH).t(fVarK);
            f fVarA2 = fVarT2.t(fVarK).k(fVarK.a(fVarT2)).a(fVar2);
            return new e(eVarI, fVarA2, fVar2.t(fVarA2).k(fVarT2).t(fVar));
        }

        @Override // ir.i
        public i L(int i10) {
            f fVarP;
            if (i10 < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            }
            if (i10 == 0 || v()) {
                return this;
            }
            if (i10 == 1) {
                return M();
            }
            ir.e eVarI = i();
            f fVarT = this.f35708c;
            if (fVarT.j()) {
                return eVarI.w();
            }
            int iS = eVarI.s();
            f fVarO = eVarI.o();
            f fVarK = this.f35707b;
            f[] fVarArr = this.f35709d;
            f fVarN = fVarArr.length < 1 ? eVarI.n(ir.d.f35647b) : fVarArr[0];
            if (!fVarN.i() && iS != 0) {
                if (iS == 1) {
                    fVarP = fVarN.p();
                    fVarK = fVarK.k(fVarN);
                    fVarT = fVarT.k(fVarP);
                } else if (iS == 2) {
                    fVarP = null;
                } else {
                    if (iS != 4) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    fVarO = S();
                }
                fVarO = O(fVarN, fVarP);
            }
            int i11 = 0;
            while (i11 < i10) {
                if (fVarT.j()) {
                    return eVarI.w();
                }
                f fVarT2 = T(fVarK.p());
                f fVarV = V(fVarT);
                f fVarK2 = fVarV.k(fVarT);
                f fVarV2 = V(fVarK.k(fVarK2));
                f fVarV3 = V(fVarK2.p());
                if (!fVarO.j()) {
                    fVarT2 = fVarT2.a(fVarO);
                    fVarO = V(fVarV3.k(fVarO));
                }
                f fVarT3 = fVarT2.p().t(V(fVarV2));
                fVarT = fVarT2.k(fVarV2.t(fVarT3)).t(fVarV3);
                fVarN = fVarN.i() ? fVarV : fVarV.k(fVarN);
                i11++;
                fVarK = fVarT3;
            }
            if (iS == 0) {
                f fVarH = fVarN.h();
                f fVarP2 = fVarH.p();
                return new e(eVarI, fVarK.k(fVarP2), fVarT.k(fVarP2.k(fVarH)));
            }
            if (iS == 1) {
                return new e(eVarI, fVarK.k(fVarN), fVarT, new f[]{fVarN.k(fVarN.p())});
            }
            if (iS == 2) {
                return new e(eVarI, fVarK, fVarT, new f[]{fVarN});
            }
            if (iS == 4) {
                return new e(eVarI, fVarK, fVarT, new f[]{fVarN, fVarO});
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        @Override // ir.i
        public i M() {
            f fVarT;
            f fVarK;
            if (v()) {
                return this;
            }
            ir.e eVarI = i();
            f fVar = this.f35708c;
            if (fVar.j()) {
                return eVarI.w();
            }
            int iS = eVarI.s();
            f fVar2 = this.f35707b;
            if (iS == 0) {
                f fVarD = T(fVar2.p()).a(i().o()).d(V(fVar));
                f fVarT2 = fVarD.p().t(V(fVar2));
                return new e(eVarI, fVarT2, fVarD.k(fVar2.t(fVarT2)).t(fVar));
            }
            if (iS == 1) {
                f fVar3 = this.f35709d[0];
                boolean zI = fVar3.i();
                f fVarO = eVarI.o();
                if (!fVarO.j() && !zI) {
                    fVarO = fVarO.k(fVar3.p());
                }
                f fVarA = fVarO.a(T(fVar2.p()));
                f fVarK2 = zI ? fVar : fVar.k(fVar3);
                f fVarP = zI ? fVar.p() : fVarK2.k(fVar);
                f fVarR = R(fVar2.k(fVarP));
                f fVarT3 = fVarA.p().t(V(fVarR));
                f fVarV = V(fVarK2);
                f fVarK3 = fVarT3.k(fVarV);
                f fVarV2 = V(fVarP);
                return new e(eVarI, fVarK3, fVarR.t(fVarT3).k(fVarA).t(V(fVarV2.p())), new f[]{V(zI ? V(fVarV2) : fVarV.p()).k(fVarK2)});
            }
            if (iS != 2) {
                if (iS == 4) {
                    return U(true);
                }
                throw new IllegalStateException("unsupported coordinate system");
            }
            f fVar4 = this.f35709d[0];
            boolean zI2 = fVar4.i();
            f fVarP2 = fVar.p();
            f fVarP3 = fVarP2.p();
            f fVarO2 = eVarI.o();
            f fVarN = fVarO2.n();
            if (fVarN.v().equals(BigInteger.valueOf(3L))) {
                f fVarP4 = zI2 ? fVar4 : fVar4.p();
                fVarT = T(fVar2.a(fVarP4).k(fVar2.t(fVarP4)));
                fVarK = fVarP2.k(fVar2);
            } else {
                f fVarT4 = T(fVar2.p());
                if (zI2) {
                    fVarT = fVarT4.a(fVarO2);
                    fVarK = fVar2.k(fVarP2);
                } else {
                    if (fVarO2.j()) {
                        fVarT = fVarT4;
                    } else {
                        f fVarP5 = fVar4.p().p();
                        if (fVarN.c() < fVarO2.c()) {
                            fVarT = fVarT4.t(fVarP5.k(fVarN));
                        } else {
                            fVarO2 = fVarP5.k(fVarO2);
                            fVarT = fVarT4.a(fVarO2);
                        }
                    }
                    fVarK = fVar2.k(fVarP2);
                }
            }
            f fVarR2 = R(fVarK);
            f fVarT5 = fVarT.p().t(V(fVarR2));
            f fVarT6 = fVarR2.t(fVarT5).k(fVarT).t(Q(fVarP3));
            f fVarV3 = V(fVar);
            if (!zI2) {
                fVarV3 = fVarV3.k(fVar4);
            }
            return new e(eVarI, fVarT5, fVarT6, new f[]{fVarV3});
        }

        @Override // ir.i
        public i N(i iVar) {
            if (this == iVar) {
                return K();
            }
            if (v()) {
                return iVar;
            }
            if (iVar.v()) {
                return M();
            }
            f fVar = this.f35708c;
            if (fVar.j()) {
                return iVar;
            }
            ir.e eVarI = i();
            int iS = eVarI.s();
            if (iS != 0) {
                return iS != 4 ? M().a(iVar) : U(false).a(iVar);
            }
            f fVar2 = this.f35707b;
            f fVar3 = iVar.f35707b;
            f fVar4 = iVar.f35708c;
            f fVarT = fVar3.t(fVar2);
            f fVarT2 = fVar4.t(fVar);
            if (fVarT.j()) {
                return fVarT2.j() ? K() : this;
            }
            f fVarP = fVarT.p();
            f fVarT3 = fVarP.k(V(fVar2).a(fVar3)).t(fVarT2.p());
            if (fVarT3.j()) {
                return eVarI.w();
            }
            f fVarH = fVarT3.k(fVarT).h();
            f fVarK = fVarT3.k(fVarH).k(fVarT2);
            f fVarT4 = V(fVar).k(fVarP).k(fVarT).k(fVarH).t(fVarK);
            f fVarA = fVarT4.t(fVarK).k(fVarK.a(fVarT4)).a(fVar3);
            return new e(eVarI, fVarA, fVar2.t(fVarA).k(fVarT4).t(fVar));
        }

        public f O(f fVar, f fVar2) {
            f fVarO = i().o();
            if (fVarO.j() || fVar.i()) {
                return fVarO;
            }
            if (fVar2 == null) {
                fVar2 = fVar.p();
            }
            f fVarP = fVar2.p();
            f fVarN = fVarO.n();
            return fVarN.c() < fVarO.c() ? fVarP.k(fVarN).n() : fVarP.k(fVarO);
        }

        public f P(f fVar, f fVar2, f fVar3, f fVar4) {
            return fVar.a(fVar2).p().t(fVar3).t(fVar4);
        }

        public f Q(f fVar) {
            return R(V(fVar));
        }

        public f R(f fVar) {
            return V(V(fVar));
        }

        public f S() {
            f[] fVarArr = this.f35709d;
            f fVar = fVarArr[1];
            if (fVar != null) {
                return fVar;
            }
            f fVarO = O(fVarArr[0], null);
            fVarArr[1] = fVarO;
            return fVarO;
        }

        public f T(f fVar) {
            return V(fVar).a(fVar);
        }

        public e U(boolean z10) {
            f fVar = this.f35707b;
            f fVar2 = this.f35708c;
            f fVar3 = this.f35709d[0];
            f fVarS = S();
            f fVarA = T(fVar.p()).a(fVarS);
            f fVarV = V(fVar2);
            f fVarK = fVarV.k(fVar2);
            f fVarV2 = V(fVar.k(fVarK));
            f fVarT = fVarA.p().t(V(fVarV2));
            f fVarV3 = V(fVarK.p());
            f fVarT2 = fVarA.k(fVarV2.t(fVarT)).t(fVarV3);
            f fVarV4 = z10 ? V(fVarV3.k(fVarS)) : null;
            if (!fVar3.i()) {
                fVarV = fVarV.k(fVar3);
            }
            return new e(i(), fVarT, fVarT2, new f[]{fVarV, fVarV4});
        }

        public f V(f fVar) {
            return fVar.a(fVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:61:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0136  */
        @Override // ir.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.i a(ir.i r17) {
            /*
                Method dump skipped, instruction units count: 532
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.i.e.a(ir.i):ir.i");
        }

        @Override // ir.i
        public i d() {
            return new e(null, f(), g());
        }

        @Override // ir.i
        public f s(int i10) {
            return (i10 == 1 && 4 == j()) ? S() : super.s(i10);
        }
    }

    public i(ir.e eVar, f fVar, f fVar2) {
        this(eVar, fVar, fVar2, m(eVar));
    }

    public i(ir.e eVar, f fVar, f fVar2, f[] fVarArr) {
        this.f35710e = null;
        this.f35706a = eVar;
        this.f35707b = fVar;
        this.f35708c = fVar2;
        this.f35709d = fVarArr;
    }

    public static f[] m(ir.e eVar) {
        int iS = eVar == null ? 0 : eVar.s();
        if (iS == 0 || iS == 5) {
            return f35705f;
        }
        f fVarN = eVar.n(ir.d.f35647b);
        if (iS != 1 && iS != 2) {
            if (iS == 3) {
                return new f[]{fVarN, fVarN, fVarN};
            }
            if (iS == 4) {
                return new f[]{fVarN, eVar.o()};
            }
            if (iS != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new f[]{fVarN};
    }

    public abstract i A();

    public i B() {
        int iJ;
        if (v() || (iJ = j()) == 0 || iJ == 5) {
            return this;
        }
        f fVarS = s(0);
        if (fVarS.i()) {
            return this;
        }
        if (this.f35706a == null) {
            throw new IllegalStateException("Detached points must be in affine coordinates");
        }
        f fVarG = this.f35706a.G(org.bouncycastle.crypto.n.f());
        return C(fVarS.k(fVarG).h().k(fVarG));
    }

    public i C(f fVar) {
        int iJ = j();
        if (iJ != 1) {
            if (iJ == 2 || iJ == 3 || iJ == 4) {
                f fVarP = fVar.p();
                return c(fVarP, fVarP.k(fVar));
            }
            if (iJ != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return c(fVar, fVar);
    }

    public abstract boolean D();

    public boolean E() {
        BigInteger bigIntegerY;
        return ir.d.f35647b.equals(this.f35706a.r()) || (bigIntegerY = this.f35706a.y()) == null || ir.c.s(this, bigIntegerY).v();
    }

    public i F(f fVar) {
        return v() ? this : i().j(n().k(fVar), o(), p());
    }

    public i G(f fVar) {
        return v() ? this : i().j(n().k(fVar), o().n(), p());
    }

    public i H(f fVar) {
        return v() ? this : i().j(n(), o().k(fVar), p());
    }

    public i I(f fVar) {
        return v() ? this : i().j(n().n(), o().k(fVar), p());
    }

    public abstract i J(i iVar);

    public i K() {
        return N(this);
    }

    public i L(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
        i iVarM = this;
        while (true) {
            i10--;
            if (i10 < 0) {
                return iVarM;
            }
            iVarM = iVarM.M();
        }
    }

    public abstract i M();

    public i N(i iVar) {
        return M().a(iVar);
    }

    public abstract i a(i iVar);

    public void b() {
        if (!w()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public i c(f fVar, f fVar2) {
        return i().i(n().k(fVar), o().k(fVar2));
    }

    public abstract i d();

    public boolean e(i iVar) {
        i iVarB;
        if (iVar == null) {
            return false;
        }
        ir.e eVarI = i();
        ir.e eVarI2 = iVar.i();
        boolean z10 = eVarI == null;
        boolean z11 = eVarI2 == null;
        boolean zV = v();
        boolean zV2 = iVar.v();
        if (zV || zV2) {
            if (zV && zV2) {
                return z10 || z11 || eVarI.m(eVarI2);
            }
            return false;
        }
        if (z10 && z11) {
            iVarB = this;
        } else if (z10) {
            iVar = iVar.B();
            iVarB = this;
        } else if (z11) {
            iVarB = B();
        } else {
            if (!eVarI.m(eVarI2)) {
                return false;
            }
            i[] iVarArr = {this, eVarI.A(iVar)};
            eVarI.C(iVarArr);
            iVarB = iVarArr[0];
            iVar = iVarArr[1];
        }
        return iVarB.q().equals(iVar.q()) && iVarB.r().equals(iVar.r());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return e((i) obj);
        }
        return false;
    }

    public f f() {
        b();
        return q();
    }

    public f g() {
        b();
        return r();
    }

    public abstract boolean h();

    public int hashCode() {
        ir.e eVarI = i();
        int i10 = eVarI == null ? 0 : ~eVarI.hashCode();
        if (v()) {
            return i10;
        }
        i iVarB = B();
        return (i10 ^ (iVarB.q().hashCode() * 17)) ^ (iVarB.r().hashCode() * 257);
    }

    public ir.e i() {
        return this.f35706a;
    }

    public int j() {
        ir.e eVar = this.f35706a;
        if (eVar == null) {
            return 0;
        }
        return eVar.s();
    }

    public final i k() {
        return B().d();
    }

    public byte[] l(boolean z10) {
        if (v()) {
            return new byte[1];
        }
        i iVarB = B();
        byte[] bArrE = iVarB.q().e();
        if (z10) {
            byte[] bArr = new byte[bArrE.length + 1];
            bArr[0] = (byte) (iVarB.h() ? 3 : 2);
            System.arraycopy(bArrE, 0, bArr, 1, bArrE.length);
            return bArr;
        }
        byte[] bArrE2 = iVarB.r().e();
        byte[] bArr2 = new byte[bArrE.length + bArrE2.length + 1];
        bArr2[0] = 4;
        System.arraycopy(bArrE, 0, bArr2, 1, bArrE.length);
        System.arraycopy(bArrE2, 0, bArr2, bArrE.length + 1, bArrE2.length);
        return bArr2;
    }

    public final f n() {
        return this.f35707b;
    }

    public final f o() {
        return this.f35708c;
    }

    public final f[] p() {
        return this.f35709d;
    }

    public f q() {
        return this.f35707b;
    }

    public f r() {
        return this.f35708c;
    }

    public f s(int i10) {
        if (i10 >= 0) {
            f[] fVarArr = this.f35709d;
            if (i10 < fVarArr.length) {
                return fVarArr[i10];
            }
        }
        return null;
    }

    public f[] t() {
        f[] fVarArr = this.f35709d;
        int length = fVarArr.length;
        if (length == 0) {
            return f35705f;
        }
        f[] fVarArr2 = new f[length];
        System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
        return fVarArr2;
    }

    public String toString() {
        if (v()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(n());
        stringBuffer.append(',');
        stringBuffer.append(o());
        for (int i10 = 0; i10 < this.f35709d.length; i10++) {
            stringBuffer.append(',');
            stringBuffer.append(this.f35709d[i10]);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public boolean u(boolean z10, boolean z11) {
        if (v()) {
            return true;
        }
        return !((y) i().E(this, y.f35747d, new a(z10, z11))).b();
    }

    public boolean v() {
        if (this.f35707b != null && this.f35708c != null) {
            f[] fVarArr = this.f35709d;
            if (fVarArr.length <= 0 || !fVarArr[0].j()) {
                return false;
            }
        }
        return true;
    }

    public boolean w() {
        int iJ = j();
        return iJ == 0 || iJ == 5 || v() || this.f35709d[0].i();
    }

    public boolean x() {
        return u(false, true);
    }

    public boolean y() {
        return u(false, false);
    }

    public i z(BigInteger bigInteger) {
        return i().x().a(this, bigInteger);
    }
}
