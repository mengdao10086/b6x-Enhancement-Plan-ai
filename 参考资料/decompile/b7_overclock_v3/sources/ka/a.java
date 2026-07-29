package ka;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.LimitLine;
import java.util.ArrayList;
import java.util.List;
import na.l;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f37087g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f37094n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f37095o;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<LimitLine> f37106z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f37088h = -7829368;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f37089i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f37090j = -7829368;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f37091k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f37092l = new float[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float[] f37093m = new float[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f37096p = 6;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f37097q = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f37098r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f37099s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f37100t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f37101u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f37102v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f37103w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public DashPathEffect f37104x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public DashPathEffect f37105y = null;
    public boolean A = false;
    public boolean B = true;
    public float C = 0.0f;
    public float D = 0.0f;
    public boolean E = false;
    public boolean F = false;
    public float G = 0.0f;
    public float H = 0.0f;
    public float I = 0.0f;

    public a() {
        this.f37111e = k.e(10.0f);
        this.f37108b = k.e(5.0f);
        this.f37109c = k.e(5.0f);
        this.f37106z = new ArrayList();
    }

    public DashPathEffect A() {
        return this.f37105y;
    }

    public float B() {
        return this.f37089i;
    }

    public int C() {
        return this.f37096p;
    }

    public List<LimitLine> D() {
        return this.f37106z;
    }

    public String E() {
        String str = "";
        for (int i10 = 0; i10 < this.f37092l.length; i10++) {
            String strX = x(i10);
            if (strX != null && str.length() < strX.length()) {
                str = strX;
            }
        }
        return str;
    }

    public float F() {
        return this.D;
    }

    public float G() {
        return this.C;
    }

    public l H() {
        l lVar = this.f37087g;
        if (lVar == null || ((lVar instanceof na.b) && ((na.b) lVar).l() != this.f37095o)) {
            this.f37087g = new na.b(this.f37095o);
        }
        return this.f37087g;
    }

    public boolean I() {
        return this.f37104x != null;
    }

    public boolean J() {
        return this.F;
    }

    public boolean K() {
        return this.E;
    }

    public boolean L() {
        return this.f37103w && this.f37094n > 0;
    }

    public boolean M() {
        return this.f37101u;
    }

    public boolean N() {
        return this.B;
    }

    public boolean O() {
        return this.f37100t;
    }

    public boolean P() {
        return this.f37102v;
    }

    public boolean Q() {
        return this.A;
    }

    public boolean R() {
        return this.f37099s;
    }

    public boolean S() {
        return this.f37098r;
    }

    public boolean T() {
        return this.f37105y != null;
    }

    public void U() {
        this.f37106z.clear();
    }

    public void V(LimitLine limitLine) {
        this.f37106z.remove(limitLine);
    }

    public void W() {
        this.F = false;
    }

    public void X() {
        this.E = false;
    }

    public void Y(int i10) {
        this.f37090j = i10;
    }

    public void Z(DashPathEffect dashPathEffect) {
        this.f37104x = dashPathEffect;
    }

    public void a0(float f10) {
        this.f37091k = k.e(f10);
    }

    @Deprecated
    public void b0(float f10) {
        c0(f10);
    }

    public void c0(float f10) {
        this.F = true;
        this.G = f10;
        this.I = Math.abs(f10 - this.H);
    }

    @Deprecated
    public void d0(float f10) {
        e0(f10);
    }

    public void e0(float f10) {
        this.E = true;
        this.H = f10;
        this.I = Math.abs(this.G - f10);
    }

    public void f0(boolean z10) {
        this.f37103w = z10;
    }

    public void g0(boolean z10) {
        this.f37101u = z10;
    }

    public void h0(boolean z10) {
        this.f37100t = z10;
    }

    public void i0(boolean z10) {
        this.B = z10;
    }

    public void j0(boolean z10) {
        this.f37102v = z10;
    }

    public void k0(boolean z10) {
        this.A = z10;
    }

    public void l0(float f10) {
        this.f37097q = f10;
        this.f37098r = true;
    }

    public void m(LimitLine limitLine) {
        this.f37106z.add(limitLine);
        this.f37106z.size();
    }

    public void m0(boolean z10) {
        this.f37098r = z10;
    }

    public void n(float f10, float f11) {
        float f12 = this.E ? this.H : f10 - this.C;
        float f13 = this.F ? this.G : f11 + this.D;
        if (Math.abs(f13 - f12) == 0.0f) {
            f13 += 1.0f;
            f12 -= 1.0f;
        }
        this.H = f12;
        this.G = f13;
        this.I = Math.abs(f13 - f12);
    }

    public void n0(int i10) {
        this.f37088h = i10;
    }

    public void o() {
        this.f37104x = null;
    }

    public void o0(DashPathEffect dashPathEffect) {
        this.f37105y = dashPathEffect;
    }

    public void p() {
        this.f37105y = null;
    }

    public void p0(float f10) {
        this.f37089i = k.e(f10);
    }

    public void q(float f10, float f11, float f12) {
        this.f37104x = new DashPathEffect(new float[]{f10, f11}, f12);
    }

    public void q0(int i10) {
        if (i10 > 25) {
            i10 = 25;
        }
        if (i10 < 2) {
            i10 = 2;
        }
        this.f37096p = i10;
        this.f37099s = false;
    }

    public void r(float f10, float f11, float f12) {
        this.f37105y = new DashPathEffect(new float[]{f10, f11}, f12);
    }

    public void r0(int i10, boolean z10) {
        q0(i10);
        this.f37099s = z10;
    }

    public int s() {
        return this.f37090j;
    }

    public void s0(float f10) {
        this.D = f10;
    }

    public DashPathEffect t() {
        return this.f37104x;
    }

    public void t0(float f10) {
        this.C = f10;
    }

    public float u() {
        return this.f37091k;
    }

    public void u0(l lVar) {
        if (lVar == null) {
            this.f37087g = new na.b(this.f37095o);
        } else {
            this.f37087g = lVar;
        }
    }

    public float v() {
        return this.G;
    }

    public float w() {
        return this.H;
    }

    public String x(int i10) {
        return (i10 < 0 || i10 >= this.f37092l.length) ? "" : H().c(this.f37092l[i10], this);
    }

    public float y() {
        return this.f37097q;
    }

    public int z() {
        return this.f37088h;
    }
}
