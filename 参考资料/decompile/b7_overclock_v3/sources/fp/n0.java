package fp;

import cp.f1;
import np.n1;

/* JADX INFO: loaded from: classes5.dex */
public class n0 {
    public static void a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i10) {
        System.arraycopy(iArr, iArr.length - 16, iArr2, 0, 16);
        int length = iArr.length >>> 1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = i10 * 2; i13 > 0; i13--) {
            h(iArr2, iArr, i11, iArr3);
            f1.r(8, iArr3, iArr2);
            System.arraycopy(iArr2, 0, iArr4, i12, 16);
            i12 = (length + i11) - i12;
            i11 += 16;
        }
    }

    public static void b(byte[] bArr) {
        if (bArr != null) {
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
        }
    }

    public static void c(int[] iArr) {
        if (iArr != null) {
            org.bouncycastle.util.a.h0(iArr, 0);
        }
    }

    public static void d(int[][] iArr) {
        for (int[] iArr2 : iArr) {
            c(iArr2);
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13) {
        int i14 = i11 * 128;
        byte[] bArrG = g(bArr, bArr2, i12 * i14);
        int[] iArr = null;
        try {
            int length = bArrG.length >>> 2;
            iArr = new int[length];
            org.bouncycastle.util.o.s(bArrG, 0, iArr);
            int i15 = 0;
            for (int i16 = i10 * i11; i10 - i15 > 2 && i16 > 1024; i16 >>>= 1) {
                i15++;
            }
            int i17 = i14 >>> 2;
            for (int i18 = 0; i18 < length; i18 += i17) {
                f(iArr, i18, i10, i15, i11);
            }
            org.bouncycastle.util.o.o(iArr, bArrG, 0);
            return g(bArr, bArrG, i13);
        } finally {
            b(bArrG);
            c(iArr);
        }
    }

    public static void f(int[] iArr, int i10, int i11, int i12, int i13) {
        int i14 = i11 >>> i12;
        int i15 = 1 << i12;
        int i16 = i14 - 1;
        int iB = org.bouncycastle.util.j.b(i11) - i12;
        int i17 = i13 * 32;
        int[] iArr2 = new int[16];
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[i17];
        int[] iArr5 = new int[i17];
        int[][] iArr6 = new int[i15][];
        try {
            System.arraycopy(iArr, i10, iArr5, 0, i17);
            int i18 = 0;
            while (i18 < i15) {
                int[] iArr7 = new int[i14 * i17];
                iArr6[i18] = iArr7;
                int i19 = i15;
                int i20 = 0;
                int i21 = 0;
                while (i21 < i14) {
                    System.arraycopy(iArr5, 0, iArr7, i20, i17);
                    int i22 = i20 + i17;
                    a(iArr5, iArr2, iArr3, iArr4, i13);
                    System.arraycopy(iArr4, 0, iArr7, i22, i17);
                    i20 = i22 + i17;
                    a(iArr4, iArr2, iArr3, iArr5, i13);
                    i21 += 2;
                    i14 = i14;
                }
                i18++;
                i15 = i19;
            }
            int i23 = i11 - 1;
            for (int i24 = 0; i24 < i11; i24++) {
                int i25 = iArr5[i17 - 16] & i23;
                System.arraycopy(iArr6[i25 >>> iB], (i25 & i16) * i17, iArr4, 0, i17);
                h(iArr4, iArr5, 0, iArr4);
                a(iArr4, iArr2, iArr3, iArr5, i13);
            }
            System.arraycopy(iArr5, 0, iArr, i10, i17);
            d(iArr6);
            d(new int[][]{iArr5, iArr2, iArr3, iArr4});
        } catch (Throwable th2) {
            d(iArr6);
            d(new int[][]{iArr5, iArr2, iArr3, iArr4});
            throw th2;
        }
    }

    public static byte[] g(byte[] bArr, byte[] bArr2, int i10) {
        j0 j0Var = new j0(new zo.e0());
        j0Var.j(bArr, bArr2, 1);
        return ((n1) j0Var.d(i10 * 8)).a();
    }

    public static void h(int[] iArr, int[] iArr2, int i10, int[] iArr3) {
        for (int length = iArr3.length - 1; length >= 0; length--) {
            iArr3[length] = iArr[length] ^ iArr2[i10 + length];
        }
    }

    public static byte[] i(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13) {
        if (bArr == null) {
            throw new IllegalArgumentException("Passphrase P must be provided.");
        }
        if (bArr2 == null) {
            throw new IllegalArgumentException("Salt S must be provided.");
        }
        if (i10 <= 1 || !j(i10)) {
            throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
        }
        if (i11 == 1 && i10 >= 65536) {
            throw new IllegalArgumentException("Cost parameter N must be > 1 and < 65536.");
        }
        if (i11 < 1) {
            throw new IllegalArgumentException("Block size r must be >= 1.");
        }
        int i14 = Integer.MAX_VALUE / ((i11 * 128) * 8);
        if (i12 >= 1 && i12 <= i14) {
            if (i13 >= 1) {
                return e(bArr, bArr2, i10, i11, i12, i13);
            }
            throw new IllegalArgumentException("Generated key length dkLen must be >= 1.");
        }
        throw new IllegalArgumentException("Parallelisation parameter p must be >= 1 and <= " + i14 + " (based on block size r of " + i11 + ee.a.f26979d);
    }

    public static boolean j(int i10) {
        return (i10 & (i10 + (-1))) == 0;
    }
}
