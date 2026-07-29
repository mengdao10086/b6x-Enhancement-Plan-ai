package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import ed.z;
import g.p0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class ClippingMediaSource extends c<Void> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l f17463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f17464k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f17465l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f17466m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f17467n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f17468o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<b> f17469p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final x1.c f17470q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public a f17471r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public IllegalClippingException f17472s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f17473t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f17474u;

    public static final class IllegalClippingException extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f17475a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17476b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f17477c = 2;
        public final int reason;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public IllegalClippingException(int i10) {
            super("Illegal clipping: " + a(i10));
            this.reason = i10;
        }

        public static String a(int i10) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public static final class a extends ec.i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f17478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f17479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f17480e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f17481f;

        public a(x1 x1Var, long j10, long j11) throws IllegalClippingException {
            super(x1Var);
            boolean z10 = false;
            if (x1Var.i() != 1) {
                throw new IllegalClippingException(0);
            }
            x1.c cVarN = x1Var.n(0, new x1.c());
            long jMax = Math.max(0L, j10);
            if (!cVarN.f57251l && jMax != 0 && !cVarN.f57247h) {
                throw new IllegalClippingException(1);
            }
            long jMax2 = j11 == Long.MIN_VALUE ? cVarN.f57255p : Math.max(0L, j11);
            long j12 = cVarN.f57255p;
            if (j12 != ya.g.f56663b) {
                jMax2 = jMax2 > j12 ? j12 : jMax2;
                if (jMax > jMax2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.f17478c = jMax;
            this.f17479d = jMax2;
            this.f17480e = jMax2 == ya.g.f56663b ? -9223372036854775807L : jMax2 - jMax;
            if (cVarN.f57248i && (jMax2 == ya.g.f56663b || (j12 != ya.g.f56663b && jMax2 == j12))) {
                z10 = true;
            }
            this.f17481f = z10;
        }

        @Override // ec.i, ya.x1
        public x1.b g(int i10, x1.b bVar, boolean z10) {
            this.f26836b.g(0, bVar, z10);
            long jN = bVar.n() - this.f17478c;
            long j10 = this.f17480e;
            return bVar.p(bVar.f57232a, bVar.f57233b, 0, j10 == ya.g.f56663b ? -9223372036854775807L : j10 - jN, jN);
        }

        @Override // ec.i, ya.x1
        public x1.c o(int i10, x1.c cVar, long j10) {
            this.f26836b.o(0, cVar, 0L);
            long j11 = cVar.f57256q;
            long j12 = this.f17478c;
            cVar.f57256q = j11 + j12;
            cVar.f57255p = this.f17480e;
            cVar.f57248i = this.f17481f;
            long j13 = cVar.f57254o;
            if (j13 != ya.g.f56663b) {
                long jMax = Math.max(j13, j12);
                cVar.f57254o = jMax;
                long j14 = this.f17479d;
                if (j14 != ya.g.f56663b) {
                    jMax = Math.min(jMax, j14);
                }
                cVar.f57254o = jMax - this.f17478c;
            }
            long jD = ya.g.d(this.f17478c);
            long j15 = cVar.f57244e;
            if (j15 != ya.g.f56663b) {
                cVar.f57244e = j15 + jD;
            }
            long j16 = cVar.f57245f;
            if (j16 != ya.g.f56663b) {
                cVar.f57245f = j16 + jD;
            }
            return cVar;
        }
    }

    public ClippingMediaSource(l lVar, long j10, long j11) {
        this(lVar, j10, j11, true, false, false);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        super.C(zVar);
        N(null, this.f17463j);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void E() {
        super.E();
        this.f17472s = null;
        this.f17471r = null;
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public long J(Void r72, long j10) {
        if (j10 == ya.g.f56663b) {
            return ya.g.f56663b;
        }
        long jD = ya.g.d(this.f17464k);
        long jMax = Math.max(0L, j10 - jD);
        long j11 = this.f17465l;
        return j11 != Long.MIN_VALUE ? Math.min(ya.g.d(j11) - jD, jMax) : jMax;
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void L(Void r12, l lVar, x1 x1Var) {
        if (this.f17472s != null) {
            return;
        }
        R(x1Var);
    }

    public final void R(x1 x1Var) {
        long j10;
        long j11;
        x1Var.n(0, this.f17470q);
        long jG = this.f17470q.g();
        if (this.f17471r == null || this.f17469p.isEmpty() || this.f17467n) {
            long j12 = this.f17464k;
            long j13 = this.f17465l;
            if (this.f17468o) {
                long jC = this.f17470q.c();
                j12 += jC;
                j13 += jC;
            }
            this.f17473t = jG + j12;
            this.f17474u = this.f17465l != Long.MIN_VALUE ? jG + j13 : Long.MIN_VALUE;
            int size = this.f17469p.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f17469p.get(i10).v(this.f17473t, this.f17474u);
            }
            j10 = j12;
            j11 = j13;
        } else {
            long j14 = this.f17473t - jG;
            j11 = this.f17465l != Long.MIN_VALUE ? this.f17474u - jG : Long.MIN_VALUE;
            j10 = j14;
        }
        try {
            a aVar = new a(x1Var, j10, j11);
            this.f17471r = aVar;
            D(aVar);
        } catch (IllegalClippingException e10) {
            this.f17472s = e10;
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.a aVar, ed.b bVar, long j10) {
        b bVar2 = new b(this.f17463j.a(aVar, bVar, j10), this.f17466m, this.f17473t, this.f17474u);
        this.f17469p.add(bVar2);
        return bVar2;
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return this.f17463j.h();
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f17463j.j();
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.l
    public void n() throws IOException {
        IllegalClippingException illegalClippingException = this.f17472s;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.n();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
        hd.a.i(this.f17469p.remove(kVar));
        this.f17463j.p(((b) kVar).f17562a);
        if (!this.f17469p.isEmpty() || this.f17467n) {
            return;
        }
        R(((a) hd.a.g(this.f17471r)).f26836b);
    }

    public ClippingMediaSource(l lVar, long j10) {
        this(lVar, 0L, j10, true, false, true);
    }

    public ClippingMediaSource(l lVar, long j10, long j11, boolean z10, boolean z11, boolean z12) {
        hd.a.a(j10 >= 0);
        this.f17463j = (l) hd.a.g(lVar);
        this.f17464k = j10;
        this.f17465l = j11;
        this.f17466m = z10;
        this.f17467n = z11;
        this.f17468o = z12;
        this.f17469p = new ArrayList<>();
        this.f17470q = new x1.c();
    }
}
