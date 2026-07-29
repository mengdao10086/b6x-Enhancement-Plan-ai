package ab;

import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f504a = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f513j = 384;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f514k = 1152;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f515l = 1152;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f516m = 576;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f506c = {hd.w.E, hd.w.F, hd.w.D};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f507d = {com.google.android.exoplayer2.source.u.f18441j, y.f524a, 32000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f508e = {32000, 64000, 96000, jd.e.f36347i, 160000, w.f491a, 224000, ab.a.f355i, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f509f = {32000, y.f524a, 56000, 64000, b.f382a, 96000, 112000, jd.e.f36347i, 144000, 160000, 176000, w.f491a, 224000, ab.a.f355i};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f510g = {32000, y.f524a, 56000, 64000, b.f382a, 96000, 112000, jd.e.f36347i, 160000, w.f491a, 224000, ab.a.f355i, 320000, 384000};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f505b = 40000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f511h = {32000, f505b, y.f524a, 56000, 64000, b.f382a, 96000, 112000, jd.e.f36347i, 160000, w.f491a, 224000, ab.a.f355i, 320000};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f512i = {8000, 16000, 24000, 32000, f505b, y.f524a, 56000, 64000, b.f382a, 96000, 112000, jd.e.f36347i, 144000, 160000};

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public String f518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f520d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f521e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f522f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f523g;

        public boolean a(int i10) {
            int i11;
            int i12;
            int i13;
            int i14;
            if (!x.l(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
                return false;
            }
            this.f517a = i11;
            this.f518b = x.f506c[3 - i12];
            int i15 = x.f507d[i14];
            this.f520d = i15;
            if (i11 == 2) {
                this.f520d = i15 / 2;
            } else if (i11 == 0) {
                this.f520d = i15 / 4;
            }
            int i16 = (i10 >>> 9) & 1;
            this.f523g = x.k(i11, i12);
            if (i12 == 3) {
                int i17 = i11 == 3 ? x.f508e[i13 - 1] : x.f509f[i13 - 1];
                this.f522f = i17;
                this.f519c = (((i17 * 12) / this.f520d) + i16) * 4;
            } else {
                if (i11 == 3) {
                    int i18 = i12 == 2 ? x.f510g[i13 - 1] : x.f511h[i13 - 1];
                    this.f522f = i18;
                    this.f519c = ((i18 * 144) / this.f520d) + i16;
                } else {
                    int i19 = x.f512i[i13 - 1];
                    this.f522f = i19;
                    this.f519c = (((i12 == 1 ? 72 : 144) * i19) / this.f520d) + i16;
                }
            }
            this.f521e = ((i10 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int j(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (!l(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
            return -1;
        }
        int i15 = f507d[i14];
        if (i11 == 2) {
            i15 /= 2;
        } else if (i11 == 0) {
            i15 /= 4;
        }
        int i16 = (i10 >>> 9) & 1;
        if (i12 == 3) {
            return ((((i11 == 3 ? f508e[i13 - 1] : f509f[i13 - 1]) * 12) / i15) + i16) * 4;
        }
        int i17 = i11 == 3 ? i12 == 2 ? f510g[i13 - 1] : f511h[i13 - 1] : f512i[i13 - 1];
        if (i11 == 3) {
            return ((i17 * 144) / i15) + i16;
        }
        return (((i12 == 1 ? 72 : 144) * i17) / i15) + i16;
    }

    public static int k(int i10, int i11) {
        if (i11 == 1) {
            return i10 == 3 ? 1152 : 576;
        }
        if (i11 == 2) {
            return 1152;
        }
        if (i11 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    public static boolean l(int i10) {
        return (i10 & (-2097152)) == -2097152;
    }

    public static int m(int i10) {
        int i11;
        int i12;
        if (!l(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0) {
            return -1;
        }
        int i13 = (i10 >>> 12) & 15;
        int i14 = (i10 >>> 10) & 3;
        if (i13 == 0 || i13 == 15 || i14 == 3) {
            return -1;
        }
        return k(i11, i12);
    }
}
