package rb;

import android.net.Uri;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import hb.a0;
import hd.p0;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements hb.k {
    public static final int A = 240;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final hb.q f47910o = new hb.q() { // from class: rb.z
        @Override // hb.q
        public final hb.k[] a() {
            return a0.d();
        }

        @Override // hb.q
        public /* synthetic */ hb.k[] b(Uri uri, Map map) {
            return hb.p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f47911p = 442;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f47912q = 443;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f47913r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f47914s = 441;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f47915t = 256;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f47916u = 1048576;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f47917v = 8192;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f47918w = 189;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f47919x = 192;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f47920y = 224;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f47921z = 224;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p0 f47922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<a> f47923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hd.c0 f47924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y f47925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f47926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f47927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f47928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f47929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.p0
    public x f47930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public hb.m f47931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f47932n;

    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f47933i = 64;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f47934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p0 f47935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final hd.b0 f47936c = new hd.b0(new byte[64]);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f47937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f47938e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f47939f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f47940g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f47941h;

        public a(m mVar, p0 p0Var) {
            this.f47934a = mVar;
            this.f47935b = p0Var;
        }

        public void a(hd.c0 c0Var) throws ParserException {
            c0Var.k(this.f47936c.f30961a, 0, 3);
            this.f47936c.q(0);
            b();
            c0Var.k(this.f47936c.f30961a, 0, this.f47940g);
            this.f47936c.q(0);
            c();
            this.f47934a.f(this.f47941h, 4);
            this.f47934a.c(c0Var);
            this.f47934a.d();
        }

        public final void b() {
            this.f47936c.s(8);
            this.f47937d = this.f47936c.g();
            this.f47938e = this.f47936c.g();
            this.f47936c.s(6);
            this.f47940g = this.f47936c.h(8);
        }

        public final void c() {
            this.f47941h = 0L;
            if (this.f47937d) {
                this.f47936c.s(4);
                long jH = ((long) this.f47936c.h(3)) << 30;
                this.f47936c.s(1);
                long jH2 = jH | ((long) (this.f47936c.h(15) << 15));
                this.f47936c.s(1);
                long jH3 = jH2 | ((long) this.f47936c.h(15));
                this.f47936c.s(1);
                if (!this.f47939f && this.f47938e) {
                    this.f47936c.s(4);
                    long jH4 = ((long) this.f47936c.h(3)) << 30;
                    this.f47936c.s(1);
                    long jH5 = jH4 | ((long) (this.f47936c.h(15) << 15));
                    this.f47936c.s(1);
                    long jH6 = jH5 | ((long) this.f47936c.h(15));
                    this.f47936c.s(1);
                    this.f47935b.b(jH6);
                    this.f47939f = true;
                }
                this.f47941h = this.f47935b.b(jH3);
            }
        }

        public void d() {
            this.f47939f = false;
            this.f47934a.a();
        }
    }

    public a0() {
        this(new p0(0L));
    }

    public static /* synthetic */ hb.k[] d() {
        return new hb.k[]{new a0()};
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        if ((this.f47922d.e() == ya.g.f56663b) || (this.f47922d.c() != 0 && this.f47922d.c() != j11)) {
            this.f47922d.g(j11);
        }
        x xVar = this.f47930l;
        if (xVar != null) {
            xVar.h(j11);
        }
        for (int i10 = 0; i10 < this.f47923e.size(); i10++) {
            this.f47923e.valueAt(i10).d();
        }
    }

    @Override // hb.k
    public void c(hb.m mVar) {
        this.f47931m = mVar;
    }

    @RequiresNonNull({"output"})
    public final void e(long j10) {
        if (this.f47932n) {
            return;
        }
        this.f47932n = true;
        if (this.f47925g.c() == ya.g.f56663b) {
            this.f47931m.o(new a0.b(this.f47925g.c()));
            return;
        }
        x xVar = new x(this.f47925g.d(), this.f47925g.c(), j10);
        this.f47930l = xVar;
        this.f47931m.o(xVar.b());
    }

    @Override // hb.k
    public int f(hb.l lVar, hb.z zVar) throws IOException {
        hd.a.k(this.f47931m);
        long length = lVar.getLength();
        if ((length != -1) && !this.f47925g.e()) {
            return this.f47925g.g(lVar, zVar);
        }
        e(length);
        x xVar = this.f47930l;
        if (xVar != null && xVar.d()) {
            return this.f47930l.c(lVar, zVar);
        }
        lVar.n();
        long jI = length != -1 ? length - lVar.i() : -1L;
        if ((jI != -1 && jI < 4) || !lVar.h(this.f47924f.d(), 0, 4, true)) {
            return -1;
        }
        this.f47924f.S(0);
        int iO = this.f47924f.o();
        if (iO == 441) {
            return -1;
        }
        if (iO == 442) {
            lVar.t(this.f47924f.d(), 0, 10);
            this.f47924f.S(9);
            lVar.o((this.f47924f.G() & 7) + 14);
            return 0;
        }
        if (iO == 443) {
            lVar.t(this.f47924f.d(), 0, 2);
            this.f47924f.S(0);
            lVar.o(this.f47924f.M() + 6);
            return 0;
        }
        if (((iO & (-256)) >> 8) != 1) {
            lVar.o(1);
            return 0;
        }
        int i10 = iO & 255;
        a aVar = this.f47923e.get(i10);
        if (!this.f47926h) {
            if (aVar == null) {
                m nVar = null;
                if (i10 == 189) {
                    nVar = new c();
                    this.f47927i = true;
                    this.f47929k = lVar.getPosition();
                } else if ((i10 & 224) == 192) {
                    nVar = new t();
                    this.f47927i = true;
                    this.f47929k = lVar.getPosition();
                } else if ((i10 & 240) == 224) {
                    nVar = new n();
                    this.f47928j = true;
                    this.f47929k = lVar.getPosition();
                }
                if (nVar != null) {
                    nVar.e(this.f47931m, new i0.e(i10, 256));
                    aVar = new a(nVar, this.f47922d);
                    this.f47923e.put(i10, aVar);
                }
            }
            if (lVar.getPosition() > ((this.f47927i && this.f47928j) ? this.f47929k + 8192 : 1048576L)) {
                this.f47926h = true;
                this.f47931m.k();
            }
        }
        lVar.t(this.f47924f.d(), 0, 2);
        this.f47924f.S(0);
        int iM = this.f47924f.M() + 6;
        if (aVar == null) {
            lVar.o(iM);
        } else {
            this.f47924f.O(iM);
            lVar.readFully(this.f47924f.d(), 0, iM);
            this.f47924f.S(6);
            aVar.a(this.f47924f);
            hd.c0 c0Var = this.f47924f;
            c0Var.R(c0Var.b());
        }
        return 0;
    }

    @Override // hb.k
    public boolean i(hb.l lVar) throws IOException {
        byte[] bArr = new byte[14];
        lVar.t(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        lVar.j(bArr[13] & 7);
        lVar.t(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // hb.k
    public void release() {
    }

    public a0(p0 p0Var) {
        this.f47922d = p0Var;
        this.f47924f = new hd.c0(4096);
        this.f47923e = new SparseArray<>();
        this.f47925g = new y();
    }
}
