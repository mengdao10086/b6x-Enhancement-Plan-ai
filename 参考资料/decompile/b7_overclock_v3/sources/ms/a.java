package ms;

import ft.u;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f41595a = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f41596b = BigInteger.valueOf(1);

    public static byte[] a(int i10, int i11, ft.g gVar) {
        if (gVar.c() != i10 || gVar.k() != i11) {
            throw new IllegalArgumentException("vector has wrong length or hamming weight");
        }
        int[] iArrL = gVar.l();
        BigInteger bigIntegerA = u.a(i10, i11);
        BigInteger bigIntegerAdd = f41595a;
        int i12 = i10;
        for (int i13 = 0; i13 < i10; i13++) {
            bigIntegerA = bigIntegerA.multiply(BigInteger.valueOf(i12 - i11)).divide(BigInteger.valueOf(i12));
            i12--;
            if ((iArrL[i13 >> 5] & (1 << (i13 & 31))) != 0) {
                bigIntegerAdd = bigIntegerAdd.add(bigIntegerA);
                i11--;
                bigIntegerA = i12 == i11 ? f41596b : bigIntegerA.multiply(BigInteger.valueOf(i11 + 1)).divide(BigInteger.valueOf(i12 - i11));
            }
        }
        return ft.b.f(bigIntegerAdd);
    }

    public static ft.g b(int i10, int i11, byte[] bArr) {
        if (i10 < i11) {
            throw new IllegalArgumentException("n < t");
        }
        BigInteger bigIntegerA = u.a(i10, i11);
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(bigIntegerA) >= 0) {
            throw new IllegalArgumentException("Encoded number too large.");
        }
        ft.g gVar = new ft.g(i10);
        int i12 = i10;
        for (int i13 = 0; i13 < i10; i13++) {
            bigIntegerA = bigIntegerA.multiply(BigInteger.valueOf(i12 - i11)).divide(BigInteger.valueOf(i12));
            i12--;
            if (bigIntegerA.compareTo(bigInteger) <= 0) {
                gVar.m(i13);
                bigInteger = bigInteger.subtract(bigIntegerA);
                i11--;
                bigIntegerA = i12 == i11 ? f41596b : bigIntegerA.multiply(BigInteger.valueOf(i11 + 1)).divide(BigInteger.valueOf(i12 - i11));
            }
        }
        return gVar;
    }

    public static byte[] c(int i10, int i11, byte[] bArr) {
        if (i10 < i11) {
            throw new IllegalArgumentException("n < t");
        }
        BigInteger bigIntegerA = u.a(i10, i11);
        int iBitLength = bigIntegerA.bitLength() - 1;
        int i12 = iBitLength >> 3;
        int i13 = iBitLength & 7;
        int i14 = 8;
        if (i13 == 0) {
            i12--;
            i13 = 8;
        }
        int i15 = i10 >> 3;
        int i16 = i10 & 7;
        if (i16 == 0) {
            i15--;
        } else {
            i14 = i16;
        }
        int i17 = i15 + 1;
        byte[] bArr2 = new byte[i17];
        if (bArr.length < i17) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            for (int length = bArr.length; length < i17; length++) {
                bArr2[length] = 0;
            }
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, i15);
            bArr2[i15] = (byte) (bArr[i15] & ((1 << i14) - 1));
        }
        BigInteger bigIntegerAdd = f41595a;
        int i18 = i10;
        for (int i19 = 0; i19 < i10; i19++) {
            bigIntegerA = bigIntegerA.multiply(new BigInteger(Integer.toString(i18 - i11))).divide(new BigInteger(Integer.toString(i18)));
            i18--;
            if (((byte) (bArr2[i19 >>> 3] & (1 << (i19 & 7)))) != 0) {
                bigIntegerAdd = bigIntegerAdd.add(bigIntegerA);
                i11--;
                bigIntegerA = i18 == i11 ? f41596b : bigIntegerA.multiply(new BigInteger(Integer.toString(i11 + 1))).divide(new BigInteger(Integer.toString(i18 - i11)));
            }
        }
        int i20 = i12 + 1;
        byte[] bArr3 = new byte[i20];
        byte[] byteArray = bigIntegerAdd.toByteArray();
        if (byteArray.length < i20) {
            System.arraycopy(byteArray, 0, bArr3, 0, byteArray.length);
            for (int length2 = byteArray.length; length2 < i20; length2++) {
                bArr3[length2] = 0;
            }
        } else {
            System.arraycopy(byteArray, 0, bArr3, 0, i12);
            bArr3[i12] = (byte) (((1 << i13) - 1) & byteArray[i12]);
        }
        return bArr3;
    }
}
