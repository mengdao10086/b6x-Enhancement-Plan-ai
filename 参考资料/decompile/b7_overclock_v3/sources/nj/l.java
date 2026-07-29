package nj;

/* JADX INFO: loaded from: classes5.dex */
public class l implements e {
    @Override // nj.e
    public double a(double d10, double d11, double d12, double d13) {
        return (((-d12) / 2.0d) * (Math.cos((d10 * 3.141592653589793d) / d13) - 1.0d)) + d11;
    }

    @Override // nj.e
    public double b(double d10, double d11, double d12, double d13) {
        return (d12 * Math.sin((d10 / d13) * 1.5707963267948966d)) + d11;
    }

    @Override // nj.e
    public double c(double d10, double d11, double d12, double d13) {
        return ((-d12) * Math.cos((d10 / d13) * 1.5707963267948966d)) + d12 + d11;
    }
}
