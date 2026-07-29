package to;

import fp.j0;
import gm.y;
import gm.z;
import np.n1;
import np.v1;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.crypto.c0;
import org.bouncycastle.crypto.l0;
import pn.q;
import so.s1;

/* JADX INFO: loaded from: classes5.dex */
public class k extends s1 {
    public k(y yVar, char[] cArr) {
        super(yVar, cArr);
    }

    @Override // so.s1
    public byte[] b(int i10, zn.b bVar, int i11) throws CMSException {
        q qVarX = q.x(bVar.A());
        byte[] bArrB = i10 == 0 ? c0.b(this.f50304a) : c0.c(this.f50304a);
        try {
            j0 j0Var = new j0(p.f(qVarX.A()));
            j0Var.j(bArrB, qVarX.B(), qVarX.y().intValue());
            return ((n1) j0Var.e(i11)).a();
        } catch (Exception e10) {
            throw new CMSException("exception creating derived key: " + e10.getMessage(), e10);
        }
    }

    @Override // so.s1
    public byte[] c(zn.b bVar, byte[] bArr, cs.q qVar) throws CMSException {
        byte[] bArrA = ((n1) o.a(qVar)).a();
        l0 l0VarC = p.c(bVar.x());
        l0VarC.a(true, new v1(new n1(bArr), z.I(bVar.A()).J()));
        return l0VarC.d(bArrA, 0, bArrA.length);
    }
}
