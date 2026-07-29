package rb;

import android.net.Uri;
import hb.a0;
import java.io.IOException;
import java.util.Map;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements hb.k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final hb.q f47942g = new hb.q() { // from class: rb.a
        @Override // hb.q
        public final hb.k[] a() {
            return b.d();
        }

        @Override // hb.q
        public /* synthetic */ hb.k[] b(Uri uri, Map map) {
            return hb.p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f47943h = 8192;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f47944i = 2935;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f47945j = 2786;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f47946d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hd.c0 f47947e = new hd.c0(f47945j);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f47948f;

    public static /* synthetic */ hb.k[] d() {
        return new hb.k[]{new b()};
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        this.f47948f = false;
        this.f47946d.a();
    }

    @Override // hb.k
    public void c(hb.m mVar) {
        this.f47946d.e(mVar, new i0.e(0, 1));
        mVar.k();
        mVar.o(new a0.b(ya.g.f56663b));
    }

    @Override // hb.k
    public int f(hb.l lVar, hb.z zVar) throws IOException {
        int i10 = lVar.read(this.f47947e.d(), 0, f47945j);
        if (i10 == -1) {
            return -1;
        }
        this.f47947e.S(0);
        this.f47947e.R(i10);
        if (!this.f47948f) {
            this.f47946d.f(0L, 4);
            this.f47948f = true;
        }
        this.f47946d.c(this.f47947e);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
    
        if ((r4 - r3) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
    
        r8.n();
        r4 = r4 + 1;
     */
    @Override // hb.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean i(hb.l r8) throws java.io.IOException {
        /*
            r7 = this;
            hd.c0 r0 = new hd.c0
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.d()
            r8.t(r4, r2, r1)
            r0.S(r2)
            int r4 = r0.J()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L5f
            r8.n()
            r8.j(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.d()
            r6 = 6
            r8.t(r5, r2, r6)
            r0.S(r2)
            int r5 = r0.M()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L47
            r8.n()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L43
            return r2
        L43:
            r8.j(r4)
            goto L23
        L47:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L4d
            return r5
        L4d:
            byte[] r5 = r0.d()
            int r5 = ab.b.f(r5)
            r6 = -1
            if (r5 != r6) goto L59
            return r2
        L59:
            int r5 = r5 + (-6)
            r8.j(r5)
            goto L24
        L5f:
            r4 = 3
            r0.T(r4)
            int r4 = r0.F()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.j(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.b.i(hb.l):boolean");
    }

    @Override // hb.k
    public void release() {
    }
}
