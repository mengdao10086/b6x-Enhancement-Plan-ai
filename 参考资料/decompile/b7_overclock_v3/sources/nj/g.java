package nj;

/* JADX INFO: loaded from: classes5.dex */
public class g implements e {
    @Override // nj.e
    public double a(double d10, double d11, double d12, double d13) {
        double d14;
        double dPow;
        if (d10 == 0.0d) {
            return d11;
        }
        if (d10 == d13) {
            return d11 + d12;
        }
        double d15 = d10 / (d13 / 2.0d);
        if (d15 < 1.0d) {
            d14 = d12 / 2.0d;
            dPow = Math.pow(2.0d, (d15 - 1.0d) * 10.0d);
        } else {
            d14 = d12 / 2.0d;
            dPow = (-Math.pow(2.0d, (d15 - 1.0d) * (-10.0d))) + 2.0d;
        }
        return (d14 * dPow) + d11;
    }

    @Override // nj.e
    public double b(double d10, double d11, double d12, double d13) {
        return d10 == d13 ? d11 + d12 : d11 + (d12 * ((-Math.pow(2.0d, (d10 * (-10.0d)) / d13)) + 1.0d));
    }

    @Override // nj.e
    public double c(double d10, double d11, double d12, double d13) {
        return d10 == 0.0d ? d11 : d11 + (d12 * Math.pow(2.0d, ((d10 / d13) - 1.0d) * 10.0d));
    }
}
