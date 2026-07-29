package w;

/* JADX INFO: loaded from: classes2.dex */
public class s implements r {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f53575p = 1.0E-5f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f53576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f53577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f53578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f53579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f53580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f53581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f53582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f53583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f53584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f53585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f53586k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f53588m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f53589n;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f53587l = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f53590o = false;

    @Override // w.r
    public float a() {
        return this.f53587l ? -c(this.f53589n) : c(this.f53589n);
    }

    @Override // w.r
    public String b(String str, float f10) {
        String str2 = str + " ===== " + this.f53586k + "\n";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        sb2.append(this.f53587l ? "backwards" : "forward ");
        sb2.append(" time = ");
        sb2.append(f10);
        sb2.append("  stages ");
        sb2.append(this.f53585j);
        sb2.append("\n");
        String str3 = sb2.toString() + str + " dur " + this.f53579d + " vel " + this.f53576a + " pos " + this.f53582g + "\n";
        if (this.f53585j > 1) {
            str3 = str3 + str + " dur " + this.f53580e + " vel " + this.f53577b + " pos " + this.f53583h + "\n";
        }
        if (this.f53585j > 2) {
            str3 = str3 + str + " dur " + this.f53581f + " vel " + this.f53578c + " pos " + this.f53584i + "\n";
        }
        float f11 = this.f53579d;
        if (f10 <= f11) {
            return str3 + str + "stage 0\n";
        }
        int i10 = this.f53585j;
        if (i10 == 1) {
            return str3 + str + "end stage 0\n";
        }
        float f12 = f10 - f11;
        float f13 = this.f53580e;
        if (f12 < f13) {
            return str3 + str + " stage 1\n";
        }
        if (i10 == 2) {
            return str3 + str + "end stage 1\n";
        }
        if (f12 - f13 < this.f53581f) {
            return str3 + str + " stage 2\n";
        }
        return str3 + str + " end stage 2\n";
    }

    @Override // w.r
    public float c(float f10) {
        float f11 = this.f53579d;
        if (f10 <= f11) {
            float f12 = this.f53576a;
            return f12 + (((this.f53577b - f12) * f10) / f11);
        }
        int i10 = this.f53585j;
        if (i10 == 1) {
            return 0.0f;
        }
        float f13 = f10 - f11;
        float f14 = this.f53580e;
        if (f13 < f14) {
            float f15 = this.f53577b;
            return f15 + (((this.f53578c - f15) * f13) / f14);
        }
        if (i10 == 2) {
            return this.f53583h;
        }
        float f16 = f13 - f14;
        float f17 = this.f53581f;
        if (f16 >= f17) {
            return this.f53584i;
        }
        float f18 = this.f53578c;
        return f18 - ((f16 * f18) / f17);
    }

    @Override // w.r
    public boolean d() {
        return a() < 1.0E-5f && Math.abs(this.f53584i - this.f53589n) < 1.0E-5f;
    }

    public final float e(float f10) {
        this.f53590o = false;
        float f11 = this.f53579d;
        if (f10 <= f11) {
            float f12 = this.f53576a;
            return (f12 * f10) + ((((this.f53577b - f12) * f10) * f10) / (f11 * 2.0f));
        }
        int i10 = this.f53585j;
        if (i10 == 1) {
            return this.f53582g;
        }
        float f13 = f10 - f11;
        float f14 = this.f53580e;
        if (f13 < f14) {
            float f15 = this.f53582g;
            float f16 = this.f53577b;
            return f15 + (f16 * f13) + ((((this.f53578c - f16) * f13) * f13) / (f14 * 2.0f));
        }
        if (i10 == 2) {
            return this.f53583h;
        }
        float f17 = f13 - f14;
        float f18 = this.f53581f;
        if (f17 > f18) {
            this.f53590o = true;
            return this.f53584i;
        }
        float f19 = this.f53583h;
        float f20 = this.f53578c;
        return (f19 + (f20 * f17)) - (((f20 * f17) * f17) / (f18 * 2.0f));
    }

