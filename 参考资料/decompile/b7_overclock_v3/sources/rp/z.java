package rp;

import gm.c0;
import gm.f0;
import gm.j2;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class z implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f49116a = new z();

    @Override // rp.b
    public BigInteger[] a(BigInteger bigInteger, byte[] bArr) throws IOException {
        f0 f0Var = (f0) c0.D(bArr);
        if (f0Var.size() == 2) {
            BigInteger bigIntegerD = d(bigInteger, f0Var, 0);
            BigInteger bigIntegerD2 = d(bigInteger, f0Var, 1);
            if (org.bouncycastle.util.a.g(b(bigInteger, bigIntegerD, bigIntegerD2), bArr)) {
                return new BigInteger[]{bigIntegerD, bigIntegerD2};
            }
        }
        throw new IllegalArgumentException("Malformed signature");
    }

    @Override // rp.b
    public byte[] b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) throws IOException {
        gm.i iVar = new gm.i();
        e(bigInteger, iVar, bigInteger2);
        e(bigInteger, iVar, bigInteger3);
        return new j2(iVar).v(gm.j.f29713a);
    }

    public BigInteger c(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.signum() < 0 || (bigInteger != null && bigInteger2.compareTo(bigInteger) >= 0)) {
            throw new IllegalArgumentException("Value out of range");
        }
        return bigInteger2;
    }

    public BigInteger d(BigInteger bigInteger, f0 f0Var, int i10) {
        return c(bigInteger, ((gm.t) f0Var.K(i10)).K());
    }

    public void e(BigInteger bigInteger, gm.i iVar, BigInteger bigInteger2) {
        iVar.a(new gm.t(c(bigInteger, bigInteger2)));
    }
}
