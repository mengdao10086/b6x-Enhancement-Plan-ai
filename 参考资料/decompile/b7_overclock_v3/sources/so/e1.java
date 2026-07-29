package so;

import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e1 implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f50159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.y f50160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.c1 f50161c;

    public e1(gm.y yVar, zn.c1 c1Var, gm.y yVar2) {
        this.f50161c = c1Var;
        this.f50159a = yVar;
        this.f50160b = yVar2;
    }

    @Override // so.w1
    public mm.o0 a(cs.q qVar) throws CMSException {
        mm.f0 f0Var = new mm.f0(b(this.f50161c));
        zn.b bVar = (t0.n(this.f50160b.L()) || this.f50160b.C(pn.s.f46838q6)) ? new zn.b(this.f50160b, gm.d2.f29657b) : t0.q(this.f50159a) ? new zn.b(this.f50160b, new qm.i(qm.a.f47458h)) : new zn.b(this.f50160b);
        zn.b bVar2 = new zn.b(this.f50159a, bVar);
        gm.f0 f0VarC = c(bVar2, bVar, qVar);
        byte[] bArrD = d(bVar2);
        return bArrD != null ? new mm.o0(new mm.c0(f0Var, new gm.f2(bArrD), bVar2, f0VarC)) : new mm.o0(new mm.c0(f0Var, null, bVar2, f0VarC));
    }

    public mm.h0 b(zn.c1 c1Var) {
        return new mm.h0(c1Var.x(), c1Var.C().H());
    }

    public abstract gm.f0 c(zn.b bVar, zn.b bVar2, cs.q qVar) throws CMSException;

    public abstract byte[] d(zn.b bVar) throws CMSException;
}
