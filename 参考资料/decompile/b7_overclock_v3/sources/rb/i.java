package rb;

import ab.a;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import g.p0;
import hd.u0;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements m {
    public static final int A = 4;
    public static final int B = 5;
    public static final int C = 2;
    public static final int D = 8;
    public static final int E = 256;
    public static final int F = 512;
    public static final int G = 768;
    public static final int H = 1024;
    public static final int I = 10;
    public static final int J = 6;
    public static final byte[] K = {73, 68, 51};
    public static final int L = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f48075v = "AdtsReader";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f48076w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f48077x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f48078y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f48079z = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f48080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hd.b0 f48081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hd.c0 f48082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final String f48083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f48084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public hb.d0 f48085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public hb.d0 f48086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f48087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f48088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f48089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f48090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f48091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f48092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f48093n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f48094o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f48095p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f48096q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f48097r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f48098s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public hb.d0 f48099t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f48100u;

    public i(boolean z10) {
        this(z10, null);
    }

    public static boolean m(int i10) {
        return (i10 & 65526) == 65520;
    }

    @Override // rb.m
    public void a() {
        q();
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    public final void b() {
        hd.a.g(this.f48085f);
        u0.k(this.f48099t);
        u0.k(this.f48086g);
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) throws ParserException {
        b();
        while (c0Var.a() > 0) {
            int i10 = this.f48087h;
            if (i10 == 0) {
                j(c0Var);
            } else if (i10 == 1) {
                g(c0Var);
            } else if (i10 != 2) {
                if (i10 == 3) {
                    if (i(c0Var, this.f48081b.f30961a, this.f48090k ? 7 : 5)) {
                        n();
                    }
                } else {
                    if (i10 != 4) {
                        throw new IllegalStateException();
                    }
                    p(c0Var);
                }
            } else if (i(c0Var, this.f48082c.d(), 10)) {
                o();
            }
        }
    }

    @Override // rb.m
    public void d() {
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        eVar.a();
        this.f48084e = eVar.b();
        hb.d0 d0VarD = mVar.d(eVar.c(), 1);
        this.f48085f = d0VarD;
        this.f48099t = d0VarD;
        if (!this.f48080a) {
            this.f48086g = new hb.j();
            return;
        }
        eVar.a();
        hb.d0 d0VarD2 = mVar.d(eVar.c(), 5);
        this.f48086g = d0VarD2;
        d0VarD2.f(new Format.b().S(eVar.b()).e0(hd.w.f31193k0).E());
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        this.f48098s = j10;
    }

    public final void g(hd.c0 c0Var) {
        if (c0Var.a() == 0) {
            return;
        }
        this.f48081b.f30961a[0] = c0Var.d()[c0Var.e()];
        this.f48081b.q(2);
        int iH = this.f48081b.h(4);
        int i10 = this.f48093n;
        if (i10 != -1 && iH != i10) {
            q();
            return;
        }
        if (!this.f48091l) {
            this.f48091l = true;
            this.f48092m = this.f48094o;
            this.f48093n = iH;
        }
        t();
    }

    public final boolean h(hd.c0 c0Var, int i10) {
        c0Var.S(i10 + 1);
        if (!w(c0Var, this.f48081b.f30961a, 1)) {
            return false;
        }
        this.f48081b.q(4);
        int iH = this.f48081b.h(1);
        int i11 = this.f48092m;
        if (i11 != -1 && iH != i11) {
            return false;
        }
        if (this.f48093n != -1) {
            if (!w(c0Var, this.f48081b.f30961a, 1)) {
                return true;
            }
            this.f48081b.q(2);
            if (this.f48081b.h(4) != this.f48093n) {
                return false;
            }
            c0Var.S(i10 + 2);
        }
        if (!w(c0Var, this.f48081b.f30961a, 4)) {
            return true;
        }
        this.f48081b.q(14);
        int iH2 = this.f48081b.h(13);
        if (iH2 < 7) {
            return false;
        }
        byte[] bArrD = c0Var.d();
        int iF = c0Var.f();
        int i12 = i10 + iH2;
        if (i12 >= iF) {
            return true;
        }
        if (bArrD[i12] == -1) {
            int i13 = i12 + 1;
            if (i13 == iF) {
                return true;
            }
            return l((byte) -1, bArrD[i13]) && ((bArrD[i13] & 8) >> 3) == iH;
        }
        if (bArrD[i12] != 73) {
            return false;
        }
        int i14 = i12 + 1;
        if (i14 == iF) {
            return true;
        }
        if (bArrD[i14] != 68) {
            return false;
        }
        int i15 = i12 + 2;
        return i15 == iF || bArrD[i15] == 51;
    }

    public final boolean i(hd.c0 c0Var, byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f48088i);
        c0Var.k(bArr, this.f48088i, iMin);
        int i11 = this.f48088i + iMin;
        this.f48088i = i11;
        return i11 == i10;
    }

    public final void j(hd.c0 c0Var) {
        byte[] bArrD = c0Var.d();
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF) {
            int i10 = iE + 1;
            int i11 = bArrD[iE] & 255;
            if (this.f48089j == 512 && l((byte) -1, (byte) i11) && (this.f48091l || h(c0Var, i10 - 2))) {
                this.f48094o = (i11 & 8) >> 3;
                this.f48090k = (i11 & 1) == 0;
                if (this.f48091l) {
                    t();
                } else {
                    r();
                }
                c0Var.S(i10);
                return;
            }
            int i12 = this.f48089j;
            int i13 = i11 | i12;
            if (i13 == 329) {
                this.f48089j = 768;
            } else if (i13 == 511) {
                this.f48089j = 512;
            } else if (i13 == 836) {
                this.f48089j = 1024;
            } else if (i13 == 1075) {
                u();
                c0Var.S(i10);
                return;
            } else if (i12 != 256) {
                this.f48089j = 256;
                i10--;
            }
            iE = i10;
        }
        c0Var.S(iE);
    }

    public long k() {
        return this.f48096q;
    }

    public final boolean l(byte b10, byte b11) {
        return m(((b10 & 255) << 8) | (b11 & 255));
    }

    @RequiresNonNull({"output"})
    public final void n() throws ParserException {
        this.f48081b.q(0);
        if (this.f48095p) {
            this.f48081b.s(10);
        } else {
            int iH = this.f48081b.h(2) + 1;
            if (iH != 2) {
                hd.t.n(f48075v, "Detected audio object type: " + iH + ", but assuming AAC LC.");
                iH = 2;
            }
            this.f48081b.s(5);
            byte[] bArrB = ab.a.b(iH, this.f48093n, this.f48081b.h(3));
            a.c cVarG = ab.a.g(bArrB);
            Format formatE = new Format.b().S(this.f48084e).e0(hd.w.A).I(cVarG.f371c).H(cVarG.f370b).f0(cVarG.f369a).T(Collections.singletonList(bArrB)).V(this.f48083d).E();
            this.f48096q = 1024000000 / ((long) formatE.f16713z);
            this.f48085f.f(formatE);
            this.f48095p = true;
        }
        this.f48081b.s(4);
        int iH2 = (this.f48081b.h(13) - 2) - 5;
        if (this.f48090k) {
            iH2 -= 2;
        }
        v(this.f48085f, this.f48096q, 0, iH2);
    }

    @RequiresNonNull({"id3Output"})
    public final void o() {
        this.f48086g.d(this.f48082c, 10);
        this.f48082c.S(6);
        v(this.f48086g, 0L, 10, this.f48082c.F() + 10);
    }

    @RequiresNonNull({"currentOutput"})
    public final void p(hd.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), this.f48097r - this.f48088i);
        this.f48099t.d(c0Var, iMin);
        int i10 = this.f48088i + iMin;
        this.f48088i = i10;
        int i11 = this.f48097r;
        if (i10 == i11) {
            this.f48099t.a(this.f48098s, 1, i11, 0, null);
            this.f48098s += this.f48100u;
            s();
        }
    }

    public final void q() {
        this.f48091l = false;
        s();
    }

    public final void r() {
        this.f48087h = 1;
        this.f48088i = 0;
    }

    public final void s() {
        this.f48087h = 0;
        this.f48088i = 0;
        this.f48089j = 256;
    }

    public final void t() {
        this.f48087h = 3;
        this.f48088i = 0;
    }

    public final void u() {
        this.f48087h = 2;
        this.f48088i = K.length;
        this.f48097r = 0;
        this.f48082c.S(0);
    }

    public final void v(hb.d0 d0Var, long j10, int i10, int i11) {
        this.f48087h = 4;
        this.f48088i = i10;
        this.f48099t = d0Var;
        this.f48100u = j10;
        this.f48097r = i11;
    }

    public final boolean w(hd.c0 c0Var, byte[] bArr, int i10) {
        if (c0Var.a() < i10) {
            return false;
        }
        c0Var.k(bArr, 0, i10);
        return true;
    }

    public i(boolean z10, @p0 String str) {
        this.f48081b = new hd.b0(new byte[7]);
        this.f48082c = new hd.c0(Arrays.copyOf(K, 10));
        s();
        this.f48092m = -1;
        this.f48093n = -1;
        this.f48096q = ya.g.f56663b;
        this.f48080a = z10;
        this.f48083d = str;
    }
}
