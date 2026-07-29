package ft;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static boolean a(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        if (bigIntegerArr.length != bigIntegerArr2.length) {
            return false;
        }
        int iCompareTo = 0;
        for (int i10 = 0; i10 < bigIntegerArr.length; i10++) {
            iCompareTo |= bigIntegerArr[i10].compareTo(bigIntegerArr2[i10]);
        }
        return iCompareTo == 0;
    }

    public static void b(BigInteger[] bigIntegerArr, BigInteger bigInteger) {
        for (int length = bigIntegerArr.length - 1; length >= 0; length--) {
            bigIntegerArr[length] = bigInteger;
        }
    }

    public static BigInteger[] c(BigInteger[] bigIntegerArr, int i10, int i11) {
        int i12 = i11 - i10;
        BigInteger[] bigIntegerArr2 = new BigInteger[i12];
        System.arraycopy(bigIntegerArr, i10, bigIntegerArr2, 0, i12);
        return bigIntegerArr2;
    }

    public static int[] d(BigInteger[] bigIntegerArr) {
        int[] iArr = new int[bigIntegerArr.length];
        for (int i10 = 0; i10 < bigIntegerArr.length; i10++) {
            iArr[i10] = bigIntegerArr[i10].intValue();
        }
        return iArr;
    }

    public static int[] e(int i10, BigInteger[] bigIntegerArr) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i10);
        int[] iArr = new int[bigIntegerArr.length];
        for (int i11 = 0; i11 < bigIntegerArr.length; i11++) {
            iArr[i11] = bigIntegerArr[i11].mod(bigIntegerValueOf).intValue();
        }
        return iArr;
    }

    public static byte[] f(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == 1 || (bigInteger.bitLength() & 7) != 0) {
            return byteArray;
        }
        int iBitLength = bigInteger.bitLength() >> 3;
        byte[] bArr = new byte[iBitLength];
        System.arraycopy(byteArray, 1, bArr, 0, iBitLength);
        return bArr;
    }
}
