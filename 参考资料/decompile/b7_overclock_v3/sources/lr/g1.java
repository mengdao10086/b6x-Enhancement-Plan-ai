package lr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f40213a = 34359738367L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f40214b = 36028797018963967L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long[] f40215c = {-5270498306774157648L, 5270498306774195053L, 19634136210L};

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr2[5] ^ jArr[5];
    }

    public static void c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    public static void d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
    }

    public static long[] e(BigInteger bigInteger) {
        return rr.o.U(163, bigInteger);
    }

    public static void f(long[] jArr, long[] jArr2) {
        long[] jArrM = rr.g.m();
        rr.g.i(jArr, jArr2);
        for (int i10 = 1; i10 < 163; i10 += 2) {
            j(jArr2, jArrM);
            n(jArrM, jArr2);
            j(jArr2, jArrM);
            n(jArrM, jArr2);
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
        jArr[0] = j10 ^ (j11 << 55);
        jArr[1] = (j11 >>> 9) ^ (j12 << 46);
        jArr[2] = (j12 >>> 18) ^ (j13 << 37);
        jArr[3] = (j13 >>> 27) ^ (j14 << 28);
        jArr[4] = (j14 >>> 36) ^ (j15 << 19);
        jArr[5] = j15 >>> 45;
    }

    public static void h(long[] jArr, long[] jArr2, long[] jArr3) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = (j11 >>> 46) ^ (jArr[2] << 18);
        long j13 = ((j11 << 9) ^ (j10 >>> 55)) & f40214b;
        long j14 = j10 & f40214b;
        long j15 = jArr2[0];
        long j16 = jArr2[1];
        long j17 = (j16 >>> 46) ^ (jArr2[2] << 18);
        long j18 = ((j16 << 9) ^ (j15 >>> 55)) & f40214b;
        long j19 = j15 & f40214b;
        long[] jArr4 = new long[10];
        i(jArr3, j14, j19, jArr4, 0);
        i(jArr3, j12, j17, jArr4, 2);
        long j20 = (j14 ^ j13) ^ j12;
        long j21 = (j19 ^ j18) ^ j17;
        i(jArr3, j20, j21, jArr4, 4);
        long j22 = (j13 << 1) ^ (j12 << 2);
        long j23 = (j18 << 1) ^ (j17 << 2);
        i(jArr3, j14 ^ j22, j19 ^ j23, jArr4, 6);
        i(jArr3, j20 ^ j22, j21 ^ j23, jArr4, 8);
        long j24 = jArr4[6] ^ jArr4[8];
        long j25 = jArr4[7] ^ jArr4[9];
        long j26 = (j24 << 1) ^ jArr4[6];
        long j27 = (j24 ^ (j25 << 1)) ^ jArr4[7];
        long j28 = jArr4[0];
        long j29 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j30 = jArr4[1] ^ jArr4[5];
        long j31 = ((j28 ^ j26) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        long j32 = (((j29 ^ j27) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j31 >>> 55);
        long j33 = j31 & f40214b;
        long j34 = (j30 ^ j25) ^ (j32 >>> 55);
        long j35 = j32 & f40214b;
        long j36 = (j33 >>> 1) ^ ((j35 & 1) << 54);
        long j37 = j36 ^ (j36 << 1);
        long j38 = j37 ^ (j37 << 2);
        long j39 = j38 ^ (j38 << 4);
        long j40 = j39 ^ (j39 << 8);
        long j41 = j40 ^ (j40 << 16);
        long j42 = (j41 ^ (j41 << 32)) & f40214b;
        long j43 = ((j35 >>> 1) ^ ((j34 & 1) << 54)) ^ (j42 >>> 54);
        long j44 = j43 ^ (j43 << 1);
        long j45 = j44 ^ (j44 << 2);
        long j46 = j45 ^ (j45 << 4);
        long j47 = j46 ^ (j46 << 8);
        long j48 = j47 ^ (j47 << 16);
        long j49 = (j48 ^ (j48 << 32)) & f40214b;
        long j50 = (j34 >>> 1) ^ (j49 >>> 54);
        long j51 = j50 ^ (j50 << 1);
        long j52 = j51 ^ (j51 << 2);
        long j53 = j52 ^ (j52 << 4);
        long j54 = j53 ^ (j53 << 8);
        long j55 = j54 ^ (j54 << 16);
        long j56 = j55 ^ (j55 << 32);
        jArr3[0] = j28;
        jArr3[1] = (j29 ^ j42) ^ jArr4[2];
        jArr3[2] = ((j30 ^ j49) ^ j42) ^ jArr4[3];
        jArr3[3] = j49 ^ j56;
        jArr3[4] = jArr4[2] ^ j56;
        jArr3[5] = jArr4[3];
        g(jArr3);
    }

    public static void i(long[] jArr, long j10, long j11, long[] jArr2, int i10) {
        jArr[1] = j11;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j11;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j11;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j11;
        long j12 = jArr[((int) j10) & 3];
        long j13 = 0;
        int i11 = 47;
        do {
            int i12 = (int) (j10 >>> i11);
            long j14 = (jArr[(i12 >>> 6) & 7] << 6) ^ (jArr[i12 & 7] ^ (jArr[(i12 >>> 3) & 7] << 3));
            j12 ^= j14 << i11;
            j13 ^= j14 >>> (-i11);
            i11 -= 9;
        } while (i11 > 0);
        jArr2[i10] = f40214b & j12;
        jArr2[i10 + 1] = (j12 >>> 55) ^ (j13 << 9);
    }

    public static void j(long[] jArr, long[] jArr2) {
        rr.b.d(jArr, 0, 3, jArr2, 0);
    }

    public static void k(long[] jArr, long[] jArr2) {
        if (rr.g.y(jArr)) {
            throw new IllegalStateException();
        }
        long[] jArrK = rr.g.k();
        long[] jArrK2 = rr.g.k();
        q(jArr, jArrK);
        s(jArrK, 1, jArrK2);
        l(jArrK, jArrK2, jArrK);
        s(jArrK2, 1, jArrK2);
        l(jArrK, jArrK2, jArrK);
        s(jArrK, 3, jArrK2);
        l(jArrK, jArrK2, jArrK);
        s(jArrK2, 3, jArrK2);
        l(jArrK, jArrK2, jArrK);
        s(jArrK, 9, jArrK2);
        l(jArrK, jArrK2, jArrK);
        s(jArrK2, 9, jArrK2);
        l(jArrK, jArrK2, jArrK);
        s(jArrK, 27, jArrK2);
        l(jArrK, jArrK2, jArrK);
        s(jArrK2, 27, jArrK2);
        l(jArrK, jArrK2, jArrK);
        s(jArrK, 81, jArrK2);
        l(jArrK, jArrK2, jArr2);
    }

    public static void l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        h(jArr, jArr2, jArr4);
        n(jArr4, jArr3);
    }

    public static void m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        h(jArr, jArr2, jArr4);
        b(jArr3, jArr4, jArr3);
    }

    public static void n(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = j13 ^ ((((j15 >>> 35) ^ (j15 >>> 32)) ^ (j15 >>> 29)) ^ (j15 >>> 28));
        long j17 = (j12 ^ ((((j15 << 29) ^ (j15 << 32)) ^ (j15 << 35)) ^ (j15 << 36))) ^ ((j14 >>> 28) ^ (((j14 >>> 35) ^ (j14 >>> 32)) ^ (j14 >>> 29)));
        long j18 = j10 ^ ((((j16 << 29) ^ (j16 << 32)) ^ (j16 << 35)) ^ (j16 << 36));
        long j19 = (j11 ^ ((((j14 << 29) ^ (j14 << 32)) ^ (j14 << 35)) ^ (j14 << 36))) ^ ((j16 >>> 28) ^ (((j16 >>> 35) ^ (j16 >>> 32)) ^ (j16 >>> 29)));
        long j20 = j17 >>> 35;
        jArr2[0] = (((j18 ^ j20) ^ (j20 << 3)) ^ (j20 << 6)) ^ (j20 << 7);
        jArr2[1] = j19;
        jArr2[2] = f40213a & j17;
    }

    public static void o(long[] jArr, int i10) {
        int i11 = i10 + 2;
        long j10 = jArr[i11];
        long j11 = j10 >>> 35;
        jArr[i10] = ((j11 << 7) ^ (((j11 << 3) ^ j11) ^ (j11 << 6))) ^ jArr[i10];
        jArr[i11] = j10 & f40213a;
    }

    public static void p(long[] jArr, long[] jArr2) {
        long[] jArrK = rr.g.k();
        long jM = rr.b.m(jArr[0]);
        long jM2 = rr.b.m(jArr[1]);
        long j10 = (jM & 4294967295L) | (jM2 << 32);
        jArrK[0] = (jM >>> 32) | (jM2 & (-4294967296L));
        long jM3 = rr.b.m(jArr[2]);
        jArrK[1] = jM3 >>> 32;
        l(jArrK, f40215c, jArr2);
        jArr2[0] = jArr2[0] ^ j10;
        jArr2[1] = jArr2[1] ^ (jM3 & 4294967295L);
    }

    public static void q(long[] jArr, long[] jArr2) {
        long[] jArrM = rr.g.m();
        j(jArr, jArrM);
        n(jArrM, jArr2);
    }

    public static void r(long[] jArr, long[] jArr2) {
        long[] jArrM = rr.g.m();
        j(jArr, jArrM);
        b(jArr2, jArrM, jArr2);
    }

    public static void s(long[] jArr, int i10, long[] jArr2) {
        long[] jArrM = rr.g.m();
        j(jArr, jArrM);
        while (true) {
            n(jArrM, jArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                j(jArr2, jArrM);
            }
        }
    }

    public static int t(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[2] >>> 29))) & 1;
    }
}
