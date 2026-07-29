package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class w extends m0<double[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final double[] f37965d;

    public w(int i10) {
        super(i10);
        this.f37965d = new double[i10];
    }

    public final void h(double d10) {
        double[] dArr = this.f37965d;
        int iB = b();
        e(iB + 1);
        dArr[iB] = d10;
    }

    @Override // kotlin.jvm.internal.m0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@yt.k double[] dArr) {
        f0.p(dArr, "<this>");
        return dArr.length;
    }

    @yt.k
    public final double[] j() {
        return g(this.f37965d, new double[f()]);
    }
}
