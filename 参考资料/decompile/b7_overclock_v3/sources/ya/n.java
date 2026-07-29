package ya;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;
import ya.j;
import ya.l1;

/* JADX INFO: loaded from: classes3.dex */
public interface n extends j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f56957a = 500;

    void C1(com.google.android.exoplayer2.source.l lVar, boolean z10);

    hd.c K();

    @g.p0
    ad.j L();

    void L0(List<com.google.android.exoplayer2.source.l> list, boolean z10);

    void M(com.google.android.exoplayer2.source.l lVar);

    void M0(boolean z10);

    Looper O0();

    void R(int i10, List<com.google.android.exoplayer2.source.l> list);

    void R0(com.google.android.exoplayer2.source.t tVar);

    boolean U0();

    @Deprecated
    void W0(com.google.android.exoplayer2.source.l lVar);

    void X(com.google.android.exoplayer2.source.l lVar);

    void Z0(boolean z10);

    void b1(List<com.google.android.exoplayer2.source.l> list, int i10, long j10);

    t1 c1();

    void e0(boolean z10);

    void h0(List<com.google.android.exoplayer2.source.l> list);

    void i0(int i10, com.google.android.exoplayer2.source.l lVar);

    void o0(List<com.google.android.exoplayer2.source.l> list);

    void s(com.google.android.exoplayer2.source.l lVar, long j10);

    l1 s1(l1.b bVar);

    @Deprecated
    void t(com.google.android.exoplayer2.source.l lVar, boolean z10, boolean z11);

    @Deprecated
    void v();

    boolean w();

    void z1(@g.p0 t1 t1Var);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o1[] f56958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public hd.c f56959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ad.j f56960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ec.x f56961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public u0 f56962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ed.d f56963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Looper f56964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @g.p0
        public za.f1 f56965h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f56966i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public t1 f56967j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f56968k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f56969l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public t0 f56970m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f56971n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f56972o;

        public a(Context context, o1... o1VarArr) {
            this(o1VarArr, new DefaultTrackSelector(context), new com.google.android.exoplayer2.source.e(context), new k(), ed.n.l(context));
        }

        public n a() {
            hd.a.i(!this.f56971n);
            this.f56971n = true;
            m0 m0Var = new m0(this.f56958a, this.f56960c, this.f56961d, this.f56962e, this.f56963f, this.f56965h, this.f56966i, this.f56967j, this.f56970m, this.f56969l, this.f56968k, this.f56959b, this.f56964g, null);
            long j10 = this.f56972o;
            if (j10 > 0) {
                m0Var.l2(j10);
            }
            return m0Var;
        }

        public a b(long j10) {
            this.f56972o = j10;
            return this;
        }

        public a c(za.f1 f1Var) {
            hd.a.i(!this.f56971n);
            this.f56965h = f1Var;
            return this;
        }

        public a d(ed.d dVar) {
            hd.a.i(!this.f56971n);
            this.f56963f = dVar;
            return this;
        }

        @g.i1
        public a e(hd.c cVar) {
            hd.a.i(!this.f56971n);
            this.f56959b = cVar;
            return this;
        }

        public a f(t0 t0Var) {
            hd.a.i(!this.f56971n);
            this.f56970m = t0Var;
            return this;
        }

        public a g(u0 u0Var) {
            hd.a.i(!this.f56971n);
            this.f56962e = u0Var;
            return this;
        }

        public a h(Looper looper) {
            hd.a.i(!this.f56971n);
            this.f56964g = looper;
            return this;
        }

        public a i(ec.x xVar) {
            hd.a.i(!this.f56971n);
            this.f56961d = xVar;
            return this;
        }

        public a j(boolean z10) {
            hd.a.i(!this.f56971n);
            this.f56968k = z10;
            return this;
        }

        public a k(long j10) {
            hd.a.i(!this.f56971n);
            this.f56969l = j10;
            return this;
        }

        public a l(t1 t1Var) {
            hd.a.i(!this.f56971n);
            this.f56967j = t1Var;
            return this;
        }

        public a m(ad.j jVar) {
            hd.a.i(!this.f56971n);
            this.f56960c = jVar;
            return this;
        }

        public a n(boolean z10) {
            hd.a.i(!this.f56971n);
            this.f56966i = z10;
            return this;
        }

        public a(o1[] o1VarArr, ad.j jVar, ec.x xVar, u0 u0Var, ed.d dVar) {
            hd.a.a(o1VarArr.length > 0);
            this.f56958a = o1VarArr;
            this.f56960c = jVar;
            this.f56961d = xVar;
            this.f56962e = u0Var;
            this.f56963f = dVar;
            this.f56964g = hd.u0.X();
            this.f56966i = true;
            this.f56967j = t1.f57074g;
            this.f56970m = new j.b().a();
            this.f56959b = hd.c.f30965a;
            this.f56969l = 500L;
        }
    }
}
