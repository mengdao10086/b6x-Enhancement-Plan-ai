package qr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f47609a = new h(BigInteger.valueOf(2));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f47610b = new h(BigInteger.valueOf(3));

    public static g a(int[] iArr) {
        if (iArr[0] != 0) {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i10 = 1; i10 < iArr.length; i10++) {
            if (iArr[i10] <= iArr[i10 - 1]) {
                throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
            }
        }
        return new e(f47609a, new d(iArr));
    }

    public static b b(BigInteger bigInteger) {
        int iBitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || iBitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (iBitLength < 3) {
            int iIntValue = bigInteger.intValue();
            if (iIntValue == 2) {
                return f47609a;
            }
            if (iIntValue == 3) {
                return f47610b;
            }
        }
        return new h(bigInteger);
    }
}
