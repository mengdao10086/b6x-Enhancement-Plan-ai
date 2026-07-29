package nr;

import com.blankj.utilcode.util.ThreadUtils;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42619a = 32;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42620b = 32;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42621c = 486662;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42622d = 121666;

    /* JADX INFO: renamed from: nr.a$a, reason: collision with other inner class name */
    public static class C0480a extends nr.b {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f42623a = new b();
    }

    public static boolean a(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        h(bArr, i10, bArr2, i11, bArr3, i12);
        return !org.bouncycastle.util.a.e(bArr3, i12, 32);
    }

    public static int b(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 8);
        int i14 = i12 + 1;
        return (bArr[i14 + 1] << 24) | i13 | ((bArr[i14] & 255) << 16);
    }

    public static void c(byte[] bArr, int i10, int[] iArr) {
        for (int i11 = 0; i11 < 8; i11++) {
            iArr[i11] = b(bArr, (i11 * 4) + i10);
        }
        iArr[0] = iArr[0] & (-8);
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        iArr[7] = iArr[7] | 1073741824;
    }

    public static void d(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & ThreadUtils.f11619i);
        bArr[31] = (byte) (bArr[31] & 127);
        bArr[31] = (byte) (bArr[31] | 64);
    }

    public static void e(byte[] bArr, int i10, byte[] bArr2, int i11) {
        i(bArr, i10, bArr2, i11);
    }

    public static void f(int[] iArr, int[] iArr2) {
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        nr.b.d(iArr, iArr2, iArrK, iArrK2);
        nr.b.L(iArrK, iArrK);
        nr.b.L(iArrK2, iArrK2);
        nr.b.E(iArrK, iArrK2, iArr);
        nr.b.N(iArrK, iArrK2, iArrK);
        nr.b.D(iArrK, f42622d, iArr2);
        nr.b.a(iArr2, iArrK2, iArr2);
        nr.b.E(iArr2, iArrK, iArr2);
    }

    public static void g() {
        or.a.X();
    }

    public static void h(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        int[] iArr = new int[8];
        c(bArr, i10, iArr);
        int[] iArrK = nr.b.k();
        nr.b.n(bArr2, i11, iArrK);
        int[] iArrK2 = nr.b.k();
        nr.b.j(iArrK, 0, iArrK2, 0);
        int[] iArrK3 = nr.b.k();
        iArrK3[0] = 1;
        int[] iArrK4 = nr.b.k();
        iArrK4[0] = 1;
        int[] iArrK5 = nr.b.k();
        int[] iArrK6 = nr.b.k();
        int[] iArrK7 = nr.b.k();
        int i13 = 254;
        int i14 = 1;
        while (true) {
            nr.b.d(iArrK4, iArrK5, iArrK6, iArrK4);
            nr.b.d(iArrK2, iArrK3, iArrK5, iArrK2);
            nr.b.E(iArrK6, iArrK2, iArrK6);
            nr.b.E(iArrK4, iArrK5, iArrK4);
            nr.b.L(iArrK5, iArrK5);
            nr.b.L(iArrK2, iArrK2);
            nr.b.N(iArrK5, iArrK2, iArrK7);
            nr.b.D(iArrK7, f42622d, iArrK3);
            nr.b.a(iArrK3, iArrK2, iArrK3);
            nr.b.E(iArrK3, iArrK7, iArrK3);
            nr.b.E(iArrK2, iArrK5, iArrK2);
            nr.b.d(iArrK6, iArrK4, iArrK4, iArrK5);
            nr.b.L(iArrK4, iArrK4);
            nr.b.L(iArrK5, iArrK5);
            nr.b.E(iArrK5, iArrK, iArrK5);
            i13--;
            int i15 = (iArr[i13 >>> 5] >>> (i13 & 31)) & 1;
            int i16 = i14 ^ i15;
            nr.b.m(i16, iArrK2, iArrK4);
            nr.b.m(i16, iArrK3, iArrK5);
            if (i13 < 3) {
                break;
            } else {
                i14 = i15;
            }
        }
        for (int i17 = 0; i17 < 3; i17++) {
            f(iArrK2, iArrK3);
        }
        nr.b.x(iArrK3, iArrK3);
        nr.b.E(iArrK2, iArrK3, iArrK2);
        nr.b.G(iArrK2);
        nr.b.s(iArrK2, bArr3, i12);
    }

    public static void i(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArrK = nr.b.k();
        int[] iArrK2 = nr.b.k();
        or.a.d0(b.f42623a, bArr, i10, iArrK, iArrK2);
        nr.b.d(iArrK2, iArrK, iArrK, iArrK2);
        nr.b.x(iArrK2, iArrK2);
        nr.b.E(iArrK, iArrK2, iArrK);
        nr.b.G(iArrK);
        nr.b.s(iArrK, bArr2, i11);
    }
}
