package nj;

/* JADX INFO: loaded from: classes5.dex */
public class a implements e {
    @Override // nj.e
    public double a(double d10, double d11, double d12, double d13) {
        return e(d10, d11, d12, d13, 0.9d);
    }

    @Override // nj.e
    public double b(double d10, double d11, double d12, double d13) {
        return f(d10, d11, d12, d13, 0.0d);
    }

    @Override // nj.e
    public double c(double d10, double d11, double d12, double d13) {
        return d(d10, d11, d12, d13, 0.0d);
    }

    public double d(double d10, double d11, double d12, double d13, double d14) {
        if (d14 == 0.0d) {
            d14 = 1.70158d;
        }
        double d15 = d10 / d13;
        return (d12 * d15 * d15 * (((1.0d + d14) * d15) - d14)) + d11;
    }

    public double e(double d10, double d11, double d12, double d13, double d14) {
        double d15 = d14 == 0.0d ? 1.70158d : d14;
        double d16 = d10 / (d13 / 2.0d);
        if (d16 < 1.0d) {
            double d17 = d15 * 1.525d;
            return ((d12 / 2.0d) * d16 * d16 * (((1.0d + d17) * d16) - d17)) + d11;
        }
        double d18 = d16 - 2.0d;
        double d19 = d15 * 1.525d;
        return ((d12 / 2.0d) * ((d18 * d18 * (((1.0d + d19) * d18) + d19)) + 2.0d)) + d11;
    }

    public double f(double d10, double d11, double d12, double d13, double d14) {
        if (d14 == 0.0d) {
            d14 = 1.70158d;
        }
        double d15 = (d10 / d13) - 1.0d;
        return (d12 * ((d15 * d15 * (((d14 + 1.0d) * d15) + d14)) + 1.0d)) + d11;
    }
}
