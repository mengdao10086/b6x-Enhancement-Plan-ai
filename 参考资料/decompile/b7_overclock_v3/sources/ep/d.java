package ep;

import java.math.BigInteger;
import kotlin.v1;
import org.bouncycastle.crypto.f;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27087a = "org.bouncycastle.fpe.disable";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27088b = "org.bouncycastle.fpe.disable_ff1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f27089c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final double f27090d = Math.log(2.0d);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final double f27091e = Math.pow(2.0d, 96.0d);

    public static byte[] A(f fVar, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        return K(m(fVar, i10, bArr, i12, i13, i14, L(bArr2, i11, i14), L(bArr2, i11 + i14, i13)));
    }

    public static short[] B(f fVar, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        short[] sArr2 = new short[i14];
        short[] sArr3 = new short[i13];
        System.arraycopy(sArr, i11, sArr2, 0, i14);
        System.arraycopy(sArr, i11 + i14, sArr3, 0, i13);
        return m(fVar, i10, bArr, i12, i13, i14, sArr2, sArr3);
    }

    public static byte[] C(f fVar, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        return K(t(fVar, i10, bArr, i12, i13, i14, L(bArr2, i11, i14), L(bArr2, i11 + i14, i13)));
    }

    public static short[] D(f fVar, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        short[] sArr2 = new short[i14];
        short[] sArr3 = new short[i13];
        System.arraycopy(sArr, i11, sArr2, 0, i14);
        System.arraycopy(sArr, i11 + i14, sArr3, 0, i13);
        return t(fVar, i10, bArr, i12, i13, i14, sArr2, sArr3);
    }

    public static BigInteger E(BigInteger bigInteger, short[] sArr) {
        BigInteger bigIntegerAdd = org.bouncycastle.util.b.f46032a;
        for (short s10 : sArr) {
            bigIntegerAdd = bigIntegerAdd.multiply(bigInteger).add(BigInteger.valueOf(s10 & v1.f38215d));
        }
        return bigIntegerAdd;
    }

    public static BigInteger F(byte[] bArr, int i10, int i11) {
        return new BigInteger(1, org.bouncycastle.util.a.W(bArr, i10, i11 + i10));
    }

    public static byte[] G(f fVar, byte[] bArr) {
        if (bArr.length % 16 != 0) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length / 16;
        byte[] bArr2 = new byte[16];
        for (int i10 = 0; i10 < length; i10++) {
            M(bArr, i10 * 16, bArr2, 0, 16);
            fVar.d(bArr2, 0, bArr2, 0);
        }
        return bArr2;
    }

    public static void H(byte[] bArr) {
        int length = bArr.length / 2;
        int length2 = bArr.length - 1;
        for (int i10 = 0; i10 < length; i10++) {
            byte b10 = bArr[i10];
            int i11 = length2 - i10;
            bArr[i10] = bArr[i11];
            bArr[i11] = b10;
        }
    }

    public static void I(short[] sArr) {
        int length = sArr.length / 2;
        int length2 = sArr.length - 1;
        for (int i10 = 0; i10 < length; i10++) {
            short s10 = sArr[i10];
            int i11 = length2 - i10;
            sArr[i10] = sArr[i11];
            sArr[i11] = s10;
        }
    }

    public static void J(BigInteger bigInteger, BigInteger bigInteger2, int i10, short[] sArr, int i11) {
        if (bigInteger2.signum() < 0) {
            throw new IllegalArgumentException();
        }
        for (int i12 = 1; i12 <= i10; i12++) {
            BigInteger[] bigIntegerArrDivideAndRemainder = bigInteger2.divideAndRemainder(bigInteger);
            sArr[(i11 + i10) - i12] = (short) bigIntegerArrDivideAndRemainder[1].intValue();
            bigInteger2 = bigIntegerArrDivideAndRemainder[0];
        }
        if (bigInteger2.signum() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static byte[] K(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr[i10] = (byte) sArr[i10];
        }
        return bArr;
    }

    public static short[] L(byte[] bArr, int i10, int i11) {
        short[] sArr = new short[i11];
        for (int i12 = 0; i12 != i11; i12++) {
            sArr[i12] = (short) (bArr[i10 + i12] & 255);
        }
        return sArr;
    }

    public static void M(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i11 + i13;
            bArr2[i14] = (byte) (bArr2[i14] ^ bArr[i10 + i13]);
        }
    }

    public static BigInteger[] a(BigInteger bigInteger, int i10, int i11) {
        BigInteger[] bigIntegerArr = new BigInteger[2];
        bigIntegerArr[0] = bigInteger.pow(i10);
        bigIntegerArr[1] = bigIntegerArr[0];
        if (i11 != i10) {
            bigIntegerArr[1] = bigIntegerArr[1].multiply(bigInteger);
        }
        return bigIntegerArr;
    }

    public static byte[] b(int i10, byte b10, int i11, int i12) {
        byte[] bArr = {1, 2, 1, 0, (byte) (i10 >> 8), (byte) i10, 10, b10, 0, 0, 0, 0, 0, 0, 0, 0};
        o.h(i11, bArr, 8);
        o.h(i12, bArr, 12);
        return bArr;
    }

    public static byte[] c(byte[] bArr) {
        return new byte[]{bArr[0], bArr[1], bArr[2], (byte) (bArr[3] & 240), bArr[4], bArr[5], bArr[6], (byte) (bArr[3] << 4)};
    }

    public static BigInteger d(f fVar, BigInteger bigInteger, byte[] bArr, int i10, int i11, int i12, byte[] bArr2, short[] sArr) {
        int length = bArr.length;
        byte[] bArrC = org.bouncycastle.util.b.c(E(bigInteger, sArr));
        int i13 = ((-(length + i10 + 1)) & 15) + length;
        int i14 = i13 + 1 + i10;
        byte[] bArr3 = new byte[i14];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        bArr3[i13] = (byte) i12;
        System.arraycopy(bArrC, 0, bArr3, i14 - bArrC.length, bArrC.length);
        byte[] bArrG = G(fVar, org.bouncycastle.util.a.B(bArr2, bArr3));
        if (i11 > 16) {
            int i15 = ((i11 + 16) - 1) / 16;
            byte[] bArr4 = new byte[i15 * 16];
            System.arraycopy(bArrG, 0, bArr4, 0, 16);
            byte[] bArr5 = new byte[4];
            for (int i16 = 1; i16 < i15; i16++) {
                int i17 = i16 * 16;
                System.arraycopy(bArrG, 0, bArr4, i17, 16);
                o.h(i16, bArr5, 0);
                M(bArr5, 0, bArr4, (i17 + 16) - 4, 4);
                fVar.d(bArr4, i17, bArr4, i17);
            }
            bArrG = bArr4;
        }
        return F(bArrG, 0, i11);
    }

    public static BigInteger e(f fVar, BigInteger bigInteger, byte[] bArr, int i10, int i11, short[] sArr) {
        byte[] bArr2 = new byte[16];
        o.h(i11, bArr2, 0);
        M(bArr, i10, bArr2, 0, 4);
        byte[] bArrC = org.bouncycastle.util.b.c(E(bigInteger, sArr));
        if (16 - bArrC.length < 4) {
            throw new IllegalStateException("input out of range");
        }
        System.arraycopy(bArrC, 0, bArr2, 16 - bArrC.length, bArrC.length);
        H(bArr2);
        fVar.d(bArr2, 0, bArr2, 0);
        H(bArr2);
        return F(bArr2, 0, 16);
    }

    public static void f(f fVar, boolean z10, int i10, byte[] bArr, int i11, int i12) {
        h(fVar);
        if (i10 < 2 || i10 > 256) {
            throw new IllegalArgumentException();
        }
        i(z10, i10, bArr, i11, i12);
    }

    public static void g(f fVar, boolean z10, int i10, short[] sArr, int i11, int i12) {
        h(fVar);
        if (i10 < 2 || i10 > 65536) {
            throw new IllegalArgumentException();
        }
        j(z10, i10, sArr, i11, i12);
    }

    public static void h(f fVar) {
        if (16 != fVar.c()) {
            throw new IllegalArgumentException();
        }
    }

    public static void i(boolean z10, int i10, byte[] bArr, int i11, int i12) {
        k(z10, i10, i12);
        for (int i13 = 0; i13 < i12; i13++) {
            if ((bArr[i11 + i13] & 255) >= i10) {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }

    public static void j(boolean z10, int i10, short[] sArr, int i11, int i12) {
        k(z10, i10, i12);
        for (int i13 = 0; i13 < i12; i13++) {
            if ((sArr[i11 + i13] & v1.f38215d) >= i10) {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }

    public static void k(boolean z10, int i10, int i11) {
        int iFloor;
        if (i11 >= 2) {
            double d10 = i10;
            if (Math.pow(d10, i11) >= 1000000.0d) {
                if (z10 || i11 <= (iFloor = ((int) Math.floor(Math.log(f27091e) / Math.log(d10))) * 2)) {
                    return;
                }
                throw new IllegalArgumentException("maximum input length is " + iFloor);
            }
        }
        throw new IllegalArgumentException("input too short");
    }

    public static short[] l(f fVar, int i10, byte[] bArr, int i11, int i12, int i13, short[] sArr, short[] sArr2) {
        int length = bArr.length;
        int iCeil = (((int) Math.ceil((Math.log(i10) * ((double) i13)) / f27090d)) + 7) / 8;
        int i14 = (((iCeil + 3) / 4) * 4) + 4;
        byte[] bArrB = b(i10, (byte) i12, i11, length);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i10);
        BigInteger[] bigIntegerArrA = a(bigIntegerValueOf, i12, i13);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i15 = i12;
        int i16 = 9;
        while (i16 >= 0) {
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            i15 = i11 - i15;
            J(bigIntegerValueOf, E(bigIntegerValueOf, sArr5).subtract(d(fVar, bigIntegerValueOf, bArr, iCeil, i14, i16, bArrB, sArr4)).mod(bigIntegerArrA[i16 & 1]), i15, sArr5, 0);
            i16--;
            sArr3 = sArr5;
        }
        return org.bouncycastle.util.a.G(sArr3, sArr4);
    }

    public static short[] m(f fVar, int i10, byte[] bArr, int i11, int i12, int i13, short[] sArr, short[] sArr2) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i10);
        int i14 = i13;
        BigInteger[] bigIntegerArrA = a(bigIntegerValueOf, i12, i14);
        I(sArr);
        I(sArr2);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i15 = 7;
        while (i15 >= 0) {
            int i16 = i11 - i14;
            int i17 = i15 & 1;
            J(bigIntegerValueOf, E(bigIntegerValueOf, sArr4).subtract(e(fVar, bigIntegerValueOf, bArr, 4 - (i17 * 4), i15, sArr3)).mod(bigIntegerArrA[1 - i17]), i16, sArr4, 0);
            i15--;
            i14 = i16;
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            sArr3 = sArr5;
        }
        I(sArr3);
        I(sArr4);
        return org.bouncycastle.util.a.G(sArr3, sArr4);
    }

    public static byte[] n(f fVar, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        f(fVar, true, i10, bArr2, i11, i12);
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        return K(l(fVar, i10, bArr, i12, i13, i14, L(bArr2, i11, i13), L(bArr2, i11 + i13, i14)));
    }

    public static short[] o(f fVar, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        g(fVar, true, i10, sArr, i11, i12);
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        short[] sArr2 = new short[i13];
        short[] sArr3 = new short[i14];
        System.arraycopy(sArr, i11, sArr2, 0, i13);
        System.arraycopy(sArr, i11 + i13, sArr3, 0, i14);
        return l(fVar, i10, bArr, i12, i13, i14, sArr2, sArr3);
    }

    public static byte[] p(f fVar, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        f(fVar, false, i10, bArr2, i11, i12);
        if (bArr.length == 8) {
            return A(fVar, i10, bArr, bArr2, i11, i12);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] q(f fVar, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        f(fVar, false, i10, bArr2, i11, i12);
        if (bArr.length == 7) {
            return A(fVar, i10, c(bArr), bArr2, i11, i12);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] r(f fVar, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        g(fVar, false, i10, sArr, i11, i12);
        if (bArr.length == 7) {
            return B(fVar, i10, c(bArr), sArr, i11, i12);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] s(f fVar, int i10, byte[] bArr, int i11, int i12, int i13, short[] sArr, short[] sArr2) {
        int length = bArr.length;
        int iCeil = (((int) Math.ceil((Math.log(i10) * ((double) i13)) / f27090d)) + 7) / 8;
        int i14 = (((iCeil + 3) / 4) * 4) + 4;
        byte[] bArrB = b(i10, (byte) i12, i11, length);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i10);
        BigInteger[] bigIntegerArrA = a(bigIntegerValueOf, i12, i13);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i15 = i13;
        int i16 = 0;
        while (i16 < 10) {
            int i17 = i16;
            short[] sArr5 = sArr3;
            sArr3 = sArr4;
            int i18 = i11 - i15;
            J(bigIntegerValueOf, E(bigIntegerValueOf, sArr5).add(d(fVar, bigIntegerValueOf, bArr, iCeil, i14, i16, bArrB, sArr3)).mod(bigIntegerArrA[i17 & 1]), i18, sArr5, 0);
            i16 = i17 + 1;
            i15 = i18;
            sArr4 = sArr5;
        }
        return org.bouncycastle.util.a.G(sArr3, sArr4);
    }

    public static short[] t(f fVar, int i10, byte[] bArr, int i11, int i12, int i13, short[] sArr, short[] sArr2) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i10);
        int i14 = i12;
        BigInteger[] bigIntegerArrA = a(bigIntegerValueOf, i14, i13);
        I(sArr);
        I(sArr2);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i15 = 0;
        while (i15 < 8) {
            i14 = i11 - i14;
            int i16 = i15 & 1;
            J(bigIntegerValueOf, E(bigIntegerValueOf, sArr3).add(e(fVar, bigIntegerValueOf, bArr, 4 - (i16 * 4), i15, sArr4)).mod(bigIntegerArrA[1 - i16]), i14, sArr3, 0);
            i15++;
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            sArr3 = sArr5;
        }
        I(sArr3);
        I(sArr4);
        return org.bouncycastle.util.a.G(sArr3, sArr4);
    }

    public static byte[] u(f fVar, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        f(fVar, true, i10, bArr2, i11, i12);
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        return K(s(fVar, i10, bArr, i12, i13, i14, L(bArr2, i11, i13), L(bArr2, i11 + i13, i14)));
    }

    public static short[] v(f fVar, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        g(fVar, true, i10, sArr, i11, i12);
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        short[] sArr2 = new short[i13];
        short[] sArr3 = new short[i14];
        System.arraycopy(sArr, i11, sArr2, 0, i13);
        System.arraycopy(sArr, i11 + i13, sArr3, 0, i14);
        return s(fVar, i10, bArr, i12, i13, i14, sArr2, sArr3);
    }

    public static byte[] w(f fVar, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        f(fVar, false, i10, bArr2, i11, i12);
        if (bArr.length == 8) {
            return C(fVar, i10, bArr, bArr2, i11, i12);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] x(f fVar, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        f(fVar, false, i10, bArr2, i11, i12);
        if (bArr.length == 7) {
            return w(fVar, i10, c(bArr), bArr2, i11, i12);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] y(f fVar, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        g(fVar, false, i10, sArr, i11, i12);
        if (bArr.length == 7) {
            return z(fVar, i10, c(bArr), sArr, i11, i12);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] z(f fVar, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        g(fVar, false, i10, sArr, i11, i12);
        if (bArr.length == 8) {
            return D(fVar, i10, bArr, sArr, i11, i12);
        }
        throw new IllegalArgumentException();
    }
}
