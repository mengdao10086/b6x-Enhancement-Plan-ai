package ob;

import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43141a = 8192;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f43142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f43143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f43144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f43145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f43146e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f43147f;

        public b(long[] jArr, int[] iArr, int i10, long[] jArr2, int[] iArr2, long j10) {
            this.f43142a = jArr;
            this.f43143b = iArr;
            this.f43144c = i10;
            this.f43145d = jArr2;
            this.f43146e = iArr2;
            this.f43147f = j10;
        }
    }

    public static b a(int i10, long[] jArr, int[] iArr, long j10) {
        int i11 = 8192 / i10;
        int iM = 0;
        for (int i12 : iArr) {
            iM += u0.m(i12, i11);
        }
        long[] jArr2 = new long[iM];
        int[] iArr2 = new int[iM];
        long[] jArr3 = new long[iM];
        int[] iArr3 = new int[iM];
        int i13 = 0;
        int i14 = 0;
        int iMax = 0;
        for (int i15 = 0; i15 < iArr.length; i15++) {
            int i16 = iArr[i15];
            long j11 = jArr[i15];
            while (i16 > 0) {
                int iMin = Math.min(i11, i16);
                jArr2[i14] = j11;
                iArr2[i14] = i10 * iMin;
                iMax = Math.max(iMax, iArr2[i14]);
                jArr3[i14] = ((long) i13) * j10;
                iArr3[i14] = 1;
                j11 += (long) iArr2[i14];
                i13 += iMin;
                i16 -= iMin;
                i14++;
            }
        }
        return new b(jArr2, iArr2, iMax, jArr3, iArr3, j10 * ((long) i13));
    }
}
