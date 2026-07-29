package fp;

import java.math.BigInteger;
import np.d2;
import np.e2;
import np.f2;

/* JADX INFO: loaded from: classes5.dex */
public class m0 implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f28670h = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d2 f28671g;

    public static int d(int i10, int i11) {
        if (i10 >= 1536) {
            if (i11 <= 100) {
                return 3;
            }
            if (i11 <= 128) {
                return 4;
            }
            return 4 + (((i11 - 128) + 1) / 2);
        }
        if (i10 >= 1024) {
            if (i11 <= 100) {
                return 4;
            }
            if (i11 <= 112) {
                return 5;
            }
            return (((i11 - 112) + 1) / 2) + 5;
        }
        if (i10 < 512) {
            if (i11 <= 80) {
                return 40;
            }
            return 40 + (((i11 - 80) + 1) / 2);
        }
        if (i11 <= 80) {
            return 5;
        }
        if (i11 <= 100) {
            return 7;
        }
        return (((i11 - 100) + 1) / 2) + 7;
    }

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28671g = (d2) yVar;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        BigInteger bigIntegerC;
        BigInteger bigIntegerC2;
        BigInteger bigIntegerMultiply;
        BigInteger bigInteger;
        m0 m0Var = this;
        int iB = m0Var.f28671g.b();
        int i10 = (iB + 1) / 2;
        int i11 = iB - i10;
        int i12 = iB / 2;
        int i13 = i12 - 100;
        int i14 = iB / 3;
        if (i13 < i14) {
            i13 = i14;
        }
        int i15 = iB >> 2;
        BigInteger bigIntegerPow = BigInteger.valueOf(2L).pow(i12);
        BigInteger bigInteger2 = f28670h;
        BigInteger bigIntegerShiftLeft = bigInteger2.shiftLeft(iB - 1);
        BigInteger bigIntegerShiftLeft2 = bigInteger2.shiftLeft(i13);
        org.bouncycastle.crypto.c cVar = null;
        boolean z10 = false;
        while (!z10) {
            BigInteger bigIntegerD = m0Var.f28671g.d();
            do {
                bigIntegerC = m0Var.c(i10, bigIntegerD, bigIntegerShiftLeft);
                while (true) {
                    bigIntegerC2 = m0Var.c(i11, bigIntegerD, bigIntegerShiftLeft);
                    BigInteger bigIntegerAbs = bigIntegerC2.subtract(bigIntegerC).abs();
                    if (bigIntegerAbs.bitLength() >= i13 && bigIntegerAbs.compareTo(bigIntegerShiftLeft2) > 0) {
                        bigIntegerMultiply = bigIntegerC.multiply(bigIntegerC2);
                        if (bigIntegerMultiply.bitLength() == iB) {
                            break;
                        }
                        bigIntegerC = bigIntegerC.max(bigIntegerC2);
                    } else {
                        m0Var = this;
                        iB = iB;
                    }
                }
            } while (ir.b0.i(bigIntegerMultiply) < i15);
            if (bigIntegerC.compareTo(bigIntegerC2) < 0) {
                bigInteger = bigIntegerC;
                bigIntegerC = bigIntegerC2;
            } else {
                bigInteger = bigIntegerC2;
            }
            BigInteger bigInteger3 = f28670h;
            BigInteger bigIntegerSubtract = bigIntegerC.subtract(bigInteger3);
            BigInteger bigIntegerSubtract2 = bigInteger.subtract(bigInteger3);
            int i16 = iB;
            BigInteger bigIntegerModInverse = bigIntegerD.modInverse(bigIntegerSubtract.divide(bigIntegerSubtract.gcd(bigIntegerSubtract2)).multiply(bigIntegerSubtract2));
            if (bigIntegerModInverse.compareTo(bigIntegerPow) > 0) {
                cVar = new org.bouncycastle.crypto.c((np.c) new e2(false, bigIntegerMultiply, bigIntegerD), (np.c) new f2(bigIntegerMultiply, bigIntegerD, bigIntegerModInverse, bigIntegerC, bigInteger, bigIntegerModInverse.remainder(bigIntegerSubtract), bigIntegerModInverse.remainder(bigIntegerSubtract2), org.bouncycastle.util.b.n(bigIntegerC, bigInteger)));
                z10 = true;
            }
            m0Var = this;
            iB = i16;
        }
        return cVar;
    }

    public BigInteger c(int i10, BigInteger bigInteger, BigInteger bigInteger2) {
        for (int i11 = 0; i11 != i10 * 5; i11++) {
            BigInteger bigIntegerH = org.bouncycastle.util.b.h(i10, 1, this.f28671g.a());
            BigInteger bigIntegerMod = bigIntegerH.mod(bigInteger);
            BigInteger bigInteger3 = f28670h;
            if (!bigIntegerMod.equals(bigInteger3) && bigIntegerH.multiply(bigIntegerH).compareTo(bigInteger2) >= 0 && e(bigIntegerH) && bigInteger.gcd(bigIntegerH.subtract(bigInteger3)).equals(bigInteger3)) {
                return bigIntegerH;
            }
        }
        throw new IllegalStateException("unable to generate prime number for RSA key");
    }

    public boolean e(BigInteger bigInteger) {
        return !hr.a.e(bigInteger) && hr.a.l(bigInteger, this.f28671g.a(), d(bigInteger.bitLength(), this.f28671g.c()));
    }
}
