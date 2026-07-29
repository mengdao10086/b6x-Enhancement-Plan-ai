package w;

/* JADX INFO: loaded from: classes2.dex */
public class j extends b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f53510i = "LinearCurveFit";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double[] f53511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double[][] f53512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f53513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f53514g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double[] f53515h;

    public j(double[] dArr, double[][] dArr2) {
        this.f53513f = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f53515h = new double[length2];
        this.f53511d = dArr;
        this.f53512e = dArr2;
        if (length2 > 2) {
            double d10 = 0.0d;
            double d11 = 0.0d;
            int i10 = 0;
            while (i10 < dArr.length) {
                double d12 = dArr2[i10][0];
                double d13 = dArr2[i10][0];
                if (i10 > 0) {
                    Math.hypot(d12 - d10, d13 - d11);
                }
                i10++;
                d10 = d12;
                d11 = d13;
            }
            this.f53513f = 0.0d;
        }
    }

    @Override // w.b
    public double c(double d10, int i10) {
        double[] dArr = this.f53511d;
        int length = dArr.length;
        int i11 = 0;
        if (this.f53514g) {
            if (d10 <= dArr[0]) {
                return this.f53512e[0][i10] + ((d10 - dArr[0]) * f(dArr[0], i10));
            }
            int i12 = length - 1;
            if (d10 >= dArr[i12]) {
                return this.f53512e[i12][i10] + ((d10 - dArr[i12]) * f(dArr[i12], i10));
            }
        } else {
            if (d10 <= dArr[0]) {
                return this.f53512e[0][i10];
            }
            int i13 = length - 1;
            if (d10 >= dArr[i13]) {
                return this.f53512e[i13][i10];
            }
        }
        while (i11 < length - 1) {
            double[] dArr2 = this.f53511d;
            if (d10 == dArr2[i11]) {
                return this.f53512e[i11][i10];
            }
            int i14 = i11 + 1;
            if (d10 < dArr2[i14]) {
                double d11 = (d10 - dArr2[i11]) / (dArr2[i14] - dArr2[i11]);
                double[][] dArr3 = this.f53512e;
                return (dArr3[i11][i10] * (1.0d - d11)) + (dArr3[i14][i10] * d11);
            }
            i11 = i14;
        }
        return 0.0d;
    }

    @Override // w.b
    public void d(double d10, double[] dArr) {
        double[] dArr2 = this.f53511d;
        int length = dArr2.length;
        int i10 = 0;
        int length2 = this.f53512e[0].length;
        if (this.f53514g) {
            if (d10 <= dArr2[0]) {
                g(dArr2[0], this.f53515h);
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.f53512e[0][i11] + ((d10 - this.f53511d[0]) * this.f53515h[i11]);
                }
                return;
            }
            int i12 = length - 1;
            if (d10 >= dArr2[i12]) {
                g(dArr2[i12], this.f53515h);
                while (i10 < length2) {
                    dArr[i10] = this.f53512e[i12][i10] + ((d10 - this.f53511d[i12]) * this.f53515h[i10]);
                    i10++;
                }
                return;
            }
        } else {
            if (d10 <= dArr2[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    dArr[i13] = this.f53512e[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d10 >= dArr2[i14]) {
                while (i10 < length2) {
                    dArr[i10] = this.f53512e[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d10 == this.f53511d[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    dArr[i16] = this.f53512e[i15][i16];
                }
            }
            double[] dArr3 = this.f53511d;
            int i17 = i15 + 1;
            if (d10 < dArr3[i17]) {
                double d11 = (d10 - dArr3[i15]) / (dArr3[i17] - dArr3[i15]);
                while (i10 < length2) {
                    double[][] dArr4 = this.f53512e;
                    dArr[i10] = (dArr4[i15][i10] * (1.0d - d11)) + (dArr4[i17][i10] * d11);
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    @Override // w.b
    public void e(double d10, float[] fArr) {
        double[] dArr = this.f53511d;
        int length = dArr.length;
        int i10 = 0;
        int length2 = this.f53512e[0].length;
        if (this.f53514g) {
            if (d10 <= dArr[0]) {
                g(dArr[0], this.f53515h);
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) (this.f53512e[0][i11] + ((d10 - this.f53511d[0]) * this.f53515h[i11]));
                }
                return;
            }
            int i12 = length - 1;
            if (d10 >= dArr[i12]) {
                g(dArr[i12], this.f53515h);
                while (i10 < length2) {
                    fArr[i10] = (float) (this.f53512e[i12][i10] + ((d10 - this.f53511d[i12]) * this.f53515h[i10]));
                    i10++;
                }
                return;
            }
        } else {
            if (d10 <= dArr[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    fArr[i13] = (float) this.f53512e[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d10 >= dArr[i14]) {
                while (i10 < length2) {
                    fArr[i10] = (float) this.f53512e[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d10 == this.f53511d[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    fArr[i16] = (float) this.f53512e[i15][i16];
                }
            }
            double[] dArr2 = this.f53511d;
            int i17 = i15 + 1;
            if (d10 < dArr2[i17]) {
                double d11 = (d10 - dArr2[i15]) / (dArr2[i17] - dArr2[i15]);
                while (i10 < length2) {
                    double[][] dArr3 = this.f53512e;
                    fArr[i10] = (float) ((dArr3[i15][i10] * (1.0d - d11)) + (dArr3[i17][i10] * d11));
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    @Override // w.b
    public double f(double d10, int i10) {
        double[] dArr = this.f53511d;
        int length = dArr.length;
        int i11 = 0;
        if (d10 < dArr[0]) {
            d10 = dArr[0];
        } else {
            int i12 = length - 1;
            if (d10 >= dArr[i12]) {
                d10 = dArr[i12];
            }
        }
        while (i11 < length - 1) {
            double[] dArr2 = this.f53511d;
            int i13 = i11 + 1;
            if (d10 <= dArr2[i13]) {
                double d11 = dArr2[i13] - dArr2[i11];
                double d12 = dArr2[i11];
                double[][] dArr3 = this.f53512e;
                return (dArr3[i13][i10] - dArr3[i11][i10]) / d11;
            }
            i11 = i13;
        }
        return 0.0d;
    }

    @Override // w.b
    public void g(double d10, double[] dArr) {
        double[] dArr2 = this.f53511d;
        int length = dArr2.length;
        int length2 = this.f53512e[0].length;
        if (d10 <= dArr2[0]) {
            d10 = dArr2[0];
        } else {
            int i10 = length - 1;
            if (d10 >= dArr2[i10]) {
                d10 = dArr2[i10];
            }
        }
        int i11 = 0;
        while (i11 < length - 1) {
            double[] dArr3 = this.f53511d;
            int i12 = i11 + 1;
            if (d10 <= dArr3[i12]) {
                double d11 = dArr3[i12] - dArr3[i11];
                double d12 = dArr3[i11];
                for (int i13 = 0; i13 < length2; i13++) {
                    double[][] dArr4 = this.f53512e;
                    dArr[i13] = (dArr4[i12][i13] - dArr4[i11][i13]) / d11;
                }
                return;
            }
            i11 = i12;
        }
    }

    @Override // w.b
    public double[] h() {
        return this.f53511d;
    }

    public final double i(double d10) {
        if (Double.isNaN(this.f53513f)) {
            return 0.0d;
        }
        double[] dArr = this.f53511d;
        int length = dArr.length;
        if (d10 <= dArr[0]) {
            return 0.0d;
        }
        int i10 = length - 1;
        if (d10 >= dArr[i10]) {
            return this.f53513f;
        }
        double dHypot = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        int i11 = 0;
        while (i11 < i10) {
            double[][] dArr2 = this.f53512e;
            double d13 = dArr2[i11][0];
            double d14 = dArr2[i11][1];
            if (i11 > 0) {
                dHypot += Math.hypot(d13 - d11, d14 - d12);
            }
            double[] dArr3 = this.f53511d;
            if (d10 == dArr3[i11]) {
                return dHypot;
            }
            int i12 = i11 + 1;
            if (d10 < dArr3[i12]) {
                double d15 = (d10 - dArr3[i11]) / (dArr3[i12] - dArr3[i11]);
                double[][] dArr4 = this.f53512e;
                double d16 = 1.0d - d15;
                return dHypot + Math.hypot(d14 - ((dArr4[i11][1] * d16) + (dArr4[i12][1] * d15)), d13 - ((dArr4[i11][0] * d16) + (dArr4[i12][0] * d15)));
            }
            i11 = i12;
            d11 = d13;
            d12 = d14;
        }
        return 0.0d;
    }
}
