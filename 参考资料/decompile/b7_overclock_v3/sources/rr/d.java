package rr;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f49134a = 4294967295L;

    public static int a(int i10) {
        int i11 = (2 - (i10 * i10)) * i10;
        int i12 = i11 * (2 - (i10 * i11));
        int i13 = i12 * (2 - (i10 * i12));
        return i13 * (2 - (i10 * i13));
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i10) {
        char c10 = 0;
        long j10 = ((long) iArr2[0]) & 4294967295L;
        int i11 = 0;
        int i12 = 0;
        while (i11 < 8) {
            long j11 = ((long) iArr3[c10]) & 4294967295L;
            long j12 = ((long) iArr[i11]) & 4294967295L;
            long j13 = j12 * j10;
            long j14 = (j13 & 4294967295L) + j11;
            long j15 = j10;
            long j16 = ((long) (((int) j14) * i10)) & 4294967295L;
            int i13 = i11;
            int i14 = i12;
            long j17 = (((long) iArr4[c10]) & 4294967295L) * j16;
            long j18 = ((j14 + (j17 & 4294967295L)) >>> 32) + (j13 >>> 32) + (j17 >>> 32);
            int i15 = 1;
            for (int i16 = 8; i15 < i16; i16 = 8) {
                long j19 = (((long) iArr2[i15]) & 4294967295L) * j12;
                long j20 = (((long) iArr4[i15]) & 4294967295L) * j16;
                long j21 = j18 + (j19 & 4294967295L) + (j20 & 4294967295L) + (((long) iArr3[i15]) & 4294967295L);
                iArr3[i15 - 1] = (int) j21;
                j18 = (j21 >>> 32) + (j19 >>> 32) + (j20 >>> 32);
                i15++;
                j16 = j16;
            }
            long j22 = j18 + (((long) i14) & 4294967295L);
            iArr3[7] = (int) j22;
            i12 = (int) (j22 >>> 32);
            i11 = i13 + 1;
            j10 = j15;
            c10 = 0;
        }
        if (i12 != 0 || i.w(iArr3, iArr4)) {
            i.Q(iArr3, iArr4, iArr3);
        }
    }

    public static void c(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        char c10 = 0;
        long j10 = ((long) iArr2[0]) & 4294967295L;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= 8) {
                break;
            }
            long j11 = ((long) iArr[i10]) & 4294967295L;
            long j12 = (j11 * j10) + (((long) iArr3[c10]) & 4294967295L);
            long j13 = j12 & 4294967295L;
            long j14 = (j12 >>> 32) + j13;
            int i12 = 1;
            for (int i13 = 8; i12 < i13; i13 = 8) {
                long j15 = j10;
                long j16 = (((long) iArr2[i12]) & 4294967295L) * j11;
                long j17 = (((long) iArr4[i12]) & 4294967295L) * j13;
                long j18 = j14 + (j16 & 4294967295L) + (j17 & 4294967295L) + (((long) iArr3[i12]) & 4294967295L);
                iArr3[i12 - 1] = (int) j18;
                j14 = (j18 >>> 32) + (j16 >>> 32) + (j17 >>> 32);
                i12++;
                j10 = j15;
                j11 = j11;
                j13 = j13;
            }
            long j19 = j14 + (((long) i11) & 4294967295L);
            iArr3[7] = (int) j19;
            i11 = (int) (j19 >>> 32);
            i10++;
            j10 = j10;
            c10 = 0;
        }
        if (i11 != 0 || i.w(iArr3, iArr4)) {
            i.Q(iArr3, iArr4, iArr3);
        }
    }

    public static void d(int[] iArr, int[] iArr2, int i10) {
        char c10 = 0;
        int i11 = 0;
        while (i11 < 8) {
            int i12 = iArr[c10];
            long j10 = ((long) (i12 * i10)) & 4294967295L;
            long j11 = (((((long) iArr2[c10]) & 4294967295L) * j10) + (((long) i12) & 4294967295L)) >>> 32;
            int i13 = 1;
            while (i13 < 8) {
                long j12 = j11 + ((((long) iArr2[i13]) & 4294967295L) * j10) + (((long) iArr[i13]) & 4294967295L);
                iArr[i13 - 1] = (int) j12;
                j11 = j12 >>> 32;
                i13++;
                i11 = i11;
            }
            iArr[7] = (int) j11;
            i11++;
            c10 = 0;
        }
        if (i.w(iArr, iArr2)) {
            i.Q(iArr, iArr2, iArr);
        }
    }

    public static void e(int[] iArr, int[] iArr2) {
        for (int i10 = 0; i10 < 8; i10++) {
            long j10 = ((long) iArr[0]) & 4294967295L;
            long j11 = j10;
            for (int i11 = 1; i11 < 8; i11++) {
                long j12 = j11 + ((((long) iArr2[i11]) & 4294967295L) * j10) + (((long) iArr[i11]) & 4294967295L);
                iArr[i11 - 1] = (int) j12;
                j11 = j12 >>> 32;
            }
            iArr[7] = (int) j11;
        }
        if (i.w(iArr, iArr2)) {
            i.Q(iArr, iArr2, iArr);
        }
    }
}
