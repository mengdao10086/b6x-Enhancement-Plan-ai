package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class m extends m0<boolean[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final boolean[] f37914d;

    public m(int i10) {
        super(i10);
        this.f37914d = new boolean[i10];
    }

    public final void h(boolean z10) {
        boolean[] zArr = this.f37914d;
        int iB = b();
        e(iB + 1);
        zArr[iB] = z10;
    }

    @Override // kotlin.jvm.internal.m0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@yt.k boolean[] zArr) {
        f0.p(zArr, "<this>");
        return zArr.length;
    }

    @yt.k
    public final boolean[] j() {
        return g(this.f37914d, new boolean[f()]);
    }
}
