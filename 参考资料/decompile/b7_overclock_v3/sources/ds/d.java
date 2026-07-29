package ds;

import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d extends cs.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public np.c f26472b;

    public d(zn.b bVar, np.c cVar) {
        super(bVar);
        this.f26472b = cVar;
    }

    @Override // cs.w
    public cs.q b(zn.b bVar, byte[] bArr) throws OperatorException {
        org.bouncycastle.crypto.b bVarC = c(a().x());
        bVarC.a(false, this.f26472b);
        try {
            byte[] bArrC = bVarC.c(bArr, 0, bArr.length);
            return bVar.x().C(pn.s.Z3) ? new cs.q(bVar, bArrC) : new cs.q(bVar, bArrC);
        } catch (InvalidCipherTextException e10) {
            throw new OperatorException("unable to recover secret key: " + e10.getMessage(), e10);
        }
    }

    public abstract org.bouncycastle.crypto.b c(gm.y yVar);
}
