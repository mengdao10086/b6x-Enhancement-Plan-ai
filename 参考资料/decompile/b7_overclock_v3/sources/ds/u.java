package ds;

import cs.h0;
import java.security.SecureRandom;
import np.n1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.l0;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes6.dex */
public class u extends h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f26505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f26506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n1 f26507d;

    public u(zn.b bVar, l0 l0Var, n1 n1Var) {
        super(bVar);
        this.f26506c = l0Var;
        this.f26507d = n1Var;
    }

    @Override // cs.w
    public cs.q b(zn.b bVar, byte[] bArr) throws OperatorException {
        this.f26506c.a(false, this.f26507d);
        try {
            return new cs.q(bVar, this.f26506c.c(bArr, 0, bArr.length));
        } catch (InvalidCipherTextException e10) {
            throw new OperatorException("unable to unwrap key: " + e10.getMessage(), e10);
        }
    }

    public u c(SecureRandom secureRandom) {
        this.f26505b = secureRandom;
        return this;
    }
}
