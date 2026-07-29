package ya;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.t;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import hd.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ya.d1;
import ya.j1;
import ya.l1;
import ya.q0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends e implements n {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f56929s0 = "ExoPlayerImpl";
    public final ad.k P;
    public final o1[] Q;
    public final ad.j R;
    public final hd.n S;
    public final q0.f T;
    public final q0 U;
    public final hd.s<j1.f, j1.g> V;
    public final x1.b W;
    public final List<a> X;
    public final boolean Y;
    public final ec.x Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @g.p0
    public final za.f1 f56930a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final Looper f56931b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final ed.d f56932c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final hd.c f56933d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f56934e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f56935f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f56936g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f56937h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f56938i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f56939j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f56940k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public t1 f56941l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public com.google.android.exoplayer2.source.t f56942m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f56943n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public g1 f56944o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f56945p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f56946q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public long f56947r0;

    public static final class a implements b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f56948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public x1 f56949b;

        public a(Object obj, x1 x1Var) {
            this.f56948a = obj;
            this.f56949b = x1Var;
        }

        @Override // ya.b1
        public Object a() {
            return this.f56948a;
        }

        @Override // ya.b1
        public x1 b() {
            return this.f56949b;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public m0(o1[] o1VarArr, ad.j jVar, ec.x xVar, u0 u0Var, ed.d dVar, @g.p0 za.f1 f1Var, boolean z10, t1 t1Var, t0 t0Var, long j10, boolean z11, hd.c cVar, Looper looper, @g.p0 j1 j1Var) {
        hd.t.i(f56929s0, "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + r0.f57056c + "] [" + hd.u0.f31158e + "]");
        hd.a.i(o1VarArr.length > 0);
        this.Q = (o1[]) hd.a.g(o1VarArr);
        this.R = (ad.j) hd.a.g(jVar);
        this.Z = xVar;
        this.f56932c0 = dVar;
        this.f56930a0 = f1Var;
        this.Y = z10;
        this.f56941l0 = t1Var;
        this.f56943n0 = z11;
        this.f56931b0 = looper;
        this.f56933d0 = cVar;
        this.f56934e0 = 0;
        final j1 j1Var2 = j1Var != null ? j1Var : this;
        this.V = new hd.s<>(looper, cVar, new Supplier() { // from class: ya.p
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new j1.g();
            }
        }, new s.b() { // from class: ya.b0
            @Override // hd.s.b
            public final void a(Object obj, hd.x xVar2) {
                ((j1.f) obj).p(j1Var2, (j1.g) xVar2);
            }
        });
        this.X = new ArrayList();
        this.f56942m0 = new t.a(0);
        ad.k kVar = new ad.k(new r1[o1VarArr.length], new com.google.android.exoplayer2.trackselection.b[o1VarArr.length], null);
        this.P = kVar;
        this.W = new x1.b();
        this.f56945p0 = -1;
        this.S = cVar.c(looper, null);
        q0.f fVar = new q0.f() { // from class: ya.d0
            @Override // ya.q0.f
            public final void a(q0.e eVar) {
                this.f56603a.t2(eVar);
            }
        };
        this.T = fVar;
        this.f56944o0 = g1.k(kVar);
        if (f1Var != null) {
            f1Var.C2(j1Var2, looper);
            y(f1Var);
            dVar.c(new Handler(looper), f1Var);
        }
        this.U = new q0(o1VarArr, jVar, kVar, u0Var, dVar, this.f56934e0, this.f56935f0, f1Var, t1Var, t0Var, j10, z11, looper, cVar, fVar);
    }

    public static /* synthetic */ void A2(g1 g1Var, j1.f fVar) {
        fVar.D(g1Var.f56775k, g1Var.f56768d);
    }

    public static /* synthetic */ void B2(g1 g1Var, j1.f fVar) {
        fVar.r(g1Var.f56768d);
    }

    public static /* synthetic */ void C2(g1 g1Var, int i10, j1.f fVar) {
        fVar.R(g1Var.f56775k, i10);
    }

    public static /* synthetic */ void D2(g1 g1Var, j1.f fVar) {
        fVar.e(g1Var.f56776l);
    }

    public static /* synthetic */ void E2(g1 g1Var, j1.f fVar) {
        fVar.b0(q2(g1Var));
    }

    public static /* synthetic */ void F2(g1 g1Var, j1.f fVar) {
        fVar.b(g1Var.f56777m);
    }

    public static /* synthetic */ void G2(g1 g1Var, j1.f fVar) {
        fVar.V(g1Var.f56778n);
    }

    public static /* synthetic */ void H2(g1 g1Var, j1.f fVar) {
        fVar.B(g1Var.f56779o);
    }

    public static /* synthetic */ void I2(g1 g1Var, int i10, j1.f fVar) {
        fVar.S(g1Var.f56765a, i10);
    }

    public static /* synthetic */ void L2(g1 g1Var, j1.f fVar) {
        fVar.m(g1Var.f56769e);
    }

    public static boolean q2(g1 g1Var) {
        return g1Var.f56768d == 3 && g1Var.f56775k && g1Var.f56776l == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(final q0.e eVar) {
        this.S.c(new Runnable() { // from class: ya.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f56579a.s2(eVar);
            }
        });
    }

    public static /* synthetic */ void u2(j1.f fVar) {
        fVar.m(ExoPlaybackException.c(new ExoTimeoutException(1)));
    }

    public static /* synthetic */ void x2(g1 g1Var, ad.i iVar, j1.f fVar) {
        fVar.h(g1Var.f56771g, iVar);
    }

    public static /* synthetic */ void y2(g1 g1Var, j1.f fVar) {
        fVar.k(g1Var.f56773i);
    }

    public static /* synthetic */ void z2(g1 g1Var, j1.f fVar) {
        fVar.n(g1Var.f56770f);
    }

    @Override // ya.j1
    public long A() {
        return g.d(this.f56944o0.f56781q);
    }

    @Override // ya.j1
    public ad.i A1() {
        return new ad.i(this.f56944o0.f56772h.f573c);
    }

    @Override // ya.j1
    public void B(int i10, long j10) {
        x1 x1Var = this.f56944o0.f56765a;
        if (i10 < 0 || (!x1Var.r() && i10 >= x1Var.q())) {
            throw new IllegalSeekPositionException(x1Var, i10, j10);
        }
        this.f56936g0++;
        if (!r()) {
            g1 g1VarM2 = M2(this.f56944o0.h(d() != 1 ? 2 : 1), x1Var, o2(x1Var, i10, j10));
            this.U.B0(x1Var, i10, g.c(j10));
            T2(g1VarM2, true, 1, 0, 1, true);
        } else {
            hd.t.n(f56929s0, "seekTo ignored because an ad is playing");
            q0.e eVar = new q0.e(this.f56944o0);
            eVar.b(1);
            this.T.a(eVar);
        }
    }

    @Override // ya.j1
    public long C0() {
        if (!r()) {
            return H1();
        }
        g1 g1Var = this.f56944o0;
        g1Var.f56765a.h(g1Var.f56766b.f26856a, this.W);
        g1 g1Var2 = this.f56944o0;
        return g1Var2.f56767c == g.f56663b ? g1Var2.f56765a.n(r0(), this.O).b() : this.W.m() + g.d(this.f56944o0.f56767c);
    }

    @Override // ya.n
    public void C1(com.google.android.exoplayer2.source.l lVar, boolean z10) {
        L0(Collections.singletonList(lVar), z10);
    }

    @Override // ya.j1
    public boolean D() {
        return this.f56944o0.f56775k;
    }

    @Override // ya.j1
    public void E() {
        p0(0, this.X.size());
    }

    @Override // ya.j1
    public void E0(int i10, List<v0> list) {
        R(i10, j2(list));
    }

    @Override // ya.j1
    public int E1(int i10) {
        return this.Q[i10].h();
    }

    @Override // ya.j1
    public void H(final boolean z10) {
        if (this.f56935f0 != z10) {
            this.f56935f0 = z10;
            this.U.a1(z10);
            this.V.l(10, new s.a() { // from class: ya.x
                @Override // hd.s.a
                public final void i(Object obj) {
                    ((j1.f) obj).y(z10);
                }
            });
        }
    }

    @Override // ya.j1
    public long H1() {
        if (this.f56944o0.f56765a.r()) {
            return this.f56947r0;
        }
        if (this.f56944o0.f56766b.b()) {
            return g.d(this.f56944o0.f56782r);
        }
        g1 g1Var = this.f56944o0;
        return N2(g1Var.f56766b, g1Var.f56782r);
    }

    @Override // ya.j1
    public long I0() {
        if (!r()) {
            return v1();
        }
        g1 g1Var = this.f56944o0;
        return g1Var.f56774j.equals(g1Var.f56766b) ? g.d(this.f56944o0.f56780p) : m1();
    }

    @Override // ya.j1
    public void J(boolean z10) {
        S2(z10, null);
    }

    @Override // ya.n
    public hd.c K() {
        return this.f56933d0;
    }

    @Override // ya.j1
    public void K0(j1.f fVar) {
        this.V.k(fVar);
    }

    @Override // ya.j1
    @g.p0
    public j1.n K1() {
        return null;
    }

    @Override // ya.n
    @g.p0
    public ad.j L() {
        return this.R;
    }

    @Override // ya.n
    public void L0(List<com.google.android.exoplayer2.source.l> list, boolean z10) {
        Q2(list, -1, g.f56663b, z10);
    }

    @Override // ya.n
    public void M(com.google.android.exoplayer2.source.l lVar) {
        h0(Collections.singletonList(lVar));
    }

    @Override // ya.n
    public void M0(boolean z10) {
        this.U.x(z10);
    }

    public final g1 M2(g1 g1Var, x1 x1Var, @g.p0 Pair<Object, Long> pair) {
        hd.a.a(x1Var.r() || pair != null);
        x1 x1Var2 = g1Var.f56765a;
        g1 g1VarJ = g1Var.j(x1Var);
        if (x1Var.r()) {
            l.a aVarL = g1.l();
            g1 g1VarB = g1VarJ.c(aVarL, g.c(this.f56947r0), g.c(this.f56947r0), 0L, TrackGroupArray.f17501d, this.P, ImmutableList.of()).b(aVarL);
            g1VarB.f56780p = g1VarB.f56782r;
            return g1VarB;
        }
        Object obj = g1VarJ.f56766b.f26856a;
        boolean z10 = !obj.equals(((Pair) hd.u0.k(pair)).first);
        l.a aVar = z10 ? new l.a(pair.first) : g1VarJ.f56766b;
        long jLongValue = ((Long) pair.second).longValue();
        long jC = g.c(C0());
        if (!x1Var2.r()) {
            jC -= x1Var2.h(obj, this.W).n();
        }
        if (z10 || jLongValue < jC) {
            hd.a.i(!aVar.b());
            g1 g1VarB2 = g1VarJ.c(aVar, jLongValue, jLongValue, 0L, z10 ? TrackGroupArray.f17501d : g1VarJ.f56771g, z10 ? this.P : g1VarJ.f56772h, z10 ? ImmutableList.of() : g1VarJ.f56773i).b(aVar);
            g1VarB2.f56780p = jLongValue;
            return g1VarB2;
        }
        if (jLongValue != jC) {
            hd.a.i(!aVar.b());
            long jMax = Math.max(0L, g1VarJ.f56781q - (jLongValue - jC));
            long j10 = g1VarJ.f56780p;
            if (g1VarJ.f56774j.equals(g1VarJ.f56766b)) {
                j10 = jLongValue + jMax;
            }
            g1 g1VarC = g1VarJ.c(aVar, jLongValue, jLongValue, jMax, g1VarJ.f56771g, g1VarJ.f56772h, g1VarJ.f56773i);
            g1VarC.f56780p = j10;
            return g1VarC;
        }
        int iB = x1Var.b(g1VarJ.f56774j.f26856a);
        if (iB != -1 && x1Var.f(iB, this.W).f57234c == x1Var.h(aVar.f26856a, this.W).f57234c) {
            return g1VarJ;
        }
        x1Var.h(aVar.f26856a, this.W);
        long jB = aVar.b() ? this.W.b(aVar.f26857b, aVar.f26858c) : this.W.f57235d;
        g1 g1VarB3 = g1VarJ.c(aVar, g1VarJ.f56782r, g1VarJ.f56782r, jB - g1VarJ.f56782r, g1VarJ.f56771g, g1VarJ.f56772h, g1VarJ.f56773i).b(aVar);
        g1VarB3.f56780p = jB;
        return g1VarB3;
    }

    public final long N2(l.a aVar, long j10) {
        long jD = g.d(j10);
        this.f56944o0.f56765a.h(aVar.f26856a, this.W);
        return jD + this.W.m();
    }

    @Override // ya.j1
    public int O() {
        return this.Q.length;
    }

    @Override // ya.n
    public Looper O0() {
        return this.U.E();
    }

    public final g1 O2(int i10, int i11) {
        boolean z10 = false;
        hd.a.a(i10 >= 0 && i11 >= i10 && i11 <= this.X.size());
        int iR0 = r0();
        x1 x1VarN1 = n1();
        int size = this.X.size();
        this.f56936g0++;
        P2(i10, i11);
        x1 x1VarI2 = i2();
        g1 g1VarM2 = M2(this.f56944o0, x1VarI2, n2(x1VarN1, x1VarI2));
        int i12 = g1VarM2.f56768d;
        if (i12 != 1 && i12 != 4 && i10 < i11 && i11 == size && iR0 >= g1VarM2.f56765a.q()) {
            z10 = true;
        }
        if (z10) {
            g1VarM2 = g1VarM2.h(4);
        }
        this.U.o0(i10, i11, this.f56942m0);
        return g1VarM2;
    }

    @Override // ya.j1
    public List<Metadata> P() {
        return this.f56944o0.f56773i;
    }

    public final void P2(int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            this.X.remove(i12);
        }
        this.f56942m0 = this.f56942m0.a(i10, i11);
    }

    public final void Q2(List<com.google.android.exoplayer2.source.l> list, int i10, long j10, boolean z10) {
        int iA = i10;
        int iM2 = m2();
        long jH1 = H1();
        this.f56936g0++;
        if (!this.X.isEmpty()) {
            P2(0, this.X.size());
        }
        List<d1.c> listH2 = h2(0, list);
        x1 x1VarI2 = i2();
        if (!x1VarI2.r() && iA >= x1VarI2.q()) {
            throw new IllegalSeekPositionException(x1VarI2, iA, j10);
        }
        long j11 = j10;
        if (z10) {
            iA = x1VarI2.a(this.f56935f0);
            j11 = -9223372036854775807L;
        } else if (iA == -1) {
            iA = iM2;
            j11 = jH1;
        }
        g1 g1VarM2 = M2(this.f56944o0, x1VarI2, o2(x1VarI2, iA, j11));
        int i11 = g1VarM2.f56768d;
        if (iA != -1 && i11 != 1) {
            i11 = (x1VarI2.r() || iA >= x1VarI2.q()) ? 4 : 2;
        }
        g1 g1VarH = g1VarM2.h(i11);
        this.U.O0(listH2, iA, g.c(j11), this.f56942m0);
        T2(g1VarH, false, 4, 0, 1, false);
    }

    @Override // ya.n
    public void R(int i10, List<com.google.android.exoplayer2.source.l> list) {
        hd.a.a(i10 >= 0);
        x1 x1VarN1 = n1();
        this.f56936g0++;
        List<d1.c> listH2 = h2(i10, list);
        x1 x1VarI2 = i2();
        g1 g1VarM2 = M2(this.f56944o0, x1VarI2, n2(x1VarN1, x1VarI2));
        this.U.n(i10, listH2, this.f56942m0);
        T2(g1VarM2, false, 4, 0, 1, false);
    }

    @Override // ya.n
    public void R0(com.google.android.exoplayer2.source.t tVar) {
        x1 x1VarI2 = i2();
        g1 g1VarM2 = M2(this.f56944o0, x1VarI2, o2(x1VarI2, r0(), H1()));
        this.f56936g0++;
        this.f56942m0 = tVar;
        this.U.c1(tVar);
        T2(g1VarM2, false, 4, 0, 1, false);
    }

    public void R2(boolean z10, int i10, int i11) {
        g1 g1Var = this.f56944o0;
        if (g1Var.f56775k == z10 && g1Var.f56776l == i10) {
            return;
        }
        this.f56936g0++;
        g1 g1VarE = g1Var.e(z10, i10);
        this.U.S0(z10, i10);
        T2(g1VarE, false, 4, 0, i11, false);
    }

    @Override // ya.j1
    @g.p0
    @Deprecated
    public ExoPlaybackException S() {
        return w0();
    }

    public void S2(boolean z10, @g.p0 ExoPlaybackException exoPlaybackException) {
        g1 g1VarB;
        if (z10) {
            g1VarB = O2(0, this.X.size()).f(null);
        } else {
            g1 g1Var = this.f56944o0;
            g1VarB = g1Var.b(g1Var.f56766b);
            g1VarB.f56780p = g1VarB.f56782r;
            g1VarB.f56781q = 0L;
        }
        g1 g1VarH = g1VarB.h(1);
        if (exoPlaybackException != null) {
            g1VarH = g1VarH.f(exoPlaybackException);
        }
        this.f56936g0++;
        this.U.m1();
        T2(g1VarH, false, 4, 0, 1, false);
    }

    @Override // ya.j1
    public int T0() {
        if (r()) {
            return this.f56944o0.f56766b.f26857b;
        }
        return -1;
    }

    public final void T2(final g1 g1Var, boolean z10, final int i10, final int i11, final int i12, boolean z11) {
        final v0 v0Var;
        g1 g1Var2 = this.f56944o0;
        this.f56944o0 = g1Var;
        Pair<Boolean, Integer> pairK2 = k2(g1Var, g1Var2, z10, i10, !g1Var2.f56765a.equals(g1Var.f56765a));
        boolean zBooleanValue = ((Boolean) pairK2.first).booleanValue();
        final int iIntValue = ((Integer) pairK2.second).intValue();
        if (!g1Var2.f56765a.equals(g1Var.f56765a)) {
            this.V.i(0, new s.a() { // from class: ya.u
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.I2(g1Var, i11, (j1.f) obj);
                }
            });
        }
        if (z10) {
            this.V.i(12, new s.a() { // from class: ya.a0
                @Override // hd.s.a
                public final void i(Object obj) {
                    ((j1.f) obj).i(i10);
                }
            });
        }
        if (zBooleanValue) {
            if (g1Var.f56765a.r()) {
                v0Var = null;
            } else {
                v0Var = g1Var.f56765a.n(g1Var.f56765a.h(g1Var.f56766b.f26856a, this.W).f57234c, this.O).f57242c;
            }
            this.V.i(1, new s.a() { // from class: ya.f0
                @Override // hd.s.a
                public final void i(Object obj) {
                    ((j1.f) obj).Z(v0Var, iIntValue);
                }
            });
        }
        ExoPlaybackException exoPlaybackException = g1Var2.f56769e;
        ExoPlaybackException exoPlaybackException2 = g1Var.f56769e;
        if (exoPlaybackException != exoPlaybackException2 && exoPlaybackException2 != null) {
            this.V.i(11, new s.a() { // from class: ya.l0
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.L2(g1Var, (j1.f) obj);
                }
            });
        }
        ad.k kVar = g1Var2.f56772h;
        ad.k kVar2 = g1Var.f56772h;
        if (kVar != kVar2) {
            this.R.d(kVar2.f574d);
            final ad.i iVar = new ad.i(g1Var.f56772h.f573c);
            this.V.i(2, new s.a() { // from class: ya.w
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.x2(g1Var, iVar, (j1.f) obj);
                }
            });
        }
        if (!g1Var2.f56773i.equals(g1Var.f56773i)) {
            this.V.i(3, new s.a() { // from class: ya.j0
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.y2(g1Var, (j1.f) obj);
                }
            });
        }
        if (g1Var2.f56770f != g1Var.f56770f) {
            this.V.i(4, new s.a() { // from class: ya.g0
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.z2(g1Var, (j1.f) obj);
                }
            });
        }
        if (g1Var2.f56768d != g1Var.f56768d || g1Var2.f56775k != g1Var.f56775k) {
            this.V.i(-1, new s.a() { // from class: ya.q
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.A2(g1Var, (j1.f) obj);
                }
            });
        }
        if (g1Var2.f56768d != g1Var.f56768d) {
            this.V.i(5, new s.a() { // from class: ya.k0
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.B2(g1Var, (j1.f) obj);
                }
            });
        }
        if (g1Var2.f56775k != g1Var.f56775k) {
            this.V.i(6, new s.a() { // from class: ya.v
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.C2(g1Var, i12, (j1.f) obj);
                }
            });
        }
        if (g1Var2.f56776l != g1Var.f56776l) {
            this.V.i(7, new s.a() { // from class: ya.r
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.D2(g1Var, (j1.f) obj);
                }
            });
        }
        if (q2(g1Var2) != q2(g1Var)) {
            this.V.i(8, new s.a() { // from class: ya.i0
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.E2(g1Var, (j1.f) obj);
                }
            });
        }
        if (!g1Var2.f56777m.equals(g1Var.f56777m)) {
            this.V.i(13, new s.a() { // from class: ya.t
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.F2(g1Var, (j1.f) obj);
                }
            });
        }
        if (z11) {
            this.V.i(-1, new s.a() { // from class: ya.z
                @Override // hd.s.a
                public final void i(Object obj) {
                    ((j1.f) obj).o();
                }
            });
        }
        if (g1Var2.f56778n != g1Var.f56778n) {
            this.V.i(-1, new s.a() { // from class: ya.h0
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.G2(g1Var, (j1.f) obj);
                }
            });
        }
        if (g1Var2.f56779o != g1Var.f56779o) {
            this.V.i(-1, new s.a() { // from class: ya.s
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.H2(g1Var, (j1.f) obj);
                }
            });
        }
        this.V.e();
    }

    @Override // ya.j1
    public int U() {
        if (this.f56944o0.f56765a.r()) {
            return this.f56946q0;
        }
        g1 g1Var = this.f56944o0;
        return g1Var.f56765a.b(g1Var.f56766b.f26856a);
    }

    @Override // ya.n
    public boolean U0() {
        return this.f56944o0.f56779o;
    }

    @Override // ya.n
    @Deprecated
    public void W0(com.google.android.exoplayer2.source.l lVar) {
        X(lVar);
        f();
    }

    @Override // ya.n
    public void X(com.google.android.exoplayer2.source.l lVar) {
        o0(Collections.singletonList(lVar));
    }

    @Override // ya.n
    public void Z0(boolean z10) {
        if (this.f56943n0 == z10) {
            return;
        }
        this.f56943n0 = z10;
        this.U.Q0(z10);
    }

    @Override // ya.j1
    public void b0(List<v0> list, boolean z10) {
        L0(j2(list), z10);
    }

    @Override // ya.n
    public void b1(List<com.google.android.exoplayer2.source.l> list, int i10, long j10) {
        Q2(list, i10, j10, false);
    }

    @Override // ya.j1
    public void c(@g.p0 h1 h1Var) {
        if (h1Var == null) {
            h1Var = h1.f56784d;
        }
        if (this.f56944o0.f56777m.equals(h1Var)) {
            return;
        }
        g1 g1VarG = this.f56944o0.g(h1Var);
        this.f56936g0++;
        this.U.U0(h1Var);
        T2(g1VarG, false, 4, 0, 1, false);
    }

    @Override // ya.n
    public t1 c1() {
        return this.f56941l0;
    }

    @Override // ya.j1
    public int d() {
        return this.f56944o0.f56768d;
    }

    @Override // ya.j1
    public h1 e() {
        return this.f56944o0.f56777m;
    }

    @Override // ya.n
    public void e0(boolean z10) {
        if (this.f56940k0 != z10) {
            this.f56940k0 = z10;
            if (this.U.L0(z10)) {
                return;
            }
            S2(false, ExoPlaybackException.c(new ExoTimeoutException(2)));
        }
    }

    @Override // ya.j1
    public void f() {
        g1 g1Var = this.f56944o0;
        if (g1Var.f56768d != 1) {
            return;
        }
        g1 g1VarF = g1Var.f(null);
        g1 g1VarH = g1VarF.h(g1VarF.f56765a.r() ? 4 : 2);
        this.f56936g0++;
        this.U.j0();
        T2(g1VarH, false, 4, 1, 1, false);
    }

    @Override // ya.j1
    public int f0() {
        if (r()) {
            return this.f56944o0.f56766b.f26858c;
        }
        return -1;
    }

    @Override // ya.n
    public void h0(List<com.google.android.exoplayer2.source.l> list) {
        R(this.X.size(), list);
    }

    @Override // ya.j1
    public void h1(int i10, int i11, int i12) {
        hd.a.a(i10 >= 0 && i10 <= i11 && i11 <= this.X.size() && i12 >= 0);
        x1 x1VarN1 = n1();
        this.f56936g0++;
        int iMin = Math.min(i12, this.X.size() - (i11 - i10));
        hd.u0.Q0(this.X, i10, i11, iMin);
        x1 x1VarI2 = i2();
        g1 g1VarM2 = M2(this.f56944o0, x1VarI2, n2(x1VarN1, x1VarI2));
        this.U.e0(i10, i11, iMin, this.f56942m0);
        T2(g1VarM2, false, 4, 0, 1, false);
    }

    public final List<d1.c> h2(int i10, List<com.google.android.exoplayer2.source.l> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            d1.c cVar = new d1.c(list.get(i11), this.Y);
            arrayList.add(cVar);
            this.X.add(i11 + i10, new a(cVar.f56624b, cVar.f56623a.T()));
        }
        this.f56942m0 = this.f56942m0.e(i10, arrayList.size());
        return arrayList;
    }

    @Override // ya.n
    public void i0(int i10, com.google.android.exoplayer2.source.l lVar) {
        R(i10, Collections.singletonList(lVar));
    }

    @Override // ya.j1
    @g.p0
    public j1.i i1() {
        return null;
    }

    public final x1 i2() {
        return new m1(this.X, this.f56942m0);
    }

    @Override // ya.j1
    public boolean isLoading() {
        return this.f56944o0.f56770f;
    }

    @Override // ya.j1
    public void j(final int i10) {
        if (this.f56934e0 != i10) {
            this.f56934e0 = i10;
            this.U.W0(i10);
            this.V.l(9, new s.a() { // from class: ya.e0
                @Override // hd.s.a
                public final void i(Object obj) {
                    ((j1.f) obj).v(i10);
                }
            });
        }
    }

    @Override // ya.j1
    public int j1() {
        return this.f56944o0.f56776l;
    }

    public final List<com.google.android.exoplayer2.source.l> j2(List<v0> list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(this.Z.c(list.get(i10)));
        }
        return arrayList;
    }

    @Override // ya.j1
    public int k() {
        return this.f56934e0;
    }

    @Override // ya.j1
    public void k1(List<v0> list) {
        E0(this.X.size(), list);
    }

    public final Pair<Boolean, Integer> k2(g1 g1Var, g1 g1Var2, boolean z10, int i10, boolean z11) {
        x1 x1Var = g1Var2.f56765a;
        x1 x1Var2 = g1Var.f56765a;
        if (x1Var2.r() && x1Var.r()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i11 = 3;
        if (x1Var2.r() != x1Var.r()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        Object obj = x1Var.n(x1Var.h(g1Var2.f56766b.f26856a, this.W).f57234c, this.O).f57240a;
        Object obj2 = x1Var2.n(x1Var2.h(g1Var.f56766b.f26856a, this.W).f57234c, this.O).f57240a;
        int i12 = this.O.f57252m;
        if (obj.equals(obj2)) {
            return (z10 && i10 == 0 && x1Var2.b(g1Var.f56766b.f26856a) == i12) ? new Pair<>(Boolean.TRUE, 0) : new Pair<>(Boolean.FALSE, -1);
        }
        if (z10 && i10 == 0) {
            i11 = 1;
        } else if (z10 && i10 == 1) {
            i11 = 2;
        } else if (!z11) {
            throw new IllegalStateException();
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(i11));
    }

    @Override // ya.j1
    @g.p0
    public j1.c l0() {
        return null;
    }

    @Override // ya.j1
    public TrackGroupArray l1() {
        return this.f56944o0.f56771g;
    }

    public void l2(long j10) {
        this.U.w(j10);
    }

    @Override // ya.j1
    public long m1() {
        if (!r()) {
            return T();
        }
        g1 g1Var = this.f56944o0;
        l.a aVar = g1Var.f56766b;
        g1Var.f56765a.h(aVar.f26856a, this.W);
        return g.d(this.W.b(aVar.f26857b, aVar.f26858c));
    }

    public final int m2() {
        if (this.f56944o0.f56765a.r()) {
            return this.f56945p0;
        }
        g1 g1Var = this.f56944o0;
        return g1Var.f56765a.h(g1Var.f56766b.f26856a, this.W).f57234c;
    }

    @Override // ya.j1
    public x1 n1() {
        return this.f56944o0.f56765a;
    }

    @g.p0
    public final Pair<Object, Long> n2(x1 x1Var, x1 x1Var2) {
        long jC0 = C0();
        if (x1Var.r() || x1Var2.r()) {
            boolean z10 = !x1Var.r() && x1Var2.r();
            int iM2 = z10 ? -1 : m2();
            if (z10) {
                jC0 = -9223372036854775807L;
            }
            return o2(x1Var2, iM2, jC0);
        }
        Pair<Object, Long> pairJ = x1Var.j(this.O, this.W, r0(), g.c(jC0));
        Object obj = ((Pair) hd.u0.k(pairJ)).first;
        if (x1Var2.b(obj) != -1) {
            return pairJ;
        }
        Object objZ0 = q0.z0(this.O, this.W, this.f56934e0, this.f56935f0, obj, x1Var, x1Var2);
        if (objZ0 == null) {
            return o2(x1Var2, -1, g.f56663b);
        }
        x1Var2.h(objZ0, this.W);
        int i10 = this.W.f57234c;
        return o2(x1Var2, i10, x1Var2.n(i10, this.O).b());
    }

    @Override // ya.n
    public void o0(List<com.google.android.exoplayer2.source.l> list) {
        L0(list, true);
    }

    @g.p0
    public final Pair<Object, Long> o2(x1 x1Var, int i10, long j10) {
        if (x1Var.r()) {
            this.f56945p0 = i10;
            if (j10 == g.f56663b) {
                j10 = 0;
            }
            this.f56947r0 = j10;
            this.f56946q0 = 0;
            return null;
        }
        if (i10 == -1 || i10 >= x1Var.q()) {
            i10 = x1Var.a(this.f56935f0);
            j10 = x1Var.n(i10, this.O).b();
        }
        return x1Var.j(this.O, this.W, i10, g.c(j10));
    }

    @Override // ya.j1
    public void p0(int i10, int i11) {
        T2(O2(i10, i11), false, 4, 0, 1, false);
    }

    @Override // ya.j1
    public Looper p1() {
        return this.f56931b0;
    }

    /* JADX INFO: renamed from: p2, reason: merged with bridge method [inline-methods] */
    public final void s2(q0.e eVar) {
        int i10 = this.f56936g0 - eVar.f57034c;
        this.f56936g0 = i10;
        if (eVar.f57035d) {
            this.f56937h0 = true;
            this.f56938i0 = eVar.f57036e;
        }
        if (eVar.f57037f) {
            this.f56939j0 = eVar.f57038g;
        }
        if (i10 == 0) {
            x1 x1Var = eVar.f57033b.f56765a;
            if (!this.f56944o0.f56765a.r() && x1Var.r()) {
                this.f56945p0 = -1;
                this.f56947r0 = 0L;
                this.f56946q0 = 0;
            }
            if (!x1Var.r()) {
                List<x1> listF = ((m1) x1Var).F();
                hd.a.i(listF.size() == this.X.size());
                for (int i11 = 0; i11 < listF.size(); i11++) {
                    this.X.get(i11).f56949b = listF.get(i11);
                }
            }
            boolean z10 = this.f56937h0;
            this.f56937h0 = false;
            T2(eVar.f57033b, z10, this.f56938i0, 1, this.f56939j0, false);
        }
    }

    @Override // ya.j1
    public boolean r() {
        return this.f56944o0.f56766b.b();
    }

    @Override // ya.j1
    public int r0() {
        int iM2 = m2();
        if (iM2 == -1) {
            return 0;
        }
        return iM2;
    }

    @Override // ya.j1
    public void release() {
        hd.t.i(f56929s0, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + r0.f57056c + "] [" + hd.u0.f31158e + "] [" + r0.b() + "]");
        if (!this.U.l0()) {
            this.V.l(11, new s.a() { // from class: ya.y
                @Override // hd.s.a
                public final void i(Object obj) {
                    m0.u2((j1.f) obj);
                }
            });
        }
        this.V.j();
        this.S.l(null);
        za.f1 f1Var = this.f56930a0;
        if (f1Var != null) {
            this.f56932c0.f(f1Var);
        }
        g1 g1VarH = this.f56944o0.h(1);
        this.f56944o0 = g1VarH;
        g1 g1VarB = g1VarH.b(g1VarH.f56766b);
        this.f56944o0 = g1VarB;
        g1VarB.f56780p = g1VarB.f56782r;
        this.f56944o0.f56781q = 0L;
    }

    @Override // ya.n
    public void s(com.google.android.exoplayer2.source.l lVar, long j10) {
        b1(Collections.singletonList(lVar), 0, j10);
    }

    @Override // ya.j1
    @g.p0
    public j1.a s0() {
        return null;
    }

    @Override // ya.n
    public l1 s1(l1.b bVar) {
        return new l1(this.U, bVar, this.f56944o0.f56765a, r0(), this.f56933d0, this.U.E());
    }

    @Override // ya.n
    @Deprecated
    public void t(com.google.android.exoplayer2.source.l lVar, boolean z10, boolean z11) {
        C1(lVar, z10);
        f();
    }

    @Override // ya.j1
    public boolean u1() {
        return this.f56935f0;
    }

    @Override // ya.n
    @Deprecated
    public void v() {
        f();
    }

    @Override // ya.j1
    public void v0(List<v0> list, int i10, long j10) {
        b1(j2(list), i10, j10);
    }

    @Override // ya.j1
    public long v1() {
        if (this.f56944o0.f56765a.r()) {
            return this.f56947r0;
        }
        g1 g1Var = this.f56944o0;
        if (g1Var.f56774j.f26859d != g1Var.f56766b.f26859d) {
            return g1Var.f56765a.n(r0(), this.O).d();
        }
        long j10 = g1Var.f56780p;
        if (this.f56944o0.f56774j.b()) {
            g1 g1Var2 = this.f56944o0;
            x1.b bVarH = g1Var2.f56765a.h(g1Var2.f56774j.f26856a, this.W);
            long jF = bVarH.f(this.f56944o0.f56774j.f26857b);
            j10 = jF == Long.MIN_VALUE ? bVarH.f57235d : jF;
        }
        return N2(this.f56944o0.f56774j, j10);
    }

    @Override // ya.n
    public boolean w() {
        return this.f56943n0;
    }

    @Override // ya.j1
    @g.p0
    public ExoPlaybackException w0() {
        return this.f56944o0.f56769e;
    }

    @Override // ya.j1
    public void x0(boolean z10) {
        R2(z10, 0, 1);
    }

    @Override // ya.j1
    public void y(j1.f fVar) {
        this.V.c(fVar);
    }

    @Override // ya.j1
    @g.p0
    public j1.p y0() {
        return null;
    }

    @Override // ya.n
    public void z1(@g.p0 t1 t1Var) {
        if (t1Var == null) {
            t1Var = t1.f57074g;
        }
        if (this.f56941l0.equals(t1Var)) {
            return;
        }
        this.f56941l0 = t1Var;
        this.U.Y0(t1Var);
    }
}
