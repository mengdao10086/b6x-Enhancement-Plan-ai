package rb;

import android.net.Uri;
import hb.a0;
import java.io.IOException;
import java.util.Map;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements hb.k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final hb.q f47977g = new hb.q() { // from class: rb.d
        @Override // hb.q
        public final hb.k[] a() {
            return e.d();
        }

        @Override // hb.q
        public /* synthetic */ hb.k[] b(Uri uri, Map map) {
            return hb.p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f47978h = 8192;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f47979i = 16384;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f47980j = 7;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f47981d = new f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hd.c0 f47982e = new hd.c0(16384);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f47983f;

    public static /* synthetic */ hb.k[] d() {
        return new hb.k[]{new e()};
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        this.f47983f = false;
        this.f47981d.a();
    }

    @Override // hb.k
    public void c(hb.m mVar) {
        this.f47981d.e(mVar, new i0.e(0, 1));
        mVar.k();
        mVar.o(new a0.b(ya.g.f56663b));
    }

    @Override // hb.k
    public int f(hb.l lVar, hb.z zVar) throws IOException {
        int i10 = lVar.read(this.f47982e.d(), 0, 16384);
        if (i10 == -1) {
            return -1;
        }
        this.f47982e.S(0);
        this.f47982e.R(i10);
        if (!this.f47983f) {
            this.f47981d.f(0L, 4);
            this.f47983f = true;
        }
        this.f47981d.c(this.f47982e);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
    
        r9.n();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
    
        if ((r4 - r3) < 8192) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
    
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
            hd.c0 r0 = new hd.c0
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.d()
            r9.t(r4, r2, r1)
            r0.S(r2)
            int r4 = r0.J()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L65
            r9.n()
            r9.j(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.d()
            r6 = 7
            r9.t(r5, r2, r6)
            r0.S(r2)
            int r5 = r0.M()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L4d
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L4d
            r9.n()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L49
            return r2
        L49:
            r9.j(r4)
            goto L23
        L4d:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L53
            return r6
        L53:
            byte[] r6 = r0.d()
            int r5 = ab.c.e(r6, r5)
            r6 = -1
            if (r5 != r6) goto L5f
            return r2
        L5f:
            int r5 = r5 + (-7)
            r9.j(r5)
            goto L24
        L65:
            r4 = 3
            r0.T(r4)
            int r4 = r0.F()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.j(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.e.i(hb.l):boolean");
    }

    @Override // hb.k
    public void release() {
    }
}
