package rr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class j {
    public static void a(long[] jArr, int i10, long[] jArr2, int i11) {
        jArr2[i11 + 0] = jArr[i10 + 0];
        jArr2[i11 + 1] = jArr[i10 + 1];
        jArr2[i11 + 2] = jArr[i10 + 2];
        jArr2[i11 + 3] = jArr[i10 + 3];
        jArr2[i11 + 4] = jArr[i10 + 4];
    }

    public static void b(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
    }

    public static long[] c() {
        return new long[5];
    }

    public static long[] d() {
        return new long[10];
    }

    public static boolean e(long[] jArr, long[] jArr2) {
        for (int i10 = 4; i10 >= 0; i10--) {
            if (jArr[i10] != jArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static long[] f(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 320) {
            throw new IllegalArgumentException();
        }
        long[] jArrC = c();
        for (int i10 = 0; i10 < 5; i10++) {
            jArrC[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArrC;
    }

    public static boolean g(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 5; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(long[] jArr) {
        for (int i10 = 0; i10 < 5; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static BigInteger i(long[] jArr) {
        byte[] bArr = new byte[40];
        for (int i10 = 0; i10 < 5; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                org.bouncycastle.util.o.z(j10, bArr, (4 - i10) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }
}
