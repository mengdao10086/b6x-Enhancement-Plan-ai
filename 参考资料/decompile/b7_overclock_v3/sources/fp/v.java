package fp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.b1;
import np.c1;
import np.d1;
import np.z0;

/* JADX INFO: loaded from: classes5.dex */
public class v implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z0 f28695g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28695g = (z0) yVar;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        b1 b1VarC = this.f28695g.c();
        SecureRandom secureRandomA = this.f28695g.a();
        BigInteger bigIntegerC = b1VarC.c();
        BigInteger bigIntegerB = b1VarC.b();
        BigInteger bigIntegerA = b1VarC.a();
        while (true) {
            BigInteger bigIntegerF = org.bouncycastle.util.b.f(256, secureRandomA);
            if (bigIntegerF.signum() >= 1 && bigIntegerF.compareTo(bigIntegerC) < 0 && ir.b0.i(bigIntegerF) >= 64) {
                return new org.bouncycastle.crypto.c((np.c) new d1(bigIntegerA.modPow(bigIntegerF, bigIntegerB), b1VarC), (np.c) new c1(bigIntegerF, b1VarC));
            }
        }
    }
}
