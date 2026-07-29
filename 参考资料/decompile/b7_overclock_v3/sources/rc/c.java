package rc;

import ag.l;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import g.p0;
import hd.b0;
import hd.c0;
import hd.t;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.text.y;
import okio.w0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import qc.b;
import qc.i;
import qc.j;
import rc.c;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e {
    public static final int A = 159;
    public static final int A0 = 49;
    public static final int B = 255;
    public static final int B0 = 50;
    public static final int C = 31;
    public static final int C0 = 51;
    public static final int D = 127;
    public static final int D0 = 52;
    public static final int E = 159;
    public static final int E0 = 53;
    public static final int F = 255;
    public static final int F0 = 57;
    public static final int G = 0;
    public static final int G0 = 58;
    public static final int H = 3;
    public static final int H0 = 60;
    public static final int I = 8;
    public static final int I0 = 61;
    public static final int J = 12;
    public static final int J0 = 63;
    public static final int K = 13;
    public static final int K0 = 118;
    public static final int L = 14;
    public static final int L0 = 119;
    public static final int M = 16;
    public static final int M0 = 120;
    public static final int N = 17;
    public static final int N0 = 121;
    public static final int O = 23;
    public static final int O0 = 122;
    public static final int P = 24;
    public static final int P0 = 123;
    public static final int Q = 31;
    public static final int Q0 = 124;
    public static final int R = 128;
    public static final int R0 = 125;
    public static final int S = 129;
    public static final int S0 = 126;
    public static final int T = 130;
    public static final int T0 = 127;
    public static final int U = 131;
    public static final int V = 132;
    public static final int W = 133;
    public static final int X = 134;
    public static final int Y = 135;
    public static final int Z = 136;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f48453a0 = 137;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f48454b0 = 138;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f48455c0 = 139;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f48456d0 = 140;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f48457e0 = 141;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f48458f0 = 142;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f48459g0 = 143;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f48460h0 = 144;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f48461i0 = 145;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f48462j0 = 146;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f48463k0 = 151;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f48464l0 = 152;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f48465m0 = 153;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f48466n0 = 154;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final int f48467o0 = 155;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final int f48468p0 = 156;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final int f48469q0 = 157;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final int f48470r0 = 158;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int f48471s0 = 159;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f48472t = "Cea708Decoder";

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int f48473t0 = 127;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f48474u = 8;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final int f48475u0 = 32;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f48476v = 2;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int f48477v0 = 33;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f48478w = 3;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int f48479w0 = 37;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f48480x = 4;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final int f48481x0 = 42;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f48482y = 31;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final int f48483y0 = 44;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f48484z = 127;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final int f48485z0 = 48;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f48486i = new c0();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b0 f48487j = new b0();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f48488k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f48489l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f48490m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b[] f48491n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f48492o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public List<qc.b> f48493p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public List<qc.b> f48494q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public C0554c f48495r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f48496s;

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator<a> f48497c = new Comparator() { // from class: rc.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.a.c((c.a) obj, (c.a) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qc.b f48498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48499b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12, boolean z10, int i13, int i14) {
            b.c cVarY = new b.c().z(charSequence).A(alignment).t(f10, i10).u(i11).v(f11).w(i12).y(f12);
            if (z10) {
                cVarY.D(i13);
            }
            this.f48498a = cVarY.a();
            this.f48499b = i14;
        }

        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.f48499b, aVar.f48499b);
        }
    }

    public static final class b {
        public static final int A = 15;
        public static final int B = 0;
        public static final int C = 1;
        public static final int D = 2;
        public static final int E = 3;
        public static final int F = 0;
        public static final int G = 1;
        public static final int H = 2;
        public static final int I = 3;
        public static final int J = 0;
        public static final int K = 3;
        public static final int L = h(2, 2, 2, 0);
        public static final int M;
        public static final int N;
        public static final int O = 1;
        public static final int P = 0;
        public static final int Q = 1;
        public static final int R = 2;
        public static final int S = 3;
        public static final int T = 4;
        public static final int U = 1;
        public static final int[] V;
        public static final int[] W;
        public static final int[] X;
        public static final boolean[] Y;
        public static final int[] Z;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public static final int[] f48500a0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public static final int[] f48501b0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public static final int[] f48502c0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f48503w = 99;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f48504x = 74;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f48505y = 209;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f48506z = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<SpannableString> f48507a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SpannableStringBuilder f48508b = new SpannableStringBuilder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f48509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f48510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f48511e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f48512f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f48513g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f48514h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f48515i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f48516j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f48517k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f48518l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f48519m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f48520n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f48521o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f48522p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f48523q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f48524r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f48525s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f48526t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f48527u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f48528v;

        static {
            int iH = h(0, 0, 0, 0);
            M = iH;
            int iH2 = h(0, 0, 0, 3);
            N = iH2;
            V = new int[]{0, 0, 0, 0, 0, 2, 0};
            W = new int[]{0, 0, 0, 0, 0, 0, 2};
            X = new int[]{3, 3, 3, 3, 3, 3, 1};
            Y = new boolean[]{false, false, false, true, true, true, false};
            Z = new int[]{iH, iH2, iH, iH, iH2, iH, iH};
            f48500a0 = new int[]{0, 1, 2, 3, 4, 3, 4};
            f48501b0 = new int[]{0, 0, 0, 0, 0, 3, 3};
            f48502c0 = new int[]{iH, iH, iH, iH, iH, iH2, iH2};
        }

        public b() {
            l();
        }

        public static int g(int i10, int i11, int i12) {
            return h(i10, i11, i12, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                hd.a.c(r4, r0, r1)
                hd.a.c(r5, r0, r1)
                hd.a.c(r6, r0, r1)
                hd.a.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L21
                if (r7 == r1) goto L21
                r3 = 2
                if (r7 == r3) goto L1e
                r3 = 3
                if (r7 == r3) goto L1c
                goto L21
            L1c:
                r7 = 0
                goto L23
            L1e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L23
            L21:
                r7 = 255(0xff, float:3.57E-43)
            L23:
                if (r4 <= r1) goto L28
                r4 = 255(0xff, float:3.57E-43)
                goto L29
            L28:
                r4 = 0
            L29:
                if (r5 <= r1) goto L2e
                r5 = 255(0xff, float:3.57E-43)
                goto L2f
            L2e:
                r5 = 0
            L2f:
                if (r6 <= r1) goto L33
                r0 = 255(0xff, float:3.57E-43)
            L33:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: rc.c.b.h(int, int, int, int):int");
        }

        public void a(char c10) {
            if (c10 != '\n') {
                this.f48508b.append(c10);
                return;
            }
            this.f48507a.add(d());
            this.f48508b.clear();
            if (this.f48522p != -1) {
                this.f48522p = 0;
            }
            if (this.f48523q != -1) {
                this.f48523q = 0;
            }
            if (this.f48524r != -1) {
                this.f48524r = 0;
            }
            if (this.f48526t != -1) {
                this.f48526t = 0;
            }
            while (true) {
                if ((!this.f48517k || this.f48507a.size() < this.f48516j) && this.f48507a.size() < 15) {
                    return;
                } else {
                    this.f48507a.remove(0);
                }
            }
        }

        public void b() {
            int length = this.f48508b.length();
            if (length > 0) {
                this.f48508b.delete(length - 1, length);
            }
        }

        @p0
        public a c() {
            Layout.Alignment alignment;
            float f10;
            float f11;
            if (j()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i10 = 0; i10 < this.f48507a.size(); i10++) {
                spannableStringBuilder.append((CharSequence) this.f48507a.get(i10));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            int i11 = this.f48518l;
            if (i11 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i11 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.f48518l);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            if (this.f48512f) {
                f10 = this.f48514h / 99.0f;
                f11 = this.f48513g / 99.0f;
            } else {
                f10 = this.f48514h / 209.0f;
                f11 = this.f48513g / 74.0f;
            }
            float f12 = (f10 * 0.9f) + 0.05f;
            float f13 = (f11 * 0.9f) + 0.05f;
            int i12 = this.f48515i;
            return new a(spannableStringBuilder, alignment2, f13, 0, i12 / 3 == 0 ? 0 : i12 / 3 == 1 ? 1 : 2, f12, i12 % 3 == 0 ? 0 : i12 % 3 == 1 ? 1 : 2, -3.4028235E38f, this.f48521o != M, this.f48521o, this.f48511e);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f48508b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f48522p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f48522p, length, 33);
                }
                if (this.f48523q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f48523q, length, 33);
                }
                if (this.f48524r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f48525s), this.f48524r, length, 33);
                }
                if (this.f48526t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f48527u), this.f48526t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f48507a.clear();
            this.f48508b.clear();
            this.f48522p = -1;
            this.f48523q = -1;
            this.f48524r = -1;
            this.f48526t = -1;
            this.f48528v = 0;
        }

        public void f(boolean z10, boolean z11, boolean z12, int i10, boolean z13, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f48509c = true;
            this.f48510d = z10;
            this.f48517k = z11;
            this.f48511e = i10;
            this.f48512f = z13;
            this.f48513g = i11;
            this.f48514h = i12;
            this.f48515i = i15;
            int i18 = i13 + 1;
            if (this.f48516j != i18) {
                this.f48516j = i18;
                while (true) {
                    if ((!z11 || this.f48507a.size() < this.f48516j) && this.f48507a.size() < 15) {
                        break;
                    } else {
                        this.f48507a.remove(0);
                    }
                }
            }
            if (i16 != 0 && this.f48519m != i16) {
                this.f48519m = i16;
                int i19 = i16 - 1;
                q(Z[i19], N, Y[i19], 0, W[i19], X[i19], V[i19]);
            }
            if (i17 == 0 || this.f48520n == i17) {
                return;
            }
            this.f48520n = i17;
            int i20 = i17 - 1;
            m(0, 1, 1, false, false, f48501b0[i20], f48500a0[i20]);
            n(L, f48502c0[i20], M);
        }

        public boolean i() {
            return this.f48509c;
        }

        public boolean j() {
            return !i() || (this.f48507a.isEmpty() && this.f48508b.length() == 0);
        }

        public boolean k() {
            return this.f48510d;
        }

        public void l() {
            e();
            this.f48509c = false;
            this.f48510d = false;
            this.f48511e = 4;
            this.f48512f = false;
            this.f48513g = 0;
            this.f48514h = 0;
            this.f48515i = 0;
            this.f48516j = 15;
            this.f48517k = true;
            this.f48518l = 0;
            this.f48519m = 0;
            this.f48520n = 0;
            int i10 = M;
            this.f48521o = i10;
            this.f48525s = L;
            this.f48527u = i10;
        }

        public void m(int i10, int i11, int i12, boolean z10, boolean z11, int i13, int i14) {
            if (this.f48522p != -1) {
                if (!z10) {
                    this.f48508b.setSpan(new StyleSpan(2), this.f48522p, this.f48508b.length(), 33);
                    this.f48522p = -1;
                }
            } else if (z10) {
                this.f48522p = this.f48508b.length();
            }
            if (this.f48523q == -1) {
                if (z11) {
                    this.f48523q = this.f48508b.length();
                }
            } else {
                if (z11) {
                    return;
                }
                this.f48508b.setSpan(new UnderlineSpan(), this.f48523q, this.f48508b.length(), 33);
                this.f48523q = -1;
            }
        }

        public void n(int i10, int i11, int i12) {
            if (this.f48524r != -1 && this.f48525s != i10) {
                this.f48508b.setSpan(new ForegroundColorSpan(this.f48525s), this.f48524r, this.f48508b.length(), 33);
            }
            if (i10 != L) {
                this.f48524r = this.f48508b.length();
                this.f48525s = i10;
            }
            if (this.f48526t != -1 && this.f48527u != i11) {
                this.f48508b.setSpan(new BackgroundColorSpan(this.f48527u), this.f48526t, this.f48508b.length(), 33);
            }
            if (i11 != M) {
                this.f48526t = this.f48508b.length();
                this.f48527u = i11;
            }
        }

        public void o(int i10, int i11) {
            if (this.f48528v != i10) {
                a('\n');
            }
            this.f48528v = i10;
        }

        public void p(boolean z10) {
            this.f48510d = z10;
        }

        public void q(int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
            this.f48521o = i10;
            this.f48518l = i15;
        }
    }

    /* JADX INFO: renamed from: rc.c$c, reason: collision with other inner class name */
    public static final class C0554c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f48529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f48531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f48532d = 0;

        public C0554c(int i10, int i11) {
            this.f48529a = i10;
            this.f48530b = i11;
            this.f48531c = new byte[(i11 * 2) - 1];
        }
    }

    public c(int i10, @p0 List<byte[]> list) {
        this.f48490m = i10 == -1 ? 1 : i10;
        this.f48489l = list != null && hd.d.h(list);
        this.f48491n = new b[8];
        for (int i11 = 0; i11 < 8; i11++) {
            this.f48491n[i11] = new b();
        }
        this.f48492o = this.f48491n[0];
    }

    public final void A() {
        int iH = b.h(this.f48487j.h(2), this.f48487j.h(2), this.f48487j.h(2), this.f48487j.h(2));
        int iH2 = b.h(this.f48487j.h(2), this.f48487j.h(2), this.f48487j.h(2), this.f48487j.h(2));
        this.f48487j.s(2);
        this.f48492o.n(iH, iH2, b.g(this.f48487j.h(2), this.f48487j.h(2), this.f48487j.h(2)));
    }

    public final void B() {
        this.f48487j.s(4);
        int iH = this.f48487j.h(4);
        this.f48487j.s(2);
        this.f48492o.o(iH, this.f48487j.h(6));
    }

    public final void C() {
        int iH = b.h(this.f48487j.h(2), this.f48487j.h(2), this.f48487j.h(2), this.f48487j.h(2));
        int iH2 = this.f48487j.h(2);
        int iG = b.g(this.f48487j.h(2), this.f48487j.h(2), this.f48487j.h(2));
        if (this.f48487j.g()) {
            iH2 |= 4;
        }
        boolean zG = this.f48487j.g();
        int iH3 = this.f48487j.h(2);
        int iH4 = this.f48487j.h(2);
        int iH5 = this.f48487j.h(2);
        this.f48487j.s(8);
        this.f48492o.q(iH, iG, zG, iH2, iH3, iH4, iH5);
    }

    @RequiresNonNull({"currentDtvCcPacket"})
    public final void D() {
        C0554c c0554c = this.f48495r;
        if (c0554c.f48532d != (c0554c.f48530b * 2) - 1) {
            t.b(f48472t, "DtvCcPacket ended prematurely; size is " + ((this.f48495r.f48530b * 2) - 1) + ", but current index is " + this.f48495r.f48532d + " (sequence number " + this.f48495r.f48529a + ");");
        }
        b0 b0Var = this.f48487j;
        C0554c c0554c2 = this.f48495r;
        b0Var.p(c0554c2.f48531c, c0554c2.f48532d);
        int iH = this.f48487j.h(3);
        int iH2 = this.f48487j.h(5);
        if (iH == 7) {
            this.f48487j.s(2);
            iH = this.f48487j.h(6);
            if (iH < 7) {
                t.n(f48472t, "Invalid extended service number: " + iH);
            }
        }
        if (iH2 == 0) {
            if (iH != 0) {
                t.n(f48472t, "serviceNumber is non-zero (" + iH + ") when blockSize is 0");
                return;
            }
            return;
        }
        if (iH != this.f48490m) {
            return;
        }
        boolean z10 = false;
        while (this.f48487j.b() > 0) {
            int iH3 = this.f48487j.h(8);
            if (iH3 == 16) {
                int iH4 = this.f48487j.h(8);
                if (iH4 <= 31) {
                    s(iH4);
                } else {
                    if (iH4 <= 127) {
                        x(iH4);
                    } else if (iH4 <= 159) {
                        t(iH4);
                    } else if (iH4 <= 255) {
                        y(iH4);
                    } else {
                        t.n(f48472t, "Invalid extended command: " + iH4);
                    }
                    z10 = true;
                }
            } else if (iH3 <= 31) {
                q(iH3);
            } else {
                if (iH3 <= 127) {
                    v(iH3);
                } else if (iH3 <= 159) {
                    r(iH3);
                } else if (iH3 <= 255) {
                    w(iH3);
                } else {
                    t.n(f48472t, "Invalid base command: " + iH3);
                }
                z10 = true;
            }
        }
        if (z10) {
            this.f48493p = p();
        }
    }

    public final void E() {
        for (int i10 = 0; i10 < 8; i10++) {
            this.f48491n[i10].l();
        }
    }

    @Override // rc.e, qc.g
    public /* bridge */ /* synthetic */ void a(long j10) {
        super.a(j10);
    }

    @Override // rc.e
    public qc.f e() {
        List<qc.b> list = this.f48493p;
        this.f48494q = list;
        return new f((List) hd.a.g(list));
    }

    @Override // rc.e
    public void f(i iVar) {
        ByteBuffer byteBuffer = (ByteBuffer) hd.a.g(iVar.f16960c);
        this.f48486i.Q(byteBuffer.array(), byteBuffer.limit());
        while (this.f48486i.a() >= 3) {
            int iG = this.f48486i.G() & 7;
            int i10 = iG & 3;
            boolean z10 = (iG & 4) == 4;
            byte bG = (byte) this.f48486i.G();
            byte bG2 = (byte) this.f48486i.G();
            if (i10 == 2 || i10 == 3) {
                if (z10) {
                    if (i10 == 3) {
                        o();
                        int i11 = (bG & i1.a.f31667o7) >> 6;
                        int i12 = this.f48488k;
                        if (i12 != -1 && i11 != (i12 + 1) % 4) {
                            E();
                            t.n(f48472t, "Sequence number discontinuity. previous=" + this.f48488k + " current=" + i11);
                        }
                        this.f48488k = i11;
                        int i13 = bG & w0.f44229a;
                        if (i13 == 0) {
                            i13 = 64;
                        }
                        C0554c c0554c = new C0554c(i11, i13);
                        this.f48495r = c0554c;
                        byte[] bArr = c0554c.f48531c;
                        int i14 = c0554c.f48532d;
                        c0554c.f48532d = i14 + 1;
                        bArr[i14] = bG2;
                    } else {
                        hd.a.a(i10 == 2);
                        C0554c c0554c2 = this.f48495r;
                        if (c0554c2 == null) {
                            t.d(f48472t, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0554c2.f48531c;
                            int i15 = c0554c2.f48532d;
                            int i16 = i15 + 1;
                            c0554c2.f48532d = i16;
                            bArr2[i15] = bG;
                            c0554c2.f48532d = i16 + 1;
                            bArr2[i16] = bG2;
                        }
                    }
                    C0554c c0554c3 = this.f48495r;
                    if (c0554c3.f48532d == (c0554c3.f48530b * 2) - 1) {
                        o();
                    }
                }
            }
        }
    }

    @Override // rc.e, eb.c
    public void flush() {
        super.flush();
        this.f48493p = null;
        this.f48494q = null;
        this.f48496s = 0;
        this.f48492o = this.f48491n[0];
        E();
        this.f48495r = null;
    }

    @Override // rc.e
    @p0
    /* JADX INFO: renamed from: g */
    public /* bridge */ /* synthetic */ i c() throws SubtitleDecoderException {
        return super.c();
    }

    @Override // rc.e, eb.c
    public String getName() {
        return f48472t;
    }

    @Override // rc.e
    @p0
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ j b() throws SubtitleDecoderException {
        return super.b();
    }

    @Override // rc.e
    public boolean k() {
        return this.f48493p != this.f48494q;
    }

    @Override // rc.e
    /* JADX INFO: renamed from: l */
    public /* bridge */ /* synthetic */ void d(i iVar) throws SubtitleDecoderException {
        super.d(iVar);
    }

    public final void o() {
        if (this.f48495r == null) {
            return;
        }
        D();
        this.f48495r = null;
    }

    public final List<qc.b> p() {
        a aVarC;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 8; i10++) {
            if (!this.f48491n[i10].j() && this.f48491n[i10].k() && (aVarC = this.f48491n[i10].c()) != null) {
                arrayList.add(aVarC);
            }
        }
        Collections.sort(arrayList, a.f48497c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList2.add(((a) arrayList.get(i11)).f48498a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public final void q(int i10) {
        if (i10 != 0) {
            if (i10 == 3) {
                this.f48493p = p();
            }
            if (i10 == 8) {
                this.f48492o.b();
                return;
            }
            switch (i10) {
                case 12:
                    E();
                    break;
                case 13:
                    this.f48492o.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i10 >= 17 && i10 <= 23) {
                        t.n(f48472t, "Currently unsupported COMMAND_EXT1 Command: " + i10);
                        this.f48487j.s(8);
                    } else if (i10 >= 24 && i10 <= 31) {
                        t.n(f48472t, "Currently unsupported COMMAND_P16 Command: " + i10);
                        this.f48487j.s(16);
                    } else {
                        t.n(f48472t, "Invalid C0 command: " + i10);
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void r(int i10) {
        int i11 = 1;
        switch (i10) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i12 = i10 - 128;
                if (this.f48496s != i12) {
                    this.f48496s = i12;
                    this.f48492o = this.f48491n[i12];
                }
                break;
            case 136:
                while (i11 <= 8) {
                    if (this.f48487j.g()) {
                        this.f48491n[8 - i11].e();
                    }
                    i11++;
                }
                break;
            case 137:
                for (int i13 = 1; i13 <= 8; i13++) {
                    if (this.f48487j.g()) {
                        this.f48491n[8 - i13].p(true);
                    }
                }
                break;
            case 138:
                while (i11 <= 8) {
                    if (this.f48487j.g()) {
                        this.f48491n[8 - i11].p(false);
                    }
                    i11++;
                }
                break;
            case 139:
                for (int i14 = 1; i14 <= 8; i14++) {
                    if (this.f48487j.g()) {
                        this.f48491n[8 - i14].p(!r0.k());
                    }
                }
                break;
            case 140:
                while (i11 <= 8) {
                    if (this.f48487j.g()) {
                        this.f48491n[8 - i11].l();
                    }
                    i11++;
                }
                break;
            case 141:
                this.f48487j.s(8);
                break;
            case 142:
                break;
            case 143:
                E();
                break;
            case 144:
                if (this.f48492o.i()) {
                    z();
                } else {
                    this.f48487j.s(16);
                }
                break;
            case 145:
                if (this.f48492o.i()) {
                    A();
                } else {
                    this.f48487j.s(24);
                }
                break;
            case 146:
                if (this.f48492o.i()) {
                    B();
                } else {
                    this.f48487j.s(16);
                }
                break;
            case uf.c.Ya /* 147 */:
            case com.google.zxing.oned.d.f21430g /* 148 */:
            case WaspWingInfo.COLD_LEVEL_STANDARD_B7 /* 149 */:
            case 150:
            default:
                t.n(f48472t, "Invalid C1 command: " + i10);
                break;
            case f48463k0 /* 151 */:
                if (this.f48492o.i()) {
                    C();
                } else {
                    this.f48487j.s(32);
                }
                break;
            case f48464l0 /* 152 */:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i15 = i10 - 152;
                u(i15);
                if (this.f48496s != i15) {
                    this.f48496s = i15;
                    this.f48492o = this.f48491n[i15];
                }
                break;
        }
    }

    @Override // rc.e, eb.c
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public final void s(int i10) {
        if (i10 <= 7) {
            return;
        }
        if (i10 <= 15) {
            this.f48487j.s(8);
        } else if (i10 <= 23) {
            this.f48487j.s(16);
        } else if (i10 <= 31) {
            this.f48487j.s(24);
        }
    }

    public final void t(int i10) {
        if (i10 <= 135) {
            this.f48487j.s(32);
            return;
        }
        if (i10 <= 143) {
            this.f48487j.s(40);
        } else if (i10 <= 159) {
            this.f48487j.s(2);
            this.f48487j.s(this.f48487j.h(6) * 8);
        }
    }

    public final void u(int i10) {
        b bVar = this.f48491n[i10];
        this.f48487j.s(2);
        boolean zG = this.f48487j.g();
        boolean zG2 = this.f48487j.g();
        boolean zG3 = this.f48487j.g();
        int iH = this.f48487j.h(3);
        boolean zG4 = this.f48487j.g();
        int iH2 = this.f48487j.h(7);
        int iH3 = this.f48487j.h(8);
        int iH4 = this.f48487j.h(4);
        int iH5 = this.f48487j.h(4);
        this.f48487j.s(2);
        int iH6 = this.f48487j.h(6);
        this.f48487j.s(2);
        bVar.f(zG, zG2, zG3, iH, zG4, iH2, iH3, iH5, iH6, iH4, this.f48487j.h(3), this.f48487j.h(3));
    }

    public final void v(int i10) {
        if (i10 == 127) {
            this.f48492o.a((char) 9835);
        } else {
            this.f48492o.a((char) (i10 & 255));
        }
    }

    public final void w(int i10) {
        this.f48492o.a((char) (i10 & 255));
    }

    public final void x(int i10) {
        if (i10 == 32) {
            this.f48492o.a(zc.f.f58383m);
        }
        if (i10 == 33) {
            this.f48492o.a(y.f38193g);
            return;
        }
        if (i10 == 37) {
            this.f48492o.a(y.F);
            return;
        }
        if (i10 == 42) {
            this.f48492o.a((char) 352);
            return;
        }
        if (i10 == 44) {
            this.f48492o.a((char) 338);
            return;
        }
        if (i10 == 63) {
            this.f48492o.a((char) 376);
            return;
        }
        if (i10 == 57) {
            this.f48492o.a(y.J);
            return;
        }
        if (i10 == 58) {
            this.f48492o.a((char) 353);
            return;
        }
        if (i10 == 60) {
            this.f48492o.a((char) 339);
            return;
        }
        if (i10 == 61) {
            this.f48492o.a((char) 8480);
            return;
        }
        switch (i10) {
            case 48:
                this.f48492o.a((char) 9608);
                break;
            case 49:
                this.f48492o.a(y.f38209w);
                break;
            case 50:
                this.f48492o.a(y.f38210x);
                break;
            case 51:
                this.f48492o.a(y.f38212z);
                break;
            case 52:
                this.f48492o.a(y.A);
                break;
            case 53:
                this.f48492o.a(y.E);
                break;
            default:
                switch (i10) {
                    case 118:
                        this.f48492o.a((char) 8539);
                        break;
                    case 119:
                        this.f48492o.a((char) 8540);
                        break;
                    case 120:
                        this.f48492o.a((char) 8541);
                        break;
                    case 121:
                        this.f48492o.a((char) 8542);
                        break;
                    case 122:
                        this.f48492o.a(l.f684k);
                        break;
                    case 123:
                        this.f48492o.a((char) 9488);
                        break;
                    case 124:
                        this.f48492o.a(l.f682i);
                        break;
                    case 125:
                        this.f48492o.a((char) 9472);
                        break;
                    case 126:
                        this.f48492o.a((char) 9496);
                        break;
                    case 127:
                        this.f48492o.a(l.f681h);
                        break;
                    default:
                        t.n(f48472t, "Invalid G2 character: " + i10);
                        break;
                }
                break;
        }
    }

    public final void y(int i10) {
        if (i10 == 160) {
            this.f48492o.a((char) 13252);
            return;
        }
        t.n(f48472t, "Invalid G3 character: " + i10);
        this.f48492o.a('_');
    }

    public final void z() {
        this.f48492o.m(this.f48487j.h(4), this.f48487j.h(2), this.f48487j.h(2), this.f48487j.g(), this.f48487j.g(), this.f48487j.h(3), this.f48487j.h(3));
    }
}
