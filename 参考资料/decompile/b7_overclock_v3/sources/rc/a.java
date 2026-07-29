package rc;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.arialyy.aria.core.listener.ISchedulers;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.umeng.analytics.pro.o;
import g.p0;
import hd.c0;
import hd.t;
import hd.u0;
import hd.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m9.m;
import ob.h;
import qc.b;
import qc.i;
import qc.j;
import rb.a0;
import v7.a;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e {
    public static final long A = 16000;
    public static final String B = "Cea608Decoder";
    public static final int C = 4;
    public static final int D = 2;
    public static final int E = 1;
    public static final int F = 0;
    public static final int G = 1;
    public static final int H = 0;
    public static final int I = 1;
    public static final int J = 0;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;
    public static final int Q = 7;
    public static final int R = 8;
    public static final int S = 4;
    public static final byte T = -4;
    public static final byte U = 32;
    public static final byte V = 33;
    public static final byte W = 36;
    public static final byte X = 37;
    public static final byte Y = 38;
    public static final byte Z = 39;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final byte f48409a0 = 41;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final byte f48410b0 = 42;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final byte f48411c0 = 43;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final byte f48412d0 = 44;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final byte f48413e0 = 45;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final byte f48414f0 = 46;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final byte f48415g0 = 47;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f48422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f48423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f48424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f48425m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public List<qc.b> f48428p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public List<qc.b> f48429q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f48430r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f48431s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f48432t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f48433u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte f48434v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte f48435w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f48437y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f48438z;
    public static final int[] N = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] O = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] P = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int[] f48416h0 = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, mb.e.f41040l1, 247, 209, 241, 9632};

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int[] f48417i0 = {mb.e.f41073w1, 176, a0.f47918w, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, mb.e.f41061s1, 244, mb.e.f41067u1};

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int[] f48418j0 = {s0.c.f49294u, 201, hr.a.f31427a, 218, 220, 252, 8216, 161, 42, 39, o.a.C, h.H, 8480, 8226, 8220, 8221, 192, 194, 199, 200, a.c.f52772h, a.c.f52773i, 235, a.c.f52775k, a.c.f52776l, 239, 212, 217, a4.d.f205j, 219, 171, mb.e.f41031i2};

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int[] f48419k0 = {195, 227, 205, a.c.f52774j, 236, ISchedulers.IS_M3U8_PEER, m.f40854e0, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, ISchedulers.SUB_CANCEL, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final boolean[] f48420l0 = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f48421i = new c0();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<C0552a> f48426n = new ArrayList<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public C0552a f48427o = new C0552a(0, 4);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f48436x = 0;

    /* JADX INFO: renamed from: rc.a$a, reason: collision with other inner class name */
    public static final class C0552a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f48439i = 32;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f48440j = 15;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C0553a> f48441a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<SpannableString> f48442b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final StringBuilder f48443c = new StringBuilder();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f48444d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f48445e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f48446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f48447g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f48448h;

        /* JADX INFO: renamed from: rc.a$a$a, reason: collision with other inner class name */
        public static class C0553a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f48449a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f48450b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f48451c;

            public C0553a(int i10, boolean z10, int i11) {
                this.f48449a = i10;
                this.f48450b = z10;
                this.f48451c = i11;
            }
        }

        public C0552a(int i10, int i11) {
            j(i10);
            this.f48448h = i11;
        }

        public static void n(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12) {
            if (i12 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i12), i10, i11, 33);
        }

        public static void o(SpannableStringBuilder spannableStringBuilder, int i10, int i11) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i10, i11, 33);
        }

        public static void q(SpannableStringBuilder spannableStringBuilder, int i10, int i11) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i10, i11, 33);
        }

        public void e(char c10) {
            if (this.f48443c.length() < 32) {
                this.f48443c.append(c10);
            }
        }

        public void f() {
            int length = this.f48443c.length();
            if (length > 0) {
                this.f48443c.delete(length - 1, length);
                for (int size = this.f48441a.size() - 1; size >= 0; size--) {
                    C0553a c0553a = this.f48441a.get(size);
                    int i10 = c0553a.f48451c;
                    if (i10 != length) {
                        return;
                    }
                    c0553a.f48451c = i10 - 1;
                }
            }
        }

        @p0
        public qc.b g(int i10) {
            float f10;
            int i11 = this.f48445e + this.f48446f;
            int i12 = 32 - i11;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i13 = 0; i13 < this.f48442b.size(); i13++) {
                spannableStringBuilder.append(u0.z1(this.f48442b.get(i13), i12));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(u0.z1(h(), i12));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i12 - spannableStringBuilder.length();
            int i14 = i11 - length;
            if (i10 == Integer.MIN_VALUE) {
                i10 = (this.f48447g != 2 || (Math.abs(i14) >= 3 && length >= 0)) ? (this.f48447g != 2 || i14 <= 0) ? 0 : 2 : 1;
            }
            if (i10 != 1) {
                if (i10 == 2) {
                    i11 = 32 - length;
                }
                f10 = ((i11 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f10 = 0.5f;
            }
            int i15 = this.f48444d;
            if (i15 > 7) {
                i15 = (i15 - 15) - 2;
            } else if (this.f48447g == 1) {
                i15 -= this.f48448h - 1;
            }
            return new b.c().z(spannableStringBuilder).A(Layout.Alignment.ALIGN_NORMAL).t(i15, 1).v(f10).w(i10).a();
        }

        public final SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f48443c);
            int length = spannableStringBuilder.length();
            int i10 = 0;
            int i11 = -1;
            int i12 = -1;
            int i13 = 0;
            int i14 = -1;
            int i15 = -1;
            boolean z10 = false;
            while (i10 < this.f48441a.size()) {
                C0553a c0553a = this.f48441a.get(i10);
                boolean z11 = c0553a.f48450b;
                int i16 = c0553a.f48449a;
                if (i16 != 8) {
                    boolean z12 = i16 == 7;
                    if (i16 != 7) {
                        i15 = a.P[i16];
                    }
                    z10 = z12;
                }
                int i17 = c0553a.f48451c;
                i10++;
                if (i17 != (i10 < this.f48441a.size() ? this.f48441a.get(i10).f48451c : length)) {
                    if (i11 != -1 && !z11) {
                        q(spannableStringBuilder, i11, i17);
                        i11 = -1;
                    } else if (i11 == -1 && z11) {
                        i11 = i17;
                    }
                    if (i12 != -1 && !z10) {
                        o(spannableStringBuilder, i12, i17);
                        i12 = -1;
                    } else if (i12 == -1 && z10) {
                        i12 = i17;
                    }
                    if (i15 != i14) {
                        n(spannableStringBuilder, i13, i17, i14);
                        i14 = i15;
                        i13 = i17;
                    }
                }
            }
            if (i11 != -1 && i11 != length) {
                q(spannableStringBuilder, i11, length);
            }
            if (i12 != -1 && i12 != length) {
                o(spannableStringBuilder, i12, length);
            }
            if (i13 != length) {
                n(spannableStringBuilder, i13, length, i14);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean i() {
            return this.f48441a.isEmpty() && this.f48442b.isEmpty() && this.f48443c.length() == 0;
        }

        public void j(int i10) {
            this.f48447g = i10;
            this.f48441a.clear();
            this.f48442b.clear();
            this.f48443c.setLength(0);
            this.f48444d = 15;
            this.f48445e = 0;
            this.f48446f = 0;
        }

        public void k() {
            this.f48442b.add(h());
            this.f48443c.setLength(0);
            this.f48441a.clear();
            int iMin = Math.min(this.f48448h, this.f48444d);
            while (this.f48442b.size() >= iMin) {
                this.f48442b.remove(0);
            }
        }

        public void l(int i10) {
            this.f48447g = i10;
        }

        public void m(int i10) {
            this.f48448h = i10;
        }

        public void p(int i10, boolean z10) {
            this.f48441a.add(new C0553a(i10, z10, this.f48443c.length()));
        }
    }

    public a(String str, int i10, long j10) {
        this.f48425m = j10 > 0 ? j10 * 1000 : -9223372036854775807L;
        this.f48422j = w.f31207r0.equals(str) ? 2 : 3;
        if (i10 == 1) {
            this.f48424l = 0;
            this.f48423k = 0;
        } else if (i10 == 2) {
            this.f48424l = 1;
            this.f48423k = 0;
        } else if (i10 == 3) {
            this.f48424l = 0;
            this.f48423k = 1;
        } else if (i10 != 4) {
            t.n(B, "Invalid channel. Defaulting to CC1.");
            this.f48424l = 0;
            this.f48423k = 0;
        } else {
            this.f48424l = 1;
            this.f48423k = 1;
        }
        M(0);
        L();
        this.f48437y = true;
        this.f48438z = ya.g.f56663b;
    }

    public static boolean A(byte b10, byte b11) {
        return (b10 & 246) == 18 && (b11 & 224) == 32;
    }

    public static boolean B(byte b10, byte b11) {
        return (b10 & 247) == 17 && (b11 & 240) == 32;
    }

    public static boolean C(byte b10, byte b11) {
        return (b10 & 246) == 20 && (b11 & 240) == 32;
    }

    public static boolean D(byte b10, byte b11) {
        return (b10 & 240) == 16 && (b11 & i1.a.f31667o7) == 64;
    }

    public static boolean E(byte b10) {
        return (b10 & 240) == 16;
    }

    public static boolean G(byte b10) {
        return (b10 & 247) == 20;
    }

    public static boolean H(byte b10, byte b11) {
        return (b10 & 247) == 17 && (b11 & 240) == 48;
    }

    public static boolean I(byte b10, byte b11) {
        return (b10 & 247) == 23 && b11 >= 33 && b11 <= 35;
    }

    public static boolean J(byte b10) {
        return 1 <= b10 && b10 <= 15;
    }

    public static char p(byte b10) {
        return (char) f48416h0[(b10 & 127) - 32];
    }

    public static int q(byte b10) {
        return (b10 >> 3) & 1;
    }

    public static char s(byte b10) {
        return (char) f48418j0[b10 & 31];
    }

    public static char t(byte b10) {
        return (char) f48419k0[b10 & 31];
    }

    public static char u(byte b10, byte b11) {
        return (b10 & 1) == 0 ? s(b11) : t(b11);
    }

    public static char v(byte b10) {
        return (char) f48417i0[b10 & 15];
    }

    public static boolean z(byte b10) {
        return (b10 & 224) == 0;
    }

    public final boolean F(boolean z10, byte b10, byte b11) {
        if (!z10 || !E(b10)) {
            this.f48433u = false;
        } else {
            if (this.f48433u && this.f48434v == b10 && this.f48435w == b11) {
                this.f48433u = false;
                return true;
            }
            this.f48433u = true;
            this.f48434v = b10;
            this.f48435w = b11;
        }
        return false;
    }

    public final void K(byte b10, byte b11) {
        if (J(b10)) {
            this.f48437y = false;
            return;
        }
        if (G(b10)) {
            if (b11 != 32 && b11 != 47) {
                switch (b11) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b11) {
                            case 42:
                            case 43:
                                this.f48437y = false;
                                break;
                        }
                }
            }
            this.f48437y = true;
        }
    }

    public final void L() {
        this.f48427o.j(this.f48430r);
        this.f48426n.clear();
        this.f48426n.add(this.f48427o);
    }

    public final void M(int i10) {
        int i11 = this.f48430r;
        if (i11 == i10) {
            return;
        }
        this.f48430r = i10;
        if (i10 == 3) {
            for (int i12 = 0; i12 < this.f48426n.size(); i12++) {
                this.f48426n.get(i12).l(i10);
            }
            return;
        }
        L();
        if (i11 == 3 || i10 == 1 || i10 == 0) {
            this.f48428p = Collections.emptyList();
        }
    }

    public final void N(int i10) {
        this.f48431s = i10;
        this.f48427o.m(i10);
    }

    public final boolean O() {
        return (this.f48425m == ya.g.f56663b || this.f48438z == ya.g.f56663b || j() - this.f48438z < this.f48425m) ? false : true;
    }

    public final boolean P(byte b10) {
        if (z(b10)) {
            this.f48436x = q(b10);
        }
        return this.f48436x == this.f48424l;
    }

    @Override // rc.e, qc.g
    public /* bridge */ /* synthetic */ void a(long j10) {
        super.a(j10);
    }

    @Override // rc.e
    public qc.f e() {
        List<qc.b> list = this.f48428p;
        this.f48429q = list;
        return new f((List) hd.a.g(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    @Override // rc.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(qc.i r10) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.a.f(qc.i):void");
    }

    @Override // rc.e, eb.c
    public void flush() {
        super.flush();
        this.f48428p = null;
        this.f48429q = null;
        M(0);
        N(4);
        L();
        this.f48432t = false;
        this.f48433u = false;
        this.f48434v = (byte) 0;
        this.f48435w = (byte) 0;
        this.f48436x = 0;
        this.f48437y = true;
        this.f48438z = ya.g.f56663b;
    }

    @Override // rc.e
    @p0
    /* JADX INFO: renamed from: g */
    public /* bridge */ /* synthetic */ i c() throws SubtitleDecoderException {
        return super.c();
    }

    @Override // rc.e, eb.c
    public String getName() {
        return B;
    }

    @Override // rc.e, eb.c
    @p0
    /* JADX INFO: renamed from: h */
    public j b() throws SubtitleDecoderException {
        j jVarI;
        j jVarB = super.b();
        if (jVarB != null) {
            return jVarB;
        }
        if (!O() || (jVarI = i()) == null) {
            return null;
        }
        this.f48428p = Collections.emptyList();
        this.f48438z = ya.g.f56663b;
        jVarI.q(j(), e(), Long.MAX_VALUE);
        return jVarI;
    }

    @Override // rc.e
    public boolean k() {
        return this.f48428p != this.f48429q;
    }

    @Override // rc.e
    /* JADX INFO: renamed from: l */
    public /* bridge */ /* synthetic */ void d(i iVar) throws SubtitleDecoderException {
        super.d(iVar);
    }

    public final List<qc.b> r() {
        int size = this.f48426n.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i10 = 0; i10 < size; i10++) {
            qc.b bVarG = this.f48426n.get(i10).g(Integer.MIN_VALUE);
            arrayList.add(bVarG);
            if (bVarG != null) {
                iMin = Math.min(iMin, bVarG.f47239h);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            qc.b bVar = (qc.b) arrayList.get(i11);
            if (bVar != null) {
                if (bVar.f47239h != iMin) {
                    bVar = (qc.b) hd.a.g(this.f48426n.get(i11).g(iMin));
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    @Override // rc.e, eb.c
    public void release() {
    }

    public final void w(byte b10) {
        this.f48427o.e(zc.f.f58383m);
        this.f48427o.p((b10 >> 1) & 7, (b10 & 1) == 1);
    }

    public final void x(byte b10) {
        if (b10 == 32) {
            M(2);
            return;
        }
        if (b10 == 41) {
            M(3);
            return;
        }
        switch (b10) {
            case 37:
                M(1);
                N(2);
                break;
            case 38:
                M(1);
                N(3);
                break;
            case 39:
                M(1);
                N(4);
                break;
            default:
                int i10 = this.f48430r;
                if (i10 != 0) {
                    if (b10 != 33) {
                        switch (b10) {
                            case 44:
                                this.f48428p = Collections.emptyList();
                                int i11 = this.f48430r;
                                if (i11 == 1 || i11 == 3) {
                                    L();
                                }
                                break;
                            case 45:
                                if (i10 == 1 && !this.f48427o.i()) {
                                    this.f48427o.k();
                                    break;
                                }
                                break;
                            case 46:
                                L();
                                break;
                            case 47:
                                this.f48428p = r();
                                L();
                                break;
                        }
                    } else {
                        this.f48427o.f();
                        break;
                    }
                }
                break;
        }
    }

    public final void y(byte b10, byte b11) {
        int i10 = N[b10 & 7];
        if ((b11 & 32) != 0) {
            i10++;
        }
        if (i10 != this.f48427o.f48444d) {
            if (this.f48430r != 1 && !this.f48427o.i()) {
                C0552a c0552a = new C0552a(this.f48430r, this.f48431s);
                this.f48427o = c0552a;
                this.f48426n.add(c0552a);
            }
            this.f48427o.f48444d = i10;
        }
        boolean z10 = (b11 & 16) == 16;
        boolean z11 = (b11 & 1) == 1;
        int i11 = (b11 >> 1) & 7;
        this.f48427o.p(z10 ? 8 : i11, z11);
        if (z10) {
            this.f48427o.f48445e = O[i11];
        }
    }
}
