package ap;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.g0;
import np.m0;
import np.w1;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes5.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m0 f8817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f8818b;

    @Override // ap.e
    public void a(org.bouncycastle.crypto.k kVar) {
        SecureRandom secureRandomF;
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            if (!(w1Var.a() instanceof m0)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
            }
            this.f8817a = (m0) w1Var.a();
            secureRandomF = w1Var.b();
        } else {
            if (!(kVar instanceof m0)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
            }
            this.f8817a = (m0) kVar;
            secureRandomF = n.f();
        }
        this.f8818b = secureRandomF;
    }

    @Override // ap.e
    public i b(ir.i iVar) {
        m0 m0Var = this.f8817a;
        if (m0Var == null) {
            throw new IllegalStateException("ECElGamalEncryptor not initialised");
        }
        g0 g0VarD = m0Var.d();
        BigInteger bigIntegerA = l.a(g0VarD.e(), this.f8818b);
        ir.i[] iVarArr = {c().a(g0VarD.b(), bigIntegerA), this.f8817a.e().z(bigIntegerA).a(ir.c.a(g0VarD.a(), iVar))};
        g0VarD.a().C(iVarArr);
        return new i(iVarArr[0], iVarArr[1]);
    }

    public ir.h c() {
        return new ir.k();
    }
}
