package w;

/* JADX INFO: loaded from: classes2.dex */
public class p implements r {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final double f53561l = Double.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f53564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f53565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f53566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f53567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f53568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f53569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f53570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f53571j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f53562a = 0.5d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f53563b = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f53572k = 0;

    @Override // w.r
    public float a() {
        return 0.0f;
    }

    @Override // w.r
    public String b(String str, float f10) {
        return null;
    }

    @Override // w.r
    public float c(float f10) {
        return this.f53569h;
    }

    @Override // w.r
    public boolean d() {
        double d10 = ((double) this.f53568g) - this.f53565d;
        double d11 = this.f53564c;
        double d12 = this.f53569h;
        return Math.sqrt((((d12 * d12) * ((double) this.f53570i)) + ((d11 * d10) * d10)) / d11) <= ((double) this.f53571j);
    }

    public final void e(double d10) {
        double d11 = this.f53564c;
        double d12 = this.f53562a;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d11 / ((double) this.f53570i)) * d10) * 4.0d)) + 1.0d);
        double d13 = d10 / ((double) iSqrt);
        int i10 = 0;
        while (i10 < iSqrt) {
            float f10 = this.f53568g;
            double d14 = this.f53565d;
            float f11 = this.f53569h;
            double d15 = d11;
            double d16 = ((-d11) * (((double) f10) - d14)) - (((double) f11) * d12);
            float f12 = this.f53570i;
            double d17 = d12;
            double d18 = ((double) f11) + (((d16 / ((double) f12)) * d13) / 2.0d);
            double d19 = ((((-((((double) f10) + ((d13 * d18) / 2.0d)) - d14)) * d15) - (d18 * d17)) / ((double) f12)) * d13;
            float f13 = (float) (((double) f11) + d19);
            this.f53569h = f13;
            float f14 = (float) (((double) f10) + ((((double) f11) + (d19 / 2.0d)) * d13));
            this.f53568g = f14;
            int i11 = this.f53572k;
            if (i11 > 0) {
                if (f14 < 0.0f && (i11 & 1) == 1) {
                    this.f53568g = -f14;
                    this.f53569h = -f13;
                }
                float f15 = this.f53568g;
                if (f15 > 1.0f && (i11 & 2) == 2) {
                    this.f53568g = 2.0f - f15;
                    this.f53569h = -this.f53569h;
                }
            }
            i10++;
            d11 = d15;
            d12 = d17;
        }
    }

    public float f() {
        double d10 = this.f53564c;
        return ((float) (((-d10) * (((double) this.f53568g) - this.f53565d)) - (this.f53562a * ((double) this.f53569h)))) / this.f53570i;
    }

    public void g(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }

    @Override // w.r
    public float getInterpolation(float f10) {
        e(f10 - this.f53567f);
        this.f53567f = f10;
        return this.f53568g;
    }

    public void h(float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i10) {
        this.f53565d = f11;
        this.f53562a = f15;
        this.f53563b = false;
        this.f53568g = f10;
        this.f53566e = f12;
        this.f53564c = f14;
        this.f53570i = f13;
        this.f53571j = f16;
        this.f53572k = i10;
        this.f53567f = 0.0f;
    }
}
