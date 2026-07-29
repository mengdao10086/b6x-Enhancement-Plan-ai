package rb;

import ab.c;
import com.google.android.exoplayer2.Format;
import g.p0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements m {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f47990n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f47991o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f47992p = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.b0 f47993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hd.c0 f47994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f47995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f47996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public hb.d0 f47997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f47998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f47999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f48000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f48001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f48002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Format f48003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f48004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f48005m;

    public f() {
        this(null);
    }

    @Override // rb.m
    public void a() {
        this.f47998f = 0;
        this.f47999g = 0;
        this.f48000h = false;
        this.f48001i = false;
    }

    public final boolean b(hd.c0 c0Var, byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f47999g);
        c0Var.k(bArr, this.f47999g, iMin);
        int i11 = this.f47999g + iMin;
        this.f47999g = i11;
        return i11 == i10;
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) {
        hd.a.k(this.f47997e);
        while (c0Var.a() > 0) {
            int i10 = this.f47998f;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        int iMin = Math.min(c0Var.a(), this.f48004l - this.f47999g);
                        this.f47997e.d(c0Var, iMin);
                        int i11 = this.f47999g + iMin;
                        this.f47999g = i11;
                        int i12 = this.f48004l;
                        if (i11 == i12) {
                            this.f47997e.a(this.f48005m, 1, i12, 0, null);
                            this.f48005m += this.f48002j;
                            this.f47998f = 0;
                        }
                    }
                } else if (b(c0Var, this.f47994b.d(), 16)) {
                    g();
                    this.f47994b.S(0);
                    this.f47997e.d(this.f47994b, 16);
                    this.f47998f = 2;
                }
            } else if (h(c0Var)) {
                this.f47998f = 1;
                this.f47994b.d()[0] = -84;
                this.f47994b.d()[1] = (byte) (this.f48001i ? 65 : 64);
                this.f47999g = 2;
            }
        }
    }

    @Override // rb.m
    public void d() {
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        eVar.a();
        this.f47996d = eVar.b();
        this.f47997e = mVar.d(eVar.c(), 1);
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        this.f48005m = j10;
    }

    @RequiresNonNull({"output"})
    public final void g() {
        this.f47993a.q(0);
        c.b bVarD = ab.c.d(this.f47993a);
        Format format = this.f48003k;
        if (format == null || bVarD.f414c != format.f16712y || bVarD.f413b != format.f16713z || !hd.w.M.equals(format.f16699l)) {
            Format formatE = new Format.b().S(this.f47996d).e0(hd.w.M).H(bVarD.f414c).f0(bVarD.f413b).V(this.f47995c).E();
            this.f48003k = formatE;
            this.f47997e.f(formatE);
        }
        this.f48004l = bVarD.f415d;
        this.f48002j = (((long) bVarD.f416e) * 1000000) / ((long) this.f48003k.f16713z);
    }

    public final boolean h(hd.c0 c0Var) {
        int iG;
        while (true) {
            if (c0Var.a() <= 0) {
                return false;
            }
            if (this.f48000h) {
                iG = c0Var.G();
                this.f48000h = iG == 172;
                if (iG == 64 || iG == 65) {
                    break;
                }
            } else {
                this.f48000h = c0Var.G() == 172;
            }
        }
        this.f48001i = iG == 65;
        return true;
    }

    public f(@p0 String str) {
        hd.b0 b0Var = new hd.b0(new byte[16]);
        this.f47993a = b0Var;
        this.f47994b = new hd.c0(b0Var.f30961a);
        this.f47998f = 0;
        this.f47999g = 0;
        this.f48000h = false;
        this.f48001i = false;
        this.f47995c = str;
    }
}
