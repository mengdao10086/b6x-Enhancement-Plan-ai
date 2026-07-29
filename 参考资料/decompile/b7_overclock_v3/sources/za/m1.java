package za;

import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ya.x1;
import za.h1;
import za.k1;
import za.l1;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 implements h1, k1.a {
    public final k1 Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Map<String, b> f58193a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final Map<String, h1.b> f58194b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @g.p0
    public final a f58195c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final boolean f58196d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final x1.b f58197e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public l1 f58198f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @g.p0
    public String f58199g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @g.p0
    public String f58200h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @g.p0
    public h1.b f58201i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f58202j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f58203k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    @g.p0
    public Exception f58204l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public long f58205m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public long f58206n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @g.p0
    public Format f58207o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    @g.p0
    public Format f58208p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f58209q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f58210r0;

    public interface a {
        void a(h1.b bVar, l1 l1Var);
    }

    public static final class b {
        public long A;
        public long B;
        public long C;
        public long D;
        public long E;
        public int F;
        public int G;
        public int H;
        public long I;
        public boolean J;
        public boolean K;
        public boolean L;
        public boolean M;
        public boolean N;
        public long O;

        @g.p0
        public Format P;

        @g.p0
        public Format Q;
        public long R;
        public long S;
        public float T;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f58211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f58212b = new long[16];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<l1.c> f58213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<long[]> f58214d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<l1.b> f58215e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<l1.b> f58216f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<l1.a> f58217g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<l1.a> f58218h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f58219i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f58220j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f58221k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f58222l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f58223m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f58224n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f58225o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f58226p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f58227q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f58228r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f58229s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public long f58230t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public long f58231u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public long f58232v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public long f58233w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public long f58234x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public long f58235y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public long f58236z;

        public b(boolean z10, h1.b bVar) {
            this.f58211a = z10;
            this.f58213c = z10 ? new ArrayList<>() : Collections.emptyList();
            this.f58214d = z10 ? new ArrayList<>() : Collections.emptyList();
            this.f58215e = z10 ? new ArrayList<>() : Collections.emptyList();
            this.f58216f = z10 ? new ArrayList<>() : Collections.emptyList();
            this.f58217g = z10 ? new ArrayList<>() : Collections.emptyList();
            this.f58218h = z10 ? new ArrayList<>() : Collections.emptyList();
            boolean z11 = false;
            this.H = 0;
            this.I = bVar.f58099a;
            this.f58220j = ya.g.f56663b;
            this.f58228r = ya.g.f56663b;
            l.a aVar = bVar.f58102d;
            if (aVar != null && aVar.b()) {
                z11 = true;
            }
            this.f58219i = z11;
            this.f58231u = -1L;
            this.f58230t = -1L;
            this.f58229s = -1;
            this.T = 1.0f;
        }

        public static boolean c(int i10, int i11) {
            return ((i10 != 1 && i10 != 2 && i10 != 14) || i11 == 1 || i11 == 2 || i11 == 14 || i11 == 3 || i11 == 4 || i11 == 9 || i11 == 11) ? false : true;
        }

        public static boolean d(int i10) {
            return i10 == 4 || i10 == 7;
        }

        public static boolean e(int i10) {
            return i10 == 3 || i10 == 4 || i10 == 9;
        }

        public static boolean f(int i10) {
            return i10 == 6 || i10 == 7 || i10 == 10;
        }

        public l1 a(boolean z10) {
            long[] jArr;
            List<long[]> list;
            long[] jArr2 = this.f58212b;
            List<long[]> list2 = this.f58214d;
            if (z10) {
                jArr = jArr2;
                list = list2;
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long[] jArrCopyOf = Arrays.copyOf(this.f58212b, 16);
                long jMax = Math.max(0L, jElapsedRealtime - this.I);
                int i10 = this.H;
                jArrCopyOf[i10] = jArrCopyOf[i10] + jMax;
                j(jElapsedRealtime);
                h(jElapsedRealtime);
                g(jElapsedRealtime);
                ArrayList arrayList = new ArrayList(this.f58214d);
                if (this.f58211a && this.H == 3) {
                    arrayList.add(b(jElapsedRealtime));
                }
                jArr = jArrCopyOf;
                list = arrayList;
            }
            int i11 = (this.f58223m || !this.f58221k) ? 1 : 0;
            long j10 = i11 != 0 ? ya.g.f56663b : jArr[2];
            int i12 = jArr[1] > 0 ? 1 : 0;
            List arrayList2 = z10 ? this.f58215e : new ArrayList(this.f58215e);
            List arrayList3 = z10 ? this.f58216f : new ArrayList(this.f58216f);
            List arrayList4 = z10 ? this.f58213c : new ArrayList(this.f58213c);
            long j11 = this.f58220j;
            boolean z11 = this.K;
            int i13 = !this.f58221k ? 1 : 0;
            boolean z12 = this.f58222l;
            int i14 = i11 ^ 1;
            int i15 = this.f58224n;
            int i16 = this.f58225o;
            int i17 = this.f58226p;
            int i18 = this.f58227q;
            long j12 = this.f58228r;
            boolean z13 = this.f58219i;
            long[] jArr3 = jArr;
            long j13 = this.f58232v;
            long j14 = this.f58233w;
            long j15 = this.f58234x;
            long j16 = this.f58235y;
            long j17 = this.f58236z;
            long j18 = this.A;
            int i19 = this.f58229s;
            int i20 = i19 == -1 ? 0 : 1;
            long j19 = this.f58230t;
            int i21 = j19 == -1 ? 0 : 1;
            long j20 = this.f58231u;
            int i22 = j20 == -1 ? 0 : 1;
            long j21 = this.B;
            long j22 = this.C;
            long j23 = this.D;
            long j24 = this.E;
            int i23 = this.F;
            return new l1(1, jArr3, arrayList4, list, j11, z11 ? 1 : 0, i13, z12 ? 1 : 0, i12, j10, i14, i15, i16, i17, i18, j12, z13 ? 1 : 0, arrayList2, arrayList3, j13, j14, j15, j16, j17, j18, i20, i21, i19, j19, i22, j20, j21, j22, j23, j24, i23 > 0 ? 1 : 0, i23, this.G, this.f58217g, this.f58218h);
        }

        public final long[] b(long j10) {
            List<long[]> list = this.f58214d;
            return new long[]{j10, list.get(list.size() - 1)[1] + ((long) ((j10 - r0[0]) * this.T))};
        }

        public final void g(long j10) {
            Format format;
            int i10;
            if (this.H == 3 && (format = this.Q) != null && (i10 = format.f16694h) != -1) {
                long j11 = (long) ((j10 - this.S) * this.T);
                this.f58236z += j11;
                this.A += j11 * ((long) i10);
            }
            this.S = j10;
        }

        public final void h(long j10) {
            Format format;
            if (this.H == 3 && (format = this.P) != null) {
                long j11 = (long) ((j10 - this.R) * this.T);
                int i10 = format.f16705r;
                if (i10 != -1) {
                    this.f58232v += j11;
                    this.f58233w += ((long) i10) * j11;
                }
                int i11 = format.f16694h;
                if (i11 != -1) {
                    this.f58234x += j11;
                    this.f58235y += j11 * ((long) i11);
                }
            }
            this.R = j10;
        }

        public final void i(h1.b bVar, @g.p0 Format format) {
            int i10;
            if (hd.u0.c(this.Q, format)) {
                return;
            }
            g(bVar.f58099a);
            if (format != null && this.f58231u == -1 && (i10 = format.f16694h) != -1) {
                this.f58231u = i10;
            }
            this.Q = format;
            if (this.f58211a) {
                this.f58216f.add(new l1.b(bVar, format));
            }
        }

        public final void j(long j10) {
            if (f(this.H)) {
                long j11 = j10 - this.O;
                long j12 = this.f58228r;
                if (j12 == ya.g.f56663b || j11 > j12) {
                    this.f58228r = j11;
                }
            }
        }

        public final void k(long j10, long j11) {
            if (this.f58211a) {
                if (this.H != 3) {
                    if (j11 == ya.g.f56663b) {
                        return;
                    }
                    if (!this.f58214d.isEmpty()) {
                        List<long[]> list = this.f58214d;
                        long j12 = list.get(list.size() - 1)[1];
                        if (j12 != j11) {
                            this.f58214d.add(new long[]{j10, j12});
                        }
                    }
                }
                this.f58214d.add(j11 == ya.g.f56663b ? b(j10) : new long[]{j10, j11});
            }
        }

        public final void l(h1.b bVar, @g.p0 Format format) {
            int i10;
            int i11;
            if (hd.u0.c(this.P, format)) {
                return;
            }
            h(bVar.f58099a);
            if (format != null) {
                if (this.f58229s == -1 && (i11 = format.f16705r) != -1) {
                    this.f58229s = i11;
                }
                if (this.f58230t == -1 && (i10 = format.f16694h) != -1) {
                    this.f58230t = i10;
                }
            }
            this.P = format;
            if (this.f58211a) {
                this.f58215e.add(new l1.b(bVar, format));
            }
        }

        public void m(ya.j1 j1Var, h1.b bVar, boolean z10, boolean z11, boolean z12, int i10, boolean z13, boolean z14, @g.p0 ExoPlaybackException exoPlaybackException, @g.p0 Exception exc, long j10, long j11, @g.p0 Format format, @g.p0 Format format2, int i11, int i12) {
            if (z11) {
                this.J = true;
            }
            if (j1Var.d() != 2) {
                this.J = false;
            }
            int iD = j1Var.d();
            if (iD == 1 || iD == 4 || z12) {
                this.L = false;
            }
            if (exoPlaybackException != null) {
                this.M = true;
                this.F++;
                if (this.f58211a) {
                    this.f58217g.add(new l1.a(bVar, exoPlaybackException));
                }
            } else if (j1Var.w0() == null) {
                this.M = false;
            }
            if (this.K && !this.L) {
                boolean z15 = false;
                boolean z16 = false;
                for (ad.h hVar : j1Var.A1().b()) {
                    if (hVar != null && hVar.length() > 0) {
                        int iL = hd.w.l(hVar.b(0).f16699l);
                        if (iL == 2) {
                            z15 = true;
                        } else if (iL == 1) {
                            z16 = true;
                        }
                    }
                }
                if (!z15) {
                    l(bVar, null);
                }
                if (!z16) {
                    i(bVar, null);
                }
            }
            if (format != null) {
                l(bVar, format);
            }
            if (format2 != null) {
                i(bVar, format2);
            }
            Format format3 = this.P;
            if (format3 != null && format3.f16705r == -1 && i11 != -1) {
                l(bVar, format3.a().j0(i12).Q(i11).E());
            }
            if (z14) {
                this.N = true;
            }
            if (z13) {
                this.E++;
            }
            this.D += (long) i10;
            this.B += j10;
            this.C += j11;
            if (exc != null) {
                this.G++;
                if (this.f58211a) {
                    this.f58218h.add(new l1.a(bVar, exc));
                }
            }
            int iQ = q(j1Var);
            float f10 = j1Var.e().f56785a;
            if (this.H != iQ || this.T != f10) {
                k(bVar.f58099a, z10 ? bVar.f58103e : ya.g.f56663b);
                h(bVar.f58099a);
                g(bVar.f58099a);
            }
            this.T = f10;
            if (this.H != iQ) {
                r(iQ, bVar);
            }
        }

        public void n(h1.b bVar, boolean z10) {
            int i10 = 11;
            if (this.H != 11 && !z10) {
                i10 = 15;
            }
            k(bVar.f58099a, ya.g.f56663b);
            h(bVar.f58099a);
            g(bVar.f58099a);
            r(i10, bVar);
        }

        public void o() {
            this.K = true;
        }

        public void p() {
            this.L = true;
            this.J = false;
        }

        public final int q(ya.j1 j1Var) {
            int iD = j1Var.d();
            if (this.J && this.K) {
                return 5;
            }
            if (this.M) {
                return 13;
            }
            if (!this.K) {
                return this.N ? 1 : 0;
            }
            if (this.L) {
                return 14;
            }
            if (iD == 4) {
                return 11;
            }
            if (iD != 2) {
                if (iD == 3) {
                    if (j1Var.D()) {
                        return j1Var.j1() != 0 ? 9 : 3;
                    }
                    return 4;
                }
                if (iD != 1 || this.H == 0) {
                    return this.H;
                }
                return 12;
            }
            int i10 = this.H;
            if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 14) {
                return 2;
            }
            if (j1Var.D()) {
                return j1Var.j1() != 0 ? 10 : 6;
            }
            return 7;
        }

        public final void r(int i10, h1.b bVar) {
            hd.a.a(bVar.f58099a >= this.I);
            long j10 = bVar.f58099a;
            long j11 = j10 - this.I;
            long[] jArr = this.f58212b;
            int i11 = this.H;
            jArr[i11] = jArr[i11] + j11;
            if (this.f58220j == ya.g.f56663b) {
                this.f58220j = j10;
            }
            this.f58223m |= c(i11, i10);
            this.f58221k |= e(i10);
            this.f58222l |= i10 == 11;
            if (!d(this.H) && d(i10)) {
                this.f58224n++;
            }
            if (i10 == 5) {
                this.f58226p++;
            }
            if (!f(this.H) && f(i10)) {
                this.f58227q++;
                this.O = bVar.f58099a;
            }
            if (f(this.H) && this.H != 7 && i10 == 7) {
                this.f58225o++;
            }
            j(bVar.f58099a);
            this.H = i10;
            this.I = bVar.f58099a;
            if (this.f58211a) {
                this.f58213c.add(new l1.c(bVar, i10));
            }
        }
    }

    public m1(boolean z10, @g.p0 a aVar) {
        this.f58195c0 = aVar;
        this.f58196d0 = z10;
        j1 j1Var = new j1();
        this.Z = j1Var;
        this.f58193a0 = new HashMap();
        this.f58194b0 = new HashMap();
        this.f58198f0 = l1.f58153e0;
        this.f58197e0 = new x1.b();
        j1Var.f(this);
    }

    @Override // za.h1
    public /* synthetic */ void A(h1.b bVar, boolean z10) {
        g1.F(this, bVar, z10);
    }

    @Override // za.h1
    public /* synthetic */ void B(h1.b bVar, int i10) {
        g1.L(this, bVar, i10);
    }

    @Override // za.h1
    public void C(h1.b bVar, ec.k kVar) {
        int i10 = kVar.f26846b;
        if (i10 == 2 || i10 == 0) {
            this.f58207o0 = kVar.f26847c;
        } else if (i10 == 1) {
            this.f58208p0 = kVar.f26847c;
        }
    }

    @Override // za.h1
    public /* synthetic */ void D(h1.b bVar, String str) {
        g1.c0(this, bVar, str);
    }

    @Override // za.h1
    public /* synthetic */ void E(h1.b bVar) {
        g1.t(this, bVar);
    }

    @Override // za.h1
    public /* synthetic */ void F(h1.b bVar, String str, long j10) {
        g1.b0(this, bVar, str, j10);
    }

    @Override // za.h1
    public /* synthetic */ void G(h1.b bVar, int i10, eb.d dVar) {
        g1.m(this, bVar, i10, dVar);
    }

    @Override // za.h1
    public /* synthetic */ void H(h1.b bVar, Surface surface) {
        g1.Q(this, bVar, surface);
    }

    @Override // za.h1
    public /* synthetic */ void I(h1.b bVar, int i10, String str, long j10) {
        g1.o(this, bVar, i10, str, j10);
    }

    @Override // za.h1
    public /* synthetic */ void J(h1.b bVar) {
        g1.S(this, bVar);
    }

    @Override // za.h1
    public /* synthetic */ void K(h1.b bVar) {
        g1.w(this, bVar);
    }

    @Override // za.h1
    public /* synthetic */ void L(h1.b bVar, eb.d dVar) {
        g1.d(this, bVar, dVar);
    }

    @Override // za.h1
    public /* synthetic */ void M(h1.b bVar, ec.j jVar, ec.k kVar) {
        g1.B(this, bVar, jVar, kVar);
    }

    @Override // za.h1
    public /* synthetic */ void N(h1.b bVar, ExoPlaybackException exoPlaybackException) {
        g1.M(this, bVar, exoPlaybackException);
    }

    @Override // za.h1
    public /* synthetic */ void O(h1.b bVar, eb.d dVar) {
        g1.e(this, bVar, dVar);
    }

    @Override // za.h1
    public /* synthetic */ void P(h1.b bVar, int i10, eb.d dVar) {
        g1.n(this, bVar, i10, dVar);
    }

    @Override // za.h1
    public /* synthetic */ void Q(h1.b bVar, TrackGroupArray trackGroupArray, ad.i iVar) {
        g1.Z(this, bVar, trackGroupArray, iVar);
    }

    @Override // za.h1
    public /* synthetic */ void R(h1.b bVar, int i10, Format format) {
        g1.p(this, bVar, i10, format);
    }

    @Override // za.h1
    public /* synthetic */ void S(h1.b bVar, int i10, long j10, long j11) {
        g1.k(this, bVar, i10, j10, j11);
    }

    @Override // za.h1
    public /* synthetic */ void T(h1.b bVar, long j10, int i10) {
        g1.f0(this, bVar, j10, i10);
    }

    @Override // za.h1
    public void U(h1.b bVar) {
        this.f58201i0 = bVar;
    }

    @Override // za.h1
    public /* synthetic */ void V(h1.b bVar, ec.j jVar, ec.k kVar) {
        g1.C(this, bVar, jVar, kVar);
    }

    @Override // za.k1.a
    public void W(h1.b bVar, String str, boolean z10) {
        if (str.equals(this.f58200h0)) {
            this.f58200h0 = null;
        } else if (str.equals(this.f58199g0)) {
            this.f58199g0 = null;
        }
        b bVar2 = (b) hd.a.g(this.f58193a0.remove(str));
        h1.b bVar3 = (h1.b) hd.a.g(this.f58194b0.remove(str));
        bVar2.n(bVar, z10);
        l1 l1VarA = bVar2.a(true);
        this.f58198f0 = l1.W(this.f58198f0, l1VarA);
        a aVar = this.f58195c0;
        if (aVar != null) {
            aVar.a(bVar3, l1VarA);
        }
    }

    @Override // za.h1
    public /* synthetic */ void X(h1.b bVar, int i10) {
        g1.i(this, bVar, i10);
    }

    @Override // za.h1
    public /* synthetic */ void Y(h1.b bVar, eb.d dVar) {
        g1.d0(this, bVar, dVar);
    }

    @Override // za.h1
    public /* synthetic */ void Z(h1.b bVar) {
        g1.u(this, bVar);
    }

    @Override // za.h1
    public /* synthetic */ void a(h1.b bVar, boolean z10) {
        g1.A(this, bVar, z10);
    }

    @Override // za.h1
    public /* synthetic */ void a0(h1.b bVar) {
        g1.N(this, bVar);
    }

    @Override // za.h1
    public /* synthetic */ void b(h1.b bVar, boolean z10) {
        g1.U(this, bVar, z10);
    }

    @Override // za.h1
    public /* synthetic */ void b0(h1.b bVar, float f10) {
        g1.j0(this, bVar, f10);
    }

    @Override // za.h1
    public /* synthetic */ void c(h1.b bVar, Format format) {
        g1.g0(this, bVar, format);
    }

    @Override // za.h1
    public /* synthetic */ void c0(h1.b bVar, ec.j jVar, ec.k kVar) {
        g1.E(this, bVar, jVar, kVar);
    }

    @Override // za.h1
    public /* synthetic */ void d(h1.b bVar, boolean z10) {
        g1.V(this, bVar, z10);
    }

    @Override // za.k1.a
    public void d0(h1.b bVar, String str) {
        ((b) hd.a.g(this.f58193a0.get(str))).o();
        l.a aVar = bVar.f58102d;
        if (aVar == null || !aVar.b()) {
            this.f58199g0 = str;
        } else {
            this.f58200h0 = str;
        }
    }

    @Override // za.h1
    public void e(h1.b bVar, ec.j jVar, ec.k kVar, IOException iOException, boolean z10) {
        this.f58204l0 = iOException;
    }

    @Override // za.h1
    public /* synthetic */ void e0(h1.b bVar, List list) {
        g1.W(this, bVar, list);
    }

    @Override // za.h1
    public /* synthetic */ void f(h1.b bVar, Exception exc) {
        g1.j(this, bVar, exc);
    }

    @Override // za.h1
    public /* synthetic */ void f0(h1.b bVar, eb.d dVar) {
        g1.e0(this, bVar, dVar);
    }

    @Override // za.h1
    public /* synthetic */ void g(h1.b bVar, ya.v0 v0Var, int i10) {
        g1.G(this, bVar, v0Var, i10);
    }

    @Override // za.h1
    public /* synthetic */ void g0(h1.b bVar, int i10) {
        g1.R(this, bVar, i10);
    }

    @Override // za.h1
    public void h(h1.b bVar, int i10, int i11, int i12, float f10) {
        this.f58210r0 = i10;
        this.f58209q0 = i11;
    }

    @Override // za.h1
    public /* synthetic */ void h0(h1.b bVar) {
        g1.s(this, bVar);
    }

    @Override // za.h1
    public /* synthetic */ void i(h1.b bVar, String str) {
        g1.c(this, bVar, str);
    }

    @Override // za.h1
    public void i0(ya.j1 j1Var, h1.c cVar) {
        if (cVar.f() == 0) {
            return;
        }
        s0(j1Var, cVar);
        for (String str : this.f58193a0.keySet()) {
            Pair<h1.b, Boolean> pairO0 = o0(cVar, str);
            b bVar = this.f58193a0.get(str);
            boolean z10 = r0(cVar, str, 12) || r0(cVar, str, 0);
            boolean zR0 = r0(cVar, str, 1023);
            boolean zR02 = r0(cVar, str, 1012);
            boolean zR03 = r0(cVar, str, 1000);
            boolean zR04 = r0(cVar, str, 11);
            boolean z11 = r0(cVar, str, 1003) || r0(cVar, str, h1.U);
            boolean zR05 = r0(cVar, str, 1006);
            boolean zR06 = r0(cVar, str, 1004);
            boolean zR07 = r0(cVar, str, 1028);
            bVar.m(j1Var, (h1.b) pairO0.first, ((Boolean) pairO0.second).booleanValue(), this.f58201i0 != null, z10, zR0 ? this.f58203k0 : 0, zR02, zR03, zR04 ? j1Var.w0() : null, z11 ? this.f58204l0 : null, zR05 ? this.f58205m0 : 0L, zR05 ? this.f58206n0 : 0L, zR06 ? this.f58207o0 : null, zR06 ? this.f58208p0 : null, zR07 ? this.f58209q0 : -1, zR07 ? this.f58210r0 : -1);
        }
        this.f58201i0 = null;
        this.f58207o0 = null;
        this.f58208p0 = null;
        if (cVar.c(h1.Y)) {
            this.Z.b(cVar.g(h1.Y));
        }
    }

    @Override // za.h1
    public /* synthetic */ void j(h1.b bVar, boolean z10, int i10) {
        g1.O(this, bVar, z10, i10);
    }

    @Override // za.h1
    public /* synthetic */ void j0(h1.b bVar, Format format, eb.e eVar) {
        g1.h0(this, bVar, format, eVar);
    }

    @Override // za.k1.a
    public void k(h1.b bVar, String str) {
        this.f58193a0.put(str, new b(this.f58196d0, bVar));
        this.f58194b0.put(str, bVar);
    }

    @Override // za.h1
    public /* synthetic */ void k0(h1.b bVar, int i10) {
        g1.Y(this, bVar, i10);
    }

    @Override // za.h1
    public /* synthetic */ void l(h1.b bVar, int i10) {
        g1.K(this, bVar, i10);
    }

    @Override // za.h1
    public /* synthetic */ void l0(h1.b bVar, Format format, eb.e eVar) {
        g1.g(this, bVar, format, eVar);
    }

    @Override // za.h1
    public /* synthetic */ void m(h1.b bVar, ab.d dVar) {
        g1.a(this, bVar, dVar);
    }

    @Override // za.h1
    public /* synthetic */ void m0(h1.b bVar, int i10, int i11) {
        g1.X(this, bVar, i10, i11);
    }

    @Override // za.h1
    public /* synthetic */ void n(h1.b bVar, ya.h1 h1Var) {
        g1.J(this, bVar, h1Var);
    }

    @Override // za.h1
    public /* synthetic */ void n0(h1.b bVar, ec.k kVar) {
        g1.a0(this, bVar, kVar);
    }

    @Override // za.h1
    public /* synthetic */ void o(h1.b bVar, long j10) {
        g1.h(this, bVar, j10);
    }

    public final Pair<h1.b, Boolean> o0(h1.c cVar, String str) {
        l.a aVar;
        h1.b bVar = this.f58201i0;
        boolean zE = bVar != null && this.Z.e(bVar, str);
        for (int i10 = 0; i10 < cVar.f(); i10++) {
            h1.b bVarG = cVar.g(cVar.e(i10));
            boolean zE2 = this.Z.e(bVarG, str);
            if (bVar == null || ((zE2 && !zE) || (zE2 == zE && bVarG.f58099a > bVar.f58099a))) {
                bVar = bVarG;
                zE = zE2;
            }
        }
        hd.a.g(bVar);
        if (!zE && (aVar = bVar.f58102d) != null && aVar.b()) {
            long jF = bVar.f58100b.h(bVar.f58102d.f26856a, this.f58197e0).f(bVar.f58102d.f26857b);
            if (jF == Long.MIN_VALUE) {
                jF = this.f58197e0.f57235d;
            }
            long jN = jF + this.f58197e0.n();
            long j10 = bVar.f58099a;
            x1 x1Var = bVar.f58100b;
            int i11 = bVar.f58101c;
            l.a aVar2 = bVar.f58102d;
            h1.b bVar2 = new h1.b(j10, x1Var, i11, new l.a(aVar2.f26856a, aVar2.f26859d, aVar2.f26857b), ya.g.d(jN), bVar.f58100b, bVar.f58105g, bVar.f58106h, bVar.f58107i, bVar.f58108j);
            zE = this.Z.e(bVar2, str);
            bVar = bVar2;
        }
        return Pair.create(bVar, Boolean.valueOf(zE));
    }

    @Override // za.h1
    public /* synthetic */ void p(h1.b bVar, Format format) {
        g1.f(this, bVar, format);
    }

    public l1 p0() {
        int i10 = 1;
        l1[] l1VarArr = new l1[this.f58193a0.size() + 1];
        l1VarArr[0] = this.f58198f0;
        Iterator<b> it2 = this.f58193a0.values().iterator();
        while (it2.hasNext()) {
            l1VarArr[i10] = it2.next().a(false);
            i10++;
        }
        return l1.W(l1VarArr);
    }

    @Override // za.k1.a
    public void q(h1.b bVar, String str, String str2) {
        ((b) hd.a.g(this.f58193a0.get(str))).p();
    }

    @g.p0
    public l1 q0() {
        b bVar;
        String str = this.f58200h0;
        if (str != null) {
            bVar = this.f58193a0.get(str);
        } else {
            String str2 = this.f58199g0;
            bVar = str2 != null ? this.f58193a0.get(str2) : null;
        }
        if (bVar == null) {
            return null;
        }
        return bVar.a(false);
    }

    @Override // za.h1
    public /* synthetic */ void r(h1.b bVar, boolean z10) {
        g1.z(this, bVar, z10);
    }

    public final boolean r0(h1.c cVar, String str, int i10) {
        return cVar.c(i10) && this.Z.e(cVar.g(i10), str);
    }

    @Override // za.h1
    public void s(h1.b bVar, int i10, long j10) {
        this.f58203k0 = i10;
    }

    public final void s0(ya.j1 j1Var, h1.c cVar) {
        boolean z10 = j1Var.n1().r() && j1Var.d() == 1;
        for (int i10 = 0; i10 < cVar.f(); i10++) {
            int iE = cVar.e(i10);
            h1.b bVarG = cVar.g(iE);
            if (iE == 0) {
                this.Z.c(bVarG);
            } else if (!z10 && iE == 12) {
                this.Z.g(bVarG, this.f58202j0);
            } else if (!z10) {
                this.Z.a(bVarG);
            }
        }
    }

    @Override // za.h1
    public void t(h1.b bVar, int i10, long j10, long j11) {
        this.f58205m0 = i10;
        this.f58206n0 = j10;
    }

    @Override // za.h1
    public /* synthetic */ void u(h1.b bVar) {
        g1.r(this, bVar);
    }

    @Override // za.h1
    public /* synthetic */ void v(h1.b bVar, Metadata metadata) {
        g1.H(this, bVar, metadata);
    }

    @Override // za.h1
    public void w(h1.b bVar, int i10) {
        this.f58202j0 = i10;
    }

    @Override // za.h1
    public /* synthetic */ void x(h1.b bVar, boolean z10, int i10) {
        g1.I(this, bVar, z10, i10);
    }

    @Override // za.h1
    public /* synthetic */ void y(h1.b bVar, String str, long j10) {
        g1.b(this, bVar, str, j10);
    }

    @Override // za.h1
    public void z(h1.b bVar, Exception exc) {
        this.f58204l0 = exc;
    }
}
