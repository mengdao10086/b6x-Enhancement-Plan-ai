package rb;

import ab.b;
import com.google.android.exoplayer2.Format;
import g.p0;
import hd.u0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements m {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f47949m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f47950n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f47951o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f47952p = 128;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.b0 f47953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hd.c0 f47954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f47955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f47956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public hb.d0 f47957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f47958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f47959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f47960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f47961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Format f47962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f47963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f47964l;

    public c() {
        this(null);
    }

    @Override // rb.m
    public void a() {
        this.f47958f = 0;
        this.f47959g = 0;
        this.f47960h = false;
    }

    public final boolean b(hd.c0 c0Var, byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f47959g);
        c0Var.k(bArr, this.f47959g, iMin);
        int i11 = this.f47959g + iMin;
        this.f47959g = i11;
        return i11 == i10;
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) {
        hd.a.k(this.f47957e);
        while (c0Var.a() > 0) {
            int i10 = this.f47958f;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        int iMin = Math.min(c0Var.a(), this.f47963k - this.f47959g);
                        this.f47957e.d(c0Var, iMin);
                        int i11 = this.f47959g + iMin;
                        this.f47959g = i11;
                        int i12 = this.f47963k;
                        if (i11 == i12) {
                            this.f47957e.a(this.f47964l, 1, i12, 0, null);
                            this.f47964l += this.f47961i;
                            this.f47958f = 0;
                        }
                    }
                } else if (b(c0Var, this.f47954b.d(), 128)) {
                    g();
                    this.f47954b.S(0);
                    this.f47957e.d(this.f47954b, 128);
                    this.f47958f = 2;
                }
            } else if (h(c0Var)) {
                this.f47958f = 1;
                this.f47954b.d()[0] = 11;
                this.f47954b.d()[1] = 119;
                this.f47959g = 2;
            }
        }
    }

    @Override // rb.m
    public void d() {
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        eVar.a();
        this.f47956d = eVar.b();
        this.f47957e = mVar.d(eVar.c(), 1);
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        this.f47964l = j10;
    }

    @RequiresNonNull({"output"})
    public final void g() {
        this.f47953a.q(0);
        b.C0011b c0011bE = ab.b.e(this.f47953a);
        Format format = this.f47962j;
        if (format == null || c0011bE.f402d != format.f16712y || c0011bE.f401c != format.f16713z || !u0.c(c0011bE.f399a, format.f16699l)) {
            Format formatE = new Format.b().S(this.f47956d).e0(c0011bE.f399a).H(c0011bE.f402d).f0(c0011bE.f401c).V(this.f47955c).E();
            this.f47962j = formatE;
            this.f47957e.f(formatE);
        }
        this.f47963k = c0011bE.f403e;
        this.f47961i = (((long) c0011bE.f404f) * 1000000) / ((long) this.f47962j.f16713z);
    }

    public final boolean h(hd.c0 c0Var) {
        while (true) {
            if (c0Var.a() <= 0) {
                return false;
            }
            if (this.f47960h) {
                int iG = c0Var.G();
                if (iG == 119) {
                    this.f47960h = false;
                    return true;
                }
                this.f47960h = iG == 11;
            } else {
                this.f47960h = c0Var.G() == 11;
            }
        }
    }

    public c(@p0 String str) {
        hd.b0 b0Var = new hd.b0(new byte[128]);
        this.f47953a = b0Var;
        this.f47954b = new hd.c0(b0Var.f30961a);
        this.f47958f = 0;
        this.f47955c = str;
    }
}
