package so;

import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class j1 extends x1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mm.d0 f50204h;

    public j1(mm.d0 d0Var, zn.b bVar, i0 i0Var, a aVar) {
        h1 h1Var;
        super(d0Var.z(), bVar, i0Var, aVar);
        this.f50204h = d0Var;
        mm.n0 n0VarA = d0Var.A();
        boolean z10 = n0VarA.z();
        gm.h hVarX = n0VarA.x();
        if (z10) {
            h1Var = new h1(gm.z.I(hVarX).J());
        } else {
            mm.y yVarX = mm.y.x(hVarX);
            h1Var = new h1(yVarX.y(), yVarX.z().K());
        }
        this.f50340a = h1Var;
    }

    @Override // so.x1
    public z1 k(u1 u1Var) throws CMSException {
        return ((g1) u1Var).a(this.f50341b, this.f50342c, this.f50204h.x().J());
    }
}
