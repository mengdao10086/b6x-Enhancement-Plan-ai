package ya;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.source.l;
import com.google.common.collect.ImmutableList;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f56556n = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1.b f56557a = new x1.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1.c f56558b = new x1.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.p0
    public final za.f1 f56559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f56560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f56561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f56563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.p0
    public x0 f56564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.p0
    public x0 f56565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.p0
    public x0 f56566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f56567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.p0
    public Object f56568l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f56569m;

    public a1(@g.p0 za.f1 f1Var, Handler handler) {
        this.f56559c = f1Var;
        this.f56560d = handler;
    }

    public static l.a A(x1 x1Var, Object obj, long j10, long j11, x1.b bVar) {
        x1Var.h(obj, bVar);
        int iE = bVar.e(j10);
        return iE == -1 ? new l.a(obj, j11, bVar.d(j10)) : new l.a(obj, iE, bVar.k(iE), j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(ImmutableList.Builder builder, l.a aVar) {
        this.f56559c.D2(builder.build(), aVar);
    }

    public final long B(x1 x1Var, Object obj) {
        int iB;
        int i10 = x1Var.h(obj, this.f56557a).f57234c;
        Object obj2 = this.f56568l;
        if (obj2 != null && (iB = x1Var.b(obj2)) != -1 && x1Var.f(iB, this.f56557a).f57234c == i10) {
            return this.f56569m;
        }
        for (x0 x0VarJ = this.f56564h; x0VarJ != null; x0VarJ = x0VarJ.j()) {
            if (x0VarJ.f57217b.equals(obj)) {
                return x0VarJ.f57221f.f57258a.f26859d;
            }
        }
        for (x0 x0VarJ2 = this.f56564h; x0VarJ2 != null; x0VarJ2 = x0VarJ2.j()) {
            int iB2 = x1Var.b(x0VarJ2.f57217b);
            if (iB2 != -1 && x1Var.f(iB2, this.f56557a).f57234c == i10) {
                return x0VarJ2.f57221f.f57258a.f26859d;
            }
        }
        long j10 = this.f56561e;
        this.f56561e = 1 + j10;
        if (this.f56564h == null) {
            this.f56568l = obj;
            this.f56569m = j10;
        }
        return j10;
    }

    public boolean C() {
        x0 x0Var = this.f56566j;
        return x0Var == null || (!x0Var.f57221f.f57265h && x0Var.q() && this.f56566j.f57221f.f57262e != g.f56663b && this.f56567k < 100);
    }

    public final boolean D(x1 x1Var) {
        x0 x0VarJ = this.f56564h;
        if (x0VarJ == null) {
            return true;
        }
        int iB = x1Var.b(x0VarJ.f57217b);
        while (true) {
            iB = x1Var.d(iB, this.f56557a, this.f56558b, this.f56562f, this.f56563g);
            while (x0VarJ.j() != null && !x0VarJ.f57221f.f57263f) {
                x0VarJ = x0VarJ.j();
            }
            x0 x0VarJ2 = x0VarJ.j();
            if (iB == -1 || x0VarJ2 == null || x1Var.b(x0VarJ2.f57217b) != iB) {
                break;
            }
            x0VarJ = x0VarJ2;
        }
        boolean zY = y(x0VarJ);
        x0VarJ.f57221f = q(x1Var, x0VarJ.f57221f);
        return !zY;
    }

    public boolean E(x1 x1Var, long j10, long j11) {
        y0 y0VarQ;
        x0 x0VarJ = this.f56564h;
        x0 x0Var = null;
        while (x0VarJ != null) {
            y0 y0Var = x0VarJ.f57221f;
            if (x0Var == null) {
                y0VarQ = q(x1Var, y0Var);
            } else {
                y0 y0VarI = i(x1Var, x0Var, j10);
                if (y0VarI == null) {
                    return !y(x0Var);
                }
                if (!e(y0Var, y0VarI)) {
                    return !y(x0Var);
                }
                y0VarQ = y0VarI;
            }
            x0VarJ.f57221f = y0VarQ.a(y0Var.f57260c);
            if (!d(y0Var.f57262e, y0VarQ.f57262e)) {
                long j12 = y0VarQ.f57262e;
                return (y(x0VarJ) || (x0VarJ == this.f56565i && ((j11 > Long.MIN_VALUE ? 1 : (j11 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j11 > ((j12 > g.f56663b ? 1 : (j12 == g.f56663b ? 0 : -1)) == 0 ? Long.MAX_VALUE : x0VarJ.z(j12)) ? 1 : (j11 == ((j12 > g.f56663b ? 1 : (j12 == g.f56663b ? 0 : -1)) == 0 ? Long.MAX_VALUE : x0VarJ.z(j12)) ? 0 : -1)) >= 0))) ? false : true;
            }
            x0Var = x0VarJ;
            x0VarJ = x0VarJ.j();
        }
        return true;
    }

    public boolean F(x1 x1Var, int i10) {
        this.f56562f = i10;
        return D(x1Var);
    }

    public boolean G(x1 x1Var, boolean z10) {
        this.f56563g = z10;
        return D(x1Var);
    }

    @g.p0
    public x0 b() {
        x0 x0Var = this.f56564h;
        if (x0Var == null) {
            return null;
        }
        if (x0Var == this.f56565i) {
            this.f56565i = x0Var.j();
        }
        this.f56564h.t();
        int i10 = this.f56567k - 1;
        this.f56567k = i10;
        if (i10 == 0) {
            this.f56566j = null;
            x0 x0Var2 = this.f56564h;
            this.f56568l = x0Var2.f57217b;
            this.f56569m = x0Var2.f57221f.f57258a.f26859d;
        }
        this.f56564h = this.f56564h.j();
        w();
        return this.f56564h;
    }

    public x0 c() {
        x0 x0Var = this.f56565i;
        hd.a.i((x0Var == null || x0Var.j() == null) ? false : true);
        this.f56565i = this.f56565i.j();
        w();
        return this.f56565i;
    }

    public final boolean d(long j10, long j11) {
        return j10 == g.f56663b || j10 == j11;
    }

    public final boolean e(y0 y0Var, y0 y0Var2) {
        return y0Var.f57259b == y0Var2.f57259b && y0Var.f57258a.equals(y0Var2.f57258a);
    }

    public void f() {
        if (this.f56567k == 0) {
            return;
        }
        x0 x0VarJ = (x0) hd.a.k(this.f56564h);
        this.f56568l = x0VarJ.f57217b;
        this.f56569m = x0VarJ.f57221f.f57258a.f26859d;
        while (x0VarJ != null) {
            x0VarJ.t();
            x0VarJ = x0VarJ.j();
        }
        this.f56564h = null;
        this.f56566j = null;
        this.f56565i = null;
        this.f56567k = 0;
        w();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ya.x0 g(ya.q1[] r12, ad.j r13, ed.b r14, ya.d1 r15, ya.y0 r16, ad.k r17) {
        /*
            r11 = this;
            r0 = r11
            r8 = r16
            ya.x0 r1 = r0.f56566j
            if (r1 != 0) goto L1e
            com.google.android.exoplayer2.source.l$a r1 = r8.f57258a
            boolean r1 = r1.b()
            if (r1 == 0) goto L1b
            long r1 = r8.f57260c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L1b
            goto L2c
        L1b:
            r1 = 0
            goto L2c
        L1e:
            long r1 = r1.l()
            ya.x0 r3 = r0.f56566j
            ya.y0 r3 = r3.f57221f
            long r3 = r3.f57262e
            long r1 = r1 + r3
            long r3 = r8.f57259b
            long r1 = r1 - r3
        L2c:
            r3 = r1
            ya.x0 r10 = new ya.x0
            r1 = r10
            r2 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r1.<init>(r2, r3, r5, r6, r7, r8, r9)
            ya.x0 r1 = r0.f56566j
            if (r1 == 0) goto L43
            r1.w(r10)
            goto L47
        L43:
            r0.f56564h = r10
            r0.f56565i = r10
        L47:
            r1 = 0
            r0.f56568l = r1
            r0.f56566j = r10
            int r1 = r0.f56567k
            int r1 = r1 + 1
            r0.f56567k = r1
            r11.w()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.a1.g(ya.q1[], ad.j, ed.b, ya.d1, ya.y0, ad.k):ya.x0");
    }

    @g.p0
    public final y0 h(g1 g1Var) {
        return k(g1Var.f56765a, g1Var.f56766b, g1Var.f56767c, g1Var.f56782r);
    }

    @g.p0
    public final y0 i(x1 x1Var, x0 x0Var, long j10) {
        long j11;
        y0 y0Var = x0Var.f57221f;
        long jL = (x0Var.l() + y0Var.f57262e) - j10;
        if (y0Var.f57263f) {
            long j12 = 0;
            int iD = x1Var.d(x1Var.b(y0Var.f57258a.f26856a), this.f56557a, this.f56558b, this.f56562f, this.f56563g);
            if (iD == -1) {
                return null;
            }
            int i10 = x1Var.g(iD, this.f56557a, true).f57234c;
            Object obj = this.f56557a.f57233b;
            long j13 = y0Var.f57258a.f26859d;
            if (x1Var.n(i10, this.f56558b).f57252m == iD) {
                Pair<Object, Long> pairK = x1Var.k(this.f56558b, this.f56557a, i10, g.f56663b, Math.max(0L, jL));
                if (pairK == null) {
                    return null;
                }
                obj = pairK.first;
                long jLongValue = ((Long) pairK.second).longValue();
                x0 x0VarJ = x0Var.j();
                if (x0VarJ == null || !x0VarJ.f57217b.equals(obj)) {
                    j13 = this.f56561e;
                    this.f56561e = 1 + j13;
                } else {
                    j13 = x0VarJ.f57221f.f57258a.f26859d;
                }
                j11 = jLongValue;
                j12 = g.f56663b;
            } else {
                j11 = 0;
            }
            return k(x1Var, A(x1Var, obj, j11, j13, this.f56557a), j12, j11);
        }
        l.a aVar = y0Var.f57258a;
        x1Var.h(aVar.f26856a, this.f56557a);
        if (!aVar.b()) {
            int iE = this.f56557a.e(y0Var.f57261d);
            if (iE != -1) {
                return l(x1Var, aVar.f26856a, iE, this.f56557a.k(iE), y0Var.f57262e, aVar.f26859d);
            }
            Object obj2 = aVar.f26856a;
            long j14 = y0Var.f57262e;
            return m(x1Var, obj2, j14, j14, aVar.f26859d);
        }
        int i11 = aVar.f26857b;
        int iA = this.f56557a.a(i11);
        if (iA == -1) {
            return null;
        }
        int iL = this.f56557a.l(i11, aVar.f26858c);
        if (iL < iA) {
            return l(x1Var, aVar.f26856a, i11, iL, y0Var.f57260c, aVar.f26859d);
        }
        long jLongValue2 = y0Var.f57260c;
        if (jLongValue2 == g.f56663b) {
            x1.c cVar = this.f56558b;
            x1.b bVar = this.f56557a;
            Pair<Object, Long> pairK2 = x1Var.k(cVar, bVar, bVar.f57234c, g.f56663b, Math.max(0L, jL));
            if (pairK2 == null) {
                return null;
            }
            jLongValue2 = ((Long) pairK2.second).longValue();
        }
        return m(x1Var, aVar.f26856a, jLongValue2, y0Var.f57260c, aVar.f26859d);
    }

    @g.p0
    public x0 j() {
        return this.f56566j;
    }

    @g.p0
    public final y0 k(x1 x1Var, l.a aVar, long j10, long j11) {
        x1Var.h(aVar.f26856a, this.f56557a);
        return aVar.b() ? l(x1Var, aVar.f26856a, aVar.f26857b, aVar.f26858c, j10, aVar.f26859d) : m(x1Var, aVar.f26856a, j11, j10, aVar.f26859d);
    }

    public final y0 l(x1 x1Var, Object obj, int i10, int i11, long j10, long j11) {
        l.a aVar = new l.a(obj, i10, i11, j11);
        long jB = x1Var.h(aVar.f26856a, this.f56557a).b(aVar.f26857b, aVar.f26858c);
        long jG = i11 == this.f56557a.k(i10) ? this.f56557a.g() : 0L;
        return new y0(aVar, (jB == g.f56663b || jG < jB) ? jG : Math.max(0L, jB - 1), j10, g.f56663b, jB, false, false, false);
    }

    public final y0 m(x1 x1Var, Object obj, long j10, long j11, long j12) {
        long jMax = j10;
        x1Var.h(obj, this.f56557a);
        int iD = this.f56557a.d(jMax);
        l.a aVar = new l.a(obj, j12, iD);
        boolean zR = r(aVar);
        boolean zT = t(x1Var, aVar);
        boolean zS = s(x1Var, aVar, zR);
        long jF = iD != -1 ? this.f56557a.f(iD) : -9223372036854775807L;
        long j13 = (jF == g.f56663b || jF == Long.MIN_VALUE) ? this.f56557a.f57235d : jF;
        if (j13 != g.f56663b && jMax >= j13) {
            jMax = Math.max(0L, j13 - 1);
        }
        return new y0(aVar, jMax, j11, jF, j13, zR, zT, zS);
    }

    @g.p0
    public y0 n(long j10, g1 g1Var) {
        x0 x0Var = this.f56566j;
        return x0Var == null ? h(g1Var) : i(g1Var.f56765a, x0Var, j10);
    }

    @g.p0
    public x0 o() {
        return this.f56564h;
    }

    @g.p0
    public x0 p() {
        return this.f56565i;
    }

    public y0 q(x1 x1Var, y0 y0Var) {
        long j10;
        l.a aVar = y0Var.f57258a;
        boolean zR = r(aVar);
        boolean zT = t(x1Var, aVar);
        boolean zS = s(x1Var, aVar, zR);
        x1Var.h(y0Var.f57258a.f26856a, this.f56557a);
        if (aVar.b()) {
            j10 = this.f56557a.b(aVar.f26857b, aVar.f26858c);
        } else {
            j10 = y0Var.f57261d;
            if (j10 == g.f56663b || j10 == Long.MIN_VALUE) {
                j10 = this.f56557a.j();
            }
        }
        return new y0(aVar, y0Var.f57259b, y0Var.f57260c, y0Var.f57261d, j10, zR, zT, zS);
    }

    public final boolean r(l.a aVar) {
        return !aVar.b() && aVar.f26860e == -1;
    }

    public final boolean s(x1 x1Var, l.a aVar, boolean z10) {
        int iB = x1Var.b(aVar.f26856a);
        return !x1Var.n(x1Var.f(iB, this.f56557a).f57234c, this.f56558b).f57248i && x1Var.s(iB, this.f56557a, this.f56558b, this.f56562f, this.f56563g) && z10;
    }

    public final boolean t(x1 x1Var, l.a aVar) {
        if (r(aVar)) {
            return x1Var.n(x1Var.h(aVar.f26856a, this.f56557a).f57234c, this.f56558b).f57253n == x1Var.b(aVar.f26856a);
        }
        return false;
    }

    public boolean u(com.google.android.exoplayer2.source.k kVar) {
        x0 x0Var = this.f56566j;
        return x0Var != null && x0Var.f57216a == kVar;
    }

    public final void w() {
        if (this.f56559c != null) {
            final ImmutableList.Builder builder = ImmutableList.builder();
            for (x0 x0VarJ = this.f56564h; x0VarJ != null; x0VarJ = x0VarJ.j()) {
                builder.add(x0VarJ.f57221f.f57258a);
            }
            x0 x0Var = this.f56565i;
            final l.a aVar = x0Var == null ? null : x0Var.f57221f.f57258a;
            this.f56560d.post(new Runnable() { // from class: ya.z0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f57273a.v(builder, aVar);
                }
            });
        }
    }

    public void x(long j10) {
        x0 x0Var = this.f56566j;
        if (x0Var != null) {
            x0Var.s(j10);
        }
    }

    public boolean y(x0 x0Var) {
        boolean z10 = false;
        hd.a.i(x0Var != null);
        if (x0Var.equals(this.f56566j)) {
            return false;
        }
        this.f56566j = x0Var;
        while (x0Var.j() != null) {
            x0Var = x0Var.j();
            if (x0Var == this.f56565i) {
                this.f56565i = this.f56564h;
                z10 = true;
            }
            x0Var.t();
            this.f56567k--;
        }
        this.f56566j.w(null);
        w();
        return z10;
    }

    public l.a z(x1 x1Var, Object obj, long j10) {
        return A(x1Var, obj, j10, B(x1Var, obj), this.f56557a);
    }
}
