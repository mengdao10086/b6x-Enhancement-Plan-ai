package nj;

/* JADX INFO: loaded from: classes5.dex */
public class b implements e {
    @Override // nj.e
    public double a(double d10, double d11, double d12, double d13) {
        return (d10 < d13 / 2.0d ? c(d10 * 2.0d, 0.0d, d12, d13) * 0.5d : (b((2.0d * d10) - d13, 0.0d, d12, d13) * 0.5d) + (d12 * 0.5d)) + d11;
    }

    @Override // nj.e
    public double b(double d10, double d11, double d12, double d13) {
        double d14;
        double d15;
        double d16;
        double d17 = d10 / d13;
        if (d17 < 0.36363636363636365d) {
            d16 = 7.5625d * d17 * d17;
        } else {
            if (d17 < 0.7272727272727273d) {
                double d18 = d17 - 0.5454545454545454d;
                d14 = 7.5625d * d18 * d18;
                d15 = 0.75d;
            } else if (d17 < 0.9090909090909091d) {
                double d19 = d17 - 0.8181818181818182d;
                d14 = 7.5625d * d19 * d19;
                d15 = 0.9375d;
            } else {
                double d20 = d17 - 0.9545454545454546d;
                d14 = 7.5625d * d20 * d20;
                d15 = 0.984375d;
            }
            d16 = d14 + d15;
        }
        return (d12 * d16) + d11;
    }

    @Override // nj.e
    public double c(double d10, double d11, double d12, double d13) {
        return (d12 - b(d13 - d10, 0.0d, d12, d13)) + d11;
    }
}
