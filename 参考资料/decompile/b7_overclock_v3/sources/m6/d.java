package m6;

import com.flydigi.cyberfox.h1.models.equalizer.parameters.ParameterType;

/* JADX INFO: loaded from: classes7.dex */
public abstract class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f40690h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f40691i = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ParameterType f40695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f40696e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f40692a = new int[2];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f40693b = new String[2];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f40694c = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f40698g = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f40697f = b();

    public d(ParameterType parameterType) {
        this.f40695d = parameterType;
    }

    public int a() {
        int[] iArr = this.f40692a;
        return iArr[1] - iArr[0];
    }

    public abstract int b();

    public abstract String c(double d10);

    public String d() {
        return this.f40698g ? this.f40693b[1] : "";
    }

    public String e() {
        return this.f40698g ? this.f40693b[0] : "";
    }

    public String f() {
        return c(((double) this.f40696e) / ((double) this.f40697f));
    }

    public int g() {
        return this.f40692a[1];
    }

    public int h() {
        return this.f40692a[0];
    }

    public ParameterType i() {
        return this.f40695d;
    }

    public int j() {
        return this.f40696e - this.f40692a[0];
    }

    public int k() {
        return this.f40696e;
    }

    public void l() {
        this.f40694c = false;
    }

    public boolean m() {
        return this.f40698g;
    }

    public boolean n() {
        return this.f40694c;
    }

    public final void o(int i10, double d10) {
        this.f40693b[i10] = c(d10);
        this.f40692a[i10] = (int) (d10 * ((double) this.f40697f));
    }

    public void p(double d10, double d11) {
        this.f40698g = true;
        o(0, d10);
        o(1, d11);
    }

    public void q() {
        this.f40698g = false;
    }

    public void r(int i10) {
        this.f40694c = true;
        this.f40696e = i10;
    }

    public void s(int i10) {
        this.f40696e = i10 + this.f40692a[0];
    }
}
