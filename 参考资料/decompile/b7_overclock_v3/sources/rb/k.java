package rb;

import com.google.android.exoplayer2.Format;
import g.p0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements m {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f48127l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f48128m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f48129n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f48130o = 18;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f48132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f48133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public hb.d0 f48134d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f48136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f48137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f48138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Format f48139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f48140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f48141k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.c0 f48131a = new hd.c0(new byte[18]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f48135e = 0;

    public k(@p0 String str) {
        this.f48132b = str;
    }

    @Override // rb.m
    public void a() {
        this.f48135e = 0;
        this.f48136f = 0;
        this.f48137g = 0;
    }

    public final boolean b(hd.c0 c0Var, byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f48136f);
        c0Var.k(bArr, this.f48136f, iMin);
        int i11 = this.f48136f + iMin;
        this.f48136f = i11;
        return i11 == i10;
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) {
        hd.a.k(this.f48134d);
        while (c0Var.a() > 0) {
            int i10 = this.f48135e;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(c0Var.a(), this.f48140j - this.f48136f);
                    this.f48134d.d(c0Var, iMin);
                    int i11 = this.f48136f + iMin;
                    this.f48136f = i11;
                    int i12 = this.f48140j;
                    if (i11 == i12) {
                        this.f48134d.a(this.f48141k, 1, i12, 0, null);
                        this.f48141k += this.f48138h;
                        this.f48135e = 0;
                    }
                } else if (b(c0Var, this.f48131a.d(), 18)) {
                    g();
                    this.f48131a.S(0);
                    this.f48134d.d(this.f48131a, 18);
                    this.f48135e = 2;
                }
            } else if (h(c0Var)) {
                this.f48135e = 1;
            }
        }
    }

    @Override // rb.m
    public void d() {
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        eVar.a();
        this.f48133c = eVar.b();
        this.f48134d = mVar.d(eVar.c(), 1);
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        this.f48141k = j10;
    }

    @RequiresNonNull({"output"})
    public final void g() {
        byte[] bArrD = this.f48131a.d();
        if (this.f48139i == null) {
            Format formatG = ab.w.g(bArrD, this.f48133c, this.f48132b, null);
            this.f48139i = formatG;
            this.f48134d.f(formatG);
        }
        this.f48140j = ab.w.a(bArrD);
        this.f48138h = (int) ((((long) ab.w.f(bArrD)) * 1000000) / ((long) this.f48139i.f16713z));
    }

    public final boolean h(hd.c0 c0Var) {
        while (c0Var.a() > 0) {
            int i10 = this.f48137g << 8;
            this.f48137g = i10;
            int iG = i10 | c0Var.G();
            this.f48137g = iG;
            if (ab.w.d(iG)) {
                byte[] bArrD = this.f48131a.d();
                int i11 = this.f48137g;
                bArrD[0] = (byte) ((i11 >> 24) & 255);
                bArrD[1] = (byte) ((i11 >> 16) & 255);
                bArrD[2] = (byte) ((i11 >> 8) & 255);
                bArrD[3] = (byte) (i11 & 255);
                this.f48136f = 4;
                this.f48137g = 0;
                return true;
            }
        }
        return false;
    }
}
