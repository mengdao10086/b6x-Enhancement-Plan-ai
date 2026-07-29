package rb;

import com.google.android.exoplayer2.ParserException;
import hd.p0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements i0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f48374p = "PesReader";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f48375q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f48376r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f48377s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f48378t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f48379u = 9;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f48380v = 10;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f48381w = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f48382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hd.b0 f48383e = new hd.b0(new byte[10]);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f48384f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f48385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p0 f48386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f48387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f48388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f48389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f48390l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f48391m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f48392n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f48393o;

    public w(m mVar) {
        this.f48382d = mVar;
    }

    @Override // rb.i0
    public final void a() {
        this.f48384f = 0;
        this.f48385g = 0;
        this.f48389k = false;
        this.f48382d.a();
    }

    @Override // rb.i0
    public void b(p0 p0Var, hb.m mVar, i0.e eVar) {
        this.f48386h = p0Var;
        this.f48382d.e(mVar, eVar);
    }

    @Override // rb.i0
    public final void c(hd.c0 c0Var, int i10) throws ParserException {
        hd.a.k(this.f48386h);
        if ((i10 & 1) != 0) {
            int i11 = this.f48384f;
            if (i11 != 0 && i11 != 1) {
                if (i11 == 2) {
                    hd.t.n(f48374p, "Unexpected start indicator reading extended header");
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f48391m != -1) {
                        hd.t.n(f48374p, "Unexpected start indicator: expected " + this.f48391m + " more bytes");
                    }
                    this.f48382d.d();
                }
            }
            g(1);
        }
        while (c0Var.a() > 0) {
            int i12 = this.f48384f;
            if (i12 != 0) {
                if (i12 != 1) {
                    if (i12 == 2) {
                        if (d(c0Var, this.f48383e.f30961a, Math.min(10, this.f48390l)) && d(c0Var, null, this.f48390l)) {
                            f();
                            i10 |= this.f48392n ? 4 : 0;
                            this.f48382d.f(this.f48393o, i10);
                            g(3);
                        }
                    } else {
                        if (i12 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = c0Var.a();
                        int i13 = this.f48391m;
                        int i14 = i13 != -1 ? iA - i13 : 0;
                        if (i14 > 0) {
                            iA -= i14;
                            c0Var.R(c0Var.e() + iA);
                        }
                        this.f48382d.c(c0Var);
                        int i15 = this.f48391m;
                        if (i15 != -1) {
                            int i16 = i15 - iA;
                            this.f48391m = i16;
                            if (i16 == 0) {
                                this.f48382d.d();
                                g(1);
                            }
                        }
                    }
                } else if (d(c0Var, this.f48383e.f30961a, 9)) {
                    g(e() ? 2 : 0);
                }
            } else {
                c0Var.T(c0Var.a());
            }
        }
    }

    public final boolean d(hd.c0 c0Var, @g.p0 byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f48385g);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            c0Var.T(iMin);
        } else {
            c0Var.k(bArr, this.f48385g, iMin);
        }
        int i11 = this.f48385g + iMin;
        this.f48385g = i11;
        return i11 == i10;
    }

    public final boolean e() {
        this.f48383e.q(0);
        int iH = this.f48383e.h(24);
        if (iH != 1) {
            hd.t.n(f48374p, "Unexpected start code prefix: " + iH);
            this.f48391m = -1;
            return false;
        }
        this.f48383e.s(8);
        int iH2 = this.f48383e.h(16);
        this.f48383e.s(5);
        this.f48392n = this.f48383e.g();
        this.f48383e.s(2);
        this.f48387i = this.f48383e.g();
        this.f48388j = this.f48383e.g();
        this.f48383e.s(6);
        int iH3 = this.f48383e.h(8);
        this.f48390l = iH3;
        if (iH2 == 0) {
            this.f48391m = -1;
        } else {
            int i10 = ((iH2 + 6) - 9) - iH3;
            this.f48391m = i10;
            if (i10 < 0) {
                hd.t.n(f48374p, "Found negative packet payload size: " + this.f48391m);
                this.f48391m = -1;
            }
        }
        return true;
    }

    @RequiresNonNull({"timestampAdjuster"})
    public final void f() {
        this.f48383e.q(0);
        this.f48393o = ya.g.f56663b;
        if (this.f48387i) {
            this.f48383e.s(4);
            long jH = ((long) this.f48383e.h(3)) << 30;
            this.f48383e.s(1);
            long jH2 = jH | ((long) (this.f48383e.h(15) << 15));
            this.f48383e.s(1);
            long jH3 = jH2 | ((long) this.f48383e.h(15));
            this.f48383e.s(1);
            if (!this.f48389k && this.f48388j) {
                this.f48383e.s(4);
                long jH4 = ((long) this.f48383e.h(3)) << 30;
                this.f48383e.s(1);
                long jH5 = jH4 | ((long) (this.f48383e.h(15) << 15));
                this.f48383e.s(1);
                long jH6 = jH5 | ((long) this.f48383e.h(15));
                this.f48383e.s(1);
                this.f48386h.b(jH6);
                this.f48389k = true;
            }
            this.f48393o = this.f48386h.b(jH3);
        }
    }

    public final void g(int i10) {
        this.f48384f = i10;
        this.f48385g = 0;
    }
}
