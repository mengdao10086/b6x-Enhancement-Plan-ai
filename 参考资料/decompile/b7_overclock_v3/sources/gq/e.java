package gq;

import co.l;
import gm.y;
import ir.i;
import np.k0;
import np.m0;
import org.bouncycastle.its.ITSPublicEncryptionKey;
import xr.a2;
import xr.b;
import xr.d1;
import xr.p;
import xr.q;
import xr.r;

/* JADX INFO: loaded from: classes5.dex */
public class e extends ITSPublicEncryptionKey {
    public e(np.c cVar) {
        super(b((m0) cVar));
    }

    public e(d1 d1Var) {
        super(d1Var);
    }

    public static d1 b(m0 m0Var) {
        y yVarJ = ((k0) m0Var.d()).j();
        i iVarE = m0Var.e();
        if (yVarJ.C(rn.d.H)) {
            return new d1(a2.f55812e, new b.a().b(0).c(q.y().f(iVarE.f().v(), iVarE.g().v())).a());
        }
        if (yVarJ.C(tn.b.f51379u)) {
            return new d1(a2.f55812e, new b.a().b(1).c(q.y().f(iVarE.f().v(), iVarE.g().v())).a());
        }
        throw new IllegalArgumentException("unknown curve in public encryption key");
    }

    public np.c c() {
        y yVar;
        l lVarC;
        xr.b bVarX = this.f44854a.x();
        int iX = bVarX.x();
        if (iX == 0) {
            yVar = rn.d.H;
            lVarC = kn.c.c(yVar);
        } else {
            if (iX != 1) {
                throw new IllegalStateException("unknown key type");
            }
            yVar = tn.b.f51379u;
            lVarC = tn.a.i(yVar);
        }
        ir.e eVarY = lVarC.y();
        if (!(this.f44854a.x().z() instanceof p)) {
            throw new IllegalStateException("extension to public verification key not supported");
        }
        p pVar = (p) bVarX.z();
        if ((pVar instanceof q) || (pVar instanceof r)) {
            return new m0(eVarY.k(pVar.x()).B(), new k0(yVar, lVarC));
        }
        throw new IllegalStateException("unknown key type");
    }
}