    public void f(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f53590o = false;
        this.f53588m = f10;
        boolean z10 = f10 > f11;
        this.f53587l = z10;
        if (z10) {
            g(-f12, f10 - f11, f14, f15, f13);
        } else {
            g(f12, f11 - f10, f14, f15, f13);
        }
    }

    public final void g(float f10, float f11, float f12, float f13, float f14) {
        this.f53590o = false;
        if (f10 == 0.0f) {
            f10 = 1.0E-4f;
        }
        this.f53576a = f10;
        float f15 = f10 / f12;
        float f16 = (f15 * f10) / 2.0f;
        if (f10 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f11 - ((((-f10) / f12) * f10) / 2.0f)) * f12);
            if (fSqrt < f13) {
                this.f53586k = "backward accelerate, decelerate";
                this.f53585j = 2;
                this.f53576a = f10;
                this.f53577b = fSqrt;
                this.f53578c = 0.0f;
                float f17 = (fSqrt - f10) / f12;
                this.f53579d = f17;
                this.f53580e = fSqrt / f12;
                this.f53582g = ((f10 + fSqrt) * f17) / 2.0f;
                this.f53583h = f11;
                this.f53584i = f11;
                return;
            }
            this.f53586k = "backward accelerate cruse decelerate";
            this.f53585j = 3;
            this.f53576a = f10;
            this.f53577b = f13;
            this.f53578c = f13;
            float f18 = (f13 - f10) / f12;
            this.f53579d = f18;
            float f19 = f13 / f12;
            this.f53581f = f19;
            float f20 = ((f10 + f13) * f18) / 2.0f;
            float f21 = (f19 * f13) / 2.0f;
            this.f53580e = ((f11 - f20) - f21) / f13;
            this.f53582g = f20;
            this.f53583h = f11 - f21;
            this.f53584i = f11;
            return;
        }
        if (f16 >= f11) {
            this.f53586k = "hard stop";
            this.f53585j = 1;
            this.f53576a = f10;
            this.f53577b = 0.0f;
            this.f53582g = f11;
            this.f53579d = (2.0f * f11) / f10;
            return;
        }
        float f22 = f11 - f16;
        float f23 = f22 / f10;
        if (f23 + f15 < f14) {
            this.f53586k = "cruse decelerate";
            this.f53585j = 2;
            this.f53576a = f10;
            this.f53577b = f10;
            this.f53578c = 0.0f;
            this.f53582g = f22;
            this.f53583h = f11;
            this.f53579d = f23;
            this.f53580e = f15;
            return;
        }
        float fSqrt2 = (float) Math.sqrt((f12 * f11) + ((f10 * f10) / 2.0f));
        float f24 = (fSqrt2 - f10) / f12;
        this.f53579d = f24;
        float f25 = fSqrt2 / f12;
        this.f53580e = f25;
        if (fSqrt2 < f13) {
            this.f53586k = "accelerate decelerate";
            this.f53585j = 2;
            this.f53576a = f10;
            this.f53577b = fSqrt2;
            this.f53578c = 0.0f;
            this.f53579d = f24;
            this.f53580e = f25;
            this.f53582g = ((f10 + fSqrt2) * f24) / 2.0f;
            this.f53583h = f11;
            return;
        }
        this.f53586k = "accelerate cruse decelerate";
        this.f53585j = 3;
        this.f53576a = f10;
        this.f53577b = f13;
        this.f53578c = f13;
        float f26 = (f13 - f10) / f12;
        this.f53579d = f26;
        float f27 = f13 / f12;
        this.f53581f = f27;
        float f28 = ((f10 + f13) * f26) / 2.0f;
        float f29 = (f27 * f13) / 2.0f;
        this.f53580e = ((f11 - f28) - f29) / f13;
        this.f53582g = f28;
        this.f53583h = f11 - f29;
        this.f53584i = f11;
    }

    @Override // w.r
    public float getInterpolation(float f10) {
        float fE = e(f10);
        this.f53589n = f10;
        return this.f53587l ? this.f53588m - fE : this.f53588m + fE;
    }
}
