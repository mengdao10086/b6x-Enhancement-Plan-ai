package np;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class s extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f42530d = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f42531e = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42532c;

    public s(BigInteger bigInteger, q qVar) {
        super(false, qVar);
        this.f42532c = g(bigInteger, qVar);
    }

    public static int f(BigInteger bigInteger, BigInteger bigInteger2) {
        int iBitLength = bigInteger2.bitLength();
        int[] iArrT = rr.o.T(iBitLength, bigInteger);
        int[] iArrT2 = rr.o.T(iBitLength, bigInteger2);
        int length = iArrT2.length;
        int i10 = 0;
        while (true) {
            if (iArrT[0] == 0) {
                rr.o.y0(length, iArrT, 0);
            } else {
                int iB = org.bouncycastle.util.j.b(iArrT[0]);
                if (iB > 0) {
                    rr.o.u0(length, iArrT, iB, 0);
                    int i11 = iArrT2[0];
                    i10 ^= (iB << 1) & (i11 ^ (i11 >>> 1));
                }
                int iW = rr.o.w(length, iArrT, iArrT2);
                if (iW == 0) {
                    break;
                }
                if (iW < 0) {
                    i10 ^= iArrT[0] & iArrT2[0];
                    int[] iArr = iArrT2;
                    iArrT2 = iArrT;
                    iArrT = iArr;
                }
                while (true) {
                    int i12 = length - 1;
                    if (iArrT[i12] != 0) {
                        break;
                    }
                    length = i12;
                }
                rr.o.P0(length, iArrT, iArrT2, iArrT);
            }
        }
        if (rr.o.c0(length, iArrT2)) {
            return 1 - (i10 & 2);
        }
        return 0;
    }

    public BigInteger e() {
        return this.f42532c;
    }

    @Override // np.n
    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).e().equals(this.f42532c) && super.equals(obj);
    }

    public final BigInteger g(BigInteger bigInteger, q qVar) {
        Objects.requireNonNull(bigInteger, "y value cannot be null");
        BigInteger bigIntegerF = qVar.f();
        BigInteger bigInteger2 = f42531e;
        if (bigInteger.compareTo(bigInteger2) < 0 || bigInteger.compareTo(bigIntegerF.subtract(bigInteger2)) > 0) {
            throw new IllegalArgumentException("invalid DH public key");
        }
        BigInteger bigIntegerG = qVar.g();
        if (bigIntegerG == null) {
            return bigInteger;
        }
        if (bigIntegerF.testBit(0) && bigIntegerF.bitLength() - 1 == bigIntegerG.bitLength() && bigIntegerF.shiftRight(1).equals(bigIntegerG)) {
            if (1 == f(bigInteger, bigIntegerF)) {
                return bigInteger;
            }
        } else if (f42530d.equals(bigInteger.modPow(bigIntegerG, bigIntegerF))) {
            return bigInteger;
        }
        throw new IllegalArgumentException("Y value does not appear to be in correct group");
    }

    @Override // np.n
    public int hashCode() {
        return this.f42532c.hashCode() ^ super.hashCode();
    }
}
