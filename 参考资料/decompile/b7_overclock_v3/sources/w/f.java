package w;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a[][] f53440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double[] f53442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f53443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double[][] f53444f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f53445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f53446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f53447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f53448d;

        public a(double d10, double d11, double d12, double d13) {
            this.f53445a = d10;
            this.f53446b = d11;
            this.f53447c = d12;
            this.f53448d = d13;
        }

        public double a(double d10) {
            return (((((this.f53448d * d10) + this.f53447c) * d10) + this.f53446b) * d10) + this.f53445a;
        }

        public double b(double d10) {
            return (((this.f53448d * 3.0d * d10) + (this.f53447c * 2.0d)) * d10) + this.f53446b;
        }
    }

    public f(double[][] dArr) {
        g(dArr);
    }

    public static a[] b(int i10, double[] dArr) {
        double[] dArr2 = new double[i10];
        double[] dArr3 = new double[i10];
        double[] dArr4 = new double[i10];
        int i11 = i10 - 1;
        int i12 = 0;
        dArr2[0] = 0.5d;
        int i13 = 1;
        for (int i14 = 1; i14 < i11; i14++) {
            dArr2[i14] = 1.0d / (4.0d - dArr2[i14 - 1]);
        }
        int i15 = i11 - 1;
        dArr2[i11] = 1.0d / (2.0d - dArr2[i15]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i13 < i11) {
            int i16 = i13 + 1;
            int i17 = i13 - 1;
            dArr3[i13] = (((dArr[i16] - dArr[i17]) * 3.0d) - dArr3[i17]) * dArr2[i13];
            i13 = i16;
        }
        dArr3[i11] = (((dArr[i11] - dArr[i15]) * 3.0d) - dArr3[i15]) * dArr2[i11];
        dArr4[i11] = dArr3[i11];
        while (i15 >= 0) {
            dArr4[i15] = dArr3[i15] - (dArr2[i15] * dArr4[i15 + 1]);
            i15--;
        }
        a[] aVarArr = new a[i11];
        while (i12 < i11) {
            int i18 = i12 + 1;
            aVarArr[i12] = new a((float) dArr[i12], dArr4[i12], (((dArr[i18] - dArr[i12]) * 3.0d) - (dArr4[i12] * 2.0d)) - dArr4[i18], ((dArr[i12] - dArr[i18]) * 2.0d) + dArr4[i12] + dArr4[i18]);
            i12 = i18;
        }
        return aVarArr;
    }

    public double a(a[] aVarArr) {
        int i10;
        int length = aVarArr.length;
        double[] dArr = new double[aVarArr.length];
        double d10 = 0.0d;
        double d11 = 0.0d;
        double dSqrt = 0.0d;
        while (true) {
            i10 = 0;
            if (d11 >= 1.0d) {
                break;
            }
            double d12 = 0.0d;
            while (i10 < aVarArr.length) {
                double d13 = dArr[i10];
                double dA = aVarArr[i10].a(d11);
                dArr[i10] = dA;
                double d14 = d13 - dA;
                d12 += d14 * d14;
                i10++;
            }
            if (d11 > 0.0d) {
                dSqrt += Math.sqrt(d12);
            }
            d11 += 0.1d;
        }
        while (i10 < aVarArr.length) {
            double d15 = dArr[i10];
            double dA2 = aVarArr[i10].a(1.0d);
            dArr[i10] = dA2;
            double d16 = d15 - dA2;
            d10 += d16 * d16;
            i10++;
        }
        return dSqrt + Math.sqrt(d10);
    }

    public double c(double d10, int i10) {
        double[] dArr;
        double d11 = d10 * this.f53443e;
        int i11 = 0;
        while (true) {
            dArr = this.f53442d;
            if (i11 >= dArr.length - 1 || dArr[i11] >= d11) {
                break;
            }
            d11 -= dArr[i11];
            i11++;
        }
        return this.f53440b[i10][i11].a(d11 / dArr[i11]);
    }

    public void d(double d10, double[] dArr) {
        double d11 = d10 * this.f53443e;
        int i10 = 0;
        while (true) {
            double[] dArr2 = this.f53442d;
            if (i10 >= dArr2.length - 1 || dArr2[i10] >= d11) {
                break;
            }
            d11 -= dArr2[i10];
            i10++;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr[i11] = this.f53440b[i11][i10].a(d11 / this.f53442d[i10]);
        }
    }

    public void e(double d10, float[] fArr) {
        double d11 = d10 * this.f53443e;
        int i10 = 0;
        while (true) {
            double[] dArr = this.f53442d;
            if (i10 >= dArr.length - 1 || dArr[i10] >= d11) {
                break;
            }
            d11 -= dArr[i10];
            i10++;
        }
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr[i11] = (float) this.f53440b[i11][i10].a(d11 / this.f53442d[i10]);
        }
    }

    public void f(double d10, double[] dArr) {
        double d11 = d10 * this.f53443e;
        int i10 = 0;
        while (true) {
            double[] dArr2 = this.f53442d;
            if (i10 >= dArr2.length - 1 || dArr2[i10] >= d11) {
                break;
            }
            d11 -= dArr2[i10];
            i10++;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr[i11] = this.f53440b[i11][i10].b(d11 / this.f53442d[i10]);
        }
    }

    public void g(double[][] dArr) {
        int i10;
        int length = dArr[0].length;
        this.f53441c = length;
        int length2 = dArr.length;
        this.f53439a = length2;
        this.f53444f = (double[][]) Array.newInstance((Class<?>) double.class, length, length2);
        this.f53440b = new a[this.f53441c][];
        for (int i11 = 0; i11 < this.f53441c; i11++) {
            for (int i12 = 0; i12 < this.f53439a; i12++) {
                this.f53444f[i11][i12] = dArr[i12][i11];
            }
        }
        int i13 = 0;
        while (true) {
            i10 = this.f53441c;
            if (i13 >= i10) {
                break;
            }
            a[][] aVarArr = this.f53440b;
            double[][] dArr2 = this.f53444f;
            aVarArr[i13] = b(dArr2[i13].length, dArr2[i13]);
            i13++;
        }
        this.f53442d = new double[this.f53439a - 1];
        this.f53443e = 0.0d;
        a[] aVarArr2 = new a[i10];
        for (int i14 = 0; i14 < this.f53442d.length; i14++) {
            for (int i15 = 0; i15 < this.f53441c; i15++) {
                aVarArr2[i15] = this.f53440b[i15][i14];
            }
            double d10 = this.f53443e;
            double[] dArr3 = this.f53442d;
            double dA = a(aVarArr2);
            dArr3[i14] = dA;
            this.f53443e = d10 + dA;
        }
    }

    public f() {
    }
}
