package w;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class k extends b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f53516i = "MonotonicCurveFit";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double[] f53517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double[][] f53518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double[][] f53519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f53520g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double[] f53521h;

    public k(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f53521h = new double[length2];
        int i10 = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) double.class, i10, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) double.class, length, length2);
        for (int i11 = 0; i11 < length2; i11++) {
            int i12 = 0;
            while (i12 < i10) {
                int i13 = i12 + 1;
                dArr3[i12][i11] = (dArr2[i13][i11] - dArr2[i12][i11]) / (dArr[i13] - dArr[i12]);
                if (i12 == 0) {
                    dArr4[i12][i11] = dArr3[i12][i11];
                } else {
                    dArr4[i12][i11] = (dArr3[i12 - 1][i11] + dArr3[i12][i11]) * 0.5d;
                }
                i12 = i13;
            }
            dArr4[i10][i11] = dArr3[length - 2][i11];
        }
        for (int i14 = 0; i14 < i10; i14++) {
            for (int i15 = 0; i15 < length2; i15++) {
                if (dArr3[i14][i15] == 0.0d) {
                    dArr4[i14][i15] = 0.0d;
                    dArr4[i14 + 1][i15] = 0.0d;
                } else {
                    double d10 = dArr4[i14][i15] / dArr3[i14][i15];
                    int i16 = i14 + 1;
                    double d11 = dArr4[i16][i15] / dArr3[i14][i15];
                    double dHypot = Math.hypot(d10, d11);
                    if (dHypot > 9.0d) {
                        double d12 = 3.0d / dHypot;
                        dArr4[i14][i15] = d10 * d12 * dArr3[i14][i15];
                        dArr4[i16][i15] = d12 * d11 * dArr3[i14][i15];
                    }
                }
            }
        }
        this.f53517d = dArr;
        this.f53518e = dArr2;
        this.f53519f = dArr4;
    }

    public static k i(String str) {
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i10 = 0;
        while (iIndexOf2 != -1) {
            dArr[i10] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i10++;
        }
        dArr[i10] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        return j(Arrays.copyOf(dArr, i10 + 1));
    }

    public static k j(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d10 = 1.0d / ((double) length2);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, length, 1);
        double[] dArr3 = new double[length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            double d11 = dArr[i10];
            int i11 = i10 + length2;
            dArr2[i11][0] = d11;
            double d12 = ((double) i10) * d10;
            dArr3[i11] = d12;
            if (i10 > 0) {
                int i12 = (length2 * 2) + i10;
                dArr2[i12][0] = d11 + 1.0d;
                dArr3[i12] = d12 + 1.0d;
                int i13 = i10 - 1;
                dArr2[i13][0] = (d11 - 1.0d) - d10;
                dArr3[i13] = (d12 - 1.0d) - d10;
            }
        }
        return new k(dArr3, dArr2);
    }

    public static double k(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d11 * d11;
        double d17 = d11 * 6.0d;
        double d18 = 3.0d * d10;
        return ((((((((((-6.0d) * d16) * d13) + (d17 * d13)) + ((6.0d * d16) * d12)) - (d17 * d12)) + ((d18 * d15) * d16)) + ((d18 * d14) * d16)) - (((2.0d * d10) * d15) * d11)) - (((4.0d * d10) * d14) * d11)) + (d10 * d14);
    }

    public static double l(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d11 * d11;
        double d17 = d16 * d11;
        double d18 = 3.0d * d16;
        double d19 = ((((((-2.0d) * d17) * d13) + (d18 * d13)) + ((d17 * 2.0d) * d12)) - (d18 * d12)) + d12;
        double d20 = d10 * d15;
        double d21 = d10 * d14;
        return ((((d19 + (d20 * d17)) + (d17 * d21)) - (d20 * d16)) - (((d10 * 2.0d) * d14) * d16)) + (d21 * d11);
    }

    @Override // w.b
    public double c(double d10, int i10) {
        double[] dArr = this.f53517d;
        int length = dArr.length;
        int i11 = 0;
        if (this.f53520g) {
            if (d10 <= dArr[0]) {
                return this.f53518e[0][i10] + ((d10 - dArr[0]) * f(dArr[0], i10));
            }
            int i12 = length - 1;
            if (d10 >= dArr[i12]) {
                return this.f53518e[i12][i10] + ((d10 - dArr[i12]) * f(dArr[i12], i10));
            }
        } else {
            if (d10 <= dArr[0]) {
                return this.f53518e[0][i10];
            }
            int i13 = length - 1;
            if (d10 >= dArr[i13]) {
                return this.f53518e[i13][i10];
            }
        }
        while (i11 < length - 1) {
            double[] dArr2 = this.f53517d;
            if (d10 == dArr2[i11]) {
                return this.f53518e[i11][i10];
            }
            int i14 = i11 + 1;
            if (d10 < dArr2[i14]) {
                double d11 = dArr2[i14] - dArr2[i11];
                double d12 = (d10 - dArr2[i11]) / d11;
                double[][] dArr3 = this.f53518e;
                double d13 = dArr3[i11][i10];
                double d14 = dArr3[i14][i10];
                double[][] dArr4 = this.f53519f;
                return l(d11, d12, d13, d14, dArr4[i11][i10], dArr4[i14][i10]);
            }
            i11 = i14;
        }
        return 0.0d;
    }

    @Override // w.b
    public void d(double d10, double[] dArr) {
        double[] dArr2 = this.f53517d;
        int length = dArr2.length;
        int i10 = 0;
        int length2 = this.f53518e[0].length;
        if (this.f53520g) {
            if (d10 <= dArr2[0]) {
                g(dArr2[0], this.f53521h);
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.f53518e[0][i11] + ((d10 - this.f53517d[0]) * this.f53521h[i11]);
                }
                return;
            }
            int i12 = length - 1;
            if (d10 >= dArr2[i12]) {
                g(dArr2[i12], this.f53521h);
                while (i10 < length2) {
                    dArr[i10] = this.f53518e[i12][i10] + ((d10 - this.f53517d[i12]) * this.f53521h[i10]);
                    i10++;
                }
                return;
            }
        } else {
            if (d10 <= dArr2[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    dArr[i13] = this.f53518e[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d10 >= dArr2[i14]) {
                while (i10 < length2) {
                    dArr[i10] = this.f53518e[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d10 == this.f53517d[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    dArr[i16] = this.f53518e[i15][i16];
                }
            }
            double[] dArr3 = this.f53517d;
            int i17 = i15 + 1;
            if (d10 < dArr3[i17]) {
                double d11 = dArr3[i17] - dArr3[i15];
                double d12 = (d10 - dArr3[i15]) / d11;
                while (i10 < length2) {
                    double[][] dArr4 = this.f53518e;
                    double d13 = dArr4[i15][i10];
                    double d14 = dArr4[i17][i10];
                    double[][] dArr5 = this.f53519f;
                    dArr[i10] = l(d11, d12, d13, d14, dArr5[i15][i10], dArr5[i17][i10]);
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    @Override // w.b
    public void e(double d10, float[] fArr) {
        double[] dArr = this.f53517d;
        int length = dArr.length;
        int i10 = 0;
        int length2 = this.f53518e[0].length;
        if (this.f53520g) {
            if (d10 <= dArr[0]) {
                g(dArr[0], this.f53521h);
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) (this.f53518e[0][i11] + ((d10 - this.f53517d[0]) * this.f53521h[i11]));
                }
                return;
            }
            int i12 = length - 1;
            if (d10 >= dArr[i12]) {
                g(dArr[i12], this.f53521h);
                while (i10 < length2) {
                    fArr[i10] = (float) (this.f53518e[i12][i10] + ((d10 - this.f53517d[i12]) * this.f53521h[i10]));
                    i10++;
                }
                return;
            }
        } else {
            if (d10 <= dArr[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    fArr[i13] = (float) this.f53518e[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d10 >= dArr[i14]) {
                while (i10 < length2) {
                    fArr[i10] = (float) this.f53518e[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d10 == this.f53517d[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    fArr[i16] = (float) this.f53518e[i15][i16];
                }
            }
            double[] dArr2 = this.f53517d;
            int i17 = i15 + 1;
            if (d10 < dArr2[i17]) {
                double d11 = dArr2[i17] - dArr2[i15];
                double d12 = (d10 - dArr2[i15]) / d11;
                while (i10 < length2) {
                    double[][] dArr3 = this.f53518e;
                    double d13 = dArr3[i15][i10];
                    double d14 = dArr3[i17][i10];
                    double[][] dArr4 = this.f53519f;
                    fArr[i10] = (float) l(d11, d12, d13, d14, dArr4[i15][i10], dArr4[i17][i10]);
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    @Override // w.b
    public double f(double d10, int i10) {
        double d11;
        double[] dArr = this.f53517d;
        int length = dArr.length;
        int i11 = 0;
        if (d10 < dArr[0]) {
            d11 = dArr[0];
        } else {
            int i12 = length - 1;
            d11 = d10 >= dArr[i12] ? dArr[i12] : d10;
        }
        while (i11 < length - 1) {
            double[] dArr2 = this.f53517d;
            int i13 = i11 + 1;
            if (d11 <= dArr2[i13]) {
                double d12 = dArr2[i13] - dArr2[i11];
                double d13 = (d11 - dArr2[i11]) / d12;
                double[][] dArr3 = this.f53518e;
                double d14 = dArr3[i11][i10];
                double d15 = dArr3[i13][i10];
                double[][] dArr4 = this.f53519f;
                return k(d12, d13, d14, d15, dArr4[i11][i10], dArr4[i13][i10]) / d12;
            }
            i11 = i13;
        }
        return 0.0d;
    }

    @Override // w.b
    public void g(double d10, double[] dArr) {
        double d11;
        double[] dArr2 = this.f53517d;
        int length = dArr2.length;
        int length2 = this.f53518e[0].length;
        if (d10 <= dArr2[0]) {
            d11 = dArr2[0];
        } else {
            int i10 = length - 1;
            d11 = d10 >= dArr2[i10] ? dArr2[i10] : d10;
        }
        int i11 = 0;
        while (i11 < length - 1) {
            double[] dArr3 = this.f53517d;
            int i12 = i11 + 1;
            if (d11 <= dArr3[i12]) {
                double d12 = dArr3[i12] - dArr3[i11];
                double d13 = (d11 - dArr3[i11]) / d12;
                for (int i13 = 0; i13 < length2; i13++) {
                    double[][] dArr4 = this.f53518e;
                    double d14 = dArr4[i11][i13];
                    double d15 = dArr4[i12][i13];
                    double[][] dArr5 = this.f53519f;
                    dArr[i13] = k(d12, d13, d14, d15, dArr5[i11][i13], dArr5[i12][i13]) / d12;
                }
                return;
            }
            i11 = i12;
        }
    }

    @Override // w.b
    public double[] h() {
        return this.f53517d;
    }
}
