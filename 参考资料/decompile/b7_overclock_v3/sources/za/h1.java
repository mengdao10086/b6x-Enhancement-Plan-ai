package za;

import android.util.SparseArray;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import com.google.common.base.Objects;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public interface h1 {
    public static final int A = 1012;
    public static final int B = 1013;
    public static final int C = 1014;
    public static final int D = 1015;
    public static final int E = 1016;
    public static final int F = 1017;
    public static final int G = 1018;
    public static final int H = 1019;
    public static final int I = 1020;
    public static final int J = 1021;
    public static final int K = 1022;
    public static final int L = 1023;
    public static final int M = 1024;
    public static final int N = 1025;
    public static final int O = 1026;
    public static final int P = 1027;
    public static final int Q = 1028;
    public static final int R = 1029;
    public static final int S = 1030;
    public static final int T = 1031;
    public static final int U = 1032;
    public static final int V = 1033;
    public static final int W = 1034;
    public static final int X = 1035;
    public static final int Y = 1036;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f58073a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f58074b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f58075c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58076d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58077e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f58078f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f58079g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f58080h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f58081i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f58082j = 9;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f58083k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f58084l = 11;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f58085m = 12;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f58086n = 13;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f58087o = 1000;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f58088p = 1001;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f58089q = 1002;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f58090r = 1003;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f58091s = 1004;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f58092t = 1005;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f58093u = 1006;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f58094v = 1007;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f58095w = 1008;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f58096x = 1009;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f58097y = 1010;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f58098z = 1011;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f58099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x1 f58100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f58101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.p0
        public final l.a f58102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f58103e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final x1 f58104f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f58105g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @g.p0
        public final l.a f58106h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f58107i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f58108j;

        public b(long j10, x1 x1Var, int i10, @g.p0 l.a aVar, long j11, x1 x1Var2, int i11, @g.p0 l.a aVar2, long j12, long j13) {
            this.f58099a = j10;
            this.f58100b = x1Var;
            this.f58101c = i10;
            this.f58102d = aVar;
            this.f58103e = j11;
            this.f58104f = x1Var2;
            this.f58105g = i11;
            this.f58106h = aVar2;
            this.f58107i = j12;
            this.f58108j = j13;
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f58099a == bVar.f58099a && this.f58101c == bVar.f58101c && this.f58103e == bVar.f58103e && this.f58105g == bVar.f58105g && this.f58107i == bVar.f58107i && this.f58108j == bVar.f58108j && Objects.equal(this.f58100b, bVar.f58100b) && Objects.equal(this.f58102d, bVar.f58102d) && Objects.equal(this.f58104f, bVar.f58104f) && Objects.equal(this.f58106h, bVar.f58106h);
        }

        public int hashCode() {
            return Objects.hashCode(Long.valueOf(this.f58099a), this.f58100b, Integer.valueOf(this.f58101c), this.f58102d, Long.valueOf(this.f58103e), this.f58104f, Integer.valueOf(this.f58105g), this.f58106h, Long.valueOf(this.f58107i), Long.valueOf(this.f58108j));
        }
    }

    public static final class c extends hd.x {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<b> f58109b = new SparseArray<>(0);

        @Override // hd.x
        public boolean c(int i10) {
            return super.c(i10);
        }

        @Override // hd.x
        public boolean d(int... iArr) {
            return super.d(iArr);
        }

        @Override // hd.x
        public int e(int i10) {
            return super.e(i10);
        }

        public b g(int i10) {
            return (b) hd.a.g(this.f58109b.get(i10));
        }

        public void h(SparseArray<b> sparseArray) {
            this.f58109b.clear();
            for (int i10 = 0; i10 < f(); i10++) {
                int iE = e(i10);
                this.f58109b.append(iE, (b) hd.a.g(sparseArray.get(iE)));
            }
        }
    }

    @Deprecated
    void A(b bVar, boolean z10);

    void B(b bVar, int i10);

    void C(b bVar, ec.k kVar);

    void D(b bVar, String str);

    void E(b bVar);

    void F(b bVar, String str, long j10);

    @Deprecated
    void G(b bVar, int i10, eb.d dVar);

    void H(b bVar, @g.p0 Surface surface);

    @Deprecated
    void I(b bVar, int i10, String str, long j10);

    @Deprecated
    void J(b bVar);

    void K(b bVar);

    void L(b bVar, eb.d dVar);

    void M(b bVar, ec.j jVar, ec.k kVar);

    void N(b bVar, ExoPlaybackException exoPlaybackException);

    void O(b bVar, eb.d dVar);

    @Deprecated
    void P(b bVar, int i10, eb.d dVar);

    void Q(b bVar, TrackGroupArray trackGroupArray, ad.i iVar);

    @Deprecated
    void R(b bVar, int i10, Format format);

    void S(b bVar, int i10, long j10, long j11);

    void T(b bVar, long j10, int i10);

    void U(b bVar);

    void V(b bVar, ec.j jVar, ec.k kVar);

    void X(b bVar, int i10);

    void Y(b bVar, eb.d dVar);

    void Z(b bVar);

    void a(b bVar, boolean z10);

    void a0(b bVar);

    void b(b bVar, boolean z10);

    void b0(b bVar, float f10);

    @Deprecated
    void c(b bVar, Format format);

    void c0(b bVar, ec.j jVar, ec.k kVar);

    void d(b bVar, boolean z10);

    void e(b bVar, ec.j jVar, ec.k kVar, IOException iOException, boolean z10);

    void e0(b bVar, List<Metadata> list);

    void f(b bVar, Exception exc);

    void f0(b bVar, eb.d dVar);

    void g(b bVar, @g.p0 ya.v0 v0Var, int i10);

    void g0(b bVar, int i10);

    void h(b bVar, int i10, int i11, int i12, float f10);

    void h0(b bVar);

    void i(b bVar, String str);

    void i0(ya.j1 j1Var, c cVar);

    @Deprecated
    void j(b bVar, boolean z10, int i10);

    void j0(b bVar, Format format, @g.p0 eb.e eVar);

    void k0(b bVar, int i10);

    void l(b bVar, int i10);

    void l0(b bVar, Format format, @g.p0 eb.e eVar);

    void m(b bVar, ab.d dVar);

    void m0(b bVar, int i10, int i11);

    void n(b bVar, ya.h1 h1Var);

    void n0(b bVar, ec.k kVar);

    void o(b bVar, long j10);

    @Deprecated
    void p(b bVar, Format format);

    void r(b bVar, boolean z10);

    void s(b bVar, int i10, long j10);

    void t(b bVar, int i10, long j10, long j11);

    void u(b bVar);

    void v(b bVar, Metadata metadata);

    void w(b bVar, int i10);

    void x(b bVar, boolean z10, int i10);

    void y(b bVar, String str, long j10);

    void z(b bVar, Exception exc);
}
