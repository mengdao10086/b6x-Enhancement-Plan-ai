package ya;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final int A = 268435456;
    public static final int A0 = 1;
    public static final int A1 = 4;
    public static final int A2 = 1;
    public static final int B = 536870912;
    public static final int B0 = 2;
    public static final int B1 = 10000;
    public static final int B2 = 2;
    public static final int C = 805306368;
    public static final int C0 = 3;
    public static final int C1 = 65536;
    public static final int C2 = 4;
    public static final int D = 4;
    public static final int D0 = 4;
    public static final String D1 = "cenc";
    public static final int D2 = 8;
    public static final int E = 9;
    public static final int E0 = 1;
    public static final String E1 = "cbc1";
    public static final int E2 = 16;
    public static final int F = 10;
    public static final int F0 = 4;
    public static final String F1 = "cens";
    public static final int F2 = 32;
    public static final int G = 11;
    public static final int G0 = 268435456;
    public static final String G1 = "cbcs";
    public static final int G2 = 64;
    public static final int H = 12;
    public static final int H0 = 536870912;
    public static final int H2 = 128;
    public static final int I = 16;
    public static final int I0 = 1073741824;
    public static final int I2 = 256;
    public static final int J = 15;
    public static final int J0 = Integer.MIN_VALUE;
    public static final int J2 = 512;
    public static final int K = 1073741824;
    public static final int K0 = -1;
    public static final int K2 = 1024;
    public static final int L = 5;
    public static final int L0 = 0;
    public static final int L2 = 2048;
    public static final int M = 6;
    public static final int M0 = 1;

    @Deprecated
    public static final int M1 = 1;
    public static final int M2 = 4096;
    public static final int N = 18;
    public static final int N0 = 1;

    @Deprecated
    public static final int N1 = 2;
    public static final int N2 = 8192;
    public static final int O = 17;
    public static final int O0 = 2;

    @Deprecated
    public static final int O1 = 3;
    public static final int O2 = 16384;
    public static final int P = 7;
    public static final int P0 = 1;

    @Deprecated
    public static final int P1 = 4;
    public static final int P2 = 4;
    public static final int Q = 8;
    public static final int Q0 = 1;

    @Deprecated
    public static final int Q1 = 5;
    public static final int Q2 = 3;
    public static final int R = 14;
    public static final int R0 = 2;

    @Deprecated
    public static final int R1 = 6;
    public static final int R2 = 2;
    public static final int S = 4;
    public static final int S0 = 4;

    @Deprecated
    public static final int S1 = 7;
    public static final int S2 = 1;
    public static final int T = 8;
    public static final String T0 = "und";

    @Deprecated
    public static final int T1 = 8;
    public static final int T2 = 0;
    public static final int U = 3;
    public static final int U0 = 0;

    @Deprecated
    public static final int U1 = 10000;
    public static final int V = 5;
    public static final int V0 = 1;
    public static final int V1 = 0;
    public static final int W = 2;
    public static final int W0 = 2;
    public static final int W1 = 1;
    public static final int X = 1;
    public static final int X0 = 3;
    public static final int X1 = 2;
    public static final int Y = 0;
    public static final int Y0 = -1;
    public static final int Y1 = 3;
    public static final int Z = 3;
    public static final int Z0 = -2;
    public static final int Z1 = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f56659a = Long.MIN_VALUE;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f56660a0 = 3;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final int f56661a1 = -3;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public static final int f56662a2 = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f56663b = -9223372036854775807L;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f56664b0 = 2;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final int f56665b1 = -4;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public static final int f56666b2 = 6;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56667c = -1;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f56668c0 = 4;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final int f56669c1 = -5;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public static final int f56670c2 = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56671d = -1;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f56672d0 = 1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final int f56673d1 = 0;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public static final int f56674d2 = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f56675e = -3.4028235E38f;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f56676e0 = 0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final int f56677e1 = 1;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public static final int f56678e2 = 7;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f56679f = -1;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f56680f0 = 1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final int f56681f1 = 2;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public static final int f56682f2 = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f56683g = -1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f56684g0 = 4;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final int f56685g1 = 3;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final int f56686g2 = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f56687h = 1000;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f56688h0 = 11;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final int f56689h1 = 4;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final int f56690h2 = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f56691i = 1000000;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f56692i0 = 12;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final int f56693i1 = 5;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    public static final int f56694i2 = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f56695j = 1000000000;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f56696j0 = 13;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final int f56697j1 = 6;

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public static final int f56698j2 = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f56699k = 8;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f56700k0 = 16;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f56701k1 = 7;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    public static final int f56702k2 = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f56703l = 4;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f56704l0 = 14;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final int f56705l1 = 10000;

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    public static final int f56706l2 = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Deprecated
    public static final String f56707m = "US-ASCII";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f56708m0 = 1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final int f56709m1 = -1;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    public static final int f56710m2 = -1000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Deprecated
    public static final String f56711n = "UTF-8";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f56712n0 = 5;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final int f56713n1 = 0;

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public static final int f56714n2 = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Deprecated
    public static final String f56715o = "ISO-8859-1";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final int f56716o0 = 9;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final int f56717o1 = 1;

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    public static final int f56718o2 = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Deprecated
    public static final String f56719p = "UTF-16";

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final int f56720p0 = 8;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final int f56721p1 = 2;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final int f56722p2 = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Deprecated
    public static final String f56723q = "UTF-16LE";

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final int f56724q0 = 7;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final int f56725q1 = 3;

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    public static final int f56726q2 = 3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f56727r = "serif";

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final int f56728r0 = 10;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final int f56729r1 = 4;

    /* JADX INFO: renamed from: r2, reason: collision with root package name */
    public static final int f56730r2 = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f56731s = "sans-serif";

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int f56732s0 = 6;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final int f56733s1 = 5;

    /* JADX INFO: renamed from: s2, reason: collision with root package name */
    public static final int f56734s2 = 5;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f56735t = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int f56736t0 = 0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final int f56737t1 = 6;

    /* JADX INFO: renamed from: t2, reason: collision with root package name */
    public static final int f56738t2 = 9;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f56739u = 1;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final int f56740u0 = 2;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final int f56741u1 = 7;

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    public static final int f56742u2 = 6;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f56743v = 2;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int f56744v0 = 3;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f56745v1 = 10000;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f56746v2 = 7;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f56747w = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int f56748w0 = 1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final int f56749w1 = 0;

    /* JADX INFO: renamed from: w2, reason: collision with root package name */
    public static final int f56750w2 = 8;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f56751x = 0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final int f56752x0 = 3;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final int f56753x1 = 1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final int f56754x2 = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f56755y = 3;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final int f56756y0 = 2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final int f56757y1 = 2;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final int f56758y2 = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f56759z = 2;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final int f56760z0 = 0;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static final int f56761z1 = 3;

    /* JADX INFO: renamed from: z2, reason: collision with root package name */
    public static final int f56762z2 = 2;
    public static final UUID H1 = new UUID(0, 0);
    public static final UUID I1 = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID J1 = new UUID(-2129748144642739255L, 8654423357094679310L);
    public static final UUID K1 = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID L1 = new UUID(-7348484286925749626L, -6083546864340672619L);

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    /* JADX INFO: renamed from: ya.g$g, reason: collision with other inner class name */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0671g {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface i {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface j {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface l {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface m {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface n {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface o {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface p {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface q {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface r {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface s {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface t {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface u {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface v {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface w {
    }

    @g.v0(21)
    public static int a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static String b(int i10) {
        if (i10 == 0) {
            return HlsPlaylistParser.W;
        }
        if (i10 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i10 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i10 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i10 == 4) {
            return HlsPlaylistParser.V;
        }
        throw new IllegalStateException();
    }

    public static long c(long j10) {
        return (j10 == f56663b || j10 == Long.MIN_VALUE) ? j10 : j10 * 1000;
    }

    public static long d(long j10) {
        return (j10 == f56663b || j10 == Long.MIN_VALUE) ? j10 : j10 / 1000;
    }
}
