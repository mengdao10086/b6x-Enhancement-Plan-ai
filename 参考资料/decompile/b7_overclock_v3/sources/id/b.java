package id;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import g.p0;
import hd.o0;
import hd.q0;
import id.z;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends com.google.android.exoplayer2.a {
    public static final int M7 = 0;
    public static final int N7 = 1;
    public static final int O7 = 2;

    @p0
    public DrmSession A;

    @p0
    public DrmSession B;
    public int C;
    public long C1;
    public boolean C2;
    public boolean D;
    public int E7;
    public long F7;
    public int G7;
    public int H7;
    public int I7;
    public long J7;
    public boolean K0;
    public boolean K1;
    public int K2;
    public long K7;
    public eb.d L7;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f32138k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f32139k1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f32140m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f32141n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final z.a f32142o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o0<Format> f32143p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DecoderInputBuffer f32144q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Format f32145r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Format f32146s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public eb.c<i, ? extends j, ? extends DecoderException> f32147t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public i f32148u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public j f32149v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public long f32150v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f32151v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public Surface f32152w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public k f32153x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public l f32154y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f32155z;

    public b(long j10, @p0 Handler handler, @p0 z zVar, int i10) {
        super(2);
        this.f32140m = j10;
        this.f32141n = i10;
        this.C1 = ya.g.f56663b;
        R();
        this.f32143p = new o0<>();
        this.f32144q = DecoderInputBuffer.u();
        this.f32142o = new z.a(handler, zVar);
        this.C = 0;
        this.f32155z = -1;
    }

    public static boolean Y(long j10) {
        return j10 < -30000;
    }

    public static boolean Z(long j10) {
        return j10 < -500000;
    }

    public void A0(j jVar) {
        this.L7.f26763f++;
        jVar.p();
    }

    public void B0(int i10) {
        eb.d dVar = this.L7;
        dVar.f26764g += i10;
        this.G7 += i10;
        int i11 = this.H7 + i10;
        this.H7 = i11;
        dVar.f26765h = Math.max(i11, dVar.f26765h);
        int i12 = this.f32141n;
        if (i12 <= 0 || this.G7 < i12) {
            return;
        }
        c0();
    }

    @Override // com.google.android.exoplayer2.a
    public void G() {
        this.f32145r = null;
        R();
        Q();
        try {
            w0(null);
            o0();
        } finally {
            this.f32142o.l(this.L7);
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void H(boolean z10, boolean z11) throws ExoPlaybackException {
        eb.d dVar = new eb.d();
        this.L7 = dVar;
        this.f32142o.n(dVar);
        this.K0 = z11;
        this.f32139k1 = false;
    }

    @Override // com.google.android.exoplayer2.a
    public void I(long j10, boolean z10) throws ExoPlaybackException {
        this.f32151v2 = false;
        this.C2 = false;
        Q();
        this.f32150v1 = ya.g.f56663b;
        this.H7 = 0;
        if (this.f32147t != null) {
            W();
        }
        if (z10) {
            t0();
        } else {
            this.C1 = ya.g.f56663b;
        }
        this.f32143p.c();
    }

    @Override // com.google.android.exoplayer2.a
    public void K() {
        this.G7 = 0;
        this.F7 = SystemClock.elapsedRealtime();
        this.J7 = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.google.android.exoplayer2.a
    public void L() {
        this.C1 = ya.g.f56663b;
        c0();
    }

    @Override // com.google.android.exoplayer2.a
    public void M(Format[] formatArr, long j10, long j11) throws ExoPlaybackException {
        this.K7 = j11;
        super.M(formatArr, j10, j11);
    }

    public eb.e P(String str, Format format, Format format2) {
        return new eb.e(str, format, format2, 0, 1);
    }

    public final void Q() {
        this.f32138k0 = false;
    }

    public final void R() {
        this.K2 = -1;
        this.E7 = -1;
    }

    public abstract eb.c<i, ? extends j, ? extends DecoderException> S(Format format, @p0 gb.s sVar) throws DecoderException;

    public final boolean T(long j10, long j11) throws ExoPlaybackException, DecoderException {
        if (this.f32149v == null) {
            j jVarB = this.f32147t.b();
            this.f32149v = jVarB;
            if (jVarB == null) {
                return false;
            }
            eb.d dVar = this.L7;
            int i10 = dVar.f26763f;
            int i11 = jVarB.f26794c;
            dVar.f26763f = i10 + i11;
            this.I7 -= i11;
        }
        if (!this.f32149v.m()) {
            boolean zN0 = n0(j10, j11);
            if (zN0) {
                l0(this.f32149v.f26793b);
                this.f32149v = null;
            }
            return zN0;
        }
        if (this.C == 2) {
            o0();
            b0();
        } else {
            this.f32149v.p();
            this.f32149v = null;
            this.C2 = true;
        }
        return false;
    }

    public void U(j jVar) {
        B0(1);
        jVar.p();
    }

    public final boolean V() throws ExoPlaybackException, DecoderException {
        eb.c<i, ? extends j, ? extends DecoderException> cVar = this.f32147t;
        if (cVar == null || this.C == 2 || this.f32151v2) {
            return false;
        }
        if (this.f32148u == null) {
            i iVarC = cVar.c();
            this.f32148u = iVarC;
            if (iVarC == null) {
                return false;
            }
        }
        if (this.C == 1) {
            this.f32148u.o(4);
            this.f32147t.d(this.f32148u);
            this.f32148u = null;
            this.C = 2;
            return false;
        }
        s0 s0VarB = B();
        int iN = N(s0VarB, this.f32148u, false);
        if (iN == -5) {
            h0(s0VarB);
            return true;
        }
        if (iN != -4) {
            if (iN == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        if (this.f32148u.m()) {
            this.f32151v2 = true;
            this.f32147t.d(this.f32148u);
            this.f32148u = null;
            return false;
        }
        if (this.K1) {
            this.f32143p.a(this.f32148u.f16962e, this.f32145r);
            this.K1 = false;
        }
        this.f32148u.r();
        i iVar = this.f32148u;
        iVar.f32229l = this.f32145r;
        m0(iVar);
        this.f32147t.d(this.f32148u);
        this.I7++;
        this.D = true;
        this.L7.f26760c++;
        this.f32148u = null;
        return true;
    }

    @g.i
    public void W() throws ExoPlaybackException {
        this.I7 = 0;
        if (this.C != 0) {
            o0();
            b0();
            return;
        }
        this.f32148u = null;
        j jVar = this.f32149v;
        if (jVar != null) {
            jVar.p();
            this.f32149v = null;
        }
        this.f32147t.flush();
        this.D = false;
    }

    public final boolean X() {
        return this.f32155z != -1;
    }

    public boolean a0(long j10) throws ExoPlaybackException {
        int iO = O(j10);
        if (iO == 0) {
            return false;
        }
        this.L7.f26766i++;
        B0(this.I7 + iO);
        W();
        return true;
    }

    @Override // ya.o1
    public boolean b() {
        return this.C2;
    }

    public final void b0() throws ExoPlaybackException {
        if (this.f32147t != null) {
            return;
        }
        r0(this.B);
        gb.s sVarJ = null;
        DrmSession drmSession = this.A;
        if (drmSession != null && (sVarJ = drmSession.j()) == null && this.A.d() == null) {
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f32147t = S(this.f32145r, sVarJ);
            s0(this.f32155z);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f32142o.j(this.f32147t.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.L7.f26758a++;
        } catch (DecoderException | OutOfMemoryError e10) {
            throw y(e10, this.f32145r);
        }
    }

    public final void c0() {
        if (this.G7 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f32142o.m(this.G7, jElapsedRealtime - this.F7);
            this.G7 = 0;
            this.F7 = jElapsedRealtime;
        }
    }

    @Override // ya.o1
    public boolean d() {
        if (this.f32145r != null && ((F() || this.f32149v != null) && (this.f32138k0 || !X()))) {
            this.C1 = ya.g.f56663b;
            return true;
        }
        if (this.C1 == ya.g.f56663b) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.C1) {
            return true;
        }
        this.C1 = ya.g.f56663b;
        return false;
    }

    public final void d0() {
        this.f32139k1 = true;
        if (this.f32138k0) {
            return;
        }
        this.f32138k0 = true;
        this.f32142o.y(this.f32152w);
    }

    public final void e0(int i10, int i11) {
        if (this.K2 == i10 && this.E7 == i11) {
            return;
        }
        this.K2 = i10;
        this.E7 = i11;
        this.f32142o.A(i10, i11, 0, 1.0f);
    }

    public final void f0() {
        if (this.f32138k0) {
            this.f32142o.y(this.f32152w);
        }
    }

    public final void g0() {
        int i10 = this.K2;
        if (i10 == -1 && this.E7 == -1) {
            return;
        }
        this.f32142o.A(i10, this.E7, 0, 1.0f);
    }

    @g.i
    public void h0(s0 s0Var) throws ExoPlaybackException {
        this.K1 = true;
        Format format = (Format) hd.a.g(s0Var.f57068b);
        w0(s0Var.f57067a);
        Format format2 = this.f32145r;
        this.f32145r = format;
        eb.c<i, ? extends j, ? extends DecoderException> cVar = this.f32147t;
        if (cVar == null) {
            b0();
            this.f32142o.o(this.f32145r, null);
            return;
        }
        eb.e eVar = this.B != this.A ? new eb.e(cVar.getName(), format2, format, 0, 128) : P(cVar.getName(), format2, format);
        if (eVar.f26791d == 0) {
            if (this.D) {
                this.C = 1;
            } else {
                o0();
                b0();
            }
        }
        this.f32142o.o(this.f32145r, eVar);
    }

    public final void i0() {
        g0();
        Q();
        if (getState() == 2) {
            t0();
        }
    }

    public final void j0() {
        R();
        Q();
    }

    public final void k0() {
        g0();
        f0();
    }

    @g.i
    public void l0(long j10) {
        this.I7--;
    }

    public void m0(i iVar) {
    }

    public final boolean n0(long j10, long j11) throws ExoPlaybackException, DecoderException {
        if (this.f32150v1 == ya.g.f56663b) {
            this.f32150v1 = j10;
        }
        long j12 = this.f32149v.f26793b - j10;
        if (!X()) {
            if (!Y(j12)) {
                return false;
            }
            A0(this.f32149v);
            return true;
        }
        long j13 = this.f32149v.f26793b - this.K7;
        Format formatJ = this.f32143p.j(j13);
        if (formatJ != null) {
            this.f32146s = formatJ;
        }
        long jElapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.J7;
        boolean z10 = getState() == 2;
        if ((this.f32139k1 ? !this.f32138k0 : z10 || this.K0) || (z10 && z0(j12, jElapsedRealtime))) {
            p0(this.f32149v, j13, this.f32146s);
            return true;
        }
        if (!z10 || j10 == this.f32150v1 || (x0(j12, j11) && a0(j10))) {
            return false;
        }
        if (y0(j12, j11)) {
            U(this.f32149v);
            return true;
        }
        if (j12 < 30000) {
            p0(this.f32149v, j13, this.f32146s);
            return true;
        }
        return false;
    }

    @g.i
    public void o0() {
        this.f32148u = null;
        this.f32149v = null;
        this.C = 0;
        this.D = false;
        this.I7 = 0;
        eb.c<i, ? extends j, ? extends DecoderException> cVar = this.f32147t;
        if (cVar != null) {
            this.L7.f26759b++;
            cVar.release();
            this.f32142o.k(this.f32147t.getName());
            this.f32147t = null;
        }
        r0(null);
    }

    public void p0(j jVar, long j10, Format format) throws DecoderException {
        l lVar = this.f32154y;
        if (lVar != null) {
            lVar.c(j10, System.nanoTime(), format, null);
        }
        this.J7 = ya.g.c(SystemClock.elapsedRealtime() * 1000);
        int i10 = jVar.f32235e;
        boolean z10 = i10 == 1 && this.f32152w != null;
        boolean z11 = i10 == 0 && this.f32153x != null;
        if (!z11 && !z10) {
            U(jVar);
            return;
        }
        e0(jVar.f32237g, jVar.f32238h);
        if (z11) {
            this.f32153x.a(jVar);
        } else {
            q0(jVar, this.f32152w);
        }
        this.H7 = 0;
        this.L7.f26762e++;
        d0();
    }

    @Override // ya.o1
    public void q(long j10, long j11) throws ExoPlaybackException {
        if (this.C2) {
            return;
        }
        if (this.f32145r == null) {
            s0 s0VarB = B();
            this.f32144q.h();
            int iN = N(s0VarB, this.f32144q, true);
            if (iN != -5) {
                if (iN == -4) {
                    hd.a.i(this.f32144q.m());
                    this.f32151v2 = true;
                    this.C2 = true;
                    return;
                }
                return;
            }
            h0(s0VarB);
        }
        b0();
        if (this.f32147t != null) {
            try {
                q0.a("drainAndFeed");
                while (T(j10, j11)) {
                }
                while (V()) {
                }
                q0.c();
                this.L7.c();
            } catch (DecoderException e10) {
                throw y(e10, this.f32145r);
            }
        }
    }

    public abstract void q0(j jVar, Surface surface) throws DecoderException;

    @Override // com.google.android.exoplayer2.a, ya.l1.b
    public void r(int i10, @p0 Object obj) throws ExoPlaybackException {
        if (i10 == 1) {
            v0((Surface) obj);
            return;
        }
        if (i10 == 8) {
            u0((k) obj);
        } else if (i10 == 6) {
            this.f32154y = (l) obj;
        } else {
            super.r(i10, obj);
        }
    }

    public final void r0(@p0 DrmSession drmSession) {
        gb.i.b(this.A, drmSession);
        this.A = drmSession;
    }

    public abstract void s0(int i10);

    public final void t0() {
        this.C1 = this.f32140m > 0 ? SystemClock.elapsedRealtime() + this.f32140m : ya.g.f56663b;
    }

    public final void u0(@p0 k kVar) {
        if (this.f32153x == kVar) {
            if (kVar != null) {
                k0();
                return;
            }
            return;
        }
        this.f32153x = kVar;
        if (kVar == null) {
            this.f32155z = -1;
            j0();
            return;
        }
        this.f32152w = null;
        this.f32155z = 0;
        if (this.f32147t != null) {
            s0(0);
        }
        i0();
    }

    public final void v0(@p0 Surface surface) {
        if (this.f32152w == surface) {
            if (surface != null) {
                k0();
                return;
            }
            return;
        }
        this.f32152w = surface;
        if (surface == null) {
            this.f32155z = -1;
            j0();
            return;
        }
        this.f32153x = null;
        this.f32155z = 1;
        if (this.f32147t != null) {
            s0(1);
        }
        i0();
    }

    public final void w0(@p0 DrmSession drmSession) {
        gb.i.b(this.B, drmSession);
        this.B = drmSession;
    }

    public boolean x0(long j10, long j11) {
        return Z(j10);
    }

    public boolean y0(long j10, long j11) {
        return Y(j10);
    }

    public boolean z0(long j10, long j11) {
        return Y(j10) && j11 > 100000;
    }
}
