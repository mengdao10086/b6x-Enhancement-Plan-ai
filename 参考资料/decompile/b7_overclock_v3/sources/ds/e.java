package ds;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e extends cs.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public np.c f26473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f26474c;

    public e(zn.b bVar, np.c cVar) {
        super(bVar);
        this.f26473b = cVar;
    }

    @Override // cs.x
    public byte[] b(cs.q qVar) throws OperatorException {
        org.bouncycastle.crypto.b bVarC = c(a().x());
        org.bouncycastle.crypto.k w1Var = this.f26473b;
        SecureRandom secureRandom = this.f26474c;
        if (secureRandom != null) {
            w1Var = new w1(w1Var, secureRandom);
        }
        try {
            byte[] bArrA = x.a(qVar);
            bVarC.a(true, w1Var);
            return bVarC.c(bArrA, 0, bArrA.length);
        } catch (InvalidCipherTextException e10) {
            throw new OperatorException("unable to encrypt contents key", e10);
        }
    }

    public abstract org.bouncycastle.crypto.b c(gm.y yVar);

    public e d(SecureRandom secureRandom) {
        this.f26474c = secureRandom;
        return this;
    }
}
