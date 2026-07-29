package nj;

/* JADX INFO: loaded from: classes5.dex */
public class c implements e {
    @Override // nj.e
    public double a(double d10, double d11, double d12, double d13) {
        double d14;
        double dSqrt;
        double d15 = d10 / (d13 / 2.0d);
        if (d15 < 1.0d) {
            d14 = (-d12) / 2.0d;
            dSqrt = Math.sqrt(1.0d - (d15 * d15)) - 1.0d;
        } else {
            d14 = d12 / 2.0d;
            double d16 = d15 - 2.0d;
            dSqrt = Math.sqrt(1.0d - (d16 * d16)) + 1.0d;
        }
        return (d14 * dSqrt) + d11;
    }

    @Override // nj.e
    public double b(double d10, double d11, double d12, double d13) {
        double d14 = (d10 / d13) - 1.0d;
        return (d12 * Math.sqrt(1.0d - (d14 * d14))) + d11;
    }

    @Override // nj.e
    public double c(double d10, double d11, double d12, double d13) {
        double d14 = d10 / d13;
        return ((-d12) * (Math.sqrt(1.0d - (d14 * d14)) - 1.0d)) + d11;
    }
}
