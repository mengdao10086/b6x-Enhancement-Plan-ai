package rb;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import hb.a0;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements hb.k {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final hb.q f48017p = new hb.q() { // from class: rb.g
        @Override // hb.q
        public final hb.k[] a() {
            return h.h();
        }

        @Override // hb.q
        public /* synthetic */ hb.k[] b(Uri uri, Map map) {
            return hb.p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f48018q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f48019r = 2048;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f48020s = 8192;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f48021t = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f48022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f48023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hd.c0 f48024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final hd.c0 f48025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final hd.b0 f48026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public hb.m f48027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f48028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f48029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f48030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f48031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f48032n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f48033o;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public h() {
        this(0);
    }

    public static int e(int i10, long j10) {
        return (int) ((((long) (i10 * 8)) * 1000000) / j10);
    }

    public static /* synthetic */ hb.k[] h() {
        return new hb.k[]{new h()};
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        this.f48032n = false;
        this.f48023e.a();
        this.f48028j = j11;
    }

    @Override // hb.k
    public void c(hb.m mVar) {
        this.f48027i = mVar;
        this.f48023e.e(mVar, new i0.e(0, 1));
        mVar.k();
    }

    public final void d(hb.l lVar) throws IOException {
        int iH;
        if (this.f48031m) {
            return;
        }
        this.f48030l = -1;
        lVar.n();
        long j10 = 0;
        if (lVar.getPosition() == 0) {
            k(lVar);
        }
        int i10 = 0;
        int i11 = 0;
        do {
            try {
                if (!lVar.h(this.f48025g.d(), 0, 2, true)) {
                    break;
                }
                this.f48025g.S(0);
                if (!i.m(this.f48025g.M())) {
                    break;
                }
                if (!lVar.h(this.f48025g.d(), 0, 4, true)) {
                    break;
                }
                this.f48026h.q(14);
                iH = this.f48026h.h(13);
                if (iH <= 6) {
                    this.f48031m = true;
                    throw new ParserException("Malformed ADTS stream");
                }
                j10 += (long) iH;
                i11++;
                if (i11 == 1000) {
                    break;
                }
            } catch (EOFException unused) {
            }
        } while (lVar.q(iH - 6, true));
        i10 = i11;
        lVar.n();
        if (i10 > 0) {
            this.f48030l = (int) (j10 / ((long) i10));
        } else {
            this.f48030l = -1;
        }
        this.f48031m = true;
    }

    @Override // hb.k
    public int f(hb.l lVar, hb.z zVar) throws IOException {
        hd.a.k(this.f48027i);
        long length = lVar.getLength();
        boolean z10 = ((this.f48022d & 1) == 0 || length == -1) ? false : true;
        if (z10) {
            d(lVar);
        }
        int i10 = lVar.read(this.f48024f.d(), 0, 2048);
        boolean z11 = i10 == -1;
        j(length, z10, z11);
        if (z11) {
            return -1;
        }
        this.f48024f.S(0);
        this.f48024f.R(i10);
        if (!this.f48032n) {
            this.f48023e.f(this.f48028j, 4);
            this.f48032n = true;
        }
        this.f48023e.c(this.f48024f);
        return 0;
    }

    public final hb.a0 g(long j10) {
        return new hb.f(j10, this.f48029k, e(this.f48030l, this.f48023e.k()), this.f48030l);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        r9.n();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        if ((r3 - r0) < 8192) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        return false;
     */
    @Override // hb.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean i(hb.l r9) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.k(r9)
            r1 = 0
            r3 = r0
        L6:
            r2 = 0
            r4 = 0
        L8:
            hd.c0 r5 = r8.f48025g
            byte[] r5 = r5.d()
            r6 = 2
            r9.t(r5, r1, r6)
            hd.c0 r5 = r8.f48025g
            r5.S(r1)
            hd.c0 r5 = r8.f48025g
            int r5 = r5.M()
            boolean r5 = rb.i.m(r5)
            if (r5 != 0) goto L33
            r9.n()
            int r3 = r3 + 1
            int r2 = r3 - r0
            r4 = 8192(0x2000, float:1.148E-41)
            if (r2 < r4) goto L2f
            return r1
        L2f:
            r9.j(r3)
            goto L6
        L33:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L3d
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 <= r7) goto L3d
            return r5
        L3d:
            hd.c0 r5 = r8.f48025g
            byte[] r5 = r5.d()
            r9.t(r5, r1, r6)
            hd.b0 r5 = r8.f48026h
            r6 = 14
            r5.q(r6)
            hd.b0 r5 = r8.f48026h
            r6 = 13
            int r5 = r5.h(r6)
            r6 = 6
            if (r5 > r6) goto L59
            return r1
        L59:
            int r6 = r5 + (-6)
            r9.j(r6)
            int r4 = r4 + r5
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.h.i(hb.l):boolean");
    }

    @RequiresNonNull({"extractorOutput"})
    public final void j(long j10, boolean z10, boolean z11) {
        if (this.f48033o) {
            return;
        }
        boolean z12 = z10 && this.f48030l > 0;
        if (z12 && this.f48023e.k() == ya.g.f56663b && !z11) {
            return;
        }
        if (!z12 || this.f48023e.k() == ya.g.f56663b) {
            this.f48027i.o(new a0.b(ya.g.f56663b));
        } else {
            this.f48027i.o(g(j10));
        }
        this.f48033o = true;
    }

    public final int k(hb.l lVar) throws IOException {
        int i10 = 0;
        while (true) {
            lVar.t(this.f48025g.d(), 0, 10);
            this.f48025g.S(0);
            if (this.f48025g.J() != 4801587) {
                break;
            }
            this.f48025g.T(3);
            int iF = this.f48025g.F();
            i10 += iF + 10;
            lVar.j(iF);
        }
        lVar.n();
        lVar.j(i10);
        if (this.f48029k == -1) {
            this.f48029k = i10;
        }
        return i10;
    }

    @Override // hb.k
    public void release() {
    }

    public h(int i10) {
        this.f48022d = i10;
        this.f48023e = new i(true);
        this.f48024f = new hd.c0(2048);
        this.f48030l = -1;
        this.f48029k = -1L;
        hd.c0 c0Var = new hd.c0(10);
        this.f48025g = c0Var;
        this.f48026h = new hd.b0(c0Var.d());
    }
}
