package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class e0 extends m0<int[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final int[] f37896d;

    public e0(int i10) {
        super(i10);
        this.f37896d = new int[i10];
    }

    public final void h(int i10) {
        int[] iArr = this.f37896d;
        int iB = b();
        e(iB + 1);
        iArr[iB] = i10;
    }

    @Override // kotlin.jvm.internal.m0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@yt.k int[] iArr) {
        f0.p(iArr, "<this>");
        return iArr.length;
    }

    @yt.k
    public final int[] j() {
        return g(this.f37896d, new int[f()]);
    }
}
