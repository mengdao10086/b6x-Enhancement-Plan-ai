package rb;

import ab.x;
import com.google.android.exoplayer2.Format;
import g.p0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements m {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f48350m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f48351n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f48352o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f48353p = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.c0 f48354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x.a f48355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f48356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public hb.d0 f48357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f48358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f48359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f48360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f48361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f48362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f48363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f48364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f48365l;

    public t() {
        this(null);
    }

    @Override // rb.m
    public void a() {
        this.f48359f = 0;
        this.f48360g = 0;
        this.f48362i = false;
    }

    public final void b(hd.c0 c0Var) {
        byte[] bArrD = c0Var.d();
        int iF = c0Var.f();
        for (int iE = c0Var.e(); iE < iF; iE++) {
            boolean z10 = (bArrD[iE] & 255) == 255;
            boolean z11 = this.f48362i && (bArrD[iE] & 224) == 224;
            this.f48362i = z10;
            if (z11) {
                c0Var.S(iE + 1);
                this.f48362i = false;
                this.f48354a.d()[1] = bArrD[iE];
                this.f48360g = 2;
                this.f48359f = 1;
                return;
            }
        }
        c0Var.S(iF);
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) {
        hd.a.k(this.f48357d);
        while (c0Var.a() > 0) {
            int i10 = this.f48359f;
            if (i10 == 0) {
                b(c0Var);
            } else if (i10 == 1) {
                h(c0Var);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException();
                }
                g(c0Var);
            }
        }
    }

    @Override // rb.m
    public void d() {
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        eVar.a();
        this.f48358e = eVar.b();
        this.f48357d = mVar.d(eVar.c(), 1);
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        this.f48365l = j10;
    }

    @RequiresNonNull({"output"})
    public final void g(hd.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), this.f48364k - this.f48360g);
        this.f48357d.d(c0Var, iMin);
        int i10 = this.f48360g + iMin;
        this.f48360g = i10;
        int i11 = this.f48364k;
        if (i10 < i11) {
            return;
        }
        this.f48357d.a(this.f48365l, 1, i11, 0, null);
        this.f48365l += this.f48363j;
        this.f48360g = 0;
        this.f48359f = 0;
    }

    @RequiresNonNull({"output"})
    public final void h(hd.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), 4 - this.f48360g);
        c0Var.k(this.f48354a.d(), this.f48360g, iMin);
        int i10 = this.f48360g + iMin;
        this.f48360g = i10;
        if (i10 < 4) {
            return;
        }
        this.f48354a.S(0);
        if (!this.f48355b.a(this.f48354a.o())) {
            this.f48360g = 0;
            this.f48359f = 1;
            return;
        }
        x.a aVar = this.f48355b;
        this.f48364k = aVar.f519c;
        if (!this.f48361h) {
            this.f48363j = (((long) aVar.f523g) * 1000000) / ((long) aVar.f520d);
            this.f48357d.f(new Format.b().S(this.f48358e).e0(this.f48355b.f518b).W(4096).H(this.f48355b.f521e).f0(this.f48355b.f520d).V(this.f48356c).E());
            this.f48361h = true;
        }
        this.f48354a.S(0);
        this.f48357d.d(this.f48354a, 4);
        this.f48359f = 2;
    }

    public t(@p0 String str) {
        this.f48359f = 0;
        hd.c0 c0Var = new hd.c0(4);
        this.f48354a = c0Var;
        c0Var.d()[0] = -1;
        this.f48355b = new x.a();
        this.f48356c = str;
    }
}
