package fp;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class d implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f28623h = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public np.f f28624g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28624g = (np.f) yVar;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        np.h hVarC = this.f28624g.c();
        np.i iVarD = d(this.f28624g.a(), hVarC);
        np.j jVarC = c(hVarC, iVarD);
        iVarD.k(jVarC);
        return new org.bouncycastle.crypto.c((np.c) jVarC, (np.c) iVarD);
    }

    public final np.j c(np.h hVar, np.i iVar) {
        BigInteger bigIntegerA = hVar.a();
        BigInteger bigIntegerB = hVar.b();
        BigInteger bigIntegerD = hVar.d();
        return new np.j(hVar, bigIntegerA.modPow(iVar.f(), bigIntegerD).multiply(bigIntegerB.modPow(iVar.g(), bigIntegerD)), bigIntegerA.modPow(iVar.h(), bigIntegerD).multiply(bigIntegerB.modPow(iVar.i(), bigIntegerD)), bigIntegerA.modPow(iVar.j(), bigIntegerD));
    }

    public final np.i d(SecureRandom secureRandom, np.h hVar) {
        BigInteger bigIntegerD = hVar.d();
        return new np.i(hVar, e(bigIntegerD, secureRandom), e(bigIntegerD, secureRandom), e(bigIntegerD, secureRandom), e(bigIntegerD, secureRandom), e(bigIntegerD, secureRandom));
    }

    public final BigInteger e(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = f28623h;
        return org.bouncycastle.util.b.g(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }
}
