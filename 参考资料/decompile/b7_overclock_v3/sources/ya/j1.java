package ya;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public interface j1 {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final int E = 4;
    public static final int F = 5;
    public static final int G = 6;
    public static final int H = 7;
    public static final int I = 8;
    public static final int J = 9;
    public static final int K = 10;
    public static final int L = 11;
    public static final int M = 12;
    public static final int N = 13;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f56829b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56830c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56831d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56832e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f56833f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f56834g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f56835h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f56836i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f56837j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f56838k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f56839l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f56840m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f56841n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f56842o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f56843p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f56844q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f56845r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f56846s = 3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f56847t = 4;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f56848u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f56849v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f56850w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f56851x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f56852y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f56853z = 3;

    public interface a {
        void I1();

        float Y();

        void a0(ab.h hVar);

        ab.d b();

        void h(int i10);

        void l(ab.u uVar);

        void m(float f10);

        boolean n();

        void o(boolean z10);

        int q1();

        void u(ab.h hVar);

        void y1(ab.d dVar, boolean z10);
    }

    @Deprecated
    public static abstract class b implements f {
        @Override // ya.j1.f
        public /* synthetic */ void B(boolean z10) {
            k1.c(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void D(boolean z10, int i10) {
            k1.m(this, z10, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void R(boolean z10, int i10) {
            k1.h(this, z10, i10);
        }

        @Override // ya.j1.f
        public void S(x1 x1Var, int i10) {
            f(x1Var, x1Var.q() == 1 ? x1Var.n(0, new x1.c()).f57243d : null, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void V(boolean z10) {
            k1.b(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void Z(v0 v0Var, int i10) {
            k1.g(this, v0Var, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void b(h1 h1Var) {
            k1.i(this, h1Var);
        }

        @Override // ya.j1.f
        public /* synthetic */ void b0(boolean z10) {
            k1.e(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void e(int i10) {
            k1.k(this, i10);
        }

        @Override // ya.j1.f
        public void f(x1 x1Var, @g.p0 Object obj, int i10) {
        }

        @Override // ya.j1.f
        public /* synthetic */ void g(boolean z10) {
            k1.f(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void h(TrackGroupArray trackGroupArray, ad.i iVar) {
            k1.u(this, trackGroupArray, iVar);
        }

        @Override // ya.j1.f
        public /* synthetic */ void i(int i10) {
            k1.n(this, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void k(List list) {
            k1.r(this, list);
        }

        @Override // ya.j1.f
        public /* synthetic */ void m(ExoPlaybackException exoPlaybackException) {
            k1.l(this, exoPlaybackException);
        }

        @Override // ya.j1.f
        public /* synthetic */ void n(boolean z10) {
            k1.d(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void o() {
            k1.p(this);
        }

        @Override // ya.j1.f
        public /* synthetic */ void p(j1 j1Var, g gVar) {
            k1.a(this, j1Var, gVar);
        }

        @Override // ya.j1.f
        public /* synthetic */ void r(int i10) {
            k1.j(this, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void v(int i10) {
            k1.o(this, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void y(boolean z10) {
            k1.q(this, z10);
        }
    }

    public interface c {
        void B1(fb.c cVar);

        void J0(fb.c cVar);

        void a1(boolean z10);

        fb.a c0();

        void d0();

        boolean o1();

        int p();

        void t1();

        void w1(int i10);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    public interface f {
        void B(boolean z10);

        @Deprecated
        void D(boolean z10, int i10);

        void R(boolean z10, int i10);

        void S(x1 x1Var, int i10);

        void V(boolean z10);

        void Z(@g.p0 v0 v0Var, int i10);

        void b(h1 h1Var);

        void b0(boolean z10);

        void e(int i10);

        @Deprecated
        void f(x1 x1Var, @g.p0 Object obj, int i10);

        @Deprecated
        void g(boolean z10);

        void h(TrackGroupArray trackGroupArray, ad.i iVar);

        void i(int i10);

        void k(List<Metadata> list);

        void m(ExoPlaybackException exoPlaybackException);

        void n(boolean z10);

        @Deprecated
        void o();

        void p(j1 j1Var, g gVar);

        void r(int i10);

        void v(int i10);

        void y(boolean z10);
    }

    public static final class g extends hd.x {
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
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    public interface i {
        void A0(ub.e eVar);

        void u0(ub.e eVar);
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

    public interface n {
        void I(qc.k kVar);

        List<qc.b> Q0();

        void z(qc.k kVar);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface o {
    }

    public interface p {
        void B0(id.o oVar);

        void C(id.l lVar);

        void F(@g.p0 Surface surface);

        void G1(@g.p0 SurfaceHolder surfaceHolder);

        void P0(id.o oVar);

        void S0(jd.a aVar);

        void V0(jd.a aVar);

        void W(@g.p0 TextureView textureView);

        void a(int i10);

        void d1(id.l lVar);

        void e1(@g.p0 SurfaceView surfaceView);

        void g0(@g.p0 SurfaceView surfaceView);

        void q(@g.p0 Surface surface);

        void q0();

        int r1();

        void t0(@g.p0 SurfaceHolder surfaceHolder);

        void x1(@g.p0 TextureView textureView);
    }

    long A();

    ad.i A1();

    void B(int i10, long j10);

    long C0();

    boolean D();

    void D0(v0 v0Var);

    void D1(v0 v0Var, long j10);

    void E();

    void E0(int i10, List<v0> list);

    int E1(int i10);

    int F0();

    void F1(List<v0> list);

    @g.p0
    v0 G();

    void G0(v0 v0Var);

    void H(boolean z10);

    @g.p0
    Object H0();

    long H1();

    long I0();

    @Deprecated
    void J(boolean z10);

    void J1(int i10, v0 v0Var);

    void K0(f fVar);

    @g.p0
    n K1();

    int N();

    boolean N0();

    int O();

    List<Metadata> P();

    v0 Q(int i10);

    @g.p0
    @Deprecated
    ExoPlaybackException S();

    long T();

    int T0();

    int U();

    boolean V();

    int X0();

    void Y0(v0 v0Var, boolean z10);

    void Z();

    void b0(List<v0> list, boolean z10);

    void c(@g.p0 h1 h1Var);

    int d();

    h1 e();

    void f();

    int f0();

    void f1(int i10, int i11);

    void g(long j10);

    boolean g1();

    void h1(int i10, int i11, int i12);

    boolean hasNext();

    boolean hasPrevious();

    void i();

    @g.p0
    i i1();

    boolean isLoading();

    void j(int i10);

    boolean j0();

    int j1();

    int k();

    @g.p0
    @Deprecated
    Object k0();

    void k1(List<v0> list);

    @g.p0
    c l0();

    TrackGroupArray l1();

    void m0(int i10);

    long m1();

    int n0();

    x1 n1();

    void next();

    void p0(int i10, int i11);

    Looper p1();

    void pause();

    void previous();

    boolean r();

    int r0();

    void release();

    @g.p0
    a s0();

    void stop();

    boolean u1();

    void v0(List<v0> list, int i10, long j10);

    long v1();

    @g.p0
    ExoPlaybackException w0();

    long x();

    void x0(boolean z10);

    void y(f fVar);

    @g.p0
    p y0();

    void z0(int i10);
}
