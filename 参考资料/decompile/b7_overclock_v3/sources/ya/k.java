package ya;

import com.google.android.exoplayer2.source.TrackGroupArray;

/* JADX INFO: loaded from: classes3.dex */
public class k implements u0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f56854l = 50000;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f56855m = 50000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f56856n = 2500;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f56857o = 5000;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f56858p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final boolean f56859q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f56860r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f56861s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f56862t = 131072000;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f56863u = 13107200;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f56864v = 131072;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f56865w = 131072;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f56866x = 131072;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f56867y = 144310272;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f56868z = 13107200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed.m f56869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f56870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f56871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f56872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f56873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f56874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f56875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f56876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f56877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f56878j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f56879k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.p0
        public ed.m f56880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f56881b = 50000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f56882c = 50000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f56883d = k.f56856n;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f56884e = 5000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f56885f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f56886g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f56887h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f56888i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f56889j;

        public k a() {
            hd.a.i(!this.f56889j);
            this.f56889j = true;
            if (this.f56880a == null) {
                this.f56880a = new ed.m(true, 65536);
            }
            return new k(this.f56880a, this.f56881b, this.f56882c, this.f56883d, this.f56884e, this.f56885f, this.f56886g, this.f56887h, this.f56888i);
        }

        @Deprecated
        public k b() {
            return a();
        }

        public a c(ed.m mVar) {
            hd.a.i(!this.f56889j);
            this.f56880a = mVar;
            return this;
        }

        public a d(int i10, boolean z10) {
            hd.a.i(!this.f56889j);
            k.k(i10, 0, "backBufferDurationMs", "0");
            this.f56887h = i10;
            this.f56888i = z10;
            return this;
        }

        public a e(int i10, int i11, int i12, int i13) {
            hd.a.i(!this.f56889j);
            k.k(i12, 0, "bufferForPlaybackMs", "0");
            k.k(i13, 0, "bufferForPlaybackAfterRebufferMs", "0");
            k.k(i10, i12, "minBufferMs", "bufferForPlaybackMs");
            k.k(i10, i13, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            k.k(i11, i10, "maxBufferMs", "minBufferMs");
            this.f56881b = i10;
            this.f56882c = i11;
            this.f56883d = i12;
            this.f56884e = i13;
            return this;
        }

        public a f(boolean z10) {
            hd.a.i(!this.f56889j);
            this.f56886g = z10;
            return this;
        }

        public a g(int i10) {
            hd.a.i(!this.f56889j);
            this.f56885f = i10;
            return this;
        }
    }

    public k() {
        this(new ed.m(true, 65536), 50000, 50000, f56856n, 5000, -1, false, 0, false);
    }

    public static void k(int i10, int i11, String str, String str2) {
        hd.a.b(i10 >= i11, str + " cannot be less than " + str2);
    }

    public static int m(int i10) {
        if (i10 == 0) {
            return f56867y;
        }
        if (i10 == 1) {
            return 13107200;
        }
        if (i10 == 2) {
            return f56862t;
        }
        if (i10 == 3 || i10 == 5 || i10 == 6) {
            return 131072;
        }
        if (i10 == 7) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    @Override // ya.u0
    public void a() {
        n(false);
    }

    @Override // ya.u0
    public void b(o1[] o1VarArr, TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.b[] bVarArr) {
        int iL = this.f56874f;
        if (iL == -1) {
            iL = l(o1VarArr, bVarArr);
        }
        this.f56878j = iL;
        this.f56869a.h(iL);
    }

    @Override // ya.u0
    public boolean c() {
        return this.f56877i;
    }

    @Override // ya.u0
    public long d() {
        return this.f56876h;
    }

    @Override // ya.u0
    public void e() {
        n(true);
    }

    @Override // ya.u0
    public boolean f(long j10, float f10, boolean z10, long j11) {
        long jN0 = hd.u0.n0(j10, f10);
        long jMin = z10 ? this.f56873e : this.f56872d;
        if (j11 != g.f56663b) {
            jMin = Math.min(j11 / 2, jMin);
        }
        return jMin <= 0 || jN0 >= jMin || (!this.f56875g && this.f56869a.e() >= this.f56878j);
    }

    @Override // ya.u0
    public boolean g(long j10, long j11, float f10) {
        boolean z10 = true;
        boolean z11 = this.f56869a.e() >= this.f56878j;
        long jMin = this.f56870b;
        if (f10 > 1.0f) {
            jMin = Math.min(hd.u0.g0(jMin, f10), this.f56871c);
        }
        if (j11 < Math.max(jMin, 500000L)) {
            if (!this.f56875g && z11) {
                z10 = false;
            }
            this.f56879k = z10;
            if (!z10 && j11 < 500000) {
                hd.t.n("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j11 >= this.f56871c || z11) {
            this.f56879k = false;
        }
        return this.f56879k;
    }

    @Override // ya.u0
    public ed.b h() {
        return this.f56869a;
    }

    @Override // ya.u0
    public void i() {
        n(true);
    }

    public int l(o1[] o1VarArr, com.google.android.exoplayer2.trackselection.b[] bVarArr) {
        int iM = 0;
        for (int i10 = 0; i10 < o1VarArr.length; i10++) {
            if (bVarArr[i10] != null) {
                iM += m(o1VarArr[i10].h());
            }
        }
        return Math.max(13107200, iM);
    }

    public final void n(boolean z10) {
        int i10 = this.f56874f;
        if (i10 == -1) {
            i10 = 13107200;
        }
        this.f56878j = i10;
        this.f56879k = false;
        if (z10) {
            this.f56869a.g();
        }
    }

    public k(ed.m mVar, int i10, int i11, int i12, int i13, int i14, boolean z10, int i15, boolean z11) {
        k(i12, 0, "bufferForPlaybackMs", "0");
        k(i13, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(i10, i12, "minBufferMs", "bufferForPlaybackMs");
        k(i10, i13, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(i11, i10, "maxBufferMs", "minBufferMs");
        k(i15, 0, "backBufferDurationMs", "0");
        this.f56869a = mVar;
        this.f56870b = g.c(i10);
        this.f56871c = g.c(i11);
        this.f56872d = g.c(i12);
        this.f56873e = g.c(i13);
        this.f56874f = i14;
        this.f56878j = i14 == -1 ? 13107200 : i14;
        this.f56875g = z10;
        this.f56876h = g.c(i15);
        this.f56877i = z11;
    }
}
