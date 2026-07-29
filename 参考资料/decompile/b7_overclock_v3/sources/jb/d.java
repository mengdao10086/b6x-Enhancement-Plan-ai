package jb;

import android.net.Uri;
import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import hb.a0;
import hb.d0;
import hb.k;
import hb.l;
import hb.m;
import hb.p;
import hb.q;
import hb.r;
import hb.s;
import hb.t;
import hb.u;
import hb.z;
import hd.c0;
import hd.u0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements k {
    public static final int A = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final q f36286r = new q() { // from class: jb.c
        @Override // hb.q
        public final k[] a() {
            return d.j();
        }

        @Override // hb.q
        public /* synthetic */ k[] b(Uri uri, Map map) {
            return p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f36287s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f36288t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f36289u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f36290v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f36291w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f36292x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f36293y = 5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f36294z = 32768;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f36295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f36296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f36297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r.a f36298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f36299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d0 f36300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public Metadata f36302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u f36303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f36304m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f36305n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f36306o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f36307p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f36308q;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public d() {
        this(0);
    }

    public static /* synthetic */ k[] j() {
        return new k[]{new d()};
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        if (j10 == 0) {
            this.f36301j = 0;
        } else {
            b bVar = this.f36306o;
            if (bVar != null) {
                bVar.h(j11);
            }
        }
        this.f36308q = j11 != 0 ? -1L : 0L;
        this.f36307p = 0;
        this.f36296e.O(0);
    }

    @Override // hb.k
    public void c(m mVar) {
        this.f36299h = mVar;
        this.f36300i = mVar.d(0, 1);
        mVar.k();
    }

    public final long d(c0 c0Var, boolean z10) {
        boolean zD;
        hd.a.g(this.f36303l);
        int iE = c0Var.e();
        while (iE <= c0Var.f() - 16) {
            c0Var.S(iE);
            if (r.d(c0Var, this.f36303l, this.f36305n, this.f36298g)) {
                c0Var.S(iE);
                return this.f36298g.f30895a;
            }
            iE++;
        }
        if (!z10) {
            c0Var.S(iE);
            return -1L;
        }
        while (iE <= c0Var.f() - this.f36304m) {
            c0Var.S(iE);
            try {
                zD = r.d(c0Var, this.f36303l, this.f36305n, this.f36298g);
            } catch (IndexOutOfBoundsException unused) {
                zD = false;
            }
            if (c0Var.e() <= c0Var.f() ? zD : false) {
                c0Var.S(iE);
                return this.f36298g.f30895a;
            }
            iE++;
        }
        c0Var.S(c0Var.f());
        return -1L;
    }

    public final void e(l lVar) throws IOException {
        this.f36305n = s.b(lVar);
        ((m) u0.k(this.f36299h)).o(g(lVar.getPosition(), lVar.getLength()));
        this.f36301j = 5;
    }

    @Override // hb.k
    public int f(l lVar, z zVar) throws IOException {
        int i10 = this.f36301j;
        if (i10 == 0) {
            m(lVar);
            return 0;
        }
        if (i10 == 1) {
            h(lVar);
            return 0;
        }
        if (i10 == 2) {
            o(lVar);
            return 0;
        }
        if (i10 == 3) {
            n(lVar);
            return 0;
        }
        if (i10 == 4) {
            e(lVar);
            return 0;
        }
        if (i10 == 5) {
            return l(lVar, zVar);
        }
        throw new IllegalStateException();
    }

    public final a0 g(long j10, long j11) {
        hd.a.g(this.f36303l);
        u uVar = this.f36303l;
        if (uVar.f30915k != null) {
            return new t(uVar, j10);
        }
        if (j11 == -1 || uVar.f30914j <= 0) {
            return new a0.b(uVar.h());
        }
        b bVar = new b(uVar, this.f36305n, j10, j11);
        this.f36306o = bVar;
        return bVar.b();
    }

    public final void h(l lVar) throws IOException {
        byte[] bArr = this.f36295d;
        lVar.t(bArr, 0, bArr.length);
        lVar.n();
        this.f36301j = 2;
    }

    @Override // hb.k
    public boolean i(l lVar) throws IOException {
        s.c(lVar, false);
        return s.a(lVar);
    }

    public final void k() {
        ((d0) u0.k(this.f36300i)).a((this.f36308q * 1000000) / ((long) ((u) u0.k(this.f36303l)).f30909e), 1, this.f36307p, 0, null);
    }

    public final int l(l lVar, z zVar) throws IOException {
        boolean z10;
        hd.a.g(this.f36300i);
        hd.a.g(this.f36303l);
        b bVar = this.f36306o;
        if (bVar != null && bVar.d()) {
            return this.f36306o.c(lVar, zVar);
        }
        if (this.f36308q == -1) {
            this.f36308q = r.i(lVar, this.f36303l);
            return 0;
        }
        int iF = this.f36296e.f();
        if (iF < 32768) {
            int i10 = lVar.read(this.f36296e.d(), iF, 32768 - iF);
            z10 = i10 == -1;
            if (!z10) {
                this.f36296e.R(iF + i10);
            } else if (this.f36296e.a() == 0) {
                k();
                return -1;
            }
        } else {
            z10 = false;
        }
        int iE = this.f36296e.e();
        int i11 = this.f36307p;
        int i12 = this.f36304m;
        if (i11 < i12) {
            c0 c0Var = this.f36296e;
            c0Var.T(Math.min(i12 - i11, c0Var.a()));
        }
        long jD = d(this.f36296e, z10);
        int iE2 = this.f36296e.e() - iE;
        this.f36296e.S(iE);
        this.f36300i.d(this.f36296e, iE2);
        this.f36307p += iE2;
        if (jD != -1) {
            k();
            this.f36307p = 0;
            this.f36308q = jD;
        }
        if (this.f36296e.a() < 16) {
            int iA = this.f36296e.a();
            System.arraycopy(this.f36296e.d(), this.f36296e.e(), this.f36296e.d(), 0, iA);
            this.f36296e.S(0);
            this.f36296e.R(iA);
        }
        return 0;
    }

    public final void m(l lVar) throws IOException {
        this.f36302k = s.d(lVar, !this.f36297f);
        this.f36301j = 1;
    }

    public final void n(l lVar) throws IOException {
        s.a aVar = new s.a(this.f36303l);
        boolean zE = false;
        while (!zE) {
            zE = s.e(lVar, aVar);
            this.f36303l = (u) u0.k(aVar.f30899a);
        }
        hd.a.g(this.f36303l);
        this.f36304m = Math.max(this.f36303l.f30907c, 6);
        ((d0) u0.k(this.f36300i)).f(this.f36303l.i(this.f36295d, this.f36302k));
        this.f36301j = 4;
    }

    public final void o(l lVar) throws IOException {
        s.j(lVar);
        this.f36301j = 3;
    }

    @Override // hb.k
    public void release() {
    }

    public d(int i10) {
        this.f36295d = new byte[42];
        this.f36296e = new c0(new byte[32768], 0);
        this.f36297f = (i10 & 1) != 0;
        this.f36298g = new r.a();
        this.f36301j = 0;
    }
}
