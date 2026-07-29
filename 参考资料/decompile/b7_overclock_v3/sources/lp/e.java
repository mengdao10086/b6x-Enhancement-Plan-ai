package lp;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40107a = 2;

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }

    public static void b(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static boolean c(long[] jArr, long[] jArr2) {
        return ((jArr2[1] ^ jArr[1]) | ((jArr[0] ^ jArr2[0]) | 0)) == 0;
    }

    public static void d(long[] jArr, long[] jArr2, long[] jArr3) {
        int i10 = 0;
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr2[0];
        long j13 = jArr2[1];
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        while (i10 < 64) {
            long j17 = j15;
            long j18 = -(j10 & 1);
            j10 >>>= 1;
            j14 ^= j12 & j18;
            long j19 = (j18 & j13) ^ j16;
            long j20 = -(j11 & 1);
            j11 >>>= 1;
            long j21 = j19 ^ (j12 & j20);
            long j22 = j17 ^ (j20 & j13);
            long j23 = j13 >> 63;
            j13 = (j13 << 1) | (j12 >>> 63);
            j12 = (j12 << 1) ^ (j23 & 135);
            i10++;
            j15 = j22;
            j16 = j21;
        }
        long j24 = j15;
        jArr3[0] = (((j24 ^ (j24 << 1)) ^ (j24 << 2)) ^ (j24 << 7)) ^ j14;
        jArr3[1] = (((j24 >>> 63) ^ (j24 >>> 62)) ^ (j24 >>> 57)) ^ j16;
    }

    public static void e(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        jArr2[0] = ((j11 >> 63) & 135) ^ (j10 << 1);
        jArr2[1] = (j10 >>> 63) | (j11 << 1);
    }

    public static void f(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = j11 >>> 56;
        jArr2[0] = (j12 << 7) ^ ((((j10 << 8) ^ j12) ^ (j12 << 1)) ^ (j12 << 2));
        jArr2[1] = (j10 >>> 56) | (j11 << 8);
    }

    public static void g(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
    }

    public static void h(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[4];
        rr.b.c(jArr[0], jArr3, 0);
        rr.b.c(jArr[1], jArr3, 2);
        long j10 = jArr3[0];
        long j11 = jArr3[1];
        long j12 = jArr3[2];
        long j13 = jArr3[3];
        long j14 = j12 ^ ((j13 >>> 57) ^ ((j13 >>> 63) ^ (j13 >>> 62)));
        jArr2[0] = j10 ^ ((((j14 << 1) ^ j14) ^ (j14 << 2)) ^ (j14 << 7));
        jArr2[1] = (j11 ^ ((((j13 << 1) ^ j13) ^ (j13 << 2)) ^ (j13 << 7))) ^ ((j14 >>> 57) ^ ((j14 >>> 63) ^ (j14 >>> 62)));
    }

    public static void i(long[] jArr) {
        jArr[0] = 2;
        jArr[1] = 0;
    }

    public static void j(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
    }
}
