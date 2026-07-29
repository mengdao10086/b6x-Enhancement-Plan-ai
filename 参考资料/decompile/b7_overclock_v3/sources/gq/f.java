package gq;

import co.l;
import gm.y;
import ir.i;
import np.k0;
import np.m0;
import xr.e1;
import xr.p;
import xr.q;
import xr.r;

/* JADX INFO: loaded from: classes5.dex */
public class f extends fq.e {
    public f(np.c cVar) {
        super(b((m0) cVar));
    }

    public f(e1 e1Var) {
        super(e1Var);
    }

    public static e1 b(m0 m0Var) {
        y yVarJ = ((k0) m0Var.d()).j();
        i iVarE = m0Var.e();
        if (yVarJ.C(rn.d.H)) {
            return new e1(0, q.y().f(iVarE.f().v(), iVarE.g().v()));
        }
        if (yVarJ.C(tn.b.f51379u)) {
            return new e1(1, q.y().f(iVarE.f().v(), iVarE.g().v()));
        }
        if (yVarJ.C(tn.b.f51383y)) {
            return new e1(3, r.y().f(iVarE.f().v(), iVarE.g().v()));
        }
        throw new IllegalArgumentException("unknown curve in public encryption key");
    }

    public np.c c() {
        y yVar;
        l lVarC;
        int iY = this.f28714a.y();
        if (iY != 0) {
            if (iY == 1) {
                yVar = tn.b.f51379u;
            } else {
                if (iY != 3) {
                    throw new IllegalStateException("unknown key type");
                }
                yVar = tn.b.f51383y;
            }
            lVarC = tn.a.i(yVar);
        } else {
            yVar = rn.d.H;
            lVarC = kn.c.c(yVar);
        }
        ir.e eVarY = lVarC.y();
        if (!(this.f28714a.z() instanceof p)) {
            throw new IllegalStateException("extension to public verification key not supported");
        }
        p pVar = (p) this.f28714a.z();
        if ((pVar instanceof q) || (pVar instanceof r)) {
            return new m0(eVarY.k(pVar.x()).B(), new k0(yVar, lVarC));
        }
        throw new IllegalStateException("unknown key type");
    }
}
