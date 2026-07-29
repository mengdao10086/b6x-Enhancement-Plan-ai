package ds;

import cs.i0;
import java.security.SecureRandom;
import np.n1;
import np.w1;
import org.bouncycastle.crypto.l0;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes6.dex */
public class v extends i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f26508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f26509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n1 f26510d;

    public v(zn.b bVar, l0 l0Var, n1 n1Var) {
        super(bVar);
        this.f26509c = l0Var;
        this.f26510d = n1Var;
    }

    @Override // cs.x
    public byte[] b(cs.q qVar) throws OperatorException {
        byte[] bArrA = x.a(qVar);
        SecureRandom secureRandom = this.f26508b;
        if (secureRandom == null) {
            this.f26509c.a(true, this.f26510d);
        } else {
            this.f26509c.a(true, new w1(this.f26510d, secureRandom));
        }
        return this.f26509c.d(bArrA, 0, bArrA.length);
    }

    public v c(SecureRandom secureRandom) {
        this.f26508b = secureRandom;
        return this;
    }
}
