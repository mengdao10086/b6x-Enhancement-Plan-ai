package kb;

import android.net.Uri;
import hb.a0;
import hb.k;
import hb.l;
import hb.m;
import hb.p;
import hb.q;
import hb.z;
import hd.c0;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements k {
    public static final int A = 8;
    public static final int B = 9;
    public static final int C = 18;
    public static final int D = 4607062;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final q f37127t = new q() { // from class: kb.a
        @Override // hb.q
        public final k[] a() {
            return b.g();
        }

        @Override // hb.q
        public /* synthetic */ k[] b(Uri uri, Map map) {
            return p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f37128u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f37129v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f37130w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f37131x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f37132y = 9;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f37133z = 11;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m f37139i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f37141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f37142l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f37143m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f37144n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f37145o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f37146p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f37147q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.flv.a f37148r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.flv.b f37149s;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f37134d = new c0(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f37135e = new c0(9);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0 f37136f = new c0(11);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f37137g = new c0();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f37138h = new c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f37140j = 1;

    public static /* synthetic */ k[] g() {
        return new k[]{new b()};
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        if (j10 == 0) {
            this.f37140j = 1;
            this.f37141k = false;
        } else {
            this.f37140j = 3;
        }
        this.f37143m = 0;
    }

    @Override // hb.k
    public void c(m mVar) {
        this.f37139i = mVar;
    }

    @RequiresNonNull({"extractorOutput"})
    public final void d() {
        if (this.f37147q) {
            return;
        }
        this.f37139i.o(new a0.b(g.f56663b));
        this.f37147q = true;
    }

    public final long e() {
        if (this.f37141k) {
            return this.f37142l + this.f37146p;
        }
        if (this.f37138h.e() == g.f56663b) {
            return 0L;
        }
        return this.f37146p;
    }

    @Override // hb.k
    public int f(l lVar, z zVar) throws IOException {
        hd.a.k(this.f37139i);
        while (true) {
            int i10 = this.f37140j;
            if (i10 != 1) {
                if (i10 == 2) {
                    m(lVar);
                } else if (i10 != 3) {
                    if (i10 != 4) {
                        throw new IllegalStateException();
                    }
                    if (k(lVar)) {
                        return 0;
                    }
                } else if (!l(lVar)) {
                    return -1;
                }
            } else if (!j(lVar)) {
                return -1;
            }
        }
    }

    public final c0 h(l lVar) throws IOException {
        if (this.f37145o > this.f37137g.b()) {
            c0 c0Var = this.f37137g;
            c0Var.Q(new byte[Math.max(c0Var.b() * 2, this.f37145o)], 0);
        } else {
            this.f37137g.S(0);
        }
        this.f37137g.R(this.f37145o);
        lVar.readFully(this.f37137g.d(), 0, this.f37145o);
        return this.f37137g;
    }

    @Override // hb.k
    public boolean i(l lVar) throws IOException {
        lVar.t(this.f37134d.d(), 0, 3);
        this.f37134d.S(0);
        if (this.f37134d.J() != 4607062) {
            return false;
        }
        lVar.t(this.f37134d.d(), 0, 2);
        this.f37134d.S(0);
        if ((this.f37134d.M() & 250) != 0) {
            return false;
        }
        lVar.t(this.f37134d.d(), 0, 4);
        this.f37134d.S(0);
        int iO = this.f37134d.o();
        lVar.n();
        lVar.j(iO);
        lVar.t(this.f37134d.d(), 0, 4);
        this.f37134d.S(0);
        return this.f37134d.o() == 0;
    }

    @RequiresNonNull({"extractorOutput"})
    public final boolean j(l lVar) throws IOException {
        if (!lVar.e(this.f37135e.d(), 0, 9, true)) {
            return false;
        }
        this.f37135e.S(0);
        this.f37135e.T(4);
        int iG = this.f37135e.G();
        boolean z10 = (iG & 4) != 0;
        boolean z11 = (iG & 1) != 0;
        if (z10 && this.f37148r == null) {
            this.f37148r = new com.google.android.exoplayer2.extractor.flv.a(this.f37139i.d(8, 1));
        }
        if (z11 && this.f37149s == null) {
            this.f37149s = new com.google.android.exoplayer2.extractor.flv.b(this.f37139i.d(9, 2));
        }
        this.f37139i.k();
        this.f37143m = (this.f37135e.o() - 9) + 4;
        this.f37140j = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(hb.l r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.e()
            int r2 = r9.f37144n
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = 0
            r6 = 1
            r7 = 8
            if (r2 != r7) goto L24
            com.google.android.exoplayer2.extractor.flv.a r7 = r9.f37148r
            if (r7 == 0) goto L24
            r9.d()
            com.google.android.exoplayer2.extractor.flv.a r2 = r9.f37148r
            hd.c0 r10 = r9.h(r10)
            boolean r5 = r2.a(r10, r0)
        L22:
            r10 = 1
            goto L75
        L24:
            r7 = 9
            if (r2 != r7) goto L3a
            com.google.android.exoplayer2.extractor.flv.b r7 = r9.f37149s
            if (r7 == 0) goto L3a
            r9.d()
            com.google.android.exoplayer2.extractor.flv.b r2 = r9.f37149s
            hd.c0 r10 = r9.h(r10)
            boolean r5 = r2.a(r10, r0)
            goto L22
        L3a:
            r7 = 18
            if (r2 != r7) goto L6f
            boolean r2 = r9.f37147q
            if (r2 != 0) goto L6f
            kb.c r2 = r9.f37138h
            hd.c0 r10 = r9.h(r10)
            boolean r5 = r2.a(r10, r0)
            kb.c r10 = r9.f37138h
            long r0 = r10.e()
            int r10 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r10 == 0) goto L22
            hb.m r10 = r9.f37139i
            hb.y r2 = new hb.y
            kb.c r7 = r9.f37138h
            long[] r7 = r7.f()
            kb.c r8 = r9.f37138h
            long[] r8 = r8.g()
            r2.<init>(r7, r8, r0)
            r10.o(r2)
            r9.f37147q = r6
            goto L22
        L6f:
            int r0 = r9.f37145o
            r10.o(r0)
            r10 = 0
        L75:
            boolean r0 = r9.f37141k
            if (r0 != 0) goto L8f
            if (r5 == 0) goto L8f
            r9.f37141k = r6
            kb.c r0 = r9.f37138h
            long r0 = r0.e()
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 != 0) goto L8b
            long r0 = r9.f37146p
            long r0 = -r0
            goto L8d
        L8b:
            r0 = 0
        L8d:
            r9.f37142l = r0
        L8f:
            r0 = 4
            r9.f37143m = r0
            r0 = 2
            r9.f37140j = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.b.k(hb.l):boolean");
    }

    public final boolean l(l lVar) throws IOException {
        if (!lVar.e(this.f37136f.d(), 0, 11, true)) {
            return false;
        }
        this.f37136f.S(0);
        this.f37144n = this.f37136f.G();
        this.f37145o = this.f37136f.J();
        this.f37146p = this.f37136f.J();
        this.f37146p = (((long) (this.f37136f.G() << 24)) | this.f37146p) * 1000;
        this.f37136f.T(3);
        this.f37140j = 4;
        return true;
    }

    public final void m(l lVar) throws IOException {
        lVar.o(this.f37143m);
        this.f37143m = 0;
        this.f37140j = 3;
    }

    @Override // hb.k
    public void release() {
    }
}
