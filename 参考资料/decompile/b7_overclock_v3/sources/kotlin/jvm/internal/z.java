package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class z extends m0<float[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final float[] f37982d;

    public z(int i10) {
        super(i10);
        this.f37982d = new float[i10];
    }

    public final void h(float f10) {
        float[] fArr = this.f37982d;
        int iB = b();
        e(iB + 1);
        fArr[iB] = f10;
    }

    @Override // kotlin.jvm.internal.m0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@yt.k float[] fArr) {
        f0.p(fArr, "<this>");
        return fArr.length;
    }

    @yt.k
    public final float[] j() {
        return g(this.f37982d, new float[f()]);
    }
}
