package w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f53408a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f53409b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f53410c = 2;

    public static class a extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f53411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double[] f53412e;

        public a(double d10, double[] dArr) {
            this.f53411d = d10;
            this.f53412e = dArr;
        }

        @Override // w.b
        public double c(double d10, int i10) {
            return this.f53412e[i10];
        }

        @Override // w.b
        public void d(double d10, double[] dArr) {
            double[] dArr2 = this.f53412e;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // w.b
        public void e(double d10, float[] fArr) {
            int i10 = 0;
            while (true) {
                double[] dArr = this.f53412e;
                if (i10 >= dArr.length) {
                    return;
                }
                fArr[i10] = (float) dArr[i10];
                i10++;
            }
        }

        @Override // w.b
        public double f(double d10, int i10) {
            return 0.0d;
        }

        @Override // w.b
        public void g(double d10, double[] dArr) {
            for (int i10 = 0; i10 < this.f53412e.length; i10++) {
                dArr[i10] = 0.0d;
            }
        }

        @Override // w.b
        public double[] h() {
            return new double[]{this.f53411d};
        }
    }

    public static b a(int i10, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i10 = 2;
        }
        return i10 != 0 ? i10 != 2 ? new j(dArr, dArr2) : new a(dArr[0], dArr2[0]) : new k(dArr, dArr2);
    }

    public static b b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new w.a(iArr, dArr, dArr2);
    }

    public abstract double c(double d10, int i10);

    public abstract void d(double d10, double[] dArr);

    public abstract void e(double d10, float[] fArr);

    public abstract double f(double d10, int i10);

    public abstract void g(double d10, double[] dArr);

    public abstract double[] h();
}
