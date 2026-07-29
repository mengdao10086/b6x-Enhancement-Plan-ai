package lr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f40142a = 140737488355327L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f40143b = 1152921504606846975L;

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    public static void c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static void d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
    }

    public static long[] e(BigInteger bigInteger) {
        return rr.o.U(239, bigInteger);
    }

    public static void f(long[] jArr, long[] jArr2) {
        long[] jArrO = rr.i.o();
        rr.i.k(jArr, jArr2);
        for (int i10 = 1; i10 < 239; i10 += 2) {
            k(jArr2, jArrO);
            o(jArrO, jArr2);
            k(jArr2, jArrO);
            o(jArrO, jArr2);
            d(jArr, jArr2);
        }
    }

    public static void g(long[] jArr) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        long j17 = jArr[7];
        jArr[0] = j10 ^ (j11 << 60);
        jArr[1] = (j11 >>> 4) ^ (j12 << 56);
        jArr[2] = (j12 >>> 8) ^ (j13 << 52);
        jArr[3] = (j13 >>> 12) ^ (j14 << 48);
        jArr[4] = (j14 >>> 16) ^ (j15 << 44);
        jArr[5] = (j15 >>> 20) ^ (j16 << 40);
        jArr[6] = (j16 >>> 24) ^ (j17 << 36);
        jArr[7] = j17 >>> 28;
    }

    public static void h(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        jArr2[0] = j10 & 1152921504606846975L;
        jArr2[1] = ((j10 >>> 60) ^ (j11 << 4)) & 1152921504606846975L;
        jArr2[2] = ((j11 >>> 56) ^ (j12 << 8)) & 1152921504606846975L;
        jArr2[3] = (j12 >>> 52) ^ (j13 << 12);
    }

    public static void i(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        h(jArr, jArr4);
        h(jArr2, jArr5);
        long[] jArr6 = new long[8];
        j(jArr6, jArr4[0], jArr5[0], jArr3, 0);
        j(jArr6, jArr4[1], jArr5[1], jArr3, 1);
        j(jArr6, jArr4[2], jArr5[2], jArr3, 2);
        j(jArr6, jArr4[3], jArr5[3], jArr3, 3);
        for (int i10 = 5; i10 > 0; i10--) {
            jArr3[i10] = jArr3[i10] ^ jArr3[i10 - 1];
        }
        j(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        j(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i11 = 7; i11 > 1; i11--) {
            jArr3[i11] = jArr3[i11] ^ jArr3[i11 - 2];
        }
        long j10 = jArr4[0] ^ jArr4[2];
        long j11 = jArr4[1] ^ jArr4[3];
        long j12 = jArr5[0] ^ jArr5[2];
        long j13 = jArr5[1] ^ jArr5[3];
        j(jArr6, j10 ^ j11, j12 ^ j13, jArr3, 3);
        long[] jArr7 = new long[3];
        j(jArr6, j10, j12, jArr7, 0);
        j(jArr6, j11, j13, jArr7, 1);
        long j14 = jArr7[0];
        long j15 = jArr7[1];
        long j16 = jArr7[2];
        jArr3[2] = jArr3[2] ^ j14;
        jArr3[3] = (j14 ^ j15) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j16 ^ j15);
        jArr3[5] = jArr3[5] ^ j16;
        g(jArr3);
    }

    public static void j(long[] jArr, long j10, long j11, long[] jArr2, int i10) {
        jArr[1] = j11;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j11;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j11;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j11;
        int i11 = (int) j10;
        long j12 = (jArr[(i11 >>> 3) & 7] << 3) ^ jArr[i11 & 7];
        long j13 = 0;
        int i12 = 54;
        do {
            int i13 = (int) (j10 >>> i12);
            long j14 = (jArr[(i13 >>> 3) & 7] << 3) ^ jArr[i13 & 7];
            j12 ^= j14 << i12;
            j13 ^= j14 >>> (-i12);
            i12 -= 6;
        } while (i12 > 0);
        jArr2[i10] = jArr2[i10] ^ (1152921504606846975L & j12);
        int i14 = i10 + 1;
        jArr2[i14] = ((((((j10 & 585610922974906400L) & ((j11 << 4) >> 63)) >>> 5) ^ j13) << 4) ^ (j12 >>> 60)) ^ jArr2[i14];
    }

    public static void k(long[] jArr, long[] jArr2) {
        rr.b.d(jArr, 0, 4, jArr2, 0);
    }

    public static void l(long[] jArr, long[] jArr2) {
        if (rr.i.A(jArr)) {
            throw new IllegalStateException();
        }
        long[] jArrM = rr.i.m();
        long[] jArrM2 = rr.i.m();
        r(jArr, jArrM);
        m(jArrM, jArr, jArrM);
        r(jArrM, jArrM);
        m(jArrM, jArr, jArrM);
        t(jArrM, 3, jArrM2);
        m(jArrM2, jArrM, jArrM2);
        r(jArrM2, jArrM2);
        m(jArrM2, jArr, jArrM2);
        t(jArrM2, 7, jArrM);
        m(jArrM, jArrM2, jArrM);
        t(jArrM, 14, jArrM2);
        m(jArrM2, jArrM, jArrM2);
        r(jArrM2, jArrM2);
        m(jArrM2, jArr, jArrM2);
        t(jArrM2, 29, jArrM);
        m(jArrM, jArrM2, jArrM);
        r(jArrM, jArrM);
        m(jArrM, jArr, jArrM);
        t(jArrM, 59, jArrM2);
        m(jArrM2, jArrM, jArrM2);
        r(jArrM2, jArrM2);
        m(jArrM2, jArr, jArrM2);
        t(jArrM2, 119, jArrM);
        m(jArrM, jArrM2, jArrM);
        r(jArrM, jArr2);
    }

    public static void m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrO = rr.i.o();
        i(jArr, jArr2, jArrO);
        o(jArrO, jArr3);
    }

    public static void n(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrO = rr.i.o();
        i(jArr, jArr2, jArrO);
        b(jArr3, jArrO, jArr3);
    }

    public static void o(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        long j17 = jArr[7];
        long j18 = j16 ^ (j17 >>> 17);
        long j19 = (j15 ^ (j17 << 47)) ^ (j18 >>> 17);
        long j20 = ((j14 ^ (j17 >>> 47)) ^ (j18 << 47)) ^ (j19 >>> 17);
        long j21 = j10 ^ (j20 << 17);
        long j22 = (j11 ^ (j19 << 17)) ^ (j20 >>> 47);
        long j23 = ((j12 ^ (j18 << 17)) ^ (j19 >>> 47)) ^ (j20 << 47);
        long j24 = (((j13 ^ (j17 << 17)) ^ (j18 >>> 47)) ^ (j19 << 47)) ^ (j20 >>> 17);
        long j25 = j24 >>> 47;
        jArr2[0] = j21 ^ j25;
        jArr2[1] = j22;
        jArr2[2] = (j25 << 30) ^ j23;
        jArr2[3] = f40142a & j24;
    }

    public static void p(long[] jArr, int i10) {
        int i11 = i10 + 3;
        long j10 = jArr[i11];
        long j11 = j10 >>> 47;
        jArr[i10] = jArr[i10] ^ j11;
        int i12 = i10 + 2;
        jArr[i12] = (j11 << 30) ^ jArr[i12];
        jArr[i11] = j10 & f40142a;
    }

    public static void q(long[] jArr, long[] jArr2) {
        int i10 = 0;
        long jM = rr.b.m(jArr[0]);
        long jM2 = rr.b.m(jArr[1]);
        long j10 = (jM & 4294967295L) | (jM2 << 32);
        long j11 = (jM >>> 32) | (jM2 & (-4294967296L));
        int i11 = 2;
        long jM3 = rr.b.m(jArr[2]);
        long jM4 = rr.b.m(jArr[3]);
        long j12 = (jM3 & 4294967295L) | (jM4 << 32);
        long j13 = (jM4 & (-4294967296L)) | (jM3 >>> 32);
        long j14 = j13 >>> 49;
        long j15 = (j11 >>> 49) | (j13 << 15);
        long j16 = j13 ^ (j11 << 15);
        long[] jArrO = rr.i.o();
        int[] iArr = {39, 120};
        while (i10 < i11) {
            int i12 = iArr[i10] >>> 6;
            int i13 = iArr[i10] & 63;
            jArrO[i12] = jArrO[i12] ^ (j11 << i13);
            int i14 = i12 + 1;
            int[] iArr2 = iArr;
            int i15 = -i13;
            jArrO[i14] = jArrO[i14] ^ ((j16 << i13) | (j11 >>> i15));
            int i16 = i12 + 2;
            jArrO[i16] = jArrO[i16] ^ ((j15 << i13) | (j16 >>> i15));
            int i17 = i12 + 3;
            jArrO[i17] = jArrO[i17] ^ ((j14 << i13) | (j15 >>> i15));
            int i18 = i12 + 4;
            jArrO[i18] = jArrO[i18] ^ (j14 >>> i15);
            i10++;
            i11 = 2;
            iArr = iArr2;
        }
        o(jArrO, jArr2);
        jArr2[0] = jArr2[0] ^ j10;
        jArr2[1] = jArr2[1] ^ j12;
    }

    public static void r(long[] jArr, long[] jArr2) {
        long[] jArrO = rr.i.o();
        k(jArr, jArrO);
        o(jArrO, jArr2);
    }

    public static void s(long[] jArr, long[] jArr2) {
        long[] jArrO = rr.i.o();
        k(jArr, jArrO);
        b(jArr2, jArrO, jArr2);
    }

    public static void t(long[] jArr, int i10, long[] jArr2) {
        long[] jArrO = rr.i.o();
        k(jArr, jArrO);
        while (true) {
            o(jArrO, jArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                k(jArr2, jArrO);
            }
        }
    }

    public static int u(long[] jArr) {
        return ((int) ((jArr[0] ^ (jArr[1] >>> 17)) ^ (jArr[2] >>> 34))) & 1;
    }
}
