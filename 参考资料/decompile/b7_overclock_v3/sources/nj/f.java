package nj;

/* JADX INFO: loaded from: classes5.dex */
public class f implements e {
    @Override // nj.e
    public double a(double d10, double d11, double d12, double d13) {
        return e(d10, d11, d12, d13, d11 + d12, d13);
    }

    @Override // nj.e
    public double b(double d10, double d11, double d12, double d13) {
        return f(d10, d11, d12, d13, d11 + d12, d13);
    }

    @Override // nj.e
    public double c(double d10, double d11, double d12, double d13) {
        return d(d10, d11, d12, d13, d11 + d12, d13);
    }

    public double d(double d10, double d11, double d12, double d13, double d14, double d15) {
        double dAsin;
        double d16;
        if (d10 == 0.0d) {
            return d11;
        }
        double d17 = d10 / d13;
        if (d17 == 1.0d) {
            return d11 + d12;
        }
        double d18 = d15 <= 0.0d ? 0.3d * d13 : d15;
        if (d14 <= 0.0d || d14 < Math.abs(d12)) {
            dAsin = d18 / 4.0d;
            d16 = d12;
        } else {
            dAsin = (d18 / 6.283185307179586d) * Math.asin(d12 / d14);
            d16 = d14;
        }
        double d19 = d17 - 1.0d;
        return (-(d16 * Math.pow(2.0d, 10.0d * d19) * Math.sin((((d19 * d13) - dAsin) * 6.283185307179586d) / d18))) + d11;
    }

    public double e(double d10, double d11, double d12, double d13, double d14, double d15) {
        double dAsin;
        double d16;
        double dPow;
        if (d10 == 0.0d) {
            return d11;
        }
        double d17 = d10 / (d13 / 2.0d);
        if (d17 == 2.0d) {
            return d11 + d12;
        }
        double d18 = d15 <= 0.0d ? 0.44999999999999996d * d13 : d15;
        if (d14 <= 0.0d || d14 < Math.abs(d12)) {
            dAsin = d18 / 4.0d;
            d16 = d12;
        } else {
            dAsin = (d18 / 6.283185307179586d) * Math.asin(d12 / d14);
            d16 = d14;
        }
        if (d17 < 1.0d) {
            double d19 = d17 - 1.0d;
            dPow = d16 * Math.pow(2.0d, d19 * 10.0d) * Math.sin((((d19 * d13) - dAsin) * 6.283185307179586d) / d18) * (-0.5d);
        } else {
            double d20 = d17 - 1.0d;
            dPow = (d16 * Math.pow(2.0d, (-10.0d) * d20) * Math.sin((((d20 * d13) - dAsin) * 6.283185307179586d) / d18) * 0.5d) + d12;
        }
        return dPow + d11;
    }

    public double f(double d10, double d11, double d12, double d13, double d14, double d15) {
        double dAsin;
        double d16;
        if (d10 == 0.0d) {
            return d11;
        }
        double d17 = d10 / d13;
        if (d17 == 1.0d) {
            return d11 + d12;
        }
        double d18 = d15 <= 0.0d ? 0.3d * d13 : d15;
        if (d14 <= 0.0d || d14 < Math.abs(d12)) {
            dAsin = d18 / 4.0d;
            d16 = d12;
        } else {
            dAsin = (d18 / 6.283185307179586d) * Math.asin(d12 / d14);
            d16 = d14;
        }
        return (d16 * Math.pow(2.0d, (-10.0d) * d17) * Math.sin((((d17 * d13) - dAsin) * 6.283185307179586d) / d18)) + d12 + d11;
    }
}
