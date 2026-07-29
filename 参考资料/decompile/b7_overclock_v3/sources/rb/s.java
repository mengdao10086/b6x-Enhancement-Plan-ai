package rb;

import ab.a;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import g.p0;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements m {
    public static final int A = 86;
    public static final int B = 224;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f48324v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f48325w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f48326x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f48327y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f48328z = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final String f48329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hd.c0 f48330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hd.b0 f48331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public hb.d0 f48332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f48333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Format f48334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f48335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f48336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f48337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f48338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f48339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f48340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f48341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f48342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f48343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f48344p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f48345q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f48346r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f48347s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f48348t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public String f48349u;

    public s(@p0 String str) {
        this.f48329a = str;
        hd.c0 c0Var = new hd.c0(1024);
        this.f48330b = c0Var;
        this.f48331c = new hd.b0(c0Var.d());
    }

    public static long b(hd.b0 b0Var) {
        return b0Var.h((b0Var.h(2) + 1) * 8);
    }

    @Override // rb.m
    public void a() {
        this.f48335g = 0;
        this.f48340l = false;
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) throws ParserException {
        hd.a.k(this.f48332d);
        while (c0Var.a() > 0) {
            int i10 = this.f48335g;
            if (i10 != 0) {
                if (i10 == 1) {
                    int iG = c0Var.G();
                    if ((iG & 224) == 224) {
                        this.f48338j = iG;
                        this.f48335g = 2;
                    } else if (iG != 86) {
                        this.f48335g = 0;
                    }
                } else if (i10 == 2) {
                    int iG2 = ((this.f48338j & (-225)) << 8) | c0Var.G();
                    this.f48337i = iG2;
                    if (iG2 > this.f48330b.d().length) {
                        m(this.f48337i);
                    }
                    this.f48336h = 0;
                    this.f48335g = 3;
                } else {
                    if (i10 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(c0Var.a(), this.f48337i - this.f48336h);
                    c0Var.k(this.f48331c.f30961a, this.f48336h, iMin);
                    int i11 = this.f48336h + iMin;
                    this.f48336h = i11;
                    if (i11 == this.f48337i) {
                        this.f48331c.q(0);
                        g(this.f48331c);
                        this.f48335g = 0;
                    }
                }
            } else if (c0Var.G() == 86) {
                this.f48335g = 1;
            }
        }
    }

    @Override // rb.m
    public void d() {
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        eVar.a();
        this.f48332d = mVar.d(eVar.c(), 1);
        this.f48333e = eVar.b();
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        this.f48339k = j10;
    }

    @RequiresNonNull({"output"})
    public final void g(hd.b0 b0Var) throws ParserException {
        if (!b0Var.g()) {
            this.f48340l = true;
            l(b0Var);
        } else if (!this.f48340l) {
            return;
        }
        if (this.f48341m != 0) {
            throw new ParserException();
        }
        if (this.f48342n != 0) {
            throw new ParserException();
        }
        k(b0Var, j(b0Var));
        if (this.f48344p) {
            b0Var.s((int) this.f48345q);
        }
    }

    public final int h(hd.b0 b0Var) throws ParserException {
        int iB = b0Var.b();
        a.c cVarF = ab.a.f(b0Var, true);
        this.f48349u = cVarF.f371c;
        this.f48346r = cVarF.f369a;
        this.f48348t = cVarF.f370b;
        return iB - b0Var.b();
    }

    public final void i(hd.b0 b0Var) {
        int iH = b0Var.h(3);
        this.f48343o = iH;
        if (iH == 0) {
            b0Var.s(8);
            return;
        }
        if (iH == 1) {
            b0Var.s(9);
            return;
        }
        if (iH == 3 || iH == 4 || iH == 5) {
            b0Var.s(6);
        } else {
            if (iH != 6 && iH != 7) {
                throw new IllegalStateException();
            }
            b0Var.s(1);
        }
    }

    public final int j(hd.b0 b0Var) throws ParserException {
        int iH;
        if (this.f48343o != 0) {
            throw new ParserException();
        }
        int i10 = 0;
        do {
            iH = b0Var.h(8);
            i10 += iH;
        } while (iH == 255);
        return i10;
    }

    @RequiresNonNull({"output"})
    public final void k(hd.b0 b0Var, int i10) {
        int iE = b0Var.e();
        if ((iE & 7) == 0) {
            this.f48330b.S(iE >> 3);
        } else {
            b0Var.i(this.f48330b.d(), 0, i10 * 8);
            this.f48330b.S(0);
        }
        this.f48332d.d(this.f48330b, i10);
        this.f48332d.a(this.f48339k, 1, i10, 0, null);
        this.f48339k += this.f48347s;
    }

    @RequiresNonNull({"output"})
    public final void l(hd.b0 b0Var) throws ParserException {
        boolean zG;
        int iH = b0Var.h(1);
        int iH2 = iH == 1 ? b0Var.h(1) : 0;
        this.f48341m = iH2;
        if (iH2 != 0) {
            throw new ParserException();
        }
        if (iH == 1) {
            b(b0Var);
        }
        if (!b0Var.g()) {
            throw new ParserException();
        }
        this.f48342n = b0Var.h(6);
        int iH3 = b0Var.h(4);
        int iH4 = b0Var.h(3);
        if (iH3 != 0 || iH4 != 0) {
            throw new ParserException();
        }
        if (iH == 0) {
            int iE = b0Var.e();
            int iH5 = h(b0Var);
            b0Var.q(iE);
            byte[] bArr = new byte[(iH5 + 7) / 8];
            b0Var.i(bArr, 0, iH5);
            Format formatE = new Format.b().S(this.f48333e).e0(hd.w.A).I(this.f48349u).H(this.f48348t).f0(this.f48346r).T(Collections.singletonList(bArr)).V(this.f48329a).E();
            if (!formatE.equals(this.f48334f)) {
                this.f48334f = formatE;
                this.f48347s = 1024000000 / ((long) formatE.f16713z);
                this.f48332d.f(formatE);
            }
        } else {
            b0Var.s(((int) b(b0Var)) - h(b0Var));
        }
        i(b0Var);
        boolean zG2 = b0Var.g();
        this.f48344p = zG2;
        this.f48345q = 0L;
        if (zG2) {
            if (iH == 1) {
                this.f48345q = b(b0Var);
            } else {
                do {
                    zG = b0Var.g();
                    this.f48345q = (this.f48345q << 8) + ((long) b0Var.h(8));
                } while (zG);
            }
        }
        if (b0Var.g()) {
            b0Var.s(8);
        }
    }

    public final void m(int i10) {
        this.f48330b.O(i10);
        this.f48331c.o(this.f48330b.d());
    }
}
