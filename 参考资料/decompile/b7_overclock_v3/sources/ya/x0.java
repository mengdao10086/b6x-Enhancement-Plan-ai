package ya;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f57215p = "MediaPeriodHolder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.k f57216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f57217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ec.d0[] f57218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f57219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f57220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y0 f57221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f57222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f57223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q1[] f57224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ad.j f57225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d1 f57226k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.p0
    public x0 f57227l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TrackGroupArray f57228m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ad.k f57229n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f57230o;

    public x0(q1[] q1VarArr, long j10, ad.j jVar, ed.b bVar, d1 d1Var, y0 y0Var, ad.k kVar) {
        this.f57224i = q1VarArr;
        this.f57230o = j10;
        this.f57225j = jVar;
        this.f57226k = d1Var;
        l.a aVar = y0Var.f57258a;
        this.f57217b = aVar.f26856a;
        this.f57221f = y0Var;
        this.f57228m = TrackGroupArray.f17501d;
        this.f57229n = kVar;
        this.f57218c = new ec.d0[q1VarArr.length];
        this.f57223h = new boolean[q1VarArr.length];
        this.f57216a = e(aVar, d1Var, bVar, y0Var.f57259b, y0Var.f57261d);
    }

    public static com.google.android.exoplayer2.source.k e(l.a aVar, d1 d1Var, ed.b bVar, long j10, long j11) {
        com.google.android.exoplayer2.source.k kVarI = d1Var.i(aVar, bVar, j10);
        return (j11 == g.f56663b || j11 == Long.MIN_VALUE) ? kVarI : new com.google.android.exoplayer2.source.b(kVarI, true, 0L, j11);
    }

    public static void u(long j10, d1 d1Var, com.google.android.exoplayer2.source.k kVar) {
        try {
            if (j10 == g.f56663b || j10 == Long.MIN_VALUE) {
                d1Var.B(kVar);
            } else {
                d1Var.B(((com.google.android.exoplayer2.source.b) kVar).f17562a);
            }
        } catch (RuntimeException e10) {
            hd.t.e(f57215p, "Period release failed.", e10);
        }
    }

    public long a(ad.k kVar, long j10, boolean z10) {
        return b(kVar, j10, z10, new boolean[this.f57224i.length]);
    }

    public long b(ad.k kVar, long j10, boolean z10, boolean[] zArr) {
        int i10 = 0;
        while (true) {
            boolean z11 = true;
            if (i10 >= kVar.f571a) {
                break;
            }
            boolean[] zArr2 = this.f57223h;
            if (z10 || !kVar.b(this.f57229n, i10)) {
                z11 = false;
            }
            zArr2[i10] = z11;
            i10++;
        }
        g(this.f57218c);
        f();
        this.f57229n = kVar;
        h();
        long jS = this.f57216a.s(kVar.f573c, this.f57223h, this.f57218c, zArr, j10);
        c(this.f57218c);
        this.f57220e = false;
        int i11 = 0;
        while (true) {
            ec.d0[] d0VarArr = this.f57218c;
            if (i11 >= d0VarArr.length) {
                return jS;
            }
            if (d0VarArr[i11] != null) {
                hd.a.i(kVar.c(i11));
                if (this.f57224i[i11].h() != 7) {
                    this.f57220e = true;
                }
            } else {
                hd.a.i(kVar.f573c[i11] == null);
            }
            i11++;
        }
    }

    public final void c(ec.d0[] d0VarArr) {
        int i10 = 0;
        while (true) {
            q1[] q1VarArr = this.f57224i;
            if (i10 >= q1VarArr.length) {
                return;
            }
            if (q1VarArr[i10].h() == 7 && this.f57229n.c(i10)) {
                d0VarArr[i10] = new ec.h();
            }
            i10++;
        }
    }

    public void d(long j10) {
        hd.a.i(r());
        this.f57216a.e(y(j10));
    }

    public final void f() {
        if (!r()) {
            return;
        }
        int i10 = 0;
        while (true) {
            ad.k kVar = this.f57229n;
            if (i10 >= kVar.f571a) {
                return;
            }
            boolean zC = kVar.c(i10);
            com.google.android.exoplayer2.trackselection.b bVar = this.f57229n.f573c[i10];
            if (zC && bVar != null) {
                bVar.g();
            }
            i10++;
        }
    }

    public final void g(ec.d0[] d0VarArr) {
        int i10 = 0;
        while (true) {
            q1[] q1VarArr = this.f57224i;
            if (i10 >= q1VarArr.length) {
                return;
            }
            if (q1VarArr[i10].h() == 7) {
                d0VarArr[i10] = null;
            }
            i10++;
        }
    }

    public final void h() {
        if (!r()) {
            return;
        }
        int i10 = 0;
        while (true) {
            ad.k kVar = this.f57229n;
            if (i10 >= kVar.f571a) {
                return;
            }
            boolean zC = kVar.c(i10);
            com.google.android.exoplayer2.trackselection.b bVar = this.f57229n.f573c[i10];
            if (zC && bVar != null) {
                bVar.l();
            }
            i10++;
        }
    }

    public long i() {
        if (!this.f57219d) {
            return this.f57221f.f57259b;
        }
        long jF = this.f57220e ? this.f57216a.f() : Long.MIN_VALUE;
        return jF == Long.MIN_VALUE ? this.f57221f.f57262e : jF;
    }

    @g.p0
    public x0 j() {
        return this.f57227l;
    }

    public long k() {
        if (this.f57219d) {
            return this.f57216a.b();
        }
        return 0L;
    }

    public long l() {
        return this.f57230o;
    }

    public long m() {
        return this.f57221f.f57259b + this.f57230o;
    }

    public TrackGroupArray n() {
        return this.f57228m;
    }

    public ad.k o() {
        return this.f57229n;
    }

    public void p(float f10, x1 x1Var) throws ExoPlaybackException {
        this.f57219d = true;
        this.f57228m = this.f57216a.r();
        ad.k kVarV = v(f10, x1Var);
        y0 y0Var = this.f57221f;
        long jMax = y0Var.f57259b;
        long j10 = y0Var.f57262e;
        if (j10 != g.f56663b && jMax >= j10) {
            jMax = Math.max(0L, j10 - 1);
        }
        long jA = a(kVarV, jMax, false);
        long j11 = this.f57230o;
        y0 y0Var2 = this.f57221f;
        this.f57230o = j11 + (y0Var2.f57259b - jA);
        this.f57221f = y0Var2.b(jA);
    }

    public boolean q() {
        return this.f57219d && (!this.f57220e || this.f57216a.f() == Long.MIN_VALUE);
    }

    public final boolean r() {
        return this.f57227l == null;
    }

    public void s(long j10) {
        hd.a.i(r());
        if (this.f57219d) {
            this.f57216a.g(y(j10));
        }
    }

    public void t() {
        f();
        u(this.f57221f.f57261d, this.f57226k, this.f57216a);
    }

    public ad.k v(float f10, x1 x1Var) throws ExoPlaybackException {
        ad.k kVarE = this.f57225j.e(this.f57224i, n(), this.f57221f.f57258a, x1Var);
        for (com.google.android.exoplayer2.trackselection.b bVar : kVarE.f573c) {
            if (bVar != null) {
                bVar.r(f10);
            }
        }
        return kVarE;
    }

    public void w(@g.p0 x0 x0Var) {
        if (x0Var == this.f57227l) {
            return;
        }
        f();
        this.f57227l = x0Var;
        h();
    }

    public void x(long j10) {
        this.f57230o = j10;
    }

    public long y(long j10) {
        return j10 - l();
    }

    public long z(long j10) {
        return j10 + l();
    }
}
