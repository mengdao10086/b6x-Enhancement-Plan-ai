package mb;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import g.i;
import g.p0;
import hb.a0;
import hb.d0;
import hb.k;
import hb.m;
import hb.p;
import hb.q;
import hb.z;
import hd.c0;
import hd.t;
import hd.u;
import hd.u0;
import hd.w;
import hd.y;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import jt.l;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public class e implements k {
    public static final String A0 = "A_AAC";
    public static final int A1 = 21930;
    public static final int A2 = 21968;
    public static final String B0 = "A_MPEG/L2";
    public static final int B1 = 2352003;
    public static final int B2 = 21969;
    public static final String C0 = "A_MPEG/L3";
    public static final int C1 = 21998;
    public static final int C2 = 21970;
    public static final String D0 = "A_AC3";
    public static final int D1 = 16868;
    public static final int D2 = 21971;
    public static final String E0 = "A_EAC3";
    public static final int E1 = 16871;
    public static final int E2 = 21972;
    public static final String F0 = "A_TRUEHD";
    public static final int F1 = 16877;
    public static final int F2 = 21973;
    public static final String G0 = "A_DTS";
    public static final int G1 = 21358;
    public static final int G2 = 21974;
    public static final String H0 = "A_DTS/EXPRESS";
    public static final int H1 = 134;
    public static final int H2 = 21975;
    public static final String I0 = "A_DTS/LOSSLESS";
    public static final int I1 = 25506;
    public static final int I2 = 21976;
    public static final String J0 = "A_FLAC";
    public static final int J1 = 22186;
    public static final int J2 = 21977;
    public static final String K0 = "A_MS/ACM";
    public static final int K1 = 22203;
    public static final int K2 = 21978;
    public static final String L0 = "A_PCM/INT/LIT";
    public static final int L1 = 224;
    public static final int L2 = 4;
    public static final String M0 = "A_PCM/INT/BIG";
    public static final int M1 = 176;
    public static final int M2 = 1685480259;
    public static final String N0 = "A_PCM/FLOAT/IEEE";
    public static final int N1 = 186;
    public static final int N2 = 1685485123;
    public static final String O0 = "S_TEXT/UTF8";
    public static final int O1 = 21680;
    public static final int O2 = 0;
    public static final String P0 = "S_TEXT/ASS";
    public static final int P1 = 21690;
    public static final int P2 = 1;
    public static final String Q0 = "S_VOBSUB";
    public static final int Q1 = 21682;
    public static final int Q2 = 2;
    public static final String R0 = "S_HDMV/PGS";
    public static final int R1 = 225;
    public static final int R2 = 3;
    public static final String S0 = "S_DVBSUB";
    public static final int S1 = 159;
    public static final int S2 = 1482049860;
    public static final int T0 = 8192;
    public static final int T1 = 25188;
    public static final int T2 = 859189832;
    public static final int U0 = 5760;
    public static final int U1 = 181;
    public static final int U2 = 826496599;
    public static final int V0 = 8;
    public static final int V1 = 28032;
    public static final int W0 = 2;
    public static final int W1 = 25152;
    public static final int W2 = 19;
    public static final int X0 = 440786851;
    public static final int X1 = 20529;
    public static final long X2 = 1000;
    public static final int Y0 = 17143;
    public static final int Y1 = 20530;
    public static final String Y2 = "%02d:%02d:%02d,%03d";
    public static final int Z0 = 17026;
    public static final int Z1 = 20532;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final int f41001a1 = 17029;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public static final int f41002a2 = 16980;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final int f41004b1 = 408125543;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public static final int f41005b2 = 16981;

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public static final int f41006b3 = 21;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final int f41007c1 = 357149030;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public static final int f41008c2 = 20533;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public static final long f41009c3 = 10000;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final int f41010d1 = 290298740;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public static final int f41011d2 = 18401;

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public static final String f41012d3 = "%01d:%02d:%02d:%02d";

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final int f41014e1 = 19899;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public static final int f41015e2 = 18402;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public static final int f41016e3 = 18;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f41017f0 = 1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final int f41018f1 = 21419;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public static final int f41019f2 = 18407;

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public static final int f41020f3 = 65534;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f41021g0 = "MatroskaExtractor";

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final int f41022g1 = 21420;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final int f41023g2 = 18408;

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public static final int f41024g3 = 1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f41025h0 = -1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final int f41026h1 = 357149030;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final int f41027h2 = 475249515;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f41029i0 = 0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final int f41030i1 = 2807729;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    public static final int f41031i2 = 187;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public static final Map<String, Integer> f41032i3;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f41033j0 = 1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final int f41034j1 = 17545;

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public static final int f41035j2 = 179;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f41036k0 = 2;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f41037k1 = 524531317;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    public static final int f41038k2 = 183;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f41039l0 = "matroska";

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final int f41040l1 = 231;

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    public static final int f41041l2 = 241;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f41042m0 = "webm";

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final int f41043m1 = 163;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    public static final int f41044m2 = 2274716;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f41045n0 = "V_VP8";

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final int f41046n1 = 160;

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public static final int f41047n2 = 30320;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f41048o0 = "V_VP9";

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final int f41049o1 = 161;

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    public static final int f41050o2 = 30321;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f41051p0 = "V_AV1";

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final int f41052p1 = 155;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final int f41053p2 = 30322;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f41054q0 = "V_MPEG2";

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final int f41055q1 = 30113;

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    public static final int f41056q2 = 30323;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f41057r0 = "V_MPEG4/ISO/SP";

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final int f41058r1 = 166;

    /* JADX INFO: renamed from: r2, reason: collision with root package name */
    public static final int f41059r2 = 30324;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f41060s0 = "V_MPEG4/ISO/ASP";

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final int f41061s1 = 238;

    /* JADX INFO: renamed from: s2, reason: collision with root package name */
    public static final int f41062s2 = 30325;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f41063t0 = "V_MPEG4/ISO/AP";

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final int f41064t1 = 165;

    /* JADX INFO: renamed from: t2, reason: collision with root package name */
    public static final int f41065t2 = 21432;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f41066u0 = "V_MPEG4/ISO/AVC";

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final int f41067u1 = 251;

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    public static final int f41068u2 = 21936;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f41069v0 = "V_MPEGH/ISO/HEVC";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f41070v1 = 374648427;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f41071v2 = 21945;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f41072w0 = "V_MS/VFW/FOURCC";

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final int f41073w1 = 174;

    /* JADX INFO: renamed from: w2, reason: collision with root package name */
    public static final int f41074w2 = 21946;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f41075x0 = "V_THEORA";

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final int f41076x1 = 215;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final int f41077x2 = 21947;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final String f41078y0 = "A_VORBIS";

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final int f41079y1 = 131;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final int f41080y2 = 21948;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f41081z0 = "A_OPUS";

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static final int f41082z1 = 136;

    /* JADX INFO: renamed from: z2, reason: collision with root package name */
    public static final int f41083z2 = 21949;
    public long A;
    public boolean B;
    public long C;
    public long D;
    public long E;

    @p0
    public u F;

    @p0
    public u G;
    public boolean H;
    public boolean I;
    public int J;
    public long K;
    public long L;
    public int M;
    public int N;
    public int[] O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public boolean T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f41084a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public byte f41085b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f41086c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final mb.c f41087d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public m f41088d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f41089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<d> f41090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f41091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0 f41092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f41093i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f41094j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0 f41095k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0 f41096l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0 f41097m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c0 f41098n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f41099o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0 f41100p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c0 f41101q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ByteBuffer f41102r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f41103s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f41104t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f41105u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f41106v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f41107w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public d f41108x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f41109y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f41110z;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final q f41013e0 = new q() { // from class: mb.d
        @Override // hb.q
        public final k[] a() {
            return e.A();
        }

        @Override // hb.q
        public /* synthetic */ k[] b(Uri uri, Map map) {
            return p.a(this, uri, map);
        }
    };
    public static final byte[] V2 = {49, 10, l.f36949q, l.f36949q, 58, l.f36949q, l.f36949q, 58, l.f36949q, l.f36949q, rc.a.f48412d0, l.f36949q, l.f36949q, l.f36949q, 32, rc.a.f48413e0, rc.a.f48413e0, 62, 32, l.f36949q, l.f36949q, 58, l.f36949q, l.f36949q, 58, l.f36949q, l.f36949q, rc.a.f48412d0, l.f36949q, l.f36949q, l.f36949q, 10};
    public static final byte[] Z2 = u0.w0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public static final byte[] f41003a3 = {68, 105, 97, 108, pq.b.f46991h, 103, 117, 101, 58, 32, l.f36949q, 58, l.f36949q, l.f36949q, 58, l.f36949q, l.f36949q, 58, l.f36949q, l.f36949q, rc.a.f48412d0, l.f36949q, 58, l.f36949q, l.f36949q, 58, l.f36949q, l.f36949q, 58, l.f36949q, l.f36949q, rc.a.f48412d0};

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final UUID f41028h3 = new UUID(72057594037932032L, -9223371306706625679L);

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public final class c implements mb.b {
        public c() {
        }

        @Override // mb.b
        public void a(int i10) throws ParserException {
            e.this.o(i10);
        }

        @Override // mb.b
        public int b(int i10) {
            return e.this.u(i10);
        }

        @Override // mb.b
        public boolean c(int i10) {
            return e.this.z(i10);
        }

        @Override // mb.b
        public void d(int i10, String str) throws ParserException {
            e.this.H(i10, str);
        }

        @Override // mb.b
        public void e(int i10, double d10) throws ParserException {
            e.this.r(i10, d10);
        }

        @Override // mb.b
        public void f(int i10, int i11, hb.l lVar) throws IOException {
            e.this.l(i10, i11, lVar);
        }

        @Override // mb.b
        public void g(int i10, long j10, long j11) throws ParserException {
            e.this.G(i10, j10, j11);
        }

        @Override // mb.b
        public void h(int i10, long j10) throws ParserException {
            e.this.x(i10, j10);
        }
    }

    public static final class d {
        public static final int Z = 0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public static final int f41112a0 = 50000;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public static final int f41113b0 = 1000;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public static final int f41114c0 = 200;
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public float M;
        public byte[] N;
        public int O;
        public int P;
        public int Q;
        public long R;
        public long S;
        public C0455e T;
        public boolean U;
        public boolean V;
        public String W;
        public d0 X;
        public int Y;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f41115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f41116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f41118d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f41119e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f41120f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f41121g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f41122h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f41123i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public d0.a f41124j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public byte[] f41125k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public DrmInitData f41126l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f41127m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f41128n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f41129o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f41130p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f41131q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f41132r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f41133s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f41134t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f41135u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public byte[] f41136v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f41137w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f41138x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f41139y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f41140z;

        public d() {
            this.f41127m = -1;
            this.f41128n = -1;
            this.f41129o = -1;
            this.f41130p = -1;
            this.f41131q = 0;
            this.f41132r = -1;
            this.f41133s = 0.0f;
            this.f41134t = 0.0f;
            this.f41135u = 0.0f;
            this.f41136v = null;
            this.f41137w = -1;
            this.f41138x = false;
            this.f41139y = -1;
            this.f41140z = -1;
            this.A = -1;
            this.B = 1000;
            this.C = 200;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = -1.0f;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = -1.0f;
            this.O = 1;
            this.P = -1;
            this.Q = 8000;
            this.R = 0L;
            this.S = 0L;
            this.V = true;
            this.W = "eng";
        }

        public static Pair<String, List<byte[]>> j(c0 c0Var) throws ParserException {
            try {
                c0Var.T(16);
                long jV = c0Var.v();
                if (jV == 1482049860) {
                    return new Pair<>(w.f31212u, null);
                }
                if (jV == 859189832) {
                    return new Pair<>(w.f31188i, null);
                }
                if (jV != 826496599) {
                    t.n(e.f41021g0, "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>(w.f31220y, null);
                }
                byte[] bArrD = c0Var.d();
                for (int iE = c0Var.e() + 20; iE < bArrD.length - 4; iE++) {
                    if (bArrD[iE] == 0 && bArrD[iE + 1] == 0 && bArrD[iE + 2] == 1 && bArrD[iE + 3] == 15) {
                        return new Pair<>(w.f31210t, Collections.singletonList(Arrays.copyOfRange(bArrD, iE, bArrD.length)));
                    }
                }
                throw new ParserException("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        public static boolean k(c0 c0Var) throws ParserException {
            try {
                int iY = c0Var.y();
                if (iY == 1) {
                    return true;
                }
                if (iY != 65534) {
                    return false;
                }
                c0Var.S(24);
                if (c0Var.z() == e.f41028h3.getMostSignificantBits()) {
                    if (c0Var.z() == e.f41028h3.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        public static List<byte[]> l(byte[] bArr) throws ParserException {
            try {
                if (bArr[0] != 2) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i10 = 1;
                int i11 = 0;
                while ((bArr[i10] & 255) == 255) {
                    i11 += 255;
                    i10++;
                }
                int i12 = i10 + 1;
                int i13 = i11 + (bArr[i10] & 255);
                int i14 = 0;
                while ((bArr[i12] & 255) == 255) {
                    i14 += 255;
                    i12++;
                }
                int i15 = i12 + 1;
                int i16 = i14 + (bArr[i12] & 255);
                if (bArr[i15] != 1) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr2 = new byte[i13];
                System.arraycopy(bArr, i15, bArr2, 0, i13);
                int i17 = i15 + i13;
                if (bArr[i17] != 3) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i18 = i17 + i16;
                if (bArr[i18] != 5) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr3 = new byte[bArr.length - i18];
                System.arraycopy(bArr, i18, bArr3, 0, bArr.length - i18);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        @EnsuresNonNull({"output"})
        public final void e() {
            hd.a.g(this.X);
        }

        @EnsuresNonNull({"codecPrivate"})
        public final byte[] f(String str) throws ParserException {
            byte[] bArr = this.f41125k;
            if (bArr != null) {
                return bArr;
            }
            throw new ParserException("Missing CodecPrivate for codec " + str);
        }

        @p0
        public final byte[] g() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.D * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.E * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.F * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.G * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.H * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.I * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.J * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.K * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.L + 0.5f));
            byteBufferOrder.putShort((short) (this.M + 0.5f));
            byteBufferOrder.putShort((short) this.B);
            byteBufferOrder.putShort((short) this.C);
            return bArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:196:0x0443  */
        /* JADX WARN: Removed duplicated region for block: B:201:0x045b  */
        /* JADX WARN: Removed duplicated region for block: B:202:0x045d  */
        /* JADX WARN: Removed duplicated region for block: B:205:0x046a  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x047c  */
        /* JADX WARN: Removed duplicated region for block: B:253:0x0534  */
        /* JADX WARN: Removed duplicated region for block: B:270:0x0587  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0015  */
        @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
        @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h(hb.m r21, int r22) throws com.google.android.exoplayer2.ParserException {
            /*
                Method dump skipped, instruction units count: 1686
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: mb.e.d.h(hb.m, int):void");
        }

        @RequiresNonNull({"output"})
        public void i() {
            C0455e c0455e = this.T;
            if (c0455e != null) {
                c0455e.a(this);
            }
        }

        public void m() {
            C0455e c0455e = this.T;
            if (c0455e != null) {
                c0455e.b();
            }
        }
    }

    /* JADX INFO: renamed from: mb.e$e, reason: collision with other inner class name */
    public static final class C0455e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f41141a = new byte[10];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f41142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f41144d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f41145e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f41146f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f41147g;

        @RequiresNonNull({"#1.output"})
        public void a(d dVar) {
            if (this.f41143c > 0) {
                dVar.X.a(this.f41144d, this.f41145e, this.f41146f, this.f41147g, dVar.f41124j);
                this.f41143c = 0;
            }
        }

        public void b() {
            this.f41142b = false;
            this.f41143c = 0;
        }

        @RequiresNonNull({"#1.output"})
        public void c(d dVar, long j10, int i10, int i11, int i12) {
            if (this.f41142b) {
                int i13 = this.f41143c;
                int i14 = i13 + 1;
                this.f41143c = i14;
                if (i13 == 0) {
                    this.f41144d = j10;
                    this.f41145e = i10;
                    this.f41146f = 0;
                }
                this.f41146f += i11;
                this.f41147g = i12;
                if (i14 >= 16) {
                    a(dVar);
                }
            }
        }

        public void d(hb.l lVar) throws IOException {
            if (this.f41142b) {
                return;
            }
            lVar.t(this.f41141a, 0, 10);
            lVar.n();
            if (ab.b.i(this.f41141a) == 0) {
                return;
            }
            this.f41142b = true;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        f41032i3 = Collections.unmodifiableMap(map);
    }

    public e() {
        this(0);
    }

    public static /* synthetic */ k[] A() {
        return new k[]{new e()};
    }

    public static void F(String str, long j10, byte[] bArr) {
        byte[] bArrS;
        int i10;
        str.hashCode();
        if (str.equals(P0)) {
            bArrS = s(j10, f41012d3, 10000L);
            i10 = 21;
        } else {
            if (!str.equals(O0)) {
                throw new IllegalArgumentException();
            }
            bArrS = s(j10, Y2, 1000L);
            i10 = 19;
        }
        System.arraycopy(bArrS, 0, bArr, i10, bArrS.length);
    }

    public static int[] p(@p0 int[] iArr, int i10) {
        return iArr == null ? new int[i10] : iArr.length >= i10 ? iArr : new int[Math.max(iArr.length * 2, i10)];
    }

    public static byte[] s(long j10, String str, long j11) {
        hd.a.a(j10 != ya.g.f56663b);
        int i10 = (int) (j10 / 3600000000L);
        long j12 = j10 - (((long) (i10 * 3600)) * 1000000);
        int i11 = (int) (j12 / 60000000);
        long j13 = j12 - (((long) (i11 * 60)) * 1000000);
        int i12 = (int) (j13 / 1000000);
        return u0.w0(String.format(Locale.US, str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf((int) ((j13 - (((long) i12) * 1000000)) / j11))));
    }

    public static boolean y(String str) {
        str.hashCode();
        switch (str) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                return true;
            default:
                return false;
        }
    }

    public final boolean B(z zVar, long j10) {
        if (this.B) {
            this.D = j10;
            zVar.f30930a = this.C;
            this.B = false;
            return true;
        }
        if (this.f41109y) {
            long j11 = this.D;
            if (j11 != -1) {
                zVar.f30930a = j11;
                this.D = -1L;
                return true;
            }
        }
        return false;
    }

    public final void C(hb.l lVar, int i10) throws IOException {
        if (this.f41094j.f() >= i10) {
            return;
        }
        if (this.f41094j.b() < i10) {
            c0 c0Var = this.f41094j;
            c0Var.c(Math.max(c0Var.b() * 2, i10));
        }
        lVar.readFully(this.f41094j.d(), this.f41094j.f(), i10 - this.f41094j.f());
        this.f41094j.R(i10);
    }

    public final void D() {
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f41084a0 = 0;
        this.f41085b0 = (byte) 0;
        this.f41086c0 = false;
        this.f41097m.O(0);
    }

    public final long E(long j10) throws ParserException {
        long j11 = this.f41105u;
        if (j11 != ya.g.f56663b) {
            return u0.h1(j10, j11, 1000L);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    @i
    public void G(int i10, long j10, long j11) throws ParserException {
        k();
        if (i10 == 160) {
            this.T = false;
            return;
        }
        if (i10 == 174) {
            this.f41108x = new d();
            return;
        }
        if (i10 == 187) {
            this.H = false;
            return;
        }
        if (i10 == 19899) {
            this.f41110z = -1;
            this.A = -1L;
            return;
        }
        if (i10 == 20533) {
            t(i10).f41122h = true;
            return;
        }
        if (i10 == 21968) {
            t(i10).f41138x = true;
            return;
        }
        if (i10 == 408125543) {
            long j12 = this.f41104t;
            if (j12 != -1 && j12 != j10) {
                throw new ParserException("Multiple Segment elements not supported");
            }
            this.f41104t = j10;
            this.f41103s = j11;
            return;
        }
        if (i10 == 475249515) {
            this.F = new u();
            this.G = new u();
        } else if (i10 == 524531317 && !this.f41109y) {
            if (this.f41091g && this.C != -1) {
                this.B = true;
            } else {
                this.f41088d0.o(new a0.b(this.f41107w));
                this.f41109y = true;
            }
        }
    }

    @i
    public void H(int i10, String str) throws ParserException {
        if (i10 == 134) {
            t(i10).f41116b = str;
            return;
        }
        if (i10 != 17026) {
            if (i10 == 21358) {
                t(i10).f41115a = str;
                return;
            } else {
                if (i10 != 2274716) {
                    return;
                }
                t(i10).W = str;
                return;
            }
        }
        if (f41042m0.equals(str) || f41039l0.equals(str)) {
            return;
        }
        throw new ParserException("DocType " + str + " not supported");
    }

    @RequiresNonNull({"#2.output"})
    public final int I(hb.l lVar, d dVar, int i10) throws IOException {
        int i11;
        if (O0.equals(dVar.f41116b)) {
            J(lVar, V2, i10);
            return q();
        }
        if (P0.equals(dVar.f41116b)) {
            J(lVar, f41003a3, i10);
            return q();
        }
        d0 d0Var = dVar.X;
        if (!this.X) {
            if (dVar.f41122h) {
                this.R &= -1073741825;
                if (!this.Y) {
                    lVar.readFully(this.f41094j.d(), 0, 1);
                    this.U++;
                    if ((this.f41094j.d()[0] & 128) == 128) {
                        throw new ParserException("Extension bit is set in signal byte");
                    }
                    this.f41085b0 = this.f41094j.d()[0];
                    this.Y = true;
                }
                byte b10 = this.f41085b0;
                if ((b10 & 1) == 1) {
                    boolean z10 = (b10 & 2) == 2;
                    this.R |= 1073741824;
                    if (!this.f41086c0) {
                        lVar.readFully(this.f41099o.d(), 0, 8);
                        this.U += 8;
                        this.f41086c0 = true;
                        this.f41094j.d()[0] = (byte) ((z10 ? 128 : 0) | 8);
                        this.f41094j.S(0);
                        d0Var.c(this.f41094j, 1, 1);
                        this.V++;
                        this.f41099o.S(0);
                        d0Var.c(this.f41099o, 8, 1);
                        this.V += 8;
                    }
                    if (z10) {
                        if (!this.Z) {
                            lVar.readFully(this.f41094j.d(), 0, 1);
                            this.U++;
                            this.f41094j.S(0);
                            this.f41084a0 = this.f41094j.G();
                            this.Z = true;
                        }
                        int i12 = this.f41084a0 * 4;
                        this.f41094j.O(i12);
                        lVar.readFully(this.f41094j.d(), 0, i12);
                        this.U += i12;
                        short s10 = (short) ((this.f41084a0 / 2) + 1);
                        int i13 = (s10 * 6) + 2;
                        ByteBuffer byteBuffer = this.f41102r;
                        if (byteBuffer == null || byteBuffer.capacity() < i13) {
                            this.f41102r = ByteBuffer.allocate(i13);
                        }
                        this.f41102r.position(0);
                        this.f41102r.putShort(s10);
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            i11 = this.f41084a0;
                            if (i14 >= i11) {
                                break;
                            }
                            int iK = this.f41094j.K();
                            if (i14 % 2 == 0) {
                                this.f41102r.putShort((short) (iK - i15));
                            } else {
                                this.f41102r.putInt(iK - i15);
                            }
                            i14++;
                            i15 = iK;
                        }
                        int i16 = (i10 - this.U) - i15;
                        if (i11 % 2 == 1) {
                            this.f41102r.putInt(i16);
                        } else {
                            this.f41102r.putShort((short) i16);
                            this.f41102r.putInt(0);
                        }
                        this.f41100p.Q(this.f41102r.array(), i13);
                        d0Var.c(this.f41100p, i13, 1);
                        this.V += i13;
                    }
                }
            } else {
                byte[] bArr = dVar.f41123i;
                if (bArr != null) {
                    this.f41097m.Q(bArr, bArr.length);
                }
            }
            if (dVar.f41120f > 0) {
                this.R |= 268435456;
                this.f41101q.O(0);
                this.f41094j.O(4);
                this.f41094j.d()[0] = (byte) ((i10 >> 24) & 255);
                this.f41094j.d()[1] = (byte) ((i10 >> 16) & 255);
                this.f41094j.d()[2] = (byte) ((i10 >> 8) & 255);
                this.f41094j.d()[3] = (byte) (i10 & 255);
                d0Var.c(this.f41094j, 4, 2);
                this.V += 4;
            }
            this.X = true;
        }
        int iF = i10 + this.f41097m.f();
        if (!f41066u0.equals(dVar.f41116b) && !f41069v0.equals(dVar.f41116b)) {
            if (dVar.T != null) {
                hd.a.i(this.f41097m.f() == 0);
                dVar.T.d(lVar);
            }
            while (true) {
                int i17 = this.U;
                if (i17 >= iF) {
                    break;
                }
                int iK2 = K(lVar, d0Var, iF - i17);
                this.U += iK2;
                this.V += iK2;
            }
        } else {
            byte[] bArrD = this.f41093i.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i18 = dVar.Y;
            int i19 = 4 - i18;
            while (this.U < iF) {
                int i20 = this.W;
                if (i20 == 0) {
                    L(lVar, bArrD, i19, i18);
                    this.U += i18;
                    this.f41093i.S(0);
                    this.W = this.f41093i.K();
                    this.f41092h.S(0);
                    d0Var.d(this.f41092h, 4);
                    this.V += 4;
                } else {
                    int iK3 = K(lVar, d0Var, i20);
                    this.U += iK3;
                    this.V += iK3;
                    this.W -= iK3;
                }
            }
        }
        if (f41078y0.equals(dVar.f41116b)) {
            this.f41095k.S(0);
            d0Var.d(this.f41095k, 4);
            this.V += 4;
        }
        return q();
    }

    public final void J(hb.l lVar, byte[] bArr, int i10) throws IOException {
        int length = bArr.length + i10;
        if (this.f41098n.b() < length) {
            this.f41098n.P(Arrays.copyOf(bArr, length + i10));
        } else {
            System.arraycopy(bArr, 0, this.f41098n.d(), 0, bArr.length);
        }
        lVar.readFully(this.f41098n.d(), bArr.length, i10);
        this.f41098n.S(0);
        this.f41098n.R(length);
    }

    public final int K(hb.l lVar, d0 d0Var, int i10) throws IOException {
        int iA = this.f41097m.a();
        if (iA <= 0) {
            return d0Var.e(lVar, i10, false);
        }
        int iMin = Math.min(i10, iA);
        d0Var.d(this.f41097m, iMin);
        return iMin;
    }

    public final void L(hb.l lVar, byte[] bArr, int i10, int i11) throws IOException {
        int iMin = Math.min(i11, this.f41097m.a());
        lVar.readFully(bArr, i10 + iMin, i11 - iMin);
        if (iMin > 0) {
            this.f41097m.k(bArr, i10, iMin);
        }
    }

    @Override // hb.k
    @i
    public void b(long j10, long j11) {
        this.E = ya.g.f56663b;
        this.J = 0;
        this.f41087d.reset();
        this.f41089e.e();
        D();
        for (int i10 = 0; i10 < this.f41090f.size(); i10++) {
            this.f41090f.valueAt(i10).m();
        }
    }

    @Override // hb.k
    public final void c(m mVar) {
        this.f41088d0 = mVar;
    }

    @Override // hb.k
    public final int f(hb.l lVar, z zVar) throws IOException {
        this.I = false;
        boolean zA = true;
        while (zA && !this.I) {
            zA = this.f41087d.a(lVar);
            if (zA && B(zVar, lVar.getPosition())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i10 = 0; i10 < this.f41090f.size(); i10++) {
            d dVarValueAt = this.f41090f.valueAt(i10);
            dVarValueAt.e();
            dVarValueAt.i();
        }
        return -1;
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    public final void h(int i10) throws ParserException {
        if (this.F == null || this.G == null) {
            throw new ParserException("Element " + i10 + " must be in a Cues");
        }
    }

    @Override // hb.k
    public final boolean i(hb.l lVar) throws IOException {
        return new f().b(lVar);
    }

    @EnsuresNonNull({"currentTrack"})
    public final void j(int i10) throws ParserException {
        if (this.f41108x != null) {
            return;
        }
        throw new ParserException("Element " + i10 + " must be in a TrackEntry");
    }

    @EnsuresNonNull({"extractorOutput"})
    public final void k() {
        hd.a.k(this.f41088d0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x022f, code lost:
    
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    @g.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(int r22, int r23, hb.l r24) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.e.l(int, int, hb.l):void");
    }

    public final a0 m(@p0 u uVar, @p0 u uVar2) {
        int i10;
        if (this.f41104t == -1 || this.f41107w == ya.g.f56663b || uVar == null || uVar.c() == 0 || uVar2 == null || uVar2.c() != uVar.c()) {
            return new a0.b(this.f41107w);
        }
        int iC = uVar.c();
        int[] iArrCopyOf = new int[iC];
        long[] jArrCopyOf = new long[iC];
        long[] jArrCopyOf2 = new long[iC];
        long[] jArrCopyOf3 = new long[iC];
        int i11 = 0;
        for (int i12 = 0; i12 < iC; i12++) {
            jArrCopyOf3[i12] = uVar.b(i12);
            jArrCopyOf[i12] = this.f41104t + uVar2.b(i12);
        }
        while (true) {
            i10 = iC - 1;
            if (i11 >= i10) {
                break;
            }
            int i13 = i11 + 1;
            iArrCopyOf[i11] = (int) (jArrCopyOf[i13] - jArrCopyOf[i11]);
            jArrCopyOf2[i11] = jArrCopyOf3[i13] - jArrCopyOf3[i11];
            i11 = i13;
        }
        iArrCopyOf[i10] = (int) ((this.f41104t + this.f41103s) - jArrCopyOf[i10]);
        jArrCopyOf2[i10] = this.f41107w - jArrCopyOf3[i10];
        long j10 = jArrCopyOf2[i10];
        if (j10 <= 0) {
            t.n(f41021g0, "Discarding last cue point with unexpected duration: " + j10);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i10);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i10);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i10);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i10);
        }
        return new hb.e(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    @RequiresNonNull({"#1.output"})
    public final void n(d dVar, long j10, int i10, int i11, int i12) {
        C0455e c0455e = dVar.T;
        if (c0455e != null) {
            c0455e.c(dVar, j10, i10, i11, i12);
        } else {
            if (O0.equals(dVar.f41116b) || P0.equals(dVar.f41116b)) {
                if (this.N > 1) {
                    t.n(f41021g0, "Skipping subtitle sample in laced block.");
                } else {
                    long j11 = this.L;
                    if (j11 == ya.g.f56663b) {
                        t.n(f41021g0, "Skipping subtitle sample with no duration.");
                    } else {
                        F(dVar.f41116b, j11, this.f41098n.d());
                        int iE = this.f41098n.e();
                        while (true) {
                            if (iE >= this.f41098n.f()) {
                                break;
                            }
                            if (this.f41098n.d()[iE] == 0) {
                                this.f41098n.R(iE);
                                break;
                            }
                            iE++;
                        }
                        d0 d0Var = dVar.X;
                        c0 c0Var = this.f41098n;
                        d0Var.d(c0Var, c0Var.f());
                        i11 += this.f41098n.f();
                    }
                }
            }
            if ((268435456 & i10) != 0) {
                if (this.N > 1) {
                    i10 &= -268435457;
                } else {
                    int iF = this.f41101q.f();
                    dVar.X.c(this.f41101q, iF, 2);
                    i11 += iF;
                }
            }
            dVar.X.a(j10, i10, i11, i12, dVar.f41124j);
        }
        this.I = true;
    }

    @i
    public void o(int i10) throws ParserException {
        k();
        if (i10 == 160) {
            if (this.J != 2) {
                return;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.N; i12++) {
                i11 += this.O[i12];
            }
            d dVar = this.f41090f.get(this.P);
            dVar.e();
            for (int i13 = 0; i13 < this.N; i13++) {
                long j10 = ((long) ((dVar.f41119e * i13) / 1000)) + this.K;
                int i14 = this.R;
                if (i13 == 0 && !this.T) {
                    i14 |= 1;
                }
                int i15 = this.O[i13];
                i11 -= i15;
                n(dVar, j10, i14, i15, i11);
            }
            this.J = 0;
            return;
        }
        if (i10 == 174) {
            d dVar2 = (d) hd.a.k(this.f41108x);
            String str = dVar2.f41116b;
            if (str == null) {
                throw new ParserException("CodecId is missing in TrackEntry element");
            }
            if (y(str)) {
                dVar2.h(this.f41088d0, dVar2.f41117c);
                this.f41090f.put(dVar2.f41117c, dVar2);
            }
            this.f41108x = null;
            return;
        }
        if (i10 == 19899) {
            int i16 = this.f41110z;
            if (i16 != -1) {
                long j11 = this.A;
                if (j11 != -1) {
                    if (i16 == 475249515) {
                        this.C = j11;
                        return;
                    }
                    return;
                }
            }
            throw new ParserException("Mandatory element SeekID or SeekPosition not found");
        }
        if (i10 == 25152) {
            j(i10);
            d dVar3 = this.f41108x;
            if (dVar3.f41122h) {
                if (dVar3.f41124j == null) {
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
                dVar3.f41126l = new DrmInitData(new DrmInitData.SchemeData(ya.g.H1, w.f31186h, this.f41108x.f41124j.f30823b));
                return;
            }
            return;
        }
        if (i10 == 28032) {
            j(i10);
            d dVar4 = this.f41108x;
            if (dVar4.f41122h && dVar4.f41123i != null) {
                throw new ParserException("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i10 == 357149030) {
            if (this.f41105u == ya.g.f56663b) {
                this.f41105u = 1000000L;
            }
            long j12 = this.f41106v;
            if (j12 != ya.g.f56663b) {
                this.f41107w = E(j12);
                return;
            }
            return;
        }
        if (i10 == 374648427) {
            if (this.f41090f.size() == 0) {
                throw new ParserException("No valid tracks were found");
            }
            this.f41088d0.k();
        } else {
            if (i10 != 475249515) {
                return;
            }
            if (!this.f41109y) {
                this.f41088d0.o(m(this.F, this.G));
                this.f41109y = true;
            }
            this.F = null;
            this.G = null;
        }
    }

    public final int q() {
        int i10 = this.V;
        D();
        return i10;
    }

    @i
    public void r(int i10, double d10) throws ParserException {
        if (i10 == 181) {
            t(i10).Q = (int) d10;
        }
        if (i10 == 17545) {
            this.f41106v = (long) d10;
            return;
        }
        switch (i10) {
            case B2 /* 21969 */:
                t(i10).D = (float) d10;
                break;
            case C2 /* 21970 */:
                t(i10).E = (float) d10;
                break;
            case D2 /* 21971 */:
                t(i10).F = (float) d10;
                break;
            case E2 /* 21972 */:
                t(i10).G = (float) d10;
                break;
            case F2 /* 21973 */:
                t(i10).H = (float) d10;
                break;
            case G2 /* 21974 */:
                t(i10).I = (float) d10;
                break;
            case H2 /* 21975 */:
                t(i10).J = (float) d10;
                break;
            case I2 /* 21976 */:
                t(i10).K = (float) d10;
                break;
            case J2 /* 21977 */:
                t(i10).L = (float) d10;
                break;
            case K2 /* 21978 */:
                t(i10).M = (float) d10;
                break;
            default:
                switch (i10) {
                    case f41056q2 /* 30323 */:
                        t(i10).f41133s = (float) d10;
                        break;
                    case f41059r2 /* 30324 */:
                        t(i10).f41134t = (float) d10;
                        break;
                    case f41062s2 /* 30325 */:
                        t(i10).f41135u = (float) d10;
                        break;
                }
                break;
        }
    }

    @Override // hb.k
    public final void release() {
    }

    public final d t(int i10) throws ParserException {
        j(i10);
        return this.f41108x;
    }

    @i
    public int u(int i10) {
        switch (i10) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case f41076x1 /* 215 */:
            case f41040l1 /* 231 */:
            case f41061s1 /* 238 */:
            case 241:
            case f41067u1 /* 251 */:
            case E1 /* 16871 */:
            case f41002a2 /* 16980 */:
            case f41001a1 /* 17029 */:
            case Y0 /* 17143 */:
            case f41011d2 /* 18401 */:
            case f41023g2 /* 18408 */:
            case X1 /* 20529 */:
            case Y1 /* 20530 */:
            case f41022g1 /* 21420 */:
            case f41065t2 /* 21432 */:
            case O1 /* 21680 */:
            case Q1 /* 21682 */:
            case P1 /* 21690 */:
            case A1 /* 21930 */:
            case f41071v2 /* 21945 */:
            case f41074w2 /* 21946 */:
            case f41077x2 /* 21947 */:
            case f41080y2 /* 21948 */:
            case f41083z2 /* 21949 */:
            case C1 /* 21998 */:
            case J1 /* 22186 */:
            case K1 /* 22203 */:
            case T1 /* 25188 */:
            case f41050o2 /* 30321 */:
            case B1 /* 2352003 */:
            case f41030i1 /* 2807729 */:
                return 2;
            case 134:
            case Z0 /* 17026 */:
            case G1 /* 21358 */:
            case f41044m2 /* 2274716 */:
                return 3;
            case 160:
            case 166:
            case f41073w1 /* 174 */:
            case 183:
            case f41031i2 /* 187 */:
            case 224:
            case 225:
            case D1 /* 16868 */:
            case f41019f2 /* 18407 */:
            case f41014e1 /* 19899 */:
            case Z1 /* 20532 */:
            case f41008c2 /* 20533 */:
            case f41068u2 /* 21936 */:
            case A2 /* 21968 */:
            case W1 /* 25152 */:
            case V1 /* 28032 */:
            case f41055q1 /* 30113 */:
            case f41047n2 /* 30320 */:
            case f41010d1 /* 290298740 */:
            case 357149030:
            case f41070v1 /* 374648427 */:
            case f41004b1 /* 408125543 */:
            case 440786851:
            case f41027h2 /* 475249515 */:
            case f41037k1 /* 524531317 */:
                return 1;
            case 161:
            case 163:
            case 165:
            case F1 /* 16877 */:
            case f41005b2 /* 16981 */:
            case f41015e2 /* 18402 */:
            case f41018f1 /* 21419 */:
            case I1 /* 25506 */:
            case f41053p2 /* 30322 */:
                return 4;
            case 181:
            case f41034j1 /* 17545 */:
            case B2 /* 21969 */:
            case C2 /* 21970 */:
            case D2 /* 21971 */:
            case E2 /* 21972 */:
            case F2 /* 21973 */:
            case G2 /* 21974 */:
            case H2 /* 21975 */:
            case I2 /* 21976 */:
            case J2 /* 21977 */:
            case K2 /* 21978 */:
            case f41056q2 /* 30323 */:
            case f41059r2 /* 30324 */:
            case f41062s2 /* 30325 */:
                return 5;
            default:
                return 0;
        }
    }

    public void v(d dVar, hb.l lVar, int i10) throws IOException {
        if (dVar.f41121g != 1685485123 && dVar.f41121g != 1685480259) {
            lVar.o(i10);
            return;
        }
        byte[] bArr = new byte[i10];
        dVar.N = bArr;
        lVar.readFully(bArr, 0, i10);
    }

    public void w(d dVar, int i10, hb.l lVar, int i11) throws IOException {
        if (i10 != 4 || !f41048o0.equals(dVar.f41116b)) {
            lVar.o(i11);
        } else {
            this.f41101q.O(i11);
            lVar.readFully(this.f41101q.d(), 0, i11);
        }
    }

    @i
    public void x(int i10, long j10) throws ParserException {
        if (i10 == 20529) {
            if (j10 == 0) {
                return;
            }
            throw new ParserException("ContentEncodingOrder " + j10 + " not supported");
        }
        if (i10 == 20530) {
            if (j10 == 1) {
                return;
            }
            throw new ParserException("ContentEncodingScope " + j10 + " not supported");
        }
        switch (i10) {
            case 131:
                t(i10).f41118d = (int) j10;
                return;
            case 136:
                t(i10).V = j10 == 1;
                return;
            case 155:
                this.L = E(j10);
                return;
            case 159:
                t(i10).O = (int) j10;
                return;
            case 176:
                t(i10).f41127m = (int) j10;
                return;
            case 179:
                h(i10);
                this.F.a(E(j10));
                return;
            case 186:
                t(i10).f41128n = (int) j10;
                return;
            case f41076x1 /* 215 */:
                t(i10).f41117c = (int) j10;
                return;
            case f41040l1 /* 231 */:
                this.E = E(j10);
                return;
            case f41061s1 /* 238 */:
                this.S = (int) j10;
                return;
            case 241:
                if (this.H) {
                    return;
                }
                h(i10);
                this.G.a(j10);
                this.H = true;
                return;
            case f41067u1 /* 251 */:
                this.T = true;
                return;
            case E1 /* 16871 */:
                t(i10).f41121g = (int) j10;
                return;
            case f41002a2 /* 16980 */:
                if (j10 == 3) {
                    return;
                }
                throw new ParserException("ContentCompAlgo " + j10 + " not supported");
            case f41001a1 /* 17029 */:
                if (j10 < 1 || j10 > 2) {
                    throw new ParserException("DocTypeReadVersion " + j10 + " not supported");
                }
                return;
            case Y0 /* 17143 */:
                if (j10 == 1) {
                    return;
                }
                throw new ParserException("EBMLReadVersion " + j10 + " not supported");
            case f41011d2 /* 18401 */:
                if (j10 == 5) {
                    return;
                }
                throw new ParserException("ContentEncAlgo " + j10 + " not supported");
            case f41023g2 /* 18408 */:
                if (j10 == 1) {
                    return;
                }
                throw new ParserException("AESSettingsCipherMode " + j10 + " not supported");
            case f41022g1 /* 21420 */:
                this.A = j10 + this.f41104t;
                return;
            case f41065t2 /* 21432 */:
                int i11 = (int) j10;
                j(i10);
                if (i11 == 0) {
                    this.f41108x.f41137w = 0;
                    return;
                }
                if (i11 == 1) {
                    this.f41108x.f41137w = 2;
                    return;
                } else if (i11 == 3) {
                    this.f41108x.f41137w = 1;
                    return;
                } else {
                    if (i11 != 15) {
                        return;
                    }
                    this.f41108x.f41137w = 3;
                    return;
                }
            case O1 /* 21680 */:
                t(i10).f41129o = (int) j10;
                return;
            case Q1 /* 21682 */:
                t(i10).f41131q = (int) j10;
                return;
            case P1 /* 21690 */:
                t(i10).f41130p = (int) j10;
                return;
            case A1 /* 21930 */:
                t(i10).U = j10 == 1;
                return;
            case C1 /* 21998 */:
                t(i10).f41120f = (int) j10;
                return;
            case J1 /* 22186 */:
                t(i10).R = j10;
                return;
            case K1 /* 22203 */:
                t(i10).S = j10;
                return;
            case T1 /* 25188 */:
                t(i10).P = (int) j10;
                return;
            case f41050o2 /* 30321 */:
                j(i10);
                int i12 = (int) j10;
                if (i12 == 0) {
                    this.f41108x.f41132r = 0;
                    return;
                }
                if (i12 == 1) {
                    this.f41108x.f41132r = 1;
                    return;
                } else if (i12 == 2) {
                    this.f41108x.f41132r = 2;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    this.f41108x.f41132r = 3;
                    return;
                }
            case B1 /* 2352003 */:
                t(i10).f41119e = (int) j10;
                return;
            case f41030i1 /* 2807729 */:
                this.f41105u = j10;
                return;
            default:
                switch (i10) {
                    case f41071v2 /* 21945 */:
                        j(i10);
                        int i13 = (int) j10;
                        if (i13 == 1) {
                            this.f41108x.A = 2;
                            return;
                        } else {
                            if (i13 != 2) {
                                return;
                            }
                            this.f41108x.A = 1;
                            return;
                        }
                    case f41074w2 /* 21946 */:
                        j(i10);
                        int i14 = (int) j10;
                        if (i14 != 1) {
                            if (i14 == 16) {
                                this.f41108x.f41140z = 6;
                                return;
                            } else if (i14 == 18) {
                                this.f41108x.f41140z = 7;
                                return;
                            } else if (i14 != 6 && i14 != 7) {
                                return;
                            }
                        }
                        this.f41108x.f41140z = 3;
                        return;
                    case f41077x2 /* 21947 */:
                        j(i10);
                        d dVar = this.f41108x;
                        dVar.f41138x = true;
                        int i15 = (int) j10;
                        if (i15 == 1) {
                            dVar.f41139y = 1;
                            return;
                        }
                        if (i15 == 9) {
                            dVar.f41139y = 6;
                            return;
                        } else {
                            if (i15 == 4 || i15 == 5 || i15 == 6 || i15 == 7) {
                                dVar.f41139y = 2;
                                return;
                            }
                            return;
                        }
                    case f41080y2 /* 21948 */:
                        t(i10).B = (int) j10;
                        return;
                    case f41083z2 /* 21949 */:
                        t(i10).C = (int) j10;
                        return;
                    default:
                        return;
                }
        }
    }

    @i
    public boolean z(int i10) {
        return i10 == 357149030 || i10 == 524531317 || i10 == 475249515 || i10 == 374648427;
    }

    public e(int i10) {
        this(new mb.a(), i10);
    }

    public e(mb.c cVar, int i10) {
        this.f41104t = -1L;
        this.f41105u = ya.g.f56663b;
        this.f41106v = ya.g.f56663b;
        this.f41107w = ya.g.f56663b;
        this.C = -1L;
        this.D = -1L;
        this.E = ya.g.f56663b;
        this.f41087d = cVar;
        cVar.b(new c());
        this.f41091g = (i10 & 1) == 0;
        this.f41089e = new g();
        this.f41090f = new SparseArray<>();
        this.f41094j = new c0(4);
        this.f41095k = new c0(ByteBuffer.allocate(4).putInt(-1).array());
        this.f41096l = new c0(4);
        this.f41092h = new c0(y.f31231b);
        this.f41093i = new c0(4);
        this.f41097m = new c0();
        this.f41098n = new c0();
        this.f41099o = new c0(8);
        this.f41100p = new c0();
        this.f41101q = new c0();
        this.O = new int[1];
    }
}
