package fp;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class p implements org.bouncycastle.crypto.d, ir.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public np.g0 f28684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SecureRandom f28685h;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        np.i0 i0Var = (np.i0) yVar;
        this.f28685h = i0Var.a();
        this.f28684g = i0Var.c();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        BigInteger bigIntegerE = this.f28684g.e();
        int iBitLength = bigIntegerE.bitLength();
        int i10 = iBitLength >>> 2;
        while (true) {
            BigInteger bigIntegerF = org.bouncycastle.util.b.f(iBitLength, this.f28685h);
            if (bigIntegerF.compareTo(ir.d.f35647b) >= 0 && bigIntegerF.compareTo(bigIntegerE) < 0 && ir.b0.i(bigIntegerF) >= i10) {
                return new org.bouncycastle.crypto.c((np.c) new np.m0(c().a(this.f28684g.b(), bigIntegerF), this.f28684g), (np.c) new np.l0(bigIntegerF, this.f28684g));
            }
        }
    }

    public ir.h c() {
        return new ir.k();
    }
}
