package ap;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.g0;
import np.m0;
import np.w1;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes5.dex */
public class g implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m0 f8821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f8822b;

    @Override // ap.k
    public void a(org.bouncycastle.crypto.k kVar) {
        SecureRandom secureRandomF;
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            if (!(w1Var.a() instanceof m0)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for new public key transform.");
            }
            this.f8821a = (m0) w1Var.a();
            secureRandomF = w1Var.b();
        } else {
            if (!(kVar instanceof m0)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for new public key transform.");
            }
            this.f8821a = (m0) kVar;
            secureRandomF = n.f();
        }
        this.f8822b = secureRandomF;
    }

    @Override // ap.k
    public i c(i iVar) {
        m0 m0Var = this.f8821a;
        if (m0Var == null) {
            throw new IllegalStateException("ECNewPublicKeyTransform not initialised");
        }
        g0 g0VarD = m0Var.d();
        BigInteger bigIntegerE = g0VarD.e();
        ir.h hVarD = d();
        BigInteger bigIntegerA = l.a(bigIntegerE, this.f8822b);
        ir.i[] iVarArr = {hVarD.a(g0VarD.b(), bigIntegerA), this.f8821a.e().z(bigIntegerA).a(ir.c.a(g0VarD.a(), iVar.c()))};
        g0VarD.a().C(iVarArr);
        return new i(iVarArr[0], iVarArr[1]);
    }

    public ir.h d() {
        return new ir.k();
    }
}
